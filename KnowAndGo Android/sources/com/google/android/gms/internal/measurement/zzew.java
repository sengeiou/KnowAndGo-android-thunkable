package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

final class zzew extends zzea.zzb {
    private final /* synthetic */ zzea zzadv;
    private final /* synthetic */ Bundle zzaem;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzew(zzea zzea, Bundle bundle) {
        super(zzea);
        this.zzadv = zzea;
        this.zzaem = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void zzgd() throws RemoteException {
        this.zzadv.zzadr.setConditionalUserProperty(this.zzaem, this.timestamp);
    }
}
