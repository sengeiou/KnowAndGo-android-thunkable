package com.google.android.gms.internal.ads;

final class zzbpo implements zzban<zzbph> {
    private final /* synthetic */ zzban zzfja;
    private final /* synthetic */ zzbpk zzfjb;

    zzbpo(zzbpk zzbpk, zzban zzban) {
        this.zzfjb = zzbpk;
        this.zzfja = zzban;
    }

    public final void zzb(Throwable th) {
        this.zzfja.zzb(th);
        this.zzfjb.zzafz();
    }

    public final /* synthetic */ void zzk(Object obj) {
        this.zzfjb.zza(((zzbph) obj).zzfiv, this.zzfja);
    }
}
