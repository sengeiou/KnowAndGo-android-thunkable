package com.uxcam.internals;

import android.util.Pair;
import com.onesignal.OneSignalDbContract;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.uxcam.internals.ai */
public class C2947ai implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static final String f1274a = "ai";

    /* renamed from: b */
    private Thread.UncaughtExceptionHandler f1275b;

    public C2947ai(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f1275b = uncaughtExceptionHandler;
    }

    /* renamed from: a */
    public static Pair m1175a(String str, boolean z) {
        JSONArray jSONArray = new JSONArray();
        String str2 = "";
        Iterator<Map.Entry<Thread, StackTraceElement[]>> it = Thread.getAllStackTraces().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry next = it.next();
            try {
                boolean equals = ((Thread) next.getKey()).getName().equals(str);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_TITLE, ((Thread) next.getKey()).getName());
                jSONObject.put("state", ((Thread) next.getKey()).getState());
                JSONArray jSONArray2 = new JSONArray();
                for (StackTraceElement stackTraceElement : (StackTraceElement[]) next.getValue()) {
                    if (equals && str2.isEmpty()) {
                        str2 = stackTraceElement.toString();
                    }
                    jSONArray2.put(stackTraceElement.toString());
                }
                jSONObject.put("backtrace", jSONArray2);
                if (equals && z) {
                    jSONArray = new JSONArray().put(jSONObject);
                    break;
                }
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return new Pair(jSONArray, str2);
    }

    /* renamed from: a */
    private static JSONObject m1176a(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("UnhandledExceptionName", th.getClass().getName());
            jSONObject.put("UnhandledExceptionReason", th.getMessage());
            JSONArray jSONArray = new JSONArray();
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                jSONArray.put(stackTrace[i].toString());
                i2++;
                if (i2 > 100) {
                    jSONArray.put("---BACKTRACE STOPPED AT 100 ENTRIES---");
                    break;
                }
                i++;
            }
            jSONObject.put("UnhandledExceptionCallStack", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        C2970bc.m1233a(f1274a);
        String str = "";
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(m1176a(th));
        if (th.getStackTrace()[0] != null) {
            str = th.getStackTrace()[0].toString();
        }
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            jSONArray.put(m1176a(cause));
            if (str.isEmpty() && cause.getStackTrace()[0] != null) {
                str = cause.getStackTrace()[0].toString();
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crashedThread", ((JSONArray) m1175a(thread.getName(), true).first).getJSONObject(0));
            jSONObject.put("crashExceptions", jSONArray);
            jSONObject.put("screen", C3165fk.m1970a().mo38448c());
            jSONObject.put("threads", m1175a(thread.getName(), false).first);
            jSONObject.put("crashedThread-TopOfStack", str);
            jSONObject.put("time", (double) C3183fy.m2041c());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("exception", th);
            C3171fo.m1998a(C3183fy.m2030a(), "UnCaughtExceptionHandled", hashMap);
        } catch (Exception unused) {
        }
        C2923aa.m1096a().mo37983a(C3183fy.m2030a(), jSONObject.toString());
        this.f1275b.uncaughtException(thread, th);
    }
}
