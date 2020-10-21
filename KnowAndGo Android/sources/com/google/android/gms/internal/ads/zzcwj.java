package com.google.android.gms.internal.ads;

public final class zzcwj implements zzcva<zzcwi> {
    private String packageName;
    private zzbbl zzfqw;
    private zzawe zzgjh;

    public zzcwj(zzawe zzawe, zzbbl zzbbl, String str) {
        this.zzgjh = zzawe;
        this.zzfqw = zzbbl;
        this.packageName = str;
    }

    public final zzbbh<zzcwi> zzalm() {
        new zzbbr();
        zzbbh zzm = zzbar.zzm(null);
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvx)).booleanValue()) {
            zzm = this.zzgjh.zzdq(this.packageName);
        }
        zzbbh<String> zzdr = this.zzgjh.zzdr(this.packageName);
        return zzbar.zza(zzm, zzdr).zza(new zzcwk(zzm, zzdr), zzaxg.zzdvp);
    }
}
