package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class zzdqn extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzdqe zzhky;

    private zzdqn(zzdqe zzdqe) {
        this.zzhky = zzdqe;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzdqm(this.zzhky, (zzdqf) null);
    }

    public int size() {
        return this.zzhky.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzhky.get(entry.getKey());
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
        this.zzhky.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzhky.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzhky.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzdqn(zzdqe zzdqe, zzdqf zzdqf) {
        this(zzdqe);
    }
}
