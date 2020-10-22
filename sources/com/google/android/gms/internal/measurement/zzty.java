package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzty extends zzta<Double> implements zzuu<Double>, zzwg, RandomAccess {
    private static final zzty zzbuz;
    private int size;
    private double[] zzbva;

    zzty() {
        this(new double[10], 0);
    }

    private zzty(double[] dArr, int i) {
        this.zzbva = dArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzua();
        if (i2 >= i) {
            System.arraycopy(this.zzbva, i2, this.zzbva, i, this.size - i2);
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
        if (!(obj instanceof zzty)) {
            return super.equals(obj);
        }
        zzty zzty = (zzty) obj;
        if (this.size != zzty.size) {
            return false;
        }
        double[] dArr = zzty.zzbva;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzbva[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzuq.zzbd(Double.doubleToLongBits(this.zzbva[i2]));
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzd(double d) {
        zzc(this.size, d);
    }

    private final void zzc(int i, double d) {
        zzua();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
        if (this.size < this.zzbva.length) {
            System.arraycopy(this.zzbva, i, this.zzbva, i + 1, this.size - i);
        } else {
            double[] dArr = new double[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzbva, 0, dArr, 0, i);
            System.arraycopy(this.zzbva, i, dArr, i + 1, this.size - i);
            this.zzbva = dArr;
        }
        this.zzbva[i] = d;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof zzty)) {
            return super.addAll(collection);
        }
        zzty zzty = (zzty) collection;
        if (zzty.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size >= zzty.size) {
            int i = this.size + zzty.size;
            if (i > this.zzbva.length) {
                this.zzbva = Arrays.copyOf(this.zzbva, i);
            }
            System.arraycopy(zzty.zzbva, 0, this.zzbva, this.size, zzty.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzua();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzbva[i]))) {
                System.arraycopy(this.zzbva, i + 1, this.zzbva, i, (this.size - i) - 1);
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
        double doubleValue = ((Double) obj).doubleValue();
        zzua();
        zzaj(i);
        double d = this.zzbva[i];
        this.zzbva[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final /* synthetic */ Object remove(int i) {
        zzua();
        zzaj(i);
        double d = this.zzbva[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzbva, i + 1, this.zzbva, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Double) obj).doubleValue());
    }

    public final /* synthetic */ zzuu zzal(int i) {
        if (i >= this.size) {
            return new zzty(Arrays.copyOf(this.zzbva, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzaj(i);
        return Double.valueOf(this.zzbva[i]);
    }

    static {
        zzty zzty = new zzty();
        zzbuz = zzty;
        zzty.zzsw();
    }
}
