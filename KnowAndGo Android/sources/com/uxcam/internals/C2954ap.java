package com.uxcam.internals;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.uxcam.internals.ap */
public final class C2954ap {

    /* renamed from: d */
    private static String f1350d = "kUXCam_UserIdentity";

    /* renamed from: a */
    public String f1351a;

    /* renamed from: b */
    public Map f1352b = new HashMap();

    /* renamed from: c */
    public C2954ap f1353c;

    public C2954ap() {
    }

    public C2954ap(String str) {
        this.f1351a = str;
    }

    /* renamed from: a */
    public final JSONObject mo38050a() {
        JSONObject jSONObject = new JSONObject(this.f1352b);
        try {
            if (this.f1351a != null && !this.f1351a.isEmpty()) {
                jSONObject.put(f1350d, this.f1351a);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: a */
    public final void mo38051a(String str, Object obj) {
        this.f1352b.put(str, obj);
    }
}
