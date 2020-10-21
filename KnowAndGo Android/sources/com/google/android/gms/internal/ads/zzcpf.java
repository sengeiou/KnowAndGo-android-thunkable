package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcpf {
    private final Executor zzffi;
    private final zzclc zzfvd;
    private final Map<String, zzcpk> zzgdg = new ConcurrentHashMap();
    private final Map<String, List<zzcpk>> zzgdh = new ConcurrentHashMap();
    private final Context zzlj;

    public zzcpf(zzclc zzclc, Executor executor, Context context) {
        this.zzfvd = zzclc;
        this.zzffi = executor;
        this.zzlj = context;
    }

    public final void zzakw() {
        zzk.zzlk().zzvc().zzb(new zzcpg(this));
        this.zzffi.execute(new zzcph(this));
    }

    public final Map<String, List<zzcpk>> zzakx() {
        return this.zzgdh;
    }

    public final void zzfr(String str) {
        if (!TextUtils.isEmpty(str) && !this.zzgdg.containsKey(str)) {
            try {
                this.zzgdg.put(str, new zzcpk(str, "", new Bundle(), this.zzfvd.zzcy(str)));
            } catch (RemoteException unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzaky */
    public final synchronized void zzalb() {
        JSONArray optJSONArray;
        synchronized (this) {
            JSONObject zzuv = zzk.zzlk().zzvc().zzvr().zzuv();
            if (zzuv != null) {
                try {
                    JSONArray optJSONArray2 = zzuv.optJSONArray("ad_unit_id_settings");
                    if (optJSONArray2 != null) {
                        for (int i = 0; i < optJSONArray2.length(); i++) {
                            JSONObject jSONObject = optJSONArray2.getJSONObject(i);
                            String optString = jSONObject.optString("ad_unit_id", "");
                            String optString2 = jSONObject.optString("format", "");
                            ArrayList arrayList = new ArrayList();
                            JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                            if (!(optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("ad_networks")) == null)) {
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                    ArrayList arrayList2 = new ArrayList();
                                    if (jSONObject2 != null) {
                                        JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                                        Bundle bundle = new Bundle();
                                        if (optJSONObject2 != null) {
                                            Iterator<String> keys = optJSONObject2.keys();
                                            while (keys.hasNext()) {
                                                String next = keys.next();
                                                bundle.putString(next, optJSONObject2.optString(next, ""));
                                            }
                                        }
                                        JSONArray optJSONArray3 = jSONObject2.optJSONArray("rtb_adapters");
                                        if (optJSONArray3 != null) {
                                            ArrayList arrayList3 = new ArrayList();
                                            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                                String optString3 = optJSONArray3.optString(i3, "");
                                                if (!TextUtils.isEmpty(optString3)) {
                                                    arrayList3.add(optString3);
                                                }
                                            }
                                            ArrayList arrayList4 = arrayList3;
                                            int size = arrayList4.size();
                                            int i4 = 0;
                                            while (i4 < size) {
                                                Object obj = arrayList4.get(i4);
                                                i4++;
                                                String str = (String) obj;
                                                zzfr(str);
                                                zzcpk zzcpk = this.zzgdg.get(str);
                                                if (zzcpk != null) {
                                                    arrayList2.add(new zzcpk(str, optString2, bundle, zzcpk.zzgdj));
                                                }
                                            }
                                        }
                                    }
                                    arrayList.addAll(arrayList2);
                                }
                            }
                            if (!TextUtils.isEmpty(optString)) {
                                this.zzgdh.put(optString, arrayList);
                            }
                        }
                    }
                } catch (JSONException e) {
                    zzawz.zza("Malformed config loading JSON.", e);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzala() {
        this.zzffi.execute(new zzcpi(this));
    }
}
