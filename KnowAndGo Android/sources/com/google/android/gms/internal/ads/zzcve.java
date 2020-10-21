package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcve<T> implements zzdti<zzcvb<T>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<Set<zzcva<? extends zzcuz<T>>>> zzgik;

    private zzcve(zzdtu<Executor> zzdtu, zzdtu<Set<zzcva<? extends zzcuz<T>>>> zzdtu2) {
        this.zzfgh = zzdtu;
        this.zzgik = zzdtu2;
    }

    public static <T> zzcve<T> zzas(zzdtu<Executor> zzdtu, zzdtu<Set<zzcva<? extends zzcuz<T>>>> zzdtu2) {
        return new zzcve<>(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcvb(this.zzfgh.get(), this.zzgik.get());
    }
}
