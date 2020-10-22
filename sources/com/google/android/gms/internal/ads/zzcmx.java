package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcmx<AdT> implements zzbal<zzcxu, AdT> {
    private final zzdae zzffb;
    private final Executor zzffi;
    private final ScheduledExecutorService zzfkf;
    private final zzbrm zzfkw;
    private final zzczt zzgbk;
    private final zzbpe<AdT> zzgbl;
    private final zzcmu zzgbm;

    public zzcmx(zzczt zzczt, zzcmu zzcmu, zzbrm zzbrm, zzdae zzdae, zzbpe<AdT> zzbpe, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zzgbk = zzczt;
        this.zzgbm = zzcmu;
        this.zzfkw = zzbrm;
        this.zzffb = zzdae;
        this.zzgbl = zzbpe;
        this.zzffi = executor;
        this.zzfkf = scheduledExecutorService;
    }

    public final /* synthetic */ zzbbh zzf(Object obj) throws Exception {
        zzcxu zzcxu = (zzcxu) obj;
        zzcze<E, I> zzane = this.zzgbk.zzv(zzczs.RENDER_CONFIG_INIT).zzb(zzbar.zzd(new zzcmw("No ad configs", 3))).zzane();
        this.zzfkw.zza(new zzbmd(zzcxu, this.zzffb), this.zzffi);
        int i = 0;
        for (zzcxm next : zzcxu.zzgky.zzgkt) {
            Iterator<String> it = next.zzgjy.iterator();
            while (true) {
                if (it.hasNext()) {
                    String next2 = it.next();
                    zzcjv<AdT> zze = this.zzgbl.zze(next.zzflt, next2);
                    if (zze != null && zze.zza(zzcxu, next)) {
                        zzczl<I> zza = this.zzgbk.zza(zzczs.RENDER_CONFIG_WATERFALL, zzane);
                        StringBuilder sb = new StringBuilder(String.valueOf(next2).length() + 26);
                        sb.append("render-config-");
                        sb.append(i);
                        sb.append("-");
                        sb.append(next2);
                        zzane = zza.zzfy(sb.toString()).zza(Throwable.class, new zzcmy(this, next, zze, zzcxu)).zzane();
                        break;
                    }
                } else {
                    break;
                }
            }
            i++;
        }
        return zzane;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zza(zzcxm zzcxm, zzcjv zzcjv, zzcxu zzcxu, Throwable th) throws Exception {
        return this.zzgbm.zza(zzcxm, zzbar.zza(zzcjv.zzb(zzcxu, zzcxm), (long) zzcxm.zzgkn, TimeUnit.MILLISECONDS, this.zzfkf));
    }
}
