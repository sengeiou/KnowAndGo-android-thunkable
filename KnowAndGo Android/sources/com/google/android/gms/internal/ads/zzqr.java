package com.google.android.gms.internal.ads;

final class zzqr {
    private int length;
    private int[] zzahp = new int[this.zzajq];
    private long[] zzahq = new long[this.zzajq];
    private long[] zzahs = new long[this.zzajq];
    private int zzajq = 1000;
    private int[] zzajr = new int[this.zzajq];
    private int[] zzbjs = new int[this.zzajq];
    private zznx[] zzbjt = new zznx[this.zzajq];
    private zzlh[] zzbju = new zzlh[this.zzajq];
    private int zzbjv;
    private int zzbjw;
    private int zzbjx;
    private long zzbjy = Long.MIN_VALUE;
    private long zzbjz = Long.MIN_VALUE;
    private boolean zzbka = true;
    private boolean zzbkb = true;
    private zzlh zzbkc;

    public final void zzjh() {
        this.zzbjv = 0;
        this.zzbjw = 0;
        this.zzbjx = 0;
        this.length = 0;
        this.zzbka = true;
    }

    public final void zzji() {
        this.zzbjy = Long.MIN_VALUE;
        this.zzbjz = Long.MIN_VALUE;
    }

    public final int zzjj() {
        return this.zzbjv + this.length;
    }

    public final synchronized boolean zzjk() {
        return this.length != 0;
    }

    public final synchronized zzlh zzjl() {
        if (this.zzbkb) {
            return null;
        }
        return this.zzbkc;
    }

