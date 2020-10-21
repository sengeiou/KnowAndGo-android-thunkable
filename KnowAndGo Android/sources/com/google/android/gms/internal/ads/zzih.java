package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

final class zzih implements zzkc {
    private final Uri uri;
    private final zzjp zzahu;
    private final zzid zzaic;
    private final zzjr zzaid;
    private final int zzaie;
    private final zzij zzajc = new zzij();
    private volatile boolean zzajd;
    private boolean zzaje;

    public zzih(Uri uri2, zzjp zzjp, zzid zzid, zzjr zzjr, int i, long j) {
        this.uri = (Uri) zzkh.checkNotNull(uri2);
        this.zzahu = (zzjp) zzkh.checkNotNull(zzjp);
        this.zzaic = (zzid) zzkh.checkNotNull(zzid);
        this.zzaid = (zzjr) zzkh.checkNotNull(zzjr);
        this.zzaie = i;
        this.zzajc.zzahv = j;
        this.zzaje = true;
    }

    public final void zzfp() {
        this.zzajd = true;
    }

    public final boolean zzfq() {
        return this.zzajd;
    }

    public final void zzfr() throws IOException, InterruptedException {
        if (this.zzaje) {
            this.zzaic.zzfh();
            this.zzaje = false;
        }
        int i = 0;
        while (i == 0 && !this.zzajd) {
            zzib zzib = null;
            try {
                long j = this.zzajc.zzahv;
                long zza = this.zzahu.zza(new zzjq(this.uri, j, -1, (String) null));
                if (zza != -1) {
                    zza += j;
                }
                zzib zzib2 = new zzib(this.zzahu, j, zza);
                while (i == 0) {
                    try {
                        if (this.zzajd) {
                            break;
                        }
                        this.zzaid.zzaa(this.zzaie);
                        i = this.zzaic.zza(zzib2, this.zzajc);
                    } catch (Throwable th) {
                        th = th;
                        zzib = zzib2;
                        if (!(i == 1 || zzib == null)) {
                            this.zzajc.zzahv = zzib.getPosition();
                        }
                        this.zzahu.close();
                        throw th;
                    }
                }
                if (i == 1) {
                    i = 0;
                } else {
                    this.zzajc.zzahv = zzib2.getPosition();
                }
                this.zzahu.close();
            } catch (Throwable th2) {
                th = th2;
                this.zzajc.zzahv = zzib.getPosition();
                this.zzahu.close();
                throw th;
            }
        }
    }
}
