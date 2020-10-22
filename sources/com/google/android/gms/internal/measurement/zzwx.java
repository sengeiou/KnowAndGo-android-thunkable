package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class zzwx extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzwo zzcca;

    private zzwx(zzwo zzwo) {
        this.zzcca = zzwo;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzww(this.zzcca, (zzwp) null);
    }

    public int size() {
        return this.zzcca.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzcca.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzcca.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzcca.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzcca.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzwx(zzwo zzwo, zzwp zzwp) {
        this(zzwo);
    }
}
