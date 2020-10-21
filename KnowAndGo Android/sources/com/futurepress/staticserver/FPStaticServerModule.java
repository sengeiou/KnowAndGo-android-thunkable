package com.futurepress.staticserver;

import android.util.Log;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.Enumeration;
import p022fi.iki.elonen.SimpleWebServer;

public class FPStaticServerModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private static final String LOGTAG = "FPStaticServerModule";
    private boolean keep_alive = false;
    private String localPath = "";
    private boolean localhost_only = false;
    private int port = 9999;
    private final ReactApplicationContext reactContext;
    private SimpleWebServer server = null;
    private String url = "";
    private File www_root = null;

    public String getName() {
        return "FPStaticServer";
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    public FPStaticServerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    private String __getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            String hostAddress = nextElement.getHostAddress();
                            if (InetAddressUtils.isIPv4Address(hostAddress)) {
                                Log.w(LOGTAG, "local IP: " + hostAddress);
                                return hostAddress;
                            }
                        }
                    }
                }
            }
            return "127.0.0.1";
        } catch (SocketException e) {
            Log.e(LOGTAG, e.toString());
            return "127.0.0.1";
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:9|10|11|12|(2:13|14)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0023 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0026 */
    @com.facebook.react.bridge.ReactMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start(java.lang.String r2, java.lang.String r3, java.lang.Boolean r4, java.lang.Boolean r5, com.facebook.react.bridge.Promise r6) {
        /*
            r1 = this;
            fi.iki.elonen.SimpleWebServer r0 = r1.server
            if (r0 == 0) goto L_0x000a
            java.lang.String r2 = r1.url
            r6.resolve(r2)
            return
        L_0x000a:
            if (r2 == 0) goto L_0x0033
            r0 = 9999(0x270f, float:1.4012E-41)
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0026 }
            r1.port = r2     // Catch:{ NumberFormatException -> 0x0026 }
            int r2 = r1.port     // Catch:{ NumberFormatException -> 0x0026 }
            if (r2 != 0) goto L_0x0033
            java.lang.Integer r2 = r1.findRandomOpenPort()     // Catch:{ IOException -> 0x0023 }
            int r2 = r2.intValue()     // Catch:{ IOException -> 0x0023 }
            r1.port = r2     // Catch:{ IOException -> 0x0023 }
            goto L_0x0033
        L_0x0023:
            r1.port = r0     // Catch:{ NumberFormatException -> 0x0026 }
            goto L_0x0033
        L_0x0026:
            java.lang.Integer r2 = r1.findRandomOpenPort()     // Catch:{ IOException -> 0x0031 }
            int r2 = r2.intValue()     // Catch:{ IOException -> 0x0031 }
            r1.port = r2     // Catch:{ IOException -> 0x0031 }
            goto L_0x0033
        L_0x0031:
            r1.port = r0
        L_0x0033:
            if (r3 == 0) goto L_0x0055
            java.lang.String r2 = "/"
            boolean r2 = r3.startsWith(r2)
            if (r2 != 0) goto L_0x0045
            java.lang.String r2 = "file:///"
            boolean r2 = r3.startsWith(r2)
            if (r2 == 0) goto L_0x0055
        L_0x0045:
            java.io.File r2 = new java.io.File
            r2.<init>(r3)
            r1.www_root = r2
            java.io.File r2 = r1.www_root
            java.lang.String r2 = r2.getAbsolutePath()
            r1.localPath = r2
            goto L_0x006a
        L_0x0055:
            java.io.File r2 = new java.io.File
            com.facebook.react.bridge.ReactApplicationContext r0 = r1.reactContext
            java.io.File r0 = r0.getFilesDir()
            r2.<init>(r0, r3)
            r1.www_root = r2
            java.io.File r2 = r1.www_root
            java.lang.String r2 = r2.getAbsolutePath()
            r1.localPath = r2
        L_0x006a:
            if (r4 == 0) goto L_0x0072
            boolean r2 = r4.booleanValue()
            r1.localhost_only = r2
        L_0x0072:
            if (r5 == 0) goto L_0x007a
            boolean r2 = r5.booleanValue()
            r1.keep_alive = r2
        L_0x007a:
            boolean r2 = r1.localhost_only     // Catch:{ IOException -> 0x00e1 }
            if (r2 == 0) goto L_0x008c
            com.futurepress.staticserver.WebServer r2 = new com.futurepress.staticserver.WebServer     // Catch:{ IOException -> 0x00e1 }
            java.lang.String r3 = "localhost"
            int r4 = r1.port     // Catch:{ IOException -> 0x00e1 }
            java.io.File r5 = r1.www_root     // Catch:{ IOException -> 0x00e1 }
            r2.<init>(r3, r4, r5)     // Catch:{ IOException -> 0x00e1 }
            r1.server = r2     // Catch:{ IOException -> 0x00e1 }
            goto L_0x009b
        L_0x008c:
            com.futurepress.staticserver.WebServer r2 = new com.futurepress.staticserver.WebServer     // Catch:{ IOException -> 0x00e1 }
            java.lang.String r3 = r1.__getLocalIpAddress()     // Catch:{ IOException -> 0x00e1 }
            int r4 = r1.port     // Catch:{ IOException -> 0x00e1 }
            java.io.File r5 = r1.www_root     // Catch:{ IOException -> 0x00e1 }
            r2.<init>(r3, r4, r5)     // Catch:{ IOException -> 0x00e1 }
            r1.server = r2     // Catch:{ IOException -> 0x00e1 }
        L_0x009b:
            boolean r2 = r1.localhost_only     // Catch:{ IOException -> 0x00e1 }
            if (r2 == 0) goto L_0x00b5
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e1 }
            r2.<init>()     // Catch:{ IOException -> 0x00e1 }
            java.lang.String r3 = "http://localhost:"
            r2.append(r3)     // Catch:{ IOException -> 0x00e1 }
            int r3 = r1.port     // Catch:{ IOException -> 0x00e1 }
            r2.append(r3)     // Catch:{ IOException -> 0x00e1 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x00e1 }
            r1.url = r2     // Catch:{ IOException -> 0x00e1 }
            goto L_0x00d6
        L_0x00b5:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e1 }
            r2.<init>()     // Catch:{ IOException -> 0x00e1 }
            java.lang.String r3 = "http://"
            r2.append(r3)     // Catch:{ IOException -> 0x00e1 }
            java.lang.String r3 = r1.__getLocalIpAddress()     // Catch:{ IOException -> 0x00e1 }
            r2.append(r3)     // Catch:{ IOException -> 0x00e1 }
            java.lang.String r3 = ":"
            r2.append(r3)     // Catch:{ IOException -> 0x00e1 }
            int r3 = r1.port     // Catch:{ IOException -> 0x00e1 }
            r2.append(r3)     // Catch:{ IOException -> 0x00e1 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x00e1 }
            r1.url = r2     // Catch:{ IOException -> 0x00e1 }
        L_0x00d6:
            fi.iki.elonen.SimpleWebServer r2 = r1.server     // Catch:{ IOException -> 0x00e1 }
            r2.start()     // Catch:{ IOException -> 0x00e1 }
            java.lang.String r2 = r1.url     // Catch:{ IOException -> 0x00e1 }
            r6.resolve(r2)     // Catch:{ IOException -> 0x00e1 }
            goto L_0x00fc
        L_0x00e1:
            r2 = move-exception
            java.lang.String r2 = r2.getMessage()
            fi.iki.elonen.SimpleWebServer r3 = r1.server
            if (r3 == 0) goto L_0x00f8
            java.lang.String r3 = "bind failed: EADDRINUSE (Address already in use)"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x00f8
            java.lang.String r2 = r1.url
            r6.resolve(r2)
            goto L_0x00fc
        L_0x00f8:
            r3 = 0
            r6.reject((java.lang.String) r3, (java.lang.String) r2)
        L_0x00fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.futurepress.staticserver.FPStaticServerModule.start(java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, com.facebook.react.bridge.Promise):void");
    }

    private Integer findRandomOpenPort() throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(0);
            int localPort = serverSocket.getLocalPort();
            Log.w(LOGTAG, "port:" + localPort);
            serverSocket.close();
            return Integer.valueOf(localPort);
        } catch (IOException unused) {
            return 0;
        }
    }

    @ReactMethod
    public void stop() {
        if (this.server != null) {
            Log.w(LOGTAG, "Stopped Server");
            this.server.stop();
            this.server = null;
        }
    }

    @ReactMethod
    public void origin(Promise promise) {
        if (this.server != null) {
            promise.resolve(this.url);
        } else {
            promise.resolve("");
        }
    }

    public void onHostDestroy() {
        stop();
    }
}
