package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzwd implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzwb zzbxa;
    private final /* synthetic */ zzvv zzbxb;
    private final /* synthetic */ zzbbr zzbxc;

    zzwd(zzwb zzwb, zzvv zzvv, zzbbr zzbbr) {
        this.zzbxa = zzwb;
        this.zzbxb = zzvv;
        this.zzbxc = zzbbr;
    }

    public final void onConnectionSuspended(int i) {
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzbxa.lock) {
            if (!this.zzbxa.zzbwz) {
                boolean unused = this.zzbxa.zzbwz = true;
                zzvu zzd = this.zzbxa.zzbwo;
                if (zzd != null) {
                    this.zzbxc.zza(new zzwf(this.zzbxc, zzaxg.zzc(new zzwe(this, zzd, this.zzbxb, this.zzbxc))), zzbbm.zzeaf);
                }
            }
        }
    }
}
