package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzckj implements zzcka<zzbnf, zzams, zzcla> {
    private final zzbai zzbrc;
    private final zzboc zzfzo;
    private final Context zzlj;

    public zzckj(Context context, zzbai zzbai, zzboc zzboc) {
        this.zzlj = context;
        this.zzbrc = zzbai;
        this.zzfzo = zzboc;
    }

    public final void zza(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzams, zzcla> zzcjy) throws RemoteException {
        zzyd zza = zzcxy.zza(this.zzlj, zzcxm.zzgkg);
        if (this.zzbrc.zzdzd < 4100000) {
            ((zzams) zzcjy.zzdgc).zza(ObjectWrapper.wrap(this.zzlj), zza, zzcxu.zzgkx.zzfjp.zzghg, zzcxm.zzgkh.toString(), (zzamv) zzcjy.zzfzn);
        } else {
            ((zzams) zzcjy.zzdgc).zza(ObjectWrapper.wrap(this.zzlj), zza, zzcxu.zzgkx.zzfjp.zzghg, zzcxm.zzgkh.toString(), zzazc.zza((zzazf) zzcxm.zzgke), (zzamv) zzcjy.zzfzn);
        }
    }

    public final /* synthetic */ Object zzb(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        zzboc zzboc = this.zzfzo;
        zzbpr zzbpr = new zzbpr(zzcxu, zzcxm, zzcjy.zzfis);
        zzams zzams = (zzams) zzcjy.zzdgc;
        zzams.getClass();
        zzbng zza = zzboc.zza(zzbpr, new zzbnk((View) ObjectWrapper.unwrap(((zzams) zzcjy.zzdgc).zzse()), (zzbgz) null, zzckk.zza(zzams), zzcxm.zzgkg.get(0)));
        zza.zzadz().zzq((View) ObjectWrapper.unwrap(((zzams) zzcjy.zzdgc).zzse()));
        ((zzcla) zzcjy.zzfzn).zza((zzamv) zza.zzadi());
        return zza.zzadx();
    }
}
