package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

final class zzgk implements Handler.Callback {
    private final Handler handler;
    private int state;
    private final Handler zzabq;
    private final boolean[] zzabt;
    private boolean zzabu;
    private final HandlerThread zzaby;
    private final zzgm zzabz;
    private final long zzaca;
    private final long zzacb;
    private final List<zzhp> zzacc;
    private zzhp[] zzacd;
    private zzhp zzace;
    private boolean zzacf;
    private boolean zzacg;
    private int zzach = 0;
    private int zzaci = 0;
    private long zzacj;
    private volatile long zzack;
    private volatile long zzacl;
    private volatile long zzacm;

    public zzgk(Handler handler2, boolean z, boolean[] zArr, int i, int i2) {
        this.zzabq = handler2;
        this.zzabu = z;
        this.zzabt = new boolean[zArr.length];
        this.zzaca = 2500000;
        this.zzacb = 5000000;
        for (int i3 = 0; i3 < zArr.length; i3++) {
            this.zzabt[i3] = zArr[i3];
        }
        this.state = 1;
        this.zzack = -1;
        this.zzacm = -1;
        this.zzabz = new zzgm();
        this.zzacc = new ArrayList(zArr.length);
        this.zzaby = new zzko(String.valueOf(getClass().getSimpleName()).concat(":Handler"), -16);
        this.zzaby.start();
        this.handler = new Handler(this.zzaby.getLooper(), this);
    }

    public final long zzdn() {
        return this.zzacl / 1000;
    }

    public final long getBufferedPosition() {
        if (this.zzacm == -1) {
            return -1;
        }
        return this.zzacm / 1000;
    }

    public final long getDuration() {
        if (this.zzack == -1) {
            return -1;
        }
        return this.zzack / 1000;
    }

    public final void zza(zzhp... zzhpArr) {
        this.handler.obtainMessage(1, zzhpArr).sendToTarget();
    }

    public final void zzd(boolean z) {
        this.handler.obtainMessage(3, z ? 1 : 0, 0).sendToTarget();
    }

    public final void seekTo(long j) {
        this.handler.obtainMessage(6, Long.valueOf(j)).sendToTarget();
    }

    public final void stop() {
        this.handler.sendEmptyMessage(4);
    }

    public final void zzc(int i, boolean z) {
        this.handler.obtainMessage(8, 0, z ? 1 : 0).sendToTarget();
    }

