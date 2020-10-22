package com.google.android.gms.internal.ads;

final class zzdmw extends zzdnb {
    private final int zzhcv;
    private final int zzhcw;

    zzdmw(byte[] bArr, int i, int i2) {
        super(bArr);
        zzg(i, i + i2, bArr.length);
        this.zzhcv = i;
        this.zzhcw = i2;
    }

    public final byte zzfm(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzhcy[this.zzhcv + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: package-private */
    public final byte zzfn(int i) {
        return this.zzhcy[this.zzhcv + i];
    }

    public final int size() {
        return this.zzhcw;
    }

    /* access modifiers changed from: protected */
    public final int zzavr() {
        return this.zzhcv;
    }

    /* access modifiers changed from: protected */
    public final void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzhcy, zzavr(), bArr, 0, i3);
    }
}
