package com.google.android.gms.internal.ads;

final class zzcny implements zzbvo {
    private final /* synthetic */ zzcxu zzgbx;
    private final /* synthetic */ zzcxm zzgby;
    private final /* synthetic */ zzcjy zzgbz;
    final /* synthetic */ zzcnw zzgca;

    zzcny(zzcnw zzcnw, zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) {
        this.zzgca = zzcnw;
        this.zzgbx = zzcxu;
        this.zzgby = zzcxm;
        this.zzgbz = zzcjy;
    }

    public final void onInitializationSucceeded() {
        this.zzgca.zzffv.execute(new zzcnz(this, this.zzgbx, this.zzgby, this.zzgbz));
    }

    public final void zzdl(int i) {
        String valueOf = String.valueOf(this.zzgbz.zzfis);
        zzawz.zzep(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "));
    }
}
