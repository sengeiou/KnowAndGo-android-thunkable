package com.onesignal;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

class OneSignalRestClient {
    private static final String BASE_URL = "https://api.onesignal.com/";
    static final String CACHE_KEY_GET_TAGS = "CACHE_KEY_GET_TAGS";
    static final String CACHE_KEY_REMOTE_PARAMS = "CACHE_KEY_REMOTE_PARAMS";
    private static final int GET_TIMEOUT = 60000;
    private static final String OS_ACCEPT_HEADER = "application/vnd.onesignal.v1+json";
    private static final String OS_API_VERSION = "1";
    private static final int THREAD_ID = 10000;
    private static final int TIMEOUT = 120000;

    private static int getThreadTimeout(int i) {
        return i + 5000;
    }

    static abstract class ResponseHandler {
        /* access modifiers changed from: package-private */
        public void onFailure(int i, String str, Throwable th) {
        }

        /* access modifiers changed from: package-private */
        public void onSuccess(String str) {
        }

        ResponseHandler() {
        }
    }

    OneSignalRestClient() {
    }

    public static void put(final String str, final JSONObject jSONObject, final ResponseHandler responseHandler) {
        new Thread(new Runnable() {
            public void run() {
                OneSignalRestClient.makeRequest(str, "PUT", jSONObject, responseHandler, OneSignalRestClient.TIMEOUT, (String) null);
            }
        }, "OS_REST_ASYNC_PUT").start();
    }

    public static void post(final String str, final JSONObject jSONObject, final ResponseHandler responseHandler) {
        new Thread(new Runnable() {
            public void run() {
                OneSignalRestClient.makeRequest(str, "POST", jSONObject, responseHandler, OneSignalRestClient.TIMEOUT, (String) null);
            }
        }, "OS_REST_ASYNC_POST").start();
    }

    public static void get(final String str, final ResponseHandler responseHandler, @NonNull final String str2) {
        new Thread(new Runnable() {
            public void run() {
                OneSignalRestClient.makeRequest(str, (String) null, (JSONObject) null, responseHandler, OneSignalRestClient.GET_TIMEOUT, str2);
            }
        }, "OS_REST_ASYNC_GET").start();
    }

    public static void getSync(String str, ResponseHandler responseHandler, @NonNull String str2) {
        makeRequest(str, (String) null, (JSONObject) null, responseHandler, GET_TIMEOUT, str2);
    }

    public static void putSync(String str, JSONObject jSONObject, ResponseHandler responseHandler) {
        makeRequest(str, "PUT", jSONObject, responseHandler, TIMEOUT, (String) null);
    }

    public static void postSync(String str, JSONObject jSONObject, ResponseHandler responseHandler) {
        makeRequest(str, "POST", jSONObject, responseHandler, TIMEOUT, (String) null);
    }

