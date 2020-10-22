package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.p005os.EnvironmentCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.zzk;
import java.util.LinkedHashMap;
import java.util.Map;

public final class zzcfi {
    private Map<String, String> zzcxs = new LinkedHashMap();

    public zzcfi(Context context, String str) {
        Map<String, String> map = this.zzcxs;
        map.put("s", "gmob_sdk");
        map.put("v", ExifInterface.GPS_MEASUREMENT_3D);
        map.put("os", Build.VERSION.RELEASE);
        map.put("sdk", Build.VERSION.SDK);
        zzk.zzlg();
        map.put("device", zzaxi.zzwc());
        map.put("app", str);
        zzk.zzlg();
        map.put("is_lite_sdk", zzaxi.zzau(context) ? "1" : "0");
        map.put("e", TextUtils.join(",", zzacu.zzqo()));
    }

    public final void zzb(zzcxu zzcxu) {
        if (zzcxu.zzgky.zzgkt.size() > 0) {
            switch (zzcxu.zzgky.zzgkt.get(0).zzflt) {
                case 1:
                    this.zzcxs.put("ad_format", "banner");
                    break;
                case 2:
                    this.zzcxs.put("ad_format", "interstitial");
                    break;
                case 3:
                    this.zzcxs.put("ad_format", "native_express");
                    break;
                case 4:
                    this.zzcxs.put("ad_format", "native_advanced");
                    break;
                case 5:
                    this.zzcxs.put("ad_format", "rewarded");
                    break;
                default:
                    this.zzcxs.put("ad_format", EnvironmentCompat.MEDIA_UNKNOWN);
                    break;
            }
            if (!TextUtils.isEmpty(zzcxu.zzgky.zzgku.zzcep)) {
                this.zzcxs.put("gqi", zzcxu.zzgky.zzgku.zzcep);
            }
        }
    }

    public final void zzi(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zzcxs.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zzcxs.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }

    public final Map<String, String> zzqy() {
        return this.zzcxs;
    }
}
