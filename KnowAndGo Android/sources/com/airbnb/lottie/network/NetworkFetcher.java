package com.airbnb.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

public class NetworkFetcher {
    private final Context appContext;
    @Nullable
    private final NetworkCache networkCache;
    private final String url;

    public static LottieResult<LottieComposition> fetchSync(Context context, String str, @Nullable String str2) {
        return new NetworkFetcher(context, str, str2).fetchSync();
    }

    private NetworkFetcher(Context context, String str, @Nullable String str2) {
        this.appContext = context.getApplicationContext();
        this.url = str;
        if (str2 == null) {
            this.networkCache = null;
        } else {
            this.networkCache = new NetworkCache(this.appContext);
        }
    }

    @WorkerThread
    public LottieResult<LottieComposition> fetchSync() {
        LottieComposition fetchFromCache = fetchFromCache();
        if (fetchFromCache != null) {
            return new LottieResult<>(fetchFromCache);
        }
        Logger.debug("Animation for " + this.url + " not found in cache. Fetching from network.");
        return fetchFromNetwork();
    }

    @WorkerThread
    @Nullable
    private LottieComposition fetchFromCache() {
        Pair<FileExtension, InputStream> fetch;
        LottieResult<LottieComposition> lottieResult;
        if (this.networkCache == null || (fetch = this.networkCache.fetch(this.url)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) fetch.first;
        InputStream inputStream = (InputStream) fetch.second;
        if (fileExtension == FileExtension.ZIP) {
            lottieResult = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), this.url);
        } else {
            lottieResult = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, this.url);
        }
        if (lottieResult.getValue() != null) {
            return lottieResult.getValue();
        }
        return null;
    }

    @WorkerThread
    private LottieResult<LottieComposition> fetchFromNetwork() {
        try {
            return fetchFromNetworkInternal();
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    @WorkerThread
    private LottieResult<LottieComposition> fetchFromNetworkInternal() throws IOException {
        Logger.debug("Fetching " + this.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
        httpURLConnection.setRequestMethod("GET");
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null) {
                if (httpURLConnection.getResponseCode() == 200) {
                    LottieResult<LottieComposition> resultFromConnection = getResultFromConnection(httpURLConnection);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Completed fetch from network. Success: ");
                    sb.append(resultFromConnection.getValue() != null);
                    Logger.debug(sb.toString());
                    httpURLConnection.disconnect();
                    return resultFromConnection;
                }
            }
            String errorFromConnection = getErrorFromConnection(httpURLConnection);
            return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to fetch " + this.url + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + errorFromConnection));
        } catch (Exception e) {
            return new LottieResult<>((Throwable) e);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    private String getErrorFromConnection(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append(10);
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e) {
                throw e;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    @Nullable
    private LottieResult<LottieComposition> getResultFromConnection(HttpURLConnection httpURLConnection) throws IOException {
        LottieResult<LottieComposition> lottieResult;
        FileExtension fileExtension;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = "application/json";
        }
        if (contentType.contains("application/zip")) {
            Logger.debug("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            if (this.networkCache == null) {
                lottieResult = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(httpURLConnection.getInputStream()), (String) null);
            } else {
                lottieResult = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(this.networkCache.writeTempCacheFile(this.url, httpURLConnection.getInputStream(), fileExtension))), this.url);
            }
        } else {
            Logger.debug("Received json response.");
            fileExtension = FileExtension.JSON;
            if (this.networkCache == null) {
                lottieResult = LottieCompositionFactory.fromJsonInputStreamSync(httpURLConnection.getInputStream(), (String) null);
            } else {
                lottieResult = LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(new File(this.networkCache.writeTempCacheFile(this.url, httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.url);
            }
        }
        if (!(this.networkCache == null || lottieResult.getValue() == null)) {
            this.networkCache.renameTempFile(this.url, fileExtension);
        }
        return lottieResult;
    }
}
