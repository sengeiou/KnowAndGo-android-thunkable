package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;

final class zzape implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {
    private final /* synthetic */ zzamv zzdhf;
    private final /* synthetic */ zzaom zzdhg;
    private final /* synthetic */ zzapc zzdhh;

    zzape(zzapc zzapc, zzaom zzaom, zzamv zzamv) {
        this.zzdhh = zzapc;
        this.zzdhg = zzaom;
        this.zzdhf = zzamv;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationInterstitialAdCallback onSuccess(MediationInterstitialAd mediationInterstitialAd) {
        try {
            MediationInterstitialAd unused = this.zzdhh.zzdhd = mediationInterstitialAd;
            this.zzdhg.zzsw();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
        return new zzapi(this.zzdhf);
    }

    public final void onFailure(String str) {
        try {
            this.zzdhg.zzdb(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
