package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzea;

final class zzfc extends zzea.zzb {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzea.zza zzaea;
    private final /* synthetic */ zzea.zze zzafa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfc(zzea.zze zze, Activity activity, zzea.zza zza) {
        super(zzea.this);
        this.zzafa = zze;
        this.val$activity = activity;
        this.zzaea = zza;
    }

    /* access modifiers changed from: package-private */
    public final void zzgd() throws RemoteException {
        zzea.this.zzadr.onActivitySaveInstanceState(ObjectWrapper.wrap(this.val$activity), this.zzaea, this.zzaev);
    }
}
