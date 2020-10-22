package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
import javax.annotation.concurrent.GuardedBy;

public final class zzcpz extends AdMetadataListener {
    @GuardedBy("this")
    private zzaao zzger;

    public final synchronized void zzb(zzaao zzaao) {
        this.zzger = zzaao;
    }

    public final synchronized void onAdMetadataChanged() {
        if (this.zzger != null) {
            try {
                this.zzger.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
