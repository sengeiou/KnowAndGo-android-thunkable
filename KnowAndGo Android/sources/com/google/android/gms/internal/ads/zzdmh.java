package com.google.android.gms.internal.ads;

import kotlin.UByte;

public final class zzdmh {
    private final byte[] zzhcc = new byte[256];
    private int zzhcd;
    private int zzhce;

    public zzdmh(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.zzhcc[i] = (byte) i;
        }
        byte b = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            b = (b + this.zzhcc[i2] + bArr[i2 % bArr.length]) & UByte.MAX_VALUE;
            byte b2 = this.zzhcc[i2];
            this.zzhcc[i2] = this.zzhcc[b];
            this.zzhcc[b] = b2;
        }
        this.zzhcd = 0;
        this.zzhce = 0;
    }

    public final void zzy(byte[] bArr) {
        int i = this.zzhcd;
        int i2 = this.zzhce;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = (i2 + this.zzhcc[i]) & 255;
            byte b = this.zzhcc[i];
            this.zzhcc[i] = this.zzhcc[i2];
            this.zzhcc[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.zzhcc[(this.zzhcc[i] + this.zzhcc[i2]) & 255]);
        }
        this.zzhcd = i;
        this.zzhce = i2;
    }
}
