package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

final class zzcoa extends zzatl {
    private final /* synthetic */ zzbsv zzgcd;
    private final /* synthetic */ zzbri zzgce;
    private final /* synthetic */ zzbse zzgcf;
    private final /* synthetic */ zzbvj zzgcg;

    zzcoa(zzcnw zzcnw, zzbsv zzbsv, zzbri zzbri, zzbse zzbse, zzbvj zzbvj) {
        this.zzgcd = zzbsv;
        this.zzgce = zzbri;
        this.zzgcf = zzbse;
        this.zzgcg = zzbvj;
    }

    public final void zzae(IObjectWrapper iObjectWrapper) {
    }

    public final void zzaf(IObjectWrapper iObjectWrapper) {
    }

    public final void zzb(Bundle bundle) {
    }

    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
    }

    public final void zze(IObjectWrapper iObjectWrapper, int i) {
    }

    public final void zzag(IObjectWrapper iObjectWrapper) {
        this.zzgcd.zzta();
    }

    public final void zzai(IObjectWrapper iObjectWrapper) {
        this.zzgcd.zzsz();
    }

    public final void zzaj(IObjectWrapper iObjectWrapper) {
        this.zzgce.onAdClicked();
    }

    public final void zzak(IObjectWrapper iObjectWrapper) {
        this.zzgcf.onAdLeftApplication();
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzato zzato) {
        this.zzgcg.zza(zzato);
    }

    public final void zzah(IObjectWrapper iObjectWrapper) {
        this.zzgcg.zzrq();
    }

    public final void zzal(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzgcf.onRewardedVideoCompleted();
    }
}
