package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdoy extends zzdml<Long> implements zzdoj<Long>, zzdpw, RandomAccess {
    private static final zzdoy zzhjd;
    private int size;
    private long[] zzhje;

    zzdoy() {
        this(new long[10], 0);
    }

    private zzdoy(long[] jArr, int i) {
        this.zzhje = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzavk();
        if (i2 >= i) {
            System.arraycopy(this.zzhje, i2, this.zzhje, i, this.size - i2);
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
        if (!(obj instanceof zzdoy)) {
            return super.equals(obj);
        }
        zzdoy zzdoy = (zzdoy) obj;
        if (this.size != zzdoy.size) {
            return false;
        }
        long[] jArr = zzdoy.zzhje;
        for (int i = 0; i < this.size; i++) {
            if (this.zzhje[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzdod.zzft(this.zzhje[i2]);
        }
        return i;
    }

    public final long getLong(int i) {
        zzfj(i);
        return this.zzhje[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzfu(long j) {
        zzr(this.size, j);
    }

    private final void zzr(int i, long j) {
        zzavk();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzfk(i));
        }
        if (this.size < this.zzhje.length) {
            System.arraycopy(this.zzhje, i, this.zzhje, i + 1, this.size - i);
        } else {
            long[] jArr = new long[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzhje, 0, jArr, 0, i);
            System.arraycopy(this.zzhje, i, jArr, i + 1, this.size - i);
            this.zzhje = jArr;
        }
        this.zzhje[i] = j;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzavk();
        zzdod.checkNotNull(collection);
        if (!(collection instanceof zzdoy)) {
            return super.addAll(collection);
        }
        zzdoy zzdoy = (zzdoy) collection;
        if (zzdoy.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size >= zzdoy.size) {
            int i = this.size + zzdoy.size;
            if (i > this.zzhje.length) {
                this.zzhje = Arrays.copyOf(this.zzhje, i);
            }
            System.arraycopy(zzdoy.zzhje, 0, this.zzhje, this.size, zzdoy.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzavk();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzhje[i]))) {
                System.arraycopy(this.zzhje, i + 1, this.zzhje, i, (this.size - i) - 1);
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
        long longValue = ((Long) obj).longValue();
        zzavk();
        zzfj(i);
        long j = this.zzhje[i];
        this.zzhje[i] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i) {
        zzavk();
        zzfj(i);
        long j = this.zzhje[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzhje, i + 1, this.zzhje, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzr(i, ((Long) obj).longValue());
    }

    public final /* synthetic */ zzdoj zzfl(int i) {
        if (i >= this.size) {
            return new zzdoy(Arrays.copyOf(this.zzhje, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        zzdoy zzdoy = new zzdoy(new long[0], 0);
        zzhjd = zzdoy;
        zzdoy.zzavj();
    }
}
