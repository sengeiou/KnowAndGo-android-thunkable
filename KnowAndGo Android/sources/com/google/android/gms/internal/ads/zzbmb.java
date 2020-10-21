package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzbmb implements zzbls {
    private final zzaxb zzduk;

    public zzbmb(zzaxb zzaxb) {
        this.zzduk = zzaxb;
    }

    public final void zzk(Map<String, String> map) {
        String str = map.get("value");
        if ("auto_collect_location".equals(map.get("key"))) {
            this.zzduk.zzak(Boolean.parseBoolean(str));
        }
    }
}
