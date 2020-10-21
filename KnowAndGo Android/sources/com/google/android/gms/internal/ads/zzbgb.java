package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.onesignal.OneSignalDbContract;
import java.util.HashMap;
import java.util.Map;

final class zzbgb implements Runnable {
    private final /* synthetic */ String val$message;
    private final /* synthetic */ String zzdli;
    private final /* synthetic */ String zzehu;
    private final /* synthetic */ zzbft zzehy;
    private final /* synthetic */ String zzeid;

    zzbgb(zzbft zzbft, String str, String str2, String str3, String str4) {
        this.zzehy = zzbft;
        this.zzdli = str;
        this.zzehu = str2;
        this.zzeid = str3;
        this.val$message = str4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheCanceled");
        hashMap.put("src", this.zzdli);
        if (!TextUtils.isEmpty(this.zzehu)) {
            hashMap.put("cachedSrc", this.zzehu);
        }
        hashMap.put("type", zzbft.zzez(this.zzeid));
        hashMap.put("reason", this.zzeid);
        if (!TextUtils.isEmpty(this.val$message)) {
            hashMap.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, this.val$message);
        }
        this.zzehy.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
