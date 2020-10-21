package com.facebook.react.modules.network;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeNetworkingAndroidSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.StandardCharsets;
import com.facebook.react.common.network.OkHttpCallUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

@ReactModule(name = "Networking")
public final class NetworkingModule extends NativeNetworkingAndroidSpec {
    private static final int CHUNK_TIMEOUT_NS = 100000000;
    private static final String CONTENT_ENCODING_HEADER_NAME = "content-encoding";
    private static final String CONTENT_TYPE_HEADER_NAME = "content-type";
    private static final int MAX_CHUNK_SIZE_BETWEEN_FLUSHES = 8192;
    public static final String NAME = "Networking";
    private static final String REQUEST_BODY_KEY_BASE64 = "base64";
    private static final String REQUEST_BODY_KEY_FORMDATA = "formData";
    private static final String REQUEST_BODY_KEY_STRING = "string";
    private static final String REQUEST_BODY_KEY_URI = "uri";
    private static final String TAG = "NetworkingModule";
    private static final String USER_AGENT_HEADER_NAME = "user-agent";
    @Nullable
    private static CustomClientBuilder customClientBuilder;
    /* access modifiers changed from: private */
    public final OkHttpClient mClient;
    private final ForwardingCookieHandler mCookieHandler;
    private final CookieJarContainer mCookieJarContainer;
    @Nullable
    private final String mDefaultUserAgent;
    private final List<RequestBodyHandler> mRequestBodyHandlers;
    private final Set<Integer> mRequestIds;
    /* access modifiers changed from: private */
    public final List<ResponseHandler> mResponseHandlers;
    /* access modifiers changed from: private */
    public boolean mShuttingDown;
    private final List<UriHandler> mUriHandlers;

    public interface CustomClientBuilder {
        void apply(OkHttpClient.Builder builder);
    }

    public interface RequestBodyHandler {
        boolean supports(ReadableMap readableMap);

        RequestBody toRequestBody(ReadableMap readableMap, String str);
    }

    public interface ResponseHandler {
        boolean supports(String str);

        WritableMap toResponseData(ResponseBody responseBody) throws IOException;
    }

    public interface UriHandler {
        WritableMap fetch(Uri uri) throws IOException;

        boolean supports(Uri uri, String str);
    }

    /* access modifiers changed from: private */
    public static boolean shouldDispatch(long j, long j2) {
        return j2 + 100000000 < j;
    }

    public void addListener(String str) {
    }

    public String getName() {
        return NAME;
    }

    public void removeListeners(double d) {
    }

    NetworkingModule(ReactApplicationContext reactApplicationContext, @Nullable String str, OkHttpClient okHttpClient, @Nullable List<NetworkInterceptorCreator> list) {
        super(reactApplicationContext);
        this.mRequestBodyHandlers = new ArrayList();
        this.mUriHandlers = new ArrayList();
        this.mResponseHandlers = new ArrayList();
        if (list != null) {
            OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
            for (NetworkInterceptorCreator create : list) {
                newBuilder.addNetworkInterceptor(create.create());
            }
            okHttpClient = newBuilder.build();
        }
        this.mClient = okHttpClient;
        this.mCookieHandler = new ForwardingCookieHandler(reactApplicationContext);
        this.mCookieJarContainer = (CookieJarContainer) this.mClient.cookieJar();
        this.mShuttingDown = false;
        this.mDefaultUserAgent = str;
        this.mRequestIds = new HashSet();
    }

