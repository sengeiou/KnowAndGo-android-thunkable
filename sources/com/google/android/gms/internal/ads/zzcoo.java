package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzcoo implements zzf {
    private final zzbvd zzfha;
    private final zzbrt zzfmr;
    private final zzbri zzfms;
    private final zzbmn zzfmt;
    private final zzbva zzfmv;
    private AtomicBoolean zzgcs = new AtomicBoolean(false);

    zzcoo(zzbri zzbri, zzbrt zzbrt, zzbvd zzbvd, zzbva zzbva, zzbmn zzbmn) {
        this.zzfms = zzbri;
        this.zzfmr = zzbrt;
        this.zzfha = zzbvd;
        this.zzfmv = zzbva;
        this.zzfmt = zzbmn;
    }

    public final synchronized void zzg(View view) {
        if (this.zzgcs.compareAndSet(false, true)) {
            this.zzfmt.onAdImpression();
            this.zzfmv.zzq(view);
        }
    }

    public final void zzky() {
        if (this.zzgcs.get()) {
            this.zzfms.onAdClicked();
        }
    }

    public final void zzkz() {
        if (this.zzgcs.get()) {
            this.zzfmr.onAdImpression();
            this.zzfha.zzagx();
        }
    }
}
