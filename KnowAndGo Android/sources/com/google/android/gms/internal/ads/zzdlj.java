package com.google.android.gms.internal.ads;

public final class zzdlj {
    private final byte[] data;

    public static zzdlj zzv(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new zzdlj(bArr, 0, bArr.length);
    }

    public final byte[] getBytes() {
        byte[] bArr = new byte[this.data.length];
        System.arraycopy(this.data, 0, bArr, 0, this.data.length);
        return bArr;
    }

    private zzdlj(byte[] bArr, int i, int i2) {
        this.data = new byte[i2];
        System.arraycopy(bArr, 0, this.data, 0, i2);
    }
}
