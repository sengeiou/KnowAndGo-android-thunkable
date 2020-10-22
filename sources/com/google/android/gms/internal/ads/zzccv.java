package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Executor;

public final class zzccv implements zzdti<zzccj> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<Executor> zzfhi;
    private final zzdtu<zzbai> zzfjy;
    private final zzdtu<zzdh> zzfni;
    private final zzdtu<zza> zzfrr;
    private final zzdtu<zzbhf> zzfsx;

    public zzccv(zzdtu<Context> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<zzdh> zzdtu3, zzdtu<zzbai> zzdtu4, zzdtu<zza> zzdtu5, zzdtu<zzbhf> zzdtu6) {
        this.zzeoj = zzdtu;
        this.zzfhi = zzdtu2;
        this.zzfni = zzdtu3;
        this.zzfjy = zzdtu4;
        this.zzfrr = zzdtu5;
        this.zzfsx = zzdtu6;
    }

    public final /* synthetic */ Object get() {
        return new zzccj(this.zzeoj.get(), this.zzfhi.get(), this.zzfni.get(), this.zzfjy.get(), this.zzfrr.get(), this.zzfsx.get());
    }
}