    public final void zza(zzgf zzgf, int i, Object obj) {
        this.zzach++;
        this.handler.obtainMessage(9, 1, 0, Pair.create(zzgf, obj)).sendToTarget();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|23|20|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0040 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(com.google.android.gms.internal.ads.zzgf r4, int r5, java.lang.Object r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r5 = r3.zzacf     // Catch:{ all -> 0x004a }
            if (r5 == 0) goto L_0x0021
            java.lang.String r4 = "ExoPlayerImplInternal"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            r6 = 57
            r5.<init>(r6)     // Catch:{ all -> 0x004a }
            java.lang.String r6 = "Sent message(1"
            r5.append(r6)     // Catch:{ all -> 0x004a }
            java.lang.String r6 = ") after release. Message ignored."
            r5.append(r6)     // Catch:{ all -> 0x004a }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x004a }
            android.util.Log.w(r4, r5)     // Catch:{ all -> 0x004a }
            monitor-exit(r3)
            return
        L_0x0021:
            int r5 = r3.zzach     // Catch:{ all -> 0x004a }
            int r0 = r5 + 1
            r3.zzach = r0     // Catch:{ all -> 0x004a }
            android.os.Handler r0 = r3.handler     // Catch:{ all -> 0x004a }
            r1 = 9
            r2 = 0
            android.util.Pair r4 = android.util.Pair.create(r4, r6)     // Catch:{ all -> 0x004a }
            r6 = 1
            android.os.Message r4 = r0.obtainMessage(r1, r6, r2, r4)     // Catch:{ all -> 0x004a }
            r4.sendToTarget()     // Catch:{ all -> 0x004a }
        L_0x0038:
            int r4 = r3.zzaci     // Catch:{ all -> 0x004a }
            if (r4 > r5) goto L_0x0048
            r3.wait()     // Catch:{ InterruptedException -> 0x0040 }
            goto L_0x0038
        L_0x0040:
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x004a }
            r4.interrupt()     // Catch:{ all -> 0x004a }
            goto L_0x0038
        L_0x0048:
            monitor-exit(r3)
            return
        L_0x004a:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgk.zzb(com.google.android.gms.internal.ads.zzgf, int, java.lang.Object):void");
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
            r1 = 5
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgk.release():void");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r22) {
        /*
            r21 = this;
            r7 = r21
            r0 = r22
            r8 = 3
            r9 = 1
            int r1 = r0.what     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r4 = 5
            r5 = 7
            r6 = 4
            r10 = 2
            r11 = -1
            switch(r1) {
                case 1: goto L_0x02eb;
                case 2: goto L_0x0239;
                case 3: goto L_0x01f5;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01de;
                case 6: goto L_0x0190;
                case 7: goto L_0x00b1;
                case 8: goto L_0x004c;
                case 9: goto L_0x0013;
                default: goto L_0x0011;
            }     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
        L_0x0011:
            r0 = 0
            return r0
        L_0x0013:
            int r1 = r0.arg1     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            java.lang.Object r0 = r0.obj     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            android.util.Pair r0 = (android.util.Pair) r0     // Catch:{ all -> 0x003d }
            java.lang.Object r2 = r0.first     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.ads.zzgf r2 = (com.google.android.gms.internal.ads.zzgf) r2     // Catch:{ all -> 0x003d }
            java.lang.Object r0 = r0.second     // Catch:{ all -> 0x003d }
            r2.zza(r1, r0)     // Catch:{ all -> 0x003d }
            monitor-enter(r21)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            int r0 = r7.zzaci     // Catch:{ all -> 0x003a }
            int r0 = r0 + r9
            r7.zzaci = r0     // Catch:{ all -> 0x003a }
            r21.notifyAll()     // Catch:{ all -> 0x003a }
            monitor-exit(r21)     // Catch:{ all -> 0x003a }
            int r0 = r7.state     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r0 == r9) goto L_0x0039
            int r0 = r7.state     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r0 == r10) goto L_0x0039
            android.os.Handler r0 = r7.handler     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r0.sendEmptyMessage(r5)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
        L_0x0039:
            return r9
        L_0x003a:
            r0 = move-exception
            monitor-exit(r21)     // Catch:{ all -> 0x003a }
            throw r0     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
        L_0x003d:
            r0 = move-exception
            monitor-enter(r21)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            int r1 = r7.zzaci     // Catch:{ all -> 0x0049 }
            int r1 = r1 + r9
            r7.zzaci = r1     // Catch:{ all -> 0x0049 }
            r21.notifyAll()     // Catch:{ all -> 0x0049 }
            monitor-exit(r21)     // Catch:{ all -> 0x0049 }
            throw r0     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
        L_0x0049:
            r0 = move-exception
            monitor-exit(r21)     // Catch:{ all -> 0x0049 }
            throw r0     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
        L_0x004c:
            int r1 = r0.arg1     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            int r0 = r0.arg2     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r0 == 0) goto L_0x0054
            r0 = 1
            goto L_0x0055
        L_0x0054:
            r0 = 0
        L_0x0055:
            boolean[] r2 = r7.zzabt     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            boolean r2 = r2[r1]     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r2 == r0) goto L_0x00b0
            boolean[] r2 = r7.zzabt     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r2[r1] = r0     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            int r2 = r7.state     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r2 == r9) goto L_0x00b0
            int r2 = r7.state     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r2 != r10) goto L_0x0068
            goto L_0x00b0
        L_0x0068:
            com.google.android.gms.internal.ads.zzhp[] r2 = r7.zzacd     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1 = r2[r1]     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            int r2 = r1.getState()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r2 == r9) goto L_0x0076
            if (r2 == r10) goto L_0x0076
            if (r2 != r8) goto L_0x00b0
        L_0x0076:
            if (r0 == 0) goto L_0x0098
            boolean r0 = r7.zzabu     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r0 == 0) goto L_0x0082
            int r0 = r7.state     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r0 != r6) goto L_0x0082
            r13 = 1
            goto L_0x0083
        L_0x0082:
            r13 = 0
        L_0x0083:
            long r2 = r7.zzacl     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1.zzc(r2, r13)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            java.util.List<com.google.android.gms.internal.ads.zzhp> r0 = r7.zzacc     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r0.add(r1)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r13 == 0) goto L_0x0092
            r1.start()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
        L_0x0092:
            android.os.Handler r0 = r7.handler     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r0.sendEmptyMessage(r5)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            goto L_0x00b0
        L_0x0098:
            com.google.android.gms.internal.ads.zzhp r0 = r7.zzace     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r1 != r0) goto L_0x00a5
            com.google.android.gms.internal.ads.zzgm r0 = r7.zzabz     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            long r2 = r1.zzdy()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r0.zzdj(r2)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
        L_0x00a5:
            zzb(r1)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            java.util.List<com.google.android.gms.internal.ads.zzhp> r0 = r7.zzacc     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r0.remove(r1)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1.disable()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
        L_0x00b0:
            return r9
        L_0x00b1:
            java.lang.String r0 = "doSomeWork"
            com.google.android.gms.internal.ads.zzkp.beginSection(r0)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            long r14 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            long r0 = r7.zzack     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            int r0 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x00c3
            long r0 = r7.zzack     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            goto L_0x00c8
        L_0x00c3:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00c8:
            r21.zzdr()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r9 = r0
            r0 = 0
            r1 = 1
            r16 = 1
        L_0x00d0:
            java.util.List<com.google.android.gms.internal.ads.zzhp> r13 = r7.zzacc     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            int r13 = r13.size()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r0 >= r13) goto L_0x012f
            java.util.List<com.google.android.gms.internal.ads.zzhp> r13 = r7.zzacc     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            java.lang.Object r13 = r13.get(r0)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            com.google.android.gms.internal.ads.zzhp r13 = (com.google.android.gms.internal.ads.zzhp) r13     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            long r5 = r7.zzacl     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            long r2 = r7.zzacj     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r13.zza((long) r5, (long) r2)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r1 == 0) goto L_0x00f1
            boolean r1 = r13.zzdx()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r1 == 0) goto L_0x00f1
            r1 = 1
            goto L_0x00f2
        L_0x00f1:
            r1 = 0
        L_0x00f2:
            if (r16 == 0) goto L_0x00fd
            boolean r2 = r7.zza((com.google.android.gms.internal.ads.zzhp) r13)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r2 == 0) goto L_0x00fd
            r16 = 1
            goto L_0x00ff
        L_0x00fd:
            r16 = 0
        L_0x00ff:
            int r2 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x012a
            long r2 = r13.getDurationUs()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            long r5 = r13.zzdu()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            int r13 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r13 != 0) goto L_0x0111
            r9 = r11
            goto L_0x012a
        L_0x0111:
            r19 = -3
            int r13 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r13 == 0) goto L_0x012a
            int r13 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x0125
            r17 = -2
            int r13 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r13 == 0) goto L_0x0125
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x012a
        L_0x0125:
            long r2 = java.lang.Math.min(r9, r5)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r9 = r2
        L_0x012a:
            int r0 = r0 + 1
            r5 = 7
            r6 = 4
            goto L_0x00d0
        L_0x012f:
            r7.zzacm = r9     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r1 == 0) goto L_0x013a
            r7.setState(r4)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r21.zzdq()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            goto L_0x015d
        L_0x013a:
            int r0 = r7.state     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r0 != r8) goto L_0x014c
            if (r16 == 0) goto L_0x014c
            r0 = 4
            r7.setState(r0)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            boolean r0 = r7.zzabu     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r0 == 0) goto L_0x015d
            r21.zzdp()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            goto L_0x015d
        L_0x014c:
            int r0 = r7.state     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1 = 4
            if (r0 != r1) goto L_0x015d
            if (r16 != 0) goto L_0x015d
            boolean r0 = r7.zzabu     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r7.zzacg = r0     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r7.setState(r8)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r21.zzdq()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
        L_0x015d:
            android.os.Handler r0 = r7.handler     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1 = 7
            r0.removeMessages(r1)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            boolean r0 = r7.zzabu     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r0 == 0) goto L_0x016c
            int r0 = r7.state     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1 = 4
            if (r0 == r1) goto L_0x0170
        L_0x016c:
            int r0 = r7.state     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r0 != r8) goto L_0x017a
        L_0x0170:
            r2 = 7
            r5 = 10
            r1 = r21
            r3 = r14
            r1.zza((int) r2, (long) r3, (long) r5)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            goto L_0x018b
        L_0x017a:
            java.util.List<com.google.android.gms.internal.ads.zzhp> r0 = r7.zzacc     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            boolean r0 = r0.isEmpty()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r0 != 0) goto L_0x018b
            r2 = 7
            r5 = 1000(0x3e8, double:4.94E-321)
            r1 = r21
            r3 = r14
            r1.zza((int) r2, (long) r3, (long) r5)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
        L_0x018b:
            com.google.android.gms.internal.ads.zzkp.endSection()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1 = 1
            return r1
        L_0x0190:
            java.lang.Object r0 = r0.obj     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            long r0 = r0.longValue()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r2 = 0
            r7.zzacg = r2     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            r7.zzacl = r0     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            com.google.android.gms.internal.ads.zzgm r0 = r7.zzabz     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r0.stop()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            com.google.android.gms.internal.ads.zzgm r0 = r7.zzabz     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            long r1 = r7.zzacl     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r0.zzdj(r1)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            int r0 = r7.state     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1 = 1
            if (r0 == r1) goto L_0x01dc
            int r0 = r7.state     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r0 != r10) goto L_0x01b7
            goto L_0x01dc
        L_0x01b7:
            r0 = 0
        L_0x01b8:
            java.util.List<com.google.android.gms.internal.ads.zzhp> r1 = r7.zzacc     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            int r1 = r1.size()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r0 >= r1) goto L_0x01d3
            java.util.List<com.google.android.gms.internal.ads.zzhp> r1 = r7.zzacc     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            com.google.android.gms.internal.ads.zzhp r1 = (com.google.android.gms.internal.ads.zzhp) r1     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            zzb(r1)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            long r2 = r7.zzacl     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1.seekTo(r2)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            int r0 = r0 + 1
            goto L_0x01b8
        L_0x01d3:
            r7.setState(r8)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            android.os.Handler r0 = r7.handler     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1 = 7
            r0.sendEmptyMessage(r1)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
        L_0x01dc:
            r1 = 1
            return r1
        L_0x01de:
            r21.zzdt()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1 = 1
            r7.setState(r1)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            monitor-enter(r21)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r7.zzacf = r1     // Catch:{ all -> 0x01ed }
            r21.notifyAll()     // Catch:{ all -> 0x01ed }
            monitor-exit(r21)     // Catch:{ all -> 0x01ed }
            return r1
        L_0x01ed:
            r0 = move-exception
            monitor-exit(r21)     // Catch:{ all -> 0x01ed }
            throw r0     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
        L_0x01f0:
            r21.zzds()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1 = 1
            return r1
        L_0x01f5:
            int r0 = r0.arg1     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r0 == 0) goto L_0x01fb
            r0 = 1
            goto L_0x01fc
        L_0x01fb:
            r0 = 0
        L_0x01fc:
            r1 = 0
            r7.zzacg = r1     // Catch:{ all -> 0x022e }
            r7.zzabu = r0     // Catch:{ all -> 0x022e }
            if (r0 != 0) goto L_0x020a
            r21.zzdq()     // Catch:{ all -> 0x022e }
            r21.zzdr()     // Catch:{ all -> 0x022e }
            goto L_0x0223
        L_0x020a:
            int r0 = r7.state     // Catch:{ all -> 0x022e }
            r1 = 4
            if (r0 != r1) goto L_0x0219
            r21.zzdp()     // Catch:{ all -> 0x022e }
            android.os.Handler r0 = r7.handler     // Catch:{ all -> 0x022e }
            r1 = 7
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x022e }
            goto L_0x0223
        L_0x0219:
            int r0 = r7.state     // Catch:{ all -> 0x022e }
            if (r0 != r8) goto L_0x0223
            android.os.Handler r0 = r7.handler     // Catch:{ all -> 0x022e }
            r1 = 7
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x022e }
        L_0x0223:
            android.os.Handler r0 = r7.zzabq     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            android.os.Message r0 = r0.obtainMessage(r10)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r0.sendToTarget()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1 = 1
            return r1
        L_0x022e:
            r0 = move-exception
            android.os.Handler r1 = r7.zzabq     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            android.os.Message r1 = r1.obtainMessage(r10)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1.sendToTarget()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            throw r0     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
        L_0x0239:
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r0 = 0
            r1 = 1
        L_0x023f:
            com.google.android.gms.internal.ads.zzhp[] r2 = r7.zzacd     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            int r2 = r2.length     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r0 >= r2) goto L_0x025e
            com.google.android.gms.internal.ads.zzhp[] r2 = r7.zzacd     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r2 = r2[r0]     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            int r2 = r2.getState()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r2 != 0) goto L_0x025b
            com.google.android.gms.internal.ads.zzhp[] r2 = r7.zzacd     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r2 = r2[r0]     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            long r9 = r7.zzacl     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            int r2 = r2.zzdm(r9)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r2 != 0) goto L_0x025b
            r1 = 0
        L_0x025b:
            int r0 = r0 + 1
            goto L_0x023f
        L_0x025e:
            if (r1 != 0) goto L_0x026d
            r2 = 2
            r9 = 10
            r1 = r21
            r3 = r5
            r5 = r9
            r1.zza((int) r2, (long) r3, (long) r5)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
        L_0x026a:
            r1 = 1
            goto L_0x02ea
        L_0x026d:
            r0 = 0
            r1 = r0
            r0 = 0
            r3 = 1
            r5 = 1
        L_0x0273:
            com.google.android.gms.internal.ads.zzhp[] r6 = r7.zzacd     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            int r6 = r6.length     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r0 >= r6) goto L_0x02c7
            com.google.android.gms.internal.ads.zzhp[] r6 = r7.zzacd     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r6 = r6[r0]     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            boolean[] r9 = r7.zzabt     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            boolean r9 = r9[r0]     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r9 == 0) goto L_0x02b7
            int r9 = r6.getState()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r10 = 1
            if (r9 != r10) goto L_0x02b7
            long r9 = r7.zzacl     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r13 = 0
            r6.zzc(r9, r13)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            java.util.List<com.google.android.gms.internal.ads.zzhp> r9 = r7.zzacc     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r9.add(r6)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r3 == 0) goto L_0x029e
            boolean r3 = r6.zzdx()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r3 == 0) goto L_0x029e
            r3 = 1
            goto L_0x029f
        L_0x029e:
            r3 = 0
        L_0x029f:
            if (r5 == 0) goto L_0x02a9
            boolean r5 = r7.zza((com.google.android.gms.internal.ads.zzhp) r6)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r5 == 0) goto L_0x02a9
            r5 = 1
            goto L_0x02aa
        L_0x02a9:
            r5 = 0
        L_0x02aa:
            int r9 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r9 == 0) goto L_0x02b7
            long r9 = r6.getDurationUs()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            int r6 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r6 != 0) goto L_0x02ba
            r1 = r11
        L_0x02b7:
            r13 = -2
            goto L_0x02c4
        L_0x02ba:
            r13 = -2
            int r6 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r6 == 0) goto L_0x02c4
            long r1 = java.lang.Math.max(r1, r9)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
        L_0x02c4:
            int r0 = r0 + 1
            goto L_0x0273
        L_0x02c7:
            r7.zzack = r1     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r3 == 0) goto L_0x02cf
            r7.setState(r4)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            goto L_0x02e3
        L_0x02cf:
            if (r5 == 0) goto L_0x02d3
            r0 = 4
            goto L_0x02d4
        L_0x02d3:
            r0 = 3
        L_0x02d4:
            r7.setState(r0)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            boolean r0 = r7.zzabu     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r0 == 0) goto L_0x02e3
            int r0 = r7.state     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1 = 4
            if (r0 != r1) goto L_0x02e3
            r21.zzdp()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
        L_0x02e3:
            android.os.Handler r0 = r7.handler     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1 = 7
            r0.sendEmptyMessage(r1)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            goto L_0x026a
        L_0x02ea:
            return r1
        L_0x02eb:
            java.lang.Object r0 = r0.obj     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            com.google.android.gms.internal.ads.zzhp[] r0 = (com.google.android.gms.internal.ads.zzhp[]) r0     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r21.zzdt()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r7.zzacd = r0     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1 = 0
        L_0x02f5:
            int r2 = r0.length     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r1 >= r2) goto L_0x0311
            r2 = r0[r1]     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            boolean r2 = r2.zzdw()     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r2 == 0) goto L_0x030e
            com.google.android.gms.internal.ads.zzhp r2 = r7.zzace     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            if (r2 != 0) goto L_0x0306
            r2 = 1
            goto L_0x0307
        L_0x0306:
            r2 = 0
        L_0x0307:
            com.google.android.gms.internal.ads.zzkh.checkState(r2)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r2 = r0[r1]     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r7.zzace = r2     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
        L_0x030e:
            int r1 = r1 + 1
            goto L_0x02f5
        L_0x0311:
            r7.setState(r10)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            android.os.Handler r0 = r7.handler     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r0.sendEmptyMessage(r10)     // Catch:{ zzgd -> 0x0336, RuntimeException -> 0x031b }
            r1 = 1
            return r1
        L_0x031b:
            r0 = move-exception
            java.lang.String r1 = "ExoPlayerImplInternal"
            java.lang.String r2 = "Internal runtime error."
            android.util.Log.e(r1, r2, r0)
            android.os.Handler r1 = r7.zzabq
            com.google.android.gms.internal.ads.zzgd r2 = new com.google.android.gms.internal.ads.zzgd
            r3 = 1
            r2.<init>(r0, r3)
            android.os.Message r0 = r1.obtainMessage(r8, r2)
            r0.sendToTarget()
            r21.zzds()
            return r3
        L_0x0336:
            r0 = move-exception
            r3 = 1
            java.lang.String r1 = "ExoPlayerImplInternal"
            java.lang.String r2 = "Internal track renderer error."
            android.util.Log.e(r1, r2, r0)
            android.os.Handler r1 = r7.zzabq
            android.os.Message r0 = r1.obtainMessage(r8, r0)
            r0.sendToTarget()
            r21.zzds()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgk.handleMessage(android.os.Message):boolean");
    }

    private final void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.zzabq.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final boolean zza(zzhp zzhp) {
        if (zzhp.zzdx()) {
            return true;
        }
        if (!zzhp.isReady()) {
            return false;
        }
        if (this.state == 4) {
            return true;
        }
        long durationUs = zzhp.getDurationUs();
        long zzdu = zzhp.zzdu();
        long j = this.zzacg ? this.zzacb : this.zzaca;
        if (j <= 0 || zzdu == -1 || zzdu == -3 || zzdu >= this.zzacl + j || (durationUs != -1 && durationUs != -2 && zzdu >= durationUs)) {
            return true;
        }
        return false;
    }

    private final void zzdp() throws zzgd {
        this.zzacg = false;
        this.zzabz.start();
        for (int i = 0; i < this.zzacc.size(); i++) {
            this.zzacc.get(i).start();
        }
    }

    private final void zzdq() throws zzgd {
        this.zzabz.stop();
        for (int i = 0; i < this.zzacc.size(); i++) {
            zzb(this.zzacc.get(i));
        }
    }

    private final void zzdr() {
        if (this.zzace == null || !this.zzacc.contains(this.zzace) || this.zzace.zzdx()) {
            this.zzacl = this.zzabz.zzdv();
        } else {
            this.zzacl = this.zzace.zzdy();
            this.zzabz.zzdj(this.zzacl);
        }
        this.zzacj = SystemClock.elapsedRealtime() * 1000;
    }

    private final void zza(int i, long j, long j2) {
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(i);
        } else {
            this.handler.sendEmptyMessageDelayed(i, elapsedRealtime);
        }
    }

    private final void zzds() {
        zzdt();
        setState(1);
    }

    private final void zzdt() {
        this.handler.removeMessages(7);
        this.handler.removeMessages(2);
        this.zzacg = false;
        this.zzabz.stop();
        if (this.zzacd != null) {
            for (zzhp zzhp : this.zzacd) {
                try {
                    zzb(zzhp);
                    if (zzhp.getState() == 2) {
                        zzhp.disable();
                    }
                } catch (zzgd e) {
                    Log.e("ExoPlayerImplInternal", "Stop failed.", e);
                } catch (RuntimeException e2) {
                    Log.e("ExoPlayerImplInternal", "Stop failed.", e2);
                }
                try {
                    zzhp.release();
                } catch (zzgd e3) {
                    Log.e("ExoPlayerImplInternal", "Release failed.", e3);
                } catch (RuntimeException e4) {
                    Log.e("ExoPlayerImplInternal", "Release failed.", e4);
                }
            }
            this.zzacd = null;
            this.zzace = null;
            this.zzacc.clear();
        }
    }

    private static void zzb(zzhp zzhp) throws zzgd {
        if (zzhp.getState() == 3) {
            zzhp.stop();
        }
    }
}
