package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzwh implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzwb zzbxa;
    private final /* synthetic */ zzbbr zzbxc;

    zzwh(zzwb zzwb, zzbbr zzbbr) {
        this.zzbxa = zzwb;
        this.zzbxc = zzbbr;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zzbxa.lock) {
            this.zzbxc.setException(new RuntimeException("Connection failed."));
        }
    }
}
