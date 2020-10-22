package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;

public final class zzcdn {
    private final zzbhf zzbrt;
    private final zzbai zzbtc;
    private final zzwj zzejd;
    private final zzdh zzeko;
    private final zza zzekq;
    private final zzcxv zzfjp;
    /* access modifiers changed from: private */
    public final zzbtb zzftg;
    private final Context zzlj;

    public zzcdn(zzbhf zzbhf, Context context, zzcxv zzcxv, zzdh zzdh, zzbai zzbai, zza zza, zzwj zzwj, zzbtb zzbtb) {
        this.zzbrt = zzbhf;
        this.zzlj = context;
        this.zzfjp = zzcxv;
        this.zzeko = zzdh;
        this.zzbtc = zzbai;
        this.zzekq = zza;
        this.zzejd = zzwj;
        this.zzftg = zzbtb;
    }

    public final zzbgz zzc(zzyd zzyd) throws zzbhj {
        return zzbhf.zza(this.zzlj, zzbin.zzb(zzyd), zzyd.zzaap, false, false, this.zzeko, this.zzbtc, (zzadi) null, new zzcdo(this), this.zzekq, this.zzejd);
    }
}
