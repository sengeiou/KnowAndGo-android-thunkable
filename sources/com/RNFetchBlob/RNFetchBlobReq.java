package com.RNFetchBlob;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.polidea.rxandroidble.ClientComponent;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.C3873Response;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;

public class RNFetchBlobReq extends BroadcastReceiver implements Runnable {
    public static HashMap<String, Long> androidDownloadManagerTaskTable = new HashMap<>();
    static ConnectionPool pool = new ConnectionPool();
    static HashMap<String, RNFetchBlobProgressConfig> progressReport = new HashMap<>();
    public static HashMap<String, Call> taskTable = new HashMap<>();
    static HashMap<String, RNFetchBlobProgressConfig> uploadProgressReport = new HashMap<>();
    Callback callback;
    OkHttpClient client;
    long contentLength;
    String destPath;
    long downloadManagerId;
    ReadableMap headers;
    String method;
    RNFetchBlobConfig options;
    String rawRequestBody;
    ReadableArray rawRequestBodyArray;
    ArrayList<String> redirects = new ArrayList<>();
    RNFetchBlobBody requestBody;
    RequestType requestType;
    WritableMap respInfo;
    ResponseFormat responseFormat = ResponseFormat.Auto;
    ResponseType responseType;
    String taskId;
    boolean timeout = false;
    String url;

    enum RequestType {
        Form,
        SingleFile,
        AsIs,
        WithoutBody,
        Others
    }

    enum ResponseFormat {
        Auto,
        UTF8,
        BASE64
    }

    enum ResponseType {
        KeepInMemory,
        FileStorage
    }

    public RNFetchBlobReq(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, ReadableArray readableArray, OkHttpClient okHttpClient, Callback callback2) {
        this.method = str2.toUpperCase();
        this.options = new RNFetchBlobConfig(readableMap);
        this.taskId = str;
        this.url = str3;
        this.headers = readableMap2;
        this.callback = callback2;
        this.rawRequestBody = str4;
        this.rawRequestBodyArray = readableArray;
        this.client = okHttpClient;
        if (this.options.fileCache.booleanValue() || this.options.path != null) {
            this.responseType = ResponseType.FileStorage;
        } else {
            this.responseType = ResponseType.KeepInMemory;
        }
        if (str4 != null) {
            this.requestType = RequestType.SingleFile;
        } else if (readableArray != null) {
            this.requestType = RequestType.Form;
        } else {
            this.requestType = RequestType.WithoutBody;
        }
    }

