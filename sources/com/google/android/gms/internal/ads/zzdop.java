package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzdop<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzdon> zzhis;

    private zzdop(Map.Entry<K, zzdon> entry) {
        this.zzhis = entry;
    }

    public final K getKey() {
        return this.zzhis.getKey();
    }

    public final Object getValue() {
        if (this.zzhis.getValue() == null) {
            return null;
        }
        return zzdon.zzaym();
    }

    public final zzdon zzayn() {
        return this.zzhis.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzdpk) {
            return this.zzhis.getValue().zzq((zzdpk) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
