package com.google.android.gms.internal.ads;

import java.io.IOException;
import kotlin.UByte;

final class zzjf {
    private static final int[] zzann = {128, 64, 32, 16, 8, 4, 2, 1};
    private int length;
    private int state;
    private final byte[] zzanf = new byte[8];

    public final void reset() {
        this.state = 0;
        this.length = 0;
    }

    public final long zza(zzie zzie, boolean z, boolean z2) throws IOException, InterruptedException {
        if (this.state == 0) {
            if (!zzie.zza(this.zzanf, 0, 1, z)) {
                return -1;
            }
            byte b = this.zzanf[0] & UByte.MAX_VALUE;
            this.length = -1;
            int i = 0;
            while (true) {
                if (i >= zzann.length) {
                    break;
                } else if ((zzann[i] & b) != 0) {
                    this.length = i + 1;
                    break;
                } else {
                    i++;
                }
            }
            if (this.length != -1) {
                this.state = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        zzie.readFully(this.zzanf, 1, this.length - 1);
        if (z2) {
            byte[] bArr = this.zzanf;
            bArr[0] = (byte) (bArr[0] & (~zzann[this.length - 1]));
        }
        long j = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            j = (j << 8) | ((long) (this.zzanf[i2] & UByte.MAX_VALUE));
        }
        this.state = 0;
        return j;
    }

    public final int zzfw() {
        return this.length;
    }
}
