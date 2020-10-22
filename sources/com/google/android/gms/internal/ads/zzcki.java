package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcki implements zzdti<zzckb> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<Executor> zzfhi;
    private final zzdtu<zzcxv> zzfhr;
    private final zzdtu<zzcdn> zzfqk;
    private final zzdtu<zzboc> zzfzs;
    private final zzdtu<zzbam<zzcxm, zzayb>> zzfzt;

    public zzcki(zzdtu<zzboc> zzdtu, zzdtu<Context> zzdtu2, zzdtu<Executor> zzdtu3, zzdtu<zzcdn> zzdtu4, zzdtu<zzcxv> zzdtu5, zzdtu<zzbam<zzcxm, zzayb>> zzdtu6) {
        this.zzfzs = zzdtu;
        this.zzeoj = zzdtu2;
        this.zzfhi = zzdtu3;
        this.zzfqk = zzdtu4;
        this.zzfhr = zzdtu5;
        this.zzfzt = zzdtu6;
    }

    public final /* synthetic */ Object get() {
        return new zzckb(this.zzfzs.get(), this.zzeoj.get(), this.zzfhi.get(), this.zzfqk.get(), this.zzfhr.get(), this.zzfzt.get());
    }
}
