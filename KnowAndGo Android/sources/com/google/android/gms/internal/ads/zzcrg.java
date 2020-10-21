package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;

public final class zzcrg implements zzdti<zzcre> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzcxv> zzfhr;
    private final zzdtu<ViewGroup> zzgbf;
    private final zzdtu<zzbbl> zzggc;

    public zzcrg(zzdtu<zzbbl> zzdtu, zzdtu<Context> zzdtu2, zzdtu<zzcxv> zzdtu3, zzdtu<ViewGroup> zzdtu4) {
        this.zzggc = zzdtu;
        this.zzeoj = zzdtu2;
        this.zzfhr = zzdtu3;
        this.zzgbf = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        return new zzcre(this.zzggc.get(), this.zzeoj.get(), this.zzfhr.get(), this.zzgbf.get());
    }
}
