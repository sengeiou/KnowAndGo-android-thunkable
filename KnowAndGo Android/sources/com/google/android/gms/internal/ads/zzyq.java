package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzyq extends zzys<zzasw> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzamp zzchv;
    private final /* synthetic */ zzyh zzchw;

    zzyq(zzyh zzyh, Context context, zzamp zzamp) {
        this.zzchw = zzyh;
        this.val$context = context;
        this.zzchv = zzamp;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzov() {
        zzyh.zza(this.val$context, "rewarded_video");
        return new zzabx();
    }

    public final /* synthetic */ Object zzow() throws RemoteException {
        return this.zzchw.zzchp.zza(this.val$context, this.zzchv);
    }

    public final /* synthetic */ Object zza(zzzv zzzv) throws RemoteException {
        return zzzv.zza(ObjectWrapper.wrap(this.val$context), this.zzchv, 15000000);
    }
}
