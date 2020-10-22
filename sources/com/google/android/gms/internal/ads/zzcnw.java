package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

public final class zzcnw implements zzcka<zzcdb, zzams, zzclb> {
    /* access modifiers changed from: private */
    public final Executor zzffv;
    private final zzcdf zzgbq;
    private final Context zzlj;

    public zzcnw(Context context, Executor executor, zzcdf zzcdf) {
        this.zzlj = context;
        this.zzffv = executor;
        this.zzgbq = zzcdf;
    }

    public final void zza(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzams, zzclb> zzcjy) throws RemoteException {
        if (!((zzams) zzcjy.zzdgc).isInitialized()) {
            ((zzclb) zzcjy.zzfzn).zza((zzbvo) new zzcny(this, zzcxu, zzcxm, zzcjy));
            ((zzams) zzcjy.zzdgc).zza(ObjectWrapper.wrap(this.zzlj), zzcxu.zzgkx.zzfjp.zzghg, (String) null, (zzatk) zzcjy.zzfzn, zzcxm.zzgkh.toString());
            return;
        }
        zzc(zzcxu, zzcxm, zzcjy);
    }

    /* access modifiers changed from: private */
    public static void zzc(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzams, zzclb> zzcjy) {
        try {
            ((zzams) zzcjy.zzdgc).zza(zzcxu.zzgkx.zzfjp.zzghg, zzcxm.zzgkh.toString());
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcjy.zzfis);
            zzawz.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    public final /* synthetic */ Object zzb(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        zzcdc zza = this.zzgbq.zza(new zzbpr(zzcxu, zzcxm, zzcjy.zzfis), new zzcdd(new zzcnx(zzcjy)));
        zza.zzadd().zza(new zzccy((zzams) zzcjy.zzdgc), this.zzffv);
        zzbse zzade = zza.zzade();
        zzbri zzadf = zza.zzadf();
        ((zzclb) zzcjy.zzfzn).zza((zzatk) new zzcoa(this, zza.zzaef(), zzadf, zzade, zza.zzaek()));
        return zza.zzaej();
    }
}
