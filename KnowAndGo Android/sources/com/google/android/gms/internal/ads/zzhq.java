package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.ConditionVariable;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import com.google.android.exoplayer2.extractor.p012ts.TsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import java.lang.reflect.Method;

@TargetApi(16)
public final class zzhq {
    private static boolean zzagc = false;
    private int zzafv;
    /* access modifiers changed from: private */
    public final ConditionVariable zzagd = new ConditionVariable(true);
    private final long[] zzage;
    private final zzhs zzagf;
    private AudioTrack zzagg;
    private int zzagh;
    private int zzagi;
    private int zzagj;
    private int zzagk;
    private int zzagl;
    private int zzagm;
    private int zzagn;
    private long zzago;
    private long zzagp;
    private boolean zzagq;
    private long zzagr;
    private Method zzags;
    private long zzagt;
    private int zzagu;
    private long zzagv;
    private long zzagw;
    private long zzagx;
    private byte[] zzagy;
    private int zzagz;
    private int zzaha;
    private boolean zzahb;
    private int zzahc;
    private float zzcv;

    public zzhq() {
        if (zzkq.SDK_INT >= 18) {
            try {
                this.zzags = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzkq.SDK_INT >= 19) {
            this.zzagf = new zzht();
        } else {
            this.zzagf = new zzhs((zzhr) null);
        }
        this.zzage = new long[10];
        this.zzcv = 1.0f;
        this.zzagu = 0;
    }

    public final boolean isInitialized() {
        return this.zzagg != null;
    }

    public final long zzf(boolean z) {
        long j;
        if (!(isInitialized() && this.zzagv != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.zzagg.getPlayState() == 3) {
            long zzew = this.zzagf.zzew();
            if (zzew != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.zzagp >= 30000) {
                    this.zzage[this.zzagm] = zzew - nanoTime;
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
                if (!this.zzahb && nanoTime - this.zzagr >= 500000) {
                    this.zzagq = this.zzagf.zzex();
                    if (this.zzagq) {
                        long zzey = this.zzagf.zzey() / 1000;
                        long zzez = this.zzagf.zzez();
                        if (zzey < this.zzagw) {
                            this.zzagq = false;
                        } else if (Math.abs(zzey - nanoTime) > 5000000) {
                            this.zzagq = false;
                            StringBuilder sb = new StringBuilder(136);
                            sb.append("Spurious audio timestamp (system clock mismatch): ");
                            sb.append(zzez);
                            sb.append(", ");
                            sb.append(zzey);
                            sb.append(", ");
                            sb.append(nanoTime);
                            sb.append(", ");
                            sb.append(zzew);
                            Log.w("AudioTrack", sb.toString());
                        } else if (Math.abs(zzdo(zzez) - zzew) > 5000000) {
                            this.zzagq = false;
                            StringBuilder sb2 = new StringBuilder(TsExtractor.TS_STREAM_TYPE_DTS);
                            sb2.append("Spurious audio timestamp (frame position mismatch): ");
                            sb2.append(zzez);
                            sb2.append(", ");
                            sb2.append(zzey);
                            sb2.append(", ");
                            sb2.append(nanoTime);
                            sb2.append(", ");
                            sb2.append(zzew);
                            Log.w("AudioTrack", sb2.toString());
                        }
                    }
                    if (this.zzags != null) {
                        try {
                            this.zzagx = (((long) ((Integer) this.zzags.invoke(this.zzagg, (Object[]) null)).intValue()) * 1000) - zzdo(zzdn((long) this.zzagl));
                            this.zzagx = Math.max(this.zzagx, 0);
                            if (this.zzagx > 5000000) {
                                long j2 = this.zzagx;
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(j2);
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
            return zzdo(this.zzagf.zzez() + zzdp(nanoTime2 - (this.zzagf.zzey() / 1000))) + this.zzagv;
        }
        if (this.zzagn == 0) {
            j = this.zzagf.zzew() + this.zzagv;
        } else {
            j = nanoTime2 + this.zzago + this.zzagv;
        }
        long j3 = j;
        return !z ? j3 - this.zzagx : j3;
    }

    public final int zzq(int i) throws zzhu {
        this.zzagd.block();
        if (i == 0) {
            this.zzagg = new AudioTrack(3, this.zzafv, this.zzagh, this.zzagi, this.zzagl, 1);
        } else {
            this.zzagg = new AudioTrack(3, this.zzafv, this.zzagh, this.zzagi, this.zzagl, 1, i);
        }
        int state = this.zzagg.getState();
        if (state == 1) {
            int audioSessionId = this.zzagg.getAudioSessionId();
            this.zzagf.zza(this.zzagg, this.zzahb);
            setVolume(this.zzcv);
            return audioSessionId;
        }
        try {
            this.zzagg.release();
        } catch (Exception unused) {
        } finally {
            this.zzagg = null;
        }
        throw new zzhu(state, this.zzafv, this.zzagh, this.zzagl);
    }

    public final void zza(MediaFormat mediaFormat, int i) {
        int i2;
        int i3;
        int integer = mediaFormat.getInteger("channel-count");
        if (integer == 6) {
            i2 = 252;
        } else if (integer != 8) {
            switch (integer) {
                case 1:
                    i2 = 4;
                    break;
                case 2:
                    i2 = 12;
                    break;
                default:
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unsupported channel count: ");
                    sb.append(integer);
                    throw new IllegalArgumentException(sb.toString());
            }
        } else {
            i2 = PointerIconCompat.TYPE_GRAB;
        }
        int integer2 = mediaFormat.getInteger("sample-rate");
        String string = mediaFormat.getString("mime");
        if (MimeTypes.AUDIO_AC3.equals(string)) {
            i3 = 5;
        } else if (MimeTypes.AUDIO_E_AC3.equals(string)) {
            i3 = 6;
        } else {
            i3 = zzkl.zzav(string) ? 2 : 0;
        }
        boolean z = true;
        boolean z2 = i3 == 5 || i3 == 6;
        if (!isInitialized() || this.zzafv != integer2 || this.zzagh != i2 || this.zzahb || z2) {
            reset();
            this.zzagi = i3;
            this.zzafv = integer2;
            this.zzagh = i2;
            this.zzahb = z2;
            this.zzahc = 0;
            this.zzagj = integer * 2;
            this.zzagk = AudioTrack.getMinBufferSize(integer2, i2, i3);
            if (this.zzagk == -2) {
                z = false;
            }
            zzkh.checkState(z);
            int i4 = this.zzagk << 2;
            int zzdp = ((int) zzdp(250000)) * this.zzagj;
            int max = (int) Math.max((long) this.zzagk, zzdp(750000) * ((long) this.zzagj));
            if (i4 < zzdp) {
                i4 = zzdp;
            } else if (i4 > max) {
                i4 = max;
            }
            this.zzagl = i4;
        }
    }

    public final void play() {
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

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x011e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.nio.ByteBuffer r10, int r11, int r12, long r13) throws com.google.android.gms.internal.ads.zzhv {
        /*
            r9 = this;
            r0 = 2
            if (r12 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = com.google.android.gms.internal.ads.zzkq.SDK_INT
            r2 = 22
            r3 = 0
            r5 = 1
            r6 = 0
            if (r1 > r2) goto L_0x002e
            boolean r1 = r9.zzahb
            if (r1 == 0) goto L_0x002e
            android.media.AudioTrack r1 = r9.zzagg
            int r1 = r1.getPlayState()
            if (r1 != r0) goto L_0x001b
            return r6
        L_0x001b:
            android.media.AudioTrack r1 = r9.zzagg
            int r1 = r1.getPlayState()
            if (r1 != r5) goto L_0x002e
            com.google.android.gms.internal.ads.zzhs r1 = r9.zzagf
            long r1 = r1.zzev()
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x002e
            return r6
        L_0x002e:
            int r1 = r9.zzaha
            if (r1 != 0) goto L_0x00ae
            boolean r1 = r9.zzahb
            if (r1 == 0) goto L_0x0042
            int r1 = r9.zzahc
            if (r1 != 0) goto L_0x0042
            int r1 = r9.zzafv
            int r1 = com.google.android.gms.internal.ads.zzkg.zza(r12, r1)
            r9.zzahc = r1
        L_0x0042:
            long r1 = (long) r12
            long r1 = r9.zzdn(r1)
            long r1 = r9.zzdo(r1)
            long r13 = r13 - r1
            long r1 = r9.zzagv
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x005b
            long r13 = java.lang.Math.max(r3, r13)
            r9.zzagv = r13
            r9.zzagu = r5
            goto L_0x00ae
        L_0x005b:
            long r1 = r9.zzagv
            long r3 = r9.zzagt
            long r3 = r9.zzdn(r3)
            long r3 = r9.zzdo(r3)
            long r1 = r1 + r3
            int r3 = r9.zzagu
            if (r3 != r5) goto L_0x00a0
            long r3 = r1 - r13
            long r3 = java.lang.Math.abs(r3)
            r7 = 200000(0x30d40, double:9.8813E-319)
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 <= 0) goto L_0x00a0
            java.lang.String r3 = "AudioTrack"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r7 = 80
            r4.<init>(r7)
            java.lang.String r7 = "Discontinuity detected [expected "
            r4.append(r7)
            r4.append(r1)
            java.lang.String r7 = ", got "
            r4.append(r7)
            r4.append(r13)
            java.lang.String r7 = "]"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            android.util.Log.e(r3, r4)
            r9.zzagu = r0
        L_0x00a0:
            int r3 = r9.zzagu
            if (r3 != r0) goto L_0x00ae
            long r3 = r9.zzagv
            long r13 = r13 - r1
            long r3 = r3 + r13
            r9.zzagv = r3
            r9.zzagu = r5
            r13 = 1
            goto L_0x00af
        L_0x00ae:
            r13 = 0
        L_0x00af:
            int r14 = r9.zzaha
            r0 = 21
            if (r14 != 0) goto L_0x00d2
            r9.zzaha = r12
            r10.position(r11)
            int r11 = com.google.android.gms.internal.ads.zzkq.SDK_INT
            if (r11 >= r0) goto L_0x00d2
            byte[] r11 = r9.zzagy
            if (r11 == 0) goto L_0x00c7
            byte[] r11 = r9.zzagy
            int r11 = r11.length
            if (r11 >= r12) goto L_0x00cb
        L_0x00c7:
            byte[] r11 = new byte[r12]
            r9.zzagy = r11
        L_0x00cb:
            byte[] r11 = r9.zzagy
            r10.get(r11, r6, r12)
            r9.zzagz = r6
        L_0x00d2:
            int r11 = com.google.android.gms.internal.ads.zzkq.SDK_INT
            if (r11 >= r0) goto L_0x0102
            long r10 = r9.zzagt
            com.google.android.gms.internal.ads.zzhs r12 = r9.zzagf
            long r0 = r12.zzev()
            int r12 = r9.zzagj
            long r2 = (long) r12
            long r0 = r0 * r2
            long r10 = r10 - r0
            int r10 = (int) r10
            int r11 = r9.zzagl
            int r11 = r11 - r10
            if (r11 <= 0) goto L_0x010a
            int r10 = r9.zzaha
            int r10 = java.lang.Math.min(r10, r11)
            android.media.AudioTrack r11 = r9.zzagg
            byte[] r12 = r9.zzagy
            int r14 = r9.zzagz
            int r6 = r11.write(r12, r14, r10)
            if (r6 < 0) goto L_0x010a
            int r10 = r9.zzagz
            int r10 = r10 + r6
            r9.zzagz = r10
            goto L_0x010a
        L_0x0102:
            android.media.AudioTrack r11 = r9.zzagg
            int r12 = r9.zzaha
            int r6 = r11.write(r10, r12, r5)
        L_0x010a:
            if (r6 < 0) goto L_0x011e
            int r10 = r9.zzaha
            int r10 = r10 - r6
            r9.zzaha = r10
            long r10 = r9.zzagt
            long r0 = (long) r6
            long r10 = r10 + r0
            r9.zzagt = r10
            int r10 = r9.zzaha
            if (r10 != 0) goto L_0x011d
            r13 = r13 | 2
        L_0x011d:
            return r13
        L_0x011e:
            com.google.android.gms.internal.ads.zzhv r10 = new com.google.android.gms.internal.ads.zzhv
            r10.<init>(r6)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhq.zza(java.nio.ByteBuffer, int, int, long):int");
    }

    public final boolean zzer() {
        if (isInitialized()) {
            return zzdn(this.zzagt) > this.zzagf.zzev() || this.zzagf.zzeu();
        }
        return false;
    }

    public final boolean zzes() {
        return this.zzagt > ((long) ((this.zzagk * 3) / 2));
    }

    public final void setVolume(float f) {
        this.zzcv = f;
        if (!isInitialized()) {
            return;
        }
        if (zzkq.SDK_INT >= 21) {
            this.zzagg.setVolume(f);
        } else {
            this.zzagg.setStereoVolume(f, f);
        }
    }

    public final void pause() {
        if (isInitialized()) {
            zzet();
            this.zzagg.pause();
        }
    }

    public final void reset() {
        if (isInitialized()) {
            this.zzagt = 0;
            this.zzaha = 0;
            this.zzagv = 0;
            this.zzagx = 0;
            zzet();
            if (this.zzagg.getPlayState() == 3) {
                this.zzagg.pause();
            }
            AudioTrack audioTrack = this.zzagg;
            this.zzagg = null;
            this.zzagf.zza((AudioTrack) null, false);
            this.zzagd.close();
            new zzhr(this, audioTrack).start();
        }
    }

    private final long zzdn(long j) {
        if (!this.zzahb) {
            return j / ((long) this.zzagj);
        }
        if (this.zzahc == 0) {
            return 0;
        }
        return ((j << 3) * ((long) this.zzafv)) / ((long) (this.zzahc * 1000));
    }

    private final long zzdo(long j) {
        return (j * 1000000) / ((long) this.zzafv);
    }

    private final long zzdp(long j) {
        return (j * ((long) this.zzafv)) / 1000000;
    }

    private final void zzet() {
        this.zzago = 0;
        this.zzagn = 0;
        this.zzagm = 0;
        this.zzagp = 0;
        this.zzagq = false;
        this.zzagr = 0;
    }
}
