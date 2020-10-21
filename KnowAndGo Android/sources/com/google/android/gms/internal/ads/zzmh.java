package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer2.extractor.p012ts.TsExtractor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

public final class zzmh {
    private static boolean zzagc = false;
    private static boolean zzavt = false;
    private int streamType;
    private int zzada;
    private ByteBuffer[] zzadt;
    private int zzafv;
    /* access modifiers changed from: private */
    public final ConditionVariable zzagd;
    private final long[] zzage;
    private AudioTrack zzagg;
    private int zzagh;
    private int zzagi;
    private int zzagl;
    private int zzagm;
    private int zzagn;
    private long zzago;
    private long zzagp;
    private boolean zzagq;
    private long zzagr;
    private Method zzags;
    private int zzagu;
    private long zzagv;
    private long zzagw;
    private long zzagx;
    private zzln zzasc;
    private final zzlw zzavu = null;
    private final zzmq zzavv;
    private final zzmx zzavw;
    private final zzlx[] zzavx;
    private final zzmn zzavy;
    private final zzmj zzavz;
    private final LinkedList<zzmo> zzawa;
    private int zzawb;
    private boolean zzawc;
    private long zzawd;
    private zzln zzawe;
    private long zzawf;
    private long zzawg;
    private ByteBuffer zzawh;
    private int zzawi;
    private int zzawj;
    private long zzawk;
    private long zzawl;
    private int zzawm;
    private long zzawn;
    private long zzawo;
    private int zzawp;
    private zzlx[] zzawq;
    private ByteBuffer zzawr;
    private ByteBuffer zzaws;
    private byte[] zzawt;
    private int zzawu;
    private int zzawv;
    private boolean zzaww;
    private boolean zzawx;
    private boolean zzawy;
    private boolean zzawz;
    private long zzaxa;
    private float zzcv;

