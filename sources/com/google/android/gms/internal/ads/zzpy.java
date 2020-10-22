package com.google.android.gms.internal.ads;

public final class zzpy implements zzqx {
    private final zzqx[] zzbhz;

    public zzpy(zzqx[] zzqxArr) {
        this.zzbhz = zzqxArr;
    }

    public final long zzix() {
        long j = Long.MAX_VALUE;
        for (zzqx zzix : this.zzbhz) {
            long zzix2 = zzix.zzix();
            if (zzix2 != Long.MIN_VALUE) {
                j = Math.min(j, zzix2);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final boolean zzel(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long zzix = zzix();
            if (zzix == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (zzqx zzqx : this.zzbhz) {
                if (zzqx.zzix() == zzix) {
                    z |= zzqx.zzel(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
