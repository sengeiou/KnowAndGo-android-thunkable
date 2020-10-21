package com.google.android.gms.internal.ads;

import android.content.Context;

final /* synthetic */ class zzbqv implements zzbam {
    private final Context zzdef;
    private final zzbai zzfhl;
    private final zzcxv zzfjs;

    zzbqv(Context context, zzbai zzbai, zzcxv zzcxv) {
        this.zzdef = context;
        this.zzfhl = zzbai;
        this.zzfjs = zzcxv;
    }

    public final Object apply(Object obj) {
        Context context = this.zzdef;
        zzbai zzbai = this.zzfhl;
        zzcxv zzcxv = this.zzfjs;
        zzcxm zzcxm = (zzcxm) obj;
        zzayb zzayb = new zzayb(context);
        zzayb.zzee(zzcxm.zzdno);
        zzayb.zzef(zzcxm.zzgkj.toString());
        zzayb.zzp(zzbai.zzbsx);
        zzayb.setAdUnitId(zzcxv.zzglb);
        return zzayb;
    }
}
