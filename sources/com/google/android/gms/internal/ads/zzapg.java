package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

final class zzapg implements MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> {
    private final /* synthetic */ zzamv zzdhf;
    private final /* synthetic */ zzaop zzdhj;

    zzapg(zzapc zzapc, zzaop zzaop, zzamv zzamv) {
        this.zzdhj = zzaop;
        this.zzdhf = zzamv;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationNativeAdCallback onSuccess(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        try {
            this.zzdhj.zza(new zzaoi(unifiedNativeAdMapper));
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
        return new zzapi(this.zzdhf);
    }

    public final void onFailure(String str) {
        try {
            this.zzdhj.zzdb(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
