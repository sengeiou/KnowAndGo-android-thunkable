package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

final class zzdpz implements zzdpi {
    private final int flags;
    private final String info;
    private final Object[] zzhjr;
    private final zzdpk zzhju;

    zzdpz(zzdpk zzdpk, String str, Object[] objArr) {
        this.zzhju = zzdpk;
        this.info = str;
        this.zzhjr = objArr;
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
    public final String zzazi() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzazj() {
        return this.zzhjr;
    }

    public final zzdpk zzazb() {
        return this.zzhju;
    }

    public final int zzayz() {
        return (this.flags & 1) == 1 ? zzdob.zze.zzhhs : zzdob.zze.zzhht;
    }

    public final boolean zzaza() {
        return (this.flags & 2) == 2;
    }
}
