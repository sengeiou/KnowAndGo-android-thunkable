package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbqy;

public final class zzcms extends zzcmn<zzcdb> {
    private final zzbtv zzeqb;
    private final zzbjm zzgbc;
    private final zzbqy.zza zzgbd;

    public zzcms(zzbjm zzbjm, zzbqy.zza zza, zzbtv zzbtv) {
        this.zzgbc = zzbjm;
        this.zzgbd = zza;
        this.zzeqb = zzbtv;
    }

    /* access modifiers changed from: protected */
    public final zzbbh<zzcdb> zza(zzcxv zzcxv, Bundle bundle) {
        return this.zzgbc.zzacm().zzd(this.zzgbd.zza(zzcxv).zze(bundle).zzagh()).zzd(this.zzeqb).zzaeh().zzadu();
    }
}
