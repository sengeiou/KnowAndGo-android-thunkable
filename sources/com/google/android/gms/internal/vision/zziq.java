package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zziq<E> extends zzex<E> implements RandomAccess {
    private static final zziq<Object> zzzq;
    private int size;
    private E[] zzlu;

    public static <E> zziq<E> zzhr() {
        return zzzq;
    }

    zziq() {
        this(new Object[10], 0);
    }

    private zziq(E[] eArr, int i) {
        this.zzlu = eArr;
        this.size = i;
    }

    public final boolean add(E e) {
        zzdq();
        if (this.size == this.zzlu.length) {
            this.zzlu = Arrays.copyOf(this.zzlu, ((this.size * 3) / 2) + 1);
        }
        E[] eArr = this.zzlu;
        int i = this.size;
        this.size = i + 1;
        eArr[i] = e;
        this.modCount++;
        return true;
    }

    public final void add(int i, E e) {
        zzdq();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzaf(i));
        }
        if (this.size < this.zzlu.length) {
            System.arraycopy(this.zzlu, i, this.zzlu, i + 1, this.size - i);
        } else {
            E[] eArr = new Object[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzlu, 0, eArr, 0, i);
            System.arraycopy(this.zzlu, i, eArr, i + 1, this.size - i);
            this.zzlu = eArr;
        }
        this.zzlu[i] = e;
        this.size++;
        this.modCount++;
    }

    public final E get(int i) {
        zzae(i);
        return this.zzlu[i];
    }

    public final E remove(int i) {
        zzdq();
        zzae(i);
        E e = this.zzlu[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzlu, i + 1, this.zzlu, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return e;
    }

    public final E set(int i, E e) {
        zzdq();
        zzae(i);
        E e2 = this.zzlu[i];
        this.zzlu[i] = e;
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.size;
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

    public final /* synthetic */ zzgz zzag(int i) {
        if (i >= this.size) {
            return new zziq(Arrays.copyOf(this.zzlu, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    static {
        zziq<Object> zziq = new zziq<>(new Object[0], 0);
        zzzq = zziq;
        zziq.zzdp();
    }
}
