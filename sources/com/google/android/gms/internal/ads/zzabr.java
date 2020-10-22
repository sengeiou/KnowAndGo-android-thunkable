package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Collections;
import java.util.List;

public final class zzabr extends zzaac {
    private zzait zzcjz;

    public final String getVersionString() {
        return "";
    }

    public final void setAppMuted(boolean z) throws RemoteException {
    }

    public final void setAppVolume(float f) throws RemoteException {
    }

    public final void zza(zzamp zzamp) throws RemoteException {
    }

    public final void zzb(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzbu(String str) throws RemoteException {
    }

    public final void zzbv(String str) throws RemoteException {
    }

    public final void zzc(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    public final float zzpq() throws RemoteException {
        return 1.0f;
    }

    public final boolean zzpr() throws RemoteException {
        return false;
    }

    public final void zza() throws RemoteException {
        zzbad.zzen("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzazt.zzyr.post(new zzabs(this));
    }

    public final void zza(zzait zzait) throws RemoteException {
        this.zzcjz = zzait;
    }

    public final List<zzaio> zzps() throws RemoteException {
        return Collections.EMPTY_LIST;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzqg() {
        if (this.zzcjz != null) {
            try {
                this.zzcjz.zzc(Collections.EMPTY_LIST);
            } catch (RemoteException e) {
                zzbad.zzd("Could not notify onComplete event.", e);
            }
        }
    }
}
