package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

final /* synthetic */ class zzbwa implements zzbsr {
    private final Context zzdef;
    private final zzbai zzfhl;
    private final zzcxm zzfhm;
    private final zzcxv zzfhn;

    zzbwa(Context context, zzbai zzbai, zzcxm zzcxm, zzcxv zzcxv) {
        this.zzdef = context;
        this.zzfhl = zzbai;
        this.zzfhm = zzcxm;
        this.zzfhn = zzcxv;
    }

    public final void onAdLoaded() {
        zzk.zzlq().zzb(this.zzdef, this.zzfhl.zzbsx, this.zzfhm.zzgkj.toString(), this.zzfhn.zzglb);
    }
}
