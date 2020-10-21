package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

@zzard
public final class zzahx implements zzaho<Object> {
    private final zzahy zzdas;

    public static void zza(zzbgz zzbgz, zzahy zzahy) {
        zzbgz.zza("/reward", (zzaho<? super zzbgz>) new zzahx(zzahy));
    }

    private zzahx(zzahy zzahy) {
        this.zzdas = zzahy;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("action");
        if ("grant".equals(str)) {
            zzato zzato = null;
            try {
                int parseInt = Integer.parseInt(map.get("amount"));
                String str2 = map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzato = new zzato(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zzawz.zzd("Unable to parse reward amount.", e);
            }
            this.zzdas.zza(zzato);
        } else if ("video_start".equals(str)) {
            this.zzdas.zzrq();
        } else if ("video_complete".equals(str)) {
            this.zzdas.zzrr();
        }
    }
}
