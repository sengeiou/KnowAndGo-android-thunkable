package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

public final class zzcjp implements zzdti<zzcjm> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzcji> zzeqw;
    private final zzdtu<zzcjc> zzetz;
    private final zzdtu<zzbbh<Bundle>> zzfzg;

    private zzcjp(zzdtu<Context> zzdtu, zzdtu<zzbbh<Bundle>> zzdtu2, zzdtu<zzcji> zzdtu3, zzdtu<zzcjc> zzdtu4) {
        this.zzeoj = zzdtu;
        this.zzfzg = zzdtu2;
        this.zzeqw = zzdtu3;
        this.zzetz = zzdtu4;
    }

    public static zzcjp zze(zzdtu<Context> zzdtu, zzdtu<zzbbh<Bundle>> zzdtu2, zzdtu<zzcji> zzdtu3, zzdtu<zzcjc> zzdtu4) {
        return new zzcjp(zzdtu, zzdtu2, zzdtu3, zzdtu4);
    }

    public final /* synthetic */ Object get() {
        return new zzcjm(this.zzeoj.get(), this.zzfzg.get(), this.zzeqw.get(), this.zzetz.get());
    }
}
