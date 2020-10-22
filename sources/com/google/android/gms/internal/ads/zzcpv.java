package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

public final class zzcpv implements zzxr {
    @GuardedBy("this")
    private zzyw zzgen;

    public final synchronized void zzb(zzyw zzyw) {
        this.zzgen = zzyw;
    }

    public final synchronized void onAdClicked() {
        if (this.zzgen != null) {
            try {
                this.zzgen.onAdClicked();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdClicked.", e);
            }
        }
    }
}
