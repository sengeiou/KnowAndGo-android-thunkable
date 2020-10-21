package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

public final class zzchl extends zzchj {
    /* access modifiers changed from: private */
    public static final Pattern zzfwx = Pattern.compile("Received error HTTP response code: (.*)");
    private final ScheduledExecutorService zzfiw;
    private final zzcxv zzfjp;
    private final zzbbl zzfqw;
    private final zzcgn zzfwv;
    /* access modifiers changed from: private */
    public final zzcji zzfww;

    zzchl(zzbtg zzbtg, zzcxv zzcxv, zzcgn zzcgn, zzbbl zzbbl, ScheduledExecutorService scheduledExecutorService, zzcji zzcji) {
        super(zzbtg);
        this.zzfjp = zzcxv;
        this.zzfwv = zzcgn;
        this.zzfqw = zzbbl;
        this.zzfiw = scheduledExecutorService;
        this.zzfww = zzcji;
    }

    public final zzbbh<zzcxu> zze(zzarx zzarx) throws zzcgm {
        zzbbh<zzcxu> zza = zzbar.zza(this.zzfwv.zzc(zzarx), new zzchm(this), (Executor) this.zzfqw);
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvm)).booleanValue()) {
            zza = zzbar.zza(zzbar.zza(zza, (long) ((Integer) zzyt.zzpe().zzd(zzacu.zzcvn)).intValue(), TimeUnit.SECONDS, this.zzfiw), TimeoutException.class, zzchn.zzbqz, zzbbm.zzeaf);
        }
        zzbar.zza(zza, new zzcho(this), zzbbm.zzeaf);
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zzd(InputStream inputStream) throws Exception {
        return zzbar.zzm(new zzcxu(new zzcxr(this.zzfjp), zzcxs.zza(new InputStreamReader(inputStream))));
    }
}
