package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

final class zzbfw implements Runnable {
    private final /* synthetic */ String zzdli;
    private final /* synthetic */ String zzehu;
    private final /* synthetic */ boolean zzehx;
    private final /* synthetic */ zzbft zzehy;
    private final /* synthetic */ long zzeib;
    private final /* synthetic */ long zzeic;

    zzbfw(zzbft zzbft, String str, String str2, long j, long j2, boolean z) {
        this.zzehy = zzbft;
        this.zzdli = str;
        this.zzehu = str2;
        this.zzeib = j;
        this.zzeic = j2;
        this.zzehx = z;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        hashMap.put("src", this.zzdli);
        hashMap.put("cachedSrc", this.zzehu);
        hashMap.put("bufferedDuration", Long.toString(this.zzeib));
        hashMap.put("totalDuration", Long.toString(this.zzeic));
        hashMap.put("cacheReady", this.zzehx ? "1" : "0");
        this.zzehy.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
