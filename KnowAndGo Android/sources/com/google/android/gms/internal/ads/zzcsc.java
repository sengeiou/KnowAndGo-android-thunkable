package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcsc implements zzcuz<Bundle> {
    private final float zzdmd;
    private final int zzdpe;
    private final boolean zzdpm;
    private final boolean zzdpn;
    private final int zzdpr;
    private final int zzdpv;
    private final int zzdpw;
    private final boolean zzggs;

    public zzcsc(int i, boolean z, boolean z2, int i2, int i3, int i4, float f, boolean z3) {
        this.zzdpe = i;
        this.zzdpm = z;
        this.zzdpn = z2;
        this.zzdpr = i2;
        this.zzdpv = i3;
        this.zzdpw = i4;
        this.zzdmd = f;
        this.zzggs = z3;
    }

    public final /* synthetic */ void zzt(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putInt("am", this.zzdpe);
        bundle.putBoolean("ma", this.zzdpm);
        bundle.putBoolean("sp", this.zzdpn);
        bundle.putInt("muv", this.zzdpr);
        bundle.putInt("rm", this.zzdpv);
        bundle.putInt("riv", this.zzdpw);
        bundle.putFloat("android_app_volume", this.zzdmd);
        bundle.putBoolean("android_app_muted", this.zzggs);
    }
}
