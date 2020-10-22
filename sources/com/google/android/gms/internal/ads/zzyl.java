package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzyl extends zzys<zzzk> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzyd zzcht;
    private final /* synthetic */ String zzchu;
    private final /* synthetic */ zzamp zzchv;
    private final /* synthetic */ zzyh zzchw;

    zzyl(zzyh zzyh, Context context, zzyd zzyd, String str, zzamp zzamp) {
        this.zzchw = zzyh;
        this.val$context = context;
        this.zzcht = zzyd;
        this.zzchu = str;
        this.zzchv = zzamp;
    }

    public final /* synthetic */ Object zzov() {
        zzyh.zza(this.val$context, "interstitial");
        return new zzabp();
    }

    public final /* synthetic */ Object zzow() throws RemoteException {
        return this.zzchw.zzchl.zza(this.val$context, this.zzcht, this.zzchu, this.zzchv, 2);
    }

    public final /* synthetic */ Object zza(zzzv zzzv) throws RemoteException {
        return zzzv.zzb(ObjectWrapper.wrap(this.val$context), this.zzcht, this.zzchu, this.zzchv, 15000000);
    }
}
