package com.google.android.gms.internal.ads;

import android.util.Log;

final class zzld {
    public final int index;
    public boolean zzacs;
    private final zzlo[] zzaro;
    private final zzrp zzarp;
    private final zzlp[] zzasi;
    private final zzll zzasj;
    private final zzql zzaso;
    public final zzqj zzasw;
    public final Object zzasx;
    public final zzqw[] zzasy;
    private final boolean[] zzasz;
    public final long zzata;
    public int zzatb;
    public long zzatc;
    public boolean zzatd;
    public boolean zzate;
    public zzld zzatf;
    public zzrr zzatg;
    private zzrr zzath;

    public zzld(zzlo[] zzloArr, zzlp[] zzlpArr, long j, zzrp zzrp, zzll zzll, zzql zzql, Object obj, int i, int i2, boolean z, long j2) {
        this.zzaro = zzloArr;
        this.zzasi = zzlpArr;
        this.zzata = j;
        this.zzarp = zzrp;
        this.zzasj = zzll;
        this.zzaso = zzql;
        this.zzasx = zzsk.checkNotNull(obj);
        this.index = i;
        this.zzatb = i2;
        this.zzatd = z;
        this.zzatc = j2;
        this.zzasy = new zzqw[zzloArr.length];
        this.zzasz = new boolean[zzloArr.length];
        this.zzasw = zzql.zza(i2, zzll.zzhe());
    }

    public final long zzgz() {
        return this.zzata - this.zzatc;
    }

    public final void zzd(int i, boolean z) {
        this.zzatb = i;
        this.zzatd = z;
    }

    public final boolean zzha() {
        if (this.zzacs) {
            return !this.zzate || this.zzasw.zzdu() == Long.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzhb() throws com.google.android.gms.internal.ads.zzku {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzrp r0 = r6.zzarp
            com.google.android.gms.internal.ads.zzlp[] r1 = r6.zzasi
            com.google.android.gms.internal.ads.zzqj r2 = r6.zzasw
            com.google.android.gms.internal.ads.zzrb r2 = r2.zziz()
            com.google.android.gms.internal.ads.zzrr r0 = r0.zza(r1, r2)
            com.google.android.gms.internal.ads.zzrr r1 = r6.zzath
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0016
        L_0x0014:
            r1 = 0
            goto L_0x0028
        L_0x0016:
            r4 = 0
        L_0x0017:
            com.google.android.gms.internal.ads.zzro r5 = r0.zzblz
            int r5 = r5.length
            if (r4 >= r5) goto L_0x0027
            boolean r5 = r0.zza(r1, r4)
            if (r5 != 0) goto L_0x0024
            goto L_0x0014
        L_0x0024:
            int r4 = r4 + 1
            goto L_0x0017
        L_0x0027:
            r1 = 1
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            return r3
        L_0x002b:
            r6.zzatg = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzld.zzhb():boolean");
    }

    public final long zze(long j, boolean z) {
        return zza(j, false, new boolean[this.zzaro.length]);
    }

    public final long zza(long j, boolean z, boolean[] zArr) {
        zzro zzro = this.zzatg.zzblz;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzro.length) {
                break;
            }
            boolean[] zArr2 = this.zzasz;
            if (z || !this.zzatg.zza(this.zzath, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long zza = this.zzasw.zza(zzro.zzjs(), this.zzasz, this.zzasy, zArr, j);
        this.zzath = this.zzatg;
        this.zzate = false;
        for (int i2 = 0; i2 < this.zzasy.length; i2++) {
            if (this.zzasy[i2] != null) {
                zzsk.checkState(zzro.zzbi(i2) != null);
                this.zzate = true;
            } else {
                zzsk.checkState(zzro.zzbi(i2) == null);
            }
        }
        this.zzasj.zza(this.zzaro, this.zzatg.zzbly, zzro);
        return zza;
    }

    public final void release() {
        try {
            this.zzaso.zzb(this.zzasw);
        } catch (RuntimeException e) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e);
        }
    }
}
