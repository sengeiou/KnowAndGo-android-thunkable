package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class zzjv implements zzkf {
    private final zzke zzaoz;
    private long zzapc;
    private boolean zzapd;
    private RandomAccessFile zzaqe;
    private String zzaqf;

    public zzjv() {
        this((zzke) null);
    }

    public zzjv(zzke zzke) {
        this.zzaoz = zzke;
    }

    public final long zza(zzjq zzjq) throws zzjw {
        long j;
        try {
            this.zzaqf = zzjq.uri.toString();
            this.zzaqe = new RandomAccessFile(zzjq.uri.getPath(), "r");
            this.zzaqe.seek(zzjq.zzahv);
            if (zzjq.zzcd == -1) {
                j = this.zzaqe.length() - zzjq.zzahv;
            } else {
                j = zzjq.zzcd;
            }
            this.zzapc = j;
            if (this.zzapc >= 0) {
                this.zzapd = true;
                if (this.zzaoz != null) {
                    this.zzaoz.zzgc();
                }
                return this.zzapc;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new zzjw(e);
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws zzjw {
        if (this.zzapc == 0) {
            return -1;
        }
        try {
            int read = this.zzaqe.read(bArr, i, (int) Math.min(this.zzapc, (long) i2));
            if (read > 0) {
                this.zzapc -= (long) read;
                if (this.zzaoz != null) {
                    this.zzaoz.zzab(read);
                }
            }
            return read;
        } catch (IOException e) {
            throw new zzjw(e);
        }
    }

    public final void close() throws zzjw {
        if (this.zzaqe != null) {
            try {
                this.zzaqe.close();
                this.zzaqe = null;
                this.zzaqf = null;
                if (this.zzapd) {
                    this.zzapd = false;
                    if (this.zzaoz != null) {
                        this.zzaoz.zzgd();
                    }
                }
            } catch (IOException e) {
                throw new zzjw(e);
            } catch (Throwable th) {
                this.zzaqe = null;
                this.zzaqf = null;
                if (this.zzapd) {
                    this.zzapd = false;
                    if (this.zzaoz != null) {
                        this.zzaoz.zzgd();
                    }
                }
                throw th;
            }
        }
    }
}
