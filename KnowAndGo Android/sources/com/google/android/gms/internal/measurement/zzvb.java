package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzvb<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzbzv;

    public zzvb(Iterator<Map.Entry<K, Object>> it) {
        this.zzbzv = it;
    }

    public final boolean hasNext() {
        return this.zzbzv.hasNext();
    }

    public final void remove() {
        this.zzbzv.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzbzv.next();
        return next.getValue() instanceof zzuy ? new zzva(next) : next;
    }
}
