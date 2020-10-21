package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

public final class zzcqb implements zzbro, zzbsr {
    @GuardedBy("this")
    private zzaub zzgeu;

    public final synchronized void zza(zzaub zzaub) {
        this.zzgeu = zzaub;
    }

    public final synchronized void onAdLoaded() {
        if (this.zzgeu != null) {
            try {
                this.zzgeu.onRewardedAdLoaded();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (this.zzgeu != null) {
            try {
                this.zzgeu.onRewardedAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
