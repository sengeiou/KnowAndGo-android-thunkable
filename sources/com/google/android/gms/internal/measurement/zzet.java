package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.measurement.zzea;
import com.google.android.gms.measurement.internal.zzcy;

final class zzet extends zzea.zzb {
    private final /* synthetic */ zzea zzadv;
    private final /* synthetic */ zzcy zzaen;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzet(zzea zzea, zzcy zzcy) {
        super(zzea);
        this.zzadv = zzea;
        this.zzaen = zzcy;
    }

    /* access modifiers changed from: package-private */
    public final void zzgd() throws RemoteException {
        zzea.zzd zzd = (zzea.zzd) this.zzadv.zzadn.get(this.zzaen);
        if (zzd == null) {
            Log.w(this.zzadv.zzadh, "OnEventListener had not been registered.");
            return;
        }
        this.zzadv.zzadr.unregisterOnMeasurementEventListener(zzd);
        this.zzadv.zzadn.remove(this.zzaen);
    }
}
