package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

@zzard
final class zzbfj implements zzrv {
    private Uri uri;
    private final long zzegg;
    private long zzegi;
    private final zzrv zzehm;
    private final zzrv zzehn;

    zzbfj(zzrv zzrv, int i, zzrv zzrv2) {
        this.zzehm = zzrv;
        this.zzegg = (long) i;
        this.zzehn = zzrv2;
    }

    public final long zza(zzry zzry) throws IOException {
        zzry zzry2;
        zzry zzry3;
        long j;
        this.uri = zzry.uri;
        if (zzry.zzahv >= this.zzegg) {
            zzry2 = null;
        } else {
            long j2 = zzry.zzahv;
            if (zzry.zzcd != -1) {
                j = Math.min(zzry.zzcd, this.zzegg - j2);
            } else {
                j = this.zzegg - j2;
            }
            zzry2 = new zzry(zzry.uri, j2, j, (String) null);
        }
        if (zzry.zzcd == -1 || zzry.zzahv + zzry.zzcd > this.zzegg) {
            zzry3 = new zzry(zzry.uri, Math.max(this.zzegg, zzry.zzahv), zzry.zzcd != -1 ? Math.min(zzry.zzcd, (zzry.zzahv + zzry.zzcd) - this.zzegg) : -1, (String) null);
        } else {
            zzry3 = null;
        }
        long j3 = 0;
        long zza = zzry2 != null ? this.zzehm.zza(zzry2) : 0;
        if (zzry3 != null) {
            j3 = this.zzehn.zza(zzry3);
        }
        this.zzegi = zzry.zzahv;
        if (zza == -1 || j3 == -1) {
            return -1;
        }
        return zza + j3;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.zzegi < this.zzegg) {
            i3 = this.zzehm.read(bArr, i, (int) Math.min((long) i2, this.zzegg - this.zzegi));
            this.zzegi += (long) i3;
        } else {
            i3 = 0;
        }
        if (this.zzegi < this.zzegg) {
            return i3;
        }
        int read = this.zzehn.read(bArr, i + i3, i2 - i3);
        int i4 = i3 + read;
        this.zzegi += (long) read;
        return i4;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void close() throws IOException {
        this.zzehm.close();
        this.zzehn.close();
    }
}
