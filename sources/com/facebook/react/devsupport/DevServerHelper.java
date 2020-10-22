package com.facebook.react.devsupport;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.C1129R;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.devsupport.BundleDownloader;
import com.facebook.react.devsupport.InspectorPackagerConnection;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.FileIoHandler;
import com.facebook.react.packagerconnection.JSPackagerClient;
import com.facebook.react.packagerconnection.NotificationOnlyHandler;
import com.facebook.react.packagerconnection.ReconnectingWebSocket;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.packagerconnection.RequestOnlyHandler;
import com.facebook.react.packagerconnection.Responder;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.C3873Response;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DevServerHelper {
    private static final String DEBUGGER_MSG_DISABLE = "{ \"id\":1,\"method\":\"Debugger.disable\" }";
    private static final int HTTP_CONNECT_TIMEOUT_MS = 5000;
    private static final String PACKAGER_OK_STATUS = "packager-status:running";
    public static final String RELOAD_APP_EXTRA_JS_PROXY = "jsproxy";
    private final BundleDownloader mBundleDownloader = new BundleDownloader(this.mClient);
    /* access modifiers changed from: private */
    public InspectorPackagerConnection.BundleStatusProvider mBundlerStatusProvider;
    private final OkHttpClient mClient = new OkHttpClient.Builder().connectTimeout(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS, TimeUnit.MILLISECONDS).readTimeout(0, TimeUnit.MILLISECONDS).writeTimeout(0, TimeUnit.MILLISECONDS).build();
    /* access modifiers changed from: private */
    @Nullable
    public InspectorPackagerConnection mInspectorPackagerConnection;
    /* access modifiers changed from: private */
    public final String mPackageName;
    /* access modifiers changed from: private */
    @Nullable
    public JSPackagerClient mPackagerClient;
    /* access modifiers changed from: private */
    public final DevInternalSettings mSettings;

    public interface OnServerContentChangeListener {
        void onServerContentChanged();
    }

    public interface PackagerCommandListener {
        @Nullable
        Map<String, RequestHandler> customCommandHandlers();

        void onCaptureHeapCommand(Responder responder);

        void onPackagerConnected();

        void onPackagerDevMenuCommand();

        void onPackagerDisconnected();

        void onPackagerReloadCommand();
    }

    public interface PackagerCustomCommandProvider {
    }

    public interface SymbolicationListener {
        void onSymbolicationComplete(@Nullable Iterable<StackFrame> iterable);
    }

    private enum BundleType {
        BUNDLE("bundle"),
        MAP("map");
        
        private final String mTypeID;

        private BundleType(String str) {
            this.mTypeID = str;
        }

        public String typeID() {
            return this.mTypeID;
        }
    }

    public DevServerHelper(DevInternalSettings devInternalSettings, String str, InspectorPackagerConnection.BundleStatusProvider bundleStatusProvider) {
        this.mSettings = devInternalSettings;
        this.mBundlerStatusProvider = bundleStatusProvider;
        this.mPackageName = str;
    }

    public void openPackagerConnection(final String str, final PackagerCommandListener packagerCommandListener) {
        if (this.mPackagerClient != null) {
            FLog.m102w(ReactConstants.TAG, "Packager connection already open, nooping.");
        } else {
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("reload", new NotificationOnlyHandler() {
                        public void onNotification(@Nullable Object obj) {
                            packagerCommandListener.onPackagerReloadCommand();
                        }
                    });
                    hashMap.put("devMenu", new NotificationOnlyHandler() {
                        public void onNotification(@Nullable Object obj) {
                            packagerCommandListener.onPackagerDevMenuCommand();
                        }
                    });
                    hashMap.put("captureHeap", new RequestOnlyHandler() {
                        public void onRequest(@Nullable Object obj, Responder responder) {
                            packagerCommandListener.onCaptureHeapCommand(responder);
                        }
                    });
                    Map<String, RequestHandler> customCommandHandlers = packagerCommandListener.customCommandHandlers();
                    if (customCommandHandlers != null) {
                        hashMap.putAll(customCommandHandlers);
                    }
                    hashMap.putAll(new FileIoHandler().handlers());
                    JSPackagerClient unused = DevServerHelper.this.mPackagerClient = new JSPackagerClient(str, DevServerHelper.this.mSettings.getPackagerConnectionSettings(), hashMap, new ReconnectingWebSocket.ConnectionCallback() {
                        public void onConnected() {
                            packagerCommandListener.onPackagerConnected();
                        }

                        public void onDisconnected() {
                            packagerCommandListener.onPackagerDisconnected();
                        }
                    });
                    DevServerHelper.this.mPackagerClient.init();
                    return null;
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void closePackagerConnection() {
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                if (DevServerHelper.this.mPackagerClient != null) {
                    DevServerHelper.this.mPackagerClient.close();
                    JSPackagerClient unused = DevServerHelper.this.mPackagerClient = null;
                }
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void openInspectorConnection() {
        if (this.mInspectorPackagerConnection != null) {
            FLog.m102w(ReactConstants.TAG, "Inspector connection already open, nooping.");
        } else {
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    InspectorPackagerConnection unused = DevServerHelper.this.mInspectorPackagerConnection = new InspectorPackagerConnection(DevServerHelper.this.getInspectorDeviceUrl(), DevServerHelper.this.mPackageName, DevServerHelper.this.mBundlerStatusProvider);
                    DevServerHelper.this.mInspectorPackagerConnection.connect();
                    return null;
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void disableDebugger() {
        if (this.mInspectorPackagerConnection != null) {
            this.mInspectorPackagerConnection.sendEventToAllConnections(DEBUGGER_MSG_DISABLE);
        }
    }

    public void closeInspectorConnection() {
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                if (DevServerHelper.this.mInspectorPackagerConnection != null) {
                    DevServerHelper.this.mInspectorPackagerConnection.closeQuietly();
                    InspectorPackagerConnection unused = DevServerHelper.this.mInspectorPackagerConnection = null;
                }
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void attachDebugger(final Context context, final String str) {
        new AsyncTask<Void, String, Boolean>() {
            /* access modifiers changed from: protected */
            public Boolean doInBackground(Void... voidArr) {
                return Boolean.valueOf(doSync());
            }

            public boolean doSync() {
                try {
                    new OkHttpClient().newCall(new Request.Builder().url(DevServerHelper.this.getInspectorAttachUrl(context, str)).build()).execute();
                    return true;
                } catch (IOException e) {
                    FLog.m63e(ReactConstants.TAG, "Failed to send attach request to Inspector", (Throwable) e);
                    return false;
                }
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Boolean bool) {
                if (!bool.booleanValue()) {
                    Toast.makeText(context, context.getString(C1129R.string.catalyst_debug_nuclide_error), 1).show();
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void symbolicateStackTrace(Iterable<StackFrame> iterable, final SymbolicationListener symbolicationListener) {
        try {
            String createSymbolicateURL = createSymbolicateURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
            JSONArray jSONArray = new JSONArray();
            for (StackFrame json : iterable) {
                jSONArray.put(json.toJSON());
            }
            ((Call) Assertions.assertNotNull(this.mClient.newCall(new Request.Builder().url(createSymbolicateURL).post(RequestBody.create(MediaType.parse("application/json"), new JSONObject().put("stack", jSONArray).toString())).build()))).enqueue(new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    FLog.m102w(ReactConstants.TAG, "Got IOException when attempting symbolicate stack trace: " + iOException.getMessage());
                    symbolicationListener.onSymbolicationComplete((Iterable<StackFrame>) null);
                }

                public void onResponse(Call call, C3873Response response) throws IOException {
                    try {
                        symbolicationListener.onSymbolicationComplete(Arrays.asList(StackTraceHelper.convertJsStackTrace(new JSONObject(response.body().string()).getJSONArray("stack"))));
                    } catch (JSONException unused) {
                        symbolicationListener.onSymbolicationComplete((Iterable<StackFrame>) null);
                    }
                }
            });
        } catch (JSONException e) {
            FLog.m102w(ReactConstants.TAG, "Got JSONException when attempting symbolicate stack trace: " + e.getMessage());
        }
    }

    public void openStackFrameCall(StackFrame stackFrame) {
        ((Call) Assertions.assertNotNull(this.mClient.newCall(new Request.Builder().url(createOpenStackFrameURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost())).post(RequestBody.create(MediaType.parse("application/json"), stackFrame.toJSON().toString())).build()))).enqueue(new Callback() {
            public void onResponse(Call call, C3873Response response) throws IOException {
            }

            public void onFailure(Call call, IOException iOException) {
                FLog.m102w(ReactConstants.TAG, "Got IOException when attempting to open stack frame: " + iOException.getMessage());
            }
        });
    }

    public String getWebsocketProxyURL() {
        return String.format(Locale.US, "ws://%s/debugger-proxy?role=client", new Object[]{this.mSettings.getPackagerConnectionSettings().getDebugServerHost()});
    }

    /* access modifiers changed from: private */
    public String getInspectorDeviceUrl() {
        return String.format(Locale.US, "http://%s/inspector/device?name=%s&app=%s", new Object[]{this.mSettings.getPackagerConnectionSettings().getInspectorServerHost(), AndroidInfoHelpers.getFriendlyDeviceName(), this.mPackageName});
    }

    /* access modifiers changed from: private */
    public String getInspectorAttachUrl(Context context, String str) {
        return String.format(Locale.US, "http://%s/nuclide/attach-debugger-nuclide?title=%s&app=%s&device=%s", new Object[]{AndroidInfoHelpers.getServerHost(context), str, this.mPackageName, AndroidInfoHelpers.getFriendlyDeviceName()});
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleDownloader.BundleInfo bundleInfo) {
        this.mBundleDownloader.downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo);
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleDownloader.BundleInfo bundleInfo, Request.Builder builder) {
        this.mBundleDownloader.downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo, builder);
    }

    private String getHostForJSProxy() {
        String str = (String) Assertions.assertNotNull(this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
        int lastIndexOf = str.lastIndexOf(58);
        if (lastIndexOf <= -1) {
            return AndroidInfoHelpers.DEVICE_LOCALHOST;
        }
        return AndroidInfoHelpers.DEVICE_LOCALHOST + str.substring(lastIndexOf);
    }

    private boolean getDevMode() {
        return this.mSettings.isJSDevModeEnabled();
    }

    private boolean getJSMinifyMode() {
        return this.mSettings.isJSMinifyEnabled();
    }

    private String createBundleURL(String str, BundleType bundleType, String str2) {
        return String.format(Locale.US, "http://%s/%s.%s?platform=android&dev=%s&minify=%s", new Object[]{str2, str, bundleType.typeID(), Boolean.valueOf(getDevMode()), Boolean.valueOf(getJSMinifyMode())});
    }

    private String createBundleURL(String str, BundleType bundleType) {
        return createBundleURL(str, bundleType, this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    }

    private static String createResourceURL(String str, String str2) {
        return String.format(Locale.US, "http://%s/%s", new Object[]{str, str2});
    }

    private static String createSymbolicateURL(String str) {
        return String.format(Locale.US, "http://%s/symbolicate", new Object[]{str});
    }

    private static String createOpenStackFrameURL(String str) {
        return String.format(Locale.US, "http://%s/open-stack-frame", new Object[]{str});
    }

    public String getDevServerBundleURL(String str) {
        return createBundleURL(str, BundleType.BUNDLE, this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    }

    public void isPackagerRunning(final PackagerStatusCallback packagerStatusCallback) {
        this.mClient.newCall(new Request.Builder().url(createPackagerStatusURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost())).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                FLog.m102w(ReactConstants.TAG, "The packager does not seem to be running as we got an IOException requesting its status: " + iOException.getMessage());
                packagerStatusCallback.onPackagerStatusFetched(false);
            }

            public void onResponse(Call call, C3873Response response) throws IOException {
                if (!response.isSuccessful()) {
                    FLog.m62e(ReactConstants.TAG, "Got non-success http code from packager when requesting status: " + response.code());
                    packagerStatusCallback.onPackagerStatusFetched(false);
                    return;
                }
                ResponseBody body = response.body();
                if (body == null) {
                    FLog.m62e(ReactConstants.TAG, "Got null body response from packager when requesting status");
                    packagerStatusCallback.onPackagerStatusFetched(false);
                    return;
                }
                String string = body.string();
                if (!DevServerHelper.PACKAGER_OK_STATUS.equals(string)) {
                    FLog.m62e(ReactConstants.TAG, "Got unexpected response from packager when requesting status: " + string);
                    packagerStatusCallback.onPackagerStatusFetched(false);
                    return;
                }
                packagerStatusCallback.onPackagerStatusFetched(true);
            }
        });
    }

    private static String createPackagerStatusURL(String str) {
        return String.format(Locale.US, "http://%s/status", new Object[]{str});
    }

    private String createLaunchJSDevtoolsCommandUrl() {
        return String.format(Locale.US, "http://%s/launch-js-devtools", new Object[]{this.mSettings.getPackagerConnectionSettings().getDebugServerHost()});
    }

    public void launchJSDevtools() {
        this.mClient.newCall(new Request.Builder().url(createLaunchJSDevtoolsCommandUrl()).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
            }

            public void onResponse(Call call, C3873Response response) throws IOException {
            }
        });
    }

    public String getSourceMapUrl(String str) {
        return createBundleURL(str, BundleType.MAP);
    }

    public String getSourceUrl(String str) {
        return createBundleURL(str, BundleType.BUNDLE);
    }

    public String getJSBundleURLForRemoteDebugging(String str) {
        return createBundleURL(str, BundleType.BUNDLE, getHostForJSProxy());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005a, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005b, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0060, code lost:
        r6 = r3;
        r3 = r2;
        r2 = r6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056 A[SYNTHETIC, Splitter:B:25:0x0056] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.File downloadBundleResourceFromUrlSync(java.lang.String r8, java.io.File r9) {
        /*
            r7 = this;
            com.facebook.react.devsupport.DevInternalSettings r0 = r7.mSettings
            com.facebook.react.packagerconnection.PackagerConnectionSettings r0 = r0.getPackagerConnectionSettings()
            java.lang.String r0 = r0.getDebugServerHost()
            java.lang.String r0 = createResourceURL(r0, r8)
            okhttp3.Request$Builder r1 = new okhttp3.Request$Builder
            r1.<init>()
            okhttp3.Request$Builder r0 = r1.url((java.lang.String) r0)
            okhttp3.Request r0 = r0.build()
            r1 = 0
            okhttp3.OkHttpClient r2 = r7.mClient     // Catch:{ Exception -> 0x0074 }
            okhttp3.Call r0 = r2.newCall(r0)     // Catch:{ Exception -> 0x0074 }
            okhttp3.Response r0 = r0.execute()     // Catch:{ Exception -> 0x0074 }
            boolean r2 = r0.isSuccessful()     // Catch:{ Throwable -> 0x005d, all -> 0x005a }
            if (r2 != 0) goto L_0x0032
            if (r0 == 0) goto L_0x0031
            r0.close()     // Catch:{ Exception -> 0x0074 }
        L_0x0031:
            return r1
        L_0x0032:
            okio.Sink r2 = okio.Okio.sink((java.io.File) r9)     // Catch:{ all -> 0x0052 }
            okhttp3.ResponseBody r3 = r0.body()     // Catch:{ all -> 0x0050 }
            okio.BufferedSource r3 = r3.source()     // Catch:{ all -> 0x0050 }
            okio.BufferedSource r3 = okio.Okio.buffer((okio.Source) r3)     // Catch:{ all -> 0x0050 }
            r3.readAll(r2)     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x004a
            r2.close()     // Catch:{ Throwable -> 0x005d, all -> 0x005a }
        L_0x004a:
            if (r0 == 0) goto L_0x004f
            r0.close()     // Catch:{ Exception -> 0x0074 }
        L_0x004f:
            return r9
        L_0x0050:
            r3 = move-exception
            goto L_0x0054
        L_0x0052:
            r3 = move-exception
            r2 = r1
        L_0x0054:
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ Throwable -> 0x005d, all -> 0x005a }
        L_0x0059:
            throw r3     // Catch:{ Throwable -> 0x005d, all -> 0x005a }
        L_0x005a:
            r2 = move-exception
            r3 = r1
            goto L_0x0063
        L_0x005d:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x005f }
        L_0x005f:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L_0x0063:
            if (r0 == 0) goto L_0x0073
            if (r3 == 0) goto L_0x0070
            r0.close()     // Catch:{ Throwable -> 0x006b }
            goto L_0x0073
        L_0x006b:
            r0 = move-exception
            r3.addSuppressed(r0)     // Catch:{ Exception -> 0x0074 }
            goto L_0x0073
        L_0x0070:
            r0.close()     // Catch:{ Exception -> 0x0074 }
        L_0x0073:
            throw r2     // Catch:{ Exception -> 0x0074 }
        L_0x0074:
            r0 = move-exception
            java.lang.String r2 = "ReactNative"
            java.lang.String r3 = "Failed to fetch resource synchronously - resourcePath: \"%s\", outputFile: \"%s\""
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            r4[r5] = r8
            r8 = 1
            java.lang.String r9 = r9.getAbsolutePath()
            r4[r8] = r9
            r8 = 2
            r4[r8] = r0
            com.facebook.common.logging.FLog.m64e((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object[]) r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.DevServerHelper.downloadBundleResourceFromUrlSync(java.lang.String, java.io.File):java.io.File");
    }
}
