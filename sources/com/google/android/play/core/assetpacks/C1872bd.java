package com.google.android.play.core.assetpacks;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.assetpacks.bd */
final class C1872bd extends InputStream {

    /* renamed from: a */
    private final InputStream f401a;

    /* renamed from: b */
    private long f402b;

    C1872bd(InputStream inputStream, long j) {
        this.f401a = inputStream;
        this.f402b = j;
    }

    public final void close() throws IOException {
        super.close();
        this.f401a.close();
        this.f402b = 0;
    }

    public final int read() throws IOException {
        long j = this.f402b;
        if (j <= 0) {
            return -1;
        }
        this.f402b = j - 1;
        return this.f401a.read();
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f402b;
        if (j <= 0) {
            return -1;
        }
        int read = this.f401a.read(bArr, i, (int) Math.min((long) i2, j));
        if (read != -1) {
            this.f402b -= (long) read;
        }
        return read;
    }
}
