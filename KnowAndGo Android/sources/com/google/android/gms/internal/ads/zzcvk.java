package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzk;

public final class zzcvk implements zzcva<zzcvj> {
    private final zzbbl zzfqw;
    private final Context zzlj;

    public zzcvk(zzbbl zzbbl, Context context) {
        this.zzfqw = zzbbl;
        this.zzlj = context;
    }

    public final zzbbh<zzcvj> zzalm() {
        return this.zzfqw.zza(new zzcvl(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcvj zzama() throws Exception {
        int i;
        boolean z;
        int i2;
        int i3;
        TelephonyManager telephonyManager = (TelephonyManager) this.zzlj.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        int networkType = telephonyManager.getNetworkType();
        int phoneType = telephonyManager.getPhoneType();
        zzk.zzlg();
        int i4 = -1;
        if (zzaxi.zzp(this.zzlj, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.zzlj.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                int ordinal = activeNetworkInfo.getDetailedState().ordinal();
                i3 = type;
                i4 = ordinal;
            } else {
                i3 = -1;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                i = i4;
                i2 = i3;
                z = connectivityManager.isActiveNetworkMetered();
            } else {
                i = i4;
                i2 = i3;
                z = false;
            }
        } else {
            i2 = -2;
            z = false;
            i = -1;
        }
        return new zzcvj(networkOperator, i2, networkType, phoneType, z, i);
    }
}
