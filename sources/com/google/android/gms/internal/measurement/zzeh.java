package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

final class zzeh extends zzea.zzb {
    private final /* synthetic */ zzea zzadv;
    private final /* synthetic */ String zzaee;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeh(zzea zzea, String str) {
        super(zzea);
        this.zzadv = zzea;
        this.zzaee = str;
    }

    /* access modifiers changed from: package-private */
    public final void zzgd() throws RemoteException {
        this.zzadv.zzadr.endAdUnitExposure(this.zzaee, this.zzaev);
    }
}
