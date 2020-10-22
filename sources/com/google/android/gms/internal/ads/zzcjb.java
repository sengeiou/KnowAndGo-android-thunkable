package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcjb implements zzdti<zzcja> {
    private final zzdtu<Context> zzeoj;

    private zzcjb(zzdtu<Context> zzdtu) {
        this.zzeoj = zzdtu;
    }

    public static zzcjb zzaf(zzdtu<Context> zzdtu) {
        return new zzcjb(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzcja(this.zzeoj.get());
    }
}
