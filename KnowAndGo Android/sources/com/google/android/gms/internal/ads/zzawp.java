package com.google.android.gms.internal.ads;

final class zzawp {
    private final Object lock;
    private volatile int zzdty;
    private volatile long zzdtz;

    private zzawp() {
        this.lock = new Object();
        this.zzdty = zzawq.zzdua;
        this.zzdtz = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzuy() {
        /*
            r8 = this;
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzk.zzln()
            long r0 = r0.currentTimeMillis()
            java.lang.Object r2 = r8.lock
            monitor-enter(r2)
            int r3 = r8.zzdty     // Catch:{ all -> 0x0050 }
            int r4 = com.google.android.gms.internal.ads.zzawq.zzduc     // Catch:{ all -> 0x0050 }
            if (r3 != r4) goto L_0x002d
            long r3 = r8.zzdtz     // Catch:{ all -> 0x0050 }
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r5 = com.google.android.gms.internal.ads.zzacu.zzcwe     // Catch:{ all -> 0x0050 }
            com.google.android.gms.internal.ads.zzacr r6 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ all -> 0x0050 }
            java.lang.Object r5 = r6.zzd(r5)     // Catch:{ all -> 0x0050 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x0050 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x0050 }
            r7 = 0
            long r3 = r3 + r5
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x002d
            int r0 = com.google.android.gms.internal.ads.zzawq.zzdua     // Catch:{ all -> 0x0050 }
            r8.zzdty = r0     // Catch:{ all -> 0x0050 }
        L_0x002d:
            monitor-exit(r2)     // Catch:{ all -> 0x0050 }
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzk.zzln()
            long r0 = r0.currentTimeMillis()
            java.lang.Object r3 = r8.lock
            monitor-enter(r3)
            int r2 = r8.zzdty     // Catch:{ all -> 0x004d }
            r4 = 2
            if (r2 == r4) goto L_0x0040
            monitor-exit(r3)     // Catch:{ all -> 0x004d }
            return
        L_0x0040:
            r2 = 3
            r8.zzdty = r2     // Catch:{ all -> 0x004d }
            int r2 = r8.zzdty     // Catch:{ all -> 0x004d }
            int r4 = com.google.android.gms.internal.ads.zzawq.zzduc     // Catch:{ all -> 0x004d }
            if (r2 != r4) goto L_0x004b
            r8.zzdtz = r0     // Catch:{ all -> 0x004d }
        L_0x004b:
            monitor-exit(r3)     // Catch:{ all -> 0x004d }
            return
        L_0x004d:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x004d }
            throw r0
        L_0x0050:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0050 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawp.zzuy():void");
    }

    /* synthetic */ zzawp(zzawo zzawo) {
        this();
    }
}
