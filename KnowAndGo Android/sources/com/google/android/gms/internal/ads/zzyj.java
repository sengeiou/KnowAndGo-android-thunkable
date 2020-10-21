package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzyj extends zzys<zzaqg> {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzyh zzchw;

    zzyj(zzyh zzyh, Activity activity) {
        this.zzchw = zzyh;
        this.val$activity = activity;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzov() {
        zzyh.zza(this.val$activity, "ad_overlay");
        return null;
    }

    public final /* synthetic */ Object zzow() throws RemoteException {
        return this.zzchw.zzchr.zzc(this.val$activity);
    }

    public final /* synthetic */ Object zza(zzzv zzzv) throws RemoteException {
        return zzzv.zzf(ObjectWrapper.wrap(this.val$activity));
    }
}
