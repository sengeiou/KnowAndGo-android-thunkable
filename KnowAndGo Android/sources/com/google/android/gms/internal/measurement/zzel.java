package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

final class zzel extends zzea.zzb {
    private final /* synthetic */ zzea zzadv;
    private final /* synthetic */ zzea.zza zzaea;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzel(zzea zzea, zzea.zza zza) {
        super(zzea);
        this.zzadv = zzea;
        this.zzaea = zza;
    }

    /* access modifiers changed from: package-private */
    public final void zzgd() throws RemoteException {
        this.zzadv.zzadr.generateEventId(this.zzaea);
    }

    /* access modifiers changed from: protected */
    public final void zzge() {
        this.zzaea.zzb((Bundle) null);
    }
}
