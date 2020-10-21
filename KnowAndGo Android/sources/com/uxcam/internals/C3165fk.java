package com.uxcam.internals;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.GestureDetector;
import android.view.ScaleGestureDetector;
import androidx.annotation.NonNull;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.uxcam.internals.fk */
public final class C3165fk {

    /* renamed from: f */
    public static float f2260f;

    /* renamed from: g */
    public static int f2261g = 0;

    /* renamed from: h */
    public static int f2262h = 0;

    /* renamed from: i */
    public static String f2263i;

    /* renamed from: j */
    public static String f2264j = "";

    /* renamed from: k */
    private static String f2265k = C2923aa.class.getSimpleName();

    /* renamed from: l */
    private static volatile C3165fk f2266l = null;

    /* renamed from: a */
    public ArrayList f2267a = new ArrayList();

    /* renamed from: b */
    public C3166fl f2268b;

    /* renamed from: c */
    public ArrayList f2269c = new ArrayList();

    /* renamed from: d */
    public ArrayList f2270d = new ArrayList();

    /* renamed from: e */
    public JSONArray f2271e = new JSONArray();

    /* renamed from: m */
    private GestureDetector f2272m;

    /* renamed from: n */
    private ScaleGestureDetector f2273n;

    private C3165fk() {
    }

