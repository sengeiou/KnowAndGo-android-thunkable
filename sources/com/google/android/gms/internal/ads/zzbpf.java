package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

public final class zzbpf<AdT> implements zzbpe<AdT> {
    private final Map<String, zzcjv<AdT>> zzfit;

    zzbpf(Map<String, zzcjv<AdT>> map) {
        this.zzfit = map;
    }

    @Nullable
    public final zzcjv<AdT> zze(int i, String str) {
        return this.zzfit.get(str);
    }
}
