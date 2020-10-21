package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzym extends zzys<zzzf> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzchu;
    private final /* synthetic */ zzamp zzchv;
    private final /* synthetic */ zzyh zzchw;

    zzym(zzyh zzyh, Context context, String str, zzamp zzamp) {
        this.zzchw = zzyh;
        this.val$context = context;
        this.zzchu = str;
        this.zzchv = zzamp;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzov() {
        zzyh.zza(this.val$context, "native_ad");
        return new zzabl();
    }

    public final /* synthetic */ Object zzow() throws RemoteException {
        return this.zzchw.zzchm.zza(this.val$context, this.zzchu, this.zzchv);
    }

    public final /* synthetic */ Object zza(zzzv zzzv) throws RemoteException {
        return zzzv.zza(ObjectWrapper.wrap(this.val$context), this.zzchu, this.zzchv, 15000000);
    }
}
