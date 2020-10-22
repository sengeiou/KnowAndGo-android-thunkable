package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;
import java.util.Locale;

final class zzcvg implements zzcva<zzcvf> {
    private final zzbbl zzfqw;
    private final Context zzlj;

    public zzcvg(zzbbl zzbbl, Context context) {
        this.zzfqw = zzbbl;
        this.zzlj = context;
    }

    public final zzbbh<zzcvf> zzalm() {
        return this.zzfqw.zza(new zzcvh(this));
    }

    private static String zzs(Context context) {
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.vending", 128);
            if (packageInfo == null) {
                return null;
            }
            int i = packageInfo.versionCode;
            String str = packageInfo.packageName;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
            sb.append(i);
            sb.append(".");
            sb.append(str);
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private static String zza(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza == null || (activityInfo = zza.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo == null) {
                return null;
            }
            int i = packageInfo.versionCode;
            String str = activityInfo.packageName;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
            sb.append(i);
            sb.append(".");
            sb.append(str);
            return sb.toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcvf zzalz() throws Exception {
        boolean z;
        PackageManager packageManager = this.zzlj.getPackageManager();
        Locale locale = Locale.getDefault();
        boolean z2 = zza(packageManager, "geo:0,0?q=donuts") != null;
        boolean z3 = zza(packageManager, "http://www.google.com") != null;
        String country = locale.getCountry();
        boolean startsWith = Build.DEVICE.startsWith("generic");
        boolean isLatchsky = DeviceProperties.isLatchsky(this.zzlj);
        boolean isSidewinder = DeviceProperties.isSidewinder(this.zzlj);
        String language = locale.getLanguage();
        String zza = zza(this.zzlj, packageManager);
        String zzs = zzs(this.zzlj);
        String str = Build.FINGERPRINT;
        Context context = this.zzlj;
        if (packageManager != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                int i = 0;
                while (true) {
                    if (i >= queryIntentActivities.size()) {
                        break;
                    } else if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i).activityInfo.name)) {
                        z = resolveActivity.activityInfo.packageName.equals(zzdtv.zzbu(context));
                        break;
                    } else {
                        i++;
                    }
                }
                return new zzcvf(z2, z3, country, startsWith, isLatchsky, isSidewinder, language, zza, zzs, str, z, Build.MODEL);
            }
        }
        z = false;
        return new zzcvf(z2, z3, country, startsWith, isLatchsky, isSidewinder, language, zza, zzs, str, z, Build.MODEL);
    }
}