    /* access modifiers changed from: private */
    public static void makeRequest(String str, String str2, JSONObject jSONObject, ResponseHandler responseHandler, int i, String str3) {
        if (str2 == null || !OneSignal.shouldLogUserPrivacyConsentErrorMessageForMethodName((String) null)) {
            Thread[] threadArr = new Thread[1];
            final Thread[] threadArr2 = threadArr;
            final String str4 = str;
            final String str5 = str2;
            final JSONObject jSONObject2 = jSONObject;
            final ResponseHandler responseHandler2 = responseHandler;
            final int i2 = i;
            final String str6 = str3;
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    threadArr2[0] = OneSignalRestClient.startHTTPConnection(str4, str5, jSONObject2, responseHandler2, i2, str6);
                }
            }, "OS_HTTPConnection");
            thread.start();
            try {
                thread.join((long) getThreadTimeout(i));
                if (thread.getState() != Thread.State.TERMINATED) {
                    thread.interrupt();
                }
                if (threadArr[0] != null) {
                    threadArr[0].join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x025e, code lost:
        if (r2 != null) goto L_0x0260;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0260, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x02b5, code lost:
        if (r2 != null) goto L_0x0260;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x02b8, code lost:
        return r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0272 A[Catch:{ all -> 0x02b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x02bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Thread startHTTPConnection(java.lang.String r5, java.lang.String r6, org.json.JSONObject r7, com.onesignal.OneSignalRestClient.ResponseHandler r8, int r9, @androidx.annotation.Nullable java.lang.String r10) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 < r1) goto L_0x000b
            r0 = 10000(0x2710, float:1.4013E-41)
            android.net.TrafficStats.setThreadStatsTag(r0)
        L_0x000b:
            r0 = 0
            r1 = -1
            com.onesignal.OneSignal$LOG_LEVEL r2 = com.onesignal.OneSignal.LOG_LEVEL.DEBUG     // Catch:{ Throwable -> 0x026b, all -> 0x0268 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x026b, all -> 0x0268 }
            r3.<init>()     // Catch:{ Throwable -> 0x026b, all -> 0x0268 }
            java.lang.String r4 = "OneSignalRestClient: Making request to: https://api.onesignal.com/"
            r3.append(r4)     // Catch:{ Throwable -> 0x026b, all -> 0x0268 }
            r3.append(r5)     // Catch:{ Throwable -> 0x026b, all -> 0x0268 }
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x026b, all -> 0x0268 }
            com.onesignal.OneSignal.Log(r2, r3)     // Catch:{ Throwable -> 0x026b, all -> 0x0268 }
            java.net.HttpURLConnection r2 = newHttpURLConnection(r5)     // Catch:{ Throwable -> 0x026b, all -> 0x0268 }
            r3 = 0
            r2.setUseCaches(r3)     // Catch:{ Throwable -> 0x0266 }
            r2.setConnectTimeout(r9)     // Catch:{ Throwable -> 0x0266 }
            r2.setReadTimeout(r9)     // Catch:{ Throwable -> 0x0266 }
            java.lang.String r9 = "SDK-Version"
            java.lang.String r3 = "onesignal/android/031501"
            r2.setRequestProperty(r9, r3)     // Catch:{ Throwable -> 0x0266 }
            java.lang.String r9 = "Accept"
            java.lang.String r3 = "application/vnd.onesignal.v1+json"
            r2.setRequestProperty(r9, r3)     // Catch:{ Throwable -> 0x0266 }
            r9 = 1
            if (r7 == 0) goto L_0x0045
            r2.setDoInput(r9)     // Catch:{ Throwable -> 0x0266 }
        L_0x0045:
            if (r6 == 0) goto L_0x0054
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/json; charset=UTF-8"
            r2.setRequestProperty(r3, r4)     // Catch:{ Throwable -> 0x0266 }
            r2.setRequestMethod(r6)     // Catch:{ Throwable -> 0x0266 }
            r2.setDoOutput(r9)     // Catch:{ Throwable -> 0x0266 }
        L_0x0054:
            if (r7 == 0) goto L_0x0089
            java.lang.String r7 = r7.toString()     // Catch:{ Throwable -> 0x0266 }
            com.onesignal.OneSignal$LOG_LEVEL r9 = com.onesignal.OneSignal.LOG_LEVEL.DEBUG     // Catch:{ Throwable -> 0x0266 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0266 }
            r3.<init>()     // Catch:{ Throwable -> 0x0266 }
            java.lang.String r4 = "OneSignalRestClient: "
            r3.append(r4)     // Catch:{ Throwable -> 0x0266 }
            r3.append(r6)     // Catch:{ Throwable -> 0x0266 }
            java.lang.String r4 = " SEND JSON: "
            r3.append(r4)     // Catch:{ Throwable -> 0x0266 }
            r3.append(r7)     // Catch:{ Throwable -> 0x0266 }
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x0266 }
            com.onesignal.OneSignal.Log(r9, r3)     // Catch:{ Throwable -> 0x0266 }
            java.lang.String r9 = "UTF-8"
            byte[] r7 = r7.getBytes(r9)     // Catch:{ Throwable -> 0x0266 }
            int r9 = r7.length     // Catch:{ Throwable -> 0x0266 }
            r2.setFixedLengthStreamingMode(r9)     // Catch:{ Throwable -> 0x0266 }
            java.io.OutputStream r9 = r2.getOutputStream()     // Catch:{ Throwable -> 0x0266 }
            r9.write(r7)     // Catch:{ Throwable -> 0x0266 }
        L_0x0089:
            if (r10 == 0) goto L_0x00bf
            java.lang.String r7 = com.onesignal.OneSignalPrefs.PREFS_ONESIGNAL     // Catch:{ Throwable -> 0x0266 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0266 }
            r9.<init>()     // Catch:{ Throwable -> 0x0266 }
            java.lang.String r3 = "PREFS_OS_ETAG_PREFIX_"
            r9.append(r3)     // Catch:{ Throwable -> 0x0266 }
            r9.append(r10)     // Catch:{ Throwable -> 0x0266 }
            java.lang.String r9 = r9.toString()     // Catch:{ Throwable -> 0x0266 }
            java.lang.String r7 = com.onesignal.OneSignalPrefs.getString(r7, r9, r0)     // Catch:{ Throwable -> 0x0266 }
            if (r7 == 0) goto L_0x00bf
            java.lang.String r9 = "if-none-match"
            r2.setRequestProperty(r9, r7)     // Catch:{ Throwable -> 0x0266 }
            com.onesignal.OneSignal$LOG_LEVEL r9 = com.onesignal.OneSignal.LOG_LEVEL.DEBUG     // Catch:{ Throwable -> 0x0266 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0266 }
            r3.<init>()     // Catch:{ Throwable -> 0x0266 }
            java.lang.String r4 = "OneSignalRestClient: Adding header if-none-match: "
            r3.append(r4)     // Catch:{ Throwable -> 0x0266 }
            r3.append(r7)     // Catch:{ Throwable -> 0x0266 }
            java.lang.String r7 = r3.toString()     // Catch:{ Throwable -> 0x0266 }
            com.onesignal.OneSignal.Log(r9, r7)     // Catch:{ Throwable -> 0x0266 }
        L_0x00bf:
            int r7 = r2.getResponseCode()     // Catch:{ Throwable -> 0x0266 }
            com.onesignal.OneSignal$LOG_LEVEL r9 = com.onesignal.OneSignal.LOG_LEVEL.VERBOSE     // Catch:{ Throwable -> 0x0264 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0264 }
            r1.<init>()     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r3 = "OneSignalRestClient: After con.getResponseCode to: https://api.onesignal.com/"
            r1.append(r3)     // Catch:{ Throwable -> 0x0264 }
            r1.append(r5)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0264 }
            com.onesignal.OneSignal.Log(r9, r1)     // Catch:{ Throwable -> 0x0264 }
            r9 = 200(0xc8, float:2.8E-43)
            if (r7 == r9) goto L_0x01ae
            r9 = 202(0xca, float:2.83E-43)
            if (r7 == r9) goto L_0x01ae
            r9 = 304(0x130, float:4.26E-43)
            if (r7 == r9) goto L_0x016d
            com.onesignal.OneSignal$LOG_LEVEL r9 = com.onesignal.OneSignal.LOG_LEVEL.DEBUG     // Catch:{ Throwable -> 0x0264 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0264 }
            r10.<init>()     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r1 = "OneSignalRestClient: Failed request to: https://api.onesignal.com/"
            r10.append(r1)     // Catch:{ Throwable -> 0x0264 }
            r10.append(r5)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r5 = r10.toString()     // Catch:{ Throwable -> 0x0264 }
            com.onesignal.OneSignal.Log(r9, r5)     // Catch:{ Throwable -> 0x0264 }
            java.io.InputStream r5 = r2.getErrorStream()     // Catch:{ Throwable -> 0x0264 }
            if (r5 != 0) goto L_0x0105
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ Throwable -> 0x0264 }
        L_0x0105:
            if (r5 == 0) goto L_0x0143
            java.util.Scanner r9 = new java.util.Scanner     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r10 = "UTF-8"
            r9.<init>(r5, r10)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r5 = "\\A"
            java.util.Scanner r5 = r9.useDelimiter(r5)     // Catch:{ Throwable -> 0x0264 }
            boolean r5 = r5.hasNext()     // Catch:{ Throwable -> 0x0264 }
            if (r5 == 0) goto L_0x011f
            java.lang.String r5 = r9.next()     // Catch:{ Throwable -> 0x0264 }
            goto L_0x0121
        L_0x011f:
            java.lang.String r5 = ""
        L_0x0121:
            r9.close()     // Catch:{ Throwable -> 0x0264 }
            com.onesignal.OneSignal$LOG_LEVEL r9 = com.onesignal.OneSignal.LOG_LEVEL.WARN     // Catch:{ Throwable -> 0x0264 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0264 }
            r10.<init>()     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r1 = "OneSignalRestClient: "
            r10.append(r1)     // Catch:{ Throwable -> 0x0264 }
            r10.append(r6)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r1 = " RECEIVED JSON: "
            r10.append(r1)     // Catch:{ Throwable -> 0x0264 }
            r10.append(r5)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r10 = r10.toString()     // Catch:{ Throwable -> 0x0264 }
            com.onesignal.OneSignal.Log(r9, r10)     // Catch:{ Throwable -> 0x0264 }
            goto L_0x0167
        L_0x0143:
            com.onesignal.OneSignal$LOG_LEVEL r5 = com.onesignal.OneSignal.LOG_LEVEL.WARN     // Catch:{ Throwable -> 0x0264 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0264 }
            r9.<init>()     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r10 = "OneSignalRestClient: "
            r9.append(r10)     // Catch:{ Throwable -> 0x0264 }
            r9.append(r6)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r10 = " HTTP Code: "
            r9.append(r10)     // Catch:{ Throwable -> 0x0264 }
            r9.append(r7)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r10 = " No response body!"
            r9.append(r10)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r9 = r9.toString()     // Catch:{ Throwable -> 0x0264 }
            com.onesignal.OneSignal.Log(r5, r9)     // Catch:{ Throwable -> 0x0264 }
            r5 = r0
        L_0x0167:
            java.lang.Thread r5 = callResponseHandlerOnFailure(r8, r7, r5, r0)     // Catch:{ Throwable -> 0x0264 }
            goto L_0x025e
        L_0x016d:
            java.lang.String r5 = com.onesignal.OneSignalPrefs.PREFS_ONESIGNAL     // Catch:{ Throwable -> 0x0264 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0264 }
            r9.<init>()     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r1 = "PREFS_OS_HTTP_CACHE_PREFIX_"
            r9.append(r1)     // Catch:{ Throwable -> 0x0264 }
            r9.append(r10)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r9 = r9.toString()     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r5 = com.onesignal.OneSignalPrefs.getString(r5, r9, r0)     // Catch:{ Throwable -> 0x0264 }
            com.onesignal.OneSignal$LOG_LEVEL r9 = com.onesignal.OneSignal.LOG_LEVEL.DEBUG     // Catch:{ Throwable -> 0x0264 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0264 }
            r10.<init>()     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r1 = "OneSignalRestClient: "
            r10.append(r1)     // Catch:{ Throwable -> 0x0264 }
            if (r6 != 0) goto L_0x0195
            java.lang.String r1 = "GET"
            goto L_0x0196
        L_0x0195:
            r1 = r6
        L_0x0196:
            r10.append(r1)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r1 = " - Using Cached response due to 304: "
            r10.append(r1)     // Catch:{ Throwable -> 0x0264 }
            r10.append(r5)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r10 = r10.toString()     // Catch:{ Throwable -> 0x0264 }
            com.onesignal.OneSignal.Log(r9, r10)     // Catch:{ Throwable -> 0x0264 }
            java.lang.Thread r5 = callResponseHandlerOnSuccess(r8, r5)     // Catch:{ Throwable -> 0x0264 }
            goto L_0x025e
        L_0x01ae:
            com.onesignal.OneSignal$LOG_LEVEL r9 = com.onesignal.OneSignal.LOG_LEVEL.DEBUG     // Catch:{ Throwable -> 0x0264 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0264 }
            r1.<init>()     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r3 = "OneSignalRestClient: Successfully finished request to: https://api.onesignal.com/"
            r1.append(r3)     // Catch:{ Throwable -> 0x0264 }
            r1.append(r5)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r5 = r1.toString()     // Catch:{ Throwable -> 0x0264 }
            com.onesignal.OneSignal.Log(r9, r5)     // Catch:{ Throwable -> 0x0264 }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ Throwable -> 0x0264 }
            java.util.Scanner r9 = new java.util.Scanner     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r1 = "UTF-8"
            r9.<init>(r5, r1)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r5 = "\\A"
            java.util.Scanner r5 = r9.useDelimiter(r5)     // Catch:{ Throwable -> 0x0264 }
            boolean r5 = r5.hasNext()     // Catch:{ Throwable -> 0x0264 }
            if (r5 == 0) goto L_0x01e0
            java.lang.String r5 = r9.next()     // Catch:{ Throwable -> 0x0264 }
            goto L_0x01e2
        L_0x01e0:
            java.lang.String r5 = ""
        L_0x01e2:
            r9.close()     // Catch:{ Throwable -> 0x0264 }
            com.onesignal.OneSignal$LOG_LEVEL r9 = com.onesignal.OneSignal.LOG_LEVEL.DEBUG     // Catch:{ Throwable -> 0x0264 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0264 }
            r1.<init>()     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r3 = "OneSignalRestClient: "
            r1.append(r3)     // Catch:{ Throwable -> 0x0264 }
            if (r6 != 0) goto L_0x01f6
            java.lang.String r3 = "GET"
            goto L_0x01f7
        L_0x01f6:
            r3 = r6
        L_0x01f7:
            r1.append(r3)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r3 = " RECEIVED JSON: "
            r1.append(r3)     // Catch:{ Throwable -> 0x0264 }
            r1.append(r5)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0264 }
            com.onesignal.OneSignal.Log(r9, r1)     // Catch:{ Throwable -> 0x0264 }
            if (r10 == 0) goto L_0x025a
            java.lang.String r9 = "etag"
            java.lang.String r9 = r2.getHeaderField(r9)     // Catch:{ Throwable -> 0x0264 }
            if (r9 == 0) goto L_0x025a
            com.onesignal.OneSignal$LOG_LEVEL r1 = com.onesignal.OneSignal.LOG_LEVEL.DEBUG     // Catch:{ Throwable -> 0x0264 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0264 }
            r3.<init>()     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r4 = "OneSignalRestClient: Response has etag of "
            r3.append(r4)     // Catch:{ Throwable -> 0x0264 }
            r3.append(r9)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r4 = " so caching the response."
            r3.append(r4)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x0264 }
            com.onesignal.OneSignal.Log(r1, r3)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r1 = com.onesignal.OneSignalPrefs.PREFS_ONESIGNAL     // Catch:{ Throwable -> 0x0264 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0264 }
            r3.<init>()     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r4 = "PREFS_OS_ETAG_PREFIX_"
            r3.append(r4)     // Catch:{ Throwable -> 0x0264 }
            r3.append(r10)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x0264 }
            com.onesignal.OneSignalPrefs.saveString(r1, r3, r9)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r9 = com.onesignal.OneSignalPrefs.PREFS_ONESIGNAL     // Catch:{ Throwable -> 0x0264 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0264 }
            r1.<init>()     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r3 = "PREFS_OS_HTTP_CACHE_PREFIX_"
            r1.append(r3)     // Catch:{ Throwable -> 0x0264 }
            r1.append(r10)     // Catch:{ Throwable -> 0x0264 }
            java.lang.String r10 = r1.toString()     // Catch:{ Throwable -> 0x0264 }
            com.onesignal.OneSignalPrefs.saveString(r9, r10, r5)     // Catch:{ Throwable -> 0x0264 }
        L_0x025a:
            java.lang.Thread r5 = callResponseHandlerOnSuccess(r8, r5)     // Catch:{ Throwable -> 0x0264 }
        L_0x025e:
            if (r2 == 0) goto L_0x02b8
        L_0x0260:
            r2.disconnect()
            goto L_0x02b8
        L_0x0264:
            r5 = move-exception
            goto L_0x026e
        L_0x0266:
            r5 = move-exception
            goto L_0x026d
        L_0x0268:
            r5 = move-exception
            r2 = r0
            goto L_0x02ba
        L_0x026b:
            r5 = move-exception
            r2 = r0
        L_0x026d:
            r7 = -1
        L_0x026e:
            boolean r9 = r5 instanceof java.net.ConnectException     // Catch:{ all -> 0x02b9 }
            if (r9 != 0) goto L_0x0293
            boolean r9 = r5 instanceof java.net.UnknownHostException     // Catch:{ all -> 0x02b9 }
            if (r9 == 0) goto L_0x0277
            goto L_0x0293
        L_0x0277:
            com.onesignal.OneSignal$LOG_LEVEL r9 = com.onesignal.OneSignal.LOG_LEVEL.WARN     // Catch:{ all -> 0x02b9 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x02b9 }
            r10.<init>()     // Catch:{ all -> 0x02b9 }
            java.lang.String r1 = "OneSignalRestClient: "
            r10.append(r1)     // Catch:{ all -> 0x02b9 }
            r10.append(r6)     // Catch:{ all -> 0x02b9 }
            java.lang.String r6 = " Error thrown from network stack. "
            r10.append(r6)     // Catch:{ all -> 0x02b9 }
            java.lang.String r6 = r10.toString()     // Catch:{ all -> 0x02b9 }
            com.onesignal.OneSignal.Log(r9, r6, r5)     // Catch:{ all -> 0x02b9 }
            goto L_0x02b1
        L_0x0293:
            com.onesignal.OneSignal$LOG_LEVEL r6 = com.onesignal.OneSignal.LOG_LEVEL.INFO     // Catch:{ all -> 0x02b9 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x02b9 }
            r9.<init>()     // Catch:{ all -> 0x02b9 }
            java.lang.String r10 = "OneSignalRestClient: Could not send last request, device is offline. Throwable: "
            r9.append(r10)     // Catch:{ all -> 0x02b9 }
            java.lang.Class r10 = r5.getClass()     // Catch:{ all -> 0x02b9 }
            java.lang.String r10 = r10.getName()     // Catch:{ all -> 0x02b9 }
            r9.append(r10)     // Catch:{ all -> 0x02b9 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x02b9 }
            com.onesignal.OneSignal.Log(r6, r9)     // Catch:{ all -> 0x02b9 }
        L_0x02b1:
            java.lang.Thread r5 = callResponseHandlerOnFailure(r8, r7, r0, r5)     // Catch:{ all -> 0x02b9 }
            if (r2 == 0) goto L_0x02b8
            goto L_0x0260
        L_0x02b8:
            return r5
        L_0x02b9:
            r5 = move-exception
        L_0x02ba:
            if (r2 == 0) goto L_0x02bf
            r2.disconnect()
        L_0x02bf:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OneSignalRestClient.startHTTPConnection(java.lang.String, java.lang.String, org.json.JSONObject, com.onesignal.OneSignalRestClient$ResponseHandler, int, java.lang.String):java.lang.Thread");
    }

    private static Thread callResponseHandlerOnSuccess(final ResponseHandler responseHandler, final String str) {
        if (responseHandler == null) {
            return null;
        }
        Thread thread = new Thread(new Runnable() {
            public void run() {
                responseHandler.onSuccess(str);
            }
        }, "OS_REST_SUCCESS_CALLBACK");
        thread.start();
        return thread;
    }

    private static Thread callResponseHandlerOnFailure(final ResponseHandler responseHandler, final int i, final String str, final Throwable th) {
        if (responseHandler == null) {
            return null;
        }
        Thread thread = new Thread(new Runnable() {
            public void run() {
                responseHandler.onFailure(i, str, th);
            }
        }, "OS_REST_FAILURE_CALLBACK");
        thread.start();
        return thread;
    }

    private static HttpURLConnection newHttpURLConnection(String str) throws IOException {
        return (HttpURLConnection) new URL(BASE_URL + str).openConnection();
    }
}
