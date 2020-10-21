package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzjo implements zzjp {
    private final byte[] data;
    private int zzape;
    private int zzapf;

    public zzjo(byte[] bArr) {
        zzkh.checkNotNull(bArr);
        zzkh.checkArgument(bArr.length > 0);
        this.data = bArr;
    }

    public final void close() throws IOException {
    }

    public final long zza(zzjq zzjq) throws IOException {
        this.zzape = (int) zzjq.zzahv;
        this.zzapf = (int) (zzjq.zzcd == -1 ? ((long) this.data.length) - zzjq.zzahv : zzjq.zzcd);
        if (this.zzapf > 0 && this.zzape + this.zzapf <= this.data.length) {
            return (long) this.zzapf;
        }
        int i = this.zzape;
        long j = zzjq.zzcd;
        int length = this.data.length;
        StringBuilder sb = new StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i);
        sb.append(", ");
        sb.append(j);
        sb.append("], length: ");
        sb.append(length);
        throw new IOException(sb.toString());
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.zzapf == 0) {
            return -1;
        }
        int min = Math.min(i2, this.zzapf);
        System.arraycopy(this.data, this.zzape, bArr, i, min);
        this.zzape += min;
        this.zzapf -= min;
        return min;
    }
}
