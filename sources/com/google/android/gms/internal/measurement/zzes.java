package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.measurement.zzea;
import com.google.android.gms.measurement.internal.zzcy;

final class zzes extends zzea.zzb {
    private final /* synthetic */ zzea zzadv;
    private final /* synthetic */ zzcy zzaen;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzes(zzea zzea, zzcy zzcy) {
        super(zzea);
        this.zzadv = zzea;
        this.zzaen = zzcy;
    }

    /* access modifiers changed from: package-private */
    public final void zzgd() throws RemoteException {
        if (this.zzadv.zzadn.containsKey(this.zzaen)) {
            Log.w(this.zzadv.zzadh, "OnEventListener already registered.");
            return;
        }
        zzea.zzd zzd = new zzea.zzd(this.zzaen);
        this.zzadv.zzadn.put(this.zzaen, zzd);
        this.zzadv.zzadr.registerOnMeasurementEventListener(zzd);
    }
}
