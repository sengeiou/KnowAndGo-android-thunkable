package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwl;
import javax.annotation.concurrent.GuardedBy;

public final class zzcep implements zzbro, zzbrw, zzbsr, zzbtk, zzxr {
    private final zzwj zzftz;
    @GuardedBy("this")
    private boolean zzfua = false;
    @GuardedBy("this")
    private boolean zzfub = false;

    public zzcep(zzwj zzwj) {
        this.zzftz = zzwj;
        zzwj.zza(zzwl.zza.zzb.AD_REQUEST);
    }

    public final void zzb(zzarx zzarx) {
    }

    public final void zza(zzcxu zzcxu) {
        this.zzftz.zza((zzwk) new zzceq(zzcxu));
    }

    public final void onAdLoaded() {
        this.zzftz.zza(zzwl.zza.zzb.AD_LOADED);
    }

    public final void onAdFailedToLoad(int i) {
        switch (i) {
            case 1:
                this.zzftz.zza(zzwl.zza.zzb.AD_FAILED_TO_LOAD_INVALID_REQUEST);
                return;
            case 2:
                this.zzftz.zza(zzwl.zza.zzb.AD_FAILED_TO_LOAD_NETWORK_ERROR);
                return;
            case 3:
                this.zzftz.zza(zzwl.zza.zzb.AD_FAILED_TO_LOAD_NO_FILL);
                return;
            case 4:
                this.zzftz.zza(zzwl.zza.zzb.AD_FAILED_TO_LOAD_TIMEOUT);
                return;
            case 5:
                this.zzftz.zza(zzwl.zza.zzb.AD_FAILED_TO_LOAD_CANCELLED);
                return;
            case 6:
                this.zzftz.zza(zzwl.zza.zzb.AD_FAILED_TO_LOAD_NO_ERROR);
                return;
            case 7:
                this.zzftz.zza(zzwl.zza.zzb.AD_FAILED_TO_LOAD_NOT_FOUND);
                return;
            default:
                this.zzftz.zza(zzwl.zza.zzb.AD_FAILED_TO_LOAD);
                return;
        }
    }

    public final synchronized void onAdImpression() {
        this.zzftz.zza(zzwl.zza.zzb.AD_IMPRESSION);
    }

    public final synchronized void onAdClicked() {
        if (!this.zzfub) {
            this.zzftz.zza(zzwl.zza.zzb.AD_FIRST_CLICK);
            this.zzfub = true;
            return;
        }
        this.zzftz.zza(zzwl.zza.zzb.AD_SUBSEQUENT_CLICK);
    }
}
