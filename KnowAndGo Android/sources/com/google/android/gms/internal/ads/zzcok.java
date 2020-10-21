package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;

public final class zzcok implements zzcjv<zzbnf> {
    private final zzboc zzfzo;
    private final zzczt zzgbk;
    private final zzbbl zzgci;
    private final Context zzgcn;
    @Nullable
    private final zzado zzgco;

    public zzcok(Context context, zzboc zzboc, zzczt zzczt, zzbbl zzbbl, @Nullable zzado zzado) {
        this.zzgcn = context;
        this.zzfzo = zzboc;
        this.zzgbk = zzczt;
        this.zzgci = zzbbl;
        this.zzgco = zzado;
    }

    public final boolean zza(zzcxu zzcxu, zzcxm zzcxm) {
        return (this.zzgco == null || zzcxm.zzgke == null || zzcxm.zzgke.zzdkp == null) ? false : true;
    }

    public final zzbbh<zzbnf> zzb(zzcxu zzcxu, zzcxm zzcxm) {
        zzbng zza = this.zzfzo.zza(new zzbpr(zzcxu, zzcxm, (String) null), (zzbnk) new zzcon(this, new View(this.zzgcn), (zzbgz) null, zzcol.zzgcp, zzcxm.zzgkg.get(0)));
        return this.zzgbk.zzv(zzczs.CUSTOM_RENDER_SYN).zza((zzczd) new zzcom(this, new zzadj(zza.zzaea(), zzcxm.zzgke.zzdkn, zzcxm.zzgke.zzdkp)), this.zzgci).zzx(zzczs.CUSTOM_RENDER_ACK).zzb(zzbar.zzm(zza.zzadx())).zzane();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzadj zzadj) throws Exception {
        this.zzgco.zza(zzadj);
    }
}
