package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

final class zzbho implements zzaho<zzbgz> {
    private final /* synthetic */ zzbhm zzelu;

    zzbho(zzbhm zzbhm) {
        this.zzelu = zzbhm;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zzelu) {
                        if (this.zzelu.zzelk != parseInt) {
                            int unused = this.zzelu.zzelk = parseInt;
                            this.zzelu.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzawz.zzd("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
