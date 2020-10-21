package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.C1470C;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzacu;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzyt;

@zzard
public final class zza {
    public static boolean zza(Context context, zzc zzc, zzu zzu) {
        int i;
        if (zzc == null) {
            zzawz.zzep("No intent data for launcher overlay.");
            return false;
        }
        zzacu.initialize(context);
        if (zzc.intent != null) {
            return zza(context, zzc.intent, zzu);
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(zzc.url)) {
            zzawz.zzep("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzc.mimeType)) {
            intent.setDataAndType(Uri.parse(zzc.url), zzc.mimeType);
        } else {
            intent.setData(Uri.parse(zzc.url));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzc.packageName)) {
            intent.setPackage(zzc.packageName);
        }
        if (!TextUtils.isEmpty(zzc.zzdjh)) {
            String[] split = zzc.zzdjh.split("/", 2);
            if (split.length < 2) {
                String valueOf = String.valueOf(zzc.zzdjh);
                zzawz.zzep(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        String str = zzc.zzdji;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                zzawz.zzep("Could not parse intent flags.");
                i = 0;
            }
            intent.addFlags(i);
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzctz)).booleanValue()) {
            intent.addFlags(C1470C.ENCODING_PCM_MU_LAW);
            intent.putExtra("androidx.browser.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcty)).booleanValue()) {
                zzk.zzlg();
                zzaxi.zzb(context, intent);
            }
        }
        return zza(context, intent, zzu);
    }

    private static boolean zza(Context context, Intent intent, zzu zzu) {
        try {
            String valueOf = String.valueOf(intent.toURI());
            zzawz.zzds(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            zzk.zzlg();
            zzaxi.zza(context, intent);
            if (zzu == null) {
                return true;
            }
            zzu.zztq();
            return true;
        } catch (ActivityNotFoundException e) {
            zzawz.zzep(e.getMessage());
            return false;
        }
    }
}
