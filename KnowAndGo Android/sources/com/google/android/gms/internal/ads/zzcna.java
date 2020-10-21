package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

public final class zzcna implements zzcka<zzcdb, zzams, zzcla> {
    private final Executor zzffv;
    private final zzcdf zzgbq;
    private final Context zzlj;

    public zzcna(Context context, Executor executor, zzcdf zzcdf) {
        this.zzlj = context;
        this.zzffv = executor;
        this.zzgbq = zzcdf;
    }

    public final void zza(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzams, zzcla> zzcjy) throws RemoteException {
        try {
            ((zzams) zzcjy.zzdgc).zzb(ObjectWrapper.wrap(this.zzlj), zzcxu.zzgkx.zzfjp.zzghg, zzcxm.zzgkh.toString(), (zzamv) zzcjy.zzfzn);
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcjy.zzfis);
            zzawz.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    public final /* synthetic */ Object zzb(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        zzcdc zza = this.zzgbq.zza(new zzbpr(zzcxu, zzcxm, zzcjy.zzfis), new zzcdd(new zzcnb(zzcjy)));
        zza.zzadd().zza(new zzccy((zzams) zzcjy.zzdgc), this.zzffv);
        ((zzcla) zzcjy.zzfzn).zza((zzamv) zza.zzael());
        return zza.zzaej();
    }
}
