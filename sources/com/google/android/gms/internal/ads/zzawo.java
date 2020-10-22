package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

final class zzawo extends zzawv {
    private final /* synthetic */ zzawm zzdtx;

    zzawo(zzawm zzawm) {
        this.zzdtx = zzawm;
    }

    public final void zzto() {
        zzacx zzacx = new zzacx(this.zzdtx.zzlj, this.zzdtx.zzbtc.zzbsx);
        synchronized (this.zzdtx.lock) {
            try {
                zzk.zzlp();
                zzada.zza(this.zzdtx.zzdtq, zzacx);
            } catch (IllegalArgumentException e) {
                zzawz.zzd("Cannot config CSI reporter.", e);
            }
        }
    }
}
