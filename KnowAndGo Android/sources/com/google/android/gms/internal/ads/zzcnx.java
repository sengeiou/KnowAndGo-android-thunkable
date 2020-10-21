package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

final /* synthetic */ class zzcnx implements zzbwz {
    private final zzcjy zzgat;

    zzcnx(zzcjy zzcjy) {
        this.zzgat = zzcjy;
    }

    public final void zza(boolean z, Context context) {
        zzcjy zzcjy = this.zzgat;
        try {
            ((zzams) zzcjy.zzdgc).setImmersiveMode(z);
            ((zzams) zzcjy.zzdgc).showVideo();
        } catch (RemoteException e) {
            zzawz.zzd("Cannot show rewarded video.", e);
        }
    }
}
