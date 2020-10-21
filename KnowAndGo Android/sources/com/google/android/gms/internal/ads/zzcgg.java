package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcgg implements Runnable {
    private final Object zzdeb;
    private final String zzftt;
    private final zzcgb zzfvf;
    private final zzbbr zzfvh;
    private final long zzfvi;

    zzcgg(zzcgb zzcgb, Object obj, zzbbr zzbbr, String str, long j) {
        this.zzfvf = zzcgb;
        this.zzdeb = obj;
        this.zzfvh = zzbbr;
        this.zzftt = str;
        this.zzfvi = j;
    }

    public final void run() {
        this.zzfvf.zza(this.zzdeb, this.zzfvh, this.zzftt, this.zzfvi);
    }
}
