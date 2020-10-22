package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcyj implements zzdti<zzcyi> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzawu> zzerc;

    private zzcyj(zzdtu<Context> zzdtu, zzdtu<zzawu> zzdtu2) {
        this.zzeoj = zzdtu;
        this.zzerc = zzdtu2;
    }

    public static zzcyj zzau(zzdtu<Context> zzdtu, zzdtu<zzawu> zzdtu2) {
        return new zzcyj(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcyi(this.zzeoj.get(), this.zzerc.get());
    }
}
