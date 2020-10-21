package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.C1470C;
import com.onesignal.OneSignalRemoteParams;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class zzth extends zzpe {
    private static final int[] zzbod = {1920, 1600, OneSignalRemoteParams.DEFAULT_INDIRECT_ATTRIBUTION_WINDOW, 1280, 960, 854, 640, 540, 480};
    private Surface zzaez;
    private boolean zzafb;
    private long zzafd;
    private int zzaff;
    private int zzafg;
    private float zzafh;
    private int zzaul;
    private boolean zzawy;
    private final zztl zzboe;
    private final zzto zzbof;
    private final long zzbog;
    private final int zzboh;
    private final boolean zzboi;
    private final long[] zzboj;
    private zzlh[] zzbok;
    private zztj zzbol;
    private Surface zzbom;
    private int zzbon;
    private long zzboo;
    private int zzbop;
    private int zzboq;
    private int zzbor;
    private float zzbos;
    private int zzbot;
    private int zzbou;
    private int zzbov;
    private int zzbow;
    private float zzbox;
    zztk zzboy;
    private long zzboz;
    private int zzbpa;
    private final Context zzlj;

    public zzth(Context context, zzpg zzpg, long j, Handler handler, zztn zztn, int i) {
        this(context, zzpg, 0, (zznj<Object>) null, false, handler, zztn, -1);
    }

    private static boolean zzer(long j) {
        return j < -30000;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzth(Context context, zzpg zzpg, long j, zznj<Object> zznj, boolean z, Handler handler, zztn zztn, int i) {
        super(2, zzpg, (zznj<Object>) null, false);
        boolean z2 = false;
        this.zzbog = 0;
        this.zzboh = -1;
        this.zzlj = context.getApplicationContext();
        this.zzboe = new zztl(context);
        this.zzbof = new zzto(handler, zztn);
        if (zzsy.SDK_INT <= 22 && "foster".equals(zzsy.DEVICE) && "NVIDIA".equals(zzsy.MANUFACTURER)) {
            z2 = true;
        }
        this.zzboi = z2;
        this.zzboj = new long[10];
        this.zzboz = C1470C.TIME_UNSET;
        this.zzboo = C1470C.TIME_UNSET;
        this.zzaff = -1;
        this.zzafg = -1;
        this.zzafh = -1.0f;
        this.zzbos = -1.0f;
        this.zzbon = 1;
        zzkk();
    }

    /* access modifiers changed from: protected */
    public final int zza(zzpg zzpg, zzlh zzlh) throws zzpk {
        boolean z;
        String str = zzlh.zzatq;
        int i = 0;
        if (!zzsp.zzbf(str)) {
            return 0;
        }
        zzne zzne = zzlh.zzatr;
        if (zzne != null) {
            z = false;
            for (int i2 = 0; i2 < zzne.zzazg; i2++) {
                z |= zzne.zzap(i2).zzazh;
            }
        } else {
            z = false;
        }
        zzpd zze = zzpg.zze(str, z);
        if (zze == null) {
            return 1;
        }
        boolean zzat = zze.zzat(zzlh.zzatn);
        if (zzat && zzlh.width > 0 && zzlh.height > 0) {
            if (zzsy.SDK_INT >= 21) {
                zzat = zze.zza(zzlh.width, zzlh.height, (double) zzlh.zzats);
            } else {
                zzat = zzlh.width * zzlh.height <= zzpi.zziw();
                if (!zzat) {
                    int i3 = zzlh.width;
                    int i4 = zzlh.height;
                    String str2 = zzsy.zzbnq;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i3);
                    sb.append("x");
                    sb.append(i4);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append("]");
                    Log.d("MediaCodecVideoRenderer", sb.toString());
                }
            }
        }
        int i5 = zze.zzabo ? 8 : 4;
        if (zze.zzawy) {
            i = 16;
        }
        return (zzat ? 3 : 2) | i5 | i;
    }

    /* access modifiers changed from: protected */
    public final void zzg(boolean z) throws zzku {
        super.zzg(z);
        this.zzaul = zzgq().zzaul;
        this.zzawy = this.zzaul != 0;
        this.zzbof.zzc(this.zzbhl);
        this.zzboe.enable();
    }

    /* access modifiers changed from: protected */
    public final void zza(zzlh[] zzlhArr, long j) throws zzku {
        this.zzbok = zzlhArr;
        if (this.zzboz == C1470C.TIME_UNSET) {
            this.zzboz = j;
        } else {
            if (this.zzbpa == this.zzboj.length) {
                long j2 = this.zzboj[this.zzbpa - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.zzbpa++;
            }
            this.zzboj[this.zzbpa - 1] = j;
        }
        super.zza(zzlhArr, j);
    }

    /* access modifiers changed from: protected */
    public final void zzd(long j, boolean z) throws zzku {
        super.zzd(j, z);
        zzki();
        this.zzboq = 0;
        if (this.zzbpa != 0) {
            this.zzboz = this.zzboj[this.zzbpa - 1];
            this.zzbpa = 0;
        }
        if (z) {
            zzkh();
        } else {
            this.zzboo = C1470C.TIME_UNSET;
        }
    }

    public final boolean isReady() {
        if (super.isReady() && (this.zzafb || ((this.zzbom != null && this.zzaez == this.zzbom) || zzir() == null))) {
            this.zzboo = C1470C.TIME_UNSET;
            return true;
        } else if (this.zzboo == C1470C.TIME_UNSET) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzboo) {
                return true;
            }
            this.zzboo = C1470C.TIME_UNSET;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void onStarted() {
        super.onStarted();
        this.zzbop = 0;
        this.zzafd = SystemClock.elapsedRealtime();
        this.zzboo = C1470C.TIME_UNSET;
    }

    /* access modifiers changed from: protected */
    public final void onStopped() {
        zzkm();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public final void zzdz() {
        this.zzaff = -1;
        this.zzafg = -1;
        this.zzafh = -1.0f;
        this.zzbos = -1.0f;
        this.zzboz = C1470C.TIME_UNSET;
        this.zzbpa = 0;
        zzkk();
        zzki();
        this.zzboe.disable();
        this.zzboy = null;
        this.zzawy = false;
        try {
            super.zzdz();
        } finally {
            this.zzbhl.zzdk();
            this.zzbof.zzd(this.zzbhl);
        }
    }

    public final void zza(int i, Object obj) throws zzku {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                if (this.zzbom != null) {
                    surface = this.zzbom;
                } else {
                    zzpd zzis = zzis();
                    if (zzis != null && zzn(zzis.zzaer)) {
                        this.zzbom = zztd.zzc(this.zzlj, zzis.zzaer);
                        surface = this.zzbom;
                    }
                }
            }
            if (this.zzaez != surface) {
                this.zzaez = surface;
                int state = getState();
                if (state == 1 || state == 2) {
                    MediaCodec zzir = zzir();
                    if (zzsy.SDK_INT < 23 || zzir == null || surface == null) {
                        zzed();
                        zzea();
                    } else {
                        zzir.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.zzbom) {
                    zzkk();
                    zzki();
                    return;
                }
                zzkl();
                zzki();
                if (state == 2) {
                    zzkh();
                }
            } else if (surface != null && surface != this.zzbom) {
                zzkl();
                if (this.zzafb) {
                    this.zzbof.zzc(this.zzaez);
                }
            }
        } else if (i == 4) {
            this.zzbon = ((Integer) obj).intValue();
            MediaCodec zzir2 = zzir();
            if (zzir2 != null) {
                zzir2.setVideoScalingMode(this.zzbon);
            }
        } else {
            super.zza(i, obj);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzpd zzpd) {
        return this.zzaez != null || zzn(zzpd.zzaer);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzpd zzpd, MediaCodec mediaCodec, zzlh zzlh, MediaCrypto mediaCrypto) throws zzpk {
        zztj zztj;
        Point point;
        zzpd zzpd2 = zzpd;
        MediaCodec mediaCodec2 = mediaCodec;
        zzlh zzlh2 = zzlh;
        zzlh[] zzlhArr = this.zzbok;
        int i = zzlh2.width;
        int i2 = zzlh2.height;
        int zzi = zzi(zzlh);
        if (zzlhArr.length == 1) {
            zztj = new zztj(i, i2, zzi);
        } else {
            int i3 = i2;
            int i4 = zzi;
            boolean z = false;
            int i5 = i;
            for (zzlh zzlh3 : zzlhArr) {
                if (zza(zzpd2.zzabo, zzlh2, zzlh3)) {
                    z |= zzlh3.width == -1 || zzlh3.height == -1;
                    i5 = Math.max(i5, zzlh3.width);
                    int max = Math.max(i3, zzlh3.height);
                    i4 = Math.max(i4, zzi(zzlh3));
                    i3 = max;
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(i5);
                sb.append("x");
                sb.append(i3);
                Log.w("MediaCodecVideoRenderer", sb.toString());
                boolean z2 = zzlh2.height > zzlh2.width;
                int i6 = z2 ? zzlh2.height : zzlh2.width;
                int i7 = z2 ? zzlh2.width : zzlh2.height;
                float f = ((float) i7) / ((float) i6);
                int[] iArr = zzbod;
                int length = iArr.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        break;
                    }
                    int i9 = iArr[i8];
                    int i10 = (int) (((float) i9) * f);
                    if (i9 <= i6 || i10 <= i7) {
                        break;
                    }
                    int i11 = i6;
                    int i12 = i7;
                    if (zzsy.SDK_INT >= 21) {
                        int i13 = z2 ? i10 : i9;
                        if (!z2) {
                            i9 = i10;
                        }
                        Point zze = zzpd2.zze(i13, i9);
                        Point point2 = zze;
                        if (zzpd2.zza(zze.x, zze.y, (double) zzlh2.zzats)) {
                            point = point2;
                            break;
                        }
                    } else {
                        int zzb = zzsy.zzb(i9, 16) << 4;
                        int zzb2 = zzsy.zzb(i10, 16) << 4;
                        if (zzb * zzb2 <= zzpi.zziw()) {
                            int i14 = z2 ? zzb2 : zzb;
                            if (z2) {
                                zzb2 = zzb;
                            }
                            point = new Point(i14, zzb2);
                        }
                    }
                    i8++;
                    i6 = i11;
                    i7 = i12;
                }
                point = null;
                if (point != null) {
                    i5 = Math.max(i5, point.x);
                    i3 = Math.max(i3, point.y);
                    i4 = Math.max(i4, zza(zzlh2.zzatq, i5, i3));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(i5);
                    sb2.append("x");
                    sb2.append(i3);
                    Log.w("MediaCodecVideoRenderer", sb2.toString());
                }
            }
            zztj = new zztj(i5, i3, i4);
        }
        this.zzbol = zztj;
        zztj zztj2 = this.zzbol;
        boolean z3 = this.zzboi;
        int i15 = this.zzaul;
        MediaFormat zzen = zzlh.zzen();
        zzen.setInteger("max-width", zztj2.width);
        zzen.setInteger("max-height", zztj2.height);
        if (zztj2.zzbpb != -1) {
            zzen.setInteger("max-input-size", zztj2.zzbpb);
        }
        if (z3) {
            zzen.setInteger("auto-frc", 0);
        }
        if (i15 != 0) {
            zzen.setFeatureEnabled("tunneled-playback", true);
            zzen.setInteger("audio-session-id", i15);
        }
        if (this.zzaez == null) {
            zzsk.checkState(zzn(zzpd2.zzaer));
            if (this.zzbom == null) {
                this.zzbom = zztd.zzc(this.zzlj, zzpd2.zzaer);
            }
            this.zzaez = this.zzbom;
        }
        mediaCodec2.configure(zzen, this.zzaez, (MediaCrypto) null, 0);
        if (zzsy.SDK_INT >= 23 && this.zzawy) {
            this.zzboy = new zztk(this, mediaCodec2);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzed() {
        try {
            super.zzed();
        } finally {
            if (this.zzbom != null) {
                if (this.zzaez == this.zzbom) {
                    this.zzaez = null;
                }
                this.zzbom.release();
                this.zzbom = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzd(String str, long j, long j2) {
        this.zzbof.zzc(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzlh zzlh) throws zzku {
        super.zzd(zzlh);
        this.zzbof.zzc(zzlh);
        this.zzbos = zzlh.zzaft == -1.0f ? 1.0f : zzlh.zzaft;
        this.zzbor = zzj(zzlh);
    }

    /* access modifiers changed from: protected */
    public final void zza(zznd zznd) {
        if (zzsy.SDK_INT < 23 && this.zzawy) {
            zzkj();
        }
    }

    /* access modifiers changed from: protected */
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
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
        this.zzafh = this.zzbos;
        if (zzsy.SDK_INT < 21) {
            this.zzbot = this.zzbor;
        } else if (this.zzbor == 90 || this.zzbor == 270) {
            int i3 = this.zzaff;
            this.zzaff = this.zzafg;
            this.zzafg = i3;
            this.zzafh = 1.0f / this.zzafh;
        }
        mediaCodec.setVideoScalingMode(this.zzbon);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(MediaCodec mediaCodec, boolean z, zzlh zzlh, zzlh zzlh2) {
        return zza(z, zzlh, zzlh2) && zzlh2.width <= this.zzbol.width && zzlh2.height <= this.zzbol.height && zzlh2.zzafs <= this.zzbol.zzbpb;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        MediaCodec mediaCodec2 = mediaCodec;
        int i3 = i;
        long j4 = j3;
        while (this.zzbpa != 0 && j4 >= this.zzboj[0]) {
            this.zzboz = this.zzboj[0];
            this.zzbpa--;
            System.arraycopy(this.zzboj, 1, this.zzboj, 0, this.zzbpa);
        }
        long j5 = j4 - this.zzboz;
        if (z) {
            zza(mediaCodec2, i3, j5);
            return true;
        }
        long j6 = j4 - j;
        if (this.zzaez == this.zzbom) {
            if (!zzer(j6)) {
                return false;
            }
            zza(mediaCodec2, i3, j5);
            return true;
        } else if (!this.zzafb) {
            if (zzsy.SDK_INT >= 21) {
                zza(mediaCodec, i, j5, System.nanoTime());
            } else {
                zzb(mediaCodec2, i3, j5);
            }
            return true;
        } else if (getState() != 2) {
            return false;
        } else {
            long elapsedRealtime = j6 - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            long zzg = this.zzboe.zzg(j4, (elapsedRealtime * 1000) + nanoTime);
            long j7 = (zzg - nanoTime) / 1000;
            if (zzer(j7)) {
                zzsx.beginSection("dropVideoBuffer");
                mediaCodec2.releaseOutputBuffer(i3, false);
                zzsx.endSection();
                this.zzbhl.zzabm++;
                this.zzbop++;
                this.zzboq++;
                this.zzbhl.zzazd = Math.max(this.zzboq, this.zzbhl.zzazd);
                if (this.zzbop == this.zzboh) {
                    zzkm();
                }
                return true;
            }
            if (zzsy.SDK_INT >= 21) {
                if (j7 < 50000) {
                    zza(mediaCodec, i, j5, zzg);
                    return true;
                }
            } else if (j7 < 30000) {
                if (j7 > 11000) {
                    try {
                        Thread.sleep((j7 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                zzb(mediaCodec2, i3, j5);
                return true;
            }
            return false;
        }
    }

    private final void zza(MediaCodec mediaCodec, int i, long j) {
        zzsx.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzsx.endSection();
        this.zzbhl.zzabl++;
    }

    private final void zzb(MediaCodec mediaCodec, int i, long j) {
        zzej();
        zzsx.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzsx.endSection();
        this.zzbhl.zzabk++;
        this.zzboq = 0;
        zzkj();
    }

    @TargetApi(21)
    private final void zza(MediaCodec mediaCodec, int i, long j, long j2) {
        zzej();
        zzsx.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzsx.endSection();
        this.zzbhl.zzabk++;
        this.zzboq = 0;
        zzkj();
    }

    private final boolean zzn(boolean z) {
        if (zzsy.SDK_INT < 23 || this.zzawy) {
            return false;
        }
        return !z || zztd.zzc(this.zzlj);
    }

    private final void zzkh() {
        this.zzboo = this.zzbog > 0 ? SystemClock.elapsedRealtime() + this.zzbog : C1470C.TIME_UNSET;
    }

    private final void zzki() {
        MediaCodec zzir;
        this.zzafb = false;
        if (zzsy.SDK_INT >= 23 && this.zzawy && (zzir = zzir()) != null) {
            this.zzboy = new zztk(this, zzir);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzkj() {
        if (!this.zzafb) {
            this.zzafb = true;
            this.zzbof.zzc(this.zzaez);
        }
    }

    private final void zzkk() {
        this.zzbou = -1;
        this.zzbov = -1;
        this.zzbox = -1.0f;
        this.zzbow = -1;
    }

    private final void zzej() {
        if (this.zzbou != this.zzaff || this.zzbov != this.zzafg || this.zzbow != this.zzbot || this.zzbox != this.zzafh) {
            this.zzbof.zzb(this.zzaff, this.zzafg, this.zzbot, this.zzafh);
            this.zzbou = this.zzaff;
            this.zzbov = this.zzafg;
            this.zzbow = this.zzbot;
            this.zzbox = this.zzafh;
        }
    }

    private final void zzkl() {
        if (this.zzbou != -1 || this.zzbov != -1) {
            this.zzbof.zzb(this.zzaff, this.zzafg, this.zzbot, this.zzafh);
        }
    }

    private final void zzkm() {
        if (this.zzbop > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbof.zzg(this.zzbop, elapsedRealtime - this.zzafd);
            this.zzbop = 0;
            this.zzafd = elapsedRealtime;
        }
    }

    private static int zzi(zzlh zzlh) {
        if (zzlh.zzafs != -1) {
            return zzlh.zzafs;
        }
        return zza(zzlh.zzatq, zzlh.width, zzlh.height);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(java.lang.String r5, int r6, int r7) {
        /*
            r0 = -1
            if (r6 == r0) goto L_0x007e
            if (r7 != r0) goto L_0x0007
            goto L_0x007e
        L_0x0007:
            int r1 = r5.hashCode()
            r2 = 3
            r3 = 4
            r4 = 2
            switch(r1) {
                case -1664118616: goto L_0x0044;
                case -1662541442: goto L_0x003a;
                case 1187890754: goto L_0x0030;
                case 1331836730: goto L_0x0026;
                case 1599127256: goto L_0x001c;
                case 1599127257: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x004e
        L_0x0012:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x004e
            r5 = 5
            goto L_0x004f
        L_0x001c:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x004e
            r5 = 3
            goto L_0x004f
        L_0x0026:
            java.lang.String r1 = "video/avc"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x004e
            r5 = 2
            goto L_0x004f
        L_0x0030:
            java.lang.String r1 = "video/mp4v-es"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x004e
            r5 = 1
            goto L_0x004f
        L_0x003a:
            java.lang.String r1 = "video/hevc"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x004e
            r5 = 4
            goto L_0x004f
        L_0x0044:
            java.lang.String r1 = "video/3gpp"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x004e
            r5 = 0
            goto L_0x004f
        L_0x004e:
            r5 = -1
        L_0x004f:
            switch(r5) {
                case 0: goto L_0x0075;
                case 1: goto L_0x0075;
                case 2: goto L_0x0059;
                case 3: goto L_0x0056;
                case 4: goto L_0x0053;
                case 5: goto L_0x0053;
                default: goto L_0x0052;
            }
        L_0x0052:
            return r0
        L_0x0053:
            int r6 = r6 * r7
            goto L_0x0078
        L_0x0056:
            int r6 = r6 * r7
            goto L_0x0077
        L_0x0059:
            java.lang.String r5 = "BRAVIA 4K 2015"
            java.lang.String r1 = com.google.android.gms.internal.ads.zzsy.MODEL
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x0064
            return r0
        L_0x0064:
            r5 = 16
            int r6 = com.google.android.gms.internal.ads.zzsy.zzb(r6, r5)
            int r5 = com.google.android.gms.internal.ads.zzsy.zzb(r7, r5)
            int r6 = r6 * r5
            int r5 = r6 << 4
            int r6 = r5 << 4
            goto L_0x0077
        L_0x0075:
            int r6 = r6 * r7
        L_0x0077:
            r3 = 2
        L_0x0078:
            int r6 = r6 * 3
            int r3 = r3 * 2
            int r6 = r6 / r3
            return r6
        L_0x007e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzth.zza(java.lang.String, int, int):int");
    }

    private static boolean zza(boolean z, zzlh zzlh, zzlh zzlh2) {
        if (!zzlh.zzatq.equals(zzlh2.zzatq) || zzj(zzlh) != zzj(zzlh2)) {
            return false;
        }
        if (!z) {
            return zzlh.width == zzlh2.width && zzlh.height == zzlh2.height;
        }
        return true;
    }

    private static int zzj(zzlh zzlh) {
        if (zzlh.zzatt == -1) {
            return 0;
        }
        return zzlh.zzatt;
    }
}
