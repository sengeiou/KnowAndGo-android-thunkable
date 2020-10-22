package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzayi {
    private final Object lock = new Object();
    @GuardedBy("lock")
    private String zzdwn = "";
    @GuardedBy("lock")
    private String zzdwo = "";
    @GuardedBy("lock")
    private boolean zzdwp = false;
    @VisibleForTesting
    private String zzdwq = "";

    public final void zze(Context context, String str, String str2) {
        if (!zzf(context, str, str2)) {
            zza(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if (ExifInterface.GPS_MEASUREMENT_2D.equals(this.zzdwq)) {
            zzawz.zzdp("Creative is not pushed for this device.");
            zza(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.zzdwq)) {
            zzawz.zzdp("The app is not linked for creative preview.");
            zzi(context, str, str2);
        } else if ("0".equals(this.zzdwq)) {
            zzawz.zzdp("Device is linked for in app preview.");
            zza(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final void zza(Context context, String str, String str2, @Nullable String str3) {
        boolean zzwo = zzwo();
        if (zzg(context, str, str2)) {
            if (!zzwo && !TextUtils.isEmpty(str3)) {
                zzc(context, str2, str3, str);
            }
            zzawz.zzdp("Device is linked for debug signals.");
            zza(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        zzi(context, str, str2);
    }

    @VisibleForTesting
    private final boolean zzf(Context context, String str, String str2) {
        String zzh = zzh(context, zzd(context, (String) zzyt.zzpe().zzd(zzacu.zzcuc), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzawz.zzdp("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(zzh.trim());
            String optString = jSONObject.optString("gct");
            this.zzdwq = jSONObject.optString("status");
            synchronized (this.lock) {
                this.zzdwo = optString;
            }
            return true;
        } catch (JSONException e) {
            zzawz.zzd("Fail to get in app preview response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    private final boolean zzg(Context context, String str, String str2) {
        String zzh = zzh(context, zzd(context, (String) zzyt.zzpe().zzd(zzacu.zzcud), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzawz.zzdp("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(zzh.trim()).optString("debug_mode"));
            synchronized (this.lock) {
                this.zzdwp = equals;
            }
            return equals;
        } catch (JSONException e) {
            zzawz.zzd("Fail to get debug mode response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    private static String zzh(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", zzk.zzlg().zzq(context, str2));
        zzbbh<String> zzc = new zzayu(context).zzc(str, hashMap);
        try {
            return (String) zzc.get((long) ((Integer) zzyt.zzpe().zzd(zzacu.zzcuf)).intValue(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            String valueOf = String.valueOf(str);
            zzawz.zzc(valueOf.length() != 0 ? "Timeout while retriving a response from: ".concat(valueOf) : new String("Timeout while retriving a response from: "), e);
            zzc.cancel(true);
            return null;
        } catch (InterruptedException e2) {
            String valueOf2 = String.valueOf(str);
            zzawz.zzc(valueOf2.length() != 0 ? "Interrupted while retriving a response from: ".concat(valueOf2) : new String("Interrupted while retriving a response from: "), e2);
            zzc.cancel(true);
            return null;
        } catch (Exception e3) {
            String valueOf3 = String.valueOf(str);
            zzawz.zzc(valueOf3.length() != 0 ? "Error retriving a response from: ".concat(valueOf3) : new String("Error retriving a response from: "), e3);
            return null;
        }
    }

    private final void zzi(Context context, String str, String str2) {
        zzk.zzlg();
        zzaxi.zza(context, zzd(context, (String) zzyt.zzpe().zzd(zzacu.zzcub), str, str2));
    }

    public final boolean zzb(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzk.zzlq().zzwo()) {
            return false;
        }
        zzawz.zzdp("Sending troubleshooting signals to the server.");
        zzc(context, str, str2, str3);
        return true;
    }

    private final void zzc(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzd(context, (String) zzyt.zzpe().zzd(zzacu.zzcue), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzk.zzlg();
        zzaxi.zzb(context, str, buildUpon.build().toString());
    }

    private final Uri zzd(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", zzbb(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    private final String zzbb(Context context) {
        String str;
        synchronized (this.lock) {
            if (TextUtils.isEmpty(this.zzdwn)) {
                zzk.zzlg();
                this.zzdwn = zzaxi.zzr(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.zzdwn)) {
                    zzk.zzlg();
                    this.zzdwn = zzaxi.zzwb();
                    zzk.zzlg();
                    zzaxi.zzc(context, "debug_signals_id.txt", this.zzdwn);
                }
            }
            str = this.zzdwn;
        }
        return str;
    }

    public final String zzwn() {
        String str;
        synchronized (this.lock) {
            str = this.zzdwo;
        }
        return str;
    }

    public final boolean zzwo() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzdwp;
        }
        return z;
    }

    @VisibleForTesting
    private final void zza(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzawz.zzeo("Can not create dialog without Activity Context");
        } else {
            zzaxi.zzdvv.post(new zzayj(this, context, str, z, z2));
        }
    }
}
