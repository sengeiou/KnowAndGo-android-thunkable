package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

final class zzbfz implements Runnable {
    private final /* synthetic */ String zzdli;
    private final /* synthetic */ String zzehu;
    private final /* synthetic */ int zzehw;
    private final /* synthetic */ zzbft zzehy;

    zzbfz(zzbft zzbft, String str, String str2, int i) {
        this.zzehy = zzbft;
        this.zzdli = str;
        this.zzehu = str2;
        this.zzehw = i;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheComplete");
        hashMap.put("src", this.zzdli);
        hashMap.put("cachedSrc", this.zzehu);
        hashMap.put("totalBytes", Integer.toString(this.zzehw));
        this.zzehy.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
