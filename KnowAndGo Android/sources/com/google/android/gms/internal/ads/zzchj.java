package com.google.android.gms.internal.ads;

public abstract class zzchj implements zzbal<zzarx, zzcxu> {
    /* access modifiers changed from: private */
    public final zzbtg zzfwt;

    public zzchj(zzbtg zzbtg) {
        this.zzfwt = zzbtg;
    }

    /* access modifiers changed from: protected */
    public abstract zzbbh<zzcxu> zze(zzarx zzarx) throws zzcgm;

    public final /* synthetic */ zzbbh zzf(Object obj) throws Exception {
        zzarx zzarx = (zzarx) obj;
        this.zzfwt.zzb(zzarx);
        zzbbh<zzcxu> zze = zze(zzarx);
        zzbar.zza(zze, new zzchk(this), zzbbm.zzeaf);
        return zze;
    }
}
