package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

final class zzcic implements zzbtk {
    private final zzavg zzbsq;
    private final Context zzlj;

    zzcic(Context context, zzavg zzavg) {
        this.zzlj = context;
        this.zzbsq = zzavg;
    }

    public final void zzb(zzarx zzarx) {
    }

    public final void zza(zzcxu zzcxu) {
        if (!TextUtils.isEmpty(zzcxu.zzgky.zzgku.zzdoj)) {
            this.zzbsq.zzi(this.zzlj, zzcxu.zzgky.zzgku.zzdoj);
        }
    }
}
