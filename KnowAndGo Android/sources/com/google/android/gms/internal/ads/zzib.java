package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

public final class zzib implements zzie {
    private static final byte[] zzaht = new byte[4096];
    private final zzjp zzahu;
    private long zzahv;
    private long zzcd;

    public zzib(zzjp zzjp, long j, long j2) {
        this.zzahu = zzjp;
        this.zzahv = j;
        this.zzcd = j2;
    }

    public final boolean zza(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int i3 = i;
        int i4 = i2;
        while (i4 > 0) {
            if (!Thread.interrupted()) {
                int read = this.zzahu.read(bArr, i3, i4);
                if (read != -1) {
                    i3 += read;
                    i4 -= read;
                } else if (z && i4 == i2) {
                    return false;
                } else {
                    throw new EOFException();
                }
            } else {
                throw new InterruptedException();
            }
        }
        this.zzahv += (long) i2;
        return true;
    }

    public final void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        zza(bArr, i, i2, false);
    }

    public final void zzr(int i) throws IOException, InterruptedException {
        int i2 = i;
        while (i2 > 0) {
            if (!Thread.interrupted()) {
                int read = this.zzahu.read(zzaht, 0, Math.min(zzaht.length, i2));
                if (read != -1) {
                    i2 -= read;
                } else {
                    throw new EOFException();
                }
            } else {
                throw new InterruptedException();
            }
        }
        this.zzahv += (long) i;
    }

    public final long getPosition() {
        return this.zzahv;
    }
}
