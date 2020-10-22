package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
import javax.annotation.concurrent.GuardedBy;

public final class zzcpx extends AdMetadataListener {
    @GuardedBy("this")
    private zzzp zzgep;

    public final synchronized void zzb(zzzp zzzp) {
        this.zzgep = zzzp;
    }

    public final synchronized void onAdMetadataChanged() {
        if (this.zzgep != null) {
            try {
                this.zzgep.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdMetadataChanged.", e);
            }
        }
    }
}
