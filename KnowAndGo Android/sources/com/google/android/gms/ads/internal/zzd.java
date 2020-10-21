package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzacu;
import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzalo;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzawl;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbbh;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzyt;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
@zzard
public final class zzd {
    private long zzbqy = 0;
    private Context zzlj;

    public final void zza(Context context, zzbai zzbai, String str, @Nullable Runnable runnable) {
        zza(context, zzbai, true, (zzawl) null, str, (String) null, runnable);
    }

    public final void zza(Context context, zzbai zzbai, String str, zzawl zzawl) {
        zza(context, zzbai, false, zzawl, zzawl != null ? zzawl.zzut() : null, str, (Runnable) null);
    }

    @VisibleForTesting
    private final void zza(Context context, zzbai zzbai, boolean z, @Nullable zzawl zzawl, String str, @Nullable String str2, @Nullable Runnable runnable) {
        if (zzk.zzln().elapsedRealtime() - this.zzbqy < DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS) {
            zzawz.zzep("Not retrying to fetch app settings");
            return;
        }
        this.zzbqy = zzk.zzln().elapsedRealtime();
        boolean z2 = true;
        if (zzawl != null) {
            if (!(zzk.zzln().currentTimeMillis() - zzawl.zzuq() > ((Long) zzyt.zzpe().zzd(zzacu.zzcsy)).longValue()) && zzawl.zzur()) {
                z2 = false;
            }
        }
        if (z2) {
            if (context == null) {
                zzawz.zzep("Context not provided to fetch application settings");
            } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                this.zzlj = applicationContext;
                zzalj<I, O> zza = zzk.zzlt().zzb(this.zzlj, zzbai).zza("google.afma.config.fetchAppSettings", zzalo.zzddi, zzalo.zzddi);
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("app_id", str);
                    } else if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("ad_unit_id", str2);
                    }
                    jSONObject.put("is_init", z);
                    jSONObject.put("pn", context.getPackageName());
                    zzbbh<O> zzi = zza.zzi(jSONObject);
                    zzbbh<B> zza2 = zzbar.zza(zzi, zze.zzbqz, zzbbm.zzeaf);
                    if (runnable != null) {
                        zzi.zza(runnable, zzbbm.zzeaf);
                    }
                    zzbao.zza(zza2, "ConfigLoader.maybeFetchNewAppSettings");
                } catch (Exception e) {
                    zzawz.zzc("Error requesting application settings", e);
                }
            } else {
                zzawz.zzep("App settings could not be fetched. Required parameters missing");
            }
        }
    }
}
