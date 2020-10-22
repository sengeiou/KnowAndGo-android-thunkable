package com.facebook.react.modules.systeminfo;

import android.content.Context;
import android.os.Build;
import com.facebook.react.C1129R;
import java.util.Locale;

public class AndroidInfoHelpers {
    public static final String DEVICE_LOCALHOST = "localhost";
    public static final String EMULATOR_LOCALHOST = "10.0.2.2";
    public static final String GENYMOTION_LOCALHOST = "10.0.3.2";
    public static final String METRO_HOST_PROP_NAME = "metro.host";
    private static final String TAG = "AndroidInfoHelpers";
    private static String metroHostPropValue;

    private static boolean isRunningOnGenymotion() {
        return Build.FINGERPRINT.contains("vbox");
    }

    private static boolean isRunningOnStockEmulator() {
        return Build.FINGERPRINT.contains("generic");
    }

    public static String getServerHost(Integer num) {
        return getServerIpAddress(num.intValue());
    }

    public static String getServerHost(Context context) {
        return getServerIpAddress(getDevServerPort(context).intValue());
    }

    public static String getAdbReverseTcpCommand(Integer num) {
        return "adb reverse tcp:" + num + " tcp:" + num;
    }

    public static String getAdbReverseTcpCommand(Context context) {
        return getAdbReverseTcpCommand(getDevServerPort(context));
    }

    public static String getInspectorProxyHost(Context context) {
        return getServerIpAddress(getInspectorProxyPort(context).intValue());
    }

    public static String getFriendlyDeviceName() {
        if (isRunningOnGenymotion()) {
            return Build.MODEL;
        }
        return Build.MODEL + " - " + Build.VERSION.RELEASE + " - API " + Build.VERSION.SDK_INT;
    }

    private static Integer getDevServerPort(Context context) {
        return Integer.valueOf(context.getResources().getInteger(C1129R.integer.react_native_dev_server_port));
    }

    private static Integer getInspectorProxyPort(Context context) {
        return Integer.valueOf(context.getResources().getInteger(C1129R.integer.react_native_dev_server_port));
    }

    private static String getServerIpAddress(int i) {
        String metroHostPropValue2 = getMetroHostPropValue();
        if (metroHostPropValue2.equals("")) {
            if (isRunningOnGenymotion()) {
                metroHostPropValue2 = GENYMOTION_LOCALHOST;
            } else {
                metroHostPropValue2 = isRunningOnStockEmulator() ? EMULATOR_LOCALHOST : DEVICE_LOCALHOST;
            }
        }
        return String.format(Locale.US, "%s:%d", new Object[]{metroHostPropValue2, Integer.valueOf(i)});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        if (r2 == null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r2.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0068, code lost:
        if (r2 == null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r1 = metroHostPropValue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006e, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0065 A[SYNTHETIC, Splitter:B:37:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0072 A[SYNTHETIC, Splitter:B:47:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0077 A[SYNTHETIC, Splitter:B:51:0x0077] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.lang.String getMetroHostPropValue() {
        /*
            java.lang.Class<com.facebook.react.modules.systeminfo.AndroidInfoHelpers> r0 = com.facebook.react.modules.systeminfo.AndroidInfoHelpers.class
            monitor-enter(r0)
            java.lang.String r1 = metroHostPropValue     // Catch:{ all -> 0x007b }
            if (r1 == 0) goto L_0x000b
            java.lang.String r1 = metroHostPropValue     // Catch:{ all -> 0x007b }
            monitor-exit(r0)
            return r1
        L_0x000b:
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0055, all -> 0x0051 }
            java.lang.String r3 = "/system/bin/getprop"
            java.lang.String r4 = "metro.host"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ Exception -> 0x0055, all -> 0x0051 }
            java.lang.Process r2 = r2.exec(r3)     // Catch:{ Exception -> 0x0055, all -> 0x0051 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x004f }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x004f }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ Exception -> 0x004f }
            java.lang.String r6 = "UTF-8"
            java.nio.charset.Charset r6 = java.nio.charset.Charset.forName(r6)     // Catch:{ Exception -> 0x004f }
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x004f }
            r3.<init>(r4)     // Catch:{ Exception -> 0x004f }
            java.lang.String r1 = ""
        L_0x0032:
            java.lang.String r4 = r3.readLine()     // Catch:{ Exception -> 0x004a, all -> 0x0045 }
            if (r4 == 0) goto L_0x003a
            r1 = r4
            goto L_0x0032
        L_0x003a:
            metroHostPropValue = r1     // Catch:{ Exception -> 0x004a, all -> 0x0045 }
            r3.close()     // Catch:{ Exception -> 0x003f }
        L_0x003f:
            if (r2 == 0) goto L_0x006b
        L_0x0041:
            r2.destroy()     // Catch:{ all -> 0x007b }
            goto L_0x006b
        L_0x0045:
            r1 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x0070
        L_0x004a:
            r1 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x0058
        L_0x004f:
            r3 = move-exception
            goto L_0x0058
        L_0x0051:
            r2 = move-exception
            r3 = r2
            r2 = r1
            goto L_0x0070
        L_0x0055:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L_0x0058:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x006f }
            java.lang.String r5 = "Failed to query for metro.host prop:"
            com.facebook.common.logging.FLog.m103w((java.lang.String) r4, (java.lang.String) r5, (java.lang.Throwable) r3)     // Catch:{ all -> 0x006f }
            java.lang.String r3 = ""
            metroHostPropValue = r3     // Catch:{ all -> 0x006f }
            if (r1 == 0) goto L_0x0068
            r1.close()     // Catch:{ Exception -> 0x0068 }
        L_0x0068:
            if (r2 == 0) goto L_0x006b
            goto L_0x0041
        L_0x006b:
            java.lang.String r1 = metroHostPropValue     // Catch:{ all -> 0x007b }
            monitor-exit(r0)
            return r1
        L_0x006f:
            r3 = move-exception
        L_0x0070:
            if (r1 == 0) goto L_0x0075
            r1.close()     // Catch:{ Exception -> 0x0075 }
        L_0x0075:
            if (r2 == 0) goto L_0x007a
            r2.destroy()     // Catch:{ all -> 0x007b }
        L_0x007a:
            throw r3     // Catch:{ all -> 0x007b }
        L_0x007b:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.systeminfo.AndroidInfoHelpers.getMetroHostPropValue():java.lang.String");
    }
}
