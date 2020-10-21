package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdmp extends zzdml<Boolean> implements zzdoj<Boolean>, zzdpw, RandomAccess {
    private static final zzdmp zzhcp;
    private int size;
    private boolean[] zzhcq;

    zzdmp() {
        this(new boolean[10], 0);
    }

    private zzdmp(boolean[] zArr, int i) {
        this.zzhcq = zArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzavk();
        if (i2 >= i) {
            System.arraycopy(this.zzhcq, i2, this.zzhcq, i, this.size - i2);
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
        if (!(obj instanceof zzdmp)) {
            return super.equals(obj);
        }
        zzdmp zzdmp = (zzdmp) obj;
        if (this.size != zzdmp.size) {
            return false;
        }
        boolean[] zArr = zzdmp.zzhcq;
        for (int i = 0; i < this.size; i++) {
            if (this.zzhcq[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzdod.zzbh(this.zzhcq[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void addBoolean(boolean z) {
        zzh(this.size, z);
    }

    private final void zzh(int i, boolean z) {
        zzavk();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzfk(i));
        }
        if (this.size < this.zzhcq.length) {
            System.arraycopy(this.zzhcq, i, this.zzhcq, i + 1, this.size - i);
        } else {
            boolean[] zArr = new boolean[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzhcq, 0, zArr, 0, i);
            System.arraycopy(this.zzhcq, i, zArr, i + 1, this.size - i);
            this.zzhcq = zArr;
        }
        this.zzhcq[i] = z;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzavk();
        zzdod.checkNotNull(collection);
        if (!(collection instanceof zzdmp)) {
            return super.addAll(collection);
        }
        zzdmp zzdmp = (zzdmp) collection;
        if (zzdmp.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size >= zzdmp.size) {
            int i = this.size + zzdmp.size;
            if (i > this.zzhcq.length) {
                this.zzhcq = Arrays.copyOf(this.zzhcq, i);
            }
            System.arraycopy(zzdmp.zzhcq, 0, this.zzhcq, this.size, zzdmp.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzavk();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zzhcq[i]))) {
                System.arraycopy(this.zzhcq, i + 1, this.zzhcq, i, (this.size - i) - 1);
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzavk();
        zzfj(i);
        boolean z = this.zzhcq[i];
        this.zzhcq[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ Object remove(int i) {
        zzavk();
        zzfj(i);
        boolean z = this.zzhcq[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzhcq, i + 1, this.zzhcq, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzh(i, ((Boolean) obj).booleanValue());
    }

    public final /* synthetic */ zzdoj zzfl(int i) {
        if (i >= this.size) {
            return new zzdmp(Arrays.copyOf(this.zzhcq, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzfj(i);
        return Boolean.valueOf(this.zzhcq[i]);
    }

    static {
        zzdmp zzdmp = new zzdmp(new boolean[0], 0);
        zzhcp = zzdmp;
        zzdmp.zzavj();
    }
}
