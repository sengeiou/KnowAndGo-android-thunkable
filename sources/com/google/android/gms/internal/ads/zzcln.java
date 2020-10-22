package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcln implements zzcka<zzbvx, zzams, zzcla> {
    private final zzbai zzbrc;
    private final zzbws zzfzy;
    private final Context zzlj;

    public zzcln(Context context, zzbai zzbai, zzbws zzbws) {
        this.zzlj = context;
        this.zzbrc = zzbai;
        this.zzfzy = zzbws;
    }

    public final void zza(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzams, zzcla> zzcjy) throws RemoteException {
        if (this.zzbrc.zzdzd < 4100000) {
            ((zzams) zzcjy.zzdgc).zza(ObjectWrapper.wrap(this.zzlj), zzcxu.zzgkx.zzfjp.zzghg, zzcxm.zzgkh.toString(), (zzamv) zzcjy.zzfzn);
        } else {
            ((zzams) zzcjy.zzdgc).zza(ObjectWrapper.wrap(this.zzlj), zzcxu.zzgkx.zzfjp.zzghg, zzcxm.zzgkh.toString(), zzazc.zza((zzazf) zzcxm.zzgke), (zzamv) zzcjy.zzfzn);
        }
    }

    public final /* synthetic */ Object zzb(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        zzbvy zza = this.zzfzy.zza(new zzbpr(zzcxu, zzcxm, zzcjy.zzfis), new zzbvz(new zzclo(zzcjy)));
        ((zzcla) zzcjy.zzfzn).zza((zzamv) zza.zzadi());
        return zza.zzaee();
    }
}
