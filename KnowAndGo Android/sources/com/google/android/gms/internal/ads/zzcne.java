package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final /* synthetic */ class zzcne implements zzbwz {
    private final zzcjy zzgat;
    private final zzcjx zzgau;

    zzcne(zzcjy zzcjy, zzcjx zzcjx) {
        this.zzgat = zzcjy;
        this.zzgau = zzcjx;
    }

    public final void zza(boolean z, Context context) {
        zzcjy zzcjy = this.zzgat;
        zzcjx zzcjx = this.zzgau;
        try {
            if (((zzaov) zzcjy.zzdgc).zzz(ObjectWrapper.wrap(context))) {
                zzcjx.zzakq();
            } else {
                zzawz.zzep("Can't show rewarded video.");
            }
        } catch (RemoteException e) {
            zzawz.zzd("Can't show rewarded video.", e);
        }
    }
}
