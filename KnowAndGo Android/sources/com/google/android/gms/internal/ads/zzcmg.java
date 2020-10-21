package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcmg implements zzcka<zzbyn, zzaov, zzcla> {
    private final zzbxo zzgav;
    /* access modifiers changed from: private */
    public zzang zzgba;
    private final Context zzlj;

    public zzcmg(Context context, zzbxo zzbxo) {
        this.zzlj = context;
        this.zzgav = zzbxo;
    }

    public final void zza(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzaov, zzcla> zzcjy) throws RemoteException {
        ((zzaov) zzcjy.zzdgc).zza(zzcxm.zzemu, zzcxm.zzgkh.toString(), zzcxu.zzgkx.zzfjp.zzghg, ObjectWrapper.wrap(this.zzlj), (zzaop) new zzcmi(this, zzcjy), (zzamv) zzcjy.zzfzn);
    }

    public final /* synthetic */ Object zzb(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        if (zzcxu.zzgkx.zzfjp.zzglc.contains(Integer.toString(6))) {
            zzbyt zzb = zzbyt.zzb(this.zzgba);
            if (zzcxu.zzgkx.zzfjp.zzglc.contains(Integer.toString(zzb.zzahv()))) {
                zzbyw zza = this.zzgav.zza(new zzbpr(zzcxu, zzcxm, zzcjy.zzfis), new zzbzf(zzb), new zzcag((zzand) null, (zzana) null, this.zzgba));
                ((zzcla) zzcjy.zzfzn).zza((zzamv) zza.zzadi());
                return zza.zzadj();
            }
            throw new zzcmw("No corresponding native ad listener", 0);
        }
        throw new zzcmw("Unified must be used for RTB.", 1);
    }
}
