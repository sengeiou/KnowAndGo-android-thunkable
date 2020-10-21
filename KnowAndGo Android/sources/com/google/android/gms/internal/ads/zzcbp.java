package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

public final class zzcbp {
    private final Executor zzffv;
    private final zzbva zzfmv;
    private final zzbmy zzfry;

    zzcbp(Executor executor, zzbmy zzbmy, zzbva zzbva) {
        this.zzffv = executor;
        this.zzfmv = zzbva;
        this.zzfry = zzbmy;
    }

    public final void zzk(zzbgz zzbgz) {
        if (zzbgz != null) {
            this.zzfmv.zzq(zzbgz.getView());
            this.zzfmv.zza(new zzcbq(zzbgz), this.zzffv);
            this.zzfmv.zza(new zzcbr(zzbgz), this.zzffv);
            this.zzfmv.zza(this.zzfry, this.zzffv);
            this.zzfry.zzg(zzbgz);
            zzbgz.zza("/trackActiveViewUnit", (zzaho<? super zzbgz>) new zzcbs(this));
            zzbgz.zza("/untrackActiveViewUnit", (zzaho<? super zzbgz>) new zzcbt(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzbgz zzbgz, Map map) {
        this.zzfry.disable();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzbgz zzbgz, Map map) {
        this.zzfry.enable();
    }
}
