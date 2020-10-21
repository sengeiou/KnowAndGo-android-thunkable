package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

@zzard
final class zzbbi {
    private final Object zzdzz = new Object();
    private final List<Runnable> zzeaa = new ArrayList();
    private boolean zzeab = false;

    public final void zza(Runnable runnable, Executor executor) {
        synchronized (this.zzdzz) {
            if (this.zzeab) {
                executor.execute(runnable);
            } else {
                this.zzeaa.add(new zzbbj(executor, runnable));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        if (r2 >= r1) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        r3 = r0.get(r2);
        r2 = r2 + 1;
        ((java.lang.Runnable) r3).run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        r0 = r0;
        r1 = r0.size();
        r2 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzxd() {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Object r1 = r4.zzdzz
            monitor-enter(r1)
            boolean r2 = r4.zzeab     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x000e
            monitor-exit(r1)     // Catch:{ all -> 0x0032 }
            return
        L_0x000e:
            java.util.List<java.lang.Runnable> r2 = r4.zzeaa     // Catch:{ all -> 0x0032 }
            r0.addAll(r2)     // Catch:{ all -> 0x0032 }
            java.util.List<java.lang.Runnable> r2 = r4.zzeaa     // Catch:{ all -> 0x0032 }
            r2.clear()     // Catch:{ all -> 0x0032 }
            r2 = 1
            r4.zzeab = r2     // Catch:{ all -> 0x0032 }
            monitor-exit(r1)     // Catch:{ all -> 0x0032 }
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r1 = r0.size()
            r2 = 0
        L_0x0023:
            if (r2 >= r1) goto L_0x0031
            java.lang.Object r3 = r0.get(r2)
            int r2 = r2 + 1
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r3.run()
            goto L_0x0023
        L_0x0031:
            return
        L_0x0032:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0032 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbi.zzxd():void");
    }
}
