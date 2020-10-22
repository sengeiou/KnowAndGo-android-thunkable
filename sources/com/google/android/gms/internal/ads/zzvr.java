package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzvr implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzvn zzbwq;

    zzvr(zzvn zzvn) {
        this.zzbwq = zzvn;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zzbwq.lock) {
            zzvy unused = this.zzbwq.zzbwp = null;
            if (this.zzbwq.zzbwo != null) {
                zzvu unused2 = this.zzbwq.zzbwo = null;
            }
            this.zzbwq.lock.notifyAll();
        }
    }
}
