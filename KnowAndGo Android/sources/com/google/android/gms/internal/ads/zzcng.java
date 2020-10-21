package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzcng extends zzaot {
    private zzcjy<zzaov, zzcla> zzfzw;

    private zzcng(zzcnd zzcnd, zzcjy zzcjy) {
        this.zzfzw = zzcjy;
    }

    public final void zzsw() throws RemoteException {
        ((zzcla) this.zzfzw.zzfzn).onAdLoaded();
    }

    public final void zzdb(String str) throws RemoteException {
        ((zzcla) this.zzfzw.zzfzn).onAdFailedToLoad(0);
    }
}
