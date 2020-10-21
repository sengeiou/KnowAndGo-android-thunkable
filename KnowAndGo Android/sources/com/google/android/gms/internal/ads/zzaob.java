package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzaob implements Runnable {
    private final /* synthetic */ zzanu zzdgx;

    zzaob(zzanu zzanu) {
        this.zzdgx = zzanu;
    }

    public final void run() {
        try {
            this.zzdgx.zzdgl.onAdOpened();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}
