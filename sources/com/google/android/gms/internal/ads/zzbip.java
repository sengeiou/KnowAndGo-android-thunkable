package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzd;

final /* synthetic */ class zzbip implements Runnable {
    private final zzbio zzeml;

    zzbip(zzbio zzbio) {
        this.zzeml = zzbio;
    }

    public final void run() {
        zzbio zzbio = this.zzeml;
        zzbio.zzdjm.zzaar();
        zzd zzaae = zzbio.zzdjm.zzaae();
        if (zzaae != null) {
            zzaae.zzth();
        }
    }
}
