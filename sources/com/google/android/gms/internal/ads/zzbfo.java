package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.ViewProps;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzbfo implements zzaho<zzbdf> {
    private boolean zzehp;

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 != null) {
            try {
                zzyt.zzpa();
                return zzazt.zza(context, Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length());
                sb.append("Could not parse ");
                sb.append(str);
                sb.append(" in a video GMSG: ");
                sb.append(str2);
                zzawz.zzep(sb.toString());
            }
        }
        return i;
    }

    private static void zza(zzbcq zzbcq, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzbcq.zzcy(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzawz.zzep(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", new Object[]{str, str2}));
                return;
            }
        }
        if (str2 != null) {
            zzbcq.zzcz(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzbcq.zzda(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzbcq.zzdb(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzbcq.zzdc(Integer.parseInt(str5));
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        int i;
        zzbdf zzbdf = (zzbdf) obj;
        String str = (String) map.get("action");
        if (str == null) {
            zzawz.zzep("Action missing from video GMSG.");
            return;
        }
        if (zzawz.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(jSONObject2).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(StringUtils.SPACE);
            sb.append(jSONObject2);
            zzawz.zzdp(sb.toString());
        }
        if (AppStateModule.APP_STATE_BACKGROUND.equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzawz.zzep("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzbdf.setBackgroundColor(Color.parseColor(str2));
            } catch (IllegalArgumentException unused) {
                zzawz.zzep("Invalid color parameter in video GMSG.");
            }
        } else {
            if ("decoderProps".equals(str)) {
                String str3 = (String) map.get("mimeTypes");
                if (str3 == null) {
                    zzawz.zzep("No MIME types specified for decoder properties inspection.");
                    zzbcq.zza(zzbdf, "missingMimeTypes");
                } else if (Build.VERSION.SDK_INT < 16) {
                    zzawz.zzep("Video decoder properties available on API versions >= 16.");
                    zzbcq.zza(zzbdf, "deficientApiVersion");
                } else {
                    HashMap hashMap = new HashMap();
                    for (String str4 : str3.split(",")) {
                        hashMap.put(str4, zzazr.zzeh(str4.trim()));
                    }
                    zzbcq.zza(zzbdf, (Map<String, List<Map<String, Object>>>) hashMap);
                }
            } else {
                zzbcw zzya = zzbdf.zzya();
                if (zzya == null) {
                    zzawz.zzep("Could not get underlay container for a video GMSG.");
                    return;
                }
                boolean equals = "new".equals(str);
                boolean equals2 = ViewProps.POSITION.equals(str);
                if (equals || equals2) {
                    Context context = zzbdf.getContext();
                    int zza = zza(context, map, "x", 0);
                    int zza2 = zza(context, map, "y", 0);
                    int zza3 = zza(context, map, "w", -1);
                    int zza4 = zza(context, map, "h", -1);
                    int min = Math.min(zza3, zzbdf.zzyj() - zza);
                    int min2 = Math.min(zza4, zzbdf.zzyi() - zza2);
                    try {
                        i = Integer.parseInt((String) map.get("player"));
                    } catch (NumberFormatException unused2) {
                        i = 0;
                    }
                    boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
                    if (!equals || zzya.zzxw() != null) {
                        zzya.zze(zza, zza2, min, min2);
                        return;
                    }
                    zzya.zza(zza, zza2, min, min2, i, parseBoolean, new zzbde((String) map.get("flags")));
                    zzbcq zzxw = zzya.zzxw();
                    if (zzxw != null) {
                        zza(zzxw, (Map<String, String>) map);
                        return;
                    }
                    return;
                }
                zzbhq zzyb = zzbdf.zzyb();
                if (zzyb != null) {
                    if ("timeupdate".equals(str)) {
                        String str5 = (String) map.get("currentTime");
                        if (str5 == null) {
                            zzawz.zzep("currentTime parameter missing from timeupdate video GMSG.");
                            return;
                        }
                        try {
                            zzyb.zze(Float.parseFloat(str5));
                            return;
                        } catch (NumberFormatException unused3) {
                            String valueOf = String.valueOf(str5);
                            zzawz.zzep(valueOf.length() != 0 ? "Could not parse currentTime parameter from timeupdate video GMSG: ".concat(valueOf) : new String("Could not parse currentTime parameter from timeupdate video GMSG: "));
                            return;
                        }
                    } else if ("skip".equals(str)) {
                        zzyb.zzabs();
                        return;
                    }
                }
                zzbcq zzxw2 = zzya.zzxw();
                if (zzxw2 == null) {
                    zzbcq.zzb(zzbdf);
                } else if ("click".equals(str)) {
                    Context context2 = zzbdf.getContext();
                    int zza5 = zza(context2, map, "x", 0);
                    int zza6 = zza(context2, map, "y", 0);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zza5, (float) zza6, 0);
                    zzxw2.zze(obtain);
                    obtain.recycle();
                } else if ("currentTime".equals(str)) {
                    String str6 = (String) map.get("time");
                    if (str6 == null) {
                        zzawz.zzep("Time parameter missing from currentTime video GMSG.");
                        return;
                    }
                    try {
                        zzxw2.seekTo((int) (Float.parseFloat(str6) * 1000.0f));
                    } catch (NumberFormatException unused4) {
                        String valueOf2 = String.valueOf(str6);
                        zzawz.zzep(valueOf2.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(valueOf2) : new String("Could not parse time parameter from currentTime video GMSG: "));
                    }
                } else if ("hide".equals(str)) {
                    zzxw2.setVisibility(4);
                } else if ("load".equals(str)) {
                    zzxw2.zzfr();
                } else if ("loadControl".equals(str)) {
                    zza(zzxw2, (Map<String, String>) map);
                } else if ("muted".equals(str)) {
                    if (Boolean.parseBoolean((String) map.get("muted"))) {
                        zzxw2.zzxq();
                    } else {
                        zzxw2.zzxr();
                    }
                } else if ("pause".equals(str)) {
                    zzxw2.pause();
                } else if ("play".equals(str)) {
                    zzxw2.play();
                } else if ("show".equals(str)) {
                    zzxw2.setVisibility(0);
                } else if ("src".equals(str)) {
                    String str7 = (String) map.get("src");
                    String[] strArr = {str7};
                    String str8 = (String) map.get("demuxed");
                    if (str8 != null) {
                        try {
                            JSONArray jSONArray = new JSONArray(str8);
                            String[] strArr2 = new String[jSONArray.length()];
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                strArr2[i2] = jSONArray.getString(i2);
                            }
                            strArr = strArr2;
                        } catch (JSONException unused5) {
                            String valueOf3 = String.valueOf(str8);
                            zzawz.zzep(valueOf3.length() != 0 ? "Malformed demuxed URL list for playback: ".concat(valueOf3) : new String("Malformed demuxed URL list for playback: "));
                            strArr = new String[]{str7};
                        }
                    }
                    zzxw2.zzc(str7, strArr);
                } else if ("touchMove".equals(str)) {
                    Context context3 = zzbdf.getContext();
                    zzxw2.zza((float) zza(context3, map, "dx", 0), (float) zza(context3, map, "dy", 0));
                    if (!this.zzehp) {
                        zzbdf.zztm();
                        this.zzehp = true;
                    }
                } else if ("volume".equals(str)) {
                    String str9 = (String) map.get("volume");
                    if (str9 == null) {
                        zzawz.zzep("Level parameter missing from volume video GMSG.");
                        return;
                    }
                    try {
                        zzxw2.setVolume(Float.parseFloat(str9));
                    } catch (NumberFormatException unused6) {
                        String valueOf4 = String.valueOf(str9);
                        zzawz.zzep(valueOf4.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(valueOf4) : new String("Could not parse volume parameter from volume video GMSG: "));
                    }
                } else if ("watermark".equals(str)) {
                    zzxw2.zzxs();
                } else {
                    String valueOf5 = String.valueOf(str);
                    zzawz.zzep(valueOf5.length() != 0 ? "Unknown video action: ".concat(valueOf5) : new String("Unknown video action: "));
                }
            }
        }
    }
}
