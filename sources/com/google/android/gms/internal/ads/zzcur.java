package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcur implements zzcuz<Bundle> {
    private final String zzdsf;
    private final String zzghz;
    private final String zzgia;
    private final String zzgib;
    private final Long zzgic;

    public zzcur(String str, String str2, String str3, String str4, Long l) {
        this.zzdsf = str;
        this.zzghz = str2;
        this.zzgia = str3;
        this.zzgib = str4;
        this.zzgic = l;
    }

    public final /* synthetic */ void zzt(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzcxz.zza(bundle, "gmp_app_id", this.zzdsf);
        zzcxz.zza(bundle, "fbs_aiid", this.zzghz);
        zzcxz.zza(bundle, "fbs_aeid", this.zzgia);
        zzcxz.zza(bundle, "apm_id_origin", this.zzgib);
        Long l = this.zzgic;
        if (l != null) {
            bundle.putLong("sai_timeout", l.longValue());
        }
    }
}
