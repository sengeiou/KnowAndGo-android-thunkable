package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzcgn {
    private final zzbbl zzfqw;
    private final zzbbl zzfvr;
    private final zzchv zzfvs;
    private final zzdte<zzcig> zzfvt;

    public zzcgn(zzbbl zzbbl, zzbbl zzbbl2, zzchv zzchv, zzdte<zzcig> zzdte) {
        this.zzfvr = zzbbl;
        this.zzfqw = zzbbl2;
        this.zzfvs = zzchv;
        this.zzfvt = zzdte;
    }

    public final zzbbh<InputStream> zzc(zzarx zzarx) {
        zzbbh zzbbh;
        String str = zzarx.packageName;
        zzk.zzlg();
        if (zzaxi.zzec(str)) {
            zzbbh = zzbar.zzd(new zzcie(0));
        } else {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvo)).booleanValue()) {
                zzbbh = zzbar.zza(this.zzfvr.zza(new zzcgo(this, zzarx)), ExecutionException.class, zzcgp.zzbqz, (Executor) this.zzfqw);
            } else {
                zzbbh = this.zzfvs.zzf(zzarx);
            }
        }
        zzbbh<InputStream> zza = zzbar.zza(zzbbh, zzcie.class, new zzcgq(this, zzarx), (Executor) this.zzfqw);
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcvo)).booleanValue()) {
            zza.zza(new zzcgr(zzbbh), zzbbm.zzeaf);
        }
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zza(zzarx zzarx, zzcie zzcie) throws Exception {
        return this.zzfvt.get().zzh(zzarx);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzd(zzarx zzarx) throws Exception {
        return (InputStream) this.zzfvs.zzf(zzarx).get((long) ((Integer) zzyt.zzpe().zzd(zzacu.zzcvn)).intValue(), TimeUnit.SECONDS);
    }
}
