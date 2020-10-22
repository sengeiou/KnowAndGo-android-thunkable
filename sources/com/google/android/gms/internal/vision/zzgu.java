package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzgu extends zzex<Integer> implements zzgz<Integer>, zzio, RandomAccess {
    private static final zzgu zzxf;
    private int size;
    private int[] zzxg;

    public static zzgu zzgl() {
        return zzxf;
    }

    zzgu() {
        this(new int[10], 0);
    }

    private zzgu(int[] iArr, int i) {
        this.zzxg = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzdq();
        if (i2 >= i) {
            System.arraycopy(this.zzxg, i2, this.zzxg, i, this.size - i2);
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
        if (!(obj instanceof zzgu)) {
            return super.equals(obj);
        }
        zzgu zzgu = (zzgu) obj;
        if (this.size != zzgu.size) {
            return false;
        }
        int[] iArr = zzgu.zzxg;
        for (int i = 0; i < this.size; i++) {
            if (this.zzxg[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzxg[i2];
        }
        return i;
    }

    public final int getInt(int i) {
        zzae(i);
        return this.zzxg[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzbl(int i) {
        zzdq();
        if (this.size == this.zzxg.length) {
            int[] iArr = new int[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzxg, 0, iArr, 0, this.size);
            this.zzxg = iArr;
        }
        int[] iArr2 = this.zzxg;
        int i2 = this.size;
        this.size = i2 + 1;
        iArr2[i2] = i;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzdq();
        zzgt.checkNotNull(collection);
        if (!(collection instanceof zzgu)) {
            return super.addAll(collection);
        }
        zzgu zzgu = (zzgu) collection;
        if (zzgu.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size >= zzgu.size) {
            int i = this.size + zzgu.size;
            if (i > this.zzxg.length) {
                this.zzxg = Arrays.copyOf(this.zzxg, i);
            }
            System.arraycopy(zzgu.zzxg, 0, this.zzxg, this.size, zzgu.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzdq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzxg[i]))) {
                System.arraycopy(this.zzxg, i + 1, this.zzxg, i, (this.size - i) - 1);
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
        int intValue = ((Integer) obj).intValue();
        zzdq();
        zzae(i);
        int i2 = this.zzxg[i];
        this.zzxg[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzdq();
        zzae(i);
        int i2 = this.zzxg[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzxg, i + 1, this.zzxg, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzdq();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzaf(i));
        }
        if (this.size < this.zzxg.length) {
            System.arraycopy(this.zzxg, i, this.zzxg, i + 1, this.size - i);
        } else {
            int[] iArr = new int[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzxg, 0, iArr, 0, i);
            System.arraycopy(this.zzxg, i, iArr, i + 1, this.size - i);
            this.zzxg = iArr;
        }
        this.zzxg[i] = intValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzbl(((Integer) obj).intValue());
        return true;
    }

    public final /* synthetic */ zzgz zzag(int i) {
        if (i >= this.size) {
            return new zzgu(Arrays.copyOf(this.zzxg, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzgu zzgu = new zzgu(new int[0], 0);
        zzxf = zzgu;
        zzgu.zzdp();
    }
}
