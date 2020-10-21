package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer2.DefaultLoadControl;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class zzgi implements zzge {
    private final Handler zzabq;
    private final zzgk zzabr;
    private final CopyOnWriteArraySet<zzgh> zzabs = new CopyOnWriteArraySet<>();
    private final boolean[] zzabt = new boolean[2];
    private boolean zzabu = false;
    private int zzabv = 1;
    private int zzabw;

    @SuppressLint({"HandlerLeak"})
    public zzgi(int i, int i2, int i3) {
        Log.i("ExoPlayerImpl", "Init 1.3.1");
        for (int i4 = 0; i4 < this.zzabt.length; i4++) {
            this.zzabt[i4] = true;
        }
        this.zzabq = new zzgj(this);
        this.zzabr = new zzgk(this.zzabq, this.zzabu, this.zzabt, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 5000);
    }

    public final void zza(zzgh zzgh) {
        this.zzabs.add(zzgh);
    }

    public final int getPlaybackState() {
        return this.zzabv;
    }

    public final void zza(zzhp... zzhpArr) {
        this.zzabr.zza(zzhpArr);
    }

    public final void zzc(int i, boolean z) {
        if (this.zzabt[0] != z) {
            this.zzabt[0] = z;
            this.zzabr.zzc(0, z);
        }
    }

    public final void zzd(boolean z) {
        if (this.zzabu != z) {
            this.zzabu = z;
            this.zzabw++;
            this.zzabr.zzd(z);
            Iterator<zzgh> it = this.zzabs.iterator();
            while (it.hasNext()) {
                it.next().zza(z, this.zzabv);
            }
        }
    }

    public final boolean zzdm() {
        return this.zzabu;
    }

    public final void seekTo(long j) {
        this.zzabr.seekTo(j);
    }

    public final void stop() {
        this.zzabr.stop();
    }

    public final void release() {
        this.zzabr.release();
        this.zzabq.removeCallbacksAndMessages((Object) null);
    }

    public final void zza(zzgf zzgf, int i, Object obj) {
        this.zzabr.zza(zzgf, 1, obj);
    }

    public final void zzb(zzgf zzgf, int i, Object obj) {
        this.zzabr.zzb(zzgf, 1, obj);
    }

    public final long getDuration() {
        return this.zzabr.getDuration();
    }

    public final long zzdn() {
        return this.zzabr.zzdn();
    }

    public final long getBufferedPosition() {
        return this.zzabr.getBufferedPosition();
    }

    /* access modifiers changed from: package-private */
    public final void zza(Message message) {
        switch (message.what) {
            case 1:
                this.zzabv = message.arg1;
                Iterator<zzgh> it = this.zzabs.iterator();
                while (it.hasNext()) {
                    it.next().zza(this.zzabu, this.zzabv);
                }
                return;
            case 2:
                this.zzabw--;
                if (this.zzabw == 0) {
                    Iterator<zzgh> it2 = this.zzabs.iterator();
                    while (it2.hasNext()) {
                        it2.next().zzdo();
                    }
                    return;
                }
                return;
            case 3:
                zzgd zzgd = (zzgd) message.obj;
                Iterator<zzgh> it3 = this.zzabs.iterator();
                while (it3.hasNext()) {
                    it3.next().zza(zzgd);
                }
                return;
            default:
                return;
        }
    }
}
