package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcnv implements zzdti<zzcnl> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzbai> zzfgp;
    private final zzdtu<Executor> zzfhi;
    private final zzdtu<zzcxv> zzfhr;
    private final zzdtu<zzcdn> zzfqk;
    private final zzdtu<zzcdf> zzfzs;

    public zzcnv(zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<zzcxv> zzdtu3, zzdtu<Executor> zzdtu4, zzdtu<zzcdf> zzdtu5, zzdtu<zzcdn> zzdtu6) {
        this.zzeoj = zzdtu;
        this.zzfgp = zzdtu2;
        this.zzfhr = zzdtu3;
        this.zzfhi = zzdtu4;
        this.zzfzs = zzdtu5;
        this.zzfqk = zzdtu6;
    }

    public final /* synthetic */ Object get() {
        return new zzcnl(this.zzeoj.get(), this.zzfgp.get(), this.zzfhr.get(), this.zzfhi.get(), this.zzfzs.get(), this.zzfqk.get());
    }
}