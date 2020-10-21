package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzapd implements MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> {
    private final /* synthetic */ zzaoj zzdhe;
    private final /* synthetic */ zzamv zzdhf;

    zzapd(zzapc zzapc, zzaoj zzaoj, zzamv zzamv) {
        this.zzdhe = zzaoj;
        this.zzdhf = zzamv;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationBannerAdCallback onSuccess(MediationBannerAd mediationBannerAd) {
        try {
            this.zzdhe.zzw(ObjectWrapper.wrap(mediationBannerAd.getView()));
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
        return new zzapi(this.zzdhf);
    }

    public final void onFailure(String str) {
        try {
            this.zzdhe.zzdb(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
