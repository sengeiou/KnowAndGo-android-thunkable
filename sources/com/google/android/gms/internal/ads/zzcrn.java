package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcrn implements zzdti<zzcrk> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzbbh<String>> zzgge;

    private zzcrn(zzdtu<zzbbh<String>> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzgge = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzcrn zzai(zzdtu<zzbbh<String>> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcrn(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcrk(this.zzgge.get(), this.zzfgh.get());
    }
}
