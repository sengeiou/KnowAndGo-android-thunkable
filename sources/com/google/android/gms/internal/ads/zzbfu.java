package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

final class zzbfu implements Runnable {
    private final /* synthetic */ String zzdli;
    private final /* synthetic */ String zzehu;
    private final /* synthetic */ int zzehv;
    private final /* synthetic */ int zzehw;
    private final /* synthetic */ boolean zzehx = false;
    private final /* synthetic */ zzbft zzehy;

    zzbfu(zzbft zzbft, String str, String str2, int i, int i2, boolean z) {
        this.zzehy = zzbft;
        this.zzdli = str;
        this.zzehu = str2;
        this.zzehv = i;
        this.zzehw = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        hashMap.put("src", this.zzdli);
        hashMap.put("cachedSrc", this.zzehu);
        hashMap.put("bytesLoaded", Integer.toString(this.zzehv));
        hashMap.put("totalBytes", Integer.toString(this.zzehw));
        hashMap.put("cacheReady", this.zzehx ? "1" : "0");
        this.zzehy.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
