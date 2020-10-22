package com.google.android.gms.internal.ads;

import java.util.List;

public final class zzcwn implements zzcva<zzcwm> {
    List<String> zzdly;
    private zzbbl zzfqw;
    zzaci zzgji;

    public zzcwn(zzaci zzaci, zzbbl zzbbl, List<String> list) {
        this.zzgji = zzaci;
        this.zzfqw = zzbbl;
        this.zzdly = list;
    }

    public final zzbbh<zzcwm> zzalm() {
        return this.zzfqw.zza(new zzcwo(this));
    }
}
