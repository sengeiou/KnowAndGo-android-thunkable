package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzard
public final class zzagy implements zzaho<zzbgz> {
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbgz zzbgz = (zzbgz) obj;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzawz.zzep("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzawz.zzep("No timestamp given for CSI tick.");
            } else {
                try {
                    long elapsedRealtime = zzk.zzln().elapsedRealtime() + (Long.parseLong(str4) - zzk.zzln().currentTimeMillis());
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzbgz.zzyg().zza(str2, str3, elapsedRealtime);
                } catch (NumberFormatException e) {
                    zzawz.zzd("Malformed timestamp for CSI tick.", e);
                }
            }
        } else if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzawz.zzep("No value given for CSI experiment.");
                return;
            }
            zzadi zzqw = zzbgz.zzyg().zzqw();
            if (zzqw == null) {
                zzawz.zzep("No ticker for WebView, dropping experiment ID.");
            } else {
                zzqw.zzh("e", str5);
            }
        } else if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzawz.zzep("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                zzawz.zzep("No name given for CSI extra.");
            } else {
                zzadi zzqw2 = zzbgz.zzyg().zzqw();
                if (zzqw2 == null) {
                    zzawz.zzep("No ticker for WebView, dropping extra parameter.");
                } else {
                    zzqw2.zzh(str6, str7);
                }
            }
        }
    }
}
