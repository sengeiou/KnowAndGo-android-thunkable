package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

final class zzapf implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzamv zzdhf;
    private final /* synthetic */ zzapc zzdhh;
    private final /* synthetic */ zzaos zzdhi;

    zzapf(zzapc zzapc, zzaos zzaos, zzamv zzamv) {
        this.zzdhh = zzapc;
        this.zzdhi = zzaos;
        this.zzdhf = zzamv;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        try {
            MediationRewardedAd unused = this.zzdhh.zzdgg = mediationRewardedAd;
            this.zzdhi.zzsw();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
        return new zzapi(this.zzdhf);
    }

    public final void onFailure(String str) {
        try {
            this.zzdhi.zzdb(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
