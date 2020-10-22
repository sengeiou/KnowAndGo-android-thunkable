package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzabn extends zzzd {
    final /* synthetic */ zzabl zzcjw;

    private zzabn(zzabl zzabl) {
        this.zzcjw = zzabl;
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    public final boolean isLoading() throws RemoteException {
        return false;
    }

    public final String zzpj() throws RemoteException {
        return null;
    }

    public final void zza(zzxz zzxz) throws RemoteException {
        zza(zzxz, 1);
    }

    public final void zza(zzxz zzxz, int i) throws RemoteException {
        zzbad.zzen("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzazt.zzyr.post(new zzabo(this));
    }
}
