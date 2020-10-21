package com.google.android.gms.internal.ads;

public final class zzdrt implements Cloneable {
    private static final zzdru zzhnq = new zzdru();
    private int mSize;
    private boolean zzhnr;
    private int[] zzhns;
    private zzdru[] zzhnt;

    zzdrt() {
        this(10);
    }

    private zzdrt(int i) {
        this.zzhnr = false;
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        int i5 = i2 / 4;
        this.zzhns = new int[i5];
        this.zzhnt = new zzdru[i5];
        this.mSize = 0;
    }

    /* access modifiers changed from: package-private */
    public final int size() {
        return this.mSize;
    }

    /* access modifiers changed from: package-private */
    public final zzdru zzhf(int i) {
        return this.zzhnt[i];
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdrt)) {
            return false;
        }
        zzdrt zzdrt = (zzdrt) obj;
        if (this.mSize != zzdrt.mSize) {
            return false;
        }
        int[] iArr = this.zzhns;
        int[] iArr2 = zzdrt.zzhns;
        int i = this.mSize;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            } else if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            zzdru[] zzdruArr = this.zzhnt;
            zzdru[] zzdruArr2 = zzdrt.zzhnt;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!zzdruArr[i4].equals(zzdruArr2[i4])) {
                    z2 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzhns[i2]) * 31) + this.zzhnt[i2].hashCode();
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzdrt zzdrt = new zzdrt(i);
        System.arraycopy(this.zzhns, 0, zzdrt.zzhns, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzhnt[i2] != null) {
                zzdrt.zzhnt[i2] = (zzdru) this.zzhnt[i2].clone();
            }
        }
        zzdrt.mSize = i;
        return zzdrt;
    }
}