    public zzmh(zzlw zzlw, zzlx[] zzlxArr, zzmn zzmn) {
        this.zzavy = zzmn;
        this.zzagd = new ConditionVariable(true);
        if (zzsy.SDK_INT >= 18) {
            try {
                this.zzags = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzsy.SDK_INT >= 19) {
            this.zzavz = new zzmk();
        } else {
            this.zzavz = new zzmj((zzmi) null);
        }
        this.zzavv = new zzmq();
        this.zzavw = new zzmx();
        this.zzavx = new zzlx[(zzlxArr.length + 3)];
        this.zzavx[0] = new zzmv();
        this.zzavx[1] = this.zzavv;
        System.arraycopy(zzlxArr, 0, this.zzavx, 2, zzlxArr.length);
        this.zzavx[zzlxArr.length + 2] = this.zzavw;
        this.zzage = new long[10];
        this.zzcv = 1.0f;
        this.zzagu = 0;
        this.streamType = 3;
        this.zzada = 0;
        this.zzasc = zzln.zzaug;
        this.zzawv = -1;
        this.zzawq = new zzlx[0];
        this.zzadt = new ByteBuffer[0];
        this.zzawa = new LinkedList<>();
    }

    public final boolean zzaz(String str) {
        return this.zzavu != null && this.zzavu.zzaf(zzba(str));
    }

    public final long zzf(boolean z) {
        long j;
        long j2;
        long j3;
        if (!(isInitialized() && this.zzagu != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.zzagg.getPlayState() == 3) {
            long zzdv = this.zzavz.zzdv();
            if (zzdv != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.zzagp >= 30000) {
                    this.zzage[this.zzagm] = zzdv - nanoTime;
                    this.zzagm = (this.zzagm + 1) % 10;
                    if (this.zzagn < 10) {
                        this.zzagn++;
                    }
                    this.zzagp = nanoTime;
                    this.zzago = 0;
                    for (int i = 0; i < this.zzagn; i++) {
                        this.zzago += this.zzage[i] / ((long) this.zzagn);
                    }
                }
                if (!zzhu() && nanoTime - this.zzagr >= 500000) {
                    this.zzagq = this.zzavz.zzex();
                    if (this.zzagq) {
                        long zzey = this.zzavz.zzey() / 1000;
                        long zzez = this.zzavz.zzez();
                        if (zzey < this.zzagw) {
                            this.zzagq = false;
                        } else if (Math.abs(zzey - nanoTime) > 5000000) {
                            StringBuilder sb = new StringBuilder(136);
                            sb.append("Spurious audio timestamp (system clock mismatch): ");
                            sb.append(zzez);
                            sb.append(", ");
                            sb.append(zzey);
                            sb.append(", ");
                            sb.append(nanoTime);
                            sb.append(", ");
                            sb.append(zzdv);
                            Log.w("AudioTrack", sb.toString());
                            this.zzagq = false;
                        } else if (Math.abs(zzdo(zzez) - zzdv) > 5000000) {
                            StringBuilder sb2 = new StringBuilder(TsExtractor.TS_STREAM_TYPE_DTS);
                            sb2.append("Spurious audio timestamp (frame position mismatch): ");
                            sb2.append(zzez);
                            sb2.append(", ");
                            sb2.append(zzey);
                            sb2.append(", ");
                            sb2.append(nanoTime);
                            sb2.append(", ");
                            sb2.append(zzdv);
                            Log.w("AudioTrack", sb2.toString());
                            this.zzagq = false;
                        }
                    }
                    if (this.zzags != null && !this.zzawc) {
                        try {
                            this.zzagx = (((long) ((Integer) this.zzags.invoke(this.zzagg, (Object[]) null)).intValue()) * 1000) - this.zzawd;
                            this.zzagx = Math.max(this.zzagx, 0);
                            if (this.zzagx > 5000000) {
                                long j4 = this.zzagx;
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(j4);
                                Log.w("AudioTrack", sb3.toString());
                                this.zzagx = 0;
                            }
                        } catch (Exception unused) {
                            this.zzags = null;
                        }
                    }
                    this.zzagr = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.zzagq) {
            j = zzdo(this.zzavz.zzez() + zzdp(nanoTime2 - (this.zzavz.zzey() / 1000)));
        } else {
            if (this.zzagn == 0) {
                j3 = this.zzavz.zzdv();
            } else {
                j3 = nanoTime2 + this.zzago;
            }
            long j5 = j3;
            j = !z ? j5 - this.zzagx : j5;
        }
        long j6 = this.zzagv;
        while (!this.zzawa.isEmpty() && j >= this.zzawa.getFirst().zzacl) {
            zzmo remove = this.zzawa.remove();
            this.zzasc = remove.zzasc;
            this.zzawg = remove.zzacl;
            this.zzawf = remove.zzaxg - this.zzagv;
        }
        if (this.zzasc.zzauh == 1.0f) {
            j2 = (j + this.zzawf) - this.zzawg;
        } else if (!this.zzawa.isEmpty() || this.zzavw.zzia() < 1024) {
            j2 = ((long) (((double) this.zzasc.zzauh) * ((double) (j - this.zzawg)))) + this.zzawf;
        } else {
            j2 = zzsy.zza(j - this.zzawg, this.zzavw.zzhz(), this.zzavw.zzia()) + this.zzawf;
        }
        return j6 + j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r8, int r9, int r10, int r11, int r12, int[] r13) throws com.google.android.gms.internal.ads.zzml {
        /*
            r7 = this;
            java.lang.String r12 = "audio/raw"
            boolean r12 = r12.equals(r8)
            r0 = 1
            r12 = r12 ^ r0
            if (r12 == 0) goto L_0x000f
            int r8 = zzba(r8)
            goto L_0x0010
        L_0x000f:
            r8 = r11
        L_0x0010:
            r1 = 0
            if (r12 != 0) goto L_0x004f
            int r11 = com.google.android.gms.internal.ads.zzsy.zzg(r11, r9)
            r7.zzawj = r11
            com.google.android.gms.internal.ads.zzmq r11 = r7.zzavv
            r11.zzb(r13)
            com.google.android.gms.internal.ads.zzlx[] r11 = r7.zzavx
            int r13 = r11.length
            r3 = r8
            r2 = r9
            r8 = 0
            r9 = 0
        L_0x0025:
            if (r8 >= r13) goto L_0x0046
            r4 = r11[r8]
            boolean r5 = r4.zzb(r10, r2, r3)     // Catch:{ zzly -> 0x003f }
            r9 = r9 | r5
            boolean r5 = r4.isActive()
            if (r5 == 0) goto L_0x003c
            int r2 = r4.zzhj()
            int r3 = r4.zzhk()
        L_0x003c:
            int r8 = r8 + 1
            goto L_0x0025
        L_0x003f:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzml r9 = new com.google.android.gms.internal.ads.zzml
            r9.<init>((java.lang.Throwable) r8)
            throw r9
        L_0x0046:
            if (r9 == 0) goto L_0x004b
            r7.zzhn()
        L_0x004b:
            r11 = r9
            r9 = r2
            r8 = r3
            goto L_0x0050
        L_0x004f:
            r11 = 0
        L_0x0050:
            r13 = 252(0xfc, float:3.53E-43)
            r2 = 12
            switch(r9) {
                case 1: goto L_0x0085;
                case 2: goto L_0x0082;
                case 3: goto L_0x007f;
                case 4: goto L_0x007c;
                case 5: goto L_0x0079;
                case 6: goto L_0x0076;
                case 7: goto L_0x0073;
                case 8: goto L_0x0070;
                default: goto L_0x0057;
            }
        L_0x0057:
            com.google.android.gms.internal.ads.zzml r8 = new com.google.android.gms.internal.ads.zzml
            r10 = 38
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r10)
            java.lang.String r10 = "Unsupported channel count: "
            r11.append(r10)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r8.<init>((java.lang.String) r9)
            throw r8
        L_0x0070:
            int r3 = com.google.android.gms.internal.ads.zzkt.CHANNEL_OUT_7POINT1_SURROUND
            goto L_0x0086
        L_0x0073:
            r3 = 1276(0x4fc, float:1.788E-42)
            goto L_0x0086
        L_0x0076:
            r3 = 252(0xfc, float:3.53E-43)
            goto L_0x0086
        L_0x0079:
            r3 = 220(0xdc, float:3.08E-43)
            goto L_0x0086
        L_0x007c:
            r3 = 204(0xcc, float:2.86E-43)
            goto L_0x0086
        L_0x007f:
            r3 = 28
            goto L_0x0086
        L_0x0082:
            r3 = 12
            goto L_0x0086
        L_0x0085:
            r3 = 4
        L_0x0086:
            int r4 = com.google.android.gms.internal.ads.zzsy.SDK_INT
            r5 = 23
            r6 = 5
            if (r4 > r5) goto L_0x00ad
            java.lang.String r4 = "foster"
            java.lang.String r5 = com.google.android.gms.internal.ads.zzsy.DEVICE
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00ad
            java.lang.String r4 = "NVIDIA"
            java.lang.String r5 = com.google.android.gms.internal.ads.zzsy.MANUFACTURER
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00ad
            r4 = 3
            if (r9 == r4) goto L_0x00ae
            if (r9 == r6) goto L_0x00ae
            r13 = 7
            if (r9 == r13) goto L_0x00aa
            goto L_0x00ad
        L_0x00aa:
            int r13 = com.google.android.gms.internal.ads.zzkt.CHANNEL_OUT_7POINT1_SURROUND
            goto L_0x00ae
        L_0x00ad:
            r13 = r3
        L_0x00ae:
            int r3 = com.google.android.gms.internal.ads.zzsy.SDK_INT
            r4 = 25
            if (r3 > r4) goto L_0x00c4
            java.lang.String r3 = "fugu"
            java.lang.String r4 = com.google.android.gms.internal.ads.zzsy.DEVICE
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00c4
            if (r12 == 0) goto L_0x00c4
            if (r9 != r0) goto L_0x00c4
            r13 = 12
        L_0x00c4:
            if (r11 != 0) goto L_0x00d9
            boolean r11 = r7.isInitialized()
            if (r11 == 0) goto L_0x00d9
            int r11 = r7.zzagi
            if (r11 != r8) goto L_0x00d9
            int r11 = r7.zzafv
            if (r11 != r10) goto L_0x00d9
            int r11 = r7.zzagh
            if (r11 != r13) goto L_0x00d9
            return
        L_0x00d9:
            r7.reset()
            r7.zzagi = r8
            r7.zzawc = r12
            r7.zzafv = r10
            r7.zzagh = r13
            r11 = 2
            if (r12 == 0) goto L_0x00e8
            goto L_0x00e9
        L_0x00e8:
            r8 = 2
        L_0x00e9:
            r7.zzawb = r8
            int r8 = com.google.android.gms.internal.ads.zzsy.zzg(r11, r9)
            r7.zzawm = r8
            if (r12 == 0) goto L_0x0104
            int r8 = r7.zzawb
            if (r8 == r6) goto L_0x0101
            int r8 = r7.zzawb
            r9 = 6
            if (r8 != r9) goto L_0x00fd
            goto L_0x0101
        L_0x00fd:
            r8 = 49152(0xc000, float:6.8877E-41)
            goto L_0x013a
        L_0x0101:
            r8 = 20480(0x5000, float:2.8699E-41)
            goto L_0x013a
        L_0x0104:
            int r8 = r7.zzawb
            int r8 = android.media.AudioTrack.getMinBufferSize(r10, r13, r8)
            r9 = -2
            if (r8 == r9) goto L_0x010e
            goto L_0x010f
        L_0x010e:
            r0 = 0
        L_0x010f:
            com.google.android.gms.internal.ads.zzsk.checkState(r0)
            int r9 = r8 << 2
            r10 = 250000(0x3d090, double:1.235164E-318)
            long r10 = r7.zzdp(r10)
            int r10 = (int) r10
            int r11 = r7.zzawm
            int r10 = r10 * r11
            long r0 = (long) r8
            r2 = 750000(0xb71b0, double:3.70549E-318)
            long r2 = r7.zzdp(r2)
            int r8 = r7.zzawm
            long r4 = (long) r8
            long r2 = r2 * r4
            long r0 = java.lang.Math.max(r0, r2)
            int r8 = (int) r0
            if (r9 >= r10) goto L_0x0136
            r8 = r10
            goto L_0x013a
        L_0x0136:
            if (r9 <= r8) goto L_0x0139
            goto L_0x013a
        L_0x0139:
            r8 = r9
        L_0x013a:
            r7.zzagl = r8
            if (r12 == 0) goto L_0x0144
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x014e
        L_0x0144:
            int r8 = r7.zzagl
            int r9 = r7.zzawm
            int r8 = r8 / r9
            long r8 = (long) r8
            long r8 = r7.zzdo(r8)
        L_0x014e:
            r7.zzawd = r8
            com.google.android.gms.internal.ads.zzln r8 = r7.zzasc
            r7.zzb(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmh.zza(java.lang.String, int, int, int, int, int[]):void");
    }

    private final void zzhn() {
        ArrayList arrayList = new ArrayList();
        for (zzlx zzlx : this.zzavx) {
            if (zzlx.isActive()) {
                arrayList.add(zzlx);
            } else {
                zzlx.flush();
            }
        }
        int size = arrayList.size();
        this.zzawq = (zzlx[]) arrayList.toArray(new zzlx[size]);
        this.zzadt = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            zzlx zzlx2 = this.zzawq[i];
            zzlx2.flush();
            this.zzadt[i] = zzlx2.zzhm();
        }
    }

    public final void play() {
        this.zzawx = true;
        if (isInitialized()) {
            this.zzagw = System.nanoTime() / 1000;
            this.zzagg.play();
        }
    }

    public final void zzeq() {
        if (this.zzagu == 1) {
            this.zzagu = 2;
        }
    }

    public final boolean zza(ByteBuffer byteBuffer, long j) throws zzmm, zzmp {
        int i;
        int i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j2 = j;
        zzsk.checkArgument(this.zzawr == null || byteBuffer2 == this.zzawr);
        if (!isInitialized()) {
            this.zzagd.block();
            if (this.zzawy) {
                this.zzagg = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.zzagh).setEncoding(this.zzawb).setSampleRate(this.zzafv).build(), this.zzagl, 1, this.zzada);
            } else if (this.zzada == 0) {
                this.zzagg = new AudioTrack(this.streamType, this.zzafv, this.zzagh, this.zzawb, this.zzagl, 1);
            } else {
                this.zzagg = new AudioTrack(this.streamType, this.zzafv, this.zzagh, this.zzawb, this.zzagl, 1, this.zzada);
            }
            int state = this.zzagg.getState();
            if (state == 1) {
                int audioSessionId = this.zzagg.getAudioSessionId();
                if (this.zzada != audioSessionId) {
                    this.zzada = audioSessionId;
                    this.zzavy.zzag(audioSessionId);
                }
                this.zzavz.zza(this.zzagg, zzhu());
                zzhs();
                this.zzawz = false;
                if (this.zzawx) {
                    play();
                }
            } else {
                try {
                    this.zzagg.release();
                } catch (Exception unused) {
                } finally {
                    this.zzagg = null;
                }
                throw new zzmm(state, this.zzafv, this.zzagh, this.zzagl);
            }
        }
        if (zzhu()) {
            if (this.zzagg.getPlayState() == 2) {
                this.zzawz = false;
                return false;
            } else if (this.zzagg.getPlayState() == 1 && this.zzavz.zzev() != 0) {
                return false;
            }
        }
        boolean z = this.zzawz;
        this.zzawz = zzer();
        if (z && !this.zzawz && this.zzagg.getPlayState() != 1) {
            this.zzavy.zze(this.zzagl, zzkt.zzdz(this.zzawd), SystemClock.elapsedRealtime() - this.zzaxa);
        }
        if (this.zzawr == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.zzawc && this.zzawp == 0) {
                int i3 = this.zzawb;
                if (i3 == 7 || i3 == 8) {
                    i2 = zzmr.zzj(byteBuffer);
                } else if (i3 == 5) {
                    i2 = zzlv.zzhi();
                } else if (i3 == 6) {
                    i2 = zzlv.zzh(byteBuffer);
                } else {
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unexpected audio encoding: ");
                    sb.append(i3);
                    throw new IllegalStateException(sb.toString());
                }
                this.zzawp = i2;
            }
            if (this.zzawe != null) {
                if (!zzhp()) {
                    return false;
                }
                LinkedList<zzmo> linkedList = this.zzawa;
                zzmo zzmo = r11;
                zzmo zzmo2 = new zzmo(this.zzawe, Math.max(0, j2), zzdo(zzht()), (zzmi) null);
                linkedList.add(zzmo);
                this.zzawe = null;
                zzhn();
            }
            if (this.zzagu == 0) {
                this.zzagv = Math.max(0, j2);
                this.zzagu = 1;
            } else {
                long zzdo = this.zzagv + zzdo(this.zzawc ? this.zzawl : this.zzawk / ((long) this.zzawj));
                if (this.zzagu != 1 || Math.abs(zzdo - j2) <= 200000) {
                    i = 2;
                } else {
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Discontinuity detected [expected ");
                    sb2.append(zzdo);
                    sb2.append(", got ");
                    sb2.append(j2);
                    sb2.append("]");
                    Log.e("AudioTrack", sb2.toString());
                    i = 2;
                    this.zzagu = 2;
                }
                if (this.zzagu == i) {
                    this.zzagv += j2 - zzdo;
                    this.zzagu = 1;
                    this.zzavy.zzgt();
                }
            }
            if (this.zzawc) {
                this.zzawl += (long) this.zzawp;
            } else {
                this.zzawk += (long) byteBuffer.remaining();
            }
            this.zzawr = byteBuffer2;
        }
        if (this.zzawc) {
            zzb(this.zzawr, j2);
        } else {
            zzeg(j2);
        }
        if (this.zzawr.hasRemaining()) {
            return false;
        }
        this.zzawr = null;
        return true;
    }

    private final void zzeg(long j) throws zzmp {
        ByteBuffer byteBuffer;
        int length = this.zzawq.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.zzadt[i - 1];
            } else {
                byteBuffer = this.zzawr != null ? this.zzawr : zzlx.zzavh;
            }
            if (i == length) {
                zzb(byteBuffer, j);
            } else {
                zzlx zzlx = this.zzawq[i];
                zzlx.zzi(byteBuffer);
                ByteBuffer zzhm = zzlx.zzhm();
                this.zzadt[i] = zzhm;
                if (zzhm.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00dd, code lost:
        if (r11 < r10) goto L_0x007a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzb(java.nio.ByteBuffer r9, long r10) throws com.google.android.gms.internal.ads.zzmp {
        /*
            r8 = this;
            boolean r0 = r9.hasRemaining()
            r1 = 1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.nio.ByteBuffer r0 = r8.zzaws
            r2 = 21
            r3 = 0
            if (r0 == 0) goto L_0x001a
            java.nio.ByteBuffer r0 = r8.zzaws
            if (r0 != r9) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            com.google.android.gms.internal.ads.zzsk.checkArgument(r0)
            goto L_0x003f
        L_0x001a:
            r8.zzaws = r9
            int r0 = com.google.android.gms.internal.ads.zzsy.SDK_INT
            if (r0 >= r2) goto L_0x003f
            int r0 = r9.remaining()
            byte[] r4 = r8.zzawt
            if (r4 == 0) goto L_0x002d
            byte[] r4 = r8.zzawt
            int r4 = r4.length
            if (r4 >= r0) goto L_0x0031
        L_0x002d:
            byte[] r4 = new byte[r0]
            r8.zzawt = r4
        L_0x0031:
            int r4 = r9.position()
            byte[] r5 = r8.zzawt
            r9.get(r5, r3, r0)
            r9.position(r4)
            r8.zzawu = r3
        L_0x003f:
            int r0 = r9.remaining()
            int r4 = com.google.android.gms.internal.ads.zzsy.SDK_INT
            if (r4 >= r2) goto L_0x007d
            long r10 = r8.zzawn
            com.google.android.gms.internal.ads.zzmj r2 = r8.zzavz
            long r4 = r2.zzev()
            int r2 = r8.zzawm
            long r6 = (long) r2
            long r4 = r4 * r6
            long r10 = r10 - r4
            int r10 = (int) r10
            int r11 = r8.zzagl
            int r11 = r11 - r10
            if (r11 <= 0) goto L_0x007a
            int r10 = java.lang.Math.min(r0, r11)
            android.media.AudioTrack r11 = r8.zzagg
            byte[] r2 = r8.zzawt
            int r4 = r8.zzawu
            int r10 = r11.write(r2, r4, r10)
            if (r10 <= 0) goto L_0x00f6
            int r11 = r8.zzawu
            int r11 = r11 + r10
            r8.zzawu = r11
            int r11 = r9.position()
            int r11 = r11 + r10
            r9.position(r11)
            goto L_0x00f6
        L_0x007a:
            r10 = 0
            goto L_0x00f6
        L_0x007d:
            boolean r2 = r8.zzawy
            if (r2 == 0) goto L_0x00f0
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x008c
            r2 = 1
            goto L_0x008d
        L_0x008c:
            r2 = 0
        L_0x008d:
            com.google.android.gms.internal.ads.zzsk.checkState(r2)
            android.media.AudioTrack r2 = r8.zzagg
            java.nio.ByteBuffer r4 = r8.zzawh
            if (r4 != 0) goto L_0x00ad
            r4 = 16
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)
            r8.zzawh = r4
            java.nio.ByteBuffer r4 = r8.zzawh
            java.nio.ByteOrder r5 = java.nio.ByteOrder.BIG_ENDIAN
            r4.order(r5)
            java.nio.ByteBuffer r4 = r8.zzawh
            r5 = 1431633921(0x55550001, float:1.46372496E13)
            r4.putInt(r5)
        L_0x00ad:
            int r4 = r8.zzawi
            if (r4 != 0) goto L_0x00c9
            java.nio.ByteBuffer r4 = r8.zzawh
            r5 = 4
            r4.putInt(r5, r0)
            java.nio.ByteBuffer r4 = r8.zzawh
            r5 = 8
            r6 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 * r6
            r4.putLong(r5, r10)
            java.nio.ByteBuffer r10 = r8.zzawh
            r10.position(r3)
            r8.zzawi = r0
        L_0x00c9:
            java.nio.ByteBuffer r10 = r8.zzawh
            int r10 = r10.remaining()
            if (r10 <= 0) goto L_0x00e0
            java.nio.ByteBuffer r11 = r8.zzawh
            int r11 = r2.write(r11, r10, r1)
            if (r11 >= 0) goto L_0x00dd
            r8.zzawi = r3
            r10 = r11
            goto L_0x00f6
        L_0x00dd:
            if (r11 >= r10) goto L_0x00e0
            goto L_0x007a
        L_0x00e0:
            int r9 = r2.write(r9, r0, r1)
            if (r9 >= 0) goto L_0x00e9
            r8.zzawi = r3
            goto L_0x00ee
        L_0x00e9:
            int r10 = r8.zzawi
            int r10 = r10 - r9
            r8.zzawi = r10
        L_0x00ee:
            r10 = r9
            goto L_0x00f6
        L_0x00f0:
            android.media.AudioTrack r10 = r8.zzagg
            int r10 = r10.write(r9, r0, r1)
        L_0x00f6:
            long r4 = android.os.SystemClock.elapsedRealtime()
            r8.zzaxa = r4
            if (r10 < 0) goto L_0x011b
            boolean r9 = r8.zzawc
            if (r9 != 0) goto L_0x0108
            long r4 = r8.zzawn
            long r6 = (long) r10
            long r4 = r4 + r6
            r8.zzawn = r4
        L_0x0108:
            if (r10 != r0) goto L_0x011a
            boolean r9 = r8.zzawc
            if (r9 == 0) goto L_0x0116
            long r9 = r8.zzawo
            int r11 = r8.zzawp
            long r2 = (long) r11
            long r9 = r9 + r2
            r8.zzawo = r9
        L_0x0116:
            r9 = 0
            r8.zzaws = r9
            return r1
        L_0x011a:
            return r3
        L_0x011b:
            com.google.android.gms.internal.ads.zzmp r9 = new com.google.android.gms.internal.ads.zzmp
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmh.zzb(java.nio.ByteBuffer, long):boolean");
    }

    public final void zzho() throws zzmp {
        if (!this.zzaww && isInitialized() && zzhp()) {
            this.zzavz.zzeh(zzht());
            this.zzawi = 0;
            this.zzaww = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzhp() throws com.google.android.gms.internal.ads.zzmp {
        /*
            r8 = this;
            int r0 = r8.zzawv
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0014
            boolean r0 = r8.zzawc
            if (r0 == 0) goto L_0x000f
            com.google.android.gms.internal.ads.zzlx[] r0 = r8.zzawq
            int r0 = r0.length
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            r8.zzawv = r0
        L_0x0012:
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            int r4 = r8.zzawv
            com.google.android.gms.internal.ads.zzlx[] r5 = r8.zzawq
            int r5 = r5.length
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r5) goto L_0x003c
            com.google.android.gms.internal.ads.zzlx[] r4 = r8.zzawq
            int r5 = r8.zzawv
            r4 = r4[r5]
            if (r0 == 0) goto L_0x002c
            r4.zzhl()
        L_0x002c:
            r8.zzeg(r6)
            boolean r0 = r4.zzdx()
            if (r0 != 0) goto L_0x0036
            return r3
        L_0x0036:
            int r0 = r8.zzawv
            int r0 = r0 + r2
            r8.zzawv = r0
            goto L_0x0012
        L_0x003c:
            java.nio.ByteBuffer r0 = r8.zzaws
            if (r0 == 0) goto L_0x004a
            java.nio.ByteBuffer r0 = r8.zzaws
            r8.zzb(r0, r6)
            java.nio.ByteBuffer r0 = r8.zzaws
            if (r0 == 0) goto L_0x004a
            return r3
        L_0x004a:
            r8.zzawv = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmh.zzhp():boolean");
    }

    public final boolean zzdx() {
        if (isInitialized()) {
            return this.zzaww && !zzer();
        }
        return true;
    }

    public final boolean zzer() {
        if (isInitialized()) {
            if (zzht() <= this.zzavz.zzev()) {
                if (zzhu() && this.zzagg.getPlayState() == 2 && this.zzagg.getPlaybackHeadPosition() == 0) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public final zzln zzb(zzln zzln) {
        zzln zzln2;
        if (this.zzawc) {
            this.zzasc = zzln.zzaug;
            return this.zzasc;
        }
        zzln zzln3 = new zzln(this.zzavw.zzb(zzln.zzauh), this.zzavw.zzc(zzln.zzaui));
        if (this.zzawe != null) {
            zzln2 = this.zzawe;
        } else if (!this.zzawa.isEmpty()) {
            zzln2 = this.zzawa.getLast().zzasc;
        } else {
            zzln2 = this.zzasc;
        }
        if (!zzln3.equals(zzln2)) {
            if (isInitialized()) {
                this.zzawe = zzln3;
            } else {
                this.zzasc = zzln3;
            }
        }
        return this.zzasc;
    }

    public final zzln zzhq() {
        return this.zzasc;
    }

    public final void setStreamType(int i) {
        if (this.streamType != i) {
            this.streamType = i;
            if (!this.zzawy) {
                reset();
                this.zzada = 0;
            }
        }
    }

    public final void zzai(int i) {
        zzsk.checkState(zzsy.SDK_INT >= 21);
        if (!this.zzawy || this.zzada != i) {
            this.zzawy = true;
            this.zzada = i;
            reset();
        }
    }

    public final void zzhr() {
        if (this.zzawy) {
            this.zzawy = false;
            this.zzada = 0;
            reset();
        }
    }

    public final void setVolume(float f) {
        if (this.zzcv != f) {
            this.zzcv = f;
            zzhs();
        }
    }

    private final void zzhs() {
        if (!isInitialized()) {
            return;
        }
        if (zzsy.SDK_INT >= 21) {
            this.zzagg.setVolume(this.zzcv);
            return;
        }
        AudioTrack audioTrack = this.zzagg;
        float f = this.zzcv;
        audioTrack.setStereoVolume(f, f);
    }

    public final void pause() {
        this.zzawx = false;
        if (isInitialized()) {
            zzet();
            this.zzavz.pause();
        }
    }

    public final void reset() {
        if (isInitialized()) {
            this.zzawk = 0;
            this.zzawl = 0;
            this.zzawn = 0;
            this.zzawo = 0;
            this.zzawp = 0;
            if (this.zzawe != null) {
                this.zzasc = this.zzawe;
                this.zzawe = null;
            } else if (!this.zzawa.isEmpty()) {
                this.zzasc = this.zzawa.getLast().zzasc;
            }
            this.zzawa.clear();
            this.zzawf = 0;
            this.zzawg = 0;
            this.zzawr = null;
            this.zzaws = null;
            for (int i = 0; i < this.zzawq.length; i++) {
                zzlx zzlx = this.zzawq[i];
                zzlx.flush();
                this.zzadt[i] = zzlx.zzhm();
            }
            this.zzaww = false;
            this.zzawv = -1;
            this.zzawh = null;
            this.zzawi = 0;
            this.zzagu = 0;
            this.zzagx = 0;
            zzet();
            if (this.zzagg.getPlayState() == 3) {
                this.zzagg.pause();
            }
            AudioTrack audioTrack = this.zzagg;
            this.zzagg = null;
            this.zzavz.zza((AudioTrack) null, false);
            this.zzagd.close();
            new zzmi(this, audioTrack).start();
        }
    }

    public final void release() {
        reset();
        for (zzlx reset : this.zzavx) {
            reset.reset();
        }
        this.zzada = 0;
        this.zzawx = false;
    }

    private final boolean isInitialized() {
        return this.zzagg != null;
    }

    private final long zzdo(long j) {
        return (j * 1000000) / ((long) this.zzafv);
    }

    private final long zzdp(long j) {
        return (j * ((long) this.zzafv)) / 1000000;
    }

    private final long zzht() {
        return this.zzawc ? this.zzawo : this.zzawn / ((long) this.zzawm);
    }

    private final void zzet() {
        this.zzago = 0;
        this.zzagn = 0;
        this.zzagm = 0;
        this.zzagp = 0;
        this.zzagq = false;
        this.zzagr = 0;
    }

    private final boolean zzhu() {
        if (zzsy.SDK_INT < 23) {
            return this.zzawb == 5 || this.zzawb == 6;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0047 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzba(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = -1095064472(0xffffffffbebaa468, float:-0.36453557)
            r2 = 0
            if (r0 == r1) goto L_0x0038
            r1 = 187078296(0xb269698, float:3.208373E-32)
            if (r0 == r1) goto L_0x002e
            r1 = 1504578661(0x59ae0c65, float:6.1237842E15)
            if (r0 == r1) goto L_0x0024
            r1 = 1505942594(0x59c2dc42, float:6.8560402E15)
            if (r0 == r1) goto L_0x001a
            goto L_0x0042
        L_0x001a:
            java.lang.String r0 = "audio/vnd.dts.hd"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0042
            r3 = 3
            goto L_0x0043
        L_0x0024:
            java.lang.String r0 = "audio/eac3"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0042
            r3 = 1
            goto L_0x0043
        L_0x002e:
            java.lang.String r0 = "audio/ac3"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0042
            r3 = 0
            goto L_0x0043
        L_0x0038:
            java.lang.String r0 = "audio/vnd.dts"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0042
            r3 = 2
            goto L_0x0043
        L_0x0042:
            r3 = -1
        L_0x0043:
            switch(r3) {
                case 0: goto L_0x004e;
                case 1: goto L_0x004c;
                case 2: goto L_0x004a;
                case 3: goto L_0x0047;
                default: goto L_0x0046;
            }
        L_0x0046:
            return r2
        L_0x0047:
            r3 = 8
            return r3
        L_0x004a:
            r3 = 7
            return r3
        L_0x004c:
            r3 = 6
            return r3
        L_0x004e:
            r3 = 5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmh.zzba(java.lang.String):int");
    }
}
