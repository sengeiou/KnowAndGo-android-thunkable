package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

final class zzef extends zzea.zzb {
    private final /* synthetic */ zzea zzadv;
    private final /* synthetic */ boolean zzaed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzef(zzea zzea, boolean z) {
        super(zzea);
        this.zzadv = zzea;
        this.zzaed = z;
    }

    /* access modifiers changed from: package-private */
    public final void zzgd() throws RemoteException {
        this.zzadv.zzadr.setMeasurementEnabled(this.zzaed, this.timestamp);
    }
}
