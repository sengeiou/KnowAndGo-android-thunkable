package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzyn extends zzys<zzaab> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzyh zzchw;

    zzyn(zzyh zzyh, Context context) {
        this.zzchw = zzyh;
        this.val$context = context;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzov() {
        zzyh.zza(this.val$context, "mobile_ads_settings");
        return new zzabr();
    }

    public final /* synthetic */ Object zzow() throws RemoteException {
        return this.zzchw.zzchn.zzi(this.val$context);
    }

    public final /* synthetic */ Object zza(zzzv zzzv) throws RemoteException {
        return zzzv.zza(ObjectWrapper.wrap(this.val$context), 15000000);
    }
}
