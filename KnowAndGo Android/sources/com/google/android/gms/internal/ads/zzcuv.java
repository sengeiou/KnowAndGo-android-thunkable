package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcuv implements zzcuz<Bundle> {
    private final String zzbsx;
    private final int zzdme;
    private final boolean zzdnb;
    private final boolean zzdzf;
    private final boolean zzgie;
    private final int zzgif;

    public zzcuv(boolean z, boolean z2, String str, boolean z3, int i, int i2) {
        this.zzgie = z;
        this.zzdzf = z2;
        this.zzbsx = str;
        this.zzdnb = z3;
        this.zzdme = i;
        this.zzgif = i2;
    }

    public final /* synthetic */ void zzt(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("js", this.zzbsx);
        bundle.putBoolean("is_nonagon", true);
        bundle.putString("extra_caps", (String) zzyt.zzpe().zzd(zzacu.zzcrv));
        bundle.putInt("target_api", this.zzdme);
        bundle.putInt("dv", this.zzgif);
        Bundle zza = zzcxz.zza(bundle, "sdk_env");
        zza.putBoolean("mf", ((Boolean) zzyt.zzpe().zzd(zzacu.zzcrx)).booleanValue());
        zza.putBoolean("instant_app", this.zzgie);
        zza.putBoolean("lite", this.zzdzf);
        zza.putBoolean("is_privileged_process", this.zzdnb);
        bundle.putBundle("sdk_env", zza);
        Bundle zza2 = zzcxz.zza(zza, "build_meta");
        zza2.putString("cl", "248613007");
        zza2.putString("rapid_rc", "dev");
        zza2.putString("rapid_rollup", "HEAD");
        zza.putBundle("build_meta", zza2);
    }
}
