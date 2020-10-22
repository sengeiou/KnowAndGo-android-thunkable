package com.google.android.gms.internal.ads;

public final class zzcyh implements zzdti<zzbuz<zzbro>> {
    private final zzdtu<zzcyi> zzfjj;
    private final zzcyg zzglp;

    private zzcyh(zzcyg zzcyg, zzdtu<zzcyi> zzdtu) {
        this.zzglp = zzcyg;
        this.zzfjj = zzdtu;
    }

    public static zzcyh zza(zzcyg zzcyg, zzdtu<zzcyi> zzdtu) {
        return new zzcyh(zzcyg, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfjj.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
