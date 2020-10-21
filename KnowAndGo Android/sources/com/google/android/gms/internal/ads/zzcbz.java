package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import javax.annotation.Nullable;

public final class zzcbz extends zzaex {
    @Nullable
    private final String zzfis;
    private final zzbyt zzfmq;
    private final zzbyn zzfpj;

    public zzcbz(@Nullable String str, zzbyn zzbyn, zzbyt zzbyt) {
        this.zzfis = str;
        this.zzfpj = zzbyn;
        this.zzfmq = zzbyt;
    }

    public final IObjectWrapper zzrh() throws RemoteException {
        return ObjectWrapper.wrap(this.zzfpj);
    }

    public final String getHeadline() throws RemoteException {
        return this.zzfmq.getHeadline();
    }

    public final List getImages() throws RemoteException {
        return this.zzfmq.getImages();
    }

    public final String getBody() throws RemoteException {
        return this.zzfmq.getBody();
    }

    public final zzaei zzri() throws RemoteException {
        return this.zzfmq.zzri();
    }

    public final String getCallToAction() throws RemoteException {
        return this.zzfmq.getCallToAction();
    }

    public final double getStarRating() throws RemoteException {
        return this.zzfmq.getStarRating();
    }

    public final String getStore() throws RemoteException {
        return this.zzfmq.getStore();
    }

    public final String getPrice() throws RemoteException {
        return this.zzfmq.getPrice();
    }

    public final Bundle getExtras() throws RemoteException {
        return this.zzfmq.getExtras();
    }

    public final void destroy() throws RemoteException {
        this.zzfpj.destroy();
    }

    public final zzaar getVideoController() throws RemoteException {
        return this.zzfmq.getVideoController();
    }

    public final void performClick(Bundle bundle) throws RemoteException {
        this.zzfpj.zzf(bundle);
    }

    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        return this.zzfpj.zzh(bundle);
    }

    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        this.zzfpj.zzg(bundle);
    }

    public final zzaea zzrj() throws RemoteException {
        return this.zzfmq.zzrj();
    }

    public final IObjectWrapper zzrk() throws RemoteException {
        return this.zzfmq.zzrk();
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return this.zzfis;
    }
}
