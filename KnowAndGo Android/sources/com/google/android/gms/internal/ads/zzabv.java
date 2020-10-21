package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.Nullable;

public final class zzabv extends zzatu {
    public final String getMediationAdapterClassName() throws RemoteException {
        return "";
    }

    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    public final void zza(IObjectWrapper iObjectWrapper, boolean z) {
    }

    public final void zza(zzaao zzaao) throws RemoteException {
    }

    public final void zza(zzatw zzatw) throws RemoteException {
    }

    public final void zza(zzaue zzaue) throws RemoteException {
    }

    public final void zza(zzaum zzaum) {
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Nullable
    public final zzatq zzqh() {
        return null;
    }

    public final void zza(zzxz zzxz, zzaub zzaub) throws RemoteException {
        zzbad.zzen("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzazt.zzyr.post(new zzabw(zzaub));
    }

    public final Bundle getAdMetadata() throws RemoteException {
        return new Bundle();
    }
}
