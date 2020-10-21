package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzanx implements Runnable {
    private final /* synthetic */ zzanu zzdgx;

    zzanx(zzanu zzanu) {
        this.zzdgx = zzanu;
    }

    public final void run() {
        try {
            this.zzdgx.zzdgl.onAdLoaded();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}
