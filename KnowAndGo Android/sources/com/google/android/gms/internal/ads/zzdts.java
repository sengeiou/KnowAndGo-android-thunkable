package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;

public final class zzdts<T> {
    private final List<zzdtu<T>> zzhup;
    private final List<zzdtu<Collection<T>>> zzhuq;

    private zzdts(int i, int i2) {
        this.zzhup = zzdtf.zzhk(i);
        this.zzhuq = zzdtf.zzhk(i2);
    }

    public final zzdts<T> zzaq(zzdtu<? extends T> zzdtu) {
        this.zzhup.add(zzdtu);
        return this;
    }

    public final zzdts<T> zzar(zzdtu<? extends Collection<? extends T>> zzdtu) {
        this.zzhuq.add(zzdtu);
        return this;
    }

    public final zzdtq<T> zzbbh() {
        return new zzdtq<>(this.zzhup, this.zzhuq);
    }
}
