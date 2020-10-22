package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzcqm extends zzzq {
    private final /* synthetic */ zzcqj zzgfo;
    private final /* synthetic */ zzzp zzgfp;

    zzcqm(zzcqj zzcqj, zzzp zzzp) {
        this.zzgfo = zzcqj;
        this.zzgfp = zzzp;
    }

    public final void onAdMetadataChanged() throws RemoteException {
        if (this.zzgfo.zzgfg && this.zzgfp != null) {
            this.zzgfp.onAdMetadataChanged();
        }
    }
}
