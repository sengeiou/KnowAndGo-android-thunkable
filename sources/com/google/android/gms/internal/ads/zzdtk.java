package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class zzdtk<K, V> implements zzdti<Map<K, V>> {
    private static final zzdtu<Map<Object, Object>> zzhuk = zzdtj.zzar(Collections.emptyMap());
    private final Map<K, zzdtu<V>> zzhul;

    public static <K, V> zzdtm<K, V> zzho(int i) {
        return new zzdtm<>(i);
    }

    private zzdtk(Map<K, zzdtu<V>> map) {
        this.zzhul = Collections.unmodifiableMap(map);
    }

    public final /* synthetic */ Object get() {
        LinkedHashMap zzhm = zzdtf.zzhm(this.zzhul.size());
        for (Map.Entry next : this.zzhul.entrySet()) {
            zzhm.put(next.getKey(), ((zzdtu) next.getValue()).get());
        }
        return Collections.unmodifiableMap(zzhm);
    }
}
