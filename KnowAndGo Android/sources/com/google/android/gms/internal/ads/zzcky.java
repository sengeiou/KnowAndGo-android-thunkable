package com.google.android.gms.internal.ads;

final class zzcky implements zzban<zzbnf> {
    private final /* synthetic */ zzckv zzgag;

    zzcky(zzckv zzckv) {
        this.zzgag = zzckv;
    }

    public final void zzb(Throwable th) {
        this.zzgag.zzfkw.onAdFailedToLoad(zzcgm.zze(th));
        zzcya.zzc(th, "DelayedBannerAd.onFailure");
    }

    public final /* synthetic */ void zzk(Object obj) {
        ((zzbnf) obj).zzafl();
    }
}
