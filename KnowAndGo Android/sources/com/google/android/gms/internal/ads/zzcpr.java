package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final /* synthetic */ class zzcpr implements zzbro {
    private final zzcpw zzgeb;
    private final zzaje zzgec;

    zzcpr(zzcpw zzcpw, zzaje zzaje) {
        this.zzgeb = zzcpw;
        this.zzgec = zzaje;
    }

    public final void onAdFailedToLoad(int i) {
        zzcpw zzcpw = this.zzgeb;
        zzaje zzaje = this.zzgec;
        zzcpw.onAdFailedToLoad(i);
        if (zzaje != null) {
            try {
                zzaje.zzcr(i);
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
