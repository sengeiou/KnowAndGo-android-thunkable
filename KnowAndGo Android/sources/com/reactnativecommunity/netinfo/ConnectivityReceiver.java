package com.reactnativecommunity.netinfo;

import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import androidx.core.net.ConnectivityManagerCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.reactnativecommunity.netinfo.types.CellularGeneration;
import com.reactnativecommunity.netinfo.types.ConnectionType;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

abstract class ConnectivityReceiver {
    @Nullable
    private CellularGeneration mCellularGeneration = null;
    @Nonnull
    private ConnectionType mConnectionType = ConnectionType.UNKNOWN;
    private final ConnectivityManager mConnectivityManager;
    private boolean mIsInternetReachable = false;
    private Boolean mIsInternetReachableOverride;
    private final ReactApplicationContext mReactContext;
    private final TelephonyManager mTelephonyManager;
    private final WifiManager mWifiManager;

    /* access modifiers changed from: package-private */
    public abstract void register();

    /* access modifiers changed from: package-private */
    public abstract void unregister();

    ConnectivityReceiver(ReactApplicationContext reactApplicationContext) {
        this.mReactContext = reactApplicationContext;
        this.mConnectivityManager = (ConnectivityManager) reactApplicationContext.getSystemService("connectivity");
        this.mWifiManager = (WifiManager) reactApplicationContext.getApplicationContext().getSystemService("wifi");
        this.mTelephonyManager = (TelephonyManager) reactApplicationContext.getSystemService("phone");
    }

    public void getCurrentState(@Nullable String str, Promise promise) {
        promise.resolve(createConnectivityEventMap(str));
    }

    public void setIsInternetReachableOverride(boolean z) {
        this.mIsInternetReachableOverride = Boolean.valueOf(z);
        updateConnectivity(this.mConnectionType, this.mCellularGeneration, this.mIsInternetReachable);
    }

    public void clearIsInternetReachableOverride() {
        this.mIsInternetReachableOverride = null;
    }

    /* access modifiers changed from: package-private */
    public ReactApplicationContext getReactContext() {
        return this.mReactContext;
    }

    /* access modifiers changed from: package-private */
    public ConnectivityManager getConnectivityManager() {
        return this.mConnectivityManager;
    }

    /* access modifiers changed from: package-private */
    public void updateConnectivity(@Nonnull ConnectionType connectionType, @Nullable CellularGeneration cellularGeneration, boolean z) {
        if (this.mIsInternetReachableOverride != null) {
            z = this.mIsInternetReachableOverride.booleanValue();
        }
        boolean z2 = false;
        boolean z3 = connectionType != this.mConnectionType;
        boolean z4 = cellularGeneration != this.mCellularGeneration;
        if (z != this.mIsInternetReachable) {
            z2 = true;
        }
        if (z3 || z4 || z2) {
            this.mConnectionType = connectionType;
            this.mCellularGeneration = cellularGeneration;
            this.mIsInternetReachable = z;
            sendConnectivityChangedEvent();
        }
    }

    private void sendConnectivityChangedEvent() {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("netInfo.networkStatusDidChange", createConnectivityEventMap((String) null));
    }

