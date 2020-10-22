package com.google.android.gms.internal.ads;

import kotlin.UByte;

public final class zzss {
    private byte[] data;
    private int zzbnl;
    private int zzbnm;
    private int zzbnn;

    public zzss() {
    }

    public zzss(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private zzss(byte[] bArr, int i) {
        this.data = bArr;
        this.zzbnn = i;
    }

    public final int zzbn(int i) {
        byte b;
        byte b2;
        boolean z = false;
        if (i == 0) {
            return 0;
        }
        int i2 = i / 8;
        int i3 = i;
        byte b3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (this.zzbnm != 0) {
                b2 = ((this.data[this.zzbnl + 1] & UByte.MAX_VALUE) >>> (8 - this.zzbnm)) | ((this.data[this.zzbnl] & UByte.MAX_VALUE) << this.zzbnm);
            } else {
                b2 = this.data[this.zzbnl];
            }
            i3 -= 8;
            b3 |= (255 & b2) << i3;
            this.zzbnl++;
        }
        if (i3 > 0) {
            int i5 = this.zzbnm + i3;
            byte b4 = (byte) (255 >> (8 - i3));
            if (i5 > 8) {
                b = (b4 & (((this.data[this.zzbnl] & UByte.MAX_VALUE) << (i5 - 8)) | ((255 & this.data[this.zzbnl + 1]) >> (16 - i5)))) | b3;
                this.zzbnl++;
            } else {
                b = (b4 & ((this.data[this.zzbnl] & UByte.MAX_VALUE) >> (8 - i5))) | b3;
                if (i5 == 8) {
                    this.zzbnl++;
                }
            }
            b3 = b;
            this.zzbnm = i5 % 8;
        }
        if (this.zzbnl >= 0 && this.zzbnm >= 0 && this.zzbnm < 8 && (this.zzbnl < this.zzbnn || (this.zzbnl == this.zzbnn && this.zzbnm == 0))) {
            z = true;
        }
        zzsk.checkState(z);
        return b3;
    }
}
