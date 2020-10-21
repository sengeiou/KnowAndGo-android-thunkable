package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

final /* synthetic */ class zzbaz implements Runnable {
    private final zzbbr zzbxh;
    private final zzbbh zzdzi;
    private final Class zzdzs;
    private final zzbal zzdzt;
    private final Executor zzdzu;

    zzbaz(zzbbr zzbbr, zzbbh zzbbh, Class cls, zzbal zzbal, Executor executor) {
        this.zzbxh = zzbbr;
        this.zzdzi = zzbbh;
        this.zzdzs = cls;
        this.zzdzt = zzbal;
        this.zzdzu = executor;
    }

    public final void run() {
        zzbar.zza(this.zzbxh, this.zzdzi, this.zzdzs, this.zzdzt, this.zzdzu);
    }
}
