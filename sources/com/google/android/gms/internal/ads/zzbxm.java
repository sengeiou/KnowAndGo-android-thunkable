package com.google.android.gms.internal.ads;

public final class zzbxm implements zzdti<zzbxk> {
    private final zzbxk zzfmf;

    private zzbxm(zzbxk zzbxk) {
        this.zzfmf = zzbxk;
    }

    public static zzbxm zzc(zzbxk zzbxk) {
        return new zzbxm(zzbxk);
    }

    public final /* synthetic */ Object get() {
        zzbxk zzbxk = this.zzfmf;
        if (zzbxk != null) {
            return (zzbxk) zzdto.zza(zzbxk, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