    public static void cancelTask(String str) {
        if (taskTable.containsKey(str)) {
            taskTable.get(str).cancel();
            taskTable.remove(str);
        }
        if (androidDownloadManagerTaskTable.containsKey(str)) {
            ((DownloadManager) C0623RNFetchBlob.RCTContext.getApplicationContext().getSystemService("download")).remove(new long[]{androidDownloadManagerTaskTable.get(str).longValue()});
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x0379 A[Catch:{ Exception -> 0x04c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x037b A[Catch:{ Exception -> 0x04c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x03ae A[Catch:{ Exception -> 0x04c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x03fb A[Catch:{ Exception -> 0x04c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x042a A[Catch:{ Exception -> 0x04c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0476 A[Catch:{ Exception -> 0x04c5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r13 = this;
            com.RNFetchBlob.RNFetchBlobConfig r0 = r13.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L_0x0126
            com.RNFetchBlob.RNFetchBlobConfig r0 = r13.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r3 = "useDownloadManager"
            boolean r0 = r0.hasKey(r3)
            if (r0 == 0) goto L_0x0126
            com.RNFetchBlob.RNFetchBlobConfig r0 = r13.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r3 = "useDownloadManager"
            boolean r0 = r0.getBoolean(r3)
            if (r0 == 0) goto L_0x0126
            java.lang.String r0 = r13.url
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.app.DownloadManager$Request r3 = new android.app.DownloadManager$Request
            r3.<init>(r0)
            com.RNFetchBlob.RNFetchBlobConfig r0 = r13.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r4 = "notification"
            boolean r0 = r0.hasKey(r4)
            if (r0 == 0) goto L_0x0049
            com.RNFetchBlob.RNFetchBlobConfig r0 = r13.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r4 = "notification"
            boolean r0 = r0.getBoolean(r4)
            if (r0 == 0) goto L_0x0049
            r3.setNotificationVisibility(r2)
            goto L_0x004c
        L_0x0049:
            r3.setNotificationVisibility(r1)
        L_0x004c:
            com.RNFetchBlob.RNFetchBlobConfig r0 = r13.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r1 = "title"
            boolean r0 = r0.hasKey(r1)
            if (r0 == 0) goto L_0x0065
            com.RNFetchBlob.RNFetchBlobConfig r0 = r13.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r1 = "title"
            java.lang.String r0 = r0.getString(r1)
            r3.setTitle(r0)
        L_0x0065:
            com.RNFetchBlob.RNFetchBlobConfig r0 = r13.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r1 = "description"
            boolean r0 = r0.hasKey(r1)
            if (r0 == 0) goto L_0x007e
            com.RNFetchBlob.RNFetchBlobConfig r0 = r13.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r1 = "description"
            java.lang.String r0 = r0.getString(r1)
            r3.setDescription(r0)
        L_0x007e:
            com.RNFetchBlob.RNFetchBlobConfig r0 = r13.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r1 = "path"
            boolean r0 = r0.hasKey(r1)
            if (r0 == 0) goto L_0x00ac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "file://"
            r0.append(r1)
            com.RNFetchBlob.RNFetchBlobConfig r1 = r13.options
            com.facebook.react.bridge.ReadableMap r1 = r1.addAndroidDownloads
            java.lang.String r2 = "path"
            java.lang.String r1 = r1.getString(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r3.setDestinationUri(r0)
        L_0x00ac:
            com.RNFetchBlob.RNFetchBlobConfig r0 = r13.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r1 = "mime"
            boolean r0 = r0.hasKey(r1)
            if (r0 == 0) goto L_0x00c5
            com.RNFetchBlob.RNFetchBlobConfig r0 = r13.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r1 = "mime"
            java.lang.String r0 = r0.getString(r1)
            r3.setMimeType(r0)
        L_0x00c5:
            com.facebook.react.bridge.ReadableMap r0 = r13.headers
            com.facebook.react.bridge.ReadableMapKeySetIterator r0 = r0.keySetIterator()
            com.RNFetchBlob.RNFetchBlobConfig r1 = r13.options
            com.facebook.react.bridge.ReadableMap r1 = r1.addAndroidDownloads
            java.lang.String r2 = "mediaScannable"
            boolean r1 = r1.hasKey(r2)
            if (r1 == 0) goto L_0x00e6
            com.RNFetchBlob.RNFetchBlobConfig r1 = r13.options
            com.facebook.react.bridge.ReadableMap r1 = r1.addAndroidDownloads
            java.lang.String r2 = "mediaScannable"
            boolean r1 = r1.hasKey(r2)
            if (r1 == 0) goto L_0x00e6
            r3.allowScanningByMediaScanner()
        L_0x00e6:
            boolean r1 = r0.hasNextKey()
            if (r1 == 0) goto L_0x00fa
            java.lang.String r1 = r0.nextKey()
            com.facebook.react.bridge.ReadableMap r2 = r13.headers
            java.lang.String r2 = r2.getString(r1)
            r3.addRequestHeader(r1, r2)
            goto L_0x00e6
        L_0x00fa:
            com.facebook.react.bridge.ReactApplicationContext r0 = com.RNFetchBlob.C0623RNFetchBlob.RCTContext
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "download"
            java.lang.Object r1 = r0.getSystemService(r1)
            android.app.DownloadManager r1 = (android.app.DownloadManager) r1
            long r1 = r1.enqueue(r3)
            r13.downloadManagerId = r1
            java.util.HashMap<java.lang.String, java.lang.Long> r1 = androidDownloadManagerTaskTable
            java.lang.String r2 = r13.taskId
            long r3 = r13.downloadManagerId
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r1.put(r2, r3)
            android.content.IntentFilter r1 = new android.content.IntentFilter
            java.lang.String r2 = "android.intent.action.DOWNLOAD_COMPLETE"
            r1.<init>(r2)
            r0.registerReceiver(r13, r1)
            return
        L_0x0126:
            java.lang.String r0 = r13.taskId
            com.RNFetchBlob.RNFetchBlobConfig r3 = r13.options
            java.lang.String r3 = r3.appendExt
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0135
            java.lang.String r3 = ""
            goto L_0x014a
        L_0x0135:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "."
            r3.append(r4)
            com.RNFetchBlob.RNFetchBlobConfig r4 = r13.options
            java.lang.String r4 = r4.appendExt
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x014a:
            com.RNFetchBlob.RNFetchBlobConfig r4 = r13.options
            java.lang.String r4 = r4.key
            r5 = 3
            r6 = 0
            r7 = 0
            if (r4 == 0) goto L_0x0191
            com.RNFetchBlob.RNFetchBlobConfig r0 = r13.options
            java.lang.String r0 = r0.key
            java.lang.String r0 = com.RNFetchBlob.RNFetchBlobUtils.getMD5(r0)
            if (r0 != 0) goto L_0x015f
            java.lang.String r0 = r13.taskId
        L_0x015f:
            java.io.File r4 = new java.io.File
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = com.RNFetchBlob.RNFetchBlobFS.getTmpPath(r0)
            r8.append(r9)
            r8.append(r3)
            java.lang.String r8 = r8.toString()
            r4.<init>(r8)
            boolean r8 = r4.exists()
            if (r8 == 0) goto L_0x0191
            com.facebook.react.bridge.Callback r0 = r13.callback
            java.lang.Object[] r3 = new java.lang.Object[r5]
            r3[r7] = r6
            java.lang.String r5 = "path"
            r3[r2] = r5
            java.lang.String r2 = r4.getAbsolutePath()
            r3[r1] = r2
            r0.invoke(r3)
            return
        L_0x0191:
            com.RNFetchBlob.RNFetchBlobConfig r4 = r13.options
            java.lang.String r4 = r4.path
            if (r4 == 0) goto L_0x019e
            com.RNFetchBlob.RNFetchBlobConfig r0 = r13.options
            java.lang.String r0 = r0.path
            r13.destPath = r0
            goto L_0x01bd
        L_0x019e:
            com.RNFetchBlob.RNFetchBlobConfig r4 = r13.options
            java.lang.Boolean r4 = r4.fileCache
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x01bd
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = com.RNFetchBlob.RNFetchBlobFS.getTmpPath(r0)
            r4.append(r0)
            r4.append(r3)
            java.lang.String r0 = r4.toString()
            r13.destPath = r0
        L_0x01bd:
            com.RNFetchBlob.RNFetchBlobConfig r0 = r13.options     // Catch:{ Exception -> 0x04c5 }
            java.lang.Boolean r0 = r0.trusty     // Catch:{ Exception -> 0x04c5 }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x04c5 }
            if (r0 == 0) goto L_0x01ce
            okhttp3.OkHttpClient r0 = r13.client     // Catch:{ Exception -> 0x04c5 }
            okhttp3.OkHttpClient$Builder r0 = com.RNFetchBlob.RNFetchBlobUtils.getUnsafeOkHttpClient(r0)     // Catch:{ Exception -> 0x04c5 }
            goto L_0x01d4
        L_0x01ce:
            okhttp3.OkHttpClient r0 = r13.client     // Catch:{ Exception -> 0x04c5 }
            okhttp3.OkHttpClient$Builder r0 = r0.newBuilder()     // Catch:{ Exception -> 0x04c5 }
        L_0x01d4:
            com.RNFetchBlob.RNFetchBlobConfig r3 = r13.options     // Catch:{ Exception -> 0x04c5 }
            java.lang.Boolean r3 = r3.wifiOnly     // Catch:{ Exception -> 0x04c5 }
            boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x04c5 }
            if (r3 == 0) goto L_0x0240
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x04c5 }
            r4 = 21
            if (r3 < r4) goto L_0x023b
            com.facebook.react.bridge.ReactApplicationContext r3 = com.RNFetchBlob.C0623RNFetchBlob.RCTContext     // Catch:{ Exception -> 0x04c5 }
            com.facebook.react.bridge.ReactApplicationContext r4 = com.RNFetchBlob.C0623RNFetchBlob.RCTContext     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r4 = "connectivity"
            java.lang.Object r3 = r3.getSystemService(r4)     // Catch:{ Exception -> 0x04c5 }
            android.net.ConnectivityManager r3 = (android.net.ConnectivityManager) r3     // Catch:{ Exception -> 0x04c5 }
            android.net.Network[] r4 = r3.getAllNetworks()     // Catch:{ Exception -> 0x04c5 }
            int r8 = r4.length     // Catch:{ Exception -> 0x04c5 }
            r9 = 0
        L_0x01f6:
            if (r9 >= r8) goto L_0x0225
            r10 = r4[r9]     // Catch:{ Exception -> 0x04c5 }
            android.net.NetworkInfo r11 = r3.getNetworkInfo(r10)     // Catch:{ Exception -> 0x04c5 }
            android.net.NetworkCapabilities r12 = r3.getNetworkCapabilities(r10)     // Catch:{ Exception -> 0x04c5 }
            if (r12 == 0) goto L_0x0222
            if (r11 != 0) goto L_0x0207
            goto L_0x0222
        L_0x0207:
            boolean r11 = r11.isConnected()     // Catch:{ Exception -> 0x04c5 }
            if (r11 != 0) goto L_0x020e
            goto L_0x0222
        L_0x020e:
            boolean r11 = r12.hasTransport(r2)     // Catch:{ Exception -> 0x04c5 }
            if (r11 == 0) goto L_0x0222
            java.net.Proxy r3 = java.net.Proxy.NO_PROXY     // Catch:{ Exception -> 0x04c5 }
            r0.proxy(r3)     // Catch:{ Exception -> 0x04c5 }
            javax.net.SocketFactory r3 = r10.getSocketFactory()     // Catch:{ Exception -> 0x04c5 }
            r0.socketFactory(r3)     // Catch:{ Exception -> 0x04c5 }
            r3 = 1
            goto L_0x0226
        L_0x0222:
            int r9 = r9 + 1
            goto L_0x01f6
        L_0x0225:
            r3 = 0
        L_0x0226:
            if (r3 != 0) goto L_0x0240
            com.facebook.react.bridge.Callback r0 = r13.callback     // Catch:{ Exception -> 0x04c5 }
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r4 = "No available WiFi connections."
            r3[r7] = r4     // Catch:{ Exception -> 0x04c5 }
            r3[r2] = r6     // Catch:{ Exception -> 0x04c5 }
            r3[r1] = r6     // Catch:{ Exception -> 0x04c5 }
            r0.invoke(r3)     // Catch:{ Exception -> 0x04c5 }
            r13.releaseTaskResource()     // Catch:{ Exception -> 0x04c5 }
            return
        L_0x023b:
            java.lang.String r1 = "RNFetchBlob: wifiOnly was set, but SDK < 21. wifiOnly was ignored."
            com.RNFetchBlob.RNFetchBlobUtils.emitWarningEvent(r1)     // Catch:{ Exception -> 0x04c5 }
        L_0x0240:
            okhttp3.Request$Builder r1 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x04c5 }
            r1.<init>()     // Catch:{ Exception -> 0x04c5 }
            java.net.URL r3 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0250 }
            java.lang.String r4 = r13.url     // Catch:{ MalformedURLException -> 0x0250 }
            r3.<init>(r4)     // Catch:{ MalformedURLException -> 0x0250 }
            r1.url((java.net.URL) r3)     // Catch:{ MalformedURLException -> 0x0250 }
            goto L_0x0254
        L_0x0250:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ Exception -> 0x04c5 }
        L_0x0254:
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x04c5 }
            r3.<init>()     // Catch:{ Exception -> 0x04c5 }
            com.facebook.react.bridge.ReadableMap r4 = r13.headers     // Catch:{ Exception -> 0x04c5 }
            if (r4 == 0) goto L_0x02a5
            com.facebook.react.bridge.ReadableMap r4 = r13.headers     // Catch:{ Exception -> 0x04c5 }
            com.facebook.react.bridge.ReadableMapKeySetIterator r4 = r4.keySetIterator()     // Catch:{ Exception -> 0x04c5 }
        L_0x0263:
            boolean r5 = r4.hasNextKey()     // Catch:{ Exception -> 0x04c5 }
            if (r5 == 0) goto L_0x02a5
            java.lang.String r5 = r4.nextKey()     // Catch:{ Exception -> 0x04c5 }
            com.facebook.react.bridge.ReadableMap r8 = r13.headers     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r8 = r8.getString(r5)     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r9 = "RNFB-Response"
            boolean r9 = r5.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x04c5 }
            if (r9 == 0) goto L_0x0296
            java.lang.String r5 = "base64"
            boolean r5 = r8.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x04c5 }
            if (r5 == 0) goto L_0x0288
            com.RNFetchBlob.RNFetchBlobReq$ResponseFormat r5 = com.RNFetchBlob.RNFetchBlobReq.ResponseFormat.BASE64     // Catch:{ Exception -> 0x04c5 }
            r13.responseFormat = r5     // Catch:{ Exception -> 0x04c5 }
            goto L_0x0263
        L_0x0288:
            java.lang.String r5 = "utf8"
            boolean r5 = r8.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x04c5 }
            if (r5 == 0) goto L_0x0263
            com.RNFetchBlob.RNFetchBlobReq$ResponseFormat r5 = com.RNFetchBlob.RNFetchBlobReq.ResponseFormat.UTF8     // Catch:{ Exception -> 0x04c5 }
            r13.responseFormat = r5     // Catch:{ Exception -> 0x04c5 }
            goto L_0x0263
        L_0x0296:
            java.lang.String r9 = r5.toLowerCase()     // Catch:{ Exception -> 0x04c5 }
            r1.header(r9, r8)     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r5 = r5.toLowerCase()     // Catch:{ Exception -> 0x04c5 }
            r3.put(r5, r8)     // Catch:{ Exception -> 0x04c5 }
            goto L_0x0263
        L_0x02a5:
            java.lang.String r4 = r13.method     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r5 = "post"
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x04c5 }
            if (r4 != 0) goto L_0x02ca
            java.lang.String r4 = r13.method     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r5 = "put"
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x04c5 }
            if (r4 != 0) goto L_0x02ca
            java.lang.String r4 = r13.method     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r5 = "patch"
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x04c5 }
            if (r4 == 0) goto L_0x02c4
            goto L_0x02ca
        L_0x02c4:
            com.RNFetchBlob.RNFetchBlobReq$RequestType r4 = com.RNFetchBlob.RNFetchBlobReq.RequestType.WithoutBody     // Catch:{ Exception -> 0x04c5 }
            r13.requestType = r4     // Catch:{ Exception -> 0x04c5 }
            goto L_0x0360
        L_0x02ca:
            java.lang.String r4 = "Content-Type"
            java.lang.String r4 = r13.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ Exception -> 0x04c5 }
            com.facebook.react.bridge.ReadableArray r5 = r13.rawRequestBodyArray     // Catch:{ Exception -> 0x04c5 }
            if (r5 == 0) goto L_0x02dd
            com.RNFetchBlob.RNFetchBlobReq$RequestType r5 = com.RNFetchBlob.RNFetchBlobReq.RequestType.Form     // Catch:{ Exception -> 0x04c5 }
            r13.requestType = r5     // Catch:{ Exception -> 0x04c5 }
            goto L_0x02f6
        L_0x02dd:
            boolean r5 = r4.isEmpty()     // Catch:{ Exception -> 0x04c5 }
            if (r5 == 0) goto L_0x02f6
            java.lang.String r5 = ""
            boolean r5 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x04c5 }
            if (r5 != 0) goto L_0x02f2
            java.lang.String r5 = "Content-Type"
            java.lang.String r8 = "application/octet-stream"
            r1.header(r5, r8)     // Catch:{ Exception -> 0x04c5 }
        L_0x02f2:
            com.RNFetchBlob.RNFetchBlobReq$RequestType r5 = com.RNFetchBlob.RNFetchBlobReq.RequestType.SingleFile     // Catch:{ Exception -> 0x04c5 }
            r13.requestType = r5     // Catch:{ Exception -> 0x04c5 }
        L_0x02f6:
            java.lang.String r5 = r13.rawRequestBody     // Catch:{ Exception -> 0x04c5 }
            if (r5 == 0) goto L_0x0360
            java.lang.String r5 = r13.rawRequestBody     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r8 = "RNFetchBlob-file://"
            boolean r5 = r5.startsWith(r8)     // Catch:{ Exception -> 0x04c5 }
            if (r5 != 0) goto L_0x035c
            java.lang.String r5 = r13.rawRequestBody     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r8 = "RNFetchBlob-content://"
            boolean r5 = r5.startsWith(r8)     // Catch:{ Exception -> 0x04c5 }
            if (r5 == 0) goto L_0x030f
            goto L_0x035c
        L_0x030f:
            java.lang.String r5 = r4.toLowerCase()     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r8 = ";base64"
            boolean r5 = r5.contains(r8)     // Catch:{ Exception -> 0x04c5 }
            if (r5 != 0) goto L_0x032d
            java.lang.String r5 = r4.toLowerCase()     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r8 = "application/octet"
            boolean r5 = r5.startsWith(r8)     // Catch:{ Exception -> 0x04c5 }
            if (r5 == 0) goto L_0x0328
            goto L_0x032d
        L_0x0328:
            com.RNFetchBlob.RNFetchBlobReq$RequestType r4 = com.RNFetchBlob.RNFetchBlobReq.RequestType.AsIs     // Catch:{ Exception -> 0x04c5 }
            r13.requestType = r4     // Catch:{ Exception -> 0x04c5 }
            goto L_0x0360
        L_0x032d:
            java.lang.String r5 = ";base64"
            java.lang.String r8 = ""
            java.lang.String r4 = r4.replace(r5, r8)     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r5 = ";BASE64"
            java.lang.String r8 = ""
            java.lang.String r4 = r4.replace(r5, r8)     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r5 = "content-type"
            boolean r5 = r3.containsKey(r5)     // Catch:{ Exception -> 0x04c5 }
            if (r5 == 0) goto L_0x034a
            java.lang.String r5 = "content-type"
            r3.put(r5, r4)     // Catch:{ Exception -> 0x04c5 }
        L_0x034a:
            java.lang.String r5 = "Content-Type"
            boolean r5 = r3.containsKey(r5)     // Catch:{ Exception -> 0x04c5 }
            if (r5 == 0) goto L_0x0357
            java.lang.String r5 = "Content-Type"
            r3.put(r5, r4)     // Catch:{ Exception -> 0x04c5 }
        L_0x0357:
            com.RNFetchBlob.RNFetchBlobReq$RequestType r4 = com.RNFetchBlob.RNFetchBlobReq.RequestType.SingleFile     // Catch:{ Exception -> 0x04c5 }
            r13.requestType = r4     // Catch:{ Exception -> 0x04c5 }
            goto L_0x0360
        L_0x035c:
            com.RNFetchBlob.RNFetchBlobReq$RequestType r4 = com.RNFetchBlob.RNFetchBlobReq.RequestType.SingleFile     // Catch:{ Exception -> 0x04c5 }
            r13.requestType = r4     // Catch:{ Exception -> 0x04c5 }
        L_0x0360:
            java.lang.String r4 = "Transfer-Encoding"
            java.lang.String r4 = r13.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r5 = "chunked"
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x04c5 }
            int[] r5 = com.RNFetchBlob.RNFetchBlobReq.C06434.$SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobReq$RequestType r8 = r13.requestType     // Catch:{ Exception -> 0x04c5 }
            int r8 = r8.ordinal()     // Catch:{ Exception -> 0x04c5 }
            r5 = r5[r8]     // Catch:{ Exception -> 0x04c5 }
            switch(r5) {
                case 1: goto L_0x042a;
                case 2: goto L_0x03fb;
                case 3: goto L_0x03ae;
                case 4: goto L_0x037b;
                default: goto L_0x0379;
            }     // Catch:{ Exception -> 0x04c5 }
        L_0x0379:
            goto L_0x0458
        L_0x037b:
            java.lang.String r3 = r13.method     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r4 = "post"
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x04c5 }
            if (r3 != 0) goto L_0x03a1
            java.lang.String r3 = r13.method     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r4 = "put"
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x04c5 }
            if (r3 != 0) goto L_0x03a1
            java.lang.String r3 = r13.method     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r4 = "patch"
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x04c5 }
            if (r3 == 0) goto L_0x039a
            goto L_0x03a1
        L_0x039a:
            java.lang.String r3 = r13.method     // Catch:{ Exception -> 0x04c5 }
            r1.method(r3, r6)     // Catch:{ Exception -> 0x04c5 }
            goto L_0x0458
        L_0x03a1:
            java.lang.String r3 = r13.method     // Catch:{ Exception -> 0x04c5 }
            byte[] r4 = new byte[r7]     // Catch:{ Exception -> 0x04c5 }
            okhttp3.RequestBody r4 = okhttp3.RequestBody.create((okhttp3.MediaType) r6, (byte[]) r4)     // Catch:{ Exception -> 0x04c5 }
            r1.method(r3, r4)     // Catch:{ Exception -> 0x04c5 }
            goto L_0x0458
        L_0x03ae:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04c5 }
            r3.<init>()     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r5 = "RNFetchBlob-"
            r3.append(r5)     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r5 = r13.taskId     // Catch:{ Exception -> 0x04c5 }
            r3.append(r5)     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobBody r5 = new com.RNFetchBlob.RNFetchBlobBody     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r6 = r13.taskId     // Catch:{ Exception -> 0x04c5 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobBody r4 = r5.chunkedEncoding(r4)     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobReq$RequestType r5 = r13.requestType     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobBody r4 = r4.setRequestType(r5)     // Catch:{ Exception -> 0x04c5 }
            com.facebook.react.bridge.ReadableArray r5 = r13.rawRequestBodyArray     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobBody r4 = r4.setBody((com.facebook.react.bridge.ReadableArray) r5)     // Catch:{ Exception -> 0x04c5 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04c5 }
            r5.<init>()     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r6 = "multipart/form-data; boundary="
            r5.append(r6)     // Catch:{ Exception -> 0x04c5 }
            r5.append(r3)     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x04c5 }
            okhttp3.MediaType r3 = okhttp3.MediaType.parse(r3)     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobBody r3 = r4.setMIME(r3)     // Catch:{ Exception -> 0x04c5 }
            r13.requestBody = r3     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r3 = r13.method     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobBody r4 = r13.requestBody     // Catch:{ Exception -> 0x04c5 }
            r1.method(r3, r4)     // Catch:{ Exception -> 0x04c5 }
            goto L_0x0458
        L_0x03fb:
            com.RNFetchBlob.RNFetchBlobBody r5 = new com.RNFetchBlob.RNFetchBlobBody     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r6 = r13.taskId     // Catch:{ Exception -> 0x04c5 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobBody r4 = r5.chunkedEncoding(r4)     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobReq$RequestType r5 = r13.requestType     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobBody r4 = r4.setRequestType(r5)     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r5 = r13.rawRequestBody     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobBody r4 = r4.setBody((java.lang.String) r5)     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r5 = "content-type"
            java.lang.String r3 = r13.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x04c5 }
            okhttp3.MediaType r3 = okhttp3.MediaType.parse(r3)     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobBody r3 = r4.setMIME(r3)     // Catch:{ Exception -> 0x04c5 }
            r13.requestBody = r3     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r3 = r13.method     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobBody r4 = r13.requestBody     // Catch:{ Exception -> 0x04c5 }
            r1.method(r3, r4)     // Catch:{ Exception -> 0x04c5 }
            goto L_0x0458
        L_0x042a:
            com.RNFetchBlob.RNFetchBlobBody r5 = new com.RNFetchBlob.RNFetchBlobBody     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r6 = r13.taskId     // Catch:{ Exception -> 0x04c5 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobBody r4 = r5.chunkedEncoding(r4)     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobReq$RequestType r5 = r13.requestType     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobBody r4 = r4.setRequestType(r5)     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r5 = r13.rawRequestBody     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobBody r4 = r4.setBody((java.lang.String) r5)     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r5 = "content-type"
            java.lang.String r3 = r13.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x04c5 }
            okhttp3.MediaType r3 = okhttp3.MediaType.parse(r3)     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobBody r3 = r4.setMIME(r3)     // Catch:{ Exception -> 0x04c5 }
            r13.requestBody = r3     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r3 = r13.method     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobBody r4 = r13.requestBody     // Catch:{ Exception -> 0x04c5 }
            r1.method(r3, r4)     // Catch:{ Exception -> 0x04c5 }
        L_0x0458:
            okhttp3.Request r1 = r1.build()     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobReq$1 r3 = new com.RNFetchBlob.RNFetchBlobReq$1     // Catch:{ Exception -> 0x04c5 }
            r3.<init>()     // Catch:{ Exception -> 0x04c5 }
            r0.addNetworkInterceptor(r3)     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobReq$2 r3 = new com.RNFetchBlob.RNFetchBlobReq$2     // Catch:{ Exception -> 0x04c5 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x04c5 }
            r0.addInterceptor(r3)     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobConfig r3 = r13.options     // Catch:{ Exception -> 0x04c5 }
            long r3 = r3.timeout     // Catch:{ Exception -> 0x04c5 }
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x0488
            com.RNFetchBlob.RNFetchBlobConfig r3 = r13.options     // Catch:{ Exception -> 0x04c5 }
            long r3 = r3.timeout     // Catch:{ Exception -> 0x04c5 }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x04c5 }
            r0.connectTimeout(r3, r5)     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobConfig r3 = r13.options     // Catch:{ Exception -> 0x04c5 }
            long r3 = r3.timeout     // Catch:{ Exception -> 0x04c5 }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x04c5 }
            r0.readTimeout(r3, r5)     // Catch:{ Exception -> 0x04c5 }
        L_0x0488:
            okhttp3.ConnectionPool r3 = pool     // Catch:{ Exception -> 0x04c5 }
            r0.connectionPool(r3)     // Catch:{ Exception -> 0x04c5 }
            r0.retryOnConnectionFailure(r7)     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobConfig r3 = r13.options     // Catch:{ Exception -> 0x04c5 }
            java.lang.Boolean r3 = r3.followRedirect     // Catch:{ Exception -> 0x04c5 }
            boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x04c5 }
            r0.followRedirects(r3)     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobConfig r3 = r13.options     // Catch:{ Exception -> 0x04c5 }
            java.lang.Boolean r3 = r3.followRedirect     // Catch:{ Exception -> 0x04c5 }
            boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x04c5 }
            r0.followSslRedirects(r3)     // Catch:{ Exception -> 0x04c5 }
            r0.retryOnConnectionFailure(r2)     // Catch:{ Exception -> 0x04c5 }
            okhttp3.OkHttpClient$Builder r0 = enableTls12OnPreLollipop(r0)     // Catch:{ Exception -> 0x04c5 }
            okhttp3.OkHttpClient r0 = r0.build()     // Catch:{ Exception -> 0x04c5 }
            okhttp3.Call r0 = r0.newCall(r1)     // Catch:{ Exception -> 0x04c5 }
            java.util.HashMap<java.lang.String, okhttp3.Call> r1 = taskTable     // Catch:{ Exception -> 0x04c5 }
            java.lang.String r3 = r13.taskId     // Catch:{ Exception -> 0x04c5 }
            r1.put(r3, r0)     // Catch:{ Exception -> 0x04c5 }
            com.RNFetchBlob.RNFetchBlobReq$3 r1 = new com.RNFetchBlob.RNFetchBlobReq$3     // Catch:{ Exception -> 0x04c5 }
            r1.<init>()     // Catch:{ Exception -> 0x04c5 }
            r0.enqueue(r1)     // Catch:{ Exception -> 0x04c5 }
            goto L_0x04f1
        L_0x04c5:
            r0 = move-exception
            r0.printStackTrace()
            r13.releaseTaskResource()
            com.facebook.react.bridge.Callback r1 = r13.callback
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "RNFetchBlob request error: "
            r3.append(r4)
            java.lang.String r4 = r0.getMessage()
            r3.append(r4)
            java.lang.Throwable r0 = r0.getCause()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2[r7] = r0
            r1.invoke(r2)
        L_0x04f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobReq.run():void");
    }

    /* access modifiers changed from: private */
    public void releaseTaskResource() {
        if (taskTable.containsKey(this.taskId)) {
            taskTable.remove(this.taskId);
        }
        if (androidDownloadManagerTaskTable.containsKey(this.taskId)) {
            androidDownloadManagerTaskTable.remove(this.taskId);
        }
        if (uploadProgressReport.containsKey(this.taskId)) {
            uploadProgressReport.remove(this.taskId);
        }
        if (progressReport.containsKey(this.taskId)) {
            progressReport.remove(this.taskId);
        }
        if (this.requestBody != null) {
            this.requestBody.clearRequestBody();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:27|28|29|30|(1:32)(1:33)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00fa */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0100 A[Catch:{ IOException -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0116 A[Catch:{ IOException -> 0x012a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void done(okhttp3.C3873Response r12) {
        /*
            r11 = this;
            boolean r0 = r11.isBlobResponse(r12)
            com.facebook.react.bridge.WritableMap r1 = r11.getResponseInfo(r12, r0)
            r11.emitStateEvent(r1)
            int[] r1 = com.RNFetchBlob.RNFetchBlobReq.C06434.$SwitchMap$com$RNFetchBlob$RNFetchBlobReq$ResponseType
            com.RNFetchBlob.RNFetchBlobReq$ResponseType r2 = r11.responseType
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 3
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 2
            switch(r1) {
                case 1: goto L_0x0060;
                case 2: goto L_0x0021;
                default: goto L_0x001d;
            }
        L_0x001d:
            com.facebook.react.bridge.Callback r0 = r11.callback     // Catch:{ IOException -> 0x0156 }
            goto L_0x0138
        L_0x0021:
            okhttp3.ResponseBody r0 = r12.body()
            r0.bytes()     // Catch:{ Exception -> 0x0028 }
        L_0x0028:
            com.RNFetchBlob.Response.RNFetchBlobFileResp r0 = (com.RNFetchBlob.Response.RNFetchBlobFileResp) r0
            if (r0 == 0) goto L_0x0041
            boolean r0 = r0.isDownloadComplete()
            if (r0 != 0) goto L_0x0041
            com.facebook.react.bridge.Callback r0 = r11.callback
            java.lang.Object[] r1 = new java.lang.Object[r6]
            java.lang.String r2 = "Download interrupted."
            r1[r5] = r2
            r1[r4] = r3
            r0.invoke(r1)
            goto L_0x0163
        L_0x0041:
            java.lang.String r0 = r11.destPath
            java.lang.String r1 = "?append=true"
            java.lang.String r7 = ""
            java.lang.String r0 = r0.replace(r1, r7)
            r11.destPath = r0
            com.facebook.react.bridge.Callback r0 = r11.callback
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r1[r5] = r3
            java.lang.String r2 = "path"
            r1[r4] = r2
            java.lang.String r2 = r11.destPath
            r1[r6] = r2
            r0.invoke(r1)
            goto L_0x0163
        L_0x0060:
            if (r0 == 0) goto L_0x00ad
            com.RNFetchBlob.RNFetchBlobConfig r0 = r11.options     // Catch:{ IOException -> 0x012a }
            java.lang.Boolean r0 = r0.auto     // Catch:{ IOException -> 0x012a }
            boolean r0 = r0.booleanValue()     // Catch:{ IOException -> 0x012a }
            if (r0 == 0) goto L_0x00ad
            java.lang.String r0 = r11.taskId     // Catch:{ IOException -> 0x012a }
            java.lang.String r0 = com.RNFetchBlob.RNFetchBlobFS.getTmpPath(r0)     // Catch:{ IOException -> 0x012a }
            okhttp3.ResponseBody r1 = r12.body()     // Catch:{ IOException -> 0x012a }
            java.io.InputStream r1 = r1.byteStream()     // Catch:{ IOException -> 0x012a }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x012a }
            java.io.File r8 = new java.io.File     // Catch:{ IOException -> 0x012a }
            r8.<init>(r0)     // Catch:{ IOException -> 0x012a }
            r7.<init>(r8)     // Catch:{ IOException -> 0x012a }
            r8 = 10240(0x2800, float:1.4349E-41)
            byte[] r8 = new byte[r8]     // Catch:{ IOException -> 0x012a }
        L_0x0088:
            int r9 = r1.read(r8)     // Catch:{ IOException -> 0x012a }
            r10 = -1
            if (r9 == r10) goto L_0x0093
            r7.write(r8, r5, r9)     // Catch:{ IOException -> 0x012a }
            goto L_0x0088
        L_0x0093:
            r1.close()     // Catch:{ IOException -> 0x012a }
            r7.flush()     // Catch:{ IOException -> 0x012a }
            r7.close()     // Catch:{ IOException -> 0x012a }
            com.facebook.react.bridge.Callback r1 = r11.callback     // Catch:{ IOException -> 0x012a }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x012a }
            r2[r5] = r3     // Catch:{ IOException -> 0x012a }
            java.lang.String r7 = "path"
            r2[r4] = r7     // Catch:{ IOException -> 0x012a }
            r2[r6] = r0     // Catch:{ IOException -> 0x012a }
            r1.invoke(r2)     // Catch:{ IOException -> 0x012a }
            goto L_0x0163
        L_0x00ad:
            okhttp3.ResponseBody r0 = r12.body()     // Catch:{ IOException -> 0x012a }
            byte[] r0 = r0.bytes()     // Catch:{ IOException -> 0x012a }
            java.lang.String r1 = "UTF-8"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)     // Catch:{ IOException -> 0x012a }
            java.nio.charset.CharsetEncoder r1 = r1.newEncoder()     // Catch:{ IOException -> 0x012a }
            com.RNFetchBlob.RNFetchBlobReq$ResponseFormat r7 = r11.responseFormat     // Catch:{ IOException -> 0x012a }
            com.RNFetchBlob.RNFetchBlobReq$ResponseFormat r8 = com.RNFetchBlob.RNFetchBlobReq.ResponseFormat.BASE64     // Catch:{ IOException -> 0x012a }
            if (r7 != r8) goto L_0x00d9
            com.facebook.react.bridge.Callback r1 = r11.callback     // Catch:{ IOException -> 0x012a }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x012a }
            r2[r5] = r3     // Catch:{ IOException -> 0x012a }
            java.lang.String r7 = "base64"
            r2[r4] = r7     // Catch:{ IOException -> 0x012a }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r6)     // Catch:{ IOException -> 0x012a }
            r2[r6] = r0     // Catch:{ IOException -> 0x012a }
            r1.invoke(r2)     // Catch:{ IOException -> 0x012a }
            return
        L_0x00d9:
            java.nio.ByteBuffer r7 = java.nio.ByteBuffer.wrap(r0)     // Catch:{ CharacterCodingException -> 0x00fa }
            java.nio.CharBuffer r7 = r7.asCharBuffer()     // Catch:{ CharacterCodingException -> 0x00fa }
            r1.encode(r7)     // Catch:{ CharacterCodingException -> 0x00fa }
            java.lang.String r1 = new java.lang.String     // Catch:{ CharacterCodingException -> 0x00fa }
            r1.<init>(r0)     // Catch:{ CharacterCodingException -> 0x00fa }
            com.facebook.react.bridge.Callback r7 = r11.callback     // Catch:{ CharacterCodingException -> 0x00fa }
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ CharacterCodingException -> 0x00fa }
            r8[r5] = r3     // Catch:{ CharacterCodingException -> 0x00fa }
            java.lang.String r9 = "utf8"
            r8[r4] = r9     // Catch:{ CharacterCodingException -> 0x00fa }
            r8[r6] = r1     // Catch:{ CharacterCodingException -> 0x00fa }
            r7.invoke(r8)     // Catch:{ CharacterCodingException -> 0x00fa }
            goto L_0x0163
        L_0x00fa:
            com.RNFetchBlob.RNFetchBlobReq$ResponseFormat r1 = r11.responseFormat     // Catch:{ IOException -> 0x012a }
            com.RNFetchBlob.RNFetchBlobReq$ResponseFormat r7 = com.RNFetchBlob.RNFetchBlobReq.ResponseFormat.UTF8     // Catch:{ IOException -> 0x012a }
            if (r1 != r7) goto L_0x0116
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x012a }
            r1.<init>(r0)     // Catch:{ IOException -> 0x012a }
            com.facebook.react.bridge.Callback r0 = r11.callback     // Catch:{ IOException -> 0x012a }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x012a }
            r2[r5] = r3     // Catch:{ IOException -> 0x012a }
            java.lang.String r7 = "utf8"
            r2[r4] = r7     // Catch:{ IOException -> 0x012a }
            r2[r6] = r1     // Catch:{ IOException -> 0x012a }
            r0.invoke(r2)     // Catch:{ IOException -> 0x012a }
            goto L_0x0163
        L_0x0116:
            com.facebook.react.bridge.Callback r1 = r11.callback     // Catch:{ IOException -> 0x012a }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x012a }
            r2[r5] = r3     // Catch:{ IOException -> 0x012a }
            java.lang.String r7 = "base64"
            r2[r4] = r7     // Catch:{ IOException -> 0x012a }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r6)     // Catch:{ IOException -> 0x012a }
            r2[r6] = r0     // Catch:{ IOException -> 0x012a }
            r1.invoke(r2)     // Catch:{ IOException -> 0x012a }
            goto L_0x0163
        L_0x012a:
            com.facebook.react.bridge.Callback r0 = r11.callback
            java.lang.Object[] r1 = new java.lang.Object[r6]
            java.lang.String r2 = "RNFetchBlob failed to encode response data to BASE64 string."
            r1[r5] = r2
            r1[r4] = r3
            r0.invoke(r1)
            goto L_0x0163
        L_0x0138:
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x0156 }
            r1[r5] = r3     // Catch:{ IOException -> 0x0156 }
            java.lang.String r2 = "utf8"
            r1[r4] = r2     // Catch:{ IOException -> 0x0156 }
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x0156 }
            okhttp3.ResponseBody r7 = r12.body()     // Catch:{ IOException -> 0x0156 }
            byte[] r7 = r7.bytes()     // Catch:{ IOException -> 0x0156 }
            java.lang.String r8 = "UTF-8"
            r2.<init>(r7, r8)     // Catch:{ IOException -> 0x0156 }
            r1[r6] = r2     // Catch:{ IOException -> 0x0156 }
            r0.invoke(r1)     // Catch:{ IOException -> 0x0156 }
            goto L_0x0163
        L_0x0156:
            com.facebook.react.bridge.Callback r0 = r11.callback
            java.lang.Object[] r1 = new java.lang.Object[r6]
            java.lang.String r2 = "RNFetchBlob failed to encode response data to UTF8 string."
            r1[r5] = r2
            r1[r4] = r3
            r0.invoke(r1)
        L_0x0163:
            okhttp3.ResponseBody r12 = r12.body()
            r12.close()
            r11.releaseTaskResource()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobReq.done(okhttp3.Response):void");
    }

    public static RNFetchBlobProgressConfig getReportProgress(String str) {
        if (!progressReport.containsKey(str)) {
            return null;
        }
        return progressReport.get(str);
    }

    public static RNFetchBlobProgressConfig getReportUploadProgress(String str) {
        if (!uploadProgressReport.containsKey(str)) {
            return null;
        }
        return uploadProgressReport.get(str);
    }

    private WritableMap getResponseInfo(C3873Response response, boolean z) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("status", response.code());
        createMap.putString("state", ExifInterface.GPS_MEASUREMENT_2D);
        createMap.putString("taskId", this.taskId);
        createMap.putBoolean(ClientComponent.NamedSchedulers.TIMEOUT, this.timeout);
        WritableMap createMap2 = Arguments.createMap();
        for (int i = 0; i < response.headers().size(); i++) {
            createMap2.putString(response.headers().name(i), response.headers().value(i));
        }
        WritableArray createArray = Arguments.createArray();
        Iterator<String> it = this.redirects.iterator();
        while (it.hasNext()) {
            createArray.pushString(it.next());
        }
        createMap.putArray("redirects", createArray);
        createMap.putMap("headers", createMap2);
        Headers headers2 = response.headers();
        if (z) {
            createMap.putString("respType", "blob");
        } else if (getHeaderIgnoreCases(headers2, "content-type").equalsIgnoreCase("text/")) {
            createMap.putString("respType", "text");
        } else if (getHeaderIgnoreCases(headers2, "content-type").contains("application/json")) {
            createMap.putString("respType", "json");
        } else {
            createMap.putString("respType", "");
        }
        return createMap;
    }

    private boolean isBlobResponse(C3873Response response) {
        boolean z;
        String headerIgnoreCases = getHeaderIgnoreCases(response.headers(), "Content-Type");
        boolean z2 = !headerIgnoreCases.equalsIgnoreCase("text/");
        boolean z3 = !headerIgnoreCases.equalsIgnoreCase("application/json");
        if (this.options.binaryContentTypes != null) {
            int i = 0;
            while (true) {
                if (i >= this.options.binaryContentTypes.size()) {
                    break;
                } else if (headerIgnoreCases.toLowerCase().contains(this.options.binaryContentTypes.getString(i).toLowerCase())) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if ((!z3 || z2) && !z) {
                return false;
            }
            return true;
        }
        z = false;
        if (!z3) {
        }
        return false;
    }

    private String getHeaderIgnoreCases(Headers headers2, String str) {
        String str2 = headers2.get(str);
        if (str2 != null) {
            return str2;
        }
        return headers2.get(str.toLowerCase()) == null ? "" : headers2.get(str.toLowerCase());
    }

    private String getHeaderIgnoreCases(HashMap<String, String> hashMap, String str) {
        String str2 = hashMap.get(str);
        if (str2 != null) {
            return str2;
        }
        String str3 = hashMap.get(str.toLowerCase());
        return str3 == null ? "" : str3;
    }

    private void emitStateEvent(WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) C0623RNFetchBlob.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(RNFetchBlobConst.EVENT_HTTP_STATE, writableMap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x010f A[SYNTHETIC, Splitter:B:32:0x010f] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0150  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r14, android.content.Intent r15) {
        /*
            r13 = this;
            java.lang.String r14 = r15.getAction()
            java.lang.String r0 = "android.intent.action.DOWNLOAD_COMPLETE"
            boolean r14 = r0.equals(r14)
            if (r14 == 0) goto L_0x017b
            com.facebook.react.bridge.ReactApplicationContext r14 = com.RNFetchBlob.C0623RNFetchBlob.RCTContext
            android.content.Context r14 = r14.getApplicationContext()
            android.os.Bundle r15 = r15.getExtras()
            java.lang.String r0 = "extra_download_id"
            long r0 = r15.getLong(r0)
            long r2 = r13.downloadManagerId
            int r15 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r15 != 0) goto L_0x017b
            r13.releaseTaskResource()
            android.app.DownloadManager$Query r15 = new android.app.DownloadManager$Query
            r15.<init>()
            r0 = 1
            long[] r1 = new long[r0]
            long r2 = r13.downloadManagerId
            r4 = 0
            r1[r4] = r2
            r15.setFilterById(r1)
            java.lang.String r1 = "download"
            java.lang.Object r1 = r14.getSystemService(r1)
            android.app.DownloadManager r1 = (android.app.DownloadManager) r1
            r1.query(r15)
            android.database.Cursor r15 = r1.query(r15)
            r1 = 3
            r2 = 2
            r3 = 0
            if (r15 != 0) goto L_0x006f
            com.facebook.react.bridge.Callback r14 = r13.callback
            java.lang.Object[] r15 = new java.lang.Object[r1]
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "Download manager failed to download from  "
            r1.append(r5)
            java.lang.String r5 = r13.url
            r1.append(r5)
            java.lang.String r5 = ". Query was unsuccessful "
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r15[r4] = r1
            r15[r0] = r3
            r15[r2] = r3
            r14.invoke(r15)
            return
        L_0x006f:
            boolean r5 = r15.moveToFirst()     // Catch:{ all -> 0x0174 }
            if (r5 == 0) goto L_0x00fd
            java.lang.String r5 = "status"
            int r5 = r15.getColumnIndex(r5)     // Catch:{ all -> 0x0174 }
            int r5 = r15.getInt(r5)     // Catch:{ all -> 0x0174 }
            r6 = 16
            if (r5 != r6) goto L_0x00b1
            com.facebook.react.bridge.Callback r14 = r13.callback     // Catch:{ all -> 0x0174 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0174 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0174 }
            r6.<init>()     // Catch:{ all -> 0x0174 }
            java.lang.String r7 = "Download manager failed to download from  "
            r6.append(r7)     // Catch:{ all -> 0x0174 }
            java.lang.String r7 = r13.url     // Catch:{ all -> 0x0174 }
            r6.append(r7)     // Catch:{ all -> 0x0174 }
            java.lang.String r7 = ". Status Code = "
            r6.append(r7)     // Catch:{ all -> 0x0174 }
            r6.append(r5)     // Catch:{ all -> 0x0174 }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x0174 }
            r1[r4] = r5     // Catch:{ all -> 0x0174 }
            r1[r0] = r3     // Catch:{ all -> 0x0174 }
            r1[r2] = r3     // Catch:{ all -> 0x0174 }
            r14.invoke(r1)     // Catch:{ all -> 0x0174 }
            if (r15 == 0) goto L_0x00b0
            r15.close()
        L_0x00b0:
            return
        L_0x00b1:
            java.lang.String r5 = "local_uri"
            int r5 = r15.getColumnIndex(r5)     // Catch:{ all -> 0x0174 }
            java.lang.String r5 = r15.getString(r5)     // Catch:{ all -> 0x0174 }
            if (r5 == 0) goto L_0x00fd
            com.RNFetchBlob.RNFetchBlobConfig r6 = r13.options     // Catch:{ all -> 0x0174 }
            com.facebook.react.bridge.ReadableMap r6 = r6.addAndroidDownloads     // Catch:{ all -> 0x0174 }
            java.lang.String r7 = "mime"
            boolean r6 = r6.hasKey(r7)     // Catch:{ all -> 0x0174 }
            if (r6 == 0) goto L_0x00fd
            com.RNFetchBlob.RNFetchBlobConfig r6 = r13.options     // Catch:{ all -> 0x0174 }
            com.facebook.react.bridge.ReadableMap r6 = r6.addAndroidDownloads     // Catch:{ all -> 0x0174 }
            java.lang.String r7 = "mime"
            java.lang.String r6 = r6.getString(r7)     // Catch:{ all -> 0x0174 }
            java.lang.String r7 = "image"
            boolean r6 = r6.contains(r7)     // Catch:{ all -> 0x0174 }
            if (r6 == 0) goto L_0x00fd
            android.net.Uri r8 = android.net.Uri.parse(r5)     // Catch:{ all -> 0x0174 }
            android.content.ContentResolver r7 = r14.getContentResolver()     // Catch:{ all -> 0x0174 }
            java.lang.String r14 = "_data"
            java.lang.String[] r9 = new java.lang.String[]{r14}     // Catch:{ all -> 0x0174 }
            r10 = 0
            r11 = 0
            r12 = 0
            android.database.Cursor r14 = r7.query(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0174 }
            if (r14 == 0) goto L_0x00fd
            r14.moveToFirst()     // Catch:{ all -> 0x0174 }
            java.lang.String r5 = r14.getString(r4)     // Catch:{ all -> 0x0174 }
            r14.close()     // Catch:{ all -> 0x0174 }
            goto L_0x00fe
        L_0x00fd:
            r5 = r3
        L_0x00fe:
            if (r15 == 0) goto L_0x0103
            r15.close()
        L_0x0103:
            com.RNFetchBlob.RNFetchBlobConfig r14 = r13.options
            com.facebook.react.bridge.ReadableMap r14 = r14.addAndroidDownloads
            java.lang.String r15 = "path"
            boolean r14 = r14.hasKey(r15)
            if (r14 == 0) goto L_0x0150
            com.RNFetchBlob.RNFetchBlobConfig r14 = r13.options     // Catch:{ Exception -> 0x013c }
            com.facebook.react.bridge.ReadableMap r14 = r14.addAndroidDownloads     // Catch:{ Exception -> 0x013c }
            java.lang.String r15 = "path"
            java.lang.String r14 = r14.getString(r15)     // Catch:{ Exception -> 0x013c }
            java.io.File r15 = new java.io.File     // Catch:{ Exception -> 0x013c }
            r15.<init>(r14)     // Catch:{ Exception -> 0x013c }
            boolean r15 = r15.exists()     // Catch:{ Exception -> 0x013c }
            if (r15 == 0) goto L_0x0134
            com.facebook.react.bridge.Callback r15 = r13.callback     // Catch:{ Exception -> 0x013c }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x013c }
            r1[r4] = r3     // Catch:{ Exception -> 0x013c }
            java.lang.String r5 = "path"
            r1[r0] = r5     // Catch:{ Exception -> 0x013c }
            r1[r2] = r14     // Catch:{ Exception -> 0x013c }
            r15.invoke(r1)     // Catch:{ Exception -> 0x013c }
            goto L_0x017b
        L_0x0134:
            java.lang.Exception r14 = new java.lang.Exception     // Catch:{ Exception -> 0x013c }
            java.lang.String r15 = "Download manager download failed, the file does not downloaded to destination."
            r14.<init>(r15)     // Catch:{ Exception -> 0x013c }
            throw r14     // Catch:{ Exception -> 0x013c }
        L_0x013c:
            r14 = move-exception
            r14.printStackTrace()
            com.facebook.react.bridge.Callback r15 = r13.callback
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.String r14 = r14.getLocalizedMessage()
            r1[r4] = r14
            r1[r0] = r3
            r15.invoke(r1)
            goto L_0x017b
        L_0x0150:
            if (r5 != 0) goto L_0x0164
            com.facebook.react.bridge.Callback r14 = r13.callback
            java.lang.Object[] r15 = new java.lang.Object[r1]
            java.lang.String r1 = "Download manager could not resolve downloaded file path."
            r15[r4] = r1
            java.lang.String r1 = "path"
            r15[r0] = r1
            r15[r2] = r3
            r14.invoke(r15)
            goto L_0x017b
        L_0x0164:
            com.facebook.react.bridge.Callback r14 = r13.callback
            java.lang.Object[] r15 = new java.lang.Object[r1]
            r15[r4] = r3
            java.lang.String r1 = "path"
            r15[r0] = r1
            r15[r2] = r5
            r14.invoke(r15)
            goto L_0x017b
        L_0x0174:
            r14 = move-exception
            if (r15 == 0) goto L_0x017a
            r15.close()
        L_0x017a:
            throw r14
        L_0x017b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobReq.onReceive(android.content.Context, android.content.Intent):void");
    }

    public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder builder) {
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19) {
            try {
                TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance.init((KeyStore) null);
                TrustManager[] trustManagers = instance.getTrustManagers();
                if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                    throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
                }
                X509TrustManager x509TrustManager = (X509TrustManager) trustManagers[0];
                SSLContext instance2 = SSLContext.getInstance("SSL");
                instance2.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
                builder.sslSocketFactory(instance2.getSocketFactory(), x509TrustManager);
                ConnectionSpec build = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(TlsVersion.TLS_1_2).build();
                ArrayList arrayList = new ArrayList();
                arrayList.add(build);
                arrayList.add(ConnectionSpec.COMPATIBLE_TLS);
                arrayList.add(ConnectionSpec.CLEARTEXT);
                builder.connectionSpecs(arrayList);
            } catch (Exception e) {
                FLog.m63e("OkHttpClientProvider", "Error while enabling TLS 1.2", (Throwable) e);
            }
        }
        return builder;
    }
}
