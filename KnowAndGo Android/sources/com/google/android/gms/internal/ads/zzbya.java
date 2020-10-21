package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

final class zzbya implements zzaho<Object> {
    private WeakReference<zzbxx> zzfnf;

    private zzbya(zzbxx zzbxx) {
        this.zzfnf = new WeakReference<>(zzbxx);
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzbxx zzbxx = (zzbxx) this.zzfnf.get();
        if (zzbxx != null) {
            zzbxx.zzfmr.onAdImpression();
        }
    }
}
