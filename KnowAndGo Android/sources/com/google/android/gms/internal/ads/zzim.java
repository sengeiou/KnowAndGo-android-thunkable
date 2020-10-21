package com.google.android.gms.internal.ads;

final class zzim {
    private int[] zzahp = new int[this.zzajq];
    private long[] zzahq = new long[this.zzajq];
    private long[] zzahs = new long[this.zzajq];
    private int zzajq = 1000;
    private int[] zzajr = new int[this.zzajq];
    private byte[][] zzajs = new byte[this.zzajq][];
    private int zzajt;
    private int zzaju;
    private int zzajv;
    private int zzajw;

    public final void clear() {
        this.zzaju = 0;
        this.zzajv = 0;
        this.zzajw = 0;
        this.zzajt = 0;
    }

    public final synchronized boolean zza(zzhm zzhm, zzin zzin) {
        if (this.zzajt == 0) {
            return false;
        }
        zzhm.zzaga = this.zzahs[this.zzajv];
        zzhm.size = this.zzahp[this.zzajv];
        zzhm.flags = this.zzajr[this.zzajv];
        zzin.zzajx = this.zzahq[this.zzajv];
        zzin.zzajy = this.zzajs[this.zzajv];
        return true;
    }

    public final synchronized long zzfv() {
        this.zzajt--;
        int i = this.zzajv;
        this.zzajv = i + 1;
        this.zzaju++;
        if (this.zzajv == this.zzajq) {
            this.zzajv = 0;
        }
        if (this.zzajt > 0) {
            return this.zzahq[this.zzajv];
        }
        return ((long) this.zzahp[i]) + this.zzahq[i];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0069, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long zzdv(long r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            int r0 = r9.zzajt     // Catch:{ all -> 0x006a }
            r1 = -1
            if (r0 == 0) goto L_0x0068
            long[] r0 = r9.zzahs     // Catch:{ all -> 0x006a }
            int r3 = r9.zzajv     // Catch:{ all -> 0x006a }
            r3 = r0[r3]     // Catch:{ all -> 0x006a }
            int r0 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0012
            goto L_0x0068
        L_0x0012:
            int r0 = r9.zzajw     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x0019
            int r0 = r9.zzajq     // Catch:{ all -> 0x006a }
            goto L_0x001b
        L_0x0019:
            int r0 = r9.zzajw     // Catch:{ all -> 0x006a }
        L_0x001b:
            int r0 = r0 + -1
            long[] r3 = r9.zzahs     // Catch:{ all -> 0x006a }
            r4 = r3[r0]     // Catch:{ all -> 0x006a }
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0027
            monitor-exit(r9)
            return r1
        L_0x0027:
            r0 = 0
            int r3 = r9.zzajv     // Catch:{ all -> 0x006a }
            r4 = -1
            r0 = -1
            r5 = 0
        L_0x002d:
            int r6 = r9.zzajw     // Catch:{ all -> 0x006a }
            if (r3 == r6) goto L_0x004a
            long[] r6 = r9.zzahs     // Catch:{ all -> 0x006a }
            r7 = r6[r3]     // Catch:{ all -> 0x006a }
            int r6 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r6 > 0) goto L_0x004a
            int[] r6 = r9.zzajr     // Catch:{ all -> 0x006a }
            r6 = r6[r3]     // Catch:{ all -> 0x006a }
            r6 = r6 & 1
            if (r6 == 0) goto L_0x0042
            r0 = r5
        L_0x0042:
            int r3 = r3 + 1
            int r6 = r9.zzajq     // Catch:{ all -> 0x006a }
            int r3 = r3 % r6
            int r5 = r5 + 1
            goto L_0x002d
        L_0x004a:
            if (r0 != r4) goto L_0x004e
            monitor-exit(r9)
            return r1
        L_0x004e:
            int r10 = r9.zzajt     // Catch:{ all -> 0x006a }
            int r10 = r10 - r0
            r9.zzajt = r10     // Catch:{ all -> 0x006a }
            int r10 = r9.zzajv     // Catch:{ all -> 0x006a }
            int r10 = r10 + r0
            int r11 = r9.zzajq     // Catch:{ all -> 0x006a }
            int r10 = r10 % r11
            r9.zzajv = r10     // Catch:{ all -> 0x006a }
            int r10 = r9.zzaju     // Catch:{ all -> 0x006a }
            int r10 = r10 + r0
            r9.zzaju = r10     // Catch:{ all -> 0x006a }
            long[] r10 = r9.zzahq     // Catch:{ all -> 0x006a }
            int r11 = r9.zzajv     // Catch:{ all -> 0x006a }
            r0 = r10[r11]     // Catch:{ all -> 0x006a }
            monitor-exit(r9)
            return r0
        L_0x0068:
            monitor-exit(r9)
            return r1
        L_0x006a:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzim.zzdv(long):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00a4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(long r4, int r6, long r7, int r9, byte[] r10) {
        /*
            r3 = this;
            monitor-enter(r3)
            long[] r0 = r3.zzahs     // Catch:{ all -> 0x00a5 }
            int r1 = r3.zzajw     // Catch:{ all -> 0x00a5 }
            r0[r1] = r4     // Catch:{ all -> 0x00a5 }
            long[] r4 = r3.zzahq     // Catch:{ all -> 0x00a5 }
            int r5 = r3.zzajw     // Catch:{ all -> 0x00a5 }
            r4[r5] = r7     // Catch:{ all -> 0x00a5 }
            int[] r4 = r3.zzahp     // Catch:{ all -> 0x00a5 }
            int r5 = r3.zzajw     // Catch:{ all -> 0x00a5 }
            r4[r5] = r9     // Catch:{ all -> 0x00a5 }
            int[] r4 = r3.zzajr     // Catch:{ all -> 0x00a5 }
            int r5 = r3.zzajw     // Catch:{ all -> 0x00a5 }
            r4[r5] = r6     // Catch:{ all -> 0x00a5 }
            byte[][] r4 = r3.zzajs     // Catch:{ all -> 0x00a5 }
            int r5 = r3.zzajw     // Catch:{ all -> 0x00a5 }
            r4[r5] = r10     // Catch:{ all -> 0x00a5 }
            int r4 = r3.zzajt     // Catch:{ all -> 0x00a5 }
            int r4 = r4 + 1
            r3.zzajt = r4     // Catch:{ all -> 0x00a5 }
            int r4 = r3.zzajt     // Catch:{ all -> 0x00a5 }
            int r5 = r3.zzajq     // Catch:{ all -> 0x00a5 }
            r6 = 0
            if (r4 != r5) goto L_0x0095
            int r4 = r3.zzajq     // Catch:{ all -> 0x00a5 }
            int r4 = r4 + 1000
            long[] r5 = new long[r4]     // Catch:{ all -> 0x00a5 }
            long[] r7 = new long[r4]     // Catch:{ all -> 0x00a5 }
            int[] r8 = new int[r4]     // Catch:{ all -> 0x00a5 }
            int[] r9 = new int[r4]     // Catch:{ all -> 0x00a5 }
            byte[][] r10 = new byte[r4][]     // Catch:{ all -> 0x00a5 }
            int r0 = r3.zzajq     // Catch:{ all -> 0x00a5 }
            int r1 = r3.zzajv     // Catch:{ all -> 0x00a5 }
            int r0 = r0 - r1
            long[] r1 = r3.zzahq     // Catch:{ all -> 0x00a5 }
            int r2 = r3.zzajv     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r1, r2, r5, r6, r0)     // Catch:{ all -> 0x00a5 }
            long[] r1 = r3.zzahs     // Catch:{ all -> 0x00a5 }
            int r2 = r3.zzajv     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r1, r2, r7, r6, r0)     // Catch:{ all -> 0x00a5 }
            int[] r1 = r3.zzajr     // Catch:{ all -> 0x00a5 }
            int r2 = r3.zzajv     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r1, r2, r8, r6, r0)     // Catch:{ all -> 0x00a5 }
            int[] r1 = r3.zzahp     // Catch:{ all -> 0x00a5 }
            int r2 = r3.zzajv     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r1, r2, r9, r6, r0)     // Catch:{ all -> 0x00a5 }
            byte[][] r1 = r3.zzajs     // Catch:{ all -> 0x00a5 }
            int r2 = r3.zzajv     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r1, r2, r10, r6, r0)     // Catch:{ all -> 0x00a5 }
            int r1 = r3.zzajv     // Catch:{ all -> 0x00a5 }
            long[] r2 = r3.zzahq     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r2, r6, r5, r0, r1)     // Catch:{ all -> 0x00a5 }
            long[] r2 = r3.zzahs     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r2, r6, r7, r0, r1)     // Catch:{ all -> 0x00a5 }
            int[] r2 = r3.zzajr     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r2, r6, r8, r0, r1)     // Catch:{ all -> 0x00a5 }
            int[] r2 = r3.zzahp     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r2, r6, r9, r0, r1)     // Catch:{ all -> 0x00a5 }
            byte[][] r2 = r3.zzajs     // Catch:{ all -> 0x00a5 }
            java.lang.System.arraycopy(r2, r6, r10, r0, r1)     // Catch:{ all -> 0x00a5 }
            r3.zzahq = r5     // Catch:{ all -> 0x00a5 }
            r3.zzahs = r7     // Catch:{ all -> 0x00a5 }
            r3.zzajr = r8     // Catch:{ all -> 0x00a5 }
            r3.zzahp = r9     // Catch:{ all -> 0x00a5 }
            r3.zzajs = r10     // Catch:{ all -> 0x00a5 }
            r3.zzajv = r6     // Catch:{ all -> 0x00a5 }
            int r5 = r3.zzajq     // Catch:{ all -> 0x00a5 }
            r3.zzajw = r5     // Catch:{ all -> 0x00a5 }
            int r5 = r3.zzajq     // Catch:{ all -> 0x00a5 }
            r3.zzajt = r5     // Catch:{ all -> 0x00a5 }
            r3.zzajq = r4     // Catch:{ all -> 0x00a5 }
            monitor-exit(r3)
            return
        L_0x0095:
            int r4 = r3.zzajw     // Catch:{ all -> 0x00a5 }
            int r4 = r4 + 1
            r3.zzajw = r4     // Catch:{ all -> 0x00a5 }
            int r4 = r3.zzajw     // Catch:{ all -> 0x00a5 }
            int r5 = r3.zzajq     // Catch:{ all -> 0x00a5 }
            if (r4 != r5) goto L_0x00a3
            r3.zzajw = r6     // Catch:{ all -> 0x00a5 }
        L_0x00a3:
            monitor-exit(r3)
            return
        L_0x00a5:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzim.zza(long, int, long, int, byte[]):void");
    }
}
