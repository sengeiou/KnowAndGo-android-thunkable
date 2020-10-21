package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbrb implements zzdti<Context> {
    private final zzdtu<Context> zzfjq;
    private final zzbqy zzfjw;

    private zzbrb(zzbqy zzbqy, zzdtu<Context> zzdtu) {
        this.zzfjw = zzbqy;
        this.zzfjq = zzdtu;
    }

    public static zzbrb zza(zzbqy zzbqy, zzdtu<Context> zzdtu) {
        return new zzbrb(zzbqy, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (Context) zzdto.zza(this.zzfjw.zzbs(this.zzfjq.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
