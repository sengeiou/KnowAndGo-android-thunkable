package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcuj implements zzdti<zzcuh> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<String> zzeqf;

    private zzcuj(zzdtu<Context> zzdtu, zzdtu<String> zzdtu2) {
        this.zzeoj = zzdtu;
        this.zzeqf = zzdtu2;
    }

    public static zzcuj zzar(zzdtu<Context> zzdtu, zzdtu<String> zzdtu2) {
        return new zzcuj(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcuh(this.zzeoj.get(), this.zzeqf.get());
    }
}
