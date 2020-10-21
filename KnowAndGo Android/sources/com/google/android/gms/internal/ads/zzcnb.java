package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final /* synthetic */ class zzcnb implements zzbwz {
    private final zzcjy zzgat;

    zzcnb(zzcjy zzcjy) {
        this.zzgat = zzcjy;
    }

    public final void zza(boolean z, Context context) {
        zzcjy zzcjy = this.zzgat;
        try {
            ((zzams) zzcjy.zzdgc).setImmersiveMode(z);
            ((zzams) zzcjy.zzdgc).zzs(ObjectWrapper.wrap(context));
        } catch (RemoteException e) {
            zzawz.zzd("Cannot show rewarded .", e);
        }
    }
}
