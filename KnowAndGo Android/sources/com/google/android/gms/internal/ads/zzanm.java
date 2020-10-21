package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

final class zzanm implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzamv zzdgh;
    private final /* synthetic */ Adapter zzdgi;
    private final /* synthetic */ zzanl zzdgj;

    zzanm(zzanl zzanl, zzamv zzamv, Adapter adapter) {
        this.zzdgj = zzanl;
        this.zzdgh = zzamv;
        this.zzdgi = adapter;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        try {
            MediationRewardedAd unused = this.zzdgj.zzdgg = mediationRewardedAd;
            this.zzdgh.onAdLoaded();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
        return new zzauo(this.zzdgh);
    }

    public final void onFailure(String str) {
        try {
            String canonicalName = this.zzdgi.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 30 + String.valueOf(str).length());
            sb.append(canonicalName);
            sb.append("failed to loaded medation ad: ");
            sb.append(str);
            zzbad.zzdp(sb.toString());
            this.zzdgh.onAdFailedToLoad(0);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
