package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.Nullable;

final class zzcqr implements zzban<zzcrc> {
    private final /* synthetic */ zzavy zzgfr;

    zzcqr(zzcqq zzcqq, zzavy zzavy) {
        this.zzgfr = zzavy;
    }

    public final void zzb(Throwable th) {
        try {
            this.zzgfr.onError("Internal error.");
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    public final /* synthetic */ void zzk(@Nullable Object obj) {
        zzcrc zzcrc = (zzcrc) obj;
        try {
            this.zzgfr.zzk(zzcrc.zzgfw, zzcrc.zzgfx);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
