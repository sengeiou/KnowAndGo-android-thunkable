package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzwq implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzcbz;
    private final /* synthetic */ zzwo zzcca;

    private zzwq(zzwo zzwo) {
        this.zzcca = zzwo;
        this.pos = this.zzcca.zzcbu.size();
    }

    public final boolean hasNext() {
        return (this.pos > 0 && this.pos <= this.zzcca.zzcbu.size()) || zzyh().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zzyh() {
        if (this.zzcbz == null) {
            this.zzcbz = this.zzcca.zzcbx.entrySet().iterator();
        }
        return this.zzcbz;
    }

    public final /* synthetic */ Object next() {
        if (zzyh().hasNext()) {
            return (Map.Entry) zzyh().next();
        }
        List zzb = this.zzcca.zzcbu;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) zzb.get(i);
    }

    /* synthetic */ zzwq(zzwo zzwo, zzwp zzwp) {
        this(zzwo);
    }
}
