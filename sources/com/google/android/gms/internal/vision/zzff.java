package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzff extends zzex<Boolean> implements zzgz<Boolean>, zzio, RandomAccess {
    private static final zzff zzrs;
    private int size;
    private boolean[] zzrt;

    zzff() {
        this(new boolean[10], 0);
    }

    private zzff(boolean[] zArr, int i) {
        this.zzrt = zArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzdq();
        if (i2 >= i) {
            System.arraycopy(this.zzrt, i2, this.zzrt, i, this.size - i2);
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
        if (!(obj instanceof zzff)) {
            return super.equals(obj);
        }
        zzff zzff = (zzff) obj;
        if (this.size != zzff.size) {
            return false;
        }
        boolean[] zArr = zzff.zzrt;
        for (int i = 0; i < this.size; i++) {
            if (this.zzrt[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzgt.zzm(this.zzrt[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void addBoolean(boolean z) {
        zzdq();
        if (this.size == this.zzrt.length) {
            boolean[] zArr = new boolean[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzrt, 0, zArr, 0, this.size);
            this.zzrt = zArr;
        }
        boolean[] zArr2 = this.zzrt;
        int i = this.size;
        this.size = i + 1;
        zArr2[i] = z;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzdq();
        zzgt.checkNotNull(collection);
        if (!(collection instanceof zzff)) {
            return super.addAll(collection);
        }
        zzff zzff = (zzff) collection;
        if (zzff.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size >= zzff.size) {
            int i = this.size + zzff.size;
            if (i > this.zzrt.length) {
                this.zzrt = Arrays.copyOf(this.zzrt, i);
            }
            System.arraycopy(zzff.zzrt, 0, this.zzrt, this.size, zzff.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzdq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zzrt[i]))) {
                System.arraycopy(this.zzrt, i + 1, this.zzrt, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzae(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzaf(i));
        }
    }

    private final String zzaf(int i) {
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
        zzdq();
        zzae(i);
        boolean z = this.zzrt[i];
        this.zzrt[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ Object remove(int i) {
        zzdq();
        zzae(i);
        boolean z = this.zzrt[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzrt, i + 1, this.zzrt, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzdq();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzaf(i));
        }
        if (this.size < this.zzrt.length) {
            System.arraycopy(this.zzrt, i, this.zzrt, i + 1, this.size - i);
        } else {
            boolean[] zArr = new boolean[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzrt, 0, zArr, 0, i);
            System.arraycopy(this.zzrt, i, zArr, i + 1, this.size - i);
            this.zzrt = zArr;
        }
        this.zzrt[i] = booleanValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        addBoolean(((Boolean) obj).booleanValue());
        return true;
    }

    public final /* synthetic */ zzgz zzag(int i) {
        if (i >= this.size) {
            return new zzff(Arrays.copyOf(this.zzrt, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzae(i);
        return Boolean.valueOf(this.zzrt[i]);
    }

    static {
        zzff zzff = new zzff(new boolean[0], 0);
        zzrs = zzff;
        zzff.zzdp();
    }
}
