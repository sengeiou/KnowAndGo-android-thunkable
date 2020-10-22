package com.reactnativecommunity.netinfo;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.reactnativecommunity.netinfo.types.CellularGeneration;
import com.reactnativecommunity.netinfo.types.ConnectionType;
import javax.annotation.Nullable;

public class BroadcastReceiverConnectivityReceiver extends ConnectivityReceiver {
    private final ConnectivityBroadcastReceiver mConnectivityBroadcastReceiver = new ConnectivityBroadcastReceiver();

    public /* bridge */ /* synthetic */ void clearIsInternetReachableOverride() {
        super.clearIsInternetReachableOverride();
    }

    public /* bridge */ /* synthetic */ void getCurrentState(@Nullable String str, Promise promise) {
        super.getCurrentState(str, promise);
    }

    public /* bridge */ /* synthetic */ void setIsInternetReachableOverride(boolean z) {
        super.setIsInternetReachableOverride(z);
    }

    public BroadcastReceiverConnectivityReceiver(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void register() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        getReactContext().registerReceiver(this.mConnectivityBroadcastReceiver, intentFilter);
        this.mConnectivityBroadcastReceiver.setRegistered(true);
        updateAndSendConnectionType();
    }

    public void unregister() {
        if (this.mConnectivityBroadcastReceiver.isRegistered()) {
            getReactContext().unregisterReceiver(this.mConnectivityBroadcastReceiver);
            this.mConnectivityBroadcastReceiver.setRegistered(false);
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void updateAndSendConnectionType() {
        boolean z;
        ConnectionType connectionType = ConnectionType.UNKNOWN;
        CellularGeneration cellularGeneration = null;
        try {
            NetworkInfo activeNetworkInfo = getConnectivityManager().getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    z = activeNetworkInfo.isConnected();
                    try {
                        switch (activeNetworkInfo.getType()) {
                            case 0:
                            case 4:
                                connectionType = ConnectionType.CELLULAR;
                                cellularGeneration = CellularGeneration.fromNetworkInfo(activeNetworkInfo);
                                break;
                            case 1:
                                connectionType = ConnectionType.WIFI;
                                break;
                            case 6:
                                connectionType = ConnectionType.WIMAX;
                                break;
                            case 7:
                                connectionType = ConnectionType.BLUETOOTH;
                                break;
                            case 9:
                                connectionType = ConnectionType.ETHERNET;
                                break;
                            case 17:
                                connectionType = ConnectionType.VPN;
                                break;
                        }
                    } catch (SecurityException unused) {
                        connectionType = ConnectionType.UNKNOWN;
                        updateConnectivity(connectionType, cellularGeneration, z);
                    }
                    updateConnectivity(connectionType, cellularGeneration, z);
                }
            }
            connectionType = ConnectionType.NONE;
            z = false;
        } catch (SecurityException unused2) {
            z = false;
            connectionType = ConnectionType.UNKNOWN;
            updateConnectivity(connectionType, cellularGeneration, z);
        }
        updateConnectivity(connectionType, cellularGeneration, z);
    }

    private class ConnectivityBroadcastReceiver extends BroadcastReceiver {
        private boolean isRegistered;

        private ConnectivityBroadcastReceiver() {
            this.isRegistered = false;
        }

        public void setRegistered(boolean z) {
            this.isRegistered = z;
        }

        public boolean isRegistered() {
            return this.isRegistered;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                BroadcastReceiverConnectivityReceiver.this.updateAndSendConnectionType();
            }
        }
    }
}
