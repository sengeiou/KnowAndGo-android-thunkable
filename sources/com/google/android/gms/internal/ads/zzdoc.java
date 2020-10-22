package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdoc extends zzdml<Integer> implements zzdoh, zzdpw, RandomAccess {
    private static final zzdoc zzhhy;
    private int size;
    private int[] zzhhz;

    public static zzdoc zzayc() {
        return zzhhy;
    }

    zzdoc() {
        this(new int[10], 0);
    }

    private zzdoc(int[] iArr, int i) {
        this.zzhhz = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzavk();
        if (i2 >= i) {
            System.arraycopy(this.zzhhz, i2, this.zzhhz, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdoc)) {
            return super.equals(obj);
        }
        zzdoc zzdoc = (zzdoc) obj;
        if (this.size != zzdoc.size) {
            return false;
        }
        int[] iArr = zzdoc.zzhhz;
        for (int i = 0; i < this.size; i++) {
            if (this.zzhhz[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzhhz[i2];
        }
        return i;
    }

    /* renamed from: zzgo */
    public final zzdoh zzfl(int i) {
        if (i >= this.size) {
            return new zzdoc(Arrays.copyOf(this.zzhhz, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final int getInt(int i) {
        zzfj(i);
        return this.zzhhz[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzgp(int i) {
        zzaj(this.size, i);
    }

    private final void zzaj(int i, int i2) {
        zzavk();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzfk(i));
        }
        if (this.size < this.zzhhz.length) {
            System.arraycopy(this.zzhhz, i, this.zzhhz, i + 1, this.size - i);
        } else {
            int[] iArr = new int[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzhhz, 0, iArr, 0, i);
            System.arraycopy(this.zzhhz, i, iArr, i + 1, this.size - i);
            this.zzhhz = iArr;
        }
        this.zzhhz[i] = i2;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzavk();
        zzdod.checkNotNull(collection);
        if (!(collection instanceof zzdoc)) {
            return super.addAll(collection);
        }
        zzdoc zzdoc = (zzdoc) collection;
        if (zzdoc.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size >= zzdoc.size) {
            int i = this.size + zzdoc.size;
            if (i > this.zzhhz.length) {
                this.zzhhz = Arrays.copyOf(this.zzhhz, i);
            }
            System.arraycopy(zzdoc.zzhhz, 0, this.zzhhz, this.size, zzdoc.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzavk();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzhhz[i]))) {
                System.arraycopy(this.zzhhz, i + 1, this.zzhhz, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzfj(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzfk(i));
        }
    }

    private final String zzfk(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzavk();
        zzfj(i);
        int i2 = this.zzhhz[i];
        this.zzhhz[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzavk();
        zzfj(i);
        int i2 = this.zzhhz[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzhhz, i + 1, this.zzhhz, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzaj(i, ((Integer) obj).intValue());
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzdoc zzdoc = new zzdoc(new int[0], 0);
        zzhhy = zzdoc;
        zzdoc.zzavj();
    }
}
