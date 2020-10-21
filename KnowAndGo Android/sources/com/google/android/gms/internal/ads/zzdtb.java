package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

final class zzdtb implements Iterator<E> {
    private int pos = 0;
    private final /* synthetic */ zzdta zzhtx;

    zzdtb(zzdta zzdta) {
        this.zzhtx = zzdta;
    }

    public final boolean hasNext() {
        return this.pos < this.zzhtx.zzhtv.size() || this.zzhtx.zzhtw.hasNext();
    }

    public final E next() {
        while (this.pos >= this.zzhtx.zzhtv.size()) {
            this.zzhtx.zzhtv.add(this.zzhtx.zzhtw.next());
        }
        List<E> list = this.zzhtx.zzhtv;
        int i = this.pos;
        this.pos = i + 1;
        return list.get(i);
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
