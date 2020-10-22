package com.facebook.react.devsupport;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.p005os.EnvironmentCompat;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.devsupport.MultipartStreamReader;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.C3873Response;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import org.json.JSONException;
import org.json.JSONObject;

public class BundleDownloader {
    private static final int FILES_CHANGED_COUNT_NOT_BUILT_BY_BUNDLER = -2;
    private static final String TAG = "BundleDownloader";
    private final OkHttpClient mClient;
    /* access modifiers changed from: private */
    @Nullable
    public Call mDownloadBundleFromURLCall;

    private String formatBundleUrl(String str) {
        return str;
    }

    public static class BundleInfo {
        /* access modifiers changed from: private */
        public int mFilesChangedCount;
        /* access modifiers changed from: private */
        @Nullable
        public String mUrl;

        @Nullable
        public static BundleInfo fromJSONString(String str) {
            if (str == null) {
                return null;
            }
            BundleInfo bundleInfo = new BundleInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                bundleInfo.mUrl = jSONObject.getString(ImagesContract.URL);
                bundleInfo.mFilesChangedCount = jSONObject.getInt("filesChangedCount");
                return bundleInfo;
            } catch (JSONException e) {
                Log.e(BundleDownloader.TAG, "Invalid bundle info: ", e);
                return null;
            }
        }

