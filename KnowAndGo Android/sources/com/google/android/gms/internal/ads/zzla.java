package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer2.C1470C;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class zzla implements zzkv {
    private int repeatMode;
    private final Handler zzabq;
    private final CopyOnWriteArraySet<zzkw> zzabs;
    private boolean zzabu;
    private int zzabv;
    private final zzlo[] zzaro;
    private final zzrp zzarp;
    private final zzro zzarq;
    private final zzlc zzarr;
    private final zzlu zzars;
    private final zzlt zzart;
    private boolean zzaru;
    private int zzarv;
    private int zzarw;
    private boolean zzarx;
    private zzlr zzary;
    private Object zzarz;
    private zzrb zzasa;
    private zzro zzasb;
    private zzln zzasc;
    private zzle zzasd;
    private int zzase;
    private int zzasf;
    private long zzasg;

    @SuppressLint({"HandlerLeak"})
    public zzla(zzlo[] zzloArr, zzrp zzrp, zzll zzll) {
        String str = zzsy.zzbnq;
        StringBuilder sb = new StringBuilder(String.valueOf("Init ExoPlayerLib/2.4.2 [").length() + 1 + String.valueOf(str).length());
        sb.append("Init ExoPlayerLib/2.4.2 [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        zzsk.checkState(zzloArr.length > 0);
        this.zzaro = (zzlo[]) zzsk.checkNotNull(zzloArr);
        this.zzarp = (zzrp) zzsk.checkNotNull(zzrp);
        this.zzabu = false;
        this.repeatMode = 0;
        this.zzabv = 1;
        this.zzabs = new CopyOnWriteArraySet<>();
        this.zzarq = new zzro(new zzrm[zzloArr.length]);
        this.zzary = zzlr.zzaum;
        this.zzars = new zzlu();
        this.zzart = new zzlt();
        this.zzasa = zzrb.zzbkw;
        this.zzasb = this.zzarq;
        this.zzasc = zzln.zzaug;
        this.zzabq = new zzlb(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.zzasd = new zzle(0, 0);
        this.zzarr = new zzlc(zzloArr, zzrp, zzll, this.zzabu, 0, this.zzabq, this.zzasd, this);
    }

    public final void zza(zzkw zzkw) {
        this.zzabs.add(zzkw);
    }

    public final void zzb(zzkw zzkw) {
        this.zzabs.remove(zzkw);
    }

    public final int getPlaybackState() {
        return this.zzabv;
    }

    public final void zza(zzql zzql) {
        if (!this.zzary.isEmpty() || this.zzarz != null) {
            this.zzary = zzlr.zzaum;
            this.zzarz = null;
            Iterator<zzkw> it = this.zzabs.iterator();
            while (it.hasNext()) {
                it.next().zza(this.zzary, this.zzarz);
            }
        }
        if (this.zzaru) {
            this.zzaru = false;
            this.zzasa = zzrb.zzbkw;
            this.zzasb = this.zzarq;
            this.zzarp.zzd((Object) null);
            Iterator<zzkw> it2 = this.zzabs.iterator();
            while (it2.hasNext()) {
                it2.next().zza(this.zzasa, this.zzasb);
            }
        }
        this.zzarw++;
        this.zzarr.zza(zzql, true);
    }

    public final void zzd(boolean z) {
        if (this.zzabu != z) {
            this.zzabu = z;
            this.zzarr.zzd(z);
            Iterator<zzkw> it = this.zzabs.iterator();
            while (it.hasNext()) {
                it.next().zza(z, this.zzabv);
            }
        }
    }

    public final boolean zzdm() {
        return this.zzabu;
    }

    public final void seekTo(long j) {
        int zzgu = zzgu();
        if (zzgu < 0 || (!this.zzary.isEmpty() && zzgu >= this.zzary.zzhf())) {
            throw new zzlk(this.zzary, zzgu, j);
        }
        this.zzarv++;
        this.zzase = zzgu;
        if (this.zzary.isEmpty()) {
            this.zzasf = 0;
        } else {
            this.zzary.zza(zzgu, this.zzars, false);
            if (j != C1470C.TIME_UNSET) {
                zzkt.zzea(j);
            }
            this.zzary.zza(0, this.zzart, false);
            this.zzasf = 0;
        }
        if (j == C1470C.TIME_UNSET) {
            this.zzasg = 0;
            this.zzarr.zza(this.zzary, zzgu, (long) C1470C.TIME_UNSET);
            return;
        }
        this.zzasg = j;
        this.zzarr.zza(this.zzary, zzgu, zzkt.zzea(j));
        Iterator<zzkw> it = this.zzabs.iterator();
        while (it.hasNext()) {
            it.next().zzgt();
        }
    }

    public final void stop() {
        this.zzarr.stop();
    }

    public final void release() {
        this.zzarr.release();
        this.zzabq.removeCallbacksAndMessages((Object) null);
    }

    public final void zza(zzky... zzkyArr) {
        this.zzarr.zza(zzkyArr);
    }

    public final void zzb(zzky... zzkyArr) {
        this.zzarr.zzb(zzkyArr);
    }

    private final int zzgu() {
        if (this.zzary.isEmpty() || this.zzarv > 0) {
            return this.zzase;
        }
        this.zzary.zza(this.zzasd.zzatb, this.zzart, false);
        return 0;
    }

    public final long getDuration() {
        if (this.zzary.isEmpty()) {
            return C1470C.TIME_UNSET;
        }
        return zzkt.zzdz(this.zzary.zza(zzgu(), this.zzars, false).zzack);
    }

    public final long zzdn() {
        if (this.zzary.isEmpty() || this.zzarv > 0) {
            return this.zzasg;
        }
        this.zzary.zza(this.zzasd.zzatb, this.zzart, false);
        return this.zzart.zzhh() + zzkt.zzdz(this.zzasd.zzacl);
    }

    public final long getBufferedPosition() {
        if (this.zzary.isEmpty() || this.zzarv > 0) {
            return this.zzasg;
        }
        this.zzary.zza(this.zzasd.zzatb, this.zzart, false);
        return this.zzart.zzhh() + zzkt.zzdz(this.zzasd.zzacm);
    }

    public final int zzgs() {
        return this.zzaro.length;
    }

    /* access modifiers changed from: package-private */
    public final void zza(Message message) {
        boolean z = true;
        switch (message.what) {
            case 0:
                this.zzarw--;
                return;
            case 1:
                this.zzabv = message.arg1;
                Iterator<zzkw> it = this.zzabs.iterator();
                while (it.hasNext()) {
                    it.next().zza(this.zzabu, this.zzabv);
                }
                return;
            case 2:
                if (message.arg1 == 0) {
                    z = false;
                }
                this.zzarx = z;
                Iterator<zzkw> it2 = this.zzabs.iterator();
                while (it2.hasNext()) {
                    it2.next().zzh(this.zzarx);
                }
                return;
            case 3:
                if (this.zzarw == 0) {
                    zzrr zzrr = (zzrr) message.obj;
                    this.zzaru = true;
                    this.zzasa = zzrr.zzbly;
                    this.zzasb = zzrr.zzblz;
                    this.zzarp.zzd(zzrr.zzbma);
                    Iterator<zzkw> it3 = this.zzabs.iterator();
                    while (it3.hasNext()) {
                        it3.next().zza(this.zzasa, this.zzasb);
                    }
                    return;
                }
                return;
            case 4:
                int i = this.zzarv - 1;
                this.zzarv = i;
                if (i == 0) {
                    this.zzasd = (zzle) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzkw> it4 = this.zzabs.iterator();
                        while (it4.hasNext()) {
                            it4.next().zzgt();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.zzarv == 0) {
                    this.zzasd = (zzle) message.obj;
                    Iterator<zzkw> it5 = this.zzabs.iterator();
                    while (it5.hasNext()) {
                        it5.next().zzgt();
                    }
                    return;
                }
                return;
            case 6:
                zzlg zzlg = (zzlg) message.obj;
                this.zzarv -= zzlg.zzatk;
                if (this.zzarw == 0) {
                    this.zzary = zzlg.zzary;
                    this.zzarz = zzlg.zzarz;
                    this.zzasd = zzlg.zzasd;
                    Iterator<zzkw> it6 = this.zzabs.iterator();
                    while (it6.hasNext()) {
                        it6.next().zza(this.zzary, this.zzarz);
                    }
                    return;
                }
                return;
            case 7:
                zzln zzln = (zzln) message.obj;
                if (!this.zzasc.equals(zzln)) {
                    this.zzasc = zzln;
                    Iterator<zzkw> it7 = this.zzabs.iterator();
                    while (it7.hasNext()) {
                        it7.next().zza(zzln);
                    }
                    return;
                }
                return;
            case 8:
                zzku zzku = (zzku) message.obj;
                Iterator<zzkw> it8 = this.zzabs.iterator();
                while (it8.hasNext()) {
                    it8.next().zza(zzku);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
