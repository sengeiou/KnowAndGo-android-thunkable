package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

final class zzbxi implements zzbpe<zzbph> {
    private final zzbzc zzfgz;
    private final Map<String, zzcjv<zzbph>> zzfit;
    private final Map<String, zzcjv<zzbyn>> zzflz;
    private final Map<String, zzclw<zzbyn>> zzfma;
    private final zzdtu<zzbpe<zzbnf>> zzfmb;

    zzbxi(Map<String, zzcjv<zzbph>> map, Map<String, zzcjv<zzbyn>> map2, Map<String, zzclw<zzbyn>> map3, zzdtu<zzbpe<zzbnf>> zzdtu, zzbzc zzbzc) {
        this.zzfit = map;
        this.zzflz = map2;
        this.zzfma = map3;
        this.zzfmb = zzdtu;
        this.zzfgz = zzbzc;
    }

    @Nullable
    public final zzcjv<zzbph> zze(int i, String str) {
        zzcjv zze;
        zzcjv<zzbph> zzcjv = this.zzfit.get(str);
        if (zzcjv != null) {
            return zzcjv;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzclw zzclw = this.zzfma.get(str);
            if (zzclw != null) {
                return zzbph.zza((zzclw<? extends zzbpc>) zzclw);
            }
            zzcjv zzcjv2 = this.zzflz.get(str);
            if (zzcjv2 != null) {
                return zzbph.zza((zzcjv<? extends zzbpc>) zzcjv2);
            }
            return null;
        } else if (this.zzfgz.zzail() == null || (zze = this.zzfmb.get().zze(i, str)) == null) {
            return null;
        } else {
            return zzbph.zza((zzcjv<? extends zzbpc>) zze);
        }
    }
}
