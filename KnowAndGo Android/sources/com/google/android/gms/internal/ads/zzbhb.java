package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzd;

final /* synthetic */ class zzbhb implements Runnable {
    private final zzbha zzejr;

    zzbhb(zzbha zzbha) {
        this.zzejr = zzbha;
    }

    public final void run() {
        zzbha zzbha = this.zzejr;
        zzbha.zzdjm.zzaar();
        zzd zzaae = zzbha.zzdjm.zzaae();
        if (zzaae != null) {
            zzaae.zzth();
        }
    }
}
