package com.google.android.gms.internal.ads;

final class zzcql implements zzban<zzcdb> {
    private final /* synthetic */ zzcdf zzgfh;
    private final /* synthetic */ zzcqj zzgfo;

    zzcql(zzcqj zzcqj, zzcdf zzcdf) {
        this.zzgfo = zzcqj;
        this.zzgfh = zzcdf;
    }

    public final void zzb(Throwable th) {
        synchronized (this.zzgfo) {
            zzbbh unused = this.zzgfo.zzgek = null;
            this.zzgfh.zzadb().onAdFailedToLoad(zzcgm.zze(th));
            zzcya.zzc(th, "NonagonRewardedVideoAdImpl.onFailure");
        }
    }

    public final /* synthetic */ void zzk(Object obj) {
        zzcdb zzcdb = (zzcdb) obj;
        synchronized (this.zzgfo) {
            zzbbh unused = this.zzgfo.zzgek = null;
            zzcdb unused2 = this.zzgfo.zzgfc = zzcdb;
            zzcdb.zzafl();
        }
    }
}
