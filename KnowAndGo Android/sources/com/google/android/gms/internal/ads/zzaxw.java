package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import com.amplitude.api.DeviceInfo;
import com.google.android.gms.ads.internal.zzk;

@TargetApi(24)
public class zzaxw extends zzaxv {
    public final boolean zza(Activity activity, Configuration configuration) {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcuh)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcuj)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzyt.zzpa();
        int zza = zzazt.zza((Context) activity, configuration.screenHeightDp);
        int zza2 = zzazt.zza((Context) activity, configuration.screenWidthDp);
        zzk.zzlg();
        DisplayMetrics zza3 = zzaxi.zza((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = zza3.heightPixels;
        int i2 = zza3.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", DeviceInfo.OS_NAME);
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        int round = ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d)) * ((Integer) zzyt.zzpe().zzd(zzacu.zzcug)).intValue();
        if (!(zze(i, zza + dimensionPixelSize, round) && zze(i2, zza2, round))) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    private static boolean zze(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }
}
