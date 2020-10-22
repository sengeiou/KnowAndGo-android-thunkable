package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

public final class zzdtm<K, V> {
    private final LinkedHashMap<K, zzdtu<V>> zzhum;

    private zzdtm(int i) {
        this.zzhum = zzdtf.zzhm(i);
    }

    public final zzdtm<K, V> zza(K k, zzdtu<V> zzdtu) {
        this.zzhum.put(zzdto.zza(k, "key"), (zzdtu) zzdto.zza(zzdtu, "provider"));
        return this;
    }

    public final zzdtk<K, V> zzbbf() {
        return new zzdtk<>(this.zzhum);
    }
}
