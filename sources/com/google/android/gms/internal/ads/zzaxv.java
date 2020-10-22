package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.Map;

@TargetApi(21)
public class zzaxv extends zzaxu {
    public final int zzwi() {
        return 16974374;
    }

    public final CookieManager zzaz(Context context) {
        if (zzwh()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzawz.zzc("Failed to obtain CookieManager.", th);
            zzk.zzlk().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public final zzbha zza(zzbgz zzbgz, zzwj zzwj, boolean z) {
        return new zzbib(zzbgz, zzwj, z);
    }

    public final WebResourceResponse zza(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i, str3, map, inputStream);
    }
}
