package com.google.android.gms.internal.ads;

public abstract class zzlr {
    public static final zzlr zzaum = new zzls();

    public abstract zzlt zza(int i, zzlt zzlt, boolean z);

    public abstract zzlu zza(int i, zzlu zzlu, boolean z, long j);

    public abstract int zzc(Object obj);

    public abstract int zzhf();

    public abstract int zzhg();

    public final boolean isEmpty() {
        return zzhf() == 0;
    }

    public final zzlu zza(int i, zzlu zzlu, boolean z) {
        return zza(i, zzlu, false, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
        if ((zzhf() - 1) == 0) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(int r2, com.google.android.gms.internal.ads.zzlt r3, com.google.android.gms.internal.ads.zzlu r4, int r5) {
        /*
            r1 = this;
            r0 = 0
            r1.zza((int) r2, (com.google.android.gms.internal.ads.zzlt) r3, (boolean) r0)
            r1.zza((int) r0, (com.google.android.gms.internal.ads.zzlu) r4, (boolean) r0)
            r3 = 1
            if (r2 != 0) goto L_0x002c
            r2 = -1
            switch(r5) {
                case 0: goto L_0x001d;
                case 1: goto L_0x001b;
                case 2: goto L_0x0014;
                default: goto L_0x000e;
            }
        L_0x000e:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            r2.<init>()
            throw r2
        L_0x0014:
            int r5 = r1.zzhf()
            int r5 = r5 - r3
            if (r5 != 0) goto L_0x0025
        L_0x001b:
            r3 = 0
            goto L_0x0025
        L_0x001d:
            int r5 = r1.zzhf()
            int r5 = r5 - r3
            if (r5 != 0) goto L_0x0025
            r3 = -1
        L_0x0025:
            if (r3 != r2) goto L_0x0028
            return r2
        L_0x0028:
            r1.zza((int) r3, (com.google.android.gms.internal.ads.zzlu) r4, (boolean) r0)
            return r0
        L_0x002c:
            int r2 = r2 + r3
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlr.zza(int, com.google.android.gms.internal.ads.zzlt, com.google.android.gms.internal.ads.zzlu, int):int");
    }
}
