package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.SystemClock;
import android.util.SparseArray;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import java.io.IOException;

public final class zzig implements zzhn, zzif, zzka {
    private final Uri uri;
    private zzho[] zzacr;
    private boolean zzacs;
    private int zzact;
    private boolean[] zzacv;
    private volatile zzhw zzadp;
    private final zzjp zzahu;
    private final zzid zzaic;
    private final zzjr zzaid;
    private final int zzaie;
    private final SparseArray<zzii> zzaif;
    private final int zzaig;
    private final boolean zzaih;
    private volatile boolean zzaii;
    private volatile zzio zzaij;
    private int zzaik;
    private long zzail;
    private boolean[] zzaim;
    private boolean[] zzain;
    private long zzaio;
    private long zzaip;
    private long zzaiq;
    private boolean zzair;
    private long zzais;
    private zzjz zzait;
    private zzih zzaiu;
    private IOException zzaiv;
    private boolean zzaiw;
    private int zzaix;
    private long zzaiy;
    private boolean zzaiz;
    private int zzaja;
    private int zzajb;

    public zzig(Uri uri2, zzjp zzjp, zzid zzid, int i, int i2) {
        this(uri2, zzjp, zzid, 2, i2, -1);
    }

    private zzig(Uri uri2, zzjp zzjp, zzid zzid, int i, int i2, int i3) {
        this.uri = uri2;
        this.zzahu = zzjp;
        this.zzaic = zzid;
        this.zzact = 2;
        this.zzaie = i2;
        this.zzaig = -1;
        this.zzaif = new SparseArray<>();
        this.zzaid = new zzjr(262144);
        this.zzaiq = -1;
        this.zzaih = true;
        zzid.zza(this);
    }

    public final boolean zzdg(long j) throws IOException {
        boolean z;
        if (this.zzacs) {
            return true;
        }
        if (this.zzait == null) {
            this.zzait = new zzjz("Loader:ExtractorSampleSource");
        }
        zzfj();
        if (this.zzaij != null && this.zzaii) {
            int i = 0;
            while (true) {
                if (i >= this.zzaif.size()) {
                    z = true;
                    break;
                } else if (!this.zzaif.valueAt(i).zzfd()) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                int size = this.zzaif.size();
                this.zzain = new boolean[size];
                this.zzacv = new boolean[size];
                this.zzaim = new boolean[size];
                this.zzacr = new zzho[size];
                this.zzail = -1;
                for (int i2 = 0; i2 < size; i2++) {
                    zzhj zzfe = this.zzaif.valueAt(i2).zzfe();
                    this.zzacr[i2] = new zzho(zzfe.mimeType, zzfe.zzack);
                    if (zzfe.zzack != -1 && zzfe.zzack > this.zzail) {
                        this.zzail = zzfe.zzack;
                    }
                }
                this.zzacs = true;
                return true;
            }
        }
        zzfl();
        return false;
    }

    public final int getTrackCount() {
        return this.zzaif.size();
    }

    public final zzho zzo(int i) {
        zzkh.checkState(this.zzacs);
        return this.zzacr[i];
    }

    public final void zza(int i, long j) {
        zzkh.checkState(this.zzacs);
        zzkh.checkState(!this.zzain[i]);
        this.zzaik++;
        this.zzain[i] = true;
        this.zzaim[i] = true;
        if (this.zzaik == 1) {
            zzdi(j);
        }
    }

    public final void zzp(int i) {
        zzkh.checkState(this.zzacs);
        zzkh.checkState(this.zzain[i]);
        this.zzaik--;
        this.zzain[i] = false;
        this.zzacv[i] = false;
        if (this.zzaik != 0) {
            return;
        }
        if (this.zzait.isLoading()) {
            this.zzait.zzgb();
            return;
        }
        zzfn();
        this.zzaid.zzz(0);
    }

    public final boolean zzdh(long j) throws IOException {
        zzkh.checkState(this.zzacs);
        zzkh.checkState(this.zzaik > 0);
        this.zzaio = j;
        long j2 = this.zzaio;
        for (int i = 0; i < this.zzain.length; i++) {
            if (!this.zzain[i]) {
                this.zzaif.valueAt(i).zzdr(j2);
            }
        }
        return this.zzaiz || zzfj();
    }

    public final int zza(int i, long j, zzhk zzhk, zzhm zzhm, boolean z) throws IOException {
        this.zzaio = j;
        int i2 = 0;
        if (this.zzacv[i]) {
            this.zzacv[i] = false;
            return -5;
        } else if (z || zzfo()) {
            zzfl();
            return -2;
        } else {
            zzii valueAt = this.zzaif.valueAt(i);
            if (this.zzaim[i]) {
                zzhk.zzado = valueAt.zzfe();
                zzhk.zzadp = this.zzadp;
                this.zzaim[i] = false;
                return -4;
            } else if (valueAt.zza(zzhm)) {
                boolean z2 = this.zzaih && zzhm.zzaga < this.zzaip;
                int i3 = zzhm.flags;
                if (z2) {
                    i2 = 134217728;
                }
                zzhm.flags = i3 | i2;
                zzhm.zzaga += this.zzais;
                return -3;
            } else if (this.zzaiz) {
                return -1;
            } else {
                zzfl();
                return -2;
            }
        }
    }

