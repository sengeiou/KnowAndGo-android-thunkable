package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdnl extends zzdml<Double> implements zzdoj<Double>, zzdpw, RandomAccess {
    private static final zzdnl zzhdw;
    private int size;
    private double[] zzhdx;

    zzdnl() {
        this(new double[10], 0);
    }

    private zzdnl(double[] dArr, int i) {
        this.zzhdx = dArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzavk();
        if (i2 >= i) {
            System.arraycopy(this.zzhdx, i2, this.zzhdx, i, this.size - i2);
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
        if (!(obj instanceof zzdnl)) {
            return super.equals(obj);
        }
        zzdnl zzdnl = (zzdnl) obj;
        if (this.size != zzdnl.size) {
            return false;
        }
        double[] dArr = zzdnl.zzhdx;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzhdx[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzdod.zzft(Double.doubleToLongBits(this.zzhdx[i2]));
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzd(double d) {
        zzd(this.size, d);
    }

    private final void zzd(int i, double d) {
        zzavk();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzfk(i));
        }
        if (this.size < this.zzhdx.length) {
            System.arraycopy(this.zzhdx, i, this.zzhdx, i + 1, this.size - i);
        } else {
            double[] dArr = new double[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzhdx, 0, dArr, 0, i);
            System.arraycopy(this.zzhdx, i, dArr, i + 1, this.size - i);
            this.zzhdx = dArr;
        }
        this.zzhdx[i] = d;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzavk();
        zzdod.checkNotNull(collection);
        if (!(collection instanceof zzdnl)) {
            return super.addAll(collection);
        }
        zzdnl zzdnl = (zzdnl) collection;
        if (zzdnl.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size >= zzdnl.size) {
            int i = this.size + zzdnl.size;
            if (i > this.zzhdx.length) {
                this.zzhdx = Arrays.copyOf(this.zzhdx, i);
            }
            System.arraycopy(zzdnl.zzhdx, 0, this.zzhdx, this.size, zzdnl.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzavk();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzhdx[i]))) {
                System.arraycopy(this.zzhdx, i + 1, this.zzhdx, i, (this.size - i) - 1);
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
        double doubleValue = ((Double) obj).doubleValue();
        zzavk();
        zzfj(i);
        double d = this.zzhdx[i];
        this.zzhdx[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final /* synthetic */ Object remove(int i) {
        zzavk();
        zzfj(i);
        double d = this.zzhdx[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzhdx, i + 1, this.zzhdx, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzd(i, ((Double) obj).doubleValue());
    }

    public final /* synthetic */ zzdoj zzfl(int i) {
        if (i >= this.size) {
            return new zzdnl(Arrays.copyOf(this.zzhdx, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzfj(i);
        return Double.valueOf(this.zzhdx[i]);
    }

    static {
        zzdnl zzdnl = new zzdnl(new double[0], 0);
        zzhdw = zzdnl;
        zzdnl.zzavj();
    }
}
