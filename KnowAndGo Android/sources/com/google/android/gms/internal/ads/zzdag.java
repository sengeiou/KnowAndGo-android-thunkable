package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzdag implements zzdti<zzdae> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzbah> zzerm;
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<Clock> zzfgj;
    private final zzdtu<zzbai> zzfgp;
    private final zzdtu<String> zzggq;
    private final zzdtu<String> zzggr;
    private final zzdtu<zzcmu> zzgnt;

    private zzdag(zzdtu<Executor> zzdtu, zzdtu<zzbah> zzdtu2, zzdtu<zzcmu> zzdtu3, zzdtu<zzbai> zzdtu4, zzdtu<String> zzdtu5, zzdtu<String> zzdtu6, zzdtu<Context> zzdtu7, zzdtu<Clock> zzdtu8) {
        this.zzfgh = zzdtu;
        this.zzerm = zzdtu2;
        this.zzgnt = zzdtu3;
        this.zzfgp = zzdtu4;
        this.zzggq = zzdtu5;
        this.zzggr = zzdtu6;
        this.zzeoj = zzdtu7;
        this.zzfgj = zzdtu8;
    }

    public static zzdag zzc(zzdtu<Executor> zzdtu, zzdtu<zzbah> zzdtu2, zzdtu<zzcmu> zzdtu3, zzdtu<zzbai> zzdtu4, zzdtu<String> zzdtu5, zzdtu<String> zzdtu6, zzdtu<Context> zzdtu7, zzdtu<Clock> zzdtu8) {
        return new zzdag(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5, zzdtu6, zzdtu7, zzdtu8);
    }

    public final /* synthetic */ Object get() {
        return new zzdae(this.zzfgh.get(), this.zzerm.get(), this.zzgnt.get(), this.zzfgp.get(), this.zzggq.get(), this.zzggr.get(), this.zzeoj.get(), this.zzfgj.get());
    }
}
