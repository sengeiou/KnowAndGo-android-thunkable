package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzabx extends zzasx {
    /* access modifiers changed from: private */
    public zzatb zzckc;

    public final void destroy() throws RemoteException {
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    public final void pause() throws RemoteException {
    }

    public final void resume() throws RemoteException {
    }

    public final void setAppPackageName(String str) {
    }

    public final void setCustomData(String str) throws RemoteException {
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    public final void setUserId(String str) throws RemoteException {
    }

    public final void show() throws RemoteException {
    }

    public final void zza(zzasu zzasu) throws RemoteException {
    }

    public final void zza(zzzp zzzp) throws RemoteException {
    }

    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zza(zzath zzath) throws RemoteException {
        zzbad.zzen("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzazt.zzyr.post(new zzaby(this));
    }

    public final void zza(zzatb zzatb) throws RemoteException {
        this.zzckc = zzatb;
    }

    public final Bundle getAdMetadata() throws RemoteException {
        return new Bundle();
    }
}
