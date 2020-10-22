package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

public final class zzbqr implements zzbtk {
    private final zzbai zzbrc;
    private final zzaxb zzduk;
    private final zzcgb zzfeh;
    private final zzcxv zzfjp;
    private final Context zzys;

    public zzbqr(Context context, zzcxv zzcxv, zzbai zzbai, zzaxb zzaxb, zzcgb zzcgb) {
        this.zzys = context;
        this.zzfjp = zzcxv;
        this.zzbrc = zzbai;
        this.zzduk = zzaxb;
        this.zzfeh = zzcgb;
    }

    public final void zza(zzcxu zzcxu) {
    }

    public final void zzb(zzarx zzarx) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcsv)).booleanValue()) {
            zzk.zzlo().zza(this.zzys, this.zzbrc, this.zzfjp.zzglb, this.zzduk.zzvr());
        }
        this.zzfeh.zzakd();
    }
}
