package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class zzhd extends zzgr {
    private final zzhi zzaeu;
    /* access modifiers changed from: private */
    public final zzhh zzaev;
    private final long zzaew;
    private final int zzaex;
    private final int zzaey;
    private Surface zzaez;
    private boolean zzafa;
    private boolean zzafb;
    private long zzafc;
    private long zzafd;
    private int zzafe;
    private int zzaff;
    private int zzafg;
    private float zzafh;
    private int zzafi;
    private int zzafj;
    private float zzafk;

    public zzhd(zzhn zzhn, int i, long j, Handler handler, zzhh zzhh, int i2) {
        this(zzhn, (zzhz) null, true, 1, 0, (zzhi) null, handler, zzhh, -1);
    }

    private zzhd(zzhn zzhn, zzhz zzhz, boolean z, int i, long j, zzhi zzhi, Handler handler, zzhh zzhh, int i2) {
        super(zzhn, (zzhz) null, true, handler, zzhh);
        this.zzaex = 1;
        this.zzaew = 0;
        this.zzaeu = null;
        this.zzaev = zzhh;
        this.zzaey = -1;
        this.zzafc = -1;
        this.zzaff = -1;
        this.zzafg = -1;
        this.zzafh = -1.0f;
        this.zzafi = -1;
        this.zzafj = -1;
        this.zzafk = -1.0f;
    }

    /* access modifiers changed from: protected */
    public final boolean zzas(String str) {
        return zzkl.zzau(str).equals(MimeTypes.BASE_TYPE_VIDEO) && super.zzas(str);
    }

    /* access modifiers changed from: protected */
    public final void zzb(long j, boolean z) {
        super.zzb(j, z);
        this.zzafb = false;
        if (z && this.zzaew > 0) {
            this.zzafc = (SystemClock.elapsedRealtime() * 1000) + this.zzaew;
        }
    }

    /* access modifiers changed from: protected */
    public final void seekTo(long j) throws zzgd {
        super.seekTo(j);
        this.zzafb = false;
        this.zzafc = -1;
    }

    /* access modifiers changed from: protected */
    public final boolean isReady() {
        if (super.isReady() && (this.zzafb || !zzec() || zzeg() == 2)) {
            this.zzafc = -1;
            return true;
        } else if (this.zzafc == -1) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() * 1000 < this.zzafc) {
                return true;
            }
            this.zzafc = -1;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void onStarted() {
        super.onStarted();
        this.zzafe = 0;
        this.zzafd = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: protected */
    public final void onStopped() {
        this.zzafc = -1;
        zzel();
        super.onStopped();
    }

    public final void zzdz() {
        this.zzaff = -1;
        this.zzafg = -1;
        this.zzafh = -1.0f;
        this.zzafi = -1;
        this.zzafj = -1;
        this.zzafk = -1.0f;
        super.zzdz();
    }

    public final void zza(int i, Object obj) throws zzgd {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (this.zzaez != surface) {
                this.zzaez = surface;
                this.zzafa = false;
                int state = getState();
                if (state == 2 || state == 3) {
                    zzed();
                    zzea();
                    return;
                }
                return;
            }
            return;
        }
        super.zza(i, obj);
    }

    /* access modifiers changed from: protected */
    public final boolean zzeb() {
        return super.zzeb() && this.zzaez != null && this.zzaez.isValid();
    }

    /* access modifiers changed from: protected */
    public final void zza(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, MediaCrypto mediaCrypto) {
        mediaCodec.configure(mediaFormat, this.zzaez, mediaCrypto, 0);
        mediaCodec.setVideoScalingMode(this.zzaex);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzhk zzhk) throws zzgd {
        float f;
        super.zza(zzhk);
        if (zzhk.zzado.zzaft == -1.0f) {
            f = 1.0f;
        } else {
            f = zzhk.zzado.zzaft;
        }
        this.zzafh = f;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzhj zzhj, MediaFormat mediaFormat) {
        int i;
        int i2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i = mediaFormat.getInteger("width");
        }
        this.zzaff = i;
        if (z) {
            i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        this.zzafg = i2;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(MediaCodec mediaCodec, boolean z, zzhj zzhj, zzhj zzhj2) {
        if (!zzhj2.mimeType.equals(zzhj.mimeType)) {
            return false;
        }
        if (!z) {
            return zzhj.width == zzhj2.width && zzhj.height == zzhj2.height;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i, boolean z) {
        if (z) {
            zzkp.beginSection("skipVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            zzkp.endSection();
            this.zzadf.zzabl++;
            return true;
        }
        long elapsedRealtime = (bufferInfo.presentationTimeUs - j) - ((SystemClock.elapsedRealtime() * 1000) - j2);
        long nanoTime = System.nanoTime() + (elapsedRealtime * 1000);
        if (elapsedRealtime < -30000) {
            zzkp.beginSection("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            zzkp.endSection();
            this.zzadf.zzabm++;
            this.zzafe++;
            if (this.zzafe == this.zzaey) {
                zzel();
            }
            return true;
        } else if (!this.zzafb) {
            zza(mediaCodec, i);
            return true;
        } else if (getState() != 3) {
            return false;
        } else {
            if (zzkq.SDK_INT >= 21) {
                if (elapsedRealtime < 50000) {
                    zzej();
                    zzkp.beginSection("releaseOutputBufferTimed");
                    mediaCodec.releaseOutputBuffer(i, nanoTime);
                    zzkp.endSection();
                    this.zzadf.zzabk++;
                    this.zzafb = true;
                    zzek();
                    return true;
                }
            } else if (elapsedRealtime < 30000) {
                if (elapsedRealtime > 11000) {
                    try {
                        Thread.sleep((elapsedRealtime - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                zza(mediaCodec, i);
                return true;
            }
            return false;
        }
    }

    private final void zza(MediaCodec mediaCodec, int i) {
        zzej();
        zzkp.beginSection("renderVideoBufferImmediate");
        mediaCodec.releaseOutputBuffer(i, true);
        zzkp.endSection();
        this.zzadf.zzabk++;
        this.zzafb = true;
        zzek();
    }

    private final void zzej() {
        if (this.zzabq != null && this.zzaev != null) {
            if (this.zzafi != this.zzaff || this.zzafj != this.zzafg || this.zzafk != this.zzafh) {
                int i = this.zzaff;
                int i2 = this.zzafg;
                float f = this.zzafh;
                this.zzabq.post(new zzhe(this, i, i2, f));
                this.zzafi = i;
                this.zzafj = i2;
                this.zzafk = f;
            }
        }
    }

    private final void zzek() {
        if (this.zzabq != null && this.zzaev != null && !this.zzafa) {
            this.zzabq.post(new zzhf(this, this.zzaez));
            this.zzafa = true;
        }
    }

    private final void zzel() {
        if (this.zzabq != null && this.zzaev != null && this.zzafe != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzabq.post(new zzhg(this, this.zzafe, elapsedRealtime - this.zzafd));
            this.zzafe = 0;
            this.zzafd = elapsedRealtime;
        }
    }
}
