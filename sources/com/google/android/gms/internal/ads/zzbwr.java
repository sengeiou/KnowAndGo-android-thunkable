package com.google.android.gms.internal.ads;

public final class zzbwr implements zzdti<zzbwq> {
    private final zzdtu<zzbsv> zzeya;
    private final zzdtu<zzbuv> zzfcy;

    private zzbwr(zzdtu<zzbsv> zzdtu, zzdtu<zzbuv> zzdtu2) {
        this.zzeya = zzdtu;
        this.zzfcy = zzdtu2;
    }

    public static zzbwr zzi(zzdtu<zzbsv> zzdtu, zzdtu<zzbuv> zzdtu2) {
        return new zzbwr(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzbwq(this.zzeya.get(), this.zzfcy.get());
    }
}
