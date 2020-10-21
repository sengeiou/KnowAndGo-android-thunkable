package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class zzgr extends zzhp {
    protected final Handler zzabq;
    private long zzadb;
    public final zzga zzadf;
    private final zzhz zzadg;
    private final boolean zzadh;
    private final zzhn zzadi;
    private final zzhm zzadj;
    private final zzhk zzadk;
    private final List<Long> zzadl;
    private final MediaCodec.BufferInfo zzadm;
    /* access modifiers changed from: private */
    public final zzgw zzadn;
    private zzhj zzado;
    private zzhw zzadp;
    private MediaCodec zzadq;
    private boolean zzadr;
    private ByteBuffer[] zzads;
    private ByteBuffer[] zzadt;
    private long zzadu;
    private int zzadv;
    private int zzadw;
    private boolean zzadx;
    private boolean zzady;
    private int zzadz;
    private int zzaea;
    private boolean zzaeb;
    private int zzaec;
    private int zzaed;
    private boolean zzaee;
    private boolean zzaef;
    private boolean zzaeg;
    private boolean zzaeh;

    public zzgr(zzhn zzhn, zzhz zzhz, boolean z, Handler handler, zzgw zzgw) {
        zzkh.checkState(zzkq.SDK_INT >= 16);
        this.zzadi = zzhn;
        this.zzadg = null;
        this.zzadh = true;
        this.zzabq = handler;
        this.zzadn = zzgw;
        this.zzadf = new zzga();
        this.zzadj = new zzhm(0);
        this.zzadk = new zzhk();
        this.zzadl = new ArrayList();
        this.zzadm = new MediaCodec.BufferInfo();
        this.zzadz = 0;
        this.zzaea = 0;
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
    }

    /* access modifiers changed from: protected */
    public void zza(zzhj zzhj, MediaFormat mediaFormat) {
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i, boolean z) throws zzgd;

    /* access modifiers changed from: protected */
    public boolean zza(MediaCodec mediaCodec, boolean z, zzhj zzhj, zzhj zzhj2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean zzas(String str) {
        return true;
    }

    /* access modifiers changed from: protected */
    public final int zzdl(long j) throws zzgd {
        try {
            if (!this.zzadi.zzdg(j)) {
                return 0;
            }
            for (int i = 0; i < this.zzadi.getTrackCount(); i++) {
                if (zzas(this.zzadi.zzo(i).mimeType)) {
                    this.zzaec = i;
                    return 1;
                }
            }
            return -1;
        } catch (IOException e) {
            throw new zzgd((Throwable) e);
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(long j, boolean z) {
        this.zzadi.zza(this.zzaec, j);
        this.zzaed = 0;
        this.zzaee = false;
        this.zzaef = false;
        this.zzaeg = false;
        this.zzadb = j;
    }

    /* access modifiers changed from: protected */
    public zzgc zzc(String str, boolean z) throws zzgz {
        return zzgx.zzc(str, z);
    }

    /* access modifiers changed from: protected */
    public void zza(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, MediaCrypto mediaCrypto) {
        mediaCodec.configure(mediaFormat, (Surface) null, mediaCrypto, 0);
    }

    /* access modifiers changed from: protected */
    public final void zzea() throws zzgd {
        MediaCrypto mediaCrypto;
        zzgc zzgc;
        if (zzeb()) {
            String str = this.zzado.mimeType;
            boolean z = false;
            if (this.zzadp == null) {
                mediaCrypto = null;
            } else if (this.zzadg != null) {
                if (!this.zzadx) {
                    this.zzadg.zza(this.zzadp);
                    this.zzadx = true;
                }
                int state = this.zzadg.getState();
                if (state == 0) {
                    throw new zzgd((Throwable) this.zzadg.zzfb());
                } else if (state == 3 || state == 4) {
                    mediaCrypto = this.zzadg.zzfa();
                    z = this.zzadg.requiresSecureDecoderComponent(str);
                } else {
                    return;
                }
            } else {
                throw new zzgd("Media requires a DrmSessionManager");
            }
            try {
                zzgc = zzc(str, z);
            } catch (zzgz e) {
                zza(new zzgv(this.zzado, (Throwable) e, -49998));
                zzgc = null;
            }
            if (zzgc == null) {
                zza(new zzgv(this.zzado, (Throwable) null, -49999));
            }
            String str2 = zzgc.name;
            this.zzadr = zzgc.zzabo;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.zzadq = MediaCodec.createByCodecName(str2);
                zza(this.zzadq, str2, this.zzado.zzen(), mediaCrypto);
                this.zzadq.start();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                long j = elapsedRealtime2 - elapsedRealtime;
                if (!(this.zzabq == null || this.zzadn == null)) {
                    this.zzabq.post(new zzgu(this, str2, elapsedRealtime2, j));
                }
                this.zzads = this.zzadq.getInputBuffers();
                this.zzadt = this.zzadq.getOutputBuffers();
            } catch (Exception e2) {
                zza(new zzgv(this.zzado, (Throwable) e2, str2));
            }
            this.zzadu = getState() == 3 ? SystemClock.elapsedRealtime() : -1;
            this.zzadv = -1;
            this.zzadw = -1;
            this.zzaeh = true;
            this.zzadf.zzabg++;
        }
    }

    private final void zza(zzgv zzgv) throws zzgd {
        if (!(this.zzabq == null || this.zzadn == null)) {
            this.zzabq.post(new zzgs(this, zzgv));
        }
        throw new zzgd((Throwable) zzgv);
    }

    /* access modifiers changed from: protected */
    public boolean zzeb() {
        return this.zzadq == null && this.zzado != null;
    }

    /* access modifiers changed from: protected */
    public final boolean zzec() {
        return this.zzadq != null;
    }

    /* access modifiers changed from: protected */
    public void zzdz() {
        this.zzado = null;
        this.zzadp = null;
        try {
            zzed();
            try {
                if (this.zzadx) {
                    this.zzadg.close();
                    this.zzadx = false;
                }
            } finally {
                this.zzadi.zzp(this.zzaec);
            }
        } catch (Throwable th) {
            if (this.zzadx) {
                this.zzadg.close();
                this.zzadx = false;
            }
            throw th;
        } finally {
            this.zzadi.zzp(this.zzaec);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzed() {
        if (this.zzadq != null) {
            this.zzadu = -1;
            this.zzadv = -1;
            this.zzadw = -1;
            this.zzaeg = false;
            this.zzadl.clear();
            this.zzads = null;
            this.zzadt = null;
            this.zzady = false;
            this.zzaeb = false;
            this.zzadr = false;
            this.zzadz = 0;
            this.zzaea = 0;
            this.zzadf.zzabh++;
            try {
                this.zzadq.stop();
                try {
                    this.zzadq.release();
                } finally {
                    this.zzadq = null;
                }
            } catch (Throwable th) {
                this.zzadq.release();
                throw th;
            } finally {
                this.zzadq = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzee() {
        this.zzadi.release();
    }

    /* access modifiers changed from: protected */
    public long zzdy() {
        return this.zzadb;
    }

    /* access modifiers changed from: protected */
    public final long getDurationUs() {
        return this.zzadi.zzo(this.zzaec).zzack;
    }

    /* access modifiers changed from: protected */
    public final long zzdu() {
        long zzdu = this.zzadi.zzdu();
        return (zzdu == -1 || zzdu == -3) ? zzdu : Math.max(zzdu, zzdy());
    }

    /* access modifiers changed from: protected */
    public void seekTo(long j) throws zzgd {
        this.zzadb = j;
        this.zzadi.zzdi(j);
        this.zzaed = 0;
        this.zzaee = false;
        this.zzaef = false;
    }

    /* access modifiers changed from: protected */
    public final void zza(long j, long j2) throws zzgd {
        boolean z;
        int i;
        try {
            this.zzaed = this.zzadi.zzdh(j) ? this.zzaed == 0 ? 1 : this.zzaed : 0;
            if (this.zzadq != null && this.zzadi.zza(this.zzaec, this.zzadb, this.zzadk, this.zzadj, true) == -5) {
                zzef();
            }
            if (this.zzado == null && this.zzadi.zza(this.zzaec, this.zzadb, this.zzadk, this.zzadj, false) == -4) {
                zza(this.zzadk);
            }
            if (this.zzadq == null && zzeb()) {
                zzea();
            }
            if (this.zzadq != null) {
                do {
                    if (!this.zzaef) {
                        if (this.zzadw < 0) {
                            this.zzadw = this.zzadq.dequeueOutputBuffer(this.zzadm, 0);
                        }
                        if (this.zzadw == -2) {
                            zza(this.zzado, this.zzadq.getOutputFormat());
                            this.zzadf.zzabi++;
                        } else if (this.zzadw == -3) {
                            this.zzadt = this.zzadq.getOutputBuffers();
                            this.zzadf.zzabj++;
                        } else if (this.zzadw >= 0) {
                            if ((this.zzadm.flags & 4) == 0) {
                                long j3 = this.zzadm.presentationTimeUs;
                                int size = this.zzadl.size();
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= size) {
                                        i = -1;
                                        break;
                                    } else if (this.zzadl.get(i2).longValue() == j3) {
                                        i = i2;
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                                if (zza(j, j2, this.zzadq, this.zzadt[this.zzadw], this.zzadm, this.zzadw, i != -1)) {
                                    if (i != -1) {
                                        this.zzadl.remove(i);
                                    } else {
                                        this.zzadb = this.zzadm.presentationTimeUs;
                                    }
                                    this.zzadw = -1;
                                }
                            } else if (this.zzaea == 2) {
                                zzed();
                                zzea();
                            } else {
                                this.zzaef = true;
                            }
                        }
                        z = true;
                        continue;
                    }
                    z = false;
                    continue;
                } while (z);
                if (zze(true)) {
                    do {
                    } while (zze(false));
                }
            }
            this.zzadf.zzdk();
        } catch (IOException e) {
            throw new zzgd((Throwable) e);
        }
    }

    private final void zzef() throws zzgd {
        this.zzadu = -1;
        this.zzadv = -1;
        this.zzadw = -1;
        this.zzaeh = true;
        this.zzaeg = false;
        this.zzadl.clear();
        if (zzkq.SDK_INT < 18 || this.zzaea != 0) {
            zzed();
            zzea();
        } else {
            this.zzadq.flush();
            this.zzaeb = false;
        }
        if (this.zzady && this.zzado != null) {
            this.zzadz = 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x0124 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0125 A[SYNTHETIC, Splitter:B:79:0x0125] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zze(boolean r18) throws java.io.IOException, com.google.android.gms.internal.ads.zzgd {
        /*
            r17 = this;
            r1 = r17
            boolean r0 = r1.zzaee
            r2 = 0
            if (r0 != 0) goto L_0x0190
            int r0 = r1.zzaea
            r3 = 2
            if (r0 != r3) goto L_0x000e
            goto L_0x0190
        L_0x000e:
            int r0 = r1.zzadv
            if (r0 >= 0) goto L_0x0032
            android.media.MediaCodec r0 = r1.zzadq
            r4 = 0
            int r0 = r0.dequeueInputBuffer(r4)
            r1.zzadv = r0
            int r0 = r1.zzadv
            if (r0 >= 0) goto L_0x0021
            return r2
        L_0x0021:
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzadj
            java.nio.ByteBuffer[] r4 = r1.zzads
            int r5 = r1.zzadv
            r4 = r4[r5]
            r0.zzde = r4
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzadj
            java.nio.ByteBuffer r0 = r0.zzde
            r0.clear()
        L_0x0032:
            int r0 = r1.zzaea
            r4 = -1
            r5 = 1
            if (r0 != r5) goto L_0x0049
            android.media.MediaCodec r6 = r1.zzadq
            int r7 = r1.zzadv
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 4
            r6.queueInputBuffer(r7, r8, r9, r10, r12)
            r1.zzadv = r4
            r1.zzaea = r3
            return r2
        L_0x0049:
            boolean r0 = r1.zzaeg
            r6 = -2
            if (r0 == 0) goto L_0x0050
            r0 = -3
            goto L_0x008e
        L_0x0050:
            int r0 = r1.zzadz
            if (r0 != r5) goto L_0x0075
            r0 = 0
        L_0x0055:
            com.google.android.gms.internal.ads.zzhj r7 = r1.zzado
            java.util.List<byte[]> r7 = r7.zzafw
            int r7 = r7.size()
            if (r0 >= r7) goto L_0x0073
            com.google.android.gms.internal.ads.zzhj r7 = r1.zzado
            java.util.List<byte[]> r7 = r7.zzafw
            java.lang.Object r7 = r7.get(r0)
            byte[] r7 = (byte[]) r7
            com.google.android.gms.internal.ads.zzhm r8 = r1.zzadj
            java.nio.ByteBuffer r8 = r8.zzde
            r8.put(r7)
            int r0 = r0 + 1
            goto L_0x0055
        L_0x0073:
            r1.zzadz = r3
        L_0x0075:
            com.google.android.gms.internal.ads.zzhn r7 = r1.zzadi
            int r8 = r1.zzaec
            long r9 = r1.zzadb
            com.google.android.gms.internal.ads.zzhk r11 = r1.zzadk
            com.google.android.gms.internal.ads.zzhm r12 = r1.zzadj
            r13 = 0
            int r0 = r7.zza(r8, r9, r11, r12, r13)
            if (r18 == 0) goto L_0x008e
            int r7 = r1.zzaed
            if (r7 != r5) goto L_0x008e
            if (r0 != r6) goto L_0x008e
            r1.zzaed = r3
        L_0x008e:
            if (r0 != r6) goto L_0x0091
            return r2
        L_0x0091:
            r6 = -5
            if (r0 != r6) goto L_0x0098
            r17.zzef()
            return r5
        L_0x0098:
            r6 = -4
            if (r0 != r6) goto L_0x00ae
            int r0 = r1.zzadz
            if (r0 != r3) goto L_0x00a8
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzadj
            java.nio.ByteBuffer r0 = r0.zzde
            r0.clear()
            r1.zzadz = r5
        L_0x00a8:
            com.google.android.gms.internal.ads.zzhk r0 = r1.zzadk
            r1.zza((com.google.android.gms.internal.ads.zzhk) r0)
            return r5
        L_0x00ae:
            if (r0 != r4) goto L_0x00d8
            int r0 = r1.zzadz
            if (r0 != r3) goto L_0x00bd
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzadj
            java.nio.ByteBuffer r0 = r0.zzde
            r0.clear()
            r1.zzadz = r5
        L_0x00bd:
            r1.zzaee = r5
            android.media.MediaCodec r6 = r1.zzadq     // Catch:{ CryptoException -> 0x00ce }
            int r7 = r1.zzadv     // Catch:{ CryptoException -> 0x00ce }
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 4
            r6.queueInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x00ce }
            r1.zzadv = r4     // Catch:{ CryptoException -> 0x00ce }
            return r2
        L_0x00ce:
            r0 = move-exception
            r1.zza((android.media.MediaCodec.CryptoException) r0)
            com.google.android.gms.internal.ads.zzgd r2 = new com.google.android.gms.internal.ads.zzgd
            r2.<init>((java.lang.Throwable) r0)
            throw r2
        L_0x00d8:
            boolean r0 = r1.zzaeh
            if (r0 == 0) goto L_0x00f4
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzadj
            boolean r0 = r0.zzep()
            if (r0 != 0) goto L_0x00f2
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzadj
            java.nio.ByteBuffer r0 = r0.zzde
            r0.clear()
            int r0 = r1.zzadz
            if (r0 != r3) goto L_0x00f1
            r1.zzadz = r5
        L_0x00f1:
            return r5
        L_0x00f2:
            r1.zzaeh = r2
        L_0x00f4:
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzadj
            boolean r0 = r0.zzeo()
            boolean r3 = r1.zzadx
            if (r3 == 0) goto L_0x011d
            com.google.android.gms.internal.ads.zzhz r3 = r1.zzadg
            int r3 = r3.getState()
            if (r3 == 0) goto L_0x0111
            r6 = 4
            if (r3 == r6) goto L_0x011d
            if (r0 != 0) goto L_0x010f
            boolean r3 = r1.zzadh
            if (r3 != 0) goto L_0x011d
        L_0x010f:
            r3 = 1
            goto L_0x011e
        L_0x0111:
            com.google.android.gms.internal.ads.zzgd r0 = new com.google.android.gms.internal.ads.zzgd
            com.google.android.gms.internal.ads.zzhz r2 = r1.zzadg
            java.lang.Exception r2 = r2.zzfb()
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x011d:
            r3 = 0
        L_0x011e:
            r1.zzaeg = r3
            boolean r3 = r1.zzaeg
            if (r3 == 0) goto L_0x0125
            return r2
        L_0x0125:
            com.google.android.gms.internal.ads.zzhm r3 = r1.zzadj     // Catch:{ CryptoException -> 0x0186 }
            java.nio.ByteBuffer r3 = r3.zzde     // Catch:{ CryptoException -> 0x0186 }
            int r9 = r3.position()     // Catch:{ CryptoException -> 0x0186 }
            com.google.android.gms.internal.ads.zzhm r3 = r1.zzadj     // Catch:{ CryptoException -> 0x0186 }
            int r3 = r3.size     // Catch:{ CryptoException -> 0x0186 }
            int r3 = r9 - r3
            com.google.android.gms.internal.ads.zzhm r6 = r1.zzadj     // Catch:{ CryptoException -> 0x0186 }
            long r14 = r6.zzaga     // Catch:{ CryptoException -> 0x0186 }
            com.google.android.gms.internal.ads.zzhm r6 = r1.zzadj     // Catch:{ CryptoException -> 0x0186 }
            int r6 = r6.flags     // Catch:{ CryptoException -> 0x0186 }
            r7 = 134217728(0x8000000, float:3.85186E-34)
            r6 = r6 & r7
            if (r6 == 0) goto L_0x0142
            r6 = 1
            goto L_0x0143
        L_0x0142:
            r6 = 0
        L_0x0143:
            if (r6 == 0) goto L_0x014e
            java.util.List<java.lang.Long> r6 = r1.zzadl     // Catch:{ CryptoException -> 0x0186 }
            java.lang.Long r7 = java.lang.Long.valueOf(r14)     // Catch:{ CryptoException -> 0x0186 }
            r6.add(r7)     // Catch:{ CryptoException -> 0x0186 }
        L_0x014e:
            if (r0 == 0) goto L_0x0175
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzadj     // Catch:{ CryptoException -> 0x0186 }
            com.google.android.gms.internal.ads.zzgb r0 = r0.zzafz     // Catch:{ CryptoException -> 0x0186 }
            android.media.MediaCodec$CryptoInfo r13 = r0.zzdl()     // Catch:{ CryptoException -> 0x0186 }
            if (r3 != 0) goto L_0x015b
            goto L_0x016a
        L_0x015b:
            int[] r0 = r13.numBytesOfClearData     // Catch:{ CryptoException -> 0x0186 }
            if (r0 != 0) goto L_0x0163
            int[] r0 = new int[r5]     // Catch:{ CryptoException -> 0x0186 }
            r13.numBytesOfClearData = r0     // Catch:{ CryptoException -> 0x0186 }
        L_0x0163:
            int[] r0 = r13.numBytesOfClearData     // Catch:{ CryptoException -> 0x0186 }
            r6 = r0[r2]     // Catch:{ CryptoException -> 0x0186 }
            int r6 = r6 + r3
            r0[r2] = r6     // Catch:{ CryptoException -> 0x0186 }
        L_0x016a:
            android.media.MediaCodec r10 = r1.zzadq     // Catch:{ CryptoException -> 0x0186 }
            int r11 = r1.zzadv     // Catch:{ CryptoException -> 0x0186 }
            r12 = 0
            r16 = 0
            r10.queueSecureInputBuffer(r11, r12, r13, r14, r16)     // Catch:{ CryptoException -> 0x0186 }
            goto L_0x017f
        L_0x0175:
            android.media.MediaCodec r6 = r1.zzadq     // Catch:{ CryptoException -> 0x0186 }
            int r7 = r1.zzadv     // Catch:{ CryptoException -> 0x0186 }
            r8 = 0
            r12 = 0
            r10 = r14
            r6.queueInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x0186 }
        L_0x017f:
            r1.zzadv = r4     // Catch:{ CryptoException -> 0x0186 }
            r1.zzaeb = r5     // Catch:{ CryptoException -> 0x0186 }
            r1.zzadz = r2     // Catch:{ CryptoException -> 0x0186 }
            return r5
        L_0x0186:
            r0 = move-exception
            r1.zza((android.media.MediaCodec.CryptoException) r0)
            com.google.android.gms.internal.ads.zzgd r2 = new com.google.android.gms.internal.ads.zzgd
            r2.<init>((java.lang.Throwable) r0)
            throw r2
        L_0x0190:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgr.zze(boolean):boolean");
    }

    /* access modifiers changed from: protected */
    public void zza(zzhk zzhk) throws zzgd {
        zzhj zzhj = this.zzado;
        this.zzado = zzhk.zzado;
        this.zzadp = zzhk.zzadp;
        if (this.zzadq != null && zza(this.zzadq, this.zzadr, zzhj, this.zzado)) {
            this.zzady = true;
            this.zzadz = 1;
        } else if (this.zzaeb) {
            this.zzaea = 1;
        } else {
            zzed();
            zzea();
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzdx() {
        return this.zzaef;
    }

    /* access modifiers changed from: protected */
    public boolean isReady() {
        if (this.zzado != null && !this.zzaeg) {
            if (this.zzaed == 0 && this.zzadw < 0) {
                if (SystemClock.elapsedRealtime() < this.zzadu + 1000) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final int zzeg() {
        return this.zzaed;
    }

    private final void zza(MediaCodec.CryptoException cryptoException) {
        if (this.zzabq != null && this.zzadn != null) {
            this.zzabq.post(new zzgt(this, cryptoException));
        }
    }
}
