package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzcqh extends zzaap {
    private final /* synthetic */ zzcqf zzgfi;
    private final /* synthetic */ zzaao zzgfj;

    zzcqh(zzcqf zzcqf, zzaao zzaao) {
        this.zzgfi = zzcqf;
        this.zzgfj = zzaao;
    }

    public final void onAdMetadataChanged() throws RemoteException {
        if (this.zzgfi.zzgfg && this.zzgfj != null) {
            this.zzgfj.onAdMetadataChanged();
        }
    }
}
