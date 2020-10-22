package com.google.android.gms.internal.ads;

import java.io.IOException;

@zzard
final class zzbej implements zzjp {
    private final zzjp zzegf;
    private final long zzegg;
    private final zzjp zzegh;
    private long zzegi;

    zzbej(zzjp zzjp, int i, zzjp zzjp2) {
        this.zzegf = zzjp;
        this.zzegg = (long) i;
        this.zzegh = zzjp2;
    }

    public final long zza(zzjq zzjq) throws IOException {
        zzjq zzjq2;
        zzjq zzjq3;
        long j;
        if (zzjq.zzahv >= this.zzegg) {
            zzjq2 = null;
        } else {
            long j2 = zzjq.zzahv;
            if (zzjq.zzcd != -1) {
                j = Math.min(zzjq.zzcd, this.zzegg - j2);
            } else {
                j = this.zzegg - j2;
            }
            zzjq2 = new zzjq(zzjq.uri, j2, j, (String) null);
        }
        if (zzjq.zzcd == -1 || zzjq.zzahv + zzjq.zzcd > this.zzegg) {
            zzjq3 = new zzjq(zzjq.uri, Math.max(this.zzegg, zzjq.zzahv), zzjq.zzcd != -1 ? Math.min(zzjq.zzcd, (zzjq.zzahv + zzjq.zzcd) - this.zzegg) : -1, (String) null);
        } else {
            zzjq3 = null;
        }
        long j3 = 0;
        long zza = zzjq2 != null ? this.zzegf.zza(zzjq2) : 0;
        if (zzjq3 != null) {
            j3 = this.zzegh.zza(zzjq3);
        }
        this.zzegi = zzjq.zzahv;
        if (zza == -1 || j3 == -1) {
            return -1;
        }
        return zza + j3;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.zzegi < this.zzegg) {
            i3 = this.zzegf.read(bArr, i, (int) Math.min((long) i2, this.zzegg - this.zzegi));
            this.zzegi += (long) i3;
        } else {
            i3 = 0;
        }
        if (this.zzegi < this.zzegg) {
            return i3;
        }
        int read = this.zzegh.read(bArr, i + i3, i2 - i3);
        int i4 = i3 + read;
        this.zzegi += (long) read;
        return i4;
    }

    public final void close() throws IOException {
        this.zzegf.close();
        this.zzegh.close();
    }
}
