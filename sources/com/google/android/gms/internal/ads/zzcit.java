package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcit implements zzdti<zzcig> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<Executor> zzfhi;
    private final zzdtu<zzasm> zzfxw;
    private final zzdtu<zzblp> zzfxx;
    private final zzdtu<zzasl> zzfxy;

    private zzcit(zzdtu<Context> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<zzasm> zzdtu3, zzdtu<zzblp> zzdtu4, zzdtu<zzasl> zzdtu5) {
        this.zzeoj = zzdtu;
        this.zzfhi = zzdtu2;
        this.zzfxw = zzdtu3;
        this.zzfxx = zzdtu4;
        this.zzfxy = zzdtu5;
    }

    public static zzcit zzg(zzdtu<Context> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<zzasm> zzdtu3, zzdtu<zzblp> zzdtu4, zzdtu<zzasl> zzdtu5) {
        return new zzcit(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5);
    }

    public final /* synthetic */ Object get() {
        return new zzcig(this.zzeoj.get(), this.zzfhi.get(), this.zzfxw.get(), this.zzfxx.get(), this.zzfxy.get());
    }
}
