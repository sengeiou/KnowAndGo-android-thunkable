package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzckz implements zzdti<zzckv> {
    private final zzdtu<zzboc> zzezx;
    private final zzdtu<zzckb> zzfab;
    private final zzdtu<zzbbl> zzfgh;
    private final zzdtu<ScheduledExecutorService> zzfjc;
    private final zzdtu<zzbrm> zzgah;

    public zzckz(zzdtu<zzboc> zzdtu, zzdtu<zzckb> zzdtu2, zzdtu<zzbrm> zzdtu3, zzdtu<ScheduledExecutorService> zzdtu4, zzdtu<zzbbl> zzdtu5) {
        this.zzezx = zzdtu;
        this.zzfab = zzdtu2;
        this.zzgah = zzdtu3;
        this.zzfjc = zzdtu4;
        this.zzfgh = zzdtu5;
    }

    public final /* synthetic */ Object get() {
        return new zzckv(this.zzezx.get(), this.zzfab.get(), this.zzgah.get(), this.zzfjc.get(), this.zzfgh.get());
    }
}
