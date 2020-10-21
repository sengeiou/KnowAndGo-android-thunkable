package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

final class zzbfv implements Runnable {
    private final /* synthetic */ String zzdli;
    private final /* synthetic */ String zzehu;
    private final /* synthetic */ int zzehv;
    private final /* synthetic */ int zzehw = 0;
    private final /* synthetic */ boolean zzehx;
    private final /* synthetic */ zzbft zzehy;
    private final /* synthetic */ int zzehz;
    private final /* synthetic */ int zzeia;

    zzbfv(zzbft zzbft, String str, String str2, int i, int i2, boolean z, int i3, int i4) {
        this.zzehy = zzbft;
        this.zzdli = str;
        this.zzehu = str2;
        this.zzehv = i;
        this.zzehx = z;
        this.zzehz = i3;
        this.zzeia = i4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        hashMap.put("src", this.zzdli);
        hashMap.put("cachedSrc", this.zzehu);
        hashMap.put("bytesLoaded", Integer.toString(this.zzehv));
        hashMap.put("totalBytes", Integer.toString(this.zzehw));
        hashMap.put("cacheReady", this.zzehx ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.zzehz));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzeia));
        this.zzehy.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
