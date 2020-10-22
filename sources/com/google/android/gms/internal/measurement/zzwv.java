package com.google.android.gms.internal.measurement;

import java.util.Map;

final class zzwv implements Comparable<zzwv>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzwo zzcca;
    private final K zzccd;

    zzwv(zzwo zzwo, Map.Entry<K, V> entry) {
        this(zzwo, (Comparable) entry.getKey(), entry.getValue());
    }

    zzwv(zzwo zzwo, K k, V v) {
        this.zzcca = zzwo;
        this.zzccd = k;
        this.value = v;
    }

    public final V getValue() {
        return this.value;
    }

    public final V setValue(V v) {
        this.zzcca.zzyf();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return equals(this.zzccd, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.zzccd == null ? 0 : this.zzccd.hashCode();
        if (this.value != null) {
            i = this.value.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzccd);
        String valueOf2 = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final /* synthetic */ Object getKey() {
        return this.zzccd;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzwv) obj).getKey());
    }
}
