package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzblt implements zzbls {
    private zzaxb zzduk;

    public zzblt(zzaxb zzaxb) {
        this.zzduk = zzaxb;
    }

    public final void zzk(Map<String, String> map) {
        this.zzduk.zzai(Boolean.parseBoolean(map.get("content_url_opted_out")));
    }
}
