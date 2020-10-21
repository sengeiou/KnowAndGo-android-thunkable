package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzgb extends zzex<Double> implements zzgz<Double>, zzio, RandomAccess {
    private static final zzgb zzst;
    private int size;
    private double[] zzsu;

    zzgb() {
        this(new double[10], 0);
    }

    private zzgb(double[] dArr, int i) {
        this.zzsu = dArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzdq();
        if (i2 >= i) {
            System.arraycopy(this.zzsu, i2, this.zzsu, i, this.size - i2);
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
        if (!(obj instanceof zzgb)) {
            return super.equals(obj);
        }
        zzgb zzgb = (zzgb) obj;
        if (this.size != zzgb.size) {
            return false;
        }
        double[] dArr = zzgb.zzsu;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzsu[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzgt.zzab(Double.doubleToLongBits(this.zzsu[i2]));
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(double d) {
        zzdq();
        if (this.size == this.zzsu.length) {
            double[] dArr = new double[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzsu, 0, dArr, 0, this.size);
            this.zzsu = dArr;
        }
        double[] dArr2 = this.zzsu;
        int i = this.size;
        this.size = i + 1;
        dArr2[i] = d;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzdq();
        zzgt.checkNotNull(collection);
        if (!(collection instanceof zzgb)) {
            return super.addAll(collection);
        }
        zzgb zzgb = (zzgb) collection;
        if (zzgb.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size >= zzgb.size) {
            int i = this.size + zzgb.size;
            if (i > this.zzsu.length) {
                this.zzsu = Arrays.copyOf(this.zzsu, i);
            }
            System.arraycopy(zzgb.zzsu, 0, this.zzsu, this.size, zzgb.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzdq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzsu[i]))) {
                System.arraycopy(this.zzsu, i + 1, this.zzsu, i, (this.size - i) - 1);
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
        double doubleValue = ((Double) obj).doubleValue();
        zzdq();
        zzae(i);
        double d = this.zzsu[i];
        this.zzsu[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final /* synthetic */ Object remove(int i) {
        zzdq();
        zzae(i);
        double d = this.zzsu[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzsu, i + 1, this.zzsu, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzdq();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzaf(i));
        }
        if (this.size < this.zzsu.length) {
            System.arraycopy(this.zzsu, i, this.zzsu, i + 1, this.size - i);
        } else {
            double[] dArr = new double[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzsu, 0, dArr, 0, i);
            System.arraycopy(this.zzsu, i, dArr, i + 1, this.size - i);
            this.zzsu = dArr;
        }
        this.zzsu[i] = doubleValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzc(((Double) obj).doubleValue());
        return true;
    }

    public final /* synthetic */ zzgz zzag(int i) {
        if (i >= this.size) {
            return new zzgb(Arrays.copyOf(this.zzsu, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzae(i);
        return Double.valueOf(this.zzsu[i]);
    }

    static {
        zzgb zzgb = new zzgb(new double[0], 0);
        zzst = zzgb;
        zzgb.zzdp();
    }
}