    public final void zzdi(long j) {
        zzkh.checkState(this.zzacs);
        zzkh.checkState(this.zzaik > 0);
        this.zzaij.zzfc();
        this.zzaip = j;
        if ((zzfo() ? this.zzaiq : this.zzaio) != j) {
            this.zzaio = j;
            boolean z = !zzfo();
            int i = 0;
            while (z && i < this.zzaif.size()) {
                z &= this.zzaif.valueAt(i).zzds(j);
                i++;
            }
            if (!z) {
                zzdt(j);
            }
            for (int i2 = 0; i2 < this.zzacv.length; i2++) {
                this.zzacv[i2] = true;
            }
        }
    }

    public final long zzdu() {
        if (this.zzaiz) {
            return -3;
        }
        if (zzfo()) {
            return this.zzaiq;
        }
        long j = Long.MIN_VALUE;
        for (int i = 0; i < this.zzaif.size(); i++) {
            j = Math.max(j, this.zzaif.valueAt(i).zzff());
        }
        return j == Long.MIN_VALUE ? this.zzaio : j;
    }

    public final void release() {
        zzkh.checkState(this.zzact > 0);
        int i = this.zzact - 1;
        this.zzact = i;
        if (i == 0 && this.zzait != null) {
            this.zzait.release();
            this.zzait = null;
        }
    }

    public final void zza(zzkc zzkc) {
        this.zzaiz = true;
    }

    public final void zzb(zzkc zzkc) {
        if (this.zzaik > 0) {
            zzdt(this.zzaiq);
            return;
        }
        zzfn();
        this.zzaid.zzz(0);
    }

    public final void zza(zzkc zzkc, IOException iOException) {
        this.zzaiv = iOException;
        int i = 1;
        if (this.zzaja <= this.zzajb) {
            i = 1 + this.zzaix;
        }
        this.zzaix = i;
        this.zzaiy = SystemClock.elapsedRealtime();
        zzfk();
    }

    public final zzip zzs(int i) {
        zzii zzii = this.zzaif.get(i);
        if (zzii != null) {
            return zzii;
        }
        zzii zzii2 = new zzii(this, this.zzaid);
        this.zzaif.put(i, zzii2);
        return zzii2;
    }

    public final void zzfi() {
        this.zzaii = true;
    }

    public final void zza(zzio zzio) {
        this.zzaij = zzio;
    }

    public final void zzb(zzhw zzhw) {
        this.zzadp = zzhw;
    }

    private final boolean zzfj() throws IOException {
        boolean z;
        zzfk();
        boolean z2 = false;
        if (zzfo()) {
            return false;
        }
        if (this.zzacs) {
            int i = 0;
            while (true) {
                if (i < this.zzain.length) {
                    if (this.zzain[i] && !this.zzaif.valueAt(i).isEmpty()) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                z2 = true;
            }
        }
        if (!z2) {
            zzfl();
        }
        return z2;
    }

    private final void zzdt(long j) {
        this.zzaiq = j;
        this.zzaiz = false;
        if (this.zzait.isLoading()) {
            this.zzait.zzgb();
            return;
        }
        zzfn();
        zzfk();
    }

    private final void zzfk() {
        if (!this.zzaiz && !this.zzait.isLoading()) {
            boolean z = true;
            if (this.zzaiv != null) {
                if (this.zzaiu == null) {
                    z = false;
                }
                zzkh.checkState(z);
                if (SystemClock.elapsedRealtime() - this.zzaiy >= Math.min((((long) this.zzaix) - 1) * 1000, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS)) {
                    this.zzaiv = null;
                    if (!this.zzacs) {
                        for (int i = 0; i < this.zzaif.size(); i++) {
                            this.zzaif.valueAt(i).clear();
                        }
                        this.zzaiu = zzfm();
                    } else {
                        this.zzaij.zzfc();
                    }
                    this.zzajb = this.zzaja;
                    this.zzait.zza((zzkc) this.zzaiu, (zzka) this);
                    return;
                }
                return;
            }
            this.zzais = 0;
            this.zzair = false;
            if (!this.zzacs) {
                this.zzaiu = zzfm();
            } else {
                zzkh.checkState(zzfo());
                if (this.zzail == -1 || this.zzaiq < this.zzail) {
                    this.zzaiu = new zzih(this.uri, this.zzahu, this.zzaic, this.zzaid, this.zzaie, this.zzaij.zzdq(this.zzaiq));
                    this.zzaiq = -1;
                } else {
                    this.zzaiz = true;
                    this.zzaiq = -1;
                    return;
                }
            }
            this.zzajb = this.zzaja;
            this.zzait.zza((zzkc) this.zzaiu, (zzka) this);
        }
    }

    private final void zzfl() throws IOException {
        int i;
        if (this.zzaiv != null) {
            if (this.zzaig != -1) {
                i = this.zzaig;
            } else {
                if (this.zzaij != null) {
                    this.zzaij.zzfc();
                }
                i = 3;
            }
            if (this.zzaix > i) {
                throw this.zzaiv;
            }
        }
    }

    private final zzih zzfm() {
        return new zzih(this.uri, this.zzahu, this.zzaic, this.zzaid, this.zzaie, 0);
    }

    private final void zzfn() {
        for (int i = 0; i < this.zzaif.size(); i++) {
            this.zzaif.valueAt(i).clear();
        }
        this.zzaiu = null;
        this.zzaiv = null;
        this.zzaix = 0;
        this.zzaiw = false;
    }

    private final boolean zzfo() {
        return this.zzaiq != -1;
    }

    static /* synthetic */ int zza(zzig zzig) {
        int i = zzig.zzaja;
        zzig.zzaja = i + 1;
        return i;
    }
}
