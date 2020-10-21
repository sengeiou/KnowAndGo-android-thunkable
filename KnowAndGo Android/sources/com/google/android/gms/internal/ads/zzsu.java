package com.google.android.gms.internal.ads;

import kotlin.UByte;

public final class zzsu {
    private byte[] data;
    private int zzbnl;
    private int zzbnm = 0;
    private int zzbnn;

    public zzsu(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.zzbnl = i;
        this.zzbnn = i2;
        zzkg();
    }

    public final void zzbq(int i) {
        int i2 = this.zzbnl;
        this.zzbnl += i / 8;
        this.zzbnm += i % 8;
        if (this.zzbnm > 7) {
            this.zzbnl++;
            this.zzbnm -= 8;
        }
        while (true) {
            i2++;
            if (i2 > this.zzbnl) {
                zzkg();
                return;
            } else if (zzbr(i2)) {
                this.zzbnl++;
                i2 += 2;
            }
        }
    }

    public final boolean zzkc() {
        return zzbn(1) == 1;
    }

    public final int zzbn(int i) {
        byte b;
        byte b2;
        if (i == 0) {
            return 0;
        }
        int i2 = i / 8;
        byte b3 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = zzbr(this.zzbnl + 1) ? this.zzbnl + 2 : this.zzbnl + 1;
            if (this.zzbnm != 0) {
                b2 = ((this.data[i4] & UByte.MAX_VALUE) >>> (8 - this.zzbnm)) | ((this.data[this.zzbnl] & UByte.MAX_VALUE) << this.zzbnm);
            } else {
                b2 = this.data[this.zzbnl];
            }
            i -= 8;
            b3 |= (255 & b2) << i;
            this.zzbnl = i4;
        }
        if (i > 0) {
            int i5 = this.zzbnm + i;
            byte b4 = (byte) (255 >> (8 - i));
            int i6 = zzbr(this.zzbnl + 1) ? this.zzbnl + 2 : this.zzbnl + 1;
            if (i5 > 8) {
                b = (b4 & (((255 & this.data[i6]) >> (16 - i5)) | ((this.data[this.zzbnl] & UByte.MAX_VALUE) << (i5 - 8)))) | b3;
                this.zzbnl = i6;
            } else {
                b = (b4 & ((255 & this.data[this.zzbnl]) >> (8 - i5))) | b3;
                if (i5 == 8) {
                    this.zzbnl = i6;
                }
            }
            b3 = b;
            this.zzbnm = i5 % 8;
        }
        zzkg();
        return b3;
    }

    public final int zzkd() {
        return zzkf();
    }

    public final int zzke() {
        int zzkf = zzkf();
        return (zzkf % 2 == 0 ? -1 : 1) * ((zzkf + 1) / 2);
    }

    private final int zzkf() {
        int i = 0;
        int i2 = 0;
        while (!zzkc()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = zzbn(i2);
        }
        return i3 + i;
    }

    private final boolean zzbr(int i) {
        return 2 <= i && i < this.zzbnn && this.data[i] == 3 && this.data[i + -2] == 0 && this.data[i - 1] == 0;
    }

    private final void zzkg() {
        zzsk.checkState(this.zzbnl >= 0 && this.zzbnm >= 0 && this.zzbnm < 8 && (this.zzbnl < this.zzbnn || (this.zzbnl == this.zzbnn && this.zzbnm == 0)));
    }
}
