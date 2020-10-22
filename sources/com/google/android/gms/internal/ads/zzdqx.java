package com.google.android.gms.internal.ads;

import java.util.ListIterator;

final class zzdqx implements ListIterator<String> {
    private ListIterator<String> zzhli = this.zzhlk.zzhlh.listIterator(this.zzhlj);
    private final /* synthetic */ int zzhlj;
    private final /* synthetic */ zzdqw zzhlk;

    zzdqx(zzdqw zzdqw, int i) {
        this.zzhlk = zzdqw;
        this.zzhlj = i;
    }

    public final boolean hasNext() {
        return this.zzhli.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzhli.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzhli.nextIndex();
    }

    public final int previousIndex() {
        return this.zzhli.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object previous() {
        return this.zzhli.previous();
    }

    public final /* synthetic */ Object next() {
        return this.zzhli.next();
    }
}
