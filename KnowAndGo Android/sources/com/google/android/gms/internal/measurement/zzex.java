package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzea;

final class zzex extends zzea.zzb {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Bundle zzaez;
    private final /* synthetic */ zzea.zze zzafa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzex(zzea.zze zze, Activity activity, Bundle bundle) {
        super(zzea.this);
        this.zzafa = zze;
        this.val$activity = activity;
        this.zzaez = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void zzgd() throws RemoteException {
        zzea.this.zzadr.onActivityCreated(ObjectWrapper.wrap(this.val$activity), this.zzaez, this.zzaev);
    }
}
