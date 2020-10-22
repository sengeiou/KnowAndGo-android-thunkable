package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<HttpUrlConnectionNetworkFetchState> {
    private static final String FETCH_TIME = "fetch_time";
    public static final int HTTP_DEFAULT_TIMEOUT = 30000;
    public static final int HTTP_PERMANENT_REDIRECT = 308;
    public static final int HTTP_TEMPORARY_REDIRECT = 307;
    private static final String IMAGE_SIZE = "image_size";
    private static final int MAX_REDIRECTS = 5;
    private static final int NUM_NETWORK_THREADS = 3;
    private static final String QUEUE_TIME = "queue_time";
    private static final String TOTAL_TIME = "total_time";
    private final ExecutorService mExecutorService;
    private int mHttpConnectionTimeout;
    private final MonotonicClock mMonotonicClock;
    @Nullable
    private String mUserAgent;

    private static boolean isHttpRedirect(int i) {
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
            case 307:
            case 308:
                return true;
            default:
                return false;
        }
    }

    private static boolean isHttpSuccess(int i) {
        return i >= 200 && i < 300;
    }

    public static class HttpUrlConnectionNetworkFetchState extends FetchState {
        /* access modifiers changed from: private */
        public long fetchCompleteTime;
        /* access modifiers changed from: private */
        public long responseTime;
        /* access modifiers changed from: private */
        public long submitTime;

        public HttpUrlConnectionNetworkFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer, producerContext);
        }
    }

    public HttpUrlConnectionNetworkFetcher() {
        this((String) null, (MonotonicClock) RealtimeSinceBootClock.get());
    }

    public HttpUrlConnectionNetworkFetcher(int i) {
        this((String) null, (MonotonicClock) RealtimeSinceBootClock.get());
        this.mHttpConnectionTimeout = i;
    }

    public HttpUrlConnectionNetworkFetcher(String str, int i) {
        this(str, (MonotonicClock) RealtimeSinceBootClock.get());
        this.mHttpConnectionTimeout = i;
    }

    @VisibleForTesting
    HttpUrlConnectionNetworkFetcher(@Nullable String str, MonotonicClock monotonicClock) {
        this.mExecutorService = Executors.newFixedThreadPool(3);
        this.mMonotonicClock = monotonicClock;
        this.mUserAgent = str;
    }

    public HttpUrlConnectionNetworkFetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new HttpUrlConnectionNetworkFetchState(consumer, producerContext);
    }

    public void fetch(final HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, final NetworkFetcher.Callback callback) {
        long unused = httpUrlConnectionNetworkFetchState.submitTime = this.mMonotonicClock.now();
        final Future<?> submit = this.mExecutorService.submit(new Runnable() {
            public void run() {
                HttpUrlConnectionNetworkFetcher.this.fetchSync(httpUrlConnectionNetworkFetchState, callback);
            }
        });
        httpUrlConnectionNetworkFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() {
            public void onCancellationRequested() {
                if (submit.cancel(false)) {
                    callback.onCancellation();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003d A[SYNTHETIC, Splitter:B:28:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004b A[SYNTHETIC, Splitter:B:35:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    @com.facebook.common.internal.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fetchSync(com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.HttpUrlConnectionNetworkFetchState r6, com.facebook.imagepipeline.producers.NetworkFetcher.Callback r7) {
        /*
            r5 = this;
            r0 = 0
            android.net.Uri r1 = r6.getUri()     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            r2 = 5
            java.net.HttpURLConnection r1 = r5.downloadFrom(r1, r2)     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            com.facebook.common.time.MonotonicClock r2 = r5.mMonotonicClock     // Catch:{ IOException -> 0x0031 }
            long r2 = r2.now()     // Catch:{ IOException -> 0x0031 }
            long unused = r6.responseTime = r2     // Catch:{ IOException -> 0x0031 }
            if (r1 == 0) goto L_0x0026
            java.io.InputStream r6 = r1.getInputStream()     // Catch:{ IOException -> 0x0031 }
            r0 = -1
            r7.onResponse(r6, r0)     // Catch:{ IOException -> 0x0021, all -> 0x001e }
            goto L_0x0027
        L_0x001e:
            r7 = move-exception
            r0 = r6
            goto L_0x0049
        L_0x0021:
            r0 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L_0x0038
        L_0x0026:
            r6 = r0
        L_0x0027:
            if (r6 == 0) goto L_0x002e
            r6.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x002e
        L_0x002d:
        L_0x002e:
            if (r1 == 0) goto L_0x0047
            goto L_0x0044
        L_0x0031:
            r6 = move-exception
            goto L_0x0038
        L_0x0033:
            r7 = move-exception
            r1 = r0
            goto L_0x0049
        L_0x0036:
            r6 = move-exception
            r1 = r0
        L_0x0038:
            r7.onFailure(r6)     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0042
            r0.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0042
        L_0x0041:
        L_0x0042:
            if (r1 == 0) goto L_0x0047
        L_0x0044:
            r1.disconnect()
        L_0x0047:
            return
        L_0x0048:
            r7 = move-exception
        L_0x0049:
            if (r0 == 0) goto L_0x0050
            r0.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0050
        L_0x004f:
        L_0x0050:
            if (r1 == 0) goto L_0x0055
            r1.disconnect()
        L_0x0055:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.fetchSync(com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher$HttpUrlConnectionNetworkFetchState, com.facebook.imagepipeline.producers.NetworkFetcher$Callback):void");
    }

    private HttpURLConnection downloadFrom(Uri uri, int i) throws IOException {
        Uri uri2;
        String str;
        HttpURLConnection openConnectionTo = openConnectionTo(uri);
        if (this.mUserAgent != null) {
            openConnectionTo.setRequestProperty("User-Agent", this.mUserAgent);
        }
        openConnectionTo.setConnectTimeout(this.mHttpConnectionTimeout);
        int responseCode = openConnectionTo.getResponseCode();
        if (isHttpSuccess(responseCode)) {
            return openConnectionTo;
        }
        if (isHttpRedirect(responseCode)) {
            String headerField = openConnectionTo.getHeaderField("Location");
            openConnectionTo.disconnect();
            if (headerField == null) {
                uri2 = null;
            } else {
                uri2 = Uri.parse(headerField);
            }
            String scheme = uri.getScheme();
            if (i > 0 && uri2 != null && !uri2.getScheme().equals(scheme)) {
                return downloadFrom(uri2, i - 1);
            }
            if (i == 0) {
                str = error("URL %s follows too many redirects", uri.toString());
            } else {
                str = error("URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode));
            }
            throw new IOException(str);
        }
        openConnectionTo.disconnect();
        throw new IOException(String.format("Image URL %s returned HTTP code %d", new Object[]{uri.toString(), Integer.valueOf(responseCode)}));
    }

    @VisibleForTesting
    static HttpURLConnection openConnectionTo(Uri uri) throws IOException {
        return (HttpURLConnection) UriUtil.uriToUrl(uri).openConnection();
    }

    public void onFetchCompletion(HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, int i) {
        long unused = httpUrlConnectionNetworkFetchState.fetchCompleteTime = this.mMonotonicClock.now();
    }

    private static String error(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }

    public Map<String, String> getExtraMap(HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, int i) {
        HashMap hashMap = new HashMap(4);
        hashMap.put(QUEUE_TIME, Long.toString(httpUrlConnectionNetworkFetchState.responseTime - httpUrlConnectionNetworkFetchState.submitTime));
        hashMap.put(FETCH_TIME, Long.toString(httpUrlConnectionNetworkFetchState.fetchCompleteTime - httpUrlConnectionNetworkFetchState.responseTime));
        hashMap.put(TOTAL_TIME, Long.toString(httpUrlConnectionNetworkFetchState.fetchCompleteTime - httpUrlConnectionNetworkFetchState.submitTime));
        hashMap.put(IMAGE_SIZE, Integer.toString(i));
        return hashMap;
    }
}