    NetworkingModule(ReactApplicationContext reactApplicationContext, @Nullable String str, OkHttpClient okHttpClient) {
        this(reactApplicationContext, str, okHttpClient, (List<NetworkInterceptorCreator>) null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, (String) null, OkHttpClientProvider.createClient(reactApplicationContext), (List<NetworkInterceptorCreator>) null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, List<NetworkInterceptorCreator> list) {
        this(reactApplicationContext, (String) null, OkHttpClientProvider.createClient(reactApplicationContext), list);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, String str) {
        this(reactApplicationContext, str, OkHttpClientProvider.createClient(reactApplicationContext), (List<NetworkInterceptorCreator>) null);
    }

    public static void setCustomClientBuilder(CustomClientBuilder customClientBuilder2) {
        customClientBuilder = customClientBuilder2;
    }

    private static void applyCustomBuilder(OkHttpClient.Builder builder) {
        if (customClientBuilder != null) {
            customClientBuilder.apply(builder);
        }
    }

    public void initialize() {
        this.mCookieJarContainer.setCookieJar(new JavaNetCookieJar(this.mCookieHandler));
    }

    public void onCatalystInstanceDestroy() {
        this.mShuttingDown = true;
        cancelAllRequests();
        this.mCookieHandler.destroy();
        this.mCookieJarContainer.removeCookieJar();
        this.mRequestBodyHandlers.clear();
        this.mResponseHandlers.clear();
        this.mUriHandlers.clear();
    }

    public void addUriHandler(UriHandler uriHandler) {
        this.mUriHandlers.add(uriHandler);
    }

    public void addRequestBodyHandler(RequestBodyHandler requestBodyHandler) {
        this.mRequestBodyHandlers.add(requestBodyHandler);
    }

    public void addResponseHandler(ResponseHandler responseHandler) {
        this.mResponseHandlers.add(responseHandler);
    }

    public void removeUriHandler(UriHandler uriHandler) {
        this.mUriHandlers.remove(uriHandler);
    }

    public void removeRequestBodyHandler(RequestBodyHandler requestBodyHandler) {
        this.mRequestBodyHandlers.remove(requestBodyHandler);
    }

    public void removeResponseHandler(ResponseHandler responseHandler) {
        this.mResponseHandlers.remove(responseHandler);
    }

    public void sendRequest(String str, String str2, double d, ReadableArray readableArray, ReadableMap readableMap, String str3, boolean z, double d2, boolean z2) {
        int i = (int) d;
        try {
            sendRequestInternal(str, str2, i, readableArray, readableMap, str3, z, (int) d2, z2);
        } catch (Throwable th) {
            Throwable th2 = th;
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to send url request: ");
            String str4 = str2;
            sb.append(str2);
            FLog.m63e(TAG, sb.toString(), th2);
            DeviceEventManagerModule.RCTDeviceEventEmitter eventEmitter = getEventEmitter("sendRequest error");
            if (eventEmitter != null) {
                ResponseUtil.onRequestError(eventEmitter, i, th2.getMessage(), th2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x019b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendRequestInternal(java.lang.String r15, java.lang.String r16, int r17, com.facebook.react.bridge.ReadableArray r18, com.facebook.react.bridge.ReadableMap r19, java.lang.String r20, boolean r21, int r22, boolean r23) {
        /*
            r14 = this;
            r7 = r14
            r3 = r17
            r0 = r19
            r5 = r20
            r1 = r22
            java.lang.String r2 = "sendRequestInternal"
            com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter r4 = r14.getEventEmitter(r2)
            android.net.Uri r2 = android.net.Uri.parse(r16)     // Catch:{ IOException -> 0x01cc }
            java.util.List<com.facebook.react.modules.network.NetworkingModule$UriHandler> r6 = r7.mUriHandlers     // Catch:{ IOException -> 0x01cc }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x01cc }
        L_0x0019:
            boolean r8 = r6.hasNext()     // Catch:{ IOException -> 0x01cc }
            if (r8 == 0) goto L_0x0036
            java.lang.Object r8 = r6.next()     // Catch:{ IOException -> 0x01cc }
            com.facebook.react.modules.network.NetworkingModule$UriHandler r8 = (com.facebook.react.modules.network.NetworkingModule.UriHandler) r8     // Catch:{ IOException -> 0x01cc }
            boolean r9 = r8.supports(r2, r5)     // Catch:{ IOException -> 0x01cc }
            if (r9 == 0) goto L_0x0019
            com.facebook.react.bridge.WritableMap r0 = r8.fetch(r2)     // Catch:{ IOException -> 0x01cc }
            com.facebook.react.modules.network.ResponseUtil.onDataReceived((com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter) r4, (int) r3, (com.facebook.react.bridge.WritableMap) r0)     // Catch:{ IOException -> 0x01cc }
            com.facebook.react.modules.network.ResponseUtil.onRequestSuccess(r4, r3)     // Catch:{ IOException -> 0x01cc }
            return
        L_0x0036:
            r2 = 0
            okhttp3.Request$Builder r6 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x01c3 }
            r6.<init>()     // Catch:{ Exception -> 0x01c3 }
            r8 = r16
            okhttp3.Request$Builder r6 = r6.url((java.lang.String) r8)     // Catch:{ Exception -> 0x01c3 }
            if (r3 == 0) goto L_0x004b
            java.lang.Integer r8 = java.lang.Integer.valueOf(r17)
            r6.tag(r8)
        L_0x004b:
            okhttp3.OkHttpClient r8 = r7.mClient
            okhttp3.OkHttpClient$Builder r8 = r8.newBuilder()
            applyCustomBuilder(r8)
            if (r23 != 0) goto L_0x005b
            okhttp3.CookieJar r9 = okhttp3.CookieJar.NO_COOKIES
            r8.cookieJar(r9)
        L_0x005b:
            if (r21 == 0) goto L_0x0065
            com.facebook.react.modules.network.NetworkingModule$1 r10 = new com.facebook.react.modules.network.NetworkingModule$1
            r10.<init>(r5, r4, r3)
            r8.addNetworkInterceptor(r10)
        L_0x0065:
            okhttp3.OkHttpClient r10 = r7.mClient
            int r10 = r10.connectTimeoutMillis()
            if (r1 == r10) goto L_0x0073
            long r10 = (long) r1
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS
            r8.connectTimeout(r10, r1)
        L_0x0073:
            okhttp3.OkHttpClient r1 = r8.build()
            r8 = r18
            okhttp3.Headers r8 = r14.extractHeaders(r8, r0)
            if (r8 != 0) goto L_0x0085
            java.lang.String r0 = "Unrecognized headers format"
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r4, r3, r0, r2)
            return
        L_0x0085:
            java.lang.String r10 = "content-type"
            java.lang.String r10 = r8.get(r10)
            java.lang.String r11 = "content-encoding"
            java.lang.String r11 = r8.get(r11)
            r6.headers(r8)
            if (r0 == 0) goto L_0x00af
            java.util.List<com.facebook.react.modules.network.NetworkingModule$RequestBodyHandler> r8 = r7.mRequestBodyHandlers
            java.util.Iterator r8 = r8.iterator()
        L_0x009c:
            boolean r12 = r8.hasNext()
            if (r12 == 0) goto L_0x00af
            java.lang.Object r12 = r8.next()
            com.facebook.react.modules.network.NetworkingModule$RequestBodyHandler r12 = (com.facebook.react.modules.network.NetworkingModule.RequestBodyHandler) r12
            boolean r13 = r12.supports(r0)
            if (r13 == 0) goto L_0x009c
            goto L_0x00b0
        L_0x00af:
            r12 = r2
        L_0x00b0:
            if (r0 == 0) goto L_0x019b
            java.lang.String r8 = r15.toLowerCase()
            java.lang.String r13 = "get"
            boolean r8 = r8.equals(r13)
            if (r8 != 0) goto L_0x019b
            java.lang.String r8 = r15.toLowerCase()
            java.lang.String r13 = "head"
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x00cc
            goto L_0x019b
        L_0x00cc:
            if (r12 == 0) goto L_0x00d4
            okhttp3.RequestBody r0 = r12.toRequestBody(r0, r10)
            goto L_0x019f
        L_0x00d4:
            java.lang.String r8 = "string"
            boolean r8 = r0.hasKey(r8)
            if (r8 == 0) goto L_0x0115
            if (r10 != 0) goto L_0x00e4
            java.lang.String r0 = "Payload is set but no content-type header specified"
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r4, r3, r0, r2)
            return
        L_0x00e4:
            java.lang.String r8 = "string"
            java.lang.String r0 = r0.getString(r8)
            okhttp3.MediaType r8 = okhttp3.MediaType.parse(r10)
            boolean r10 = com.facebook.react.modules.network.RequestBodyUtil.isGzipEncoding(r11)
            if (r10 == 0) goto L_0x0100
            okhttp3.RequestBody r0 = com.facebook.react.modules.network.RequestBodyUtil.createGzip(r8, r0)
            if (r0 != 0) goto L_0x019f
            java.lang.String r0 = "Failed to gzip request body"
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r4, r3, r0, r2)
            return
        L_0x0100:
            if (r8 != 0) goto L_0x0105
            java.nio.charset.Charset r2 = com.facebook.react.common.StandardCharsets.UTF_8
            goto L_0x010b
        L_0x0105:
            java.nio.charset.Charset r2 = com.facebook.react.common.StandardCharsets.UTF_8
            java.nio.charset.Charset r2 = r8.charset(r2)
        L_0x010b:
            byte[] r0 = r0.getBytes(r2)
            okhttp3.RequestBody r0 = okhttp3.RequestBody.create((okhttp3.MediaType) r8, (byte[]) r0)
            goto L_0x019f
        L_0x0115:
            java.lang.String r8 = "base64"
            boolean r8 = r0.hasKey(r8)
            if (r8 == 0) goto L_0x0138
            if (r10 != 0) goto L_0x0125
            java.lang.String r0 = "Payload is set but no content-type header specified"
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r4, r3, r0, r2)
            return
        L_0x0125:
            java.lang.String r2 = "base64"
            java.lang.String r0 = r0.getString(r2)
            okhttp3.MediaType r2 = okhttp3.MediaType.parse(r10)
            okio.ByteString r0 = okio.ByteString.decodeBase64(r0)
            okhttp3.RequestBody r0 = okhttp3.RequestBody.create((okhttp3.MediaType) r2, (okio.ByteString) r0)
            goto L_0x019f
        L_0x0138:
            java.lang.String r8 = "uri"
            boolean r8 = r0.hasKey(r8)
            if (r8 == 0) goto L_0x0178
            if (r10 != 0) goto L_0x0149
            java.lang.String r0 = "Payload is set but no content-type header specified"
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r4, r3, r0, r2)
            return
        L_0x0149:
            java.lang.String r8 = "uri"
            java.lang.String r0 = r0.getString(r8)
            com.facebook.react.bridge.ReactApplicationContext r8 = r14.getReactApplicationContext()
            java.io.InputStream r8 = com.facebook.react.modules.network.RequestBodyUtil.getFileInputStream(r8, r0)
            if (r8 != 0) goto L_0x016f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "Could not retrieve file for uri "
            r1.append(r5)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r4, r3, r0, r2)
            return
        L_0x016f:
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r10)
            okhttp3.RequestBody r0 = com.facebook.react.modules.network.RequestBodyUtil.create(r0, r8)
            goto L_0x019f
        L_0x0178:
            java.lang.String r2 = "formData"
            boolean r2 = r0.hasKey(r2)
            if (r2 == 0) goto L_0x0196
            if (r10 != 0) goto L_0x0184
            java.lang.String r10 = "multipart/form-data"
        L_0x0184:
            java.lang.String r2 = "formData"
            com.facebook.react.bridge.ReadableArray r0 = r0.getArray(r2)
            okhttp3.MultipartBody$Builder r0 = r14.constructMultipartBody(r0, r10, r3)
            if (r0 != 0) goto L_0x0191
            return
        L_0x0191:
            okhttp3.MultipartBody r0 = r0.build()
            goto L_0x019f
        L_0x0196:
            okhttp3.RequestBody r0 = com.facebook.react.modules.network.RequestBodyUtil.getEmptyBody(r15)
            goto L_0x019f
        L_0x019b:
            okhttp3.RequestBody r0 = com.facebook.react.modules.network.RequestBodyUtil.getEmptyBody(r15)
        L_0x019f:
            okhttp3.RequestBody r0 = r14.wrapRequestBodyWithProgressEmitter(r0, r4, r3)
            r2 = r15
            r6.method(r15, r0)
            r14.addRequest(r3)
            okhttp3.Request r0 = r6.build()
            okhttp3.Call r0 = r1.newCall(r0)
            com.facebook.react.modules.network.NetworkingModule$2 r8 = new com.facebook.react.modules.network.NetworkingModule$2
            r1 = r8
            r2 = r14
            r3 = r17
            r5 = r20
            r6 = r21
            r1.<init>(r3, r4, r5, r6)
            r0.enqueue(r8)
            return
        L_0x01c3:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r4, r3, r0, r2)
            return
        L_0x01cc:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r4, r3, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.network.NetworkingModule.sendRequestInternal(java.lang.String, java.lang.String, int, com.facebook.react.bridge.ReadableArray, com.facebook.react.bridge.ReadableMap, java.lang.String, boolean, int, boolean):void");
    }

    private RequestBody wrapRequestBodyWithProgressEmitter(RequestBody requestBody, final DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, final int i) {
        if (requestBody == null) {
            return null;
        }
        return RequestBodyUtil.createProgressRequest(requestBody, new ProgressListener() {
            long last = System.nanoTime();

            public void onProgress(long j, long j2, boolean z) {
                long nanoTime = System.nanoTime();
                if (z || NetworkingModule.shouldDispatch(nanoTime, this.last)) {
                    ResponseUtil.onDataSend(rCTDeviceEventEmitter, i, j, j2);
                    this.last = nanoTime;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void readWithProgress(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i, ResponseBody responseBody) throws IOException {
        long j;
        Charset charset;
        long j2 = -1;
        try {
            ProgressResponseBody progressResponseBody = (ProgressResponseBody) responseBody;
            j = progressResponseBody.totalBytesRead();
            try {
                j2 = progressResponseBody.contentLength();
            } catch (ClassCastException unused) {
            }
        } catch (ClassCastException unused2) {
            j = -1;
        }
        if (responseBody.contentType() == null) {
            charset = StandardCharsets.UTF_8;
        } else {
            charset = responseBody.contentType().charset(StandardCharsets.UTF_8);
        }
        ProgressiveStringDecoder progressiveStringDecoder = new ProgressiveStringDecoder(charset);
        InputStream byteStream = responseBody.byteStream();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = byteStream.read(bArr);
                if (read != -1) {
                    ResponseUtil.onIncrementalDataReceived(rCTDeviceEventEmitter, i, progressiveStringDecoder.decodeNext(bArr, read), j, j2);
                } else {
                    return;
                }
            }
        } finally {
            byteStream.close();
        }
    }

    private synchronized void addRequest(int i) {
        this.mRequestIds.add(Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    public synchronized void removeRequest(int i) {
        this.mRequestIds.remove(Integer.valueOf(i));
    }

    private synchronized void cancelAllRequests() {
        for (Integer intValue : this.mRequestIds) {
            cancelRequest(intValue.intValue());
        }
        this.mRequestIds.clear();
    }

    /* access modifiers changed from: private */
    public static WritableMap translateHeaders(Headers headers) {
        Bundle bundle = new Bundle();
        for (int i = 0; i < headers.size(); i++) {
            String name = headers.name(i);
            if (bundle.containsKey(name)) {
                bundle.putString(name, bundle.getString(name) + ", " + headers.value(i));
            } else {
                bundle.putString(name, headers.value(i));
            }
        }
        return Arguments.fromBundle(bundle);
    }

    public void abortRequest(double d) {
        int i = (int) d;
        cancelRequest(i);
        removeRequest(i);
    }

    private void cancelRequest(final int i) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                OkHttpCallUtil.cancelTag(NetworkingModule.this.mClient, Integer.valueOf(i));
            }
        }.execute(new Void[0]);
    }

    @ReactMethod
    public void clearCookies(Callback callback) {
        this.mCookieHandler.clearCookies(callback);
    }

    @Nullable
    private MultipartBody.Builder constructMultipartBody(ReadableArray readableArray, String str, int i) {
        MediaType mediaType;
        DeviceEventManagerModule.RCTDeviceEventEmitter eventEmitter = getEventEmitter("constructMultipartBody");
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MediaType.parse(str));
        int size = readableArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            ReadableMap map = readableArray.getMap(i2);
            Headers extractHeaders = extractHeaders(map.getArray("headers"), (ReadableMap) null);
            if (extractHeaders == null) {
                ResponseUtil.onRequestError(eventEmitter, i, "Missing or invalid header format for FormData part.", (Throwable) null);
                return null;
            }
            String str2 = extractHeaders.get(CONTENT_TYPE_HEADER_NAME);
            if (str2 != null) {
                mediaType = MediaType.parse(str2);
                extractHeaders = extractHeaders.newBuilder().removeAll(CONTENT_TYPE_HEADER_NAME).build();
            } else {
                mediaType = null;
            }
            if (map.hasKey(REQUEST_BODY_KEY_STRING)) {
                builder.addPart(extractHeaders, RequestBody.create(mediaType, map.getString(REQUEST_BODY_KEY_STRING)));
            } else if (!map.hasKey("uri")) {
                ResponseUtil.onRequestError(eventEmitter, i, "Unrecognized FormData part.", (Throwable) null);
            } else if (mediaType == null) {
                ResponseUtil.onRequestError(eventEmitter, i, "Binary FormData part needs a content-type header.", (Throwable) null);
                return null;
            } else {
                String string = map.getString("uri");
                InputStream fileInputStream = RequestBodyUtil.getFileInputStream(getReactApplicationContext(), string);
                if (fileInputStream == null) {
                    ResponseUtil.onRequestError(eventEmitter, i, "Could not retrieve file for uri " + string, (Throwable) null);
                    return null;
                }
                builder.addPart(extractHeaders, RequestBodyUtil.create(mediaType, fileInputStream));
            }
        }
        return builder;
    }

    @Nullable
    private Headers extractHeaders(@Nullable ReadableArray readableArray, @Nullable ReadableMap readableMap) {
        if (readableArray == null) {
            return null;
        }
        Headers.Builder builder = new Headers.Builder();
        int size = readableArray.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            ReadableArray array = readableArray.getArray(i);
            if (array == null || array.size() != 2) {
                return null;
            }
            String stripHeaderName = HeaderUtil.stripHeaderName(array.getString(0));
            String stripHeaderValue = HeaderUtil.stripHeaderValue(array.getString(1));
            if (stripHeaderName == null || stripHeaderValue == null) {
                return null;
            }
            builder.add(stripHeaderName, stripHeaderValue);
        }
        if (builder.get(USER_AGENT_HEADER_NAME) == null && this.mDefaultUserAgent != null) {
            builder.add(USER_AGENT_HEADER_NAME, this.mDefaultUserAgent);
        }
        if (readableMap != null && readableMap.hasKey(REQUEST_BODY_KEY_STRING)) {
            z = true;
        }
        if (!z) {
            builder.removeAll(CONTENT_ENCODING_HEADER_NAME);
        }
        return builder.build();
    }

    private DeviceEventManagerModule.RCTDeviceEventEmitter getEventEmitter(String str) {
        if (getReactApplicationContextIfActiveOrWarn() != null) {
            return (DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        }
        return null;
    }
}
