package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzblq implements zzbal<zzcxu, zzcxu> {
    private Map<String, zzbls> zzfev;

    public zzblq(Map<String, zzbls> map) {
        this.zzfev = map;
    }

    public final /* synthetic */ zzbbh zzf(Object obj) throws Exception {
        zzcxu zzcxu = (zzcxu) obj;
        for (zzcxt next : zzcxu.zzgky.zzgkv) {
            if (this.zzfev.containsKey(next.name)) {
                this.zzfev.get(next.name).zzk(next.zzgkw);
            }
        }
        return zzbar.zzm(zzcxu);
    }
}
