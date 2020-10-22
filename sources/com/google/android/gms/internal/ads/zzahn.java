package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.HashMap;
import java.util.Map;

final class zzahn implements zzaho<zzbgz> {
    zzahn() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbgz zzbgz = (zzbgz) obj;
        zzk.zzlg();
        DisplayMetrics zza = zzaxi.zza((WindowManager) zzbgz.getContext().getSystemService("window"));
        int i = zza.widthPixels;
        int i2 = zza.heightPixels;
        int[] iArr = new int[2];
        HashMap hashMap = new HashMap();
        ((View) zzbgz).getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i2));
        zzbgz.zza("locationReady", (Map<String, ?>) hashMap);
        zzawz.zzep("GET LOCATION COMPILED");
    }
}
