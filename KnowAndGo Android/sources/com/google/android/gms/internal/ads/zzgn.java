package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class zzgn extends zzgr {
    /* access modifiers changed from: private */
    public final zzgq zzacy;
    private final zzhq zzacz;
    private int zzada;
    private long zzadb;

    public zzgn(zzhn zzhn, Handler handler, zzgq zzgq) {
        this(zzhn, (zzhz) null, true, handler, zzgq);
    }

    /* access modifiers changed from: protected */
    public final boolean zzdw() {
        return true;
    }

    private zzgn(zzhn zzhn, zzhz zzhz, boolean z, Handler handler, zzgq zzgq) {
        super(zzhn, (zzhz) null, true, handler, zzgq);
        this.zzacy = zzgq;
        this.zzada = 0;
        this.zzacz = new zzhq();
    }

    /* access modifiers changed from: protected */
    public final zzgc zzc(String str, boolean z) throws zzgz {
        if (zzkl.zzaw(str)) {
            return new zzgc("OMX.google.raw.decoder", true);
        }
        return super.zzc(str, z);
    }

    /* access modifiers changed from: protected */
    public final void zza(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, MediaCrypto mediaCrypto) {
        if ("OMX.google.raw.decoder".equals(str)) {
            String string = mediaFormat.getString("mime");
            mediaFormat.setString("mime", MimeTypes.AUDIO_RAW);
            mediaCodec.configure(mediaFormat, (Surface) null, mediaCrypto, 0);
            mediaFormat.setString("mime", string);
            return;
        }
        mediaCodec.configure(mediaFormat, (Surface) null, mediaCrypto, 0);
    }

    /* access modifiers changed from: protected */
    public final boolean zzas(String str) {
        return zzkl.zzav(str) && super.zzas(str);
    }

    /* access modifiers changed from: protected */
    public final void zzb(long j, boolean z) {
        super.zzb(j, z);
        this.zzadb = Long.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzhj zzhj, MediaFormat mediaFormat) {
        if (zzkl.zzaw(zzhj.mimeType)) {
            this.zzacz.zza(zzhj.zzen(), 0);
        } else {
            this.zzacz.zza(mediaFormat, 0);
        }
    }

    /* access modifiers changed from: protected */
    public final void onStarted() {
        super.onStarted();
        this.zzacz.play();
    }

    /* access modifiers changed from: protected */
    public final void onStopped() {
        this.zzacz.pause();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public final boolean zzdx() {
        if (super.zzdx()) {
            return !this.zzacz.zzer() || !this.zzacz.zzes();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean isReady() {
        if (!this.zzacz.zzer()) {
            return super.isReady() && zzeg() == 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final long zzdy() {
        long zzf = this.zzacz.zzf(zzdx());
        if (zzf == Long.MIN_VALUE) {
            this.zzadb = Math.max(this.zzadb, super.zzdy());
        } else {
            this.zzadb = Math.max(this.zzadb, zzf);
        }
        return this.zzadb;
    }

    /* access modifiers changed from: protected */
    public final void zzdz() {
        this.zzada = 0;
        try {
            this.zzacz.reset();
        } finally {
            super.zzdz();
        }
    }

    /* access modifiers changed from: protected */
    public final void seekTo(long j) throws zzgd {
        super.seekTo(j);
        this.zzacz.reset();
        this.zzadb = Long.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i, boolean z) throws zzgd {
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.zzadf.zzabl++;
            this.zzacz.zzeq();
            return true;
        }
        if (!this.zzacz.isInitialized()) {
            try {
                if (this.zzada != 0) {
                    this.zzacz.zzq(this.zzada);
                } else {
                    this.zzada = this.zzacz.zzq(0);
                }
                if (getState() == 3) {
                    this.zzacz.play();
                }
            } catch (zzhu e) {
                if (!(this.zzabq == null || this.zzacy == null)) {
                    this.zzabq.post(new zzgo(this, e));
                }
                throw new zzgd((Throwable) e);
            }
        }
        try {
            int zza = this.zzacz.zza(byteBuffer, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs);
            if ((zza & 1) != 0) {
                this.zzadb = Long.MIN_VALUE;
            }
            if ((zza & 2) == 0) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.zzadf.zzabk++;
            return true;
        } catch (zzhv e2) {
            if (!(this.zzabq == null || this.zzacy == null)) {
                this.zzabq.post(new zzgp(this, e2));
            }
            throw new zzgd((Throwable) e2);
        }
    }

    public final void zza(int i, Object obj) throws zzgd {
        if (i == 1) {
            this.zzacz.setVolume(((Float) obj).floatValue());
        } else {
            super.zza(i, obj);
        }
    }
}
