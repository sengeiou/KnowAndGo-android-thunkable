package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzaim implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzbbr zzbxc;
    private final /* synthetic */ zzaii zzdaz;

    zzaim(zzaii zzaii, zzbbr zzbbr) {
        this.zzdaz = zzaii;
        this.zzbxc = zzbbr;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        try {
            this.zzbxc.set(this.zzdaz.zzdax.zzrs());
        } catch (DeadObjectException e) {
            this.zzbxc.setException(e);
        }
    }

    public final void onConnectionSuspended(int i) {
        zzbbr zzbbr = this.zzbxc;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        zzbbr.setException(new RuntimeException(sb.toString()));
    }
}
