package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzdos extends zzdml<String> implements zzdot, RandomAccess {
    private static final zzdos zzhix;
    private static final zzdot zzhiy = zzhix;
    private final List<Object> zzhiz;

    public zzdos() {
        this(10);
    }

    public zzdos(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzdos(ArrayList<Object> arrayList) {
        this.zzhiz = arrayList;
    }

    public final int size() {
        return this.zzhiz.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzavk();
        if (collection instanceof zzdot) {
            collection = ((zzdot) collection).zzayo();
        }
        boolean addAll = this.zzhiz.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzavk();
        this.zzhiz.clear();
        this.modCount++;
    }

    public final void zzdb(zzdmr zzdmr) {
        zzavk();
        this.zzhiz.add(zzdmr);
        this.modCount++;
    }

    public final Object zzgq(int i) {
        return this.zzhiz.get(i);
    }

    private static String zzac(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdmr) {
            return ((zzdmr) obj).zzavn();
        }
        return zzdod.zzae((byte[]) obj);
    }

    public final List<?> zzayo() {
        return Collections.unmodifiableList(this.zzhiz);
    }

    public final zzdot zzayp() {
        return zzavi() ? new zzdqw(this) : this;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        zzavk();
        return zzac(this.zzhiz.set(i, (String) obj));
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* synthetic */ Object remove(int i) {
        zzavk();
        Object remove = this.zzhiz.remove(i);
        this.modCount++;
        return zzac(remove);
    }

    public final /* bridge */ /* synthetic */ boolean zzavi() {
        return super.zzavi();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzavk();
        this.zzhiz.add(i, (String) obj);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ zzdoj zzfl(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzhiz);
            return new zzdos((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzhiz.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdmr) {
            zzdmr zzdmr = (zzdmr) obj;
            String zzavn = zzdmr.zzavn();
            if (zzdmr.zzavo()) {
                this.zzhiz.set(i, zzavn);
            }
            return zzavn;
        }
        byte[] bArr = (byte[]) obj;
        String zzae = zzdod.zzae(bArr);
        if (zzdod.zzad(bArr)) {
            this.zzhiz.set(i, zzae);
        }
        return zzae;
    }

    static {
        zzdos zzdos = new zzdos();
        zzhix = zzdos;
        zzdos.zzavj();
    }
}
