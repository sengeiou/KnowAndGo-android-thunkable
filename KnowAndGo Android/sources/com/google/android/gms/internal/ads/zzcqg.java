package com.google.android.gms.internal.ads;

final class zzcqg implements zzban<zzcdb> {
    private final /* synthetic */ zzcdf zzgfh;
    private final /* synthetic */ zzcqf zzgfi;

    zzcqg(zzcqf zzcqf, zzcdf zzcdf) {
        this.zzgfi = zzcqf;
        this.zzgfh = zzcdf;
    }

    public final void zzb(Throwable th) {
        synchronized (this.zzgfi) {
            zzbbh unused = this.zzgfi.zzgek = null;
            this.zzgfh.zzadb().onAdFailedToLoad(zzcgm.zze(th));
            zzcya.zzc(th, "NonagonRewardedAdImpl.onFailure");
        }
    }

    public final /* synthetic */ void zzk(Object obj) {
        zzcdb zzcdb = (zzcdb) obj;
        synchronized (this.zzgfi) {
            zzbbh unused = this.zzgfi.zzgek = null;
            zzcdb unused2 = this.zzgfi.zzgfc = zzcdb;
            zzcdb.zzafl();
        }
    }
}
