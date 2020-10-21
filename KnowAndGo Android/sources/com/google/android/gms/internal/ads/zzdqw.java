package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzdqw extends AbstractList<String> implements zzdot, RandomAccess {
    /* access modifiers changed from: private */
    public final zzdot zzhlh;

    public zzdqw(zzdot zzdot) {
        this.zzhlh = zzdot;
    }

    public final zzdot zzayp() {
        return this;
    }

    public final Object zzgq(int i) {
        return this.zzhlh.zzgq(i);
    }

    public final int size() {
        return this.zzhlh.size();
    }

    public final void zzdb(zzdmr zzdmr) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzdqx(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzdqy(this);
    }

    public final List<?> zzayo() {
        return this.zzhlh.zzayo();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzhlh.get(i);
    }
}
