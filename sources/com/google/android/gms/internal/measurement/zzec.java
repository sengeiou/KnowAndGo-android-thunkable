package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

final class zzec extends zzea.zzb {
    private final /* synthetic */ zzea zzadv;
    private final /* synthetic */ String zzadw;
    private final /* synthetic */ String zzadx;
    private final /* synthetic */ Bundle zzady;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzec(zzea zzea, String str, String str2, Bundle bundle) {
        super(zzea);
        this.zzadv = zzea;
        this.zzadw = str;
        this.zzadx = str2;
        this.zzady = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void zzgd() throws RemoteException {
        this.zzadv.zzadr.clearConditionalUserProperty(this.zzadw, this.zzadx, this.zzady);
    }
}
