package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

final class zzdpy<E> extends zzdml<E> {
    private static final zzdpy<Object> zzhkm;
    private final List<E> zzhiz;

    public static <E> zzdpy<E> zzazh() {
        return zzhkm;
    }

    zzdpy() {
        this(new ArrayList(10));
    }

    private zzdpy(List<E> list) {
        this.zzhiz = list;
    }

    public final void add(int i, E e) {
        zzavk();
        this.zzhiz.add(i, e);
        this.modCount++;
    }

    public final E get(int i) {
        return this.zzhiz.get(i);
    }

    public final E remove(int i) {
        zzavk();
        E remove = this.zzhiz.remove(i);
        this.modCount++;
        return remove;
    }

    public final E set(int i, E e) {
        zzavk();
        E e2 = this.zzhiz.set(i, e);
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.zzhiz.size();
    }

    public final /* synthetic */ zzdoj zzfl(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzhiz);
            return new zzdpy(arrayList);
        }
        throw new IllegalArgumentException();
    }

    static {
        zzdpy<Object> zzdpy = new zzdpy<>(new ArrayList(0));
        zzhkm = zzdpy;
        zzdpy.zzavj();
    }
}
