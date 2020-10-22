package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzaug {
    private final zzatt zzdqv;
    private final Context zzys;

    public zzaug(Context context, String str) {
        this.zzys = context.getApplicationContext();
        this.zzdqv = zzyt.zzpb().zzc(context, str, new zzamo());
    }

    public final void zza(zzaaz zzaaz, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            this.zzdqv.zza(zzyc.zza(this.zzys, zzaaz), (zzaub) new zzaul(rewardedAdLoadCallback));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zzdqv.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return "";
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            this.zzdqv.zza(new zzaum(serverSideVerificationOptions));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        try {
            this.zzdqv.zza((zzaao) new zzabz(onAdMetadataChangedListener));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final Bundle getAdMetadata() {
        try {
            return this.zzdqv.getAdMetadata();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return new Bundle();
        }
    }

    public final boolean isLoaded() {
        try {
            return this.zzdqv.isLoaded();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        try {
            this.zzdqv.zza((zzatw) new zzaui(rewardedAdCallback));
            this.zzdqv.zzj(ObjectWrapper.wrap(activity));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        try {
            this.zzdqv.zza((zzatw) new zzaui(rewardedAdCallback));
            this.zzdqv.zza(ObjectWrapper.wrap(activity), z);
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Nullable
    public final RewardItem getRewardItem() {
        try {
            zzatq zzqh = this.zzdqv.zzqh();
            if (zzqh == null) {
                return null;
            }
            return new zzauh(zzqh);
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
