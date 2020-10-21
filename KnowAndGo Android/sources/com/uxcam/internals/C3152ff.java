package com.uxcam.internals;

import android.graphics.Rect;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.uxcam.internals.ff */
public final class C3152ff {

    /* renamed from: a */
    public C3181fw f2203a;

    /* renamed from: b */
    private int f2204b;

    /* renamed from: c */
    private Rect f2205c;

    /* renamed from: d */
    private int f2206d;

    /* renamed from: e */
    private String f2207e;

    /* renamed from: f */
    private String f2208f;

    /* renamed from: g */
    private String f2209g;

    /* renamed from: h */
    private float f2210h;

    /* renamed from: i */
    private int f2211i;

    /* renamed from: j */
    private String f2212j;

    /* renamed from: k */
    private ArrayList f2213k;

    /* renamed from: l */
    private C3152ff f2214l;

    /* renamed from: m */
    private String f2215m;

    /* renamed from: n */
    private JSONArray f2216n;

    /* renamed from: com.uxcam.internals.ff$aa */
    public static class C3153aa {

        /* renamed from: a */
        public int f2217a;

        /* renamed from: b */
        public int f2218b;

        /* renamed from: c */
        public String f2219c;

        /* renamed from: d */
        public Rect f2220d;

        /* renamed from: e */
        String f2221e;

        /* renamed from: f */
        public String f2222f;

        /* renamed from: g */
        public float f2223g;

        /* renamed from: h */
        public int f2224h;

        /* renamed from: i */
        public String f2225i;

        /* renamed from: j */
        public C3181fw f2226j;

        /* renamed from: k */
        public ArrayList f2227k;

        /* renamed from: l */
        C3152ff f2228l;

        /* renamed from: m */
        public String f2229m = "";

        /* renamed from: n */
        public JSONArray f2230n = new JSONArray();

        /* renamed from: a */
        public final C3153aa mo38436a(String str) {
            if (str.length() >= 128) {
                str = str.substring(0, 128).concat("...");
            }
            this.f2221e = str;
            return this;
        }
    }

    private C3152ff(C3153aa aaVar) {
        this.f2216n = new JSONArray();
        this.f2204b = aaVar.f2217a;
        this.f2205c = aaVar.f2220d;
        this.f2206d = aaVar.f2218b;
        this.f2207e = aaVar.f2219c;
        this.f2208f = aaVar.f2221e;
        this.f2209g = aaVar.f2222f;
        this.f2210h = aaVar.f2223g;
        this.f2211i = aaVar.f2224h;
        this.f2212j = aaVar.f2225i;
        this.f2203a = aaVar.f2226j;
        this.f2213k = aaVar.f2227k;
        this.f2214l = aaVar.f2228l;
        this.f2215m = aaVar.f2229m;
        this.f2216n = aaVar.f2230n;
    }

    public /* synthetic */ C3152ff(C3153aa aaVar, byte b) {
        this(aaVar);
    }

    /* renamed from: a */
    public final JSONObject mo38435a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vt", this.f2204b);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.f2205c.left);
            jSONArray.put(this.f2205c.top);
            jSONArray.put(this.f2205c.width());
            jSONArray.put(this.f2205c.height());
            jSONObject.put("rec", jSONArray);
            if (this.f2206d > 0) {
                jSONObject.put("i", this.f2206d);
            }
            if (this.f2207e != null && !this.f2207e.isEmpty()) {
                jSONObject.put("is", this.f2207e);
            }
            jSONObject.putOpt(NotificationBundleProcessor.PUSH_MINIFIED_BUTTON_TEXT, this.f2208f);
            jSONObject.put("v", this.f2209g);
            jSONObject.put("p", this.f2211i);
            jSONObject.put("c", this.f2212j);
            jSONObject.put("isViewGroup", this.f2203a.f2310l);
            jSONObject.put("isEnabled", this.f2203a.f2305g);
            jSONObject.put("isClickable", this.f2203a.f2304f);
            jSONObject.put("hasOnClickListeners", this.f2203a.f2312n);
            jSONObject.put("isScrollable", this.f2203a.mo38479a());
            jSONObject.put("isScrollContainer", this.f2203a.f2311m);
            jSONObject.put("detectorType", this.f2215m);
            jSONObject.put("parentClasses", this.f2216n);
            jSONObject.put("parentClassesCount", this.f2216n.length());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
