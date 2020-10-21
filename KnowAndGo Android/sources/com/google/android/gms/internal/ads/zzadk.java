package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzadk implements CustomRenderedAd {
    private final zzadl zzcxx;

    public zzadk(zzadl zzadl) {
        this.zzcxx = zzadl;
    }

    public final String getBaseUrl() {
        try {
            return this.zzcxx.zzqz();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final String getContent() {
        try {
            return this.zzcxx.getContent();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final void onAdRendered(View view) {
        try {
            this.zzcxx.zzo(view != null ? ObjectWrapper.wrap(view) : null);
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void recordClick() {
        try {
            this.zzcxx.recordClick();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void recordImpression() {
        try {
            this.zzcxx.recordImpression();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}
