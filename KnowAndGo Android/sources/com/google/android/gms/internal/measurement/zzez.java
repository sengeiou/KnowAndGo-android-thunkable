package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzea;

final class zzez extends zzea.zzb {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzea.zze zzafa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzez(zzea.zze zze, Activity activity) {
        super(zzea.this);
        this.zzafa = zze;
        this.val$activity = activity;
    }

    /* access modifiers changed from: package-private */
    public final void zzgd() throws RemoteException {
        zzea.this.zzadr.onActivityResumed(ObjectWrapper.wrap(this.val$activity), this.zzaev);
    }
}
