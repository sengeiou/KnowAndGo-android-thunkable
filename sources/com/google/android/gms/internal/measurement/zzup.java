package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzup extends zzta<Integer> implements zzuu<Integer>, zzwg, RandomAccess {
    private static final zzup zzbza;
    private int size;
    private int[] zzbzb;

    zzup() {
        this(new int[10], 0);
    }

    private zzup(int[] iArr, int i) {
        this.zzbzb = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzua();
        if (i2 >= i) {
            System.arraycopy(this.zzbzb, i2, this.zzbzb, i, this.size - i2);
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
        if (!(obj instanceof zzup)) {
            return super.equals(obj);
        }
        zzup zzup = (zzup) obj;
        if (this.size != zzup.size) {
            return false;
        }
        int[] iArr = zzup.zzbzb;
        for (int i = 0; i < this.size; i++) {
            if (this.zzbzb[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzbzb[i2];
        }
        return i;
    }

    public final int getInt(int i) {
        zzaj(i);
        return this.zzbzb[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzbo(int i) {
        zzp(this.size, i);
    }

    private final void zzp(int i, int i2) {
        zzua();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
        if (this.size < this.zzbzb.length) {
            System.arraycopy(this.zzbzb, i, this.zzbzb, i + 1, this.size - i);
        } else {
            int[] iArr = new int[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzbzb, 0, iArr, 0, i);
            System.arraycopy(this.zzbzb, i, iArr, i + 1, this.size - i);
            this.zzbzb = iArr;
        }
        this.zzbzb[i] = i2;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof zzup)) {
            return super.addAll(collection);
        }
        zzup zzup = (zzup) collection;
        if (zzup.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size >= zzup.size) {
            int i = this.size + zzup.size;
            if (i > this.zzbzb.length) {
                this.zzbzb = Arrays.copyOf(this.zzbzb, i);
            }
            System.arraycopy(zzup.zzbzb, 0, this.zzbzb, this.size, zzup.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzua();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzbzb[i]))) {
                System.arraycopy(this.zzbzb, i + 1, this.zzbzb, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzaj(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
    }

    private final String zzak(int i) {
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
        zzua();
        zzaj(i);
        int i2 = this.zzbzb[i];
        this.zzbzb[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzua();
        zzaj(i);
        int i2 = this.zzbzb[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzbzb, i + 1, this.zzbzb, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzp(i, ((Integer) obj).intValue());
    }

    public final /* synthetic */ zzuu zzal(int i) {
        if (i >= this.size) {
            return new zzup(Arrays.copyOf(this.zzbzb, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzup zzup = new zzup();
        zzbza = zzup;
        zzup.zzsw();
    }
}
