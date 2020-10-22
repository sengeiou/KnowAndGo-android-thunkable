package com.google.android.gms.ads;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzabe;
import com.google.android.gms.internal.ads.zzabi;
import com.google.android.gms.internal.ads.zztx;

public class MobileAds {
    @RequiresPermission("android.permission.INTERNET")
    public static void initialize(Context context, String str) {
        initialize(context, str, (Settings) null);
    }

    @RequiresPermission("android.permission.INTERNET")
    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        zzabi zzabi;
        zzabe zzqf = zzabe.zzqf();
        if (settings == null) {
            zzabi = null;
        } else {
            zzabi = settings.zzdg();
        }
        zzqf.zza(context, str, zzabi, (zztx) null);
    }

    public static final class Settings {
        private final zzabi zzaat = new zzabi();

        @Deprecated
        public final String getTrackingId() {
            return null;
        }

        @Deprecated
        public final boolean isGoogleAnalyticsEnabled() {
            return false;
        }

        @Deprecated
        public final Settings setGoogleAnalyticsEnabled(boolean z) {
            return this;
        }

        @Deprecated
        public final Settings setTrackingId(String str) {
            return this;
        }

        /* access modifiers changed from: package-private */
        public final zzabi zzdg() {
            return this.zzaat;
        }
    }

    public static void initialize(Context context) {
        initialize(context, (String) null, (Settings) null);
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzabe.zzqf().getRewardedVideoAdInstance(context);
    }

    public static void setAppVolume(float f) {
        zzabe.zzqf().setAppVolume(f);
    }

    public static void setAppMuted(boolean z) {
        zzabe.zzqf().setAppMuted(z);
    }

    public static void openDebugMenu(Context context, String str) {
        zzabe.zzqf().openDebugMenu(context, str);
    }

    @KeepForSdk
    public static String getVersionString() {
        return zzabe.zzqf().getVersionString();
    }

    @KeepForSdk
    public static void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        zzabe.zzqf().registerRtbAdapter(cls);
    }

    private MobileAds() {
    }
}
