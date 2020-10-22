package com.google.android.gms.internal.ads;

public final class zzcyq implements zzdti<zzcym> {
    private final zzdtu<zzcyk> zzfgf;
    private final zzcyo zzglu;
    private final zzdtu<String> zzglw;

    private zzcyq(zzcyo zzcyo, zzdtu<zzcyk> zzdtu, zzdtu<String> zzdtu2) {
        this.zzglu = zzcyo;
        this.zzfgf = zzdtu;
        this.zzglw = zzdtu2;
    }

    public static zzcyq zza(zzcyo zzcyo, zzdtu<zzcyk> zzdtu, zzdtu<String> zzdtu2) {
        return new zzcyq(zzcyo, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (zzcym) zzdto.zza(this.zzfgf.get().zzfw(this.zzglw.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
