package com.google.android.gms.internal.ads;

public final class zzcsb implements zzdti<zzcrz> {
    private final zzdtu<zzbqe> zzerf;
    private final zzdtu<zzcyi> zzese;
    private final zzdtu<zzcxv> zzfhr;
    private final zzdtu<String> zzggq;
    private final zzdtu<String> zzggr;

    private zzcsb(zzdtu<String> zzdtu, zzdtu<String> zzdtu2, zzdtu<zzbqe> zzdtu3, zzdtu<zzcyi> zzdtu4, zzdtu<zzcxv> zzdtu5) {
        this.zzggq = zzdtu;
        this.zzggr = zzdtu2;
        this.zzerf = zzdtu3;
        this.zzese = zzdtu4;
        this.zzfhr = zzdtu5;
    }

    public static zzcsb zzh(zzdtu<String> zzdtu, zzdtu<String> zzdtu2, zzdtu<zzbqe> zzdtu3, zzdtu<zzcyi> zzdtu4, zzdtu<zzcxv> zzdtu5) {
        return new zzcsb(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5);
    }

    public final /* synthetic */ Object get() {
        return new zzcrz(this.zzggq.get(), this.zzggr.get(), this.zzerf.get(), this.zzese.get(), this.zzfhr.get());
    }
}
