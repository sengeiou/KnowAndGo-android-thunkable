package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzain implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzbbr zzbxc;

    zzain(zzaii zzaii, zzbbr zzbbr) {
        this.zzbxc = zzbbr;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zzbxc.setException(new RuntimeException("Connection failed."));
    }
}
