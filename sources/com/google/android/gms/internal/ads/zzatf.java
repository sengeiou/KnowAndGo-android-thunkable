package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

@zzard
public final class zzatf extends RemoteCreator<zzasz> {
    public zzatf() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    public final zzasw zza(Context context, zzamp zzamp) {
        try {
            IBinder zzb = ((zzasz) getRemoteCreatorInstance(context)).zzb(ObjectWrapper.wrap(context), zzamp, 15000000);
            if (zzb == null) {
                return null;
            }
            IInterface queryLocalInterface = zzb.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
            if (queryLocalInterface instanceof zzasw) {
                return (zzasw) queryLocalInterface;
            }
            return new zzasy(zzb);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbad.zzd("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        if (queryLocalInterface instanceof zzasz) {
            return (zzasz) queryLocalInterface;
        }
        return new zzata(iBinder);
    }
}
