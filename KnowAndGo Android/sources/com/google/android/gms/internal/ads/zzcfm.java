package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

public final class zzcfm implements zzdti<zzcfk> {
    private final zzdtu<Clock> zzfgj;
    private final zzdtu<zzcfi> zzfuv;
    private final zzdtu<Set<zzcfl>> zzfuw;

    private zzcfm(zzdtu<zzcfi> zzdtu, zzdtu<Set<zzcfl>> zzdtu2, zzdtu<Clock> zzdtu3) {
        this.zzfuv = zzdtu;
        this.zzfuw = zzdtu2;
        this.zzfgj = zzdtu3;
    }

    public static zzcfm zzl(zzdtu<zzcfi> zzdtu, zzdtu<Set<zzcfl>> zzdtu2, zzdtu<Clock> zzdtu3) {
        return new zzcfm(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return new zzcfk(this.zzfuv.get(), this.zzfuw.get(), this.zzfgj.get());
    }
}
