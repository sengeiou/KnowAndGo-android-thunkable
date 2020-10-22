package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

public final class zzbph {
    public final List<? extends zzbbh<? extends zzbpc>> zzfiv;

    public zzbph(List<? extends zzbbh<? extends zzbpc>> list) {
        this.zzfiv = list;
    }

    public zzbph(zzbpc zzbpc) {
        this.zzfiv = Collections.singletonList(zzbar.zzm(zzbpc));
    }

    public static zzcjv<zzbph> zza(@Nonnull zzclw<? extends zzbpc> zzclw) {
        return new zzcjw(zzclw, zzbpi.zzdrn);
    }

    public static zzcjv<zzbph> zza(@Nonnull zzcjv<? extends zzbpc> zzcjv) {
        return new zzcjw(zzcjv, zzbpj.zzdrn);
    }
}
