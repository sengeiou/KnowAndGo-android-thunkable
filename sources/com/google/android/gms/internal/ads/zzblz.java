package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

public final class zzblz implements zzbls {
    private final Context zzlj;

    public zzblz(Context context) {
        this.zzlj = context;
    }

    public final void zzk(Map<String, String> map) {
        CookieManager zzaz;
        String str = map.get("cookie");
        if (!TextUtils.isEmpty(str) && (zzaz = zzk.zzli().zzaz(this.zzlj)) != null) {
            zzaz.setCookie("googleads.g.doubleclick.net", str);
        }
    }
}
