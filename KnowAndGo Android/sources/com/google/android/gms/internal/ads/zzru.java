package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

public final class zzru implements zzrv {
    private final byte[] data;
    private Uri uri;
    private int zzape;
    private int zzbmc;

    public zzru(byte[] bArr) {
        zzsk.checkNotNull(bArr);
        zzsk.checkArgument(bArr.length > 0);
        this.data = bArr;
    }

    public final long zza(zzry zzry) throws IOException {
        this.uri = zzry.uri;
        this.zzape = (int) zzry.zzahv;
        this.zzbmc = (int) (zzry.zzcd == -1 ? ((long) this.data.length) - zzry.zzahv : zzry.zzcd);
        if (this.zzbmc > 0 && this.zzape + this.zzbmc <= this.data.length) {
            return (long) this.zzbmc;
        }
        int i = this.zzape;
        long j = zzry.zzcd;
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
        if (i2 == 0) {
            return 0;
        }
        if (this.zzbmc == 0) {
            return -1;
        }
        int min = Math.min(i2, this.zzbmc);
        System.arraycopy(this.data, this.zzape, bArr, i, min);
        this.zzape += min;
        this.zzbmc -= min;
        return min;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void close() throws IOException {
        this.uri = null;
    }
}
