package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@VisibleForTesting
final class zzap extends FilterInputStream {
    private final long zzcd;
    private long zzce;

    zzap(InputStream inputStream, long j) {
        super(inputStream);
        this.zzcd = j;
    }

    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.zzce++;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.zzce += (long) read;
        }
        return read;
    }

    /* access modifiers changed from: package-private */
    public final long zzo() {
        return this.zzcd - this.zzce;
    }
}
