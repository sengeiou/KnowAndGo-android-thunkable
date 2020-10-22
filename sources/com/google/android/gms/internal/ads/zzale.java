package com.google.android.gms.internal.ads;

final /* synthetic */ class zzale implements Runnable {
    private final zzald zzdda;
    private final zzajw zzddb;

    zzale(zzald zzald, zzajw zzajw) {
        this.zzdda = zzald;
        this.zzddb = zzajw;
    }

    public final void run() {
        zzald zzald = this.zzdda;
        zzajw zzajw = this.zzddb;
        zzald.zzdcz.zzdcc.zzh(zzajw);
        zzajw.destroy();
    }
}
