package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C1470C;
import java.io.IOException;

final class zzlc implements Handler.Callback, zzqk, zzqm, zzrq {
    private final Handler handler;
    private int repeatMode = 0;
    private int state;
    private final Handler zzabq;
    private boolean zzabu;
    private final HandlerThread zzaby;
    private boolean zzacf;
    private boolean zzacg;
    private int zzach;
    private int zzaci;
    private long zzacj;
    private final zzlo[] zzaro;
    private final zzrp zzarp;
    private final zzlu zzars;
    private final zzlt zzart;
    private boolean zzarx;
    private zzlr zzary;
    private zzln zzasc;
    private zzle zzasd;
    private final zzlp[] zzasi;
    private final zzll zzasj;
    private final zzsw zzask;
    private final zzkv zzasl;
    private zzlo zzasm;
    private zzso zzasn;
    private zzql zzaso;
    private zzlo[] zzasp;
    private int zzasq;
    private zzlf zzasr;
    private long zzass;
    private zzld zzast;
    private zzld zzasu;
    private zzld zzasv;

    public zzlc(zzlo[] zzloArr, zzrp zzrp, zzll zzll, boolean z, int i, Handler handler2, zzle zzle, zzkv zzkv) {
        this.zzaro = zzloArr;
        this.zzarp = zzrp;
        this.zzasj = zzll;
        this.zzabu = z;
        this.zzabq = handler2;
        this.state = 1;
        this.zzasd = zzle;
        this.zzasl = zzkv;
        this.zzasi = new zzlp[zzloArr.length];
        for (int i2 = 0; i2 < zzloArr.length; i2++) {
            zzloArr[i2].setIndex(i2);
            this.zzasi[i2] = zzloArr[i2].zzgi();
        }
        this.zzask = new zzsw();
        this.zzasp = new zzlo[0];
        this.zzars = new zzlu();
        this.zzart = new zzlt();
        zzrp.zza(this);
        this.zzasc = zzln.zzaug;
        this.zzaby = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.zzaby.start();
        this.handler = new Handler(this.zzaby.getLooper(), this);
    }

    public final void zza(zzql zzql, boolean z) {
        this.handler.obtainMessage(0, 1, 0, zzql).sendToTarget();
    }

