package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcbv implements zzdti<zzcbi> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<Executor> zzfhi;
    private final zzdtu<zzcxv> zzfhr;
    private final zzdtu<zzcdn> zzfqk;

    public zzcbv(zzdtu<Context> zzdtu, zzdtu<zzcxv> zzdtu2, zzdtu<Executor> zzdtu3, zzdtu<zzcdn> zzdtu4) {
        this.zzeoj = zzdtu;
        this.zzfhr = zzdtu2;
        this.zzfhi = zzdtu3;
        this.zzfqk = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        return new zzcbi(this.zzeoj.get(), this.zzfhr.get(), this.zzfhi.get(), this.zzfqk.get());
    }
}
