package com.learnium.RNDeviceInfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import java.io.PrintStream;

public class RNInstallReferrerClient {
    private InstallReferrerStateListener installReferrerStateListener = new InstallReferrerStateListener() {
        public void onInstallReferrerSetupFinished(int i) {
            switch (i) {
                case 0:
                    try {
                        Log.d("InstallReferrerState", "OK");
                        ReferrerDetails installReferrer = RNInstallReferrerClient.this.mReferrerClient.getInstallReferrer();
                        installReferrer.getInstallReferrer();
                        installReferrer.getReferrerClickTimestampSeconds();
                        installReferrer.getInstallBeginTimestampSeconds();
                        SharedPreferences.Editor edit = RNInstallReferrerClient.this.sharedPreferences.edit();
                        edit.putString("installReferrer", RNInstallReferrerClient.this.getInstallReferrer());
                        edit.apply();
                        RNInstallReferrerClient.this.mReferrerClient.endConnection();
                        return;
                    } catch (Exception e) {
                        PrintStream printStream = System.err;
                        printStream.println("RNInstallReferrerClient exception. getInstallReferrer will be unavailable: " + e.getMessage());
                        e.printStackTrace(System.err);
                        return;
                    }
                case 1:
                    Log.d("InstallReferrerState", "SERVICE_UNAVAILABLE");
                    return;
                case 2:
                    Log.d("InstallReferrerState", "FEATURE_NOT_SUPPORTED");
                    return;
                default:
                    return;
            }
        }

        public void onInstallReferrerServiceDisconnected() {
            Log.d("RNInstallReferrerClient", "InstallReferrerService disconnected");
        }
    };
    /* access modifiers changed from: private */
    public InstallReferrerClient mReferrerClient;
    /* access modifiers changed from: private */
    public SharedPreferences sharedPreferences;

    RNInstallReferrerClient(Context context) {
        this.sharedPreferences = context.getSharedPreferences("react-native-device-info", 0);
        this.mReferrerClient = InstallReferrerClient.newBuilder(context).build();
        try {
            this.mReferrerClient.startConnection(this.installReferrerStateListener);
        } catch (Exception e) {
            PrintStream printStream = System.err;
            printStream.println("RNInstallReferrerClient exception. getInstallReferrer will be unavailable: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    /* access modifiers changed from: private */
    public String getInstallReferrer() {
        try {
            return this.mReferrerClient.getInstallReferrer().getInstallReferrer();
        } catch (Exception e) {
            PrintStream printStream = System.err;
            printStream.println("RNInstallReferrerClient exception. getInstallReferrer will be unavailable: " + e.getMessage());
            e.printStackTrace(System.err);
            return null;
        }
    }
}
