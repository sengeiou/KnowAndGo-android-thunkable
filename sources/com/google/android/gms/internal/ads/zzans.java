package com.google.android.gms.internal.ads;

import android.location.Location;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;

@zzard
public final class zzans implements NativeMediationAdRequest {
    private final int zzcgo;
    private final boolean zzcha;
    private final String zzchd;
    private final int zzdga;
    private final int zzdgb;
    private final zzady zzdgs;
    private final List<String> zzdgt = new ArrayList();
    private final Map<String, Boolean> zzdgu = new HashMap();
    private final Date zzms;
    private final Set<String> zzmu;
    private final boolean zzmv;
    private final Location zzmw;

    public zzans(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, zzady zzady, List<String> list, boolean z2, int i3, String str) {
        this.zzms = date;
        this.zzcgo = i;
        this.zzmu = set;
        this.zzmw = location;
        this.zzmv = z;
        this.zzdga = i2;
        this.zzdgs = zzady;
        this.zzcha = z2;
        this.zzdgb = i3;
        this.zzchd = str;
        if (list != null) {
            for (String next : list) {
                if (next.startsWith("custom:")) {
                    String[] split = next.split(ParameterizedMessage.ERROR_MSG_SEPARATOR, 3);
                    if (split.length == 3) {
                        if ("true".equals(split[2])) {
                            this.zzdgu.put(split[1], true);
                        } else if ("false".equals(split[2])) {
                            this.zzdgu.put(split[1], false);
                        }
                    }
                } else {
                    this.zzdgt.add(next);
                }
            }
        }
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zzms;
    }

    @Deprecated
    public final int getGender() {
        return this.zzcgo;
    }

    public final Set<String> getKeywords() {
        return this.zzmu;
    }

    public final Location getLocation() {
        return this.zzmw;
    }

    public final boolean isTesting() {
        return this.zzmv;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzdga;
    }

    public final NativeAdOptions getNativeAdOptions() {
        if (this.zzdgs == null) {
            return null;
        }
        NativeAdOptions.Builder requestMultipleImages = new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.zzdgs.zzcym).setImageOrientation(this.zzdgs.zzbqc).setRequestMultipleImages(this.zzdgs.zzbqe);
        if (this.zzdgs.versionCode >= 2) {
            requestMultipleImages.setAdChoicesPlacement(this.zzdgs.zzbqf);
        }
        if (this.zzdgs.versionCode >= 3 && this.zzdgs.zzcyn != null) {
            requestMultipleImages.setVideoOptions(new VideoOptions(this.zzdgs.zzcyn));
        }
        return requestMultipleImages.build();
    }

    public final boolean isAdMuted() {
        return zzabe.zzqf().zzpr();
    }

    public final float getAdVolume() {
        return zzabe.zzqf().zzpq();
    }

    public final boolean isAppInstallAdRequested() {
        if (this.zzdgt != null) {
            return this.zzdgt.contains(ExifInterface.GPS_MEASUREMENT_2D) || this.zzdgt.contains("6");
        }
        return false;
    }

    public final boolean isUnifiedNativeAdRequested() {
        return this.zzdgt != null && this.zzdgt.contains("6");
    }

    public final boolean isContentAdRequested() {
        if (this.zzdgt != null) {
            return this.zzdgt.contains("1") || this.zzdgt.contains("6");
        }
        return false;
    }

    public final boolean zzsu() {
        return this.zzdgt != null && this.zzdgt.contains(ExifInterface.GPS_MEASUREMENT_3D);
    }

    public final Map<String, Boolean> zzsv() {
        return this.zzdgu;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzcha;
    }
}
