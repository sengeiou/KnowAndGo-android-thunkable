package com.google.android.gms.internal.ads;

final /* synthetic */ class zzakm implements Runnable {
    private final zzakh zzdce;
    private final zzala zzdci;
    private final zzajw zzdcj;

    zzakm(zzakh zzakh, zzala zzala, zzajw zzajw) {
        this.zzdce = zzakh;
        this.zzdci = zzala;
        this.zzdcj = zzajw;
    }

    public final void run() {
        this.zzdce.zza(this.zzdci, this.zzdcj);
    }
}
