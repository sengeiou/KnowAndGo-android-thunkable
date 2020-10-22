package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

public final class zzcle implements zzcjv<zzbvx> {
    private final zzbai zzbrc;
    private final Executor zzffv;
    private final zzcxv zzfjp;
    private final zzcdn zzfqh;
    private final zzbws zzfzy;
    private final Context zzlj;

    public zzcle(Context context, zzbai zzbai, zzcxv zzcxv, Executor executor, zzbws zzbws, zzcdn zzcdn) {
        this.zzlj = context;
        this.zzfjp = zzcxv;
        this.zzfzy = zzbws;
        this.zzffv = executor;
        this.zzbrc = zzbai;
        this.zzfqh = zzcdn;
    }

    public final boolean zza(zzcxu zzcxu, zzcxm zzcxm) {
        return (zzcxm.zzgke == null || zzcxm.zzgke.zzdkp == null) ? false : true;
    }

    public final zzbbh<zzbvx> zzb(zzcxu zzcxu, zzcxm zzcxm) {
        zzced zzced = new zzced();
        zzbbh<zzbvx> zza = zzbar.zza(zzbar.zzm(null), new zzclf(this, zzcxm, zzced, zzcxu), this.zzffv);
        zzced.getClass();
        zza.zza(zzclg.zza(zzced), this.zzffv);
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zza(zzcxm zzcxm, zzced zzced, zzcxu zzcxu, Object obj) throws Exception {
        zzbgz zzc = this.zzfqh.zzc(this.zzfjp.zzdll);
        zzc.zzat(zzcxm.zzdok);
        zzced.zza(this.zzlj, zzc.getView());
        zzbbr zzbbr = new zzbbr();
        zzbvy zza = this.zzfzy.zza(new zzbpr(zzcxu, zzcxm, (String) null), new zzbvz(new zzclh(this, zzc, zzcxm, zzbbr), zzc));
        zzbbr.set(zza);
        zza.zzadg().zza(new zzcli(zzc), zzbbm.zzeaf);
        zza.zzady().zzb(zzc, true);
        zza.zzady();
        zzbbh<?> zza2 = zzcdp.zza(zzc, zzcxm.zzgke.zzdkn, zzcxm.zzgke.zzdkp);
        if (zzcxm.zzdpc) {
            zza2.zza(new zzclj(zzc), this.zzffv);
        }
        zza2.zza(new zzclk(zzc), this.zzffv);
        return zzbar.zza(zza2, new zzcll(zza), zzbbm.zzeaf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbgz zzbgz, zzcxm zzcxm, zzbbr zzbbr, boolean z, Context context) {
        zzcxm zzcxm2 = zzcxm;
        try {
            zzbgz.zzaq(true);
            zzk.zzlg();
            zzh zzh = new zzh(false, zzaxi.zzax(this.zzlj), false, 0.0f, -1, z, zzcxm2.zzgkl, false);
            zzk.zzlf();
            Context context2 = context;
            zzm.zza(context2, new AdOverlayInfoParcel((zzxr) null, ((zzbvy) zzbbr.get()).zzaeg(), (zzu) null, zzbgz, zzcxm2.zzgkm, this.zzbrc, zzcxm2.zzdno, zzh), true);
        } catch (Exception unused) {
        }
    }
}
