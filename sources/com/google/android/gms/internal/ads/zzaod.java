package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzaod implements Runnable {
    private final /* synthetic */ zzanu zzdgx;

    zzaod(zzanu zzanu) {
        this.zzdgx = zzanu;
    }

    public final void run() {
        try {
            this.zzdgx.zzdgl.onAdClosed();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}