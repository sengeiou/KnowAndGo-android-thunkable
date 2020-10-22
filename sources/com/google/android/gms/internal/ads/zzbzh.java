package com.google.android.gms.internal.ads;

public final class zzbzh implements zzdti<zzbyt> {
    private final zzbzf zzfpe;

    private zzbzh(zzbzf zzbzf) {
        this.zzfpe = zzbzf;
    }

    public static zzbzh zza(zzbzf zzbzf) {
        return new zzbzh(zzbzf);
    }

    public static zzbyt zzb(zzbzf zzbzf) {
        return (zzbyt) zzdto.zza(zzbzf.zzaiq(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzfpe);
    }
}
