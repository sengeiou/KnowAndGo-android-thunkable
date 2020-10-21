package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

@zzard
public final class zzxw extends RemoteCreator<zzzi> {
    public zzxw() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public final zzzf zza(Context context, String str, zzamp zzamp) {
        try {
            IBinder zzc = ((zzzi) getRemoteCreatorInstance(context)).zzc(ObjectWrapper.wrap(context), str, zzamp, 15000000);
            if (zzc == null) {
                return null;
            }
            IInterface queryLocalInterface = zzc.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzzf) {
                return (zzzf) queryLocalInterface;
            }
            return new zzzh(zzc);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbad.zzd("Could not create remote builder for AdLoader.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        if (queryLocalInterface instanceof zzzi) {
            return (zzzi) queryLocalInterface;
        }
        return new zzzj(iBinder);
    }
}
