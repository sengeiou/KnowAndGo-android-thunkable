package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

final /* synthetic */ class zzclo implements zzbwz {
    private final zzcjy zzgat;

    zzclo(zzcjy zzcjy) {
        this.zzgat = zzcjy;
    }

    public final void zza(boolean z, Context context) {
        zzcjy zzcjy = this.zzgat;
        try {
            ((zzams) zzcjy.zzdgc).setImmersiveMode(z);
            ((zzams) zzcjy.zzdgc).showInterstitial();
        } catch (RemoteException unused) {
            zzawz.zzeo("Cannot show interstitial.");
        }
    }
}
