package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzdoq<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzhit;

    public zzdoq(Iterator<Map.Entry<K, Object>> it) {
        this.zzhit = it;
    }

    public final boolean hasNext() {
        return this.zzhit.hasNext();
    }

    public final void remove() {
        this.zzhit.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzhit.next();
        return next.getValue() instanceof zzdon ? new zzdop(next) : next;
    }
}
