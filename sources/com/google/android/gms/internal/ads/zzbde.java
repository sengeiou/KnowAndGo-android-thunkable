package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzbde {
    public final boolean zzeec;
    public final int zzeed;
    public final int zzeee;
    public final int zzeef;
    public final String zzeeg;
    public final int zzeeh;
    public final int zzeei;
    public final int zzeej;
    public final int zzeek;
    public final boolean zzeel;

    public zzbde(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zzeec = zza(jSONObject, "aggressive_media_codec_release", zzacu.zzcmi);
        this.zzeed = zzb(jSONObject, "byte_buffer_precache_limit", zzacu.zzclr);
        this.zzeee = zzb(jSONObject, "exo_cache_buffer_size", zzacu.zzclw);
        this.zzeef = zzb(jSONObject, "exo_connect_timeout_millis", zzacu.zzcln);
        this.zzeeg = zzc(jSONObject, "exo_player_version", zzacu.zzclm);
        this.zzeeh = zzb(jSONObject, "exo_read_timeout_millis", zzacu.zzclo);
        this.zzeei = zzb(jSONObject, "load_check_interval_bytes", zzacu.zzclp);
        this.zzeej = zzb(jSONObject, "player_precache_limit", zzacu.zzclq);
        this.zzeek = zzb(jSONObject, "socket_receive_buffer_size", zzacu.zzcls);
        this.zzeel = zza(jSONObject, "use_cache_data_source", zzacu.zzctr);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.internal.ads.zzacj<java.lang.Boolean>, com.google.android.gms.internal.ads.zzacj] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zza(org.json.JSONObject r1, java.lang.String r2, com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r3) {
        /*
            com.google.android.gms.internal.ads.zzacr r0 = com.google.android.gms.internal.ads.zzyt.zzpe()
            java.lang.Object r3 = r0.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            boolean r1 = zza((org.json.JSONObject) r1, (java.lang.String) r2, (boolean) r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbde.zza(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzacj):boolean");
    }

    private static boolean zza(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return z;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzacj<java.lang.Integer>, com.google.android.gms.internal.ads.zzacj] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(org.json.JSONObject r0, java.lang.String r1, com.google.android.gms.internal.ads.zzacj<java.lang.Integer> r2) {
        /*
            if (r0 == 0) goto L_0x0007
            int r0 = r0.getInt(r1)     // Catch:{ JSONException -> 0x0007 }
            return r0
        L_0x0007:
            com.google.android.gms.internal.ads.zzacr r0 = com.google.android.gms.internal.ads.zzyt.zzpe()
            java.lang.Object r0 = r0.zzd(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbde.zzb(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzacj):int");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzacj<java.lang.String>, com.google.android.gms.internal.ads.zzacj] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String zzc(org.json.JSONObject r0, java.lang.String r1, com.google.android.gms.internal.ads.zzacj<java.lang.String> r2) {
        /*
            if (r0 == 0) goto L_0x0007
            java.lang.String r0 = r0.getString(r1)     // Catch:{ JSONException -> 0x0007 }
            return r0
        L_0x0007:
            com.google.android.gms.internal.ads.zzacr r0 = com.google.android.gms.internal.ads.zzyt.zzpe()
            java.lang.Object r0 = r0.zzd(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbde.zzc(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzacj):java.lang.String");
    }
}
