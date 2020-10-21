package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzgo extends zzex<Float> implements zzgz<Float>, zzio, RandomAccess {
    private static final zzgo zzvq;
    private int size;
    private float[] zzvr;

    zzgo() {
        this(new float[10], 0);
    }

    private zzgo(float[] fArr, int i) {
        this.zzvr = fArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzdq();
        if (i2 >= i) {
            System.arraycopy(this.zzvr, i2, this.zzvr, i, this.size - i2);
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
        if (!(obj instanceof zzgo)) {
            return super.equals(obj);
        }
        zzgo zzgo = (zzgo) obj;
        if (this.size != zzgo.size) {
            return false;
        }
        float[] fArr = zzgo.zzvr;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzvr[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzvr[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzu(float f) {
        zzdq();
        if (this.size == this.zzvr.length) {
            float[] fArr = new float[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzvr, 0, fArr, 0, this.size);
            this.zzvr = fArr;
        }
        float[] fArr2 = this.zzvr;
        int i = this.size;
        this.size = i + 1;
        fArr2[i] = f;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzdq();
        zzgt.checkNotNull(collection);
        if (!(collection instanceof zzgo)) {
            return super.addAll(collection);
        }
        zzgo zzgo = (zzgo) collection;
        if (zzgo.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size >= zzgo.size) {
            int i = this.size + zzgo.size;
            if (i > this.zzvr.length) {
                this.zzvr = Arrays.copyOf(this.zzvr, i);
            }
            System.arraycopy(zzgo.zzvr, 0, this.zzvr, this.size, zzgo.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzdq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzvr[i]))) {
                System.arraycopy(this.zzvr, i + 1, this.zzvr, i, (this.size - i) - 1);
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
        float floatValue = ((Float) obj).floatValue();
        zzdq();
        zzae(i);
        float f = this.zzvr[i];
        this.zzvr[i] = floatValue;
        return Float.valueOf(f);
    }

    public final /* synthetic */ Object remove(int i) {
        zzdq();
        zzae(i);
        float f = this.zzvr[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzvr, i + 1, this.zzvr, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzdq();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzaf(i));
        }
        if (this.size < this.zzvr.length) {
            System.arraycopy(this.zzvr, i, this.zzvr, i + 1, this.size - i);
        } else {
            float[] fArr = new float[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzvr, 0, fArr, 0, i);
            System.arraycopy(this.zzvr, i, fArr, i + 1, this.size - i);
            this.zzvr = fArr;
        }
        this.zzvr[i] = floatValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzu(((Float) obj).floatValue());
        return true;
    }

    public final /* synthetic */ zzgz zzag(int i) {
        if (i >= this.size) {
            return new zzgo(Arrays.copyOf(this.zzvr, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzae(i);
        return Float.valueOf(this.zzvr[i]);
    }

    static {
        zzgo zzgo = new zzgo(new float[0], 0);
        zzvq = zzgo;
        zzgo.zzdp();
    }
}
