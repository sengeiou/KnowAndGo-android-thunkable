package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

final class zzbix implements zzaho<zzbgz> {
    private final /* synthetic */ zzbiv zzemp;

    zzbix(zzbiv zzbiv) {
        this.zzemp = zzbiv;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zzemp) {
                        if (this.zzemp.zzelk != parseInt) {
                            int unused = this.zzemp.zzelk = parseInt;
                            this.zzemp.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzawz.zzd("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
