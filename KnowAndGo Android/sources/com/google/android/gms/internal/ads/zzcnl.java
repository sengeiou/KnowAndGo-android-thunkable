package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

public final class zzcnl implements zzcjv<zzcdb> {
    private final zzbai zzbrc;
    private final Executor zzffv;
    private final zzcxv zzfjp;
    private final zzcdn zzfqh;
    private final zzcdf zzgbq;
    private final Context zzlj;

    public zzcnl(Context context, zzbai zzbai, zzcxv zzcxv, Executor executor, zzcdf zzcdf, zzcdn zzcdn) {
        this.zzlj = context;
        this.zzfjp = zzcxv;
        this.zzgbq = zzcdf;
        this.zzffv = executor;
        this.zzbrc = zzbai;
        this.zzfqh = zzcdn;
    }

    public final boolean zza(zzcxu zzcxu, zzcxm zzcxm) {
        return (zzcxm.zzgke == null || zzcxm.zzgke.zzdkp == null) ? false : true;
    }

    public final zzbbh<zzcdb> zzb(zzcxu zzcxu, zzcxm zzcxm) {
        zzced zzced = new zzced();
        zzbbh<zzcdb> zza = zzbar.zza(zzbar.zzm(null), new zzcnm(this, zzcxm, zzced, zzcxu), this.zzffv);
        zzced.getClass();
        zza.zza(zzcnn.zza(zzced), this.zzffv);
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zzb(zzcxm zzcxm, zzced zzced, zzcxu zzcxu, Object obj) throws Exception {
        zzbgz zzc = this.zzfqh.zzc(this.zzfjp.zzdll);
        zzc.zzat(zzcxm.zzdok);
        zzced.zza(this.zzlj, zzc.getView());
        zzbbr zzbbr = new zzbbr();
        zzcdc zza = this.zzgbq.zza(new zzbpr(zzcxu, zzcxm, (String) null), new zzcdd(new zzcnq(this, zzc, zzcxm, zzbbr), zzc));
        zzbbr.set(zza);
        zzahx.zza(zzc, (zzahy) zza.zzaek());
        zza.zzadg().zza(new zzcnr(zzc), zzbbm.zzeaf);
        zza.zzady().zzb(zzc, true);
        zza.zzady();
        zzbbh<?> zza2 = zzcdp.zza(zzc, zzcxm.zzgke.zzdkn, zzcxm.zzgke.zzdkp);
        if (zzcxm.zzdpc) {
            zza2.zza(new zzcns(zzc), this.zzffv);
        }
        zza2.zza(new zzcnt(zzc), this.zzffv);
        return zzbar.zza(zza2, new zzcnu(zza), zzbbm.zzeaf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbgz zzbgz, zzcxm zzcxm, zzbbr zzbbr, boolean z, Context context) {
        zzbgz zzbgz2;
        zzcxm zzcxm2 = zzcxm;
        try {
            zzcdc zzcdc = (zzcdc) zzbbr.get();
            if (zzbgz.zzaaw()) {
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcoq)).booleanValue()) {
                    zzbgz zzc = this.zzfqh.zzc(this.zzfjp.zzdll);
                    zzahx.zza(zzc, (zzahy) zzcdc.zzaek());
                    zzced zzced = new zzced();
                    zzced.zza(this.zzlj, zzc.getView());
                    zzcdc.zzady().zzb(zzc, true);
                    zzc.zzaai().zza((zzbij) new zzcno(zzced, zzc));
                    zzbii zzaai = zzc.zzaai();
                    zzc.getClass();
                    zzaai.zza(zzcnp.zzp(zzc));
                    zzc.zzb(zzcxm2.zzgke.zzdkn, zzcxm2.zzgke.zzdkp, (String) null);
                    zzbgz2 = zzc;
                    zzbgz2.zzaq(true);
                    zzk.zzlg();
                    zzh zzh = new zzh(false, zzaxi.zzax(this.zzlj), false, 0.0f, -1, z, zzcxm2.zzgkl, zzcxm2.zzbrm);
                    zzk.zzlf();
                    zzm.zza(context, new AdOverlayInfoParcel((zzxr) null, ((zzcdc) zzbbr.get()).zzaeg(), (zzu) null, zzbgz2, zzcxm2.zzgkm, this.zzbrc, zzcxm2.zzdno, zzh), true);
                }
            }
            zzbgz2 = zzbgz;
            zzbgz2.zzaq(true);
            zzk.zzlg();
            zzh zzh2 = new zzh(false, zzaxi.zzax(this.zzlj), false, 0.0f, -1, z, zzcxm2.zzgkl, zzcxm2.zzbrm);
            zzk.zzlf();
            zzm.zza(context, new AdOverlayInfoParcel((zzxr) null, ((zzcdc) zzbbr.get()).zzaeg(), (zzu) null, zzbgz2, zzcxm2.zzgkm, this.zzbrc, zzcxm2.zzdno, zzh2), true);
        } catch (Exception unused) {
        }
    }
}
