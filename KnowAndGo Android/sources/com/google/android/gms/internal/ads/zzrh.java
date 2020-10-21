package com.google.android.gms.internal.ads;

import android.text.TextUtils;

public final class zzrh {
    public final int viewportHeight;
    public final int viewportWidth;
    public final String zzble;
    public final String zzblf;
    public final boolean zzblg;
    public final boolean zzblh;
    public final int zzbli;
    public final int zzblj;
    public final int zzblk;
    public final boolean zzbll;
    public final boolean zzblm;
    public final boolean zzbln;

    public zzrh() {
        this((String) null, (String) null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
    }

    private zzrh(String str, String str2, boolean z, boolean z2, int i, int i2, int i3, boolean z3, boolean z4, int i4, int i5, boolean z5) {
        this.zzble = null;
        this.zzblf = null;
        this.zzblg = false;
        this.zzblh = true;
        this.zzbli = Integer.MAX_VALUE;
        this.zzblj = Integer.MAX_VALUE;
        this.zzblk = Integer.MAX_VALUE;
        this.zzbll = true;
        this.zzblm = true;
        this.viewportWidth = Integer.MAX_VALUE;
        this.viewportHeight = Integer.MAX_VALUE;
        this.zzbln = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzrh zzrh = (zzrh) obj;
        return this.zzblh == zzrh.zzblh && this.zzbli == zzrh.zzbli && this.zzblj == zzrh.zzblj && this.zzbll == zzrh.zzbll && this.zzblm == zzrh.zzblm && this.zzbln == zzrh.zzbln && this.viewportWidth == zzrh.viewportWidth && this.viewportHeight == zzrh.viewportHeight && this.zzblk == zzrh.zzblk && TextUtils.equals((CharSequence) null, (CharSequence) null) && TextUtils.equals((CharSequence) null, (CharSequence) null);
    }

    public final int hashCode() {
        String str = null;
        return (((((((((((((((((((str.hashCode() * 31) + str.hashCode()) * 31 * 31) + (this.zzblh ? 1 : 0)) * 31) + this.zzbli) * 31) + this.zzblj) * 31) + this.zzblk) * 31) + (this.zzbll ? 1 : 0)) * 31) + (this.zzblm ? 1 : 0)) * 31) + (this.zzbln ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
    }
}
