package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbqy;

public final class zzcmo extends zzcmn<zzbnf> {
    private final zzbtv zzeqb;
    private final zzbxk zzeqc;
    private final zzcow zzezu;
    private final ViewGroup zzfgu;
    private final zzbtb zzfim;
    private final zzbjm zzgbc;
    private final zzbqy.zza zzgbd;

    public zzcmo(zzbjm zzbjm, zzbqy.zza zza, zzcow zzcow, zzbtv zzbtv, zzbxk zzbxk, zzbtb zzbtb, @Nullable ViewGroup viewGroup) {
        this.zzgbc = zzbjm;
        this.zzgbd = zza;
        this.zzezu = zzcow;
        this.zzeqb = zzbtv;
        this.zzeqc = zzbxk;
        this.zzfim = zzbtb;
        this.zzfgu = viewGroup;
    }

    /* access modifiers changed from: protected */
    public final zzbbh<zzbnf> zza(zzcxv zzcxv, Bundle bundle) {
        return this.zzgbc.zzacj().zzb(this.zzgbd.zza(zzcxv).zze(bundle).zzagh()).zzb(this.zzeqb).zza(this.zzezu).zzb(this.zzeqc).zza(new zzbox(this.zzfim)).zza(new zzbnc(this.zzfgu)).zzads().zzadu();
    }
}
