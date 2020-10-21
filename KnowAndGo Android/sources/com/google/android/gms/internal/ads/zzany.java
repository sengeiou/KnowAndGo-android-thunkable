package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzany implements Runnable {
    private final /* synthetic */ zzanu zzdgx;

    zzany(zzanu zzanu) {
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
