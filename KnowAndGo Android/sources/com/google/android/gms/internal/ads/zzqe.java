package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

final class zzqe implements zzsh {
    private final Uri uri;
    private volatile boolean zzajd;
    private boolean zzaje = true;
    private final zzrv zzazi;
    private final zzqf zzbig;
    private final zzsm zzbih;
    private final /* synthetic */ zzpz zzbis;
    private final zznt zzbiv = new zznt();
    private long zzbiw;
    /* access modifiers changed from: private */
    public long zzcd = -1;

    public zzqe(zzpz zzpz, Uri uri2, zzrv zzrv, zzqf zzqf, zzsm zzsm) {
        this.zzbis = zzpz;
        this.uri = (Uri) zzsk.checkNotNull(uri2);
        this.zzazi = (zzrv) zzsk.checkNotNull(zzrv);
        this.zzbig = (zzqf) zzsk.checkNotNull(zzqf);
        this.zzbih = zzsm;
    }

    public final void zzf(long j, long j2) {
        this.zzbiv.zzahv = j;
        this.zzbiw = j2;
        this.zzaje = true;
    }

    public final void zzfp() {
        this.zzajd = true;
    }

    public final boolean zzfq() {
        return this.zzajd;
    }

    public final void zzfr() throws IOException, InterruptedException {
        zznm zznm;
        int i = 0;
        while (i == 0 && !this.zzajd) {
            try {
                long j = this.zzbiv.zzahv;
                this.zzcd = this.zzazi.zza(new zzry(this.uri, j, -1, this.zzbis.zzbid));
                if (this.zzcd != -1) {
                    this.zzcd += j;
                }
                zznm = new zznm(this.zzazi, j, this.zzcd);
                try {
                    zznn zza = this.zzbig.zza(zznm, this.zzazi.getUri());
                    if (this.zzaje) {
                        zza.zzd(j, this.zzbiw);
                        this.zzaje = false;
                    }
                    while (i == 0 && !this.zzajd) {
                        this.zzbih.block();
                        int zza2 = zza.zza(zznm, this.zzbiv);
                        try {
                            if (zznm.getPosition() > this.zzbis.zzbie + j) {
                                j = zznm.getPosition();
                                this.zzbih.zzjy();
                                this.zzbis.handler.post(this.zzbis.zzbij);
                            }
                            i = zza2;
                        } catch (Throwable th) {
                            th = th;
                            i = zza2;
                            if (!(i == 1 || zznm == null)) {
                                this.zzbiv.zzahv = zznm.getPosition();
                            }
                            zzsy.zza(this.zzazi);
                            throw th;
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else {
                        this.zzbiv.zzahv = zznm.getPosition();
                    }
                    zzsy.zza(this.zzazi);
                } catch (Throwable th2) {
                    th = th2;
                    this.zzbiv.zzahv = zznm.getPosition();
                    zzsy.zza(this.zzazi);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                zznm = null;
                this.zzbiv.zzahv = zznm.getPosition();
                zzsy.zza(this.zzazi);
                throw th;
            }
        }
    }
}
