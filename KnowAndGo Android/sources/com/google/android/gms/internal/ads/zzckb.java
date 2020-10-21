package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzckb implements zzcjv<zzbnf> {
    private final Executor zzffv;
    private final zzcxv zzfjp;
    private final zzcdn zzfqh;
    private final zzboc zzfzo;
    private final zzbam<zzcxm, zzayb> zzfzp;
    private final Context zzlj;

    public zzckb(zzboc zzboc, Context context, Executor executor, zzcdn zzcdn, zzcxv zzcxv, zzbam<zzcxm, zzayb> zzbam) {
        this.zzlj = context;
        this.zzfzo = zzboc;
        this.zzffv = executor;
        this.zzfqh = zzcdn;
        this.zzfjp = zzcxv;
        this.zzfzp = zzbam;
    }

    public final boolean zza(zzcxu zzcxu, zzcxm zzcxm) {
        return (zzcxm.zzgke == null || zzcxm.zzgke.zzdkp == null) ? false : true;
    }

    public final zzbbh<zzbnf> zzb(zzcxu zzcxu, zzcxm zzcxm) {
        return zzbar.zza(zzbar.zzm(null), new zzckc(this, zzcxu, zzcxm), this.zzffv);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(zzbgz zzbgz) {
        zzbgz.zzaac();
        zzbhq zzyb = zzbgz.zzyb();
        if (this.zzfjp.zzgla != null && zzyb != null) {
            zzyb.zzb(this.zzfjp.zzgla);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zza(zzcxu zzcxu, zzcxm zzcxm, Object obj) throws Exception {
        zzcxn zzcxn;
        zzyd zza = zzcxy.zza(this.zzlj, zzcxm.zzgkg);
        zzbgz zzc = this.zzfqh.zzc(zza);
        zzc.zzat(zzcxm.zzdok);
        zzboc zzboc = this.zzfzo;
        zzbpr zzbpr = new zzbpr(zzcxu, zzcxm, (String) null);
        zzcec zzcec = new zzcec(this.zzlj, zzc.getView(), this.zzfzp.apply(zzcxm));
        zzc.getClass();
        zzbpb zzn = zzckd.zzn(zzc);
        if (zza.zzchh) {
            zzcxn = new zzcxn(-3, 0, true);
        } else {
            zzcxn = new zzcxn(zza.width, zza.height, false);
        }
        zzbng zza2 = zzboc.zza(zzbpr, new zzbnk(zzcec, zzc, zzn, zzcxn));
        zza2.zzady().zzb(zzc, false);
        zza2.zzadg().zza(new zzcke(zzc), zzbbm.zzeaf);
        zza2.zzady();
        zzbbh<?> zza3 = zzcdp.zza(zzc, zzcxm.zzgke.zzdkn, zzcxm.zzgke.zzdkp);
        if (zzcxm.zzdpc) {
            zzc.getClass();
            zza3.zza(zzckf.zzo(zzc), this.zzffv);
        }
        zza3.zza(new zzckg(this, zzc), this.zzffv);
        return zzbar.zza(zza3, new zzckh(zza2), zzbbm.zzeaf);
    }
}
