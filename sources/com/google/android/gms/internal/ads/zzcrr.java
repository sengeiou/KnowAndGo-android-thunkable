package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcrr implements zzdti<zzcrp> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzcsk<zzcvf>> zzeph;
    private final zzdtu<zzcxv> zzfhr;
    private final zzdtu<zzawm> zzggj;

    private zzcrr(zzdtu<zzcsk<zzcvf>> zzdtu, zzdtu<zzcxv> zzdtu2, zzdtu<Context> zzdtu3, zzdtu<zzawm> zzdtu4) {
        this.zzeph = zzdtu;
        this.zzfhr = zzdtu2;
        this.zzeoj = zzdtu3;
        this.zzggj = zzdtu4;
    }

    public static zzcrr zzg(zzdtu<zzcsk<zzcvf>> zzdtu, zzdtu<zzcxv> zzdtu2, zzdtu<Context> zzdtu3, zzdtu<zzawm> zzdtu4) {
        return new zzcrr(zzdtu, zzdtu2, zzdtu3, zzdtu4);
    }

    public final /* synthetic */ Object get() {
        return new zzcrp(this.zzeph.get(), this.zzfhr.get(), this.zzeoj.get(), this.zzggj.get());
    }
}
