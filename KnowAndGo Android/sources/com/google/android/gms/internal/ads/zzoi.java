package com.google.android.gms.internal.ads;

import java.io.IOException;
import kotlin.UByte;

final class zzoi {
    private static final long[] zzbci = {128, 64, 32, 16, 8, 4, 2, 1};
    private int length;
    private int state;
    private final byte[] zzanf = new byte[8];

    public final void reset() {
        this.state = 0;
        this.length = 0;
    }

    public final long zza(zzno zzno, boolean z, boolean z2, int i) throws IOException, InterruptedException {
        if (this.state == 0) {
            if (!zzno.zza(this.zzanf, 0, 1, z)) {
                return -1;
            }
            this.length = zzaw(this.zzanf[0] & UByte.MAX_VALUE);
            if (this.length != -1) {
                this.state = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        if (this.length > i) {
            this.state = 0;
            return -2;
        }
        if (this.length != 1) {
            zzno.readFully(this.zzanf, 1, this.length - 1);
        }
        this.state = 0;
        return zza(this.zzanf, this.length, z2);
    }

    public final int zzfw() {
        return this.length;
    }

    public static int zzaw(int i) {
        for (int i2 = 0; i2 < zzbci.length; i2++) {
            if ((zzbci[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
        }
        return -1;
    }

    public static long zza(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= ~zzbci[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (((long) bArr[i2]) & 255);
        }
        return j;
    }
}