        @Nullable
        public String toJSONString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ImagesContract.URL, this.mUrl);
                jSONObject.put("filesChangedCount", this.mFilesChangedCount);
                return jSONObject.toString();
            } catch (JSONException e) {
                Log.e(BundleDownloader.TAG, "Can't serialize bundle info: ", e);
                return null;
            }
        }

        public String getUrl() {
            return this.mUrl != null ? this.mUrl : EnvironmentCompat.MEDIA_UNKNOWN;
        }

        public int getFilesChangedCount() {
            return this.mFilesChangedCount;
        }
    }

    public BundleDownloader(OkHttpClient okHttpClient) {
        this.mClient = okHttpClient;
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, @Nullable BundleInfo bundleInfo) {
        downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo, new Request.Builder());
    }

    public void downloadBundleFromURL(final DevBundleDownloadListener devBundleDownloadListener, final File file, String str, @Nullable final BundleInfo bundleInfo, Request.Builder builder) {
        this.mDownloadBundleFromURLCall = (Call) Assertions.assertNotNull(this.mClient.newCall(builder.url(formatBundleUrl(str)).addHeader("Accept", "multipart/mixed").build()));
        this.mDownloadBundleFromURLCall.enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                if (BundleDownloader.this.mDownloadBundleFromURLCall == null || BundleDownloader.this.mDownloadBundleFromURLCall.isCanceled()) {
                    Call unused = BundleDownloader.this.mDownloadBundleFromURLCall = null;
                    return;
                }
                Call unused2 = BundleDownloader.this.mDownloadBundleFromURLCall = null;
                String httpUrl = call.request().url().toString();
                DevBundleDownloadListener devBundleDownloadListener = devBundleDownloadListener;
                devBundleDownloadListener.onFailure(DebugServerException.makeGeneric(httpUrl, "Could not connect to development server.", "URL: " + httpUrl, iOException));
            }

            public void onResponse(Call call, C3873Response response) throws IOException {
                Throwable th;
                if (BundleDownloader.this.mDownloadBundleFromURLCall == null || BundleDownloader.this.mDownloadBundleFromURLCall.isCanceled()) {
                    Call unused = BundleDownloader.this.mDownloadBundleFromURLCall = null;
                    return;
                }
                Call unused2 = BundleDownloader.this.mDownloadBundleFromURLCall = null;
                String httpUrl = response.request().url().toString();
                Matcher matcher = Pattern.compile("multipart/mixed;.*boundary=\"([^\"]+)\"").matcher(response.header("content-type"));
                try {
                    if (matcher.find()) {
                        BundleDownloader.this.processMultipartResponse(httpUrl, response, matcher.group(1), file, bundleInfo, devBundleDownloadListener);
                    } else {
                        BundleDownloader.this.processBundleResult(httpUrl, response.code(), response.headers(), Okio.buffer((Source) response.body().source()), file, bundleInfo, devBundleDownloadListener);
                    }
                    if (response != null) {
                        response.close();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        });
    }

    /* access modifiers changed from: private */
    public void processMultipartResponse(String str, C3873Response response, String str2, File file, @Nullable BundleInfo bundleInfo, DevBundleDownloadListener devBundleDownloadListener) throws IOException {
        final C3873Response response2 = response;
        final String str3 = str;
        final File file2 = file;
        final BundleInfo bundleInfo2 = bundleInfo;
        final DevBundleDownloadListener devBundleDownloadListener2 = devBundleDownloadListener;
        if (!new MultipartStreamReader(response.body().source(), str2).readAllParts(new MultipartStreamReader.ChunkListener() {
            public void onChunkComplete(Map<String, String> map, Buffer buffer, boolean z) throws IOException {
                if (z) {
                    int code = response2.code();
                    if (map.containsKey("X-Http-Status")) {
                        code = Integer.parseInt(map.get("X-Http-Status"));
                    }
                    BundleDownloader.this.processBundleResult(str3, code, Headers.m2488of(map), buffer, file2, bundleInfo2, devBundleDownloadListener2);
                } else if (map.containsKey("Content-Type") && map.get("Content-Type").equals("application/json")) {
                    try {
                        JSONObject jSONObject = new JSONObject(buffer.readUtf8());
                        Integer num = null;
                        String string = jSONObject.has("status") ? jSONObject.getString("status") : null;
                        Integer valueOf = jSONObject.has("done") ? Integer.valueOf(jSONObject.getInt("done")) : null;
                        if (jSONObject.has("total")) {
                            num = Integer.valueOf(jSONObject.getInt("total"));
                        }
                        devBundleDownloadListener2.onProgress(string, valueOf, num);
                    } catch (JSONException e) {
                        FLog.m62e(ReactConstants.TAG, "Error parsing progress JSON. " + e.toString());
                    }
                }
            }

            public void onChunkProgress(Map<String, String> map, long j, long j2) throws IOException {
                if ("application/javascript".equals(map.get("Content-Type"))) {
                    devBundleDownloadListener2.onProgress("Downloading JavaScript bundle", Integer.valueOf((int) (j / 1024)), Integer.valueOf((int) (j2 / 1024)));
                }
            }
        })) {
            devBundleDownloadListener.onFailure(new DebugServerException("Error while reading multipart response.\n\nResponse code: " + response.code() + "\n\nURL: " + str.toString() + "\n\n"));
        }
    }

    /* access modifiers changed from: private */
    public void processBundleResult(String str, int i, Headers headers, BufferedSource bufferedSource, File file, BundleInfo bundleInfo, DevBundleDownloadListener devBundleDownloadListener) throws IOException {
        if (i != 200) {
            String readUtf8 = bufferedSource.readUtf8();
            DebugServerException parse = DebugServerException.parse(str, readUtf8);
            if (parse != null) {
                devBundleDownloadListener.onFailure(parse);
                return;
            }
            devBundleDownloadListener.onFailure(new DebugServerException("The development server returned response error code: " + i + "\n\n" + "URL: " + str + "\n\n" + "Body:\n" + readUtf8));
            return;
        }
        if (bundleInfo != null) {
            populateBundleInfo(str, headers, bundleInfo);
        }
        File file2 = new File(file.getPath() + DefaultDiskStorage.FileType.TEMP);
        if (!storePlainJSInFile(bufferedSource, file2) || file2.renameTo(file)) {
            devBundleDownloadListener.onSuccess();
            return;
        }
        throw new IOException("Couldn't rename " + file2 + " to " + file);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean storePlainJSInFile(okio.BufferedSource r0, java.io.File r1) throws java.io.IOException {
        /*
            okio.Sink r1 = okio.Okio.sink((java.io.File) r1)     // Catch:{ all -> 0x0010 }
            r0.readAll(r1)     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x000c
            r1.close()
        L_0x000c:
            r0 = 1
            return r0
        L_0x000e:
            r0 = move-exception
            goto L_0x0012
        L_0x0010:
            r0 = move-exception
            r1 = 0
        L_0x0012:
            if (r1 == 0) goto L_0x0017
            r1.close()
        L_0x0017:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.BundleDownloader.storePlainJSInFile(okio.BufferedSource, java.io.File):boolean");
    }

    private static void populateBundleInfo(String str, Headers headers, BundleInfo bundleInfo) {
        String unused = bundleInfo.mUrl = str;
        String str2 = headers.get("X-Metro-Files-Changed-Count");
        if (str2 != null) {
            try {
                int unused2 = bundleInfo.mFilesChangedCount = Integer.parseInt(str2);
            } catch (NumberFormatException unused3) {
                int unused4 = bundleInfo.mFilesChangedCount = -2;
            }
        }
    }
}
