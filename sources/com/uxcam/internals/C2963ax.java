package com.uxcam.internals;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.uxcam.internals.ax */
public final class C2963ax {

    /* renamed from: a */
    public ArrayList f1373a = new ArrayList();

    /* renamed from: b */
    private List f1374b = new ArrayList();

    /* renamed from: c */
    private List f1375c = new ArrayList();

    /* renamed from: d */
    private ArrayList f1376d = new ArrayList();

    /* renamed from: e */
    private boolean f1377e;

    /* renamed from: f */
    private int f1378f;

    /* renamed from: g */
    private int f1379g;

    public C2963ax(@NonNull List list, JSONArray jSONArray, boolean z, int i, int i2) {
        List list2;
        this.f1377e = z;
        this.f1378f = i;
        this.f1379g = i2;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C2962aw awVar = (C2962aw) it.next();
            C2970bc.m1233a("filter11");
            StringBuilder sb = new StringBuilder("Comparable : ");
            sb.append(awVar.mo38041b());
            sb.append(" type : ");
            sb.append(awVar.mo38040a());
            if (awVar.mo38040a() == 1) {
                list2 = this.f1374b;
            } else if (awVar.mo38040a() == 2) {
                list2 = this.f1375c;
            }
            list2.add(awVar);
        }
        int i3 = 0;
        while (i3 < jSONArray.length()) {
            try {
                this.f1376d.add(jSONArray.getJSONObject(i3));
                i3++;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    /* renamed from: a */
    private boolean m1215a(String str, int i) {
        Iterator it = this.f1376d.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                return true;
            }
            JSONObject jSONObject = (JSONObject) it.next();
            if (jSONObject.getString("attribute").equalsIgnoreCase(str)) {
                String string = jSONObject.getString("operator");
                JSONArray jSONArray = jSONObject.getJSONArray("value");
                if ((!string.equalsIgnoreCase("is") || i != jSONArray.getInt(0)) && ((!string.equalsIgnoreCase("isNot") || i == jSONArray.getInt(0)) && ((!string.equalsIgnoreCase("gt") || i <= jSONArray.getInt(0)) && ((!string.equalsIgnoreCase("gteq") || i < jSONArray.getInt(0)) && ((!string.equalsIgnoreCase("lt") || i >= jSONArray.getInt(0)) && ((!string.equalsIgnoreCase("lteq") || i > jSONArray.getInt(0)) && (!string.equalsIgnoreCase("gt&lt") || i <= jSONArray.getInt(0) || i >= jSONArray.getInt(1)))))))) {
                    z = false;
                }
                if (!z) {
                    return false;
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m1216a(String str, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(((C2962aw) it.next()).mo38041b())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private boolean m1217b() {
        boolean z;
        if (this.f1374b.isEmpty()) {
            return true;
        }
        Iterator it = this.f1376d.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) it.next();
            if (jSONObject.getString("attribute").equalsIgnoreCase("screen")) {
                String string = jSONObject.getString("operator");
                JSONArray jSONArray = jSONObject.getJSONArray("value");
                if (string.equalsIgnoreCase("is")) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (m1216a(jSONArray.getString(i), this.f1374b)) {
                            return true;
                        }
                    }
                    return false;
                } else if (string.equalsIgnoreCase("isNot")) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jSONArray.length()) {
                            z = false;
                            break;
                        } else if (!m1218b(jSONArray.getString(i2), this.f1374b)) {
                            z = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    return !z;
                } else {
                    z2 = true;
                }
            }
        }
        return !z2;
    }

    /* renamed from: b */
    private static boolean m1218b(String str, List list) {
        Iterator it = list.iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(((C2962aw) it.next()).mo38041b())) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: c */
    private boolean m1219c() {
        boolean z;
        Iterator it = this.f1376d.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) it.next();
            if (jSONObject.getString("attribute").equalsIgnoreCase(NotificationCompat.CATEGORY_EVENT)) {
                String string = jSONObject.getString("operator");
                JSONArray jSONArray = jSONObject.getJSONArray("value");
                if (string.equalsIgnoreCase("is")) {
                    if (this.f1375c.isEmpty()) {
                        return false;
                    }
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (m1216a(jSONArray.getString(i), this.f1375c)) {
                            return true;
                        }
                    }
                    return false;
                } else if (string.equalsIgnoreCase("isNot")) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jSONArray.length()) {
                            z = false;
                            break;
                        } else if (!m1218b(jSONArray.getString(i2), this.f1375c)) {
                            z = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    return !z;
                } else {
                    z2 = true;
                }
            }
        }
        return !z2;
    }

    /* renamed from: d */
    private boolean m1220d() {
        Iterator it = this.f1376d.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                return true;
            }
            JSONObject jSONObject = (JSONObject) it.next();
            if (jSONObject.getString("attribute").equalsIgnoreCase("isCrashed")) {
                String string = jSONObject.getString("operator");
                JSONArray jSONArray = jSONObject.getJSONArray("value");
                if ((!string.equalsIgnoreCase("is") || this.f1377e != jSONArray.getBoolean(0)) && (!string.equalsIgnoreCase("isNot") || this.f1377e != jSONArray.getBoolean(0))) {
                    z = false;
                }
                if (!z) {
                    return false;
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean mo38060a() {
        boolean z = true;
        try {
            if (!m1215a("noOfInteraction", this.f1379g)) {
                this.f1373a.add(1);
                C2970bc.m1233a("filter11");
                StringBuilder sb = new StringBuilder("No. of interaction is:");
                sb.append(this.f1379g);
                sb.append(" checkNumberOfInteraction : false");
                z = false;
            }
            try {
                if (!m1215a("duration", this.f1378f)) {
                    this.f1373a.add(2);
                    C2970bc.m1233a("filter11");
                    StringBuilder sb2 = new StringBuilder("session length is:");
                    sb2.append(this.f1378f);
                    sb2.append("checkSessionLength: false");
                    z = false;
                }
                if (!m1220d()) {
                    this.f1373a.add(3);
                    C2970bc.m1233a("filter11");
                    StringBuilder sb3 = new StringBuilder("crash status is:");
                    sb3.append(this.f1377e);
                    sb3.append("checkCrashed: false");
                    z = false;
                }
                if (!m1219c()) {
                    this.f1373a.add(4);
                    C2970bc.m1233a("filter11");
                    z = false;
                }
                if (!m1217b()) {
                    this.f1373a.add(5);
                    C2970bc.m1233a("filter11");
                    return false;
                }
                C2970bc.m1233a("filter11");
                return z;
            } catch (JSONException unused) {
            }
        } catch (JSONException unused2) {
            return true;
        }
    }
}