    private WritableMap createConnectivityEventMap(@Nullable String str) {
        String str2;
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("isWifiEnabled", this.mWifiManager.isWifiEnabled());
        if (str != null) {
            str2 = str;
        } else {
            str2 = this.mConnectionType.label;
        }
        createMap.putString("type", str2);
        boolean z = true;
        boolean z2 = !this.mConnectionType.equals(ConnectionType.NONE) && !this.mConnectionType.equals(ConnectionType.UNKNOWN);
        createMap.putBoolean("isConnected", z2);
        if (!this.mIsInternetReachable || (str != null && !str.equals(this.mConnectionType.label))) {
            z = false;
        }
        createMap.putBoolean("isInternetReachable", z);
        if (str == null) {
            str = this.mConnectionType.label;
        }
        WritableMap createDetailsMap = createDetailsMap(str);
        if (z2) {
            createDetailsMap.putBoolean("isConnectionExpensive", ConnectivityManagerCompat.isActiveNetworkMetered(getConnectivityManager()));
        }
        createMap.putMap("details", createDetailsMap);
        return createMap;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:16|17|(1:21)|22|23|(1:25)|26|27|28|29|(1:31)|32|33|34|35) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x005f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x006a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0079 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0088 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00a5 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065 A[Catch:{ Exception -> 0x006a }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007f A[Catch:{ Exception -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.react.bridge.WritableMap createDetailsMap(@javax.annotation.Nonnull java.lang.String r8) {
        /*
            r7 = this;
            com.facebook.react.bridge.WritableMap r0 = com.facebook.react.bridge.Arguments.createMap()
            int r1 = r8.hashCode()
            r2 = -916596374(0xffffffffc95dd96a, float:-908694.6)
            r3 = 0
            r4 = -1
            r5 = 1
            if (r1 == r2) goto L_0x0020
            r2 = 3649301(0x37af15, float:5.11376E-39)
            if (r1 == r2) goto L_0x0016
            goto L_0x002a
        L_0x0016:
            java.lang.String r1 = "wifi"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x002a
            r8 = 1
            goto L_0x002b
        L_0x0020:
            java.lang.String r1 = "cellular"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x002a
            r8 = 0
            goto L_0x002b
        L_0x002a:
            r8 = -1
        L_0x002b:
            switch(r8) {
                case 0: goto L_0x0108;
                case 1: goto L_0x0030;
                default: goto L_0x002e;
            }
        L_0x002e:
            goto L_0x0122
        L_0x0030:
            com.facebook.react.bridge.ReactApplicationContext r8 = r7.getReactContext()
            java.lang.String r1 = "android.permission.ACCESS_WIFI_STATE"
            int r8 = androidx.core.content.ContextCompat.checkSelfPermission(r8, r1)
            if (r8 != 0) goto L_0x0122
            android.net.wifi.WifiManager r8 = r7.mWifiManager
            android.net.wifi.WifiInfo r8 = r8.getConnectionInfo()
            if (r8 == 0) goto L_0x0122
            java.lang.String r1 = r8.getSSID()     // Catch:{ Exception -> 0x005f }
            if (r1 == 0) goto L_0x005f
            java.lang.String r2 = "<unknown ssid>"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x005f }
            if (r2 != 0) goto L_0x005f
            java.lang.String r2 = "\""
            java.lang.String r6 = ""
            java.lang.String r1 = r1.replace(r2, r6)     // Catch:{ Exception -> 0x005f }
            java.lang.String r2 = "ssid"
            r0.putString(r2, r1)     // Catch:{ Exception -> 0x005f }
        L_0x005f:
            java.lang.String r1 = r8.getBSSID()     // Catch:{ Exception -> 0x006a }
            if (r1 == 0) goto L_0x006a
            java.lang.String r2 = "bssid"
            r0.putString(r2, r1)     // Catch:{ Exception -> 0x006a }
        L_0x006a:
            int r1 = r8.getRssi()     // Catch:{ Exception -> 0x0079 }
            r2 = 100
            int r1 = android.net.wifi.WifiManager.calculateSignalLevel(r1, r2)     // Catch:{ Exception -> 0x0079 }
            java.lang.String r2 = "strength"
            r0.putInt(r2, r1)     // Catch:{ Exception -> 0x0079 }
        L_0x0079:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0088 }
            r2 = 21
            if (r1 < r2) goto L_0x0088
            int r1 = r8.getFrequency()     // Catch:{ Exception -> 0x0088 }
            java.lang.String r2 = "frequency"
            r0.putInt(r2, r1)     // Catch:{ Exception -> 0x0088 }
        L_0x0088:
            int r1 = r8.getIpAddress()     // Catch:{ Exception -> 0x00a5 }
            long r1 = (long) r1     // Catch:{ Exception -> 0x00a5 }
            java.math.BigInteger r1 = java.math.BigInteger.valueOf(r1)     // Catch:{ Exception -> 0x00a5 }
            byte[] r1 = r1.toByteArray()     // Catch:{ Exception -> 0x00a5 }
            com.reactnativecommunity.netinfo.NetInfoUtils.reverseByteArray(r1)     // Catch:{ Exception -> 0x00a5 }
            java.net.InetAddress r1 = java.net.InetAddress.getByAddress(r1)     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r1 = r1.getHostAddress()     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r2 = "ipAddress"
            r0.putString(r2, r1)     // Catch:{ Exception -> 0x00a5 }
        L_0x00a5:
            int r8 = r8.getIpAddress()     // Catch:{ Exception -> 0x0122 }
            long r1 = (long) r8     // Catch:{ Exception -> 0x0122 }
            java.math.BigInteger r8 = java.math.BigInteger.valueOf(r1)     // Catch:{ Exception -> 0x0122 }
            byte[] r8 = r8.toByteArray()     // Catch:{ Exception -> 0x0122 }
            com.reactnativecommunity.netinfo.NetInfoUtils.reverseByteArray(r8)     // Catch:{ Exception -> 0x0122 }
            java.net.InetAddress r8 = java.net.InetAddress.getByAddress(r8)     // Catch:{ Exception -> 0x0122 }
            java.net.NetworkInterface r8 = java.net.NetworkInterface.getByInetAddress(r8)     // Catch:{ Exception -> 0x0122 }
            java.util.List r8 = r8.getInterfaceAddresses()     // Catch:{ Exception -> 0x0122 }
            java.lang.Object r8 = r8.get(r5)     // Catch:{ Exception -> 0x0122 }
            java.net.InterfaceAddress r8 = (java.net.InterfaceAddress) r8     // Catch:{ Exception -> 0x0122 }
            short r8 = r8.getNetworkPrefixLength()     // Catch:{ Exception -> 0x0122 }
            int r8 = 32 - r8
            int r8 = r4 << r8
            java.util.Locale r1 = java.util.Locale.US     // Catch:{ Exception -> 0x0122 }
            java.lang.String r2 = "%d.%d.%d.%d"
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0122 }
            int r6 = r8 >> 24
            r6 = r6 & 255(0xff, float:3.57E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0122 }
            r4[r3] = r6     // Catch:{ Exception -> 0x0122 }
            int r3 = r8 >> 16
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0122 }
            r4[r5] = r3     // Catch:{ Exception -> 0x0122 }
            r3 = 2
            int r5 = r8 >> 8
            r5 = r5 & 255(0xff, float:3.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0122 }
            r4[r3] = r5     // Catch:{ Exception -> 0x0122 }
            r3 = 3
            r8 = r8 & 255(0xff, float:3.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0122 }
            r4[r3] = r8     // Catch:{ Exception -> 0x0122 }
            java.lang.String r8 = java.lang.String.format(r1, r2, r4)     // Catch:{ Exception -> 0x0122 }
            java.lang.String r1 = "subnet"
            r0.putString(r1, r8)     // Catch:{ Exception -> 0x0122 }
            goto L_0x0122
        L_0x0108:
            com.reactnativecommunity.netinfo.types.CellularGeneration r8 = r7.mCellularGeneration
            if (r8 == 0) goto L_0x0115
            java.lang.String r8 = "cellularGeneration"
            com.reactnativecommunity.netinfo.types.CellularGeneration r1 = r7.mCellularGeneration
            java.lang.String r1 = r1.label
            r0.putString(r8, r1)
        L_0x0115:
            android.telephony.TelephonyManager r8 = r7.mTelephonyManager
            java.lang.String r8 = r8.getNetworkOperatorName()
            if (r8 == 0) goto L_0x0122
            java.lang.String r1 = "carrier"
            r0.putString(r1, r8)
        L_0x0122:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.netinfo.ConnectivityReceiver.createDetailsMap(java.lang.String):com.facebook.react.bridge.WritableMap");
    }
}
