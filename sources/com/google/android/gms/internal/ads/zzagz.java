package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzagz {
    public static final zzaho<zzbgz> zzczq = zzaha.zzdai;
    public static final zzaho<zzbgz> zzczr = zzahb.zzdai;
    public static final zzaho<zzbgz> zzczs = zzahc.zzdai;
    public static final zzaho<zzbgz> zzczt = new zzahf();
    public static final zzaho<zzbgz> zzczu = new zzahg();
    public static final zzaho<zzbgz> zzczv = zzahd.zzdai;
    public static final zzaho<Object> zzczw = new zzahh();
    public static final zzaho<zzbgz> zzczx = new zzahi();
    public static final zzaho<zzbgz> zzczy = zzahe.zzdai;
    public static final zzaho<zzbgz> zzczz = new zzahj();
    public static final zzaho<zzbgz> zzdaa = new zzahk();
    public static final zzaho<zzbdf> zzdab = new zzbfo();
    public static final zzaho<zzbdf> zzdac = new zzbfp();
    public static final zzaho<zzbgz> zzdad = new zzagy();
    public static final zzahu zzdae = new zzahu();
    public static final zzaho<zzbgz> zzdaf = new zzahl();
    public static final zzaho<zzbgz> zzdag = new zzahm();
    public static final zzaho<zzbgz> zzdah = new zzahn();

    static final /* synthetic */ void zza(zzbif zzbif, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzdh zzaal = zzbif.zzaal();
            if (zzaal != null) {
                zzaal.zzcg().zza(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            zzawz.zzep("Could not parse touch parameters from gmsg.");
        }
    }

    static final /* synthetic */ void zza(zzbhx zzbhx, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzawz.zzep("URL missing from httpTrack GMSG.");
        } else {
            new zzazi(zzbhx.getContext(), ((zzbig) zzbhx).zzyh().zzbsx, str).zzvi();
        }
    }

    static final /* synthetic */ void zza(zzaji zzaji, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzawz.zzep("URL missing from click GMSG.");
            return;
        }
        Uri parse = Uri.parse(str);
        try {
            zzdh zzaal = ((zzbif) zzaji).zzaal();
            if (zzaal != null && zzaal.zzc(parse)) {
                parse = zzaal.zza(parse, ((zzbhx) zzaji).getContext(), ((zzbih) zzaji).getView(), ((zzbhx) zzaji).zzyd());
            }
        } catch (zzdi unused) {
            String valueOf = String.valueOf(str);
            zzawz.zzep(valueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf) : new String("Unable to append parameter to URL: "));
        }
        zzbhx zzbhx = (zzbhx) zzaji;
        new zzazi(zzbhx.getContext(), ((zzbig) zzaji).zzyh().zzbsx, zzavx.zzb(parse, zzbhx.getContext())).zzvi();
    }

    static final /* synthetic */ void zzb(zzbhx zzbhx, Map map) {
        PackageManager packageManager = zzbhx.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString("u");
                        String optString3 = jSONObject2.optString("i");
                        String optString4 = jSONObject2.optString("m");
                        String optString5 = jSONObject2.optString("p");
                        String optString6 = jSONObject2.optString("c");
                        jSONObject2.optString("f");
                        jSONObject2.optString("e");
                        String optString7 = jSONObject2.optString("intent_url");
                        Intent intent = null;
                        if (!TextUtils.isEmpty(optString7)) {
                            try {
                                intent = Intent.parseUri(optString7, 0);
                            } catch (URISyntaxException e) {
                                URISyntaxException uRISyntaxException = e;
                                String valueOf = String.valueOf(optString7);
                                zzawz.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), uRISyntaxException);
                            }
                        }
                        boolean z = true;
                        if (intent == null) {
                            intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                        }
                        if (packageManager.resolveActivity(intent, 65536) == null) {
                            z = false;
                        }
                        try {
                            jSONObject.put(optString, z);
                        } catch (JSONException e2) {
                            zzawz.zzc("Error constructing openable urls response.", e2);
                        }
                    } catch (JSONException e3) {
                        zzawz.zzc("Error parsing the intent data.", e3);
                    }
                }
                ((zzaji) zzbhx).zza("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzaji) zzbhx).zza("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzaji) zzbhx).zza("openableIntents", new JSONObject());
        }
    }

    static final /* synthetic */ void zzc(zzbhx zzbhx, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            zzawz.zzep("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzbhx.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                z = false;
            }
            hashMap.put(str2, Boolean.valueOf(z));
        }
        ((zzaji) zzbhx).zza("openableURLs", (Map<String, ?>) hashMap);
    }
}
