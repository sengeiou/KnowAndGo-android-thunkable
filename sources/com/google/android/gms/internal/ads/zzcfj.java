package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcfj implements zzdti<zzcfi> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<String> zzftu;

    private zzcfj(zzdtu<Context> zzdtu, zzdtu<String> zzdtu2) {
        this.zzeoj = zzdtu;
        this.zzftu = zzdtu2;
    }

    public static zzcfj zzx(zzdtu<Context> zzdtu, zzdtu<String> zzdtu2) {
        return new zzcfj(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcfi(this.zzeoj.get(), this.zzftu.get());
    }
}
