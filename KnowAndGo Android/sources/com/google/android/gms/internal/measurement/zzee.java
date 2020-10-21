package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzea;

final class zzee extends zzea.zzb {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzea zzadv;
    private final /* synthetic */ String zzaeb;
    private final /* synthetic */ String zzaec;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzee(zzea zzea, Activity activity, String str, String str2) {
        super(zzea);
        this.zzadv = zzea;
        this.val$activity = activity;
        this.zzaeb = str;
        this.zzaec = str2;
    }

    /* access modifiers changed from: package-private */
    public final void zzgd() throws RemoteException {
        this.zzadv.zzadr.setCurrentScreen(ObjectWrapper.wrap(this.val$activity), this.zzaeb, this.zzaec, this.timestamp);
    }
}
