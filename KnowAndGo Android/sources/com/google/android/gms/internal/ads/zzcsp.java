package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

public final class zzcsp implements zzcva<zzcss> {
    private final zzbbl zzfqw;
    private final Context zzys;

    zzcsp(Context context, zzbbl zzbbl) {
        this.zzys = context;
        this.zzfqw = zzbbl;
    }

    public final zzbbh<zzcss> zzalm() {
        return this.zzfqw.zza(new zzcsq(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcss zzalq() throws Exception {
        zzk.zzlg();
        String zzav = zzaxi.zzav(this.zzys);
        zzk.zzlg();
        return new zzcss(zzav, zzaxi.zzaw(this.zzys));
    }
}
