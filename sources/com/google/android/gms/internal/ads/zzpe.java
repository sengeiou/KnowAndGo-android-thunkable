package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.C1470C;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class zzpe extends zzks {
    private static final byte[] zzbgp = zzsy.zzbi("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private final boolean zzadh;
    private final List<Long> zzadl;
    private final MediaCodec.BufferInfo zzadm;
    private MediaCodec zzadq;
    private ByteBuffer[] zzads;
    private ByteBuffer[] zzadt;
    private int zzadv;
    private int zzadw;
    private boolean zzady;
    private int zzadz;
    private int zzaea;
    private boolean zzaee;
    private boolean zzaef;
    private boolean zzaeg;
    private boolean zzaeh;
    private zzlh zzaue;
    private final zzpg zzbgq;
    private final zznj<Object> zzbgr;
    private final zznd zzbgs;
    private final zznd zzbgt;
    private final zzlj zzbgu;
    private zznh<Object> zzbgv;
    private zznh<Object> zzbgw;
    private zzpd zzbgx;
    private boolean zzbgy;
    private boolean zzbgz;
    private boolean zzbha;
    private boolean zzbhb;
    private boolean zzbhc;
    private boolean zzbhd;
    private boolean zzbhe;
    private boolean zzbhf;
    private boolean zzbhg;
    private long zzbhh;
    private boolean zzbhi;
    private boolean zzbhj;
    private boolean zzbhk;
    protected zznc zzbhl;

    public zzpe(int i, zzpg zzpg, zznj<Object> zznj, boolean z) {
        super(i);
        zzsk.checkState(zzsy.SDK_INT >= 16);
        this.zzbgq = (zzpg) zzsk.checkNotNull(zzpg);
        this.zzbgr = zznj;
        this.zzadh = z;
        this.zzbgs = new zznd(0);
        this.zzbgt = new zznd(0);
        this.zzbgu = new zzlj();
        this.zzadl = new ArrayList();
        this.zzadm = new MediaCodec.BufferInfo();
        this.zzadz = 0;
        this.zzaea = 0;
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzku {
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
    }

    /* access modifiers changed from: protected */
    public abstract int zza(zzpg zzpg, zzlh zzlh) throws zzpk;

    /* access modifiers changed from: protected */
    public void zza(zznd zznd) {
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzpd zzpd, MediaCodec mediaCodec, zzlh zzlh, MediaCrypto mediaCrypto) throws zzpk;

    /* access modifiers changed from: protected */
    public abstract boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzku;

    /* access modifiers changed from: protected */
    public boolean zza(MediaCodec mediaCodec, boolean z, zzlh zzlh, zzlh zzlh2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzpd zzpd) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void zzd(String str, long j, long j2) {
    }

    public final int zzgp() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public void zzhw() throws zzku {
    }

    public final int zza(zzlh zzlh) throws zzku {
        try {
            return zza(this.zzbgq, zzlh);
        } catch (zzpk e) {
            throw zzku.zza(e, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    public zzpd zza(zzpg zzpg, zzlh zzlh, boolean z) throws zzpk {
        return zzpg.zze(zzlh.zzatq, z);
    }

    /* access modifiers changed from: protected */
    public final void zzea() throws zzku {
        if (this.zzadq == null && this.zzaue != null) {
            this.zzbgv = this.zzbgw;
            String str = this.zzaue.zzatq;
            if (this.zzbgv != null) {
                int state = this.zzbgv.getState();
                if (state == 0) {
                    throw zzku.zza(this.zzbgv.zzif(), getIndex());
                } else if (state == 3 || state == 4) {
                    this.zzbgv.zzie();
                    throw new NoSuchMethodError();
                }
            } else {
                if (this.zzbgx == null) {
                    try {
                        this.zzbgx = zza(this.zzbgq, this.zzaue, false);
                    } catch (zzpk e) {
                        zza(new zzpf(this.zzaue, (Throwable) e, false, -49998));
                    }
                    if (this.zzbgx == null) {
                        zza(new zzpf(this.zzaue, (Throwable) null, false, -49999));
                    }
                }
                if (zza(this.zzbgx)) {
                    String str2 = this.zzbgx.name;
                    this.zzbgy = zzsy.SDK_INT < 21 && this.zzaue.zzafw.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
                    this.zzbgz = zzsy.SDK_INT < 18 || (zzsy.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (zzsy.SDK_INT == 19 && zzsy.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
                    this.zzbha = zzsy.SDK_INT < 24 && ("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(zzsy.DEVICE) || "flounder_lte".equals(zzsy.DEVICE) || "grouper".equals(zzsy.DEVICE) || "tilapia".equals(zzsy.DEVICE));
                    this.zzbhb = zzsy.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
                    this.zzbhc = (zzsy.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str2)) || (zzsy.SDK_INT <= 19 && "hb2000".equals(zzsy.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
                    this.zzbhd = zzsy.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str2);
                    this.zzbhe = zzsy.SDK_INT <= 18 && this.zzaue.zzafu == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2);
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        String valueOf = String.valueOf(str2);
                        zzsx.beginSection(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
                        this.zzadq = MediaCodec.createByCodecName(str2);
                        zzsx.endSection();
                        zzsx.beginSection("configureCodec");
                        zza(this.zzbgx, this.zzadq, this.zzaue, (MediaCrypto) null);
                        zzsx.endSection();
                        zzsx.beginSection("startCodec");
                        this.zzadq.start();
                        zzsx.endSection();
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        zzd(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                        this.zzads = this.zzadq.getInputBuffers();
                        this.zzadt = this.zzadq.getOutputBuffers();
                    } catch (Exception e2) {
                        zza(new zzpf(this.zzaue, (Throwable) e2, false, str2));
                    }
                    this.zzbhh = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : C1470C.TIME_UNSET;
                    this.zzadv = -1;
                    this.zzadw = -1;
                    this.zzaeh = true;
                    this.zzbhl.zzaza++;
                }
            }
        }
    }

    private final void zza(zzpf zzpf) throws zzku {
        throw zzku.zza(zzpf, getIndex());
    }

    /* access modifiers changed from: protected */
    public final MediaCodec zzir() {
        return this.zzadq;
    }

    /* access modifiers changed from: protected */
    public final zzpd zzis() {
        return this.zzbgx;
    }

    /* access modifiers changed from: protected */
    public void zzg(boolean z) throws zzku {
        this.zzbhl = new zznc();
    }

    /* access modifiers changed from: protected */
    public void zzd(long j, boolean z) throws zzku {
        this.zzaee = false;
        this.zzaef = false;
        if (this.zzadq != null) {
            this.zzbhh = C1470C.TIME_UNSET;
            this.zzadv = -1;
            this.zzadw = -1;
            this.zzaeh = true;
            this.zzaeg = false;
            this.zzbhi = false;
            this.zzadl.clear();
            this.zzbhf = false;
            this.zzbhg = false;
            if (this.zzbgz || (this.zzbhc && this.zzbhk)) {
                zzed();
                zzea();
            } else if (this.zzaea != 0) {
                zzed();
                zzea();
            } else {
                this.zzadq.flush();
                this.zzbhj = false;
            }
            if (this.zzady && this.zzaue != null) {
                this.zzadz = 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzdz() {
        this.zzaue = null;
        try {
            zzed();
            try {
                if (this.zzbgv != null) {
                    this.zzbgr.zza(this.zzbgv);
                }
                try {
                    if (!(this.zzbgw == null || this.zzbgw == this.zzbgv)) {
                        this.zzbgr.zza(this.zzbgw);
                    }
                } finally {
                    this.zzbgv = null;
                    this.zzbgw = null;
                }
            } catch (Throwable th) {
                if (!(this.zzbgw == null || this.zzbgw == this.zzbgv)) {
                    this.zzbgr.zza(this.zzbgw);
                }
                throw th;
            } finally {
                this.zzbgv = null;
                this.zzbgw = null;
            }
        } catch (Throwable th2) {
            try {
                if (!(this.zzbgw == null || this.zzbgw == this.zzbgv)) {
                    this.zzbgr.zza(this.zzbgw);
                }
                throw th2;
            } finally {
                this.zzbgv = null;
                this.zzbgw = null;
            }
        } finally {
        }
    }

    /* access modifiers changed from: protected */
    public void zzed() {
        this.zzbhh = C1470C.TIME_UNSET;
        this.zzadv = -1;
        this.zzadw = -1;
        this.zzaeg = false;
        this.zzbhi = false;
        this.zzadl.clear();
        this.zzads = null;
        this.zzadt = null;
        this.zzbgx = null;
        this.zzady = false;
        this.zzbhj = false;
        this.zzbgy = false;
        this.zzbgz = false;
        this.zzbha = false;
        this.zzbhb = false;
        this.zzbhc = false;
        this.zzbhe = false;
        this.zzbhf = false;
        this.zzbhg = false;
        this.zzbhk = false;
        this.zzadz = 0;
        this.zzaea = 0;
        this.zzbgs.zzde = null;
        if (this.zzadq != null) {
            this.zzbhl.zzazb++;
            try {
                this.zzadq.stop();
                try {
                    this.zzadq.release();
                    this.zzadq = null;
                    if (this.zzbgv != null && this.zzbgw != this.zzbgv) {
                        try {
                            this.zzbgr.zza(this.zzbgv);
                        } finally {
                            this.zzbgv = null;
                        }
                    }
                } catch (Throwable th) {
                    this.zzadq = null;
                    if (!(this.zzbgv == null || this.zzbgw == this.zzbgv)) {
                        this.zzbgr.zza(this.zzbgv);
                    }
                    throw th;
                } finally {
                    this.zzbgv = null;
                }
            } catch (Throwable th2) {
                this.zzadq = null;
                if (!(this.zzbgv == null || this.zzbgw == this.zzbgv)) {
                    try {
                        this.zzbgr.zza(this.zzbgv);
                    } finally {
                        this.zzbgv = null;
                    }
                }
                throw th2;
            } finally {
            }
        }
    }

    public final void zzc(long j, long j2) throws zzku {
        if (this.zzaef) {
            zzhw();
            return;
        }
        if (this.zzaue == null) {
            this.zzbgt.clear();
            int zza = zza(this.zzbgu, this.zzbgt, true);
            if (zza == -5) {
                zzd(this.zzbgu.zzaue);
            } else if (zza == -4) {
                zzsk.checkState(this.zzbgt.zzic());
                this.zzaee = true;
                zziu();
                return;
            } else {
                return;
            }
        }
        zzea();
        if (this.zzadq != null) {
            zzsx.beginSection("drainAndFeed");
            do {
            } while (zze(j, j2));
            do {
            } while (zzit());
            zzsx.endSection();
        } else {
            zzdy(j);
            this.zzbgt.clear();
            int zza2 = zza(this.zzbgu, this.zzbgt, false);
            if (zza2 == -5) {
                zzd(this.zzbgu.zzaue);
            } else if (zza2 == -4) {
                zzsk.checkState(this.zzbgt.zzic());
                this.zzaee = true;
                zziu();
            }
        }
        this.zzbhl.zzdk();
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0153 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzit() throws com.google.android.gms.internal.ads.zzku {
        /*
            r14 = this;
            android.media.MediaCodec r0 = r14.zzadq
            r1 = 0
            if (r0 == 0) goto L_0x01de
            int r0 = r14.zzaea
            r2 = 2
            if (r0 == r2) goto L_0x01de
            boolean r0 = r14.zzaee
            if (r0 == 0) goto L_0x0010
            goto L_0x01de
        L_0x0010:
            int r0 = r14.zzadv
            if (r0 >= 0) goto L_0x0032
            android.media.MediaCodec r0 = r14.zzadq
            r3 = 0
            int r0 = r0.dequeueInputBuffer(r3)
            r14.zzadv = r0
            int r0 = r14.zzadv
            if (r0 >= 0) goto L_0x0023
            return r1
        L_0x0023:
            com.google.android.gms.internal.ads.zznd r0 = r14.zzbgs
            java.nio.ByteBuffer[] r3 = r14.zzads
            int r4 = r14.zzadv
            r3 = r3[r4]
            r0.zzde = r3
            com.google.android.gms.internal.ads.zznd r0 = r14.zzbgs
            r0.clear()
        L_0x0032:
            int r0 = r14.zzaea
            r3 = -1
            r4 = 1
            if (r0 != r4) goto L_0x004f
            boolean r0 = r14.zzbhb
            if (r0 != 0) goto L_0x004c
            r14.zzbhk = r4
            android.media.MediaCodec r5 = r14.zzadq
            int r6 = r14.zzadv
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r14.zzadv = r3
        L_0x004c:
            r14.zzaea = r2
            return r1
        L_0x004f:
            boolean r0 = r14.zzbhf
            if (r0 == 0) goto L_0x0071
            r14.zzbhf = r1
            com.google.android.gms.internal.ads.zznd r0 = r14.zzbgs
            java.nio.ByteBuffer r0 = r0.zzde
            byte[] r1 = zzbgp
            r0.put(r1)
            android.media.MediaCodec r5 = r14.zzadq
            int r6 = r14.zzadv
            r7 = 0
            byte[] r0 = zzbgp
            int r8 = r0.length
            r9 = 0
            r11 = 0
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r14.zzadv = r3
            r14.zzbhj = r4
            return r4
        L_0x0071:
            boolean r0 = r14.zzaeg
            if (r0 == 0) goto L_0x0078
            r0 = -4
            r5 = 0
            goto L_0x00b0
        L_0x0078:
            int r0 = r14.zzadz
            if (r0 != r4) goto L_0x009d
            r0 = 0
        L_0x007d:
            com.google.android.gms.internal.ads.zzlh r5 = r14.zzaue
            java.util.List<byte[]> r5 = r5.zzafw
            int r5 = r5.size()
            if (r0 >= r5) goto L_0x009b
            com.google.android.gms.internal.ads.zzlh r5 = r14.zzaue
            java.util.List<byte[]> r5 = r5.zzafw
            java.lang.Object r5 = r5.get(r0)
            byte[] r5 = (byte[]) r5
            com.google.android.gms.internal.ads.zznd r6 = r14.zzbgs
            java.nio.ByteBuffer r6 = r6.zzde
            r6.put(r5)
            int r0 = r0 + 1
            goto L_0x007d
        L_0x009b:
            r14.zzadz = r2
        L_0x009d:
            com.google.android.gms.internal.ads.zznd r0 = r14.zzbgs
            java.nio.ByteBuffer r0 = r0.zzde
            int r0 = r0.position()
            com.google.android.gms.internal.ads.zzlj r5 = r14.zzbgu
            com.google.android.gms.internal.ads.zznd r6 = r14.zzbgs
            int r5 = r14.zza((com.google.android.gms.internal.ads.zzlj) r5, (com.google.android.gms.internal.ads.zznd) r6, (boolean) r1)
            r13 = r5
            r5 = r0
            r0 = r13
        L_0x00b0:
            r6 = -3
            if (r0 != r6) goto L_0x00b4
            return r1
        L_0x00b4:
            r6 = -5
            if (r0 != r6) goto L_0x00ca
            int r0 = r14.zzadz
            if (r0 != r2) goto L_0x00c2
            com.google.android.gms.internal.ads.zznd r0 = r14.zzbgs
            r0.clear()
            r14.zzadz = r4
        L_0x00c2:
            com.google.android.gms.internal.ads.zzlj r0 = r14.zzbgu
            com.google.android.gms.internal.ads.zzlh r0 = r0.zzaue
            r14.zzd(r0)
            return r4
        L_0x00ca:
            com.google.android.gms.internal.ads.zznd r0 = r14.zzbgs
            boolean r0 = r0.zzic()
            if (r0 == 0) goto L_0x0106
            int r0 = r14.zzadz
            if (r0 != r2) goto L_0x00dd
            com.google.android.gms.internal.ads.zznd r0 = r14.zzbgs
            r0.clear()
            r14.zzadz = r4
        L_0x00dd:
            r14.zzaee = r4
            boolean r0 = r14.zzbhj
            if (r0 != 0) goto L_0x00e7
            r14.zziu()
            return r1
        L_0x00e7:
            boolean r0 = r14.zzbhb     // Catch:{ CryptoException -> 0x00fc }
            if (r0 != 0) goto L_0x00fb
            r14.zzbhk = r4     // Catch:{ CryptoException -> 0x00fc }
            android.media.MediaCodec r5 = r14.zzadq     // Catch:{ CryptoException -> 0x00fc }
            int r6 = r14.zzadv     // Catch:{ CryptoException -> 0x00fc }
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)     // Catch:{ CryptoException -> 0x00fc }
            r14.zzadv = r3     // Catch:{ CryptoException -> 0x00fc }
        L_0x00fb:
            return r1
        L_0x00fc:
            r0 = move-exception
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzku r0 = com.google.android.gms.internal.ads.zzku.zza(r0, r1)
            throw r0
        L_0x0106:
            boolean r0 = r14.zzaeh
            if (r0 == 0) goto L_0x011e
            com.google.android.gms.internal.ads.zznd r0 = r14.zzbgs
            boolean r0 = r0.zzid()
            if (r0 != 0) goto L_0x011e
            com.google.android.gms.internal.ads.zznd r0 = r14.zzbgs
            r0.clear()
            int r0 = r14.zzadz
            if (r0 != r2) goto L_0x011d
            r14.zzadz = r4
        L_0x011d:
            return r4
        L_0x011e:
            r14.zzaeh = r1
            com.google.android.gms.internal.ads.zznd r0 = r14.zzbgs
            boolean r0 = r0.zzeo()
            com.google.android.gms.internal.ads.zznh<java.lang.Object> r2 = r14.zzbgv
            if (r2 == 0) goto L_0x014c
            com.google.android.gms.internal.ads.zznh<java.lang.Object> r2 = r14.zzbgv
            int r2 = r2.getState()
            if (r2 == 0) goto L_0x013d
            r6 = 4
            if (r2 == r6) goto L_0x014c
            if (r0 != 0) goto L_0x013b
            boolean r2 = r14.zzadh
            if (r2 != 0) goto L_0x014c
        L_0x013b:
            r2 = 1
            goto L_0x014d
        L_0x013d:
            com.google.android.gms.internal.ads.zznh<java.lang.Object> r0 = r14.zzbgv
            com.google.android.gms.internal.ads.zzni r0 = r0.zzif()
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzku r0 = com.google.android.gms.internal.ads.zzku.zza(r0, r1)
            throw r0
        L_0x014c:
            r2 = 0
        L_0x014d:
            r14.zzaeg = r2
            boolean r2 = r14.zzaeg
            if (r2 == 0) goto L_0x0154
            return r1
        L_0x0154:
            boolean r2 = r14.zzbgy
            if (r2 == 0) goto L_0x016e
            if (r0 != 0) goto L_0x016e
            com.google.android.gms.internal.ads.zznd r2 = r14.zzbgs
            java.nio.ByteBuffer r2 = r2.zzde
            com.google.android.gms.internal.ads.zzsq.zzk(r2)
            com.google.android.gms.internal.ads.zznd r2 = r14.zzbgs
            java.nio.ByteBuffer r2 = r2.zzde
            int r2 = r2.position()
            if (r2 != 0) goto L_0x016c
            return r4
        L_0x016c:
            r14.zzbgy = r1
        L_0x016e:
            com.google.android.gms.internal.ads.zznd r2 = r14.zzbgs     // Catch:{ CryptoException -> 0x01d4 }
            long r10 = r2.zzaga     // Catch:{ CryptoException -> 0x01d4 }
            com.google.android.gms.internal.ads.zznd r2 = r14.zzbgs     // Catch:{ CryptoException -> 0x01d4 }
            boolean r2 = r2.zzib()     // Catch:{ CryptoException -> 0x01d4 }
            if (r2 == 0) goto L_0x0183
            java.util.List<java.lang.Long> r2 = r14.zzadl     // Catch:{ CryptoException -> 0x01d4 }
            java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ CryptoException -> 0x01d4 }
            r2.add(r6)     // Catch:{ CryptoException -> 0x01d4 }
        L_0x0183:
            com.google.android.gms.internal.ads.zznd r2 = r14.zzbgs     // Catch:{ CryptoException -> 0x01d4 }
            java.nio.ByteBuffer r2 = r2.zzde     // Catch:{ CryptoException -> 0x01d4 }
            r2.flip()     // Catch:{ CryptoException -> 0x01d4 }
            com.google.android.gms.internal.ads.zznd r2 = r14.zzbgs     // Catch:{ CryptoException -> 0x01d4 }
            r14.zza((com.google.android.gms.internal.ads.zznd) r2)     // Catch:{ CryptoException -> 0x01d4 }
            if (r0 == 0) goto L_0x01b5
            com.google.android.gms.internal.ads.zznd r0 = r14.zzbgs     // Catch:{ CryptoException -> 0x01d4 }
            com.google.android.gms.internal.ads.zzmz r0 = r0.zzaze     // Catch:{ CryptoException -> 0x01d4 }
            android.media.MediaCodec$CryptoInfo r9 = r0.zzdl()     // Catch:{ CryptoException -> 0x01d4 }
            if (r5 != 0) goto L_0x019c
            goto L_0x01ab
        L_0x019c:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01d4 }
            if (r0 != 0) goto L_0x01a4
            int[] r0 = new int[r4]     // Catch:{ CryptoException -> 0x01d4 }
            r9.numBytesOfClearData = r0     // Catch:{ CryptoException -> 0x01d4 }
        L_0x01a4:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01d4 }
            r2 = r0[r1]     // Catch:{ CryptoException -> 0x01d4 }
            int r2 = r2 + r5
            r0[r1] = r2     // Catch:{ CryptoException -> 0x01d4 }
        L_0x01ab:
            android.media.MediaCodec r6 = r14.zzadq     // Catch:{ CryptoException -> 0x01d4 }
            int r7 = r14.zzadv     // Catch:{ CryptoException -> 0x01d4 }
            r8 = 0
            r12 = 0
            r6.queueSecureInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01d4 }
            goto L_0x01c6
        L_0x01b5:
            android.media.MediaCodec r6 = r14.zzadq     // Catch:{ CryptoException -> 0x01d4 }
            int r7 = r14.zzadv     // Catch:{ CryptoException -> 0x01d4 }
            r8 = 0
            com.google.android.gms.internal.ads.zznd r0 = r14.zzbgs     // Catch:{ CryptoException -> 0x01d4 }
            java.nio.ByteBuffer r0 = r0.zzde     // Catch:{ CryptoException -> 0x01d4 }
            int r9 = r0.limit()     // Catch:{ CryptoException -> 0x01d4 }
            r12 = 0
            r6.queueInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01d4 }
        L_0x01c6:
            r14.zzadv = r3     // Catch:{ CryptoException -> 0x01d4 }
            r14.zzbhj = r4     // Catch:{ CryptoException -> 0x01d4 }
            r14.zzadz = r1     // Catch:{ CryptoException -> 0x01d4 }
            com.google.android.gms.internal.ads.zznc r0 = r14.zzbhl     // Catch:{ CryptoException -> 0x01d4 }
            int r1 = r0.zzazc     // Catch:{ CryptoException -> 0x01d4 }
            int r1 = r1 + r4
            r0.zzazc = r1     // Catch:{ CryptoException -> 0x01d4 }
            return r4
        L_0x01d4:
            r0 = move-exception
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzku r0 = com.google.android.gms.internal.ads.zzku.zza(r0, r1)
            throw r0
        L_0x01de:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpe.zzit():boolean");
    }

    /* access modifiers changed from: protected */
    public void zzd(zzlh zzlh) throws zzku {
        zzne zzne;
        zzlh zzlh2 = this.zzaue;
        this.zzaue = zzlh;
        zzne zzne2 = this.zzaue.zzatr;
        if (zzlh2 == null) {
            zzne = null;
        } else {
            zzne = zzlh2.zzatr;
        }
        boolean zza = zzsy.zza(zzne2, zzne);
        boolean z = true;
        if (!zza) {
            if (this.zzaue.zzatr == null) {
                this.zzbgw = null;
            } else if (this.zzbgr != null) {
                this.zzbgw = this.zzbgr.zza(Looper.myLooper(), this.zzaue.zzatr);
                if (this.zzbgw == this.zzbgv) {
                    this.zzbgr.zza(this.zzbgw);
                }
            } else {
                throw zzku.zza(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
            }
        }
        if (this.zzbgw == this.zzbgv && this.zzadq != null && zza(this.zzadq, this.zzbgx.zzabo, zzlh2, this.zzaue)) {
            this.zzady = true;
            this.zzadz = 1;
            if (!(this.zzbha && this.zzaue.width == zzlh2.width && this.zzaue.height == zzlh2.height)) {
                z = false;
            }
            this.zzbhf = z;
        } else if (this.zzbhj) {
            this.zzaea = 1;
        } else {
            zzed();
            zzea();
        }
    }

    public boolean zzdx() {
        return this.zzaef;
    }

    public boolean isReady() {
        if (this.zzaue == null || this.zzaeg) {
            return false;
        }
        if (zzgr() || this.zzadw >= 0) {
            return true;
        }
        return this.zzbhh != C1470C.TIME_UNSET && SystemClock.elapsedRealtime() < this.zzbhh;
    }

    private final boolean zze(long j, long j2) throws zzku {
        boolean z;
        boolean z2;
        if (this.zzadw < 0) {
            if (!this.zzbhd || !this.zzbhk) {
                this.zzadw = this.zzadq.dequeueOutputBuffer(this.zzadm, 0);
            } else {
                try {
                    this.zzadw = this.zzadq.dequeueOutputBuffer(this.zzadm, 0);
                } catch (IllegalStateException unused) {
                    zziu();
                    if (this.zzaef) {
                        zzed();
                    }
                    return false;
                }
            }
            if (this.zzadw >= 0) {
                if (this.zzbhg) {
                    this.zzbhg = false;
                    this.zzadq.releaseOutputBuffer(this.zzadw, false);
                    this.zzadw = -1;
                    return true;
                } else if ((this.zzadm.flags & 4) != 0) {
                    zziu();
                    this.zzadw = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.zzadt[this.zzadw];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.zzadm.offset);
                        byteBuffer.limit(this.zzadm.offset + this.zzadm.size);
                    }
                    long j3 = this.zzadm.presentationTimeUs;
                    int size = this.zzadl.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            z2 = false;
                            break;
                        } else if (this.zzadl.get(i).longValue() == j3) {
                            this.zzadl.remove(i);
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                    this.zzbhi = z2;
                }
            } else if (this.zzadw == -2) {
                MediaFormat outputFormat = this.zzadq.getOutputFormat();
                if (this.zzbha && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.zzbhg = true;
                } else {
                    if (this.zzbhe) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.zzadq, outputFormat);
                }
                return true;
            } else if (this.zzadw == -3) {
                this.zzadt = this.zzadq.getOutputBuffers();
                return true;
            } else {
                if (this.zzbhb && (this.zzaee || this.zzaea == 2)) {
                    zziu();
                }
                return false;
            }
        }
        if (!this.zzbhd || !this.zzbhk) {
            z = zza(j, j2, this.zzadq, this.zzadt[this.zzadw], this.zzadw, this.zzadm.flags, this.zzadm.presentationTimeUs, this.zzbhi);
        } else {
            try {
                z = zza(j, j2, this.zzadq, this.zzadt[this.zzadw], this.zzadw, this.zzadm.flags, this.zzadm.presentationTimeUs, this.zzbhi);
            } catch (IllegalStateException unused2) {
                zziu();
                if (this.zzaef) {
                    zzed();
                }
                return false;
            }
        }
        if (!z) {
            return false;
        }
        long j4 = this.zzadm.presentationTimeUs;
        this.zzadw = -1;
        return true;
    }

    private final void zziu() throws zzku {
        if (this.zzaea == 2) {
            zzed();
            zzea();
            return;
        }
        this.zzaef = true;
        zzhw();
    }
}
