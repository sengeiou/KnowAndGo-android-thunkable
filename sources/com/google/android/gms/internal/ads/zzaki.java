package com.google.android.gms.internal.ads;

final /* synthetic */ class zzaki implements Runnable {
    private final zzakh zzdce;
    private final zzdh zzdcf;
    private final zzala zzdcg;

    zzaki(zzakh zzakh, zzdh zzdh, zzala zzala) {
        this.zzdce = zzakh;
        this.zzdcf = zzdh;
        this.zzdcg = zzala;
    }

    public final void run() {
        this.zzdce.zza(this.zzdcf, this.zzdcg);
    }
}
