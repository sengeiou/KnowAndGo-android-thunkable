package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.concurrent.Executor;

public final class zzcam implements zzdti<zzbuz<VideoController.VideoLifecycleCallbacks>> {
    private final zzdtu<zzccw> zzfgm;
    private final zzdtu<Executor> zzfhi;
    private final zzcag zzfqr;

    public zzcam(zzcag zzcag, zzdtu<zzccw> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzfqr = zzcag;
        this.zzfgm = zzdtu;
        this.zzfhi = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfgm.get(), this.zzfhi.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
