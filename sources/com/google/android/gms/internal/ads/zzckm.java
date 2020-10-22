package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzckm implements zzcka<zzbnf, zzaov, zzcla> {
    /* access modifiers changed from: private */
    public View view;
    private final zzboc zzfzo;
    private final Context zzlj;

    public zzckm(Context context, zzboc zzboc) {
        this.zzlj = context;
        this.zzfzo = zzboc;
    }

    public final void zza(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzaov, zzcla> zzcjy) throws RemoteException {
        ((zzaov) zzcjy.zzdgc).zza(zzcxm.zzemu, zzcxm.zzgkh.toString(), zzcxu.zzgkx.zzfjp.zzghg, ObjectWrapper.wrap(this.zzlj), new zzckp(this, zzcjy), (zzamv) zzcjy.zzfzn, zzcxu.zzgkx.zzfjp.zzdll);
    }

    public final /* synthetic */ Object zzb(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        zzboc zzboc = this.zzfzo;
        zzbpr zzbpr = new zzbpr(zzcxu, zzcxm, zzcjy.zzfis);
        View view2 = this.view;
        zzaov zzaov = (zzaov) zzcjy.zzdgc;
        zzaov.getClass();
        zzbng zza = zzboc.zza(zzbpr, new zzbnk(view2, (zzbgz) null, zzckn.zza(zzaov), zzcxm.zzgkg.get(0)));
        zza.zzadz().zzq(this.view);
        ((zzcla) zzcjy.zzfzn).zza((zzamv) zza.zzadi());
        return zza.zzadx();
    }
}
