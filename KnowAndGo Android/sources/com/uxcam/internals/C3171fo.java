package com.uxcam.internals;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.uxcam.internals.fo */
public final class C3171fo {
    /* renamed from: a */
    public static String m1997a(Context context) {
        return context.getSharedPreferences("uxcamDebug", 0).getString("events", "[]");
    }

    /* renamed from: a */
    public static void m1998a(Context context, String str, Map map) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("uxcamDebug", 0);
        if (sharedPreferences.getBoolean("debug", true)) {
            try {
                JSONArray jSONArray = new JSONArray(sharedPreferences.getString("events", "[]"));
                if (jSONArray.length() <= 500) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("tag", str);
                    jSONObject.put("time", System.currentTimeMillis());
                    jSONObject.put("appDeviceId", C2952an.f1318b);
                    jSONObject.put("params", new JSONObject(map));
                    jSONArray.put(jSONObject);
                    new StringBuilder("DebugPreference, ").append(jSONObject.toString());
                    sharedPreferences.edit().putString("events", jSONArray.toString()).apply();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public static void m1999b(Context context) {
        context.getSharedPreferences("uxcamDebug", 0).edit().putString("events", "[]").apply();
    }

    /* renamed from: c */
    public static void m2000c(Context context) {
        context.getSharedPreferences("uxcamDebug", 0).edit().putBoolean("debug", true).apply();
    }
}
