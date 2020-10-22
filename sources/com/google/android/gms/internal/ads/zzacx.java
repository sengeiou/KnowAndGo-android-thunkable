package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.zzk;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

@zzard
public final class zzacx {
    private String zzbsx = null;
    private String zzcwz;
    private Map<String, String> zzcxa;
    private Context zzlj = null;

    public zzacx(Context context, String str) {
        String str2;
        this.zzlj = context;
        this.zzbsx = str;
        this.zzcwz = (String) zzyt.zzpe().zzd(zzacu.zzcmy);
        this.zzcxa = new LinkedHashMap();
        this.zzcxa.put("s", "gmob_sdk");
        this.zzcxa.put("v", ExifInterface.GPS_MEASUREMENT_3D);
        this.zzcxa.put("os", Build.VERSION.RELEASE);
        this.zzcxa.put("sdk", Build.VERSION.SDK);
        Map<String, String> map = this.zzcxa;
        zzk.zzlg();
        map.put("device", zzaxi.zzwc());
        Map<String, String> map2 = this.zzcxa;
        if (context.getApplicationContext() != null) {
            str2 = context.getApplicationContext().getPackageName();
        } else {
            str2 = context.getPackageName();
        }
        map2.put("app", str2);
        Map<String, String> map3 = this.zzcxa;
        zzk.zzlg();
        map3.put("is_lite_sdk", zzaxi.zzau(context) ? "1" : "0");
        Future<zzase> zzt = zzk.zzlr().zzt(this.zzlj);
        try {
            this.zzcxa.put("network_coarse", Integer.toString(zzt.get().zzdps));
            this.zzcxa.put("network_fine", Integer.toString(zzt.get().zzdpt));
        } catch (Exception e) {
            zzk.zzlk().zza(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzqr() {
        return this.zzcwz;
    }

    /* access modifiers changed from: package-private */
    public final Context getContext() {
        return this.zzlj;
    }

    /* access modifiers changed from: package-private */
    public final String zzmg() {
        return this.zzbsx;
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zzqs() {
        return this.zzcxa;
    }
}
