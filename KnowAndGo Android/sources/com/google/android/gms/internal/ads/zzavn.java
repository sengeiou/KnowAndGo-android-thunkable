package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

final /* synthetic */ class zzavn implements zzavw {
    private final String zzdbk;
    private final Context zzdef;

    zzavn(Context context, String str) {
        this.zzdef = context;
        this.zzdbk = str;
    }

    public final void zza(zzbjf zzbjf) {
        Context context = this.zzdef;
        zzbjf.zzb(ObjectWrapper.wrap(context), this.zzdbk, context.getPackageName());
    }
}
