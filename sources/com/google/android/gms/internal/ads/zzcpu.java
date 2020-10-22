package com.google.android.gms.internal.ads;

final class zzcpu implements zzban<zzbnf> {
    private final /* synthetic */ zzboc zzgel;
    private final /* synthetic */ zzcpt zzgem;

    zzcpu(zzcpt zzcpt, zzboc zzboc) {
        this.zzgem = zzcpt;
        this.zzgel = zzboc;
    }

    public final void zzb(Throwable th) {
        synchronized (this.zzgem) {
            zzbbh unused = this.zzgem.zzgek = null;
            this.zzgel.zzadb().onAdFailedToLoad(zzcgm.zze(th));
            this.zzgem.zzgei.zzdk(60);
            zzcya.zzc(th, "BannerAdManagerShim.onFailure");
        }
    }

    public final /* synthetic */ void zzk(Object obj) {
        zzbnf zzbnf = (zzbnf) obj;
        synchronized (this.zzgem) {
            zzbbh unused = this.zzgem.zzgek = null;
            if (this.zzgem.zzgdo != null) {
                this.zzgem.zzgdo.destroy();
            }
            zzbnf unused2 = this.zzgem.zzgdo = zzbnf;
            this.zzgem.zzfgu.removeAllViews();
            this.zzgem.zzfgu.addView(zzbnf.zzafi());
            zzbnf.zzafl();
            this.zzgem.zzgei.zzdk(zzbnf.zzafk());
        }
    }
}
