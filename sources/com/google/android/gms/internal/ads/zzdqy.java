package com.google.android.gms.internal.ads;

import java.util.Iterator;

final class zzdqy implements Iterator<String> {
    private final /* synthetic */ zzdqw zzhlk;
    private Iterator<String> zzhll = this.zzhlk.zzhlh.iterator();

    zzdqy(zzdqw zzdqw) {
        this.zzhlk = zzdqw;
    }

    public final boolean hasNext() {
        return this.zzhll.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.zzhll.next();
    }
}