    /* renamed from: a */
    public static int m1969a(String str) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bArr = new byte[0];
        }
        return bArr.length;
    }

    /* renamed from: a */
    public static C3165fk m1970a() {
        if (f2266l == null) {
            synchronized (C2923aa.class) {
                if (f2266l == null) {
                    f2266l = new C3165fk();
                }
            }
        }
        return f2266l;
    }

    @NonNull
    /* renamed from: a */
    public static JSONArray m1971a(ArrayList arrayList, JSONArray jSONArray) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                JSONObject jSONObject = new JSONObject();
                C2948aj ajVar = (C2948aj) it.next();
                jSONObject.put("name", ajVar.f1276a);
                jSONObject.put("time", Float.valueOf(String.format(Locale.ENGLISH, "%.3f", new Object[]{Float.valueOf(ajVar.f1277b)})));
                jSONObject.put("screen", ajVar.f1278c);
                if (ajVar.f1280e) {
                    jSONObject.put("internal", true);
                }
                if (ajVar.f1279d != null) {
                    jSONObject.put("params", new JSONObject(ajVar.f1279d));
                }
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                new Object[1][0] = e.getMessage();
                C2970bc.m1237b();
            }
        }
        return jSONArray;
    }

    /* renamed from: b */
    private static boolean m1972b(String str) {
        return !C2952an.f1311N.isEmpty() ? C2952an.f1311N.contains(str) : !C2952an.f1312O.isEmpty() && !C2952an.f1312O.contains(str);
    }

    /* renamed from: c */
    private static boolean m1973c(String str) {
        for (String equals : C2952an.f1310M) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(8)
    /* renamed from: a */
    public final void mo38445a(Context context, String str, boolean z) {
        C2953ao aoVar;
        if (str == null || str.isEmpty()) {
            str = ((Activity) C3183fy.m2038b()).getClass().getSimpleName();
        }
        if (z || !m1973c(str)) {
            f2264j = str;
            boolean b = m1972b(str);
            if (!C2952an.f1311N.isEmpty() || !C2952an.f1312O.isEmpty()) {
                C3196gd.m2085b(b);
            }
            C3166fl flVar = m1970a().f2268b == null ? new C3166fl() : m1970a().f2268b;
            this.f2268b = flVar;
            GestureDetector gestureDetector = new GestureDetector(context, flVar);
            gestureDetector.setOnDoubleTapListener(flVar);
            this.f2272m = gestureDetector;
            this.f2273n = new ScaleGestureDetector(context, flVar);
            this.f2268b = flVar;
            ArrayList arrayList = this.f2267a;
            if (arrayList.isEmpty() || !str.equalsIgnoreCase(((C2953ao) arrayList.get(arrayList.size() - 1)).f1343a)) {
                C2953ao aoVar2 = new C2953ao();
                aoVar2.f1343a = str;
                aoVar2.f1348f = b && !C2952an.f1309L;
                aoVar2.f1347e = true;
                flVar.f2278d = str;
                float c = C3183fy.m2041c();
                if (arrayList.isEmpty()) {
                    c = 0.0f;
                }
                aoVar2.f1344b = c;
                if (m1970a().f2267a.size() > 0) {
                    C2953ao aoVar3 = m1970a().f2268b.f2277c;
                    aoVar3.f1346d = c - aoVar3.f1344b;
                }
                arrayList.add(aoVar2);
                aoVar = aoVar2;
            } else {
                aoVar = (C2953ao) arrayList.get(arrayList.size() - 1);
            }
            flVar.f2277c = aoVar;
            C3154fg.m1953a();
        }
    }

    /* renamed from: a */
    public final void mo38446a(String str, float f, Map map) {
        C2970bc.m1233a("rageClickDetector");
        StringBuilder sb = new StringBuilder("internal event: ");
        sb.append(f);
        sb.append(" params: ");
        sb.append(map);
        if (this.f2270d == null) {
            this.f2270d = new ArrayList();
        }
        C2948aj ajVar = new C2948aj(str, f, m1970a().mo38448c(), map);
        ajVar.f1280e = true;
        this.f2270d.add(ajVar);
    }

    /* renamed from: b */
    public final void mo38447b() {
        ArrayList arrayList = this.f2269c != null ? this.f2269c : null;
        C3165fk fkVar = new C3165fk();
        f2266l = fkVar;
        fkVar.f2269c = arrayList;
        this.f2267a = null;
    }

    /* renamed from: c */
    public final String mo38448c() {
        return (this.f2267a == null || this.f2267a.isEmpty()) ? "" : ((C2953ao) this.f2267a.get(this.f2267a.size() - 1)).f1343a;
    }

    /* renamed from: d */
    public final JSONArray mo38449d() {
        Iterator it = this.f2267a.iterator();
        JSONArray jSONArray = new JSONArray();
        int i = 1;
        boolean z = true;
        while (true) {
            float f = 0.0f;
            try {
                if (!it.hasNext()) {
                    break;
                }
                JSONObject jSONObject = new JSONObject();
                C2953ao aoVar = (C2953ao) it.next();
                Iterator it2 = aoVar.f1345c.iterator();
                JSONArray jSONArray2 = new JSONArray();
                if (z && aoVar.f1346d - f2260f < 0.0f) {
                    f2260f = 0.0f;
                }
                JSONObject jSONObject2 = new JSONObject();
                Locale locale = Locale.ENGLISH;
                Object[] objArr = new Object[i];
                objArr[0] = Float.valueOf(aoVar.f1344b);
                jSONObject2.put("va", Float.valueOf(String.format(locale, "%.3f", objArr)));
                jSONArray2.put(jSONObject2);
                JSONArray jSONArray3 = new JSONArray();
                C2949ak akVar = null;
                while (it2.hasNext()) {
                    C2949ak akVar2 = (C2949ak) it2.next();
                    JSONArray jSONArray4 = new JSONArray();
                    jSONArray4.put(akVar2.f1284d);
                    jSONArray4.put(akVar2.f1285e);
                    jSONArray4.put(akVar2.f1288h);
                    jSONArray4.put(akVar2.f1282b);
                    jSONArray4.put(akVar2.f1289i.booleanValue() ? 1 : 0);
                    akVar2.mo38046b(f2260f);
                    Locale locale2 = Locale.ENGLISH;
                    Object[] objArr2 = new Object[i];
                    objArr2[0] = Float.valueOf(akVar2.f1283c >= f ? akVar2.f1283c : 0.0f);
                    jSONArray4.put(Float.valueOf(String.format(locale2, "%.3f", objArr2)));
                    if (akVar != null && akVar.f1283c <= akVar2.f1283c) {
                        StringBuilder sb = new StringBuilder("No TIMELINE ERROR. ");
                        sb.append(akVar.f1283c);
                        sb.append("<=");
                        sb.append(akVar2.f1283c);
                    }
                    JSONArray jSONArray5 = new JSONArray();
                    Iterator it3 = akVar2.f1293m.iterator();
                    while (it3.hasNext()) {
                        C2949ak akVar3 = (C2949ak) it3.next();
                        JSONArray jSONArray6 = new JSONArray();
                        jSONArray6.put(akVar3.f1282b);
                        jSONArray6.put(Float.valueOf(String.format(Locale.ENGLISH, "%.3f", new Object[]{Float.valueOf(akVar3.f1283c)})));
                        jSONArray6.put(akVar3.f1284d);
                        jSONArray6.put(akVar3.f1285e);
                        jSONArray5.put(jSONArray6);
                        it2 = it2;
                    }
                    Iterator it4 = it2;
                    if (akVar2.f1283c > 0.0f || akVar2.f1282b == 10) {
                        jSONArray4.put(jSONArray5);
                        jSONArray3.put(jSONArray4);
                    }
                    jSONArray4.put(akVar2.f1291k ? 1 : 0);
                    jSONArray4.put(akVar2.f1292l != null ? akVar2.f1292l.mo38435a() : new JSONObject());
                    akVar = akVar2;
                    it2 = it4;
                    i = 1;
                    f = 0.0f;
                }
                jSONObject.put("cor", jSONArray3);
                float f2 = aoVar.f1344b - f2260f;
                Locale locale3 = Locale.ENGLISH;
                Object[] objArr3 = new Object[1];
                if (f2 < 0.0f) {
                    f2 = 0.0f;
                }
                objArr3[0] = Float.valueOf(f2);
                jSONObject.put("at", Float.valueOf(String.format(locale3, "%.3f", objArr3)));
                float f3 = aoVar.f1346d;
                if (z) {
                    f3 -= f2260f;
                }
                if (!it.hasNext()) {
                    f3 += f2260f;
                }
                if (z) {
                    z = false;
                }
                jSONObject.put("vt", Float.valueOf(String.format(Locale.ENGLISH, "%.3f", new Object[]{Float.valueOf(f3)})));
                jSONObject.put("an", aoVar.f1343a);
                jSONArray.put(jSONObject);
                i = 1;
            } catch (JSONException e) {
                C2970bc.m1233a(f2265k);
                e.getMessage();
            }
        }
        f2260f = 0.0f;
        return jSONArray;
    }

    /* renamed from: e */
    public final int mo38450e() {
        Iterator it = this.f2267a.iterator();
        int i = 0;
        while (it.hasNext()) {
            Iterator it2 = ((C2953ao) it.next()).f1345c.iterator();
            while (it2.hasNext()) {
                C2949ak akVar = (C2949ak) it2.next();
                if (!(akVar.f1282b == 10 || akVar.f1282b == 3 || akVar.f1282b == 4 || akVar.f1282b == 5 || akVar.f1282b == 2)) {
                    i++;
                }
            }
        }
        return i;
    }

    /* renamed from: f */
    public final Set mo38451f() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f2267a.iterator();
        while (it.hasNext()) {
            hashSet.add(new C2961av(((C2953ao) it.next()).f1343a));
        }
        return hashSet;
    }
}
