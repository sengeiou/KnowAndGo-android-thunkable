package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcvo implements zzcva<zzcvn> {
    private final Executor zzffi;
    private final ScheduledExecutorService zzfiw;
    private final zzawi zzgir;
    private final Context zzlj;

    public zzcvo(zzawi zzawi, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.zzgir = zzawi;
        this.zzlj = context;
        this.zzfiw = scheduledExecutorService;
        this.zzffi = executor;
    }

    public final zzbbh<zzcvn> zzalm() {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcoz)).booleanValue()) {
            return zzbar.zzd(new Exception("Did not ad Ad ID into query param."));
        }
        zzbbr zzbbr = new zzbbr();
        zzbbh<AdvertisingIdClient.Info> zzag = this.zzgir.zzag(this.zzlj);
        zzag.zza(new zzcvp(this, zzag, zzbbr), this.zzffi);
        this.zzfiw.schedule(new zzcvq(zzag), ((Long) zzyt.zzpe().zzd(zzacu.zzcpa)).longValue(), TimeUnit.MILLISECONDS);
        return zzbbr;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbbh zzbbh, zzbbr zzbbr) {
        String str;
        try {
            AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) zzbbh.get();
            if (info == null || !TextUtils.isEmpty(info.getId())) {
                str = null;
            } else {
                zzyt.zzpa();
                str = zzazt.zzbf(this.zzlj);
            }
            zzbbr.set(new zzcvn(info, this.zzlj, str));
        } catch (InterruptedException | CancellationException | ExecutionException unused) {
            zzyt.zzpa();
            zzbbr.set(new zzcvn((AdvertisingIdClient.Info) null, this.zzlj, zzazt.zzbf(this.zzlj)));
        }
    }
}
