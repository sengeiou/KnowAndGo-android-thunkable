package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzvq implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzvn zzbwq;

    zzvq(zzvn zzvn) {
        this.zzbwq = zzvn;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzbwq.lock) {
            try {
                if (this.zzbwq.zzbwo != null) {
                    zzvy unused = this.zzbwq.zzbwp = this.zzbwq.zzbwo.zznk();
                }
            } catch (DeadObjectException e) {
                zzawz.zzc("Unable to obtain a cache service instance.", e);
                this.zzbwq.disconnect();
            }
            this.zzbwq.lock.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i) {
        synchronized (this.zzbwq.lock) {
            zzvy unused = this.zzbwq.zzbwp = null;
            this.zzbwq.lock.notifyAll();
        }
    }
}
