package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

public final class zzblx implements zzbls {
    private final zzcxk zzfex;

    public zzblx(zzcxk zzcxk) {
        this.zzfex = zzcxk;
    }

    public final void zzk(Map<String, String> map) {
        String str = map.get("render_in_browser");
        if (!TextUtils.isEmpty(str)) {
            try {
                this.zzfex.zzbb(Boolean.parseBoolean(str));
            } catch (Exception unused) {
                throw new IllegalStateException("Invalid render_in_browser state");
            }
        }
    }
}
