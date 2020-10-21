package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzcor<AdT> implements zzcjv<AdT> {
    private final zzczt zzgbk;
    private final zzbbl zzgci;
    @Nullable
    private final zzado zzgco;
    /* access modifiers changed from: private */
    public final zzcou<AdT> zzgcv;

    public zzcor(zzczt zzczt, zzbbl zzbbl, @Nullable zzado zzado, zzcou<AdT> zzcou) {
        this.zzgbk = zzczt;
        this.zzgci = zzbbl;
        this.zzgco = zzado;
        this.zzgcv = zzcou;
    }

    public final boolean zza(zzcxu zzcxu, zzcxm zzcxm) {
        return (this.zzgco == null || zzcxm.zzgke == null || zzcxm.zzgke.zzdkp == null) ? false : true;
    }

    public final zzbbh<AdT> zzb(zzcxu zzcxu, zzcxm zzcxm) {
        zzbbr zzbbr = new zzbbr();
        zzcoz zzcoz = new zzcoz();
        zzcoz.zza(new zzcot(this, zzbbr, zzcxu, zzcxm, zzcoz));
        return this.zzgbk.zzv(zzczs.CUSTOM_RENDER_SYN).zza((zzczd) new zzcos(this, new zzadj(zzcoz, zzcxm.zzgke.zzdkn, zzcxm.zzgke.zzdkp)), this.zzgci).zzx(zzczs.CUSTOM_RENDER_ACK).zzb(zzbbr).zzane();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzadj zzadj) throws Exception {
        this.zzgco.zza(zzadj);
    }
}
