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
public final class zzms extends zzpe implements zzso {
    private long zzadb;
    private int zzafu;
    private int zzatx;
    /* access modifiers changed from: private */
    public final zzma zzaxq;
    private final zzmh zzaxr;
    private boolean zzaxs;
    private boolean zzaxt;
    private MediaFormat zzaxu;
    /* access modifiers changed from: private */
    public boolean zzaxv;

    public zzms(zzpg zzpg) {
        this(zzpg, (zznj<Object>) null, true);
    }

    protected static void zzag(int i) {
    }

    protected static void zzc(int i, long j, long j2) {
    }

    protected static void zzhv() {
    }

    public final zzso zzgj() {
        return this;
    }

    private zzms(zzpg zzpg, zznj<Object> zznj, boolean z) {
        this(zzpg, (zznj<Object>) null, true, (Handler) null, (zzlz) null);
    }

    private zzms(zzpg zzpg, zznj<Object> zznj, boolean z, Handler handler, zzlz zzlz) {
        this(zzpg, (zznj<Object>) null, true, (Handler) null, (zzlz) null, (zzlw) null, new zzlx[0]);
    }

    private zzms(zzpg zzpg, zznj<Object> zznj, boolean z, Handler handler, zzlz zzlz, zzlw zzlw, zzlx... zzlxArr) {
        super(1, zzpg, zznj, z);
        this.zzaxr = new zzmh((zzlw) null, zzlxArr, new zzmu(this));
        this.zzaxq = new zzma((Handler) null, (zzlz) null);
    }

    /* access modifiers changed from: protected */
    public final int zza(zzpg zzpg, zzlh zzlh) throws zzpk {
        String str = zzlh.zzatq;
        if (!zzsp.zzav(str)) {
            return 0;
        }
        int i = zzsy.SDK_INT >= 21 ? 16 : 0;
        int i2 = 3;
        if (zzbb(str) && zzpg.zziv() != null) {
            return i | 4 | 3;
        }
        zzpd zze = zzpg.zze(str, false);
        boolean z = true;
        if (zze == null) {
            return 1;
        }
        if (zzsy.SDK_INT >= 21 && ((zzlh.zzafv != -1 && !zze.zzba(zzlh.zzafv)) || (zzlh.zzafu != -1 && !zze.zzbb(zzlh.zzafu)))) {
            z = false;
        }
        if (!z) {
            i2 = 2;
        }
        return i | 4 | i2;
    }

    /* access modifiers changed from: protected */
    public final zzpd zza(zzpg zzpg, zzlh zzlh, boolean z) throws zzpk {
        zzpd zziv;
        if (!zzbb(zzlh.zzatq) || (zziv = zzpg.zziv()) == null) {
            this.zzaxs = false;
            return super.zza(zzpg, zzlh, z);
        }
        this.zzaxs = true;
        return zziv;
    }

    private final boolean zzbb(String str) {
        return this.zzaxr.zzaz(str);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzpd zzpd, MediaCodec mediaCodec, zzlh zzlh, MediaCrypto mediaCrypto) {
        this.zzaxt = zzsy.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(zzpd.name) && "samsung".equals(zzsy.MANUFACTURER) && (zzsy.DEVICE.startsWith("zeroflte") || zzsy.DEVICE.startsWith("herolte") || zzsy.DEVICE.startsWith("heroqlte"));
        if (this.zzaxs) {
            this.zzaxu = zzlh.zzen();
            this.zzaxu.setString("mime", MimeTypes.AUDIO_RAW);
            mediaCodec.configure(this.zzaxu, (Surface) null, (MediaCrypto) null, 0);
            this.zzaxu.setString("mime", zzlh.zzatq);
            return;
        }
        mediaCodec.configure(zzlh.zzen(), (Surface) null, (MediaCrypto) null, 0);
        this.zzaxu = null;
    }

    /* access modifiers changed from: protected */
    public final void zzd(String str, long j, long j2) {
        this.zzaxq.zzc(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzlh zzlh) throws zzku {
        super.zzd(zzlh);
        this.zzaxq.zzc(zzlh);
        this.zzatx = MimeTypes.AUDIO_RAW.equals(zzlh.zzatq) ? zzlh.zzatx : 2;
        this.zzafu = zzlh.zzafu;
    }

    /* access modifiers changed from: protected */
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzku {
        int[] iArr;
        boolean z = this.zzaxu != null;
        String string = z ? this.zzaxu.getString("mime") : MimeTypes.AUDIO_RAW;
        if (z) {
            mediaFormat = this.zzaxu;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (!this.zzaxt || integer != 6 || this.zzafu >= 6) {
            iArr = null;
        } else {
            iArr = new int[this.zzafu];
            for (int i = 0; i < this.zzafu; i++) {
                iArr[i] = i;
            }
        }
        try {
            this.zzaxr.zza(string, integer, integer2, this.zzatx, 0, iArr);
        } catch (zzml e) {
            throw zzku.zza(e, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    public final void zzg(boolean z) throws zzku {
        super.zzg(z);
        this.zzaxq.zzc(this.zzbhl);
        int i = zzgq().zzaul;
        if (i != 0) {
            this.zzaxr.zzai(i);
        } else {
            this.zzaxr.zzhr();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzd(long j, boolean z) throws zzku {
        super.zzd(j, z);
        this.zzaxr.reset();
        this.zzadb = j;
        this.zzaxv = true;
    }

    /* access modifiers changed from: protected */
    public final void onStarted() {
        super.onStarted();
        this.zzaxr.play();
    }

    /* access modifiers changed from: protected */
    public final void onStopped() {
        this.zzaxr.pause();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public final void zzdz() {
        try {
            this.zzaxr.release();
            try {
                super.zzdz();
            } finally {
                this.zzbhl.zzdk();
                this.zzaxq.zzd(this.zzbhl);
            }
        } catch (Throwable th) {
            super.zzdz();
            throw th;
        } finally {
            this.zzbhl.zzdk();
            this.zzaxq.zzd(this.zzbhl);
        }
    }

    public final boolean zzdx() {
        return super.zzdx() && this.zzaxr.zzdx();
    }

    public final boolean isReady() {
        return this.zzaxr.zzer() || super.isReady();
    }

    public final long zzdv() {
        long zzf = this.zzaxr.zzf(zzdx());
        if (zzf != Long.MIN_VALUE) {
            if (!this.zzaxv) {
                zzf = Math.max(this.zzadb, zzf);
            }
            this.zzadb = zzf;
            this.zzaxv = false;
        }
        return this.zzadb;
    }

    public final zzln zzb(zzln zzln) {
        return this.zzaxr.zzb(zzln);
    }

    public final zzln zzhq() {
        return this.zzaxr.zzhq();
    }

    /* access modifiers changed from: protected */
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzku {
        if (this.zzaxs && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.zzbhl.zzabl++;
            this.zzaxr.zzeq();
            return true;
        } else {
            try {
                if (!this.zzaxr.zza(byteBuffer, j3)) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                this.zzbhl.zzabk++;
                return true;
            } catch (zzmm | zzmp e) {
                throw zzku.zza(e, getIndex());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzhw() throws zzku {
        try {
            this.zzaxr.zzho();
        } catch (zzmp e) {
            throw zzku.zza(e, getIndex());
        }
    }

    public final void zza(int i, Object obj) throws zzku {
        switch (i) {
            case 2:
                this.zzaxr.setVolume(((Float) obj).floatValue());
                return;
            case 3:
                this.zzaxr.setStreamType(((Integer) obj).intValue());
                return;
            default:
                super.zza(i, obj);
                return;
        }
    }
}
