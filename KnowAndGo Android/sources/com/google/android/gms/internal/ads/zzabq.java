package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzabq implements Runnable {
    private final /* synthetic */ zzabp zzcjy;

    zzabq(zzabp zzabp) {
        this.zzcjy = zzabp;
    }

    public final void run() {
        if (this.zzcjy.zzcjv != null) {
            try {
                this.zzcjy.zzcjv.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbad.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
