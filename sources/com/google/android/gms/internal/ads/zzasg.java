package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

@zzard
public final class zzasg {
    /* access modifiers changed from: private */
    public WeakHashMap<Context, zzasi> zzdqe = new WeakHashMap<>();

    public final Future<zzase> zzt(Context context) {
        return zzaxg.zza(new zzash(this, context));
    }
}
