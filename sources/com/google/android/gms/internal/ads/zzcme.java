package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcme implements zzcka<zzbyn, zzams, zzcla> {
    private final zzbxo zzgav;
    private final Context zzlj;

    public zzcme(Context context, zzbxo zzbxo) {
        this.zzlj = context;
        this.zzgav = zzbxo;
    }

    public final void zza(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzams, zzcla> zzcjy) throws RemoteException {
        ((zzams) zzcjy.zzdgc).zza(ObjectWrapper.wrap(this.zzlj), zzcxu.zzgkx.zzfjp.zzghg, zzcxm.zzgkh.toString(), zzazc.zza((zzazf) zzcxm.zzgke), (zzamv) zzcjy.zzfzn, zzcxu.zzgkx.zzfjp.zzdgs, zzcxu.zzgkx.zzfjp.zzglc);
    }

    private static boolean zza(zzcxu zzcxu, int i) {
        return zzcxu.zzgkx.zzfjp.zzglc.contains(Integer.toString(i));
    }

    public final /* synthetic */ Object zzb(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        zzbyt zzbyt;
        zzana zzsf = ((zzams) zzcjy.zzdgc).zzsf();
        zzand zzsg = ((zzams) zzcjy.zzdgc).zzsg();
        zzang zzsl = ((zzams) zzcjy.zzdgc).zzsl();
        if (zzsl != null && zza(zzcxu, 6)) {
            zzbyt = zzbyt.zzb(zzsl);
        } else if (zzsf != null && zza(zzcxu, 6)) {
            zzbyt = zzbyt.zzb(zzsf);
        } else if (zzsf != null && zza(zzcxu, 2)) {
            zzbyt = zzbyt.zza(zzsf);
        } else if (zzsg != null && zza(zzcxu, 6)) {
            zzbyt = zzbyt.zzb(zzsg);
        } else if (zzsg == null || !zza(zzcxu, 1)) {
            throw new zzcmw("No native ad mappers", 0);
        } else {
            zzbyt = zzbyt.zza(zzsg);
        }
        if (zzcxu.zzgkx.zzfjp.zzglc.contains(Integer.toString(zzbyt.zzahv()))) {
            zzbyw zza = this.zzgav.zza(new zzbpr(zzcxu, zzcxm, zzcjy.zzfis), new zzbzf(zzbyt), new zzcag(zzsg, zzsf, zzsl));
            ((zzcla) zzcjy.zzfzn).zza((zzamv) zza.zzadi());
            return zza.zzadj();
        }
        throw new zzcmw("No corresponding native ad listener", 0);
    }
}
