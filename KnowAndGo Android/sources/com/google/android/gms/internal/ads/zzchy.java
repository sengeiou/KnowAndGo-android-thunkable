package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

public final class zzchy extends zzars {
    private final /* synthetic */ zzchx zzfxj;

    protected zzchy(zzchx zzchx) {
        this.zzfxj = zzchx;
    }

    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzfxj.zzddv.set(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }

    public final void zza(zzaym zzaym) {
        this.zzfxj.zzddv.setException(new zzayn(zzaym.zzdwv, zzaym.errorCode));
    }
}
