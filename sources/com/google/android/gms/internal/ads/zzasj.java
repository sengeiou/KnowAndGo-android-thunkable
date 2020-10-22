package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzasj extends zzasl {
    private final Object lock = new Object();
    @Nullable
    private SharedPreferences zzdqi;
    private final zzalj<JSONObject, JSONObject> zzdqj;
    private final Context zzys;

    public zzasj(Context context, zzalj<JSONObject, JSONObject> zzalj) {
        this.zzys = context.getApplicationContext();
        this.zzdqj = zzalj;
    }

    public final zzbbh<Void> zztz() {
        synchronized (this.lock) {
            if (this.zzdqi == null) {
                this.zzdqi = this.zzys.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (zzk.zzln().currentTimeMillis() - this.zzdqi.getLong("js_last_update", 0) < ((Long) zzyt.zzpe().zzd(zzacu.zzcrw)).longValue()) {
            return zzbar.zzm(null);
        }
        return zzbar.zza(this.zzdqj.zzi(zzu(this.zzys)), new zzask(this), zzbbm.zzeaf);
    }

    public static JSONObject zzu(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzbai.zzxc().zzbsx);
            jSONObject.put("mf", zzyt.zzpe().zzd(zzacu.zzcrx));
            jSONObject.put("cl", "248613007");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", 11140);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451009);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzf(JSONObject jSONObject) {
        zzacu.zza(this.zzys, 1, jSONObject);
        this.zzdqi.edit().putLong("js_last_update", zzk.zzln().currentTimeMillis()).apply();
        return null;
    }
}
