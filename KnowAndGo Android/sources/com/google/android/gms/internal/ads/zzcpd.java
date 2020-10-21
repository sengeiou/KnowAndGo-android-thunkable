package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;

final class zzcpd implements zzf {
    private final /* synthetic */ zzbvy zzgdf;

    zzcpd(zzcpa zzcpa, zzbvy zzbvy) {
        this.zzgdf = zzbvy;
    }

    public final void zzg(View view) {
    }

    public final void zzky() {
        this.zzgdf.zzadf().onAdClicked();
    }

    public final void zzkz() {
        this.zzgdf.zzadg().onAdImpression();
        this.zzgdf.zzadh().zzagx();
    }
}
