package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcku implements zzdti<zzckr> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzcxk> zzfey;
    private final zzdtu<Executor> zzfhi;
    private final zzdtu<zzbws> zzfzs;

    public zzcku(zzdtu<Context> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<zzbws> zzdtu3, zzdtu<zzcxk> zzdtu4) {
        this.zzeoj = zzdtu;
        this.zzfhi = zzdtu2;
        this.zzfzs = zzdtu3;
        this.zzfey = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        return new zzckr(this.zzeoj.get(), this.zzfhi.get(), this.zzfzs.get(), this.zzfey.get());
    }
}
