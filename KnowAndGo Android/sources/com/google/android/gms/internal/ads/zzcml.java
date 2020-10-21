package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbqy;

public final class zzcml extends zzcmn<zzbph> {
    private final zzbtv zzeqb;
    private final zzbxk zzeqc;
    private final zzbjm zzgbc;
    private final zzbqy.zza zzgbd;

    public zzcml(zzbjm zzbjm, zzbxk zzbxk, zzbqy.zza zza, zzbtv zzbtv) {
        this.zzgbc = zzbjm;
        this.zzeqc = zzbxk;
        this.zzgbd = zza;
        this.zzeqb = zzbtv;
    }

    /* access modifiers changed from: protected */
    public final zzbbh<zzbph> zza(zzcxv zzcxv, Bundle bundle) {
        return this.zzgbc.zzacl().zza(this.zzgbd.zza(zzcxv).zze(bundle).zzagh()).zza(this.zzeqb).zza(this.zzeqc).zzacy().zzada();
    }
}
