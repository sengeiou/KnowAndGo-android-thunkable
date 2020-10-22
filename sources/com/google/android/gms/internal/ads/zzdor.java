package com.google.android.gms.internal.ads;

public class zzdor {
    private static final zzdno zzhch = zzdno.zzaxd();
    private zzdmr zzhiu;
    private volatile zzdpk zzhiv;
    private volatile zzdmr zzhiw;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdor)) {
            return false;
        }
        zzdor zzdor = (zzdor) obj;
        zzdpk zzdpk = this.zzhiv;
        zzdpk zzdpk2 = zzdor.zzhiv;
        if (zzdpk == null && zzdpk2 == null) {
            return zzavf().equals(zzdor.zzavf());
        }
        if (zzdpk != null && zzdpk2 != null) {
            return zzdpk.equals(zzdpk2);
        }
        if (zzdpk != null) {
            return zzdpk.equals(zzdor.zzp(zzdpk.zzaxv()));
        }
        return zzp(zzdpk2.zzaxv()).equals(zzdpk2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzdpk zzp(com.google.android.gms.internal.ads.zzdpk r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzdpk r0 = r1.zzhiv
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzdpk r0 = r1.zzhiv     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzhiv = r2     // Catch:{ zzdok -> 0x0012 }
            com.google.android.gms.internal.ads.zzdmr r0 = com.google.android.gms.internal.ads.zzdmr.zzhcr     // Catch:{ zzdok -> 0x0012 }
            r1.zzhiw = r0     // Catch:{ zzdok -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzhiv = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.ads.zzdmr r2 = com.google.android.gms.internal.ads.zzdmr.zzhcr     // Catch:{ all -> 0x001a }
            r1.zzhiw = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.ads.zzdpk r2 = r1.zzhiv
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdor.zzp(com.google.android.gms.internal.ads.zzdpk):com.google.android.gms.internal.ads.zzdpk");
    }

    public final zzdpk zzq(zzdpk zzdpk) {
        zzdpk zzdpk2 = this.zzhiv;
        this.zzhiu = null;
        this.zzhiw = null;
        this.zzhiv = zzdpk;
        return zzdpk2;
    }

    public final int zzaxj() {
        if (this.zzhiw != null) {
            return this.zzhiw.size();
        }
        if (this.zzhiv != null) {
            return this.zzhiv.zzaxj();
        }
        return 0;
    }

    public final zzdmr zzavf() {
        if (this.zzhiw != null) {
            return this.zzhiw;
        }
        synchronized (this) {
            if (this.zzhiw != null) {
                zzdmr zzdmr = this.zzhiw;
                return zzdmr;
            }
            if (this.zzhiv == null) {
                this.zzhiw = zzdmr.zzhcr;
            } else {
                this.zzhiw = this.zzhiv.zzavf();
            }
            zzdmr zzdmr2 = this.zzhiw;
            return zzdmr2;
        }
    }
}
