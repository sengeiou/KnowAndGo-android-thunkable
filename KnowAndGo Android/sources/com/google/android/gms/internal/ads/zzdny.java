package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdny extends zzdml<Float> implements zzdoj<Float>, zzdpw, RandomAccess {
    private static final zzdny zzhgz;
    private int size;
    private float[] zzhha;

    zzdny() {
        this(new float[10], 0);
    }

    private zzdny(float[] fArr, int i) {
        this.zzhha = fArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzavk();
        if (i2 >= i) {
            System.arraycopy(this.zzhha, i2, this.zzhha, i, this.size - i2);
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
        if (!(obj instanceof zzdny)) {
            return super.equals(obj);
        }
        zzdny zzdny = (zzdny) obj;
        if (this.size != zzdny.size) {
            return false;
        }
        float[] fArr = zzdny.zzhha;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzhha[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzhha[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzi(float f) {
        zzc(this.size, f);
    }

    private final void zzc(int i, float f) {
        zzavk();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzfk(i));
        }
        if (this.size < this.zzhha.length) {
            System.arraycopy(this.zzhha, i, this.zzhha, i + 1, this.size - i);
        } else {
            float[] fArr = new float[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzhha, 0, fArr, 0, i);
            System.arraycopy(this.zzhha, i, fArr, i + 1, this.size - i);
            this.zzhha = fArr;
        }
        this.zzhha[i] = f;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzavk();
        zzdod.checkNotNull(collection);
        if (!(collection instanceof zzdny)) {
            return super.addAll(collection);
        }
        zzdny zzdny = (zzdny) collection;
        if (zzdny.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size >= zzdny.size) {
            int i = this.size + zzdny.size;
            if (i > this.zzhha.length) {
                this.zzhha = Arrays.copyOf(this.zzhha, i);
            }
            System.arraycopy(zzdny.zzhha, 0, this.zzhha, this.size, zzdny.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzavk();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzhha[i]))) {
                System.arraycopy(this.zzhha, i + 1, this.zzhha, i, (this.size - i) - 1);
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
        float floatValue = ((Float) obj).floatValue();
        zzavk();
        zzfj(i);
        float f = this.zzhha[i];
        this.zzhha[i] = floatValue;
        return Float.valueOf(f);
    }

    public final /* synthetic */ Object remove(int i) {
        zzavk();
        zzfj(i);
        float f = this.zzhha[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzhha, i + 1, this.zzhha, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Float) obj).floatValue());
    }

    public final /* synthetic */ zzdoj zzfl(int i) {
        if (i >= this.size) {
            return new zzdny(Arrays.copyOf(this.zzhha, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzfj(i);
        return Float.valueOf(this.zzhha[i]);
    }

    static {
        zzdny zzdny = new zzdny(new float[0], 0);
        zzhgz = zzdny;
        zzdny.zzavj();
    }
}
