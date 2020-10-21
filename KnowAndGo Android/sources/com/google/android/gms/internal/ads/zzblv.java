package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzblv implements zzbls {
    private zzaxb zzduk;

    public zzblv(zzaxb zzaxb) {
        this.zzduk = zzaxb;
    }

    public final void zzk(Map<String, String> map) {
        this.zzduk.zzaj(Boolean.parseBoolean(map.get("content_vertical_opted_out")));
    }
}
