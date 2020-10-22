package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
public final class zzavx {
    public static String zzd(String str, Context context, boolean z) {
        String zzac;
        if ((((Boolean) zzyt.zzpe().zzd(zzacu.zzcod)).booleanValue() && !z) || !zzk.zzme().zzx(context) || TextUtils.isEmpty(str) || (zzac = zzk.zzme().zzac(context)) == null) {
            return str;
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcnv)).booleanValue()) {
            String str2 = (String) zzyt.zzpe().zzd(zzacu.zzcnw);
            if (str.contains(str2)) {
                if (zzk.zzlg().zzea(str)) {
                    zzk.zzme().zzg(context, zzac);
                    return str.replace(str2, zzac);
                } else if (zzk.zzlg().zzeb(str)) {
                    zzk.zzme().zzh(context, zzac);
                    return str.replace(str2, zzac);
                }
            }
        } else if (!str.contains("fbs_aeid")) {
            if (zzk.zzlg().zzea(str)) {
                zzk.zzme().zzg(context, zzac);
                return zza(str, "fbs_aeid", zzac).toString();
            } else if (zzk.zzlg().zzeb(str)) {
                zzk.zzme().zzh(context, zzac);
                return zza(str, "fbs_aeid", zzac).toString();
            }
        }
        return str;
    }

    public static String zzb(Uri uri, Context context) {
        if (!zzk.zzme().zzx(context)) {
            return uri.toString();
        }
        String zzac = zzk.zzme().zzac(context);
        if (zzac == null) {
            return uri.toString();
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcnv)).booleanValue()) {
            String str = (String) zzyt.zzpe().zzd(zzacu.zzcnw);
            String uri2 = uri.toString();
            if (uri2.contains(str)) {
                zzk.zzme().zzg(context, zzac);
                return uri2.replace(str, zzac);
            }
        } else if (TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            uri = zza(uri.toString(), "fbs_aeid", zzac);
            zzk.zzme().zzg(context, zzac);
        }
        return uri.toString();
    }

    @VisibleForTesting
    private static Uri zza(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i = indexOf + 1;
        return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + "&" + str.substring(i));
    }
}
