package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class zzjm implements zzkf {
    private final AssetManager zzaoy;
    private final zzke zzaoz;
    private String zzapa;
    private InputStream zzapb;
    private long zzapc;
    private boolean zzapd;

    public zzjm(Context context, zzke zzke) {
        this.zzaoy = context.getAssets();
        this.zzaoz = zzke;
    }

    public final long zza(zzjq zzjq) throws zzjn {
        long j;
        try {
            this.zzapa = zzjq.uri.toString();
            String path = zzjq.uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            this.zzapb = this.zzaoy.open(path, 1);
            zzkh.checkState(this.zzapb.skip(zzjq.zzahv) == zzjq.zzahv);
            if (zzjq.zzcd == -1) {
                j = (long) this.zzapb.available();
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
            throw new zzjn(e);
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws zzjn {
        if (this.zzapc == 0) {
            return -1;
        }
        try {
            int read = this.zzapb.read(bArr, i, (int) Math.min(this.zzapc, (long) i2));
            if (read > 0) {
                this.zzapc -= (long) read;
                if (this.zzaoz != null) {
                    this.zzaoz.zzab(read);
                }
            }
            return read;
        } catch (IOException e) {
            throw new zzjn(e);
        }
    }

    public final void close() throws zzjn {
        if (this.zzapb != null) {
            try {
                this.zzapb.close();
                this.zzapb = null;
                if (this.zzapd) {
                    this.zzapd = false;
                    if (this.zzaoz != null) {
                        this.zzaoz.zzgd();
                    }
                }
            } catch (IOException e) {
                throw new zzjn(e);
            } catch (Throwable th) {
                this.zzapb = null;
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
