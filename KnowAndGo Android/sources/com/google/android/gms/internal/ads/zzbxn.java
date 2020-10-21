package com.google.android.gms.internal.ads;

public final class zzbxn implements zzdti<zzbzc> {
    private final zzbxk zzfmf;

    private zzbxn(zzbxk zzbxk) {
        this.zzfmf = zzbxk;
    }

    public static zzbxn zzd(zzbxk zzbxk) {
        return new zzbxn(zzbxk);
    }

    public static zzbzc zze(zzbxk zzbxk) {
        return (zzbzc) zzdto.zza(zzbxk.zzahf(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zze(this.zzfmf);
    }
}
