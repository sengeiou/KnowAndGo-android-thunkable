package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import p022fi.iki.elonen.NanoHTTPD;

final /* synthetic */ class zzbzw implements zzaho {
    private final zzbzt zzfqj;

    zzbzw(zzbzt zzbzt) {
        this.zzfqj = zzbzt;
    }

    public final void zza(Object obj, Map map) {
        zzbgz zzbgz = (zzbgz) obj;
        zzbgz.zzaai().zza((zzbij) new zzbzz(this.zzfqj, map));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzbgz.loadData(str, NanoHTTPD.MIME_HTML, "UTF-8");
        } else {
            zzbgz.loadDataWithBaseURL(str2, str, NanoHTTPD.MIME_HTML, "UTF-8", (String) null);
        }
    }
}
