package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbqy;

public final class zzcmq extends zzcmn<zzbvx> {
    private final zzbtv zzeqb;
    private final zzcow zzezu;
    private final zzbjm zzgbc;
    private final zzbqy.zza zzgbd;

    public zzcmq(zzbjm zzbjm, zzbqy.zza zza, zzcow zzcow, zzbtv zzbtv) {
        this.zzgbc = zzbjm;
        this.zzgbd = zza;
        this.zzezu = zzcow;
        this.zzeqb = zzbtv;
    }

    /* access modifiers changed from: protected */
    public final zzbbh<zzbvx> zza(zzcxv zzcxv, Bundle bundle) {
        return this.zzgbc.zzack().zzc(this.zzgbd.zza(zzcxv).zze(bundle).zzagh()).zzc(this.zzeqb).zzb(this.zzezu).zzaed().zzadu();
    }
}
