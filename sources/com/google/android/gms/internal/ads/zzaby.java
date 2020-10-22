package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzaby implements Runnable {
    private final /* synthetic */ zzabx zzckd;

    zzaby(zzabx zzabx) {
        this.zzckd = zzabx;
    }

    public final void run() {
        if (this.zzckd.zzckc != null) {
            try {
                this.zzckd.zzckc.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbad.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
