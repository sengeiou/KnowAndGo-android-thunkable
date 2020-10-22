package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcnd implements zzcka<zzcdb, zzaov, zzcla> {
    private final zzcdf zzgbq;
    private final Context zzlj;

    public zzcnd(Context context, zzcdf zzcdf) {
        this.zzlj = context;
        this.zzgbq = zzcdf;
    }

    public final void zza(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzaov, zzcla> zzcjy) throws RemoteException {
        ((zzaov) zzcjy.zzdgc).zza(zzcxm.zzemu, zzcxm.zzgkh.toString(), zzcxu.zzgkx.zzfjp.zzghg, ObjectWrapper.wrap(this.zzlj), (zzaos) new zzcng(this, zzcjy), (zzamv) zzcjy.zzfzn);
    }

    public final /* synthetic */ Object zzb(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        zzcjx zzcjx = new zzcjx(zzcxm);
        zzcdc zza = this.zzgbq.zza(new zzbpr(zzcxu, zzcxm, zzcjy.zzfis), new zzcdd(new zzcne(zzcjy, zzcjx)));
        zzcjx.zza(zza.zzadg());
        ((zzcla) zzcjy.zzfzn).zza((zzamv) zza.zzael());
        return zza.zzaej();
    }
}
