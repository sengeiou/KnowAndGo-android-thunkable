package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class zzcrh implements zzcuz<Bundle> {
    private final zzcxv zzfjp;

    public zzcrh(zzcxv zzcxv) {
        Preconditions.checkNotNull(zzcxv, "the targeting must not be null");
        this.zzfjp = zzcxv;
    }

    public final /* synthetic */ void zzt(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzxz zzxz = this.zzfjp.zzghg;
        bundle.putString("slotname", this.zzfjp.zzglb);
        boolean z = true;
        if (this.zzfjp.zzglj.contains("new_rewarded")) {
            bundle.putBoolean("is_new_rewarded", true);
        }
        zzcxz.zza(bundle, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzxz.zzcgn)), zzxz.zzcgn != -1);
        zzcxz.zza(bundle, "extras", zzxz.extras);
        zzcxz.zza(bundle, "cust_gender", Integer.valueOf(zzxz.zzcgo), zzxz.zzcgo != -1);
        zzcxz.zza(bundle, "kw", zzxz.zzcgp);
        zzcxz.zza(bundle, "tag_for_child_directed_treatment", Integer.valueOf(zzxz.zzcgr), zzxz.zzcgr != -1);
        if (zzxz.zzcgq) {
            bundle.putBoolean("test_request", zzxz.zzcgq);
        }
        zzcxz.zza(bundle, "d_imp_hdr", (Integer) 1, zzxz.versionCode >= 2 && zzxz.zzbqn);
        zzcxz.zza(bundle, "ppid", zzxz.zzcgs, zzxz.versionCode >= 2 && !TextUtils.isEmpty(zzxz.zzcgs));
        if (zzxz.zzmw != null) {
            Location location = zzxz.zzmw;
            Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
            Long valueOf2 = Long.valueOf(location.getTime() * 1000);
            Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
            Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("radius", valueOf.floatValue());
            bundle2.putLong("lat", valueOf3.longValue());
            bundle2.putLong("long", valueOf4.longValue());
            bundle2.putLong("time", valueOf2.longValue());
            bundle.putBundle("uule", bundle2);
        }
        zzcxz.zza(bundle, ImagesContract.URL, zzxz.zzcgu);
        zzcxz.zza(bundle, "custom_targeting", zzxz.zzcgw);
        zzcxz.zza(bundle, "category_exclusions", zzxz.zzcgx);
        zzcxz.zza(bundle, "request_agent", zzxz.zzcgy);
        zzcxz.zza(bundle, "request_pkg", zzxz.zzcgz);
        zzcxz.zza(bundle, "is_designed_for_families", Boolean.valueOf(zzxz.zzcha), zzxz.versionCode >= 7);
        if (zzxz.versionCode >= 8) {
            Integer valueOf5 = Integer.valueOf(zzxz.zzchc);
            if (zzxz.zzchc == -1) {
                z = false;
            }
            zzcxz.zza(bundle, "tag_for_under_age_of_consent", valueOf5, z);
            zzcxz.zza(bundle, "max_ad_content_rating", zzxz.zzchd);
        }
    }
}