    public final void zzd(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void zza(zzlr zzlr, int i, long j) {
        this.handler.obtainMessage(3, new zzlf(zzlr, i, j)).sendToTarget();
    }

    public final void stop() {
        this.handler.sendEmptyMessage(5);
    }

    public final void zza(zzky... zzkyArr) {
        if (this.zzacf) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.zzach++;
        this.handler.obtainMessage(11, zzkyArr).sendToTarget();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|23|20|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x001f, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(com.google.android.gms.internal.ads.zzky... r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzacf     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x000e
            java.lang.String r4 = "ExoPlayerImplInternal"
            java.lang.String r0 = "Ignoring messages sent after release."
            android.util.Log.w(r4, r0)     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)
            return
        L_0x000e:
            int r0 = r3.zzach     // Catch:{ all -> 0x0031 }
            int r1 = r0 + 1
            r3.zzach = r1     // Catch:{ all -> 0x0031 }
            android.os.Handler r1 = r3.handler     // Catch:{ all -> 0x0031 }
            r2 = 11
            android.os.Message r4 = r1.obtainMessage(r2, r4)     // Catch:{ all -> 0x0031 }
            r4.sendToTarget()     // Catch:{ all -> 0x0031 }
        L_0x001f:
            int r4 = r3.zzaci     // Catch:{ all -> 0x0031 }
            if (r4 > r0) goto L_0x002f
            r3.wait()     // Catch:{ InterruptedException -> 0x0027 }
            goto L_0x001f
        L_0x0027:
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0031 }
            r4.interrupt()     // Catch:{ all -> 0x0031 }
            goto L_0x001f
        L_0x002f:
            monitor-exit(r3)
            return
        L_0x0031:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlc.zzb(com.google.android.gms.internal.ads.zzky[]):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|12|13|23|20|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x000d, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void release() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzacf     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            android.os.Handler r0 = r2.handler     // Catch:{ all -> 0x0024 }
            r1 = 6
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x0024 }
        L_0x000d:
            boolean r0 = r2.zzacf     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x001d
            r2.wait()     // Catch:{ InterruptedException -> 0x0015 }
            goto L_0x000d
        L_0x0015:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0024 }
            r0.interrupt()     // Catch:{ all -> 0x0024 }
            goto L_0x000d
        L_0x001d:
            android.os.HandlerThread r0 = r2.zzaby     // Catch:{ all -> 0x0024 }
            r0.quit()     // Catch:{ all -> 0x0024 }
            monitor-exit(r2)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlc.release():void");
    }

    public final void zzb(zzlr zzlr, Object obj) {
        this.handler.obtainMessage(7, Pair.create(zzlr, obj)).sendToTarget();
    }

    public final void zza(zzqj zzqj) {
        this.handler.obtainMessage(8, zzqj).sendToTarget();
    }

    public final void zzgv() {
        this.handler.sendEmptyMessage(10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:216:0x038d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x0450, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0451, code lost:
        r2 = r0;
        r8.zzasd = new com.google.android.gms.internal.ads.zzle(r3, r4);
        r8.zzabq.obtainMessage(4, r1, 0, r8.zzasd).sendToTarget();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0464, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:495:0x08ad, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:496:0x08ae, code lost:
        r1 = r0;
        r3 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:497:0x08b2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:498:0x08b3, code lost:
        r1 = r0;
        r3 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:499:0x08b7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:500:0x08b8, code lost:
        r1 = r0;
        android.util.Log.e("ExoPlayerImplInternal", "Internal runtime error.", r1);
        r8.zzabq.obtainMessage(8, com.google.android.gms.internal.ads.zzku.zza(r1)).sendToTarget();
        zzds();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:501:0x08d2, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00c8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00cc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00cd, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00ce, code lost:
        monitor-enter(r34);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r8.zzaci++;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00d9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0290 A[Catch:{ all -> 0x0450, all -> 0x038d, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0293 A[Catch:{ all -> 0x0450, all -> 0x038d, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0297 A[Catch:{ all -> 0x0450, all -> 0x038d, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0359 A[Catch:{ all -> 0x0450, all -> 0x038d, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x036d A[Catch:{ all -> 0x0450, all -> 0x038d, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0531 A[Catch:{ all -> 0x0450, all -> 0x038d, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0538 A[Catch:{ all -> 0x0450, all -> 0x038d, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0553 A[Catch:{ all -> 0x0450, all -> 0x038d, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x0556 A[Catch:{ all -> 0x0450, all -> 0x038d, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0591 A[Catch:{ all -> 0x0450, all -> 0x038d, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x05a5 A[Catch:{ all -> 0x0450, all -> 0x038d, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x05c1 A[Catch:{ all -> 0x0450, all -> 0x038d, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }, LOOP:8: B:323:0x05c1->B:327:0x05d3, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x0723 A[Catch:{ all -> 0x0450, all -> 0x038d, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x07dd A[Catch:{ all -> 0x0450, all -> 0x038d, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:499:0x08b7 A[ExcHandler: RuntimeException (r0v2 'e' java.lang.RuntimeException A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r35) {
        /*
            r34 = this;
            r8 = r34
            r1 = r35
            r10 = 1
            int r2 = r1.what     // Catch:{ zzku -> 0x08ef, IOException -> 0x08d3, RuntimeException -> 0x08b7 }
            r11 = 7
            r3 = 0
            r14 = 3
            r5 = -1
            r6 = 0
            r15 = 4
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 2
            r9 = 0
            switch(r2) {
                case 0: goto L_0x0876;
                case 1: goto L_0x0849;
                case 2: goto L_0x0465;
                case 3: goto L_0x03b6;
                case 4: goto L_0x0395;
                case 5: goto L_0x0391;
                case 6: goto L_0x037a;
                case 7: goto L_0x021c;
                case 8: goto L_0x01e6;
                case 9: goto L_0x01d3;
                case 10: goto L_0x00dd;
                case 11: goto L_0x009f;
                case 12: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            return r9
        L_0x0019:
            int r1 = r1.arg1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.repeatMode = r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r2 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzld r2 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x0026
        L_0x0024:
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0026:
            if (r2 == 0) goto L_0x009e
            com.google.android.gms.internal.ads.zzld r3 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 != r3) goto L_0x002e
            r3 = 1
            goto L_0x002f
        L_0x002e:
            r3 = 0
        L_0x002f:
            com.google.android.gms.internal.ads.zzld r4 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 != r4) goto L_0x0037
            r4 = r3
            r3 = r2
            r2 = 1
            goto L_0x003a
        L_0x0037:
            r4 = r3
            r3 = r2
            r2 = 0
        L_0x003a:
            com.google.android.gms.internal.ads.zzlr r11 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r12 = r3.zzatb     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r13 = r8.zzart     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlu r14 = r8.zzars     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r11 = r11.zza((int) r12, (com.google.android.gms.internal.ads.zzlt) r13, (com.google.android.gms.internal.ads.zzlu) r14, (int) r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r12 = r3.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r12 == 0) goto L_0x0065
            if (r11 == r5) goto L_0x0065
            com.google.android.gms.internal.ads.zzld r12 = r3.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r12 = r12.zzatb     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r12 != r11) goto L_0x0065
            com.google.android.gms.internal.ads.zzld r3 = r3.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r11 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r3 != r11) goto L_0x005a
            r11 = 1
            goto L_0x005b
        L_0x005a:
            r11 = 0
        L_0x005b:
            r4 = r4 | r11
            com.google.android.gms.internal.ads.zzld r11 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r3 != r11) goto L_0x0062
            r11 = 1
            goto L_0x0063
        L_0x0062:
            r11 = 0
        L_0x0063:
            r2 = r2 | r11
            goto L_0x003a
        L_0x0065:
            com.google.android.gms.internal.ads.zzld r5 = r3.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r5 == 0) goto L_0x0070
            com.google.android.gms.internal.ads.zzld r5 = r3.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            zza((com.google.android.gms.internal.ads.zzld) r5)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r3.zzatf = r6     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0070:
            int r5 = r3.zzatb     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            boolean r5 = r8.zzad(r5)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r3.zzatd = r5     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 != 0) goto L_0x007c
            r8.zzast = r3     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x007c:
            if (r4 != 0) goto L_0x0095
            com.google.android.gms.internal.ads.zzld r2 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 == 0) goto L_0x0095
            com.google.android.gms.internal.ads.zzld r2 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r2.zzatb     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzle r3 = r8.zzasd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r3 = r3.zzacl     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r3 = r8.zzd(r2, r3)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzle r5 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r5.<init>(r2, r3)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasd = r5     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0095:
            int r2 = r8.state     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 != r15) goto L_0x009e
            if (r1 == 0) goto L_0x009e
            r8.setState(r7)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x009e:
            return r10
        L_0x009f:
            java.lang.Object r1 = r1.obj     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzky[] r1 = (com.google.android.gms.internal.ads.zzky[]) r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r1.length     // Catch:{ all -> 0x00cc }
        L_0x00a4:
            if (r9 >= r2) goto L_0x00b4
            r3 = r1[r9]     // Catch:{ all -> 0x00cc }
            com.google.android.gms.internal.ads.zzkx r4 = r3.zzarl     // Catch:{ all -> 0x00cc }
            int r5 = r3.zzarm     // Catch:{ all -> 0x00cc }
            java.lang.Object r3 = r3.zzarn     // Catch:{ all -> 0x00cc }
            r4.zza(r5, r3)     // Catch:{ all -> 0x00cc }
            int r9 = r9 + 1
            goto L_0x00a4
        L_0x00b4:
            com.google.android.gms.internal.ads.zzql r1 = r8.zzaso     // Catch:{ all -> 0x00cc }
            if (r1 == 0) goto L_0x00bd
            android.os.Handler r1 = r8.handler     // Catch:{ all -> 0x00cc }
            r1.sendEmptyMessage(r7)     // Catch:{ all -> 0x00cc }
        L_0x00bd:
            monitor-enter(r34)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r1 = r8.zzaci     // Catch:{ all -> 0x00c8 }
            int r1 = r1 + r10
            r8.zzaci = r1     // Catch:{ all -> 0x00c8 }
            r34.notifyAll()     // Catch:{ all -> 0x00c8 }
            monitor-exit(r34)     // Catch:{ all -> 0x00c8 }
            return r10
        L_0x00c8:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x00c8 }
            throw r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x00cc:
            r0 = move-exception
            r1 = r0
            monitor-enter(r34)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r8.zzaci     // Catch:{ all -> 0x00d9 }
            int r2 = r2 + r10
            r8.zzaci = r2     // Catch:{ all -> 0x00d9 }
            r34.notifyAll()     // Catch:{ all -> 0x00d9 }
            monitor-exit(r34)     // Catch:{ all -> 0x00d9 }
            throw r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x00d9:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x00d9 }
            throw r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x00dd:
            com.google.android.gms.internal.ads.zzld r1 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x01d2
            com.google.android.gms.internal.ads.zzld r1 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2 = 1
        L_0x00e4:
            if (r1 == 0) goto L_0x01d2
            boolean r3 = r1.zzacs     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r3 != 0) goto L_0x00ec
            goto L_0x01d2
        L_0x00ec:
            boolean r3 = r1.zzhb()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r3 != 0) goto L_0x00fa
            com.google.android.gms.internal.ads.zzld r3 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 != r3) goto L_0x00f7
            r2 = 0
        L_0x00f7:
            com.google.android.gms.internal.ads.zzld r1 = r1.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x00e4
        L_0x00fa:
            if (r2 == 0) goto L_0x0198
            com.google.android.gms.internal.ads.zzld r2 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r3 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 == r3) goto L_0x0104
            r2 = 1
            goto L_0x0105
        L_0x0104:
            r2 = 0
        L_0x0105:
            com.google.android.gms.internal.ads.zzld r3 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r3 = r3.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            zza((com.google.android.gms.internal.ads.zzld) r3)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r3 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r3.zzatf = r6     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r3 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzast = r3     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r3 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasu = r3     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlo[] r3 = r8.zzaro     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r3 = r3.length     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            boolean[] r3 = new boolean[r3]     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r4 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzle r5 = r8.zzasd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r11 = r5.zzacl     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r4 = r4.zza(r11, r2, r3)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzle r2 = r8.zzasd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r11 = r2.zzacl     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x0136
            com.google.android.gms.internal.ads.zzle r2 = r8.zzasd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2.zzacl = r4     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzeb(r4)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0136:
            com.google.android.gms.internal.ads.zzlo[] r2 = r8.zzaro     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r2.length     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            boolean[] r2 = new boolean[r2]     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r4 = 0
            r5 = 0
        L_0x013d:
            com.google.android.gms.internal.ads.zzlo[] r11 = r8.zzaro     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r11 = r11.length     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r4 >= r11) goto L_0x0189
            com.google.android.gms.internal.ads.zzlo[] r11 = r8.zzaro     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r11 = r11[r4]     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r12 = r11.getState()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r12 == 0) goto L_0x014e
            r12 = 1
            goto L_0x014f
        L_0x014e:
            r12 = 0
        L_0x014f:
            r2[r4] = r12     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r12 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzqw[] r12 = r12.zzasy     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r12 = r12[r4]     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r12 == 0) goto L_0x015b
            int r5 = r5 + 1
        L_0x015b:
            boolean r13 = r2[r4]     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r13 == 0) goto L_0x0186
            com.google.android.gms.internal.ads.zzqw r13 = r11.zzgk()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r12 == r13) goto L_0x017d
            com.google.android.gms.internal.ads.zzlo r13 = r8.zzasm     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r11 != r13) goto L_0x0176
            if (r12 != 0) goto L_0x0172
            com.google.android.gms.internal.ads.zzsw r12 = r8.zzask     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzso r13 = r8.zzasn     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r12.zza(r13)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0172:
            r8.zzasn = r6     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasm = r6     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0176:
            zza((com.google.android.gms.internal.ads.zzlo) r11)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r11.disable()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x0186
        L_0x017d:
            boolean r12 = r3[r4]     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r12 == 0) goto L_0x0186
            long r12 = r8.zzass     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r11.zzdx(r12)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0186:
            int r4 = r4 + 1
            goto L_0x013d
        L_0x0189:
            android.os.Handler r3 = r8.zzabq     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzrr r1 = r1.zzatg     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.os.Message r1 = r3.obtainMessage(r14, r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.sendToTarget()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zza((boolean[]) r2, (int) r5)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x01c7
        L_0x0198:
            r8.zzast = r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r1 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r1 = r1.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x019e:
            if (r1 == 0) goto L_0x01a6
            r1.release()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r1 = r1.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x019e
        L_0x01a6:
            com.google.android.gms.internal.ads.zzld r1 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.zzatf = r6     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r1 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            boolean r1 = r1.zzacs     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x01c7
            com.google.android.gms.internal.ads.zzld r1 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r1 = r1.zzatc     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r3 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r4 = r8.zzass     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r11 = r3.zzgz()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r3 = 0
            long r4 = r4 - r11
            long r1 = java.lang.Math.max(r1, r4)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r3 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r3.zze(r1, r9)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x01c7:
            r34.zzgy()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r34.zzgw()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.os.Handler r1 = r8.handler     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.sendEmptyMessage(r7)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x01d2:
            return r10
        L_0x01d3:
            java.lang.Object r1 = r1.obj     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzqj r1 = (com.google.android.gms.internal.ads.zzqj) r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 == 0) goto L_0x01e5
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzqj r2 = r2.zzasw     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 == r1) goto L_0x01e2
            goto L_0x01e5
        L_0x01e2:
            r34.zzgy()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x01e5:
            return r10
        L_0x01e6:
            java.lang.Object r1 = r1.obj     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzqj r1 = (com.google.android.gms.internal.ads.zzqj) r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 == 0) goto L_0x021b
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzqj r2 = r2.zzasw     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 == r1) goto L_0x01f5
            goto L_0x021b
        L_0x01f5:
            com.google.android.gms.internal.ads.zzld r1 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.zzacs = r10     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.zzhb()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r2 = r1.zzatc     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r2 = r1.zze(r2, r9)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.zzatc = r2     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r1 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 != 0) goto L_0x0218
            com.google.android.gms.internal.ads.zzld r1 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasu = r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r1 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r1 = r1.zzatc     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzeb(r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r1 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzb((com.google.android.gms.internal.ads.zzld) r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0218:
            r34.zzgy()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x021b:
            return r10
        L_0x021c:
            java.lang.Object r1 = r1.obj     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.util.Pair r1 = (android.util.Pair) r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlr r2 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Object r3 = r1.first     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlr r3 = (com.google.android.gms.internal.ads.zzlr) r3     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzary = r3     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Object r1 = r1.second     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 != 0) goto L_0x028b
            int r3 = r8.zzasq     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r3 <= 0) goto L_0x025b
            com.google.android.gms.internal.ads.zzlf r3 = r8.zzasr     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.util.Pair r3 = r8.zza((com.google.android.gms.internal.ads.zzlf) r3)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r4 = r8.zzasq     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasq = r9     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasr = r6     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r3 != 0) goto L_0x0243
            r8.zza((java.lang.Object) r1, (int) r4)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x0379
        L_0x0243:
            com.google.android.gms.internal.ads.zzle r7 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Object r11 = r3.first     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r11 = r11.intValue()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Object r3 = r3.second     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r14 = r3.longValue()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r7.<init>(r11, r14)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasd = r7     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x028c
        L_0x025b:
            com.google.android.gms.internal.ads.zzle r3 = r8.zzasd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r3 = r3.zzatc     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r3 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r3 != 0) goto L_0x028b
            com.google.android.gms.internal.ads.zzlr r3 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            boolean r3 = r3.isEmpty()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r3 == 0) goto L_0x0270
            r8.zza((java.lang.Object) r1, (int) r9)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x0379
        L_0x0270:
            android.util.Pair r3 = r8.zze(r9, r12)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzle r4 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Object r7 = r3.first     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r7 = r7.intValue()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Object r3 = r3.second     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r14 = r3.longValue()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r4.<init>(r7, r14)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasd = r4     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x028b:
            r4 = 0
        L_0x028c:
            com.google.android.gms.internal.ads.zzld r3 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r3 == 0) goto L_0x0293
            com.google.android.gms.internal.ads.zzld r3 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x0295
        L_0x0293:
            com.google.android.gms.internal.ads.zzld r3 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0295:
            if (r3 == 0) goto L_0x0376
            com.google.android.gms.internal.ads.zzlr r7 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Object r11 = r3.zzasx     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r7 = r7.zzc(r11)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r7 != r5) goto L_0x02f9
            int r6 = r3.zzatb     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlr r7 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r8.zza((int) r6, (com.google.android.gms.internal.ads.zzlr) r2, (com.google.android.gms.internal.ads.zzlr) r7)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 != r5) goto L_0x02b0
            r8.zza((java.lang.Object) r1, (int) r4)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x0379
        L_0x02b0:
            com.google.android.gms.internal.ads.zzlr r6 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r7 = r8.zzart     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r6.zza((int) r2, (com.google.android.gms.internal.ads.zzlt) r7, (boolean) r9)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.util.Pair r2 = r8.zze(r9, r12)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Object r6 = r2.first     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r6 = r6.intValue()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Object r2 = r2.second     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r11 = r2.longValue()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlr r2 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r7 = r8.zzart     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2.zza((int) r6, (com.google.android.gms.internal.ads.zzlt) r7, (boolean) r10)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r2 = r8.zzart     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Object r2 = r2.zzasx     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r3.zzatb = r5     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x02d8:
            com.google.android.gms.internal.ads.zzld r7 = r3.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r7 == 0) goto L_0x02ec
            com.google.android.gms.internal.ads.zzld r3 = r3.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Object r7 = r3.zzasx     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            boolean r7 = r7.equals(r2)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r7 == 0) goto L_0x02e8
            r7 = r6
            goto L_0x02e9
        L_0x02e8:
            r7 = -1
        L_0x02e9:
            r3.zzatb = r7     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x02d8
        L_0x02ec:
            long r2 = r8.zzd(r6, r11)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzle r5 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r5.<init>(r6, r2)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasd = r5     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x0376
        L_0x02f9:
            boolean r2 = r8.zzad(r7)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r3.zzd(r7, r2)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r2 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r3 != r2) goto L_0x0306
            r2 = 1
            goto L_0x0307
        L_0x0306:
            r2 = 0
        L_0x0307:
            com.google.android.gms.internal.ads.zzle r11 = r8.zzasd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r11 = r11.zzatb     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r7 == r11) goto L_0x0320
            com.google.android.gms.internal.ads.zzle r11 = r8.zzasd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzle r12 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r13 = r11.zzatc     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r12.<init>(r7, r13)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r13 = r11.zzacl     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r12.zzacl = r13     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r13 = r11.zzacm     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r12.zzacm = r13     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasd = r12     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0320:
            com.google.android.gms.internal.ads.zzld r11 = r3.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r11 == 0) goto L_0x0376
            com.google.android.gms.internal.ads.zzld r11 = r3.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlr r12 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r13 = r8.zzart     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlu r14 = r8.zzars     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r15 = r8.repeatMode     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r7 = r12.zza((int) r7, (com.google.android.gms.internal.ads.zzlt) r13, (com.google.android.gms.internal.ads.zzlu) r14, (int) r15)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r7 == r5) goto L_0x0357
            java.lang.Object r12 = r11.zzasx     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlr r13 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r14 = r8.zzart     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r13 = r13.zza((int) r7, (com.google.android.gms.internal.ads.zzlt) r14, (boolean) r10)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Object r13 = r13.zzasx     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            boolean r12 = r12.equals(r13)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r12 == 0) goto L_0x0357
            boolean r3 = r8.zzad(r7)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r11.zzd(r7, r3)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r3 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r11 != r3) goto L_0x0353
            r3 = 1
            goto L_0x0354
        L_0x0353:
            r3 = 0
        L_0x0354:
            r2 = r2 | r3
            r3 = r11
            goto L_0x0320
        L_0x0357:
            if (r2 != 0) goto L_0x036d
            com.google.android.gms.internal.ads.zzld r2 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r2.zzatb     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzle r3 = r8.zzasd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r5 = r3.zzacl     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r5 = r8.zzd(r2, r5)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzle r3 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r3.<init>(r2, r5)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasd = r3     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x0376
        L_0x036d:
            r8.zzast = r3     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2.zzatf = r6     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            zza((com.google.android.gms.internal.ads.zzld) r11)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0376:
            r8.zzb((java.lang.Object) r1, (int) r4)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0379:
            return r10
        L_0x037a:
            r8.zzj(r10)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzll r1 = r8.zzasj     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.zzee()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.setState(r10)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            monitor-enter(r34)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzacf = r10     // Catch:{ all -> 0x038d }
            r34.notifyAll()     // Catch:{ all -> 0x038d }
            monitor-exit(r34)     // Catch:{ all -> 0x038d }
            return r10
        L_0x038d:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x038d }
            throw r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0391:
            r34.zzds()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            return r10
        L_0x0395:
            java.lang.Object r1 = r1.obj     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzln r1 = (com.google.android.gms.internal.ads.zzln) r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzso r2 = r8.zzasn     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 == 0) goto L_0x03a4
            com.google.android.gms.internal.ads.zzso r2 = r8.zzasn     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzln r1 = r2.zzb(r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x03aa
        L_0x03a4:
            com.google.android.gms.internal.ads.zzsw r2 = r8.zzask     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzln r1 = r2.zzb(r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x03aa:
            r8.zzasc = r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.os.Handler r2 = r8.zzabq     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.os.Message r1 = r2.obtainMessage(r11, r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.sendToTarget()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            return r10
        L_0x03b6:
            java.lang.Object r1 = r1.obj     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlf r1 = (com.google.android.gms.internal.ads.zzlf) r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlr r2 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 != 0) goto L_0x03c7
            int r2 = r8.zzasq     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r2 + r10
            r8.zzasq = r2     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasr = r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x044f
        L_0x03c7:
            android.util.Pair r2 = r8.zza((com.google.android.gms.internal.ads.zzlf) r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 != 0) goto L_0x03ed
            com.google.android.gms.internal.ads.zzle r1 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.<init>(r9, r3)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasd = r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.os.Handler r1 = r8.zzabq     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzle r2 = r8.zzasd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.os.Message r1 = r1.obtainMessage(r15, r10, r9, r2)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.sendToTarget()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzle r1 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.<init>(r9, r12)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasd = r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.setState(r15)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzj(r9)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x044f
        L_0x03ed:
            long r3 = r1.zzatj     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r1 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x03f5
            r1 = 1
            goto L_0x03f6
        L_0x03f5:
            r1 = 0
        L_0x03f6:
            java.lang.Object r3 = r2.first     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r3 = r3.intValue()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Object r2 = r2.second     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r4 = r2.longValue()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzle r2 = r8.zzasd     // Catch:{ all -> 0x0450 }
            int r2 = r2.zzatb     // Catch:{ all -> 0x0450 }
            if (r3 != r2) goto L_0x042c
            r6 = 1000(0x3e8, double:4.94E-321)
            long r11 = r4 / r6
            com.google.android.gms.internal.ads.zzle r2 = r8.zzasd     // Catch:{ all -> 0x0450 }
            long r13 = r2.zzacl     // Catch:{ all -> 0x0450 }
            long r13 = r13 / r6
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x042c
            com.google.android.gms.internal.ads.zzle r2 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2.<init>(r3, r4)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasd = r2     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.os.Handler r2 = r8.zzabq     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzle r3 = r8.zzasd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.os.Message r1 = r2.obtainMessage(r15, r1, r9, r3)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.sendToTarget()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x044f
        L_0x042c:
            long r6 = r8.zzd(r3, r4)     // Catch:{ all -> 0x0450 }
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0436
            r2 = 1
            goto L_0x0437
        L_0x0436:
            r2 = 0
        L_0x0437:
            r1 = r1 | r2
            com.google.android.gms.internal.ads.zzle r2 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2.<init>(r3, r6)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasd = r2     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.os.Handler r2 = r8.zzabq     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x0445
            r1 = 1
            goto L_0x0446
        L_0x0445:
            r1 = 0
        L_0x0446:
            com.google.android.gms.internal.ads.zzle r3 = r8.zzasd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.os.Message r1 = r2.obtainMessage(r15, r1, r9, r3)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.sendToTarget()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x044f:
            return r10
        L_0x0450:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.ads.zzle r6 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r6.<init>(r3, r4)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasd = r6     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.os.Handler r3 = r8.zzabq     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzle r4 = r8.zzasd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r4)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.sendToTarget()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            throw r2     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0465:
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlr r1 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 != 0) goto L_0x0475
            com.google.android.gms.internal.ads.zzql r1 = r8.zzaso     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.zzjf()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r14 = r5
            goto L_0x06d4
        L_0x0475:
            com.google.android.gms.internal.ads.zzld r1 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 != 0) goto L_0x047e
            com.google.android.gms.internal.ads.zzle r1 = r8.zzasd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r1 = r1.zzatb     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x04bc
        L_0x047e:
            com.google.android.gms.internal.ads.zzld r1 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r1 = r1.zzatb     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            boolean r2 = r2.zzatd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 != 0) goto L_0x04c9
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            boolean r2 = r2.zzha()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 == 0) goto L_0x04c9
            com.google.android.gms.internal.ads.zzlr r2 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r7 = r8.zzart     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r2 = r2.zza((int) r1, (com.google.android.gms.internal.ads.zzlt) r7, (boolean) r9)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r14 = r2.zzack     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x049f
            goto L_0x04c9
        L_0x049f:
            com.google.android.gms.internal.ads.zzld r2 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 == 0) goto L_0x04b0
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r2.index     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r7 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r7 = r7.index     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r2 - r7
            r7 = 100
            if (r2 == r7) goto L_0x04c9
        L_0x04b0:
            com.google.android.gms.internal.ads.zzlr r2 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r7 = r8.zzart     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlu r14 = r8.zzars     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r15 = r8.repeatMode     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r1 = r2.zza((int) r1, (com.google.android.gms.internal.ads.zzlt) r7, (com.google.android.gms.internal.ads.zzlu) r14, (int) r15)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x04bc:
            com.google.android.gms.internal.ads.zzlr r2 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r2.zzhg()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 < r2) goto L_0x04cc
            com.google.android.gms.internal.ads.zzql r1 = r8.zzaso     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.zzjf()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x04c9:
            r14 = r5
            goto L_0x05a1
        L_0x04cc:
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 != 0) goto L_0x04d6
            com.google.android.gms.internal.ads.zzle r2 = r8.zzasd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r3 = r2.zzacl     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x04d4:
            r14 = r5
            goto L_0x052d
        L_0x04d6:
            com.google.android.gms.internal.ads.zzlr r2 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r7 = r8.zzart     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2.zza((int) r1, (com.google.android.gms.internal.ads.zzlt) r7, (boolean) r9)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlr r2 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlu r7 = r8.zzars     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2.zza((int) r9, (com.google.android.gms.internal.ads.zzlu) r7, (boolean) r9)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x04e7
            goto L_0x04d4
        L_0x04e7:
            com.google.android.gms.internal.ads.zzld r1 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r1 = r1.zzgz()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlr r7 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r14 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r14 = r14.zzatb     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r15 = r8.zzart     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r7 = r7.zza((int) r14, (com.google.android.gms.internal.ads.zzlt) r15, (boolean) r9)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r14 = r7.zzack     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r7 = 0
            long r1 = r1 + r14
            long r14 = r8.zzass     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r7 = 0
            long r1 = r1 - r14
            com.google.android.gms.internal.ads.zzlr r7 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r14 = 0
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r18 = java.lang.Math.max(r3, r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1 = r34
            r2 = r7
            r3 = r14
            r14 = r5
            r4 = r16
            r6 = r18
            android.util.Pair r1 = r1.zza(r2, r3, r4, r6)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x05a1
            java.lang.Object r2 = r1.first     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r2.intValue()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Object r1 = r1.second     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r3 = r1.longValue()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1 = r2
        L_0x052d:
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 != 0) goto L_0x0538
            r5 = 60000000(0x3938700, double:2.96439388E-316)
            long r5 = r5 + r3
        L_0x0535:
            r23 = r5
            goto L_0x054f
        L_0x0538:
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r5 = r2.zzgz()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlr r2 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r7 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r7 = r7.zzatb     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r11 = r8.zzart     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r2 = r2.zza((int) r7, (com.google.android.gms.internal.ads.zzlt) r11, (boolean) r9)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r12 = r2.zzack     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2 = 0
            long r5 = r5 + r12
            goto L_0x0535
        L_0x054f:
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 != 0) goto L_0x0556
            r29 = 0
            goto L_0x055d
        L_0x0556:
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r2.index     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r2 + r10
            r29 = r2
        L_0x055d:
            boolean r31 = r8.zzad(r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlr r2 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r5 = r8.zzart     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2.zza((int) r1, (com.google.android.gms.internal.ads.zzlt) r5, (boolean) r10)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r2 = new com.google.android.gms.internal.ads.zzld     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlo[] r5 = r8.zzaro     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlp[] r6 = r8.zzasi     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzrp r7 = r8.zzarp     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzll r11 = r8.zzasj     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzql r12 = r8.zzaso     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r13 = r8.zzart     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            java.lang.Object r13 = r13.zzasx     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r20 = r2
            r21 = r5
            r22 = r6
            r25 = r7
            r26 = r11
            r27 = r12
            r28 = r13
            r30 = r1
            r32 = r3
            r20.<init>(r21, r22, r23, r25, r26, r27, r28, r29, r30, r31, r32)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r1 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x0595
            com.google.android.gms.internal.ads.zzld r1 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.zzatf = r2     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0595:
            r8.zzast = r2     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r1 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzqj r1 = r1.zzasw     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.zza(r8, r3)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzi(r10)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x05a1:
            com.google.android.gms.internal.ads.zzld r1 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x05ba
            com.google.android.gms.internal.ads.zzld r1 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            boolean r1 = r1.zzha()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x05ae
            goto L_0x05ba
        L_0x05ae:
            com.google.android.gms.internal.ads.zzld r1 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x05bd
            boolean r1 = r8.zzarx     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 != 0) goto L_0x05bd
            r34.zzgy()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x05bd
        L_0x05ba:
            r8.zzi(r9)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x05bd:
            com.google.android.gms.internal.ads.zzld r1 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x06d4
        L_0x05c1:
            com.google.android.gms.internal.ads.zzld r1 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r2 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == r2) goto L_0x05fe
            long r1 = r8.zzass     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r3 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r3 = r3.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r3 = r3.zzata     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x05fe
            com.google.android.gms.internal.ads.zzld r1 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.release()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r1 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r1 = r1.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzb((com.google.android.gms.internal.ads.zzld) r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzle r1 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r2 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r2.zzatb     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r3 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r3 = r3.zzatc     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.<init>(r2, r3)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasd = r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r34.zzgw()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.os.Handler r1 = r8.zzabq     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2 = 5
            com.google.android.gms.internal.ads.zzle r3 = r8.zzasd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.os.Message r1 = r1.obtainMessage(r2, r3)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.sendToTarget()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x05c1
        L_0x05fe:
            com.google.android.gms.internal.ads.zzld r1 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            boolean r1 = r1.zzatd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x0628
            r1 = 0
        L_0x0605:
            com.google.android.gms.internal.ads.zzlo[] r2 = r8.zzaro     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r2.length     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 >= r2) goto L_0x06d4
            com.google.android.gms.internal.ads.zzlo[] r2 = r8.zzaro     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2 = r2[r1]     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r3 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzqw[] r3 = r3.zzasy     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r3 = r3[r1]     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r3 == 0) goto L_0x0625
            com.google.android.gms.internal.ads.zzqw r4 = r2.zzgk()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r4 != r3) goto L_0x0625
            boolean r3 = r2.zzgl()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r3 == 0) goto L_0x0625
            r2.zzgm()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0625:
            int r1 = r1 + 1
            goto L_0x0605
        L_0x0628:
            r1 = 0
        L_0x0629:
            com.google.android.gms.internal.ads.zzlo[] r2 = r8.zzaro     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r2.length     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 >= r2) goto L_0x064b
            com.google.android.gms.internal.ads.zzlo[] r2 = r8.zzaro     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2 = r2[r1]     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r3 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzqw[] r3 = r3.zzasy     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r3 = r3[r1]     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzqw r4 = r2.zzgk()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r4 != r3) goto L_0x06d4
            if (r3 == 0) goto L_0x0648
            boolean r2 = r2.zzgl()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 != 0) goto L_0x0648
            goto L_0x06d4
        L_0x0648:
            int r1 = r1 + 1
            goto L_0x0629
        L_0x064b:
            com.google.android.gms.internal.ads.zzld r1 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r1 = r1.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x06d4
            com.google.android.gms.internal.ads.zzld r1 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r1 = r1.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            boolean r1 = r1.zzacs     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x06d4
            com.google.android.gms.internal.ads.zzld r1 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzrr r1 = r1.zzatg     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r2 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r2 = r2.zzatf     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasu = r2     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r2 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzrr r2 = r2.zzatg     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r3 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzqj r3 = r3.zzasw     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r3 = r3.zzja()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x067a
            r3 = 1
            goto L_0x067b
        L_0x067a:
            r3 = 0
        L_0x067b:
            r4 = 0
        L_0x067c:
            com.google.android.gms.internal.ads.zzlo[] r5 = r8.zzaro     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r5 = r5.length     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r4 >= r5) goto L_0x06d4
            com.google.android.gms.internal.ads.zzlo[] r5 = r8.zzaro     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r5 = r5[r4]     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzro r6 = r1.zzblz     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzrm r6 = r6.zzbi(r4)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r6 == 0) goto L_0x06d1
            if (r3 != 0) goto L_0x06ce
            boolean r6 = r5.zzgn()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r6 != 0) goto L_0x06d1
            com.google.android.gms.internal.ads.zzro r6 = r2.zzblz     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzrm r6 = r6.zzbi(r4)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlq[] r7 = r1.zzbmb     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r7 = r7[r4]     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlq[] r11 = r2.zzbmb     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r11 = r11[r4]     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r6 == 0) goto L_0x06ce
            boolean r7 = r11.equals(r7)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r7 == 0) goto L_0x06ce
            int r7 = r6.length()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlh[] r7 = new com.google.android.gms.internal.ads.zzlh[r7]     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r11 = 0
        L_0x06b2:
            int r12 = r7.length     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r11 >= r12) goto L_0x06be
            com.google.android.gms.internal.ads.zzlh r12 = r6.zzbf(r11)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r7[r11] = r12     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r11 = r11 + 1
            goto L_0x06b2
        L_0x06be:
            com.google.android.gms.internal.ads.zzld r6 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzqw[] r6 = r6.zzasy     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r6 = r6[r4]     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r11 = r8.zzasu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r11 = r11.zzgz()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r5.zza(r7, r6, r11)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x06d1
        L_0x06ce:
            r5.zzgm()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x06d1:
            int r4 = r4 + 1
            goto L_0x067c
        L_0x06d4:
            com.google.android.gms.internal.ads.zzld r1 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2 = 10
            if (r1 != 0) goto L_0x06e2
            r34.zzgx()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzb((long) r14, (long) r2)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x0848
        L_0x06e2:
            java.lang.String r1 = "doSomeWork"
            com.google.android.gms.internal.ads.zzsx.beginSection(r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r34.zzgw()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r1 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzqj r1 = r1.zzasw     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzle r4 = r8.zzasd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r4 = r4.zzacl     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.zzem(r4)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlo[] r1 = r8.zzasp     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r4 = r1.length     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r5 = 0
            r6 = 1
            r7 = 1
        L_0x06fb:
            if (r5 >= r4) goto L_0x0732
            r11 = r1[r5]     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r12 = r8.zzass     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r2 = r8.zzacj     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r11.zzc(r12, r2)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r7 == 0) goto L_0x0710
            boolean r2 = r11.zzdx()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 == 0) goto L_0x0710
            r7 = 1
            goto L_0x0711
        L_0x0710:
            r7 = 0
        L_0x0711:
            boolean r2 = r11.isReady()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 != 0) goto L_0x0720
            boolean r2 = r11.zzdx()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 == 0) goto L_0x071e
            goto L_0x0720
        L_0x071e:
            r2 = 0
            goto L_0x0721
        L_0x0720:
            r2 = 1
        L_0x0721:
            if (r2 != 0) goto L_0x0726
            r11.zzgo()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0726:
            if (r6 == 0) goto L_0x072c
            if (r2 == 0) goto L_0x072c
            r6 = 1
            goto L_0x072d
        L_0x072c:
            r6 = 0
        L_0x072d:
            int r5 = r5 + 1
            r2 = 10
            goto L_0x06fb
        L_0x0732:
            if (r6 != 0) goto L_0x0737
            r34.zzgx()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0737:
            com.google.android.gms.internal.ads.zzso r1 = r8.zzasn     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x075c
            com.google.android.gms.internal.ads.zzso r1 = r8.zzasn     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzln r1 = r1.zzhq()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzln r2 = r8.zzasc     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            boolean r2 = r1.equals(r2)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 != 0) goto L_0x075c
            r8.zzasc = r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzsw r2 = r8.zzask     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzso r3 = r8.zzasn     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2.zza(r3)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.os.Handler r2 = r8.zzabq     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r3 = 7
            android.os.Message r1 = r2.obtainMessage(r3, r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.sendToTarget()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x075c:
            com.google.android.gms.internal.ads.zzlr r1 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r2 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r2.zzatb     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r3 = r8.zzart     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r1 = r1.zza((int) r2, (com.google.android.gms.internal.ads.zzlt) r3, (boolean) r9)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r1 = r1.zzack     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r7 == 0) goto L_0x078d
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x077d
            com.google.android.gms.internal.ads.zzle r3 = r8.zzasd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r3 = r3.zzacl     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x078d
        L_0x077d:
            com.google.android.gms.internal.ads.zzld r3 = r8.zzasv     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            boolean r3 = r3.zzatd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r3 == 0) goto L_0x078d
            r3 = 4
            r8.setState(r3)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r34.zzdq()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r4 = 2
            goto L_0x080e
        L_0x078d:
            int r3 = r8.state     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r4 = 2
            if (r3 != r4) goto L_0x07f3
            com.google.android.gms.internal.ads.zzlo[] r3 = r8.zzasp     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r3 = r3.length     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r3 <= 0) goto L_0x07e1
            if (r6 == 0) goto L_0x07df
            boolean r1 = r8.zzacg     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            boolean r2 = r2.zzacs     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 != 0) goto L_0x07a6
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r2 = r2.zzatc     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x07ae
        L_0x07a6:
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzqj r2 = r2.zzasw     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r2 = r2.zzdu()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x07ae:
            r5 = -9223372036854775808
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x07ca
            com.google.android.gms.internal.ads.zzld r2 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            boolean r2 = r2.zzatd     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r2 == 0) goto L_0x07bc
            r1 = 1
            goto L_0x07db
        L_0x07bc:
            com.google.android.gms.internal.ads.zzlr r2 = r8.zzary     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r3 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r3 = r3.zzatb     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r5 = r8.zzart     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzlt r2 = r2.zza((int) r3, (com.google.android.gms.internal.ads.zzlt) r5, (boolean) r9)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r2 = r2.zzack     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x07ca:
            com.google.android.gms.internal.ads.zzll r5 = r8.zzasj     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzld r6 = r8.zzast     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r11 = r8.zzass     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            long r6 = r6.zzgz()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r13 = 0
            long r11 = r11 - r6
            long r2 = r2 - r11
            boolean r1 = r5.zzf(r2, r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x07db:
            if (r1 == 0) goto L_0x07df
            r1 = 1
            goto L_0x07e5
        L_0x07df:
            r1 = 0
            goto L_0x07e5
        L_0x07e1:
            boolean r1 = r8.zzec(r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x07e5:
            if (r1 == 0) goto L_0x080e
            r1 = 3
            r8.setState(r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            boolean r1 = r8.zzabu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x080e
            r34.zzdp()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x080e
        L_0x07f3:
            int r3 = r8.state     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r5 = 3
            if (r3 != r5) goto L_0x080e
            com.google.android.gms.internal.ads.zzlo[] r3 = r8.zzasp     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r3 = r3.length     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r3 <= 0) goto L_0x07fe
            goto L_0x0802
        L_0x07fe:
            boolean r6 = r8.zzec(r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0802:
            if (r6 != 0) goto L_0x080e
            boolean r1 = r8.zzabu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzacg = r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.setState(r4)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r34.zzdq()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x080e:
            int r1 = r8.state     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 != r4) goto L_0x081f
            com.google.android.gms.internal.ads.zzlo[] r1 = r8.zzasp     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r2 = r1.length     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0815:
            if (r9 >= r2) goto L_0x081f
            r3 = r1[r9]     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r3.zzgo()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r9 = r9 + 1
            goto L_0x0815
        L_0x081f:
            boolean r1 = r8.zzabu     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x082c
            int r1 = r8.state     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2 = 3
            if (r1 == r2) goto L_0x0829
            goto L_0x082c
        L_0x0829:
            r1 = 10
            goto L_0x0831
        L_0x082c:
            int r1 = r8.state     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 != r4) goto L_0x0835
            goto L_0x0829
        L_0x0831:
            r8.zzb((long) r14, (long) r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x0845
        L_0x0835:
            com.google.android.gms.internal.ads.zzlo[] r1 = r8.zzasp     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r1 = r1.length     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x0840
            r1 = 1000(0x3e8, double:4.94E-321)
            r8.zzb((long) r14, (long) r1)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x0845
        L_0x0840:
            android.os.Handler r1 = r8.handler     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.removeMessages(r4)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0845:
            com.google.android.gms.internal.ads.zzsx.endSection()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0848:
            return r10
        L_0x0849:
            r4 = 2
            int r1 = r1.arg1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x0850
            r1 = 1
            goto L_0x0851
        L_0x0850:
            r1 = 0
        L_0x0851:
            r8.zzacg = r9     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzabu = r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 != 0) goto L_0x085e
            r34.zzdq()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r34.zzgw()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x0875
        L_0x085e:
            int r1 = r8.state     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2 = 3
            if (r1 != r2) goto L_0x086c
            r34.zzdp()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.os.Handler r1 = r8.handler     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.sendEmptyMessage(r4)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            goto L_0x0875
        L_0x086c:
            int r1 = r8.state     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 != r4) goto L_0x0875
            android.os.Handler r1 = r8.handler     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.sendEmptyMessage(r4)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x0875:
            return r10
        L_0x0876:
            r4 = 2
            java.lang.Object r2 = r1.obj     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzql r2 = (com.google.android.gms.internal.ads.zzql) r2     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            int r1 = r1.arg1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x0881
            r1 = 1
            goto L_0x0882
        L_0x0881:
            r1 = 0
        L_0x0882:
            android.os.Handler r3 = r8.zzabq     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r3.sendEmptyMessage(r9)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzj(r10)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzll r3 = r8.zzasj     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r3.zzhd()     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            if (r1 == 0) goto L_0x089d
            com.google.android.gms.internal.ads.zzle r1 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1.<init>(r9, r5)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.zzasd = r1     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
        L_0x089d:
            r8.zzaso = r2     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            com.google.android.gms.internal.ads.zzkv r1 = r8.zzasl     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r2.zza(r1, r10, r8)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r8.setState(r4)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            android.os.Handler r1 = r8.handler     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            r1.sendEmptyMessage(r4)     // Catch:{ zzku -> 0x08b2, IOException -> 0x08ad, RuntimeException -> 0x08b7 }
            return r10
        L_0x08ad:
            r0 = move-exception
            r1 = r0
            r3 = 8
            goto L_0x08d7
        L_0x08b2:
            r0 = move-exception
            r1 = r0
            r3 = 8
            goto L_0x08f3
        L_0x08b7:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Internal runtime error."
            android.util.Log.e(r2, r3, r1)
            android.os.Handler r2 = r8.zzabq
            com.google.android.gms.internal.ads.zzku r1 = com.google.android.gms.internal.ads.zzku.zza((java.lang.RuntimeException) r1)
            r3 = 8
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r34.zzds()
            return r10
        L_0x08d3:
            r0 = move-exception
            r3 = 8
            r1 = r0
        L_0x08d7:
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r4 = "Source error."
            android.util.Log.e(r2, r4, r1)
            android.os.Handler r2 = r8.zzabq
            com.google.android.gms.internal.ads.zzku r1 = com.google.android.gms.internal.ads.zzku.zza((java.io.IOException) r1)
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r34.zzds()
            return r10
        L_0x08ef:
            r0 = move-exception
            r3 = 8
            r1 = r0
        L_0x08f3:
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r4 = "Renderer error."
            android.util.Log.e(r2, r4, r1)
            android.os.Handler r2 = r8.zzabq
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r34.zzds()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlc.handleMessage(android.os.Message):boolean");
    }

    private final void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.zzabq.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final void zzi(boolean z) {
        if (this.zzarx != z) {
            this.zzarx = z;
            this.zzabq.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void zzdp() throws zzku {
        this.zzacg = false;
        this.zzask.start();
        for (zzlo start : this.zzasp) {
            start.start();
        }
    }

    private final void zzdq() throws zzku {
        this.zzask.stop();
        for (zzlo zza : this.zzasp) {
            zza(zza);
        }
    }

    private final void zzgw() throws zzku {
        long j;
        if (this.zzasv != null) {
            long zzja = this.zzasv.zzasw.zzja();
            if (zzja != C1470C.TIME_UNSET) {
                zzeb(zzja);
            } else {
                if (this.zzasm == null || this.zzasm.zzdx()) {
                    this.zzass = this.zzask.zzdv();
                } else {
                    this.zzass = this.zzasn.zzdv();
                    this.zzask.zzdj(this.zzass);
                }
                zzja = this.zzass - this.zzasv.zzgz();
            }
            this.zzasd.zzacl = zzja;
            this.zzacj = SystemClock.elapsedRealtime() * 1000;
            if (this.zzasp.length == 0) {
                j = Long.MIN_VALUE;
            } else {
                j = this.zzasv.zzasw.zzdu();
            }
            zzle zzle = this.zzasd;
            if (j == Long.MIN_VALUE) {
                j = this.zzary.zza(this.zzasv.zzatb, this.zzart, false).zzack;
            }
            zzle.zzacm = j;
        }
    }

    private final void zzb(long j, long j2) {
        this.handler.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
        } else {
            this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private final long zzd(int i, long j) throws zzku {
        zzld zzld;
        zzdq();
        this.zzacg = false;
        setState(2);
        if (this.zzasv == null) {
            if (this.zzast != null) {
                this.zzast.release();
            }
            zzld = null;
        } else {
            zzld = null;
            for (zzld zzld2 = this.zzasv; zzld2 != null; zzld2 = zzld2.zzatf) {
                if (zzld2.zzatb != i || !zzld2.zzacs) {
                    zzld2.release();
                } else {
                    zzld = zzld2;
                }
            }
        }
        if (!(this.zzasv == zzld && this.zzasv == this.zzasu)) {
            for (zzlo disable : this.zzasp) {
                disable.disable();
            }
            this.zzasp = new zzlo[0];
            this.zzasn = null;
            this.zzasm = null;
            this.zzasv = null;
        }
        if (zzld != null) {
            zzld.zzatf = null;
            this.zzast = zzld;
            this.zzasu = zzld;
            zzb(zzld);
            if (this.zzasv.zzate) {
                j = this.zzasv.zzasw.zzen(j);
            }
            zzeb(j);
            zzgy();
        } else {
            this.zzast = null;
            this.zzasu = null;
            this.zzasv = null;
            zzeb(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private final void zzeb(long j) throws zzku {
        long j2;
        if (this.zzasv == null) {
            j2 = j + 60000000;
        } else {
            j2 = j + this.zzasv.zzgz();
        }
        this.zzass = j2;
        this.zzask.zzdj(this.zzass);
        for (zzlo zzdx : this.zzasp) {
            zzdx.zzdx(this.zzass);
        }
    }

    private final void zzds() {
        zzj(true);
        this.zzasj.onStopped();
        setState(1);
    }

    private final void zzj(boolean z) {
        zzld zzld;
        this.handler.removeMessages(2);
        this.zzacg = false;
        this.zzask.stop();
        this.zzasn = null;
        this.zzasm = null;
        this.zzass = 60000000;
        for (zzlo zzlo : this.zzasp) {
            try {
                zza(zzlo);
                zzlo.disable();
            } catch (zzku | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.zzasp = new zzlo[0];
        if (this.zzasv != null) {
            zzld = this.zzasv;
        } else {
            zzld = this.zzast;
        }
        zza(zzld);
        this.zzast = null;
        this.zzasu = null;
        this.zzasv = null;
        zzi(false);
        if (z) {
            if (this.zzaso != null) {
                this.zzaso.zzjg();
                this.zzaso = null;
            }
            this.zzary = null;
        }
    }

    private static void zza(zzlo zzlo) throws zzku {
        if (zzlo.getState() == 2) {
            zzlo.stop();
        }
    }

    private final boolean zzec(long j) {
        if (j == C1470C.TIME_UNSET || this.zzasd.zzacl < j) {
            return true;
        }
        return this.zzasv.zzatf != null && this.zzasv.zzatf.zzacs;
    }

    private final void zzgx() throws IOException {
        if (this.zzast != null && !this.zzast.zzacs) {
            if (this.zzasu == null || this.zzasu.zzatf == this.zzast) {
                zzlo[] zzloArr = this.zzasp;
                int length = zzloArr.length;
                int i = 0;
                while (i < length) {
                    if (zzloArr[i].zzgl()) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.zzast.zzasw.zziy();
            }
        }
    }

    private final void zza(Object obj, int i) {
        this.zzasd = new zzle(0, 0);
        zzb(obj, i);
        this.zzasd = new zzle(0, C1470C.TIME_UNSET);
        setState(4);
        zzj(false);
    }

    private final void zzb(Object obj, int i) {
        this.zzabq.obtainMessage(6, new zzlg(this.zzary, obj, this.zzasd, i)).sendToTarget();
    }

    private final int zza(int i, zzlr zzlr, zzlr zzlr2) {
        int zzhg = zzlr.zzhg();
        int i2 = i;
        int i3 = -1;
        for (int i4 = 0; i4 < zzhg && i3 == -1; i4++) {
            i2 = zzlr.zza(i2, this.zzart, this.zzars, this.repeatMode);
            i3 = zzlr2.zzc(zzlr.zza(i2, this.zzart, true).zzasx);
        }
        return i3;
    }

    private final boolean zzad(int i) {
        this.zzary.zza(i, this.zzart, false);
        if (this.zzary.zza(0, this.zzars, false).zzaut || this.zzary.zza(i, this.zzart, this.zzars, this.repeatMode) != -1) {
            return false;
        }
        return true;
    }

    private final Pair<Integer, Long> zza(zzlf zzlf) {
        zzlr zzlr = zzlf.zzary;
        if (zzlr.isEmpty()) {
            zzlr = this.zzary;
        }
        try {
            Pair<Integer, Long> zzb = zzb(zzlr, zzlf.zzati, zzlf.zzatj);
            if (this.zzary == zzlr) {
                return zzb;
            }
            int zzc = this.zzary.zzc(zzlr.zza(((Integer) zzb.first).intValue(), this.zzart, true).zzasx);
            if (zzc != -1) {
                return Pair.create(Integer.valueOf(zzc), (Long) zzb.second);
            }
            int zza = zza(((Integer) zzb.first).intValue(), zzlr, this.zzary);
            if (zza == -1) {
                return null;
            }
            this.zzary.zza(zza, this.zzart, false);
            return zze(0, C1470C.TIME_UNSET);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzlk(this.zzary, zzlf.zzati, zzlf.zzatj);
        }
    }

    private final Pair<Integer, Long> zze(int i, long j) {
        return zzb(this.zzary, i, C1470C.TIME_UNSET);
    }

    private final Pair<Integer, Long> zzb(zzlr zzlr, int i, long j) {
        return zza(zzlr, i, j, 0);
    }

    private final Pair<Integer, Long> zza(zzlr zzlr, int i, long j, long j2) {
        zzsk.zzc(i, 0, zzlr.zzhf());
        zzlr.zza(i, this.zzars, false, j2);
        if (j == C1470C.TIME_UNSET) {
            j = this.zzars.zzauw;
            if (j == C1470C.TIME_UNSET) {
                return null;
            }
        }
        zzlr.zza(0, this.zzart, false);
        return Pair.create(0, Long.valueOf(this.zzars.zzaux + j));
    }

    private final void zzgy() {
        long j;
        if (!this.zzast.zzacs) {
            j = 0;
        } else {
            j = this.zzast.zzasw.zzix();
        }
        if (j == Long.MIN_VALUE) {
            zzi(false);
            return;
        }
        long zzgz = this.zzass - this.zzast.zzgz();
        boolean zzee = this.zzasj.zzee(j - zzgz);
        zzi(zzee);
        if (zzee) {
            this.zzast.zzasw.zzel(zzgz);
        }
    }

    private static void zza(zzld zzld) {
        while (zzld != null) {
            zzld.release();
            zzld = zzld.zzatf;
        }
    }

    private final void zzb(zzld zzld) throws zzku {
        if (this.zzasv != zzld) {
            boolean[] zArr = new boolean[this.zzaro.length];
            int i = 0;
            for (int i2 = 0; i2 < this.zzaro.length; i2++) {
                zzlo zzlo = this.zzaro[i2];
                zArr[i2] = zzlo.getState() != 0;
                zzrm zzbi = zzld.zzatg.zzblz.zzbi(i2);
                if (zzbi != null) {
                    i++;
                }
                if (zArr[i2] && (zzbi == null || (zzlo.zzgn() && zzlo.zzgk() == this.zzasv.zzasy[i2]))) {
                    if (zzlo == this.zzasm) {
                        this.zzask.zza(this.zzasn);
                        this.zzasn = null;
                        this.zzasm = null;
                    }
                    zza(zzlo);
                    zzlo.disable();
                }
            }
            this.zzasv = zzld;
            this.zzabq.obtainMessage(3, zzld.zzatg).sendToTarget();
            zza(zArr, i);
        }
    }

    private final void zza(boolean[] zArr, int i) throws zzku {
        this.zzasp = new zzlo[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzaro.length; i3++) {
            zzlo zzlo = this.zzaro[i3];
            zzrm zzbi = this.zzasv.zzatg.zzblz.zzbi(i3);
            if (zzbi != null) {
                int i4 = i2 + 1;
                this.zzasp[i2] = zzlo;
                if (zzlo.getState() == 0) {
                    zzlq zzlq = this.zzasv.zzatg.zzbmb[i3];
                    boolean z = this.zzabu && this.state == 3;
                    boolean z2 = !zArr[i3] && z;
                    zzlh[] zzlhArr = new zzlh[zzbi.length()];
                    for (int i5 = 0; i5 < zzlhArr.length; i5++) {
                        zzlhArr[i5] = zzbi.zzbf(i5);
                    }
                    zzlo.zza(zzlq, zzlhArr, this.zzasv.zzasy[i3], this.zzass, z2, this.zzasv.zzgz());
                    zzso zzgj = zzlo.zzgj();
                    if (zzgj != null) {
                        if (this.zzasn == null) {
                            this.zzasn = zzgj;
                            this.zzasm = zzlo;
                            this.zzasn.zzb(this.zzasc);
                        } else {
                            throw zzku.zza((RuntimeException) new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                    }
                    if (z) {
                        zzlo.start();
                    }
                }
                i2 = i4;
            }
        }
    }

    public final /* synthetic */ void zza(zzqx zzqx) {
        this.handler.obtainMessage(9, (zzqj) zzqx).sendToTarget();
    }
}
