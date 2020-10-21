package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzclq implements zzcka<zzbvx, zzaov, zzcla> {
    private final zzbws zzfzy;
    private final Context zzlj;

    public zzclq(Context context, zzbws zzbws) {
        this.zzlj = context;
        this.zzfzy = zzbws;
    }

    public final void zza(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzaov, zzcla> zzcjy) throws RemoteException {
        ((zzaov) zzcjy.zzdgc).zza(zzcxm.zzemu, zzcxm.zzgkh.toString(), zzcxu.zzgkx.zzfjp.zzghg, ObjectWrapper.wrap(this.zzlj), (zzaom) new zzclt(this, zzcjy), (zzamv) zzcjy.zzfzn);
    }

    public final /* synthetic */ Object zzb(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        zzcjx zzcjx = new zzcjx(zzcxm);
        zzbvy zza = this.zzfzy.zza(new zzbpr(zzcxu, zzcxm, zzcjy.zzfis), new zzbvz(new zzclr(zzcjy, zzcjx)));
        zzcjx.zza(zza.zzadg());
        ((zzcla) zzcjy.zzfzn).zza((zzamv) zza.zzadi());
        return zza.zzaee();
    }
}
