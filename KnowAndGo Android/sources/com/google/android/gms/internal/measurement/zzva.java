package com.google.android.gms.internal.measurement;

import java.util.Map;

final class zzva<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzuy> zzbzu;

    private zzva(Map.Entry<K, zzuy> entry) {
        this.zzbzu = entry;
    }

    public final K getKey() {
        return this.zzbzu.getKey();
    }

    public final Object getValue() {
        if (this.zzbzu.getValue() == null) {
            return null;
        }
        return zzuy.zzwz();
    }

    public final zzuy zzxa() {
        return this.zzbzu.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzvv) {
            return this.zzbzu.getValue().zzi((zzvv) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
