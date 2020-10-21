package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class zzaw extends ByteArrayOutputStream {
    private final zzal zzbr;

    public zzaw(zzal zzal, int i) {
        this.zzbr = zzal;
        this.buf = this.zzbr.zzc(Math.max(i, 256));
    }

    public final void close() throws IOException {
        this.zzbr.zza(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.zzbr.zza(this.buf);
    }

    private final void zzd(int i) {
        if (this.count + i > this.buf.length) {
            byte[] zzc = this.zzbr.zzc((this.count + i) << 1);
            System.arraycopy(this.buf, 0, zzc, 0, this.count);
            this.zzbr.zza(this.buf);
            this.buf = zzc;
        }
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        zzd(i2);
        super.write(bArr, i, i2);
    }

    public final synchronized void write(int i) {
        zzd(1);
        super.write(i);
    }
}
