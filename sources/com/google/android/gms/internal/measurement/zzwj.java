package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;

final class zzwj implements zzvt {
    private final int flags;
    private final String info;
    private final Object[] zzcat;
    private final zzvv zzcaw;

    zzwj(zzvv zzvv, String str, Object[] objArr) {
        this.zzcaw = zzvv;
        this.info = str;
        this.zzcat = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.flags = c | (charAt2 << i);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzxv() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzxw() {
        return this.zzcat;
    }

    public final zzvv zzxo() {
        return this.zzcaw;
    }

    public final int zzxm() {
        return (this.flags & 1) == 1 ? zzuo.zze.zzbyu : zzuo.zze.zzbyv;
    }

    public final boolean zzxn() {
        return (this.flags & 2) == 2;
    }
}
