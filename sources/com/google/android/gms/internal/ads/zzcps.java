package com.google.android.gms.internal.ads;

final class zzcps implements zzban<zzbpc> {
    private final /* synthetic */ zzbxo zzged;
    private final /* synthetic */ zzcpp zzgee;

    zzcps(zzcpp zzcpp, zzbxo zzbxo) {
        this.zzgee = zzcpp;
        this.zzged = zzbxo;
    }

    public final void zzb(Throwable th) {
        this.zzged.zzadb().onAdFailedToLoad(zzcgm.zze(th));
        zzcya.zzc(th, "AdLoaderShim.onFailure");
    }

    public final /* synthetic */ void zzk(Object obj) {
        zzbpc zzbpc = (zzbpc) obj;
        synchronized (this.zzgee) {
            String unused = this.zzgee.zzgdy = zzbpc.getMediationAdapterClassName();
            String unused2 = this.zzgee.zzgdz = zzbpc.zzpj();
            zzbpc.zzafl();
        }
    }
}
