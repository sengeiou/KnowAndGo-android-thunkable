package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcsg implements zzcuz<Bundle> {
    private final double zzdpx;
    private final boolean zzdpy;

    public zzcsg(double d, boolean z) {
        this.zzdpx = d;
        this.zzdpy = z;
    }

    public final /* synthetic */ void zzt(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza = zzcxz.zza(bundle, "device");
        bundle.putBundle("device", zza);
        Bundle zza2 = zzcxz.zza(zza, "battery");
        zza.putBundle("battery", zza2);
        zza2.putBoolean("is_charging", this.zzdpy);
        zza2.putDouble("battery_level", this.zzdpx);
    }
}
