package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

final /* synthetic */ class zzcgw implements Callable {
    private final Context zzcjt;
    private final zzdh zzfwa;

    zzcgw(zzdh zzdh, Context context) {
        this.zzfwa = zzdh;
        this.zzcjt = context;
    }

    public final Object call() {
        zzdh zzdh = this.zzfwa;
        return zzdh.zzcg().zza(this.zzcjt);
    }
}
