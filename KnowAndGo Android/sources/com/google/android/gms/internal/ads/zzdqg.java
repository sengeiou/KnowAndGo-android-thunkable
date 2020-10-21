package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzdqg implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzhkx;
    private final /* synthetic */ zzdqe zzhky;

    private zzdqg(zzdqe zzdqe) {
        this.zzhky = zzdqe;
        this.pos = this.zzhky.zzhks.size();
    }

    public final boolean hasNext() {
        return (this.pos > 0 && this.pos <= this.zzhky.zzhks.size()) || zzazu().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zzazu() {
        if (this.zzhkx == null) {
            this.zzhkx = this.zzhky.zzhkv.entrySet().iterator();
        }
        return this.zzhkx;
    }

    public final /* synthetic */ Object next() {
        if (zzazu().hasNext()) {
            return (Map.Entry) zzazu().next();
        }
        List zzb = this.zzhky.zzhks;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) zzb.get(i);
    }

    /* synthetic */ zzdqg(zzdqe zzdqe, zzdqf zzdqf) {
        this(zzdqe);
    }
}