    public final synchronized long zzje() {
        return Math.max(this.zzbjy, this.zzbjz);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0023, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int zza(com.google.android.gms.internal.ads.zzlj r5, com.google.android.gms.internal.ads.zznd r6, boolean r7, boolean r8, com.google.android.gms.internal.ads.zzlh r9, com.google.android.gms.internal.ads.zzqs r10) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.zzjk()     // Catch:{ all -> 0x00a6 }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0024
            if (r8 == 0) goto L_0x0012
            r5 = 4
            r6.setFlags(r5)     // Catch:{ all -> 0x00a6 }
            monitor-exit(r4)
            return r3
        L_0x0012:
            com.google.android.gms.internal.ads.zzlh r6 = r4.zzbkc     // Catch:{ all -> 0x00a6 }
            if (r6 == 0) goto L_0x0022
            if (r7 != 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzlh r6 = r4.zzbkc     // Catch:{ all -> 0x00a6 }
            if (r6 == r9) goto L_0x0022
        L_0x001c:
            com.google.android.gms.internal.ads.zzlh r6 = r4.zzbkc     // Catch:{ all -> 0x00a6 }
            r5.zzaue = r6     // Catch:{ all -> 0x00a6 }
            monitor-exit(r4)
            return r1
        L_0x0022:
            monitor-exit(r4)
            return r2
        L_0x0024:
            if (r7 != 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzlh[] r7 = r4.zzbju     // Catch:{ all -> 0x00a6 }
            int r8 = r4.zzbjw     // Catch:{ all -> 0x00a6 }
            r7 = r7[r8]     // Catch:{ all -> 0x00a6 }
            if (r7 == r9) goto L_0x002f
            goto L_0x009c
        L_0x002f:
            java.nio.ByteBuffer r5 = r6.zzde     // Catch:{ all -> 0x00a6 }
            r7 = 0
            r8 = 1
            if (r5 != 0) goto L_0x0037
            r5 = 1
            goto L_0x0038
        L_0x0037:
            r5 = 0
        L_0x0038:
            if (r5 == 0) goto L_0x003c
            monitor-exit(r4)
            return r2
        L_0x003c:
            long[] r5 = r4.zzahs     // Catch:{ all -> 0x00a6 }
            int r9 = r4.zzbjw     // Catch:{ all -> 0x00a6 }
            r0 = r5[r9]     // Catch:{ all -> 0x00a6 }
            r6.zzaga = r0     // Catch:{ all -> 0x00a6 }
            int[] r5 = r4.zzajr     // Catch:{ all -> 0x00a6 }
            int r9 = r4.zzbjw     // Catch:{ all -> 0x00a6 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a6 }
            r6.setFlags(r5)     // Catch:{ all -> 0x00a6 }
            int[] r5 = r4.zzahp     // Catch:{ all -> 0x00a6 }
            int r9 = r4.zzbjw     // Catch:{ all -> 0x00a6 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a6 }
            r10.size = r5     // Catch:{ all -> 0x00a6 }
            long[] r5 = r4.zzahq     // Catch:{ all -> 0x00a6 }
            int r9 = r4.zzbjw     // Catch:{ all -> 0x00a6 }
            r0 = r5[r9]     // Catch:{ all -> 0x00a6 }
            r10.zzajx = r0     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zznx[] r5 = r4.zzbjt     // Catch:{ all -> 0x00a6 }
            int r9 = r4.zzbjw     // Catch:{ all -> 0x00a6 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a6 }
            r10.zzbbj = r5     // Catch:{ all -> 0x00a6 }
            long r0 = r4.zzbjy     // Catch:{ all -> 0x00a6 }
            long r5 = r6.zzaga     // Catch:{ all -> 0x00a6 }
            long r5 = java.lang.Math.max(r0, r5)     // Catch:{ all -> 0x00a6 }
            r4.zzbjy = r5     // Catch:{ all -> 0x00a6 }
            int r5 = r4.length     // Catch:{ all -> 0x00a6 }
            int r5 = r5 - r8
            r4.length = r5     // Catch:{ all -> 0x00a6 }
            int r5 = r4.zzbjw     // Catch:{ all -> 0x00a6 }
            int r5 = r5 + r8
            r4.zzbjw = r5     // Catch:{ all -> 0x00a6 }
            int r5 = r4.zzbjv     // Catch:{ all -> 0x00a6 }
            int r5 = r5 + r8
            r4.zzbjv = r5     // Catch:{ all -> 0x00a6 }
            int r5 = r4.zzbjw     // Catch:{ all -> 0x00a6 }
            int r6 = r4.zzajq     // Catch:{ all -> 0x00a6 }
            if (r5 != r6) goto L_0x0086
            r4.zzbjw = r7     // Catch:{ all -> 0x00a6 }
        L_0x0086:
            int r5 = r4.length     // Catch:{ all -> 0x00a6 }
            if (r5 <= 0) goto L_0x0091
            long[] r5 = r4.zzahq     // Catch:{ all -> 0x00a6 }
            int r6 = r4.zzbjw     // Catch:{ all -> 0x00a6 }
            r6 = r5[r6]     // Catch:{ all -> 0x00a6 }
            goto L_0x0098
        L_0x0091:
            long r5 = r10.zzajx     // Catch:{ all -> 0x00a6 }
            int r7 = r10.size     // Catch:{ all -> 0x00a6 }
            long r7 = (long) r7     // Catch:{ all -> 0x00a6 }
            long r6 = r5 + r7
        L_0x0098:
            r10.zzbkd = r6     // Catch:{ all -> 0x00a6 }
            monitor-exit(r4)
            return r3
        L_0x009c:
            com.google.android.gms.internal.ads.zzlh[] r6 = r4.zzbju     // Catch:{ all -> 0x00a6 }
            int r7 = r4.zzbjw     // Catch:{ all -> 0x00a6 }
            r6 = r6[r7]     // Catch:{ all -> 0x00a6 }
            r5.zzaue = r6     // Catch:{ all -> 0x00a6 }
            monitor-exit(r4)
            return r1
        L_0x00a6:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqr.zza(com.google.android.gms.internal.ads.zzlj, com.google.android.gms.internal.ads.zznd, boolean, boolean, com.google.android.gms.internal.ads.zzlh, com.google.android.gms.internal.ads.zzqs):int");
    }

    public final synchronized long zzjm() {
        if (!zzjk()) {
            return -1;
        }
        int i = ((this.zzbjw + this.length) - 1) % this.zzajq;
        this.zzbjw = (this.zzbjw + this.length) % this.zzajq;
        this.zzbjv += this.length;
        this.length = 0;
        return this.zzahq[i] + ((long) this.zzahp[i]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0060, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long zzg(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.zzjk()     // Catch:{ all -> 0x0061 }
            r1 = -1
            if (r0 == 0) goto L_0x005f
            long[] r0 = r8.zzahs     // Catch:{ all -> 0x0061 }
            int r3 = r8.zzbjw     // Catch:{ all -> 0x0061 }
            r3 = r0[r3]     // Catch:{ all -> 0x0061 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0014
            goto L_0x005f
        L_0x0014:
            long r3 = r8.zzbjz     // Catch:{ all -> 0x0061 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x001e
            if (r11 != 0) goto L_0x001e
            monitor-exit(r8)
            return r1
        L_0x001e:
            r11 = 0
            int r0 = r8.zzbjw     // Catch:{ all -> 0x0061 }
            r3 = -1
            r11 = -1
            r4 = 0
        L_0x0024:
            int r5 = r8.zzbjx     // Catch:{ all -> 0x0061 }
            if (r0 == r5) goto L_0x0041
            long[] r5 = r8.zzahs     // Catch:{ all -> 0x0061 }
            r6 = r5[r0]     // Catch:{ all -> 0x0061 }
            int r5 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x0041
            int[] r5 = r8.zzajr     // Catch:{ all -> 0x0061 }
            r5 = r5[r0]     // Catch:{ all -> 0x0061 }
            r5 = r5 & 1
            if (r5 == 0) goto L_0x0039
            r11 = r4
        L_0x0039:
            int r0 = r0 + 1
            int r5 = r8.zzajq     // Catch:{ all -> 0x0061 }
            int r0 = r0 % r5
            int r4 = r4 + 1
            goto L_0x0024
        L_0x0041:
            if (r11 != r3) goto L_0x0045
            monitor-exit(r8)
            return r1
        L_0x0045:
            int r9 = r8.zzbjw     // Catch:{ all -> 0x0061 }
            int r9 = r9 + r11
            int r10 = r8.zzajq     // Catch:{ all -> 0x0061 }
            int r9 = r9 % r10
            r8.zzbjw = r9     // Catch:{ all -> 0x0061 }
            int r9 = r8.zzbjv     // Catch:{ all -> 0x0061 }
            int r9 = r9 + r11
            r8.zzbjv = r9     // Catch:{ all -> 0x0061 }
            int r9 = r8.length     // Catch:{ all -> 0x0061 }
            int r9 = r9 - r11
            r8.length = r9     // Catch:{ all -> 0x0061 }
            long[] r9 = r8.zzahq     // Catch:{ all -> 0x0061 }
            int r10 = r8.zzbjw     // Catch:{ all -> 0x0061 }
            r10 = r9[r10]     // Catch:{ all -> 0x0061 }
            monitor-exit(r8)
            return r10
        L_0x005f:
            monitor-exit(r8)
            return r1
        L_0x0061:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqr.zzg(long, boolean):long");
    }

    public final synchronized boolean zzg(zzlh zzlh) {
        if (zzlh == null) {
            this.zzbkb = true;
            return false;
        }
        this.zzbkb = false;
        if (zzsy.zza(zzlh, this.zzbkc)) {
            return false;
        }
        this.zzbkc = zzlh;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00e8, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(long r6, int r8, long r9, int r11, com.google.android.gms.internal.ads.zznx r12) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.zzbka     // Catch:{ all -> 0x00e9 }
            r1 = 0
            if (r0 == 0) goto L_0x000e
            r0 = r8 & 1
            if (r0 != 0) goto L_0x000c
            monitor-exit(r5)
            return
        L_0x000c:
            r5.zzbka = r1     // Catch:{ all -> 0x00e9 }
        L_0x000e:
            boolean r0 = r5.zzbkb     // Catch:{ all -> 0x00e9 }
            r0 = r0 ^ 1
            com.google.android.gms.internal.ads.zzsk.checkState(r0)     // Catch:{ all -> 0x00e9 }
            r5.zzep(r6)     // Catch:{ all -> 0x00e9 }
            long[] r0 = r5.zzahs     // Catch:{ all -> 0x00e9 }
            int r2 = r5.zzbjx     // Catch:{ all -> 0x00e9 }
            r0[r2] = r6     // Catch:{ all -> 0x00e9 }
            long[] r6 = r5.zzahq     // Catch:{ all -> 0x00e9 }
            int r7 = r5.zzbjx     // Catch:{ all -> 0x00e9 }
            r6[r7] = r9     // Catch:{ all -> 0x00e9 }
            int[] r6 = r5.zzahp     // Catch:{ all -> 0x00e9 }
            int r7 = r5.zzbjx     // Catch:{ all -> 0x00e9 }
            r6[r7] = r11     // Catch:{ all -> 0x00e9 }
            int[] r6 = r5.zzajr     // Catch:{ all -> 0x00e9 }
            int r7 = r5.zzbjx     // Catch:{ all -> 0x00e9 }
            r6[r7] = r8     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zznx[] r6 = r5.zzbjt     // Catch:{ all -> 0x00e9 }
            int r7 = r5.zzbjx     // Catch:{ all -> 0x00e9 }
            r6[r7] = r12     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzlh[] r6 = r5.zzbju     // Catch:{ all -> 0x00e9 }
            int r7 = r5.zzbjx     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzlh r8 = r5.zzbkc     // Catch:{ all -> 0x00e9 }
            r6[r7] = r8     // Catch:{ all -> 0x00e9 }
            int[] r6 = r5.zzbjs     // Catch:{ all -> 0x00e9 }
            int r7 = r5.zzbjx     // Catch:{ all -> 0x00e9 }
            r6[r7] = r1     // Catch:{ all -> 0x00e9 }
            int r6 = r5.length     // Catch:{ all -> 0x00e9 }
            int r6 = r6 + 1
            r5.length = r6     // Catch:{ all -> 0x00e9 }
            int r6 = r5.length     // Catch:{ all -> 0x00e9 }
            int r7 = r5.zzajq     // Catch:{ all -> 0x00e9 }
            if (r6 != r7) goto L_0x00d9
            int r6 = r5.zzajq     // Catch:{ all -> 0x00e9 }
            int r6 = r6 + 1000
            int[] r7 = new int[r6]     // Catch:{ all -> 0x00e9 }
            long[] r8 = new long[r6]     // Catch:{ all -> 0x00e9 }
            long[] r9 = new long[r6]     // Catch:{ all -> 0x00e9 }
            int[] r10 = new int[r6]     // Catch:{ all -> 0x00e9 }
            int[] r11 = new int[r6]     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zznx[] r12 = new com.google.android.gms.internal.ads.zznx[r6]     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzlh[] r0 = new com.google.android.gms.internal.ads.zzlh[r6]     // Catch:{ all -> 0x00e9 }
            int r2 = r5.zzajq     // Catch:{ all -> 0x00e9 }
            int r3 = r5.zzbjw     // Catch:{ all -> 0x00e9 }
            int r2 = r2 - r3
            long[] r3 = r5.zzahq     // Catch:{ all -> 0x00e9 }
            int r4 = r5.zzbjw     // Catch:{ all -> 0x00e9 }
            java.lang.System.arraycopy(r3, r4, r8, r1, r2)     // Catch:{ all -> 0x00e9 }
            long[] r3 = r5.zzahs     // Catch:{ all -> 0x00e9 }
            int r4 = r5.zzbjw     // Catch:{ all -> 0x00e9 }
            java.lang.System.arraycopy(r3, r4, r9, r1, r2)     // Catch:{ all -> 0x00e9 }
            int[] r3 = r5.zzajr     // Catch:{ all -> 0x00e9 }
            int r4 = r5.zzbjw     // Catch:{ all -> 0x00e9 }
            java.lang.System.arraycopy(r3, r4, r10, r1, r2)     // Catch:{ all -> 0x00e9 }
            int[] r3 = r5.zzahp     // Catch:{ all -> 0x00e9 }
            int r4 = r5.zzbjw     // Catch:{ all -> 0x00e9 }
            java.lang.System.arraycopy(r3, r4, r11, r1, r2)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zznx[] r3 = r5.zzbjt     // Catch:{ all -> 0x00e9 }
            int r4 = r5.zzbjw     // Catch:{ all -> 0x00e9 }
            java.lang.System.arraycopy(r3, r4, r12, r1, r2)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzlh[] r3 = r5.zzbju     // Catch:{ all -> 0x00e9 }
            int r4 = r5.zzbjw     // Catch:{ all -> 0x00e9 }
            java.lang.System.arraycopy(r3, r4, r0, r1, r2)     // Catch:{ all -> 0x00e9 }
            int[] r3 = r5.zzbjs     // Catch:{ all -> 0x00e9 }
            int r4 = r5.zzbjw     // Catch:{ all -> 0x00e9 }
            java.lang.System.arraycopy(r3, r4, r7, r1, r2)     // Catch:{ all -> 0x00e9 }
            int r3 = r5.zzbjw     // Catch:{ all -> 0x00e9 }
            long[] r4 = r5.zzahq     // Catch:{ all -> 0x00e9 }
            java.lang.System.arraycopy(r4, r1, r8, r2, r3)     // Catch:{ all -> 0x00e9 }
            long[] r4 = r5.zzahs     // Catch:{ all -> 0x00e9 }
            java.lang.System.arraycopy(r4, r1, r9, r2, r3)     // Catch:{ all -> 0x00e9 }
            int[] r4 = r5.zzajr     // Catch:{ all -> 0x00e9 }
            java.lang.System.arraycopy(r4, r1, r10, r2, r3)     // Catch:{ all -> 0x00e9 }
            int[] r4 = r5.zzahp     // Catch:{ all -> 0x00e9 }
            java.lang.System.arraycopy(r4, r1, r11, r2, r3)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zznx[] r4 = r5.zzbjt     // Catch:{ all -> 0x00e9 }
            java.lang.System.arraycopy(r4, r1, r12, r2, r3)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzlh[] r4 = r5.zzbju     // Catch:{ all -> 0x00e9 }
            java.lang.System.arraycopy(r4, r1, r0, r2, r3)     // Catch:{ all -> 0x00e9 }
            int[] r4 = r5.zzbjs     // Catch:{ all -> 0x00e9 }
            java.lang.System.arraycopy(r4, r1, r7, r2, r3)     // Catch:{ all -> 0x00e9 }
            r5.zzahq = r8     // Catch:{ all -> 0x00e9 }
            r5.zzahs = r9     // Catch:{ all -> 0x00e9 }
            r5.zzajr = r10     // Catch:{ all -> 0x00e9 }
            r5.zzahp = r11     // Catch:{ all -> 0x00e9 }
            r5.zzbjt = r12     // Catch:{ all -> 0x00e9 }
            r5.zzbju = r0     // Catch:{ all -> 0x00e9 }
            r5.zzbjs = r7     // Catch:{ all -> 0x00e9 }
            r5.zzbjw = r1     // Catch:{ all -> 0x00e9 }
            int r7 = r5.zzajq     // Catch:{ all -> 0x00e9 }
            r5.zzbjx = r7     // Catch:{ all -> 0x00e9 }
            int r7 = r5.zzajq     // Catch:{ all -> 0x00e9 }
            r5.length = r7     // Catch:{ all -> 0x00e9 }
            r5.zzajq = r6     // Catch:{ all -> 0x00e9 }
            monitor-exit(r5)
            return
        L_0x00d9:
            int r6 = r5.zzbjx     // Catch:{ all -> 0x00e9 }
            int r6 = r6 + 1
            r5.zzbjx = r6     // Catch:{ all -> 0x00e9 }
            int r6 = r5.zzbjx     // Catch:{ all -> 0x00e9 }
            int r7 = r5.zzajq     // Catch:{ all -> 0x00e9 }
            if (r6 != r7) goto L_0x00e7
            r5.zzbjx = r1     // Catch:{ all -> 0x00e9 }
        L_0x00e7:
            monitor-exit(r5)
            return
        L_0x00e9:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqr.zza(long, int, long, int, com.google.android.gms.internal.ads.zznx):void");
    }

    public final synchronized void zzep(long j) {
        this.zzbjz = Math.max(this.zzbjz, j);
    }
}
