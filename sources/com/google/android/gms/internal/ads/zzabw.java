package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final /* synthetic */ class zzabw implements Runnable {
    private final zzaub zzckb;

    zzabw(zzaub zzaub) {
        this.zzckb = zzaub;
    }

    public final void run() {
        zzaub zzaub = this.zzckb;
        if (zzaub != null) {
            try {
                zzaub.onRewardedAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
