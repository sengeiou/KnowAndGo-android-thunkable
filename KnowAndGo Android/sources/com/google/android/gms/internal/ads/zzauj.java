package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzauj {
    public static zzatt zzd(Context context, String str, zzamp zzamp) {
        try {
            IBinder zzd = ((zzatz) zzbae.zza(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", zzauk.zzbzd)).zzd(ObjectWrapper.wrap(context), str, zzamp, 15000000);
            if (zzd == null) {
                return null;
            }
            IInterface queryLocalInterface = zzd.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            if (queryLocalInterface instanceof zzatt) {
                return (zzatt) queryLocalInterface;
            }
            return new zzatv(zzd);
        } catch (RemoteException | zzbag e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
