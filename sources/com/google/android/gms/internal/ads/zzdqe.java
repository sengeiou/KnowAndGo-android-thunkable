package com.google.android.gms.internal.ads;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzdqe<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzheh;
    private final int zzhkr;
    /* access modifiers changed from: private */
    public List<zzdql> zzhks;
    /* access modifiers changed from: private */
    public Map<K, V> zzhkt;
    private volatile zzdqn zzhku;
    /* access modifiers changed from: private */
    public Map<K, V> zzhkv;
    private volatile zzdqh zzhkw;

    static <FieldDescriptorType extends zzdnu<FieldDescriptorType>> zzdqe<FieldDescriptorType, Object> zzgy(int i) {
        return new zzdqf(i);
    }

    private zzdqe(int i) {
        this.zzhkr = i;
        this.zzhks = Collections.emptyList();
        this.zzhkt = Collections.emptyMap();
        this.zzhkv = Collections.emptyMap();
    }

    public void zzavj() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzheh) {
            if (this.zzhkt.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzhkt);
            }
            this.zzhkt = map;
            if (this.zzhkv.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzhkv);
            }
            this.zzhkv = map2;
            this.zzheh = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzheh;
    }

    public final int zzazp() {
        return this.zzhks.size();
    }

    public final Map.Entry<K, V> zzgz(int i) {
        return this.zzhks.get(i);
    }

    public final Iterable<Map.Entry<K, V>> zzazq() {
        if (this.zzhkt.isEmpty()) {
            return zzdqi.zzazv();
        }
        return this.zzhkt.entrySet();
    }

    public int size() {
        return this.zzhks.size() + this.zzhkt.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzhkt.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return this.zzhks.get(zza).getValue();
        }
        return this.zzhkt.get(comparable);
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzazs();
        int zza = zza(k);
        if (zza >= 0) {
            return this.zzhks.get(zza).setValue(v);
        }
        zzazs();
        if (this.zzhks.isEmpty() && !(this.zzhks instanceof ArrayList)) {
            this.zzhks = new ArrayList(this.zzhkr);
        }
        int i = -(zza + 1);
        if (i >= this.zzhkr) {
            return zzazt().put(k, v);
        }
        if (this.zzhks.size() == this.zzhkr) {
            zzdql remove = this.zzhks.remove(this.zzhkr - 1);
            zzazt().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzhks.add(i, new zzdql(this, k, v));
        return null;
    }

    public void clear() {
        zzazs();
        if (!this.zzhks.isEmpty()) {
            this.zzhks.clear();
        }
        if (!this.zzhkt.isEmpty()) {
            this.zzhkt.clear();
        }
    }

    public V remove(Object obj) {
        zzazs();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzha(zza);
        }
        if (this.zzhkt.isEmpty()) {
            return null;
        }
        return this.zzhkt.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V zzha(int i) {
        zzazs();
        V value = this.zzhks.remove(i).getValue();
        if (!this.zzhkt.isEmpty()) {
            Iterator it = zzazt().entrySet().iterator();
            this.zzhks.add(new zzdql(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final int zza(K k) {
        int size = this.zzhks.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzhks.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzhks.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzhku == null) {
            this.zzhku = new zzdqn(this, (zzdqf) null);
        }
        return this.zzhku;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzazr() {
        if (this.zzhkw == null) {
            this.zzhkw = new zzdqh(this, (zzdqf) null);
        }
        return this.zzhkw;
    }

    /* access modifiers changed from: private */
    public final void zzazs() {
        if (this.zzheh) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzazt() {
        zzazs();
        if (this.zzhkt.isEmpty() && !(this.zzhkt instanceof TreeMap)) {
            this.zzhkt = new TreeMap();
            this.zzhkv = ((TreeMap) this.zzhkt).descendingMap();
        }
        return (SortedMap) this.zzhkt;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdqe)) {
            return super.equals(obj);
        }
        zzdqe zzdqe = (zzdqe) obj;
        int size = size();
        if (size != zzdqe.size()) {
            return false;
        }
        int zzazp = zzazp();
        if (zzazp != zzdqe.zzazp()) {
            return entrySet().equals(zzdqe.entrySet());
        }
        for (int i = 0; i < zzazp; i++) {
            if (!zzgz(i).equals(zzdqe.zzgz(i))) {
                return false;
            }
        }
        if (zzazp != size) {
            return this.zzhkt.equals(zzdqe.zzhkt);
        }
        return true;
    }

    public int hashCode() {
        int zzazp = zzazp();
        int i = 0;
        for (int i2 = 0; i2 < zzazp; i2++) {
            i += this.zzhks.get(i2).hashCode();
        }
        return this.zzhkt.size() > 0 ? i + this.zzhkt.hashCode() : i;
    }

    /* synthetic */ zzdqe(int i, zzdqf zzdqf) {
        this(i);
    }
}
