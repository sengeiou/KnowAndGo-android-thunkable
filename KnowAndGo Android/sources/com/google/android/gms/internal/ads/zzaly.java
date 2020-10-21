package com.google.android.gms.internal.ads;

@zzard
public final class zzaly {
    private zzakh zzddw;
    private zzbbr<zzalf> zzddx;

    zzaly(zzakh zzakh) {
        this.zzddw = zzakh;
    }

    private final void zzsd() {
        if (this.zzddx == null) {
            this.zzddx = new zzbbr<>();
            zzbbr<zzalf> zzbbr = this.zzddx;
            this.zzddw.zzb((zzdh) null).zza(new zzalz(zzbbr), new zzama(zzbbr));
        }
    }

    public final zzamd zzb(String str, zzalm zzalm, zzall zzall) {
        zzsd();
        return new zzamd(this.zzddx, str, zzalm, zzall);
    }

    public final void zzc(String str, zzaho<? super zzalf> zzaho) {
        zzsd();
        this.zzddx = (zzbbr) zzbar.zza(this.zzddx, new zzamb(str, zzaho), zzbbm.zzeaf);
    }

    public final void zzd(String str, zzaho<? super zzalf> zzaho) {
        this.zzddx = (zzbbr) zzbar.zza(this.zzddx, new zzamc(str, zzaho), zzbbm.zzeaf);
    }
}
