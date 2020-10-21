package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import javax.annotation.concurrent.GuardedBy;

public final class zzcpy implements AppEventListener {
    @GuardedBy("this")
    private zzzs zzgeq;

    public final synchronized void zzb(zzzs zzzs) {
        this.zzgeq = zzzs;
    }

    public final synchronized zzzs zzale() {
        return this.zzgeq;
    }

    public final synchronized void onAppEvent(String str, String str2) {
        if (this.zzgeq != null) {
            try {
                this.zzgeq.onAppEvent(str, str2);
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAppEvent.", e);
            }
        }
    }
}
