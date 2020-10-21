package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzdql implements Comparable<zzdql>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzdqe zzhky;
    private final K zzhlb;

    zzdql(zzdqe zzdqe, Map.Entry<K, V> entry) {
        this(zzdqe, (Comparable) entry.getKey(), entry.getValue());
    }

    zzdql(zzdqe zzdqe, K k, V v) {
        this.zzhky = zzdqe;
        this.zzhlb = k;
        this.value = v;
    }

    public final V getValue() {
        return this.value;
    }

    public final V setValue(V v) {
        this.zzhky.zzazs();
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
        return equals(this.zzhlb, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.zzhlb == null ? 0 : this.zzhlb.hashCode();
        if (this.value != null) {
            i = this.value.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzhlb);
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
        return this.zzhlb;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzdql) obj).getKey());
    }
}
