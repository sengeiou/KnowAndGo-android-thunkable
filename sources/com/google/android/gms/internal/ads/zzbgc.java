package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzbgc implements zzaho<zzbdf> {
    private static Integer zza(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzawz.zzep(sb.toString());
            return null;
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbft zzbft;
        zzbdf zzbdf = (zzbdf) obj;
        if (zzawz.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(valueOf);
            zzawz.zzdp(sb.toString());
        }
        zzk.zzmc();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str != null) {
                String[] strArr = {str};
                String str2 = (String) map.get("demuxed");
                if (str2 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str2);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i = 0; i < jSONArray.length(); i++) {
                            strArr2[i] = jSONArray.getString(i);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused) {
                        String valueOf2 = String.valueOf(str2);
                        zzawz.zzep(valueOf2.length() != 0 ? "Malformed demuxed URL list for precache: ".concat(valueOf2) : new String("Malformed demuxed URL list for precache: "));
                        strArr = null;
                    }
                }
                if (strArr == null) {
                    strArr = new String[]{str};
                }
                if (zzbfs.zzd(zzbdf) != null) {
                    zzawz.zzep("Precache task is already running.");
                    return;
                } else if (zzbdf.zzye() == null) {
                    zzawz.zzep("Precache requires a dependency provider.");
                    return;
                } else {
                    zzbde zzbde = new zzbde((String) map.get("flags"));
                    Integer zza = zza((Map<String, String>) map, "player");
                    if (zza == null) {
                        zza = 0;
                    }
                    zzbft = zzbdf.zzye().zzbqr.zza(zzbdf, zza.intValue(), (String) null, zzbde);
                    new zzbfq(zzbdf, zzbft, str, strArr).zzvi();
                }
            } else {
                zzbfq zzd = zzbfs.zzd(zzbdf);
                if (zzd != null) {
                    zzbft = zzd.zzehq;
                } else {
                    zzawz.zzep("Precache must specify a source.");
                    return;
                }
            }
            Integer zza2 = zza((Map<String, String>) map, "minBufferMs");
            if (zza2 != null) {
                zzbft.zzcy(zza2.intValue());
            }
            Integer zza3 = zza((Map<String, String>) map, "maxBufferMs");
            if (zza3 != null) {
                zzbft.zzcz(zza3.intValue());
            }
            Integer zza4 = zza((Map<String, String>) map, "bufferForPlaybackMs");
            if (zza4 != null) {
                zzbft.zzda(zza4.intValue());
            }
            Integer zza5 = zza((Map<String, String>) map, "bufferForPlaybackAfterRebufferMs");
            if (zza5 != null) {
                zzbft.zzdb(zza5.intValue());
            }
        } else if (!zzbfs.zzc(zzbdf)) {
            zzawz.zzep("Precache abort but no precache task running.");
        }
    }
}
