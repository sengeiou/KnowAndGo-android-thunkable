package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzcmi extends zzaoq {
    private zzcjy<zzaov, zzcla> zzfzw;
    private final /* synthetic */ zzcmg zzgbb;

    private zzcmi(zzcmg zzcmg, zzcjy zzcjy) {
        this.zzgbb = zzcmg;
        this.zzfzw = zzcjy;
    }

    public final void zza(zzang zzang) throws RemoteException {
        zzang unused = this.zzgbb.zzgba = zzang;
        ((zzcla) this.zzfzw.zzfzn).onAdLoaded();
    }

    public final void zzdb(String str) throws RemoteException {
        ((zzcla) this.zzfzw.zzfzn).onAdFailedToLoad(0);
    }
}
