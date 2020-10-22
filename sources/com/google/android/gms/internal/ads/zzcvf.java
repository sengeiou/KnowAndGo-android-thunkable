package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

public final class zzcvf implements zzcuz<Bundle> {
    private final boolean zzdpf;
    private final boolean zzdpg;
    private final String zzdpi;
    private final boolean zzdpj;
    private final boolean zzdpk;
    private final boolean zzdpl;
    private final String zzdpo;
    private final String zzdpp;
    private final String zzdpq;
    private final boolean zzdqd;
    private final String zzgil;
    private final String zzgim;

    public zzcvf(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, String str2, String str3, String str4, String str5, boolean z6, String str6) {
        this.zzdpf = z;
        this.zzdpg = z2;
        this.zzdpi = str;
        this.zzdpj = z3;
        this.zzdpk = z4;
        this.zzdpl = z5;
        this.zzdpo = str2;
        this.zzdpp = str3;
        this.zzdpq = str4;
        this.zzgil = str5;
        this.zzdqd = z6;
        this.zzgim = str6;
    }

    public final /* synthetic */ void zzt(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putBoolean("cog", this.zzdpf);
        bundle.putBoolean("coh", this.zzdpg);
        bundle.putString("gl", this.zzdpi);
        bundle.putBoolean("simulator", this.zzdpj);
        bundle.putBoolean("is_latchsky", this.zzdpk);
        bundle.putBoolean("is_sidewinder", this.zzdpl);
        bundle.putString("hl", this.zzdpo);
        bundle.putString("mv", this.zzdpp);
        bundle.putString("submodel", this.zzgim);
        Bundle zza = zzcxz.zza(bundle, "device");
        bundle.putBundle("device", zza);
        zza.putString("build", this.zzgil);
        Bundle zza2 = zzcxz.zza(zza, "browser");
        zza.putBundle("browser", zza2);
        zza2.putBoolean("is_browser_custom_tabs_capable", this.zzdqd);
        if (!TextUtils.isEmpty(this.zzdpq)) {
            Bundle zza3 = zzcxz.zza(zza, "play_store");
            zza.putBundle("play_store", zza3);
            zza3.putString("package_version", this.zzdpq);
        }
    }
}
