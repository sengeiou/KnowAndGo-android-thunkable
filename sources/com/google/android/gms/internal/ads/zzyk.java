package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzyk extends zzys<zzzk> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzyd zzcht;
    private final /* synthetic */ String zzchu;
    private final /* synthetic */ zzyh zzchw;

    zzyk(zzyh zzyh, Context context, zzyd zzyd, String str) {
        this.zzchw = zzyh;
        this.val$context = context;
        this.zzcht = zzyd;
        this.zzchu = str;
    }

    public final /* synthetic */ Object zzov() {
        zzyh.zza(this.val$context, "search");
        return new zzabp();
    }

    public final /* synthetic */ Object zzow() throws RemoteException {
        return this.zzchw.zzchl.zza(this.val$context, this.zzcht, this.zzchu, (zzamp) null, 3);
    }

    public final /* synthetic */ Object zza(zzzv zzzv) throws RemoteException {
        return zzzv.zza(ObjectWrapper.wrap(this.val$context), this.zzcht, this.zzchu, 15000000);
    }
}
