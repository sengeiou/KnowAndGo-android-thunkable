package com.google.android.gms.internal.ads;

final class zzcqe implements zzban<zzbvx> {
    private final /* synthetic */ zzbws zzgfa;
    private final /* synthetic */ zzcqd zzgfb;

    zzcqe(zzcqd zzcqd, zzbws zzbws) {
        this.zzgfb = zzcqd;
        this.zzgfa = zzbws;
    }

    public final void zzb(Throwable th) {
        synchronized (this.zzgfb) {
            zzbbh unused = this.zzgfb.zzgek = null;
            this.zzgfa.zzadb().onAdFailedToLoad(zzcgm.zze(th));
            zzcya.zzc(th, "InterstitialAdManagerShim.onFailure");
        }
    }

    public final /* synthetic */ void zzk(Object obj) {
        zzbvx zzbvx = (zzbvx) obj;
        synchronized (this.zzgfb) {
            zzbbh unused = this.zzgfb.zzgek = null;
            zzbvx unused2 = this.zzgfb.zzgey = zzbvx;
            zzbvx.zzafl();
        }
    }
}
