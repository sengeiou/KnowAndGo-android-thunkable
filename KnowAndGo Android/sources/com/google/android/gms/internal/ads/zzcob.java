package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcob implements zzdti<zzcnw> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<Executor> zzfhi;
    private final zzdtu<zzcdf> zzfzs;

    public zzcob(zzdtu<Context> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<zzcdf> zzdtu3) {
        this.zzeoj = zzdtu;
        this.zzfhi = zzdtu2;
        this.zzfzs = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        return new zzcnw(this.zzeoj.get(), this.zzfhi.get(), this.zzfzs.get());
    }
}
