package com.uxcam.internals;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.amplitude.api.Constants;
import com.uxcam.internals.C2997bt;
import com.uxcam.internals.C3011ca;
import com.uxcam.internals.C3017cd;
import expo.modules.updates.UpdatesConfiguration;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.uxcam.internals.fz */
public class C3184fz {

    /* renamed from: a */
    public static String f2321a = "fz";

    /* renamed from: b */
    public Context f2322b;

    /* renamed from: c */
    private JSONObject f2323c;

    public C3184fz(Context context) {
        this.f2322b = context;
        String b = C3172fp.m2003b(this.f2322b);
        String c = C3183fy.m2042c(this.f2322b);
        String d = C3172fp.m2005d(this.f2322b);
        String str = (String) C3183fy.m2045d(this.f2322b).first;
        String str2 = Build.VERSION.RELEASE;
        String str3 = Build.MODEL;
        int i = new C3175fs(this.f2322b).f2294a.getInt("recorded_session_count", 0);
        int i2 = new C3175fs(this.f2322b).f2294a.getInt("recorded_video_count", 0);
        try {
            this.f2323c = new JSONObject();
            this.f2323c.putOpt("buildIdentifier", c);
            this.f2323c.putOpt("deviceId", b);
            this.f2323c.putOpt("osVersion", str2);
            this.f2323c.putOpt(Constants.AMP_TRACKING_OPTION_PLATFORM, C3182fx.f2314b);
            this.f2323c.putOpt("deviceType", d);
            this.f2323c.putOpt("deviceModelName", str3);
            this.f2323c.putOpt("appVersion", str);
            this.f2323c.putOpt(UpdatesConfiguration.UPDATES_CONFIGURATION_SDK_VERSION_KEY, "3.3.0");
            this.f2323c.putOpt("sdkVersionNumber", "501");
            this.f2323c.putOpt("sessionsRecordedOnDevice", Integer.valueOf(i));
            this.f2323c.putOpt("videosRecordedOnDevice", Integer.valueOf(i2));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m2060a(C2997bt.C2998aa aaVar) {
        Iterator<String> keys = this.f2323c.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            aaVar.mo38107a(next, this.f2323c.getString(next));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x02f1 A[Catch:{ Exception -> 0x02fc }, LOOP:0: B:71:0x02eb->B:73:0x02f1, LOOP_END] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m2063a(com.uxcam.internals.C3184fz r7, org.json.JSONObject r8, boolean r9) {
        /*
            com.uxcam.internals.ab r0 = com.uxcam.internals.C2928ab.m1105a()
            r1 = 0
            r0.f1232e = r1
            com.uxcam.internals.ab r0 = com.uxcam.internals.C2928ab.m1105a()
            int r0 = r0.f1231d
            r2 = 2
            if (r0 == r2) goto L_0x0311
            java.lang.String r0 = f2321a
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Verification success with app key "
            r0.<init>(r3)
            java.lang.String r3 = com.uxcam.internals.C2928ab.f1215a
            r0.append(r3)
            java.lang.String r0 = f2321a
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "settings received is : "
            r0.<init>(r3)
            java.lang.String r3 = r8.toString()
            r0.append(r3)
            r0 = 1
            java.lang.String r3 = "status"
            boolean r3 = r8.optBoolean(r3, r0)     // Catch:{ Exception -> 0x02fc }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x02fc }
            r4.<init>()     // Catch:{ Exception -> 0x02fc }
            java.lang.String r5 = "verificationStatus"
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x02fc }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x02fc }
            android.content.Context r5 = r7.f2322b     // Catch:{ Exception -> 0x02fc }
            java.lang.String r6 = "verificationSuccess"
            com.uxcam.internals.C3171fo.m1998a(r5, r6, r4)     // Catch:{ Exception -> 0x02fc }
            java.lang.String r4 = "cancelInternalLogs"
            boolean r4 = r8.has(r4)     // Catch:{ Exception -> 0x02fc }
            if (r4 == 0) goto L_0x00af
            java.lang.String r4 = "cancelInternalLogs"
            boolean r4 = r8.optBoolean(r4)     // Catch:{ Exception -> 0x02fc }
            if (r4 == 0) goto L_0x0090
            android.content.Context r5 = r7.f2322b     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C3171fo.m1999b(r5)     // Catch:{ Exception -> 0x02fc }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x02fc }
            r5.<init>()     // Catch:{ Exception -> 0x02fc }
            java.lang.String r6 = "cancelInternalLogs"
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x02fc }
            r5.put(r6, r4)     // Catch:{ Exception -> 0x02fc }
            android.content.Context r4 = r7.f2322b     // Catch:{ Exception -> 0x02fc }
            java.lang.String r6 = "enableOrDisableInternalLogs"
            com.uxcam.internals.C3171fo.m1998a(r4, r6, r5)     // Catch:{ Exception -> 0x02fc }
            android.content.Context r4 = r7.f2322b     // Catch:{ Exception -> 0x02fc }
            java.lang.String r5 = "uxcamDebug"
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r5, r1)     // Catch:{ Exception -> 0x02fc }
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ Exception -> 0x02fc }
            java.lang.String r5 = "debug"
            android.content.SharedPreferences$Editor r4 = r4.putBoolean(r5, r1)     // Catch:{ Exception -> 0x02fc }
            r4.apply()     // Catch:{ Exception -> 0x02fc }
            goto L_0x00af
        L_0x0090:
            android.content.Context r5 = r7.f2322b     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C3171fo.m2000c(r5)     // Catch:{ Exception -> 0x02fc }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x02fc }
            r5.<init>()     // Catch:{ Exception -> 0x02fc }
            java.lang.String r6 = "cancelInternalLogs"
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x02fc }
            r5.put(r6, r4)     // Catch:{ Exception -> 0x02fc }
            android.content.Context r4 = r7.f2322b     // Catch:{ Exception -> 0x02fc }
            java.lang.String r6 = "enableOrDisableInternalLogs"
            com.uxcam.internals.C3171fo.m1998a(r4, r6, r5)     // Catch:{ Exception -> 0x02fc }
            android.content.Context r4 = r7.f2322b     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C3171fo.m2000c(r4)     // Catch:{ Exception -> 0x02fc }
        L_0x00af:
            if (r3 == 0) goto L_0x02a6
            java.util.UUID r4 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x02fc }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1318b = r4     // Catch:{ Exception -> 0x02fc }
            if (r9 != 0) goto L_0x00d8
            java.lang.String r4 = "data"
            org.json.JSONObject r4 = r8.optJSONObject(r4)     // Catch:{ Exception -> 0x02fc }
            java.lang.String r5 = "sessionId"
            java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x02fc }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x02fc }
            java.lang.String r6 = com.uxcam.internals.C2958as.m1196a()     // Catch:{ Exception -> 0x02fc }
            r5.<init>(r6)     // Catch:{ Exception -> 0x02fc }
            r7.m2064a((java.io.File) r5, (java.lang.String) r4)     // Catch:{ Exception -> 0x02fc }
            r7.m2065a((java.lang.String) r4)     // Catch:{ Exception -> 0x02fc }
        L_0x00d8:
            com.uxcam.internals.aq r4 = new com.uxcam.internals.aq     // Catch:{ Exception -> 0x02fc }
            r4.<init>()     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2955aq.m1188a(r3)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1305H = r9     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.fi r9 = new com.uxcam.internals.fi     // Catch:{ Exception -> 0x02fc }
            android.content.Context r7 = r7.f2322b     // Catch:{ Exception -> 0x02fc }
            r9.<init>(r8, r7)     // Catch:{ Exception -> 0x02fc }
            org.json.JSONObject r7 = r9.f2249a     // Catch:{ Exception -> 0x02fc }
            java.lang.String r8 = "settings"
            org.json.JSONObject r7 = r7.optJSONObject(r8)     // Catch:{ Exception -> 0x02fc }
            if (r7 != 0) goto L_0x00f8
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x02fc }
            r7.<init>()     // Catch:{ Exception -> 0x02fc }
        L_0x00f8:
            com.uxcam.internals.fs r8 = new com.uxcam.internals.fs     // Catch:{ Exception -> 0x02fc }
            android.content.Context r3 = r9.f2250b     // Catch:{ Exception -> 0x02fc }
            r8.<init>(r3)     // Catch:{ Exception -> 0x02fc }
            boolean r3 = r8.mo38471c()     // Catch:{ Exception -> 0x02fc }
            r3 = r3 ^ r0
            org.json.JSONObject r4 = r9.f2249a     // Catch:{ Exception -> 0x02fc }
            java.lang.String r5 = "videoRecording"
            boolean r4 = r4.optBoolean(r5, r0)     // Catch:{ Exception -> 0x02fc }
            if (r4 == 0) goto L_0x0112
            if (r3 != 0) goto L_0x0112
            com.uxcam.internals.C2956ar.f1357c = r0     // Catch:{ Exception -> 0x02fc }
        L_0x0112:
            if (r3 == 0) goto L_0x0118
            if (r4 == 0) goto L_0x0118
            r3 = 1
            goto L_0x0119
        L_0x0118:
            r3 = 0
        L_0x0119:
            com.uxcam.internals.C2952an.f1323g = r3     // Catch:{ Exception -> 0x02fc }
            java.lang.String r3 = "subscriptionSessionLimitReached"
            boolean r3 = r7.optBoolean(r3, r1)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1301D = r3     // Catch:{ Exception -> 0x02fc }
            java.lang.String r3 = "screenAction"
            boolean r3 = r7.optBoolean(r3, r0)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1306I = r3     // Catch:{ Exception -> 0x02fc }
            java.lang.String r3 = "encrypt"
            boolean r3 = r7.optBoolean(r3, r0)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1307J = r3     // Catch:{ Exception -> 0x02fc }
            boolean r3 = com.uxcam.internals.C2952an.f1339w     // Catch:{ Exception -> 0x02fc }
            if (r3 != 0) goto L_0x013f
            java.lang.String r3 = "occludeAllTextFields"
            boolean r3 = r7.optBoolean(r3, r1)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1340x = r3     // Catch:{ Exception -> 0x02fc }
        L_0x013f:
            org.json.JSONObject r3 = r9.f2249a     // Catch:{ Exception -> 0x02fc }
            java.lang.String r4 = "stopRecording"
            boolean r3 = r3.optBoolean(r4)     // Catch:{ Exception -> 0x02fc }
            if (r3 == 0) goto L_0x015c
            java.lang.String r3 = "killed_app_key"
            java.lang.String r4 = com.uxcam.internals.C2928ab.f1215a     // Catch:{ Exception -> 0x02fc }
            r8.mo38466a((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x02fc }
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x02fc }
            java.lang.String r3 = com.uxcam.internals.C2958as.m1199b()     // Catch:{ Exception -> 0x02fc }
            r8.<init>(r3)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C3183fy.m2035a((java.io.File) r8)     // Catch:{ Exception -> 0x02fc }
        L_0x015c:
            java.lang.String r8 = "rage"
            org.json.JSONArray r8 = r7.optJSONArray(r8)     // Catch:{ Exception -> 0x02fc }
            r3 = 3
            if (r8 == 0) goto L_0x017b
            int[] r4 = new int[r3]     // Catch:{ Exception -> 0x02fc }
            int r5 = r8.optInt(r1)     // Catch:{ Exception -> 0x02fc }
            r4[r1] = r5     // Catch:{ Exception -> 0x02fc }
            int r5 = r8.optInt(r0)     // Catch:{ Exception -> 0x02fc }
            r4[r0] = r5     // Catch:{ Exception -> 0x02fc }
            int r8 = r8.optInt(r2)     // Catch:{ Exception -> 0x02fc }
            r4[r2] = r8     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1302E = r4     // Catch:{ Exception -> 0x02fc }
        L_0x017b:
            java.lang.String r8 = "eventLimit"
            org.json.JSONArray r8 = r7.optJSONArray(r8)     // Catch:{ Exception -> 0x02fc }
            if (r8 == 0) goto L_0x0199
            int[] r3 = new int[r3]     // Catch:{ Exception -> 0x02fc }
            int r4 = r8.optInt(r1)     // Catch:{ Exception -> 0x02fc }
            r3[r1] = r4     // Catch:{ Exception -> 0x02fc }
            int r4 = r8.optInt(r0)     // Catch:{ Exception -> 0x02fc }
            r3[r0] = r4     // Catch:{ Exception -> 0x02fc }
            int r8 = r8.optInt(r2)     // Catch:{ Exception -> 0x02fc }
            r3[r2] = r8     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1304G = r3     // Catch:{ Exception -> 0x02fc }
        L_0x0199:
            java.lang.String r8 = "anr"
            org.json.JSONArray r8 = r7.optJSONArray(r8)     // Catch:{ Exception -> 0x02fc }
            if (r8 == 0) goto L_0x01b1
            int[] r3 = new int[r2]     // Catch:{ Exception -> 0x02fc }
            int r4 = r8.optInt(r1)     // Catch:{ Exception -> 0x02fc }
            r3[r1] = r4     // Catch:{ Exception -> 0x02fc }
            int r8 = r8.optInt(r0)     // Catch:{ Exception -> 0x02fc }
            r3[r0] = r8     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1303F = r3     // Catch:{ Exception -> 0x02fc }
        L_0x01b1:
            org.json.JSONObject r8 = r9.f2249a     // Catch:{ Exception -> 0x02fc }
            java.lang.String r3 = "domain"
            java.lang.String r8 = r8.optString(r3)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1330n = r8     // Catch:{ Exception -> 0x02fc }
            org.json.JSONObject r8 = r9.f2249a     // Catch:{ Exception -> 0x02fc }
            java.lang.String r3 = "deviceUrl"
            java.lang.String r8 = r8.optString(r3)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1328l = r8     // Catch:{ Exception -> 0x02fc }
            org.json.JSONObject r8 = r9.f2249a     // Catch:{ Exception -> 0x02fc }
            java.lang.String r3 = "sessionUrl"
            java.lang.String r8 = r8.optString(r3)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1329m = r8     // Catch:{ Exception -> 0x02fc }
            org.json.JSONObject r8 = r9.f2249a     // Catch:{ Exception -> 0x02fc }
            java.lang.String r3 = "misc"
            java.lang.String r8 = r8.optString(r3)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1331o = r8     // Catch:{ Exception -> 0x02fc }
            org.json.JSONObject r8 = r9.f2249a     // Catch:{ Exception -> 0x02fc }
            java.lang.String r3 = "appIcon"
            boolean r8 = r8.optBoolean(r3, r1)     // Catch:{ Exception -> 0x02fc }
            r8 = r8 ^ r0
            com.uxcam.internals.C2952an.f1322f = r8     // Catch:{ Exception -> 0x02fc }
            org.json.JSONObject r8 = r9.f2249a     // Catch:{ Exception -> 0x02fc }
            java.lang.String r3 = "s3"
            org.json.JSONObject r8 = r8.optJSONObject(r3)     // Catch:{ Exception -> 0x02fc }
            if (r8 != 0) goto L_0x01f3
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x02fc }
            r8.<init>()     // Catch:{ Exception -> 0x02fc }
        L_0x01f3:
            com.uxcam.internals.C2952an.f1327k = r8     // Catch:{ Exception -> 0x02fc }
            java.lang.String r8 = "filtersDataSession"
            org.json.JSONArray r8 = r7.optJSONArray(r8)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1341y = r8     // Catch:{ Exception -> 0x02fc }
            java.lang.String r8 = "filters"
            org.json.JSONArray r8 = r7.optJSONArray(r8)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1342z = r8     // Catch:{ Exception -> 0x02fc }
            java.lang.String r8 = "url"
            java.lang.String r8 = r7.optString(r8)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1319c = r8     // Catch:{ Exception -> 0x02fc }
            java.lang.String r8 = "videoQuality"
            int r8 = r7.optInt(r8, r2)     // Catch:{ Exception -> 0x02fc }
            boolean r3 = com.uxcam.internals.C3196gd.m2090f()     // Catch:{ Exception -> 0x02fc }
            int r4 = com.uxcam.internals.C2952an.f1299B     // Catch:{ Exception -> 0x02fc }
            if (r4 <= 0) goto L_0x0225
            int r8 = com.uxcam.internals.C2952an.f1299B     // Catch:{ Exception -> 0x02fc }
            double r3 = (double) r8     // Catch:{ Exception -> 0x02fc }
            int r8 = com.uxcam.internals.C2952an.f1298A     // Catch:{ Exception -> 0x02fc }
            r5 = 4
            r9.mo38439a(r3, r8, r5)     // Catch:{ Exception -> 0x02fc }
            goto L_0x0228
        L_0x0225:
            r9.mo38440a((int) r8, (boolean) r3)     // Catch:{ Exception -> 0x02fc }
        L_0x0228:
            java.lang.String r8 = "uploadNetwork"
            int r8 = r7.optInt(r8, r0)     // Catch:{ Exception -> 0x02fc }
            if (r8 != r2) goto L_0x0239
            java.lang.String r8 = "mobileDataLimit"
            int r8 = r7.optInt(r8, r1)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1325i = r8     // Catch:{ Exception -> 0x02fc }
            goto L_0x023b
        L_0x0239:
            com.uxcam.internals.C2952an.f1325i = r1     // Catch:{ Exception -> 0x02fc }
        L_0x023b:
            java.lang.String r8 = "mobileDataDataOnly"
            boolean r8 = r7.optBoolean(r8, r1)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1326j = r8     // Catch:{ Exception -> 0x02fc }
            java.lang.String r8 = "activitiesToIgnore"
            org.json.JSONArray r8 = r7.optJSONArray(r8)     // Catch:{ Exception -> 0x02fc }
            java.lang.String r2 = "recordGestureForOccludedScreen"
            boolean r2 = r7.optBoolean(r2, r1)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1309L = r2     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.fi$1 r2 = new com.uxcam.internals.fi$1     // Catch:{ Exception -> 0x02fc }
            r2.<init>()     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C3158fi.m1958a((org.json.JSONArray) r8, (com.uxcam.internals.C3158fi.C3162aa) r2)     // Catch:{ Exception -> 0x02fc }
            java.lang.String r8 = "screensNotToOcclude"
            org.json.JSONArray r8 = r7.optJSONArray(r8)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.fi$2 r2 = new com.uxcam.internals.fi$2     // Catch:{ Exception -> 0x02fc }
            r2.<init>()     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C3158fi.m1958a((org.json.JSONArray) r8, (com.uxcam.internals.C3158fi.C3162aa) r2)     // Catch:{ Exception -> 0x02fc }
            java.lang.String r8 = "screensToOcclude"
            org.json.JSONArray r8 = r7.optJSONArray(r8)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.fi$3 r2 = new com.uxcam.internals.fi$3     // Catch:{ Exception -> 0x02fc }
            r2.<init>()     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C3158fi.m1958a((org.json.JSONArray) r8, (com.uxcam.internals.C3158fi.C3162aa) r2)     // Catch:{ Exception -> 0x02fc }
            java.lang.String r8 = "upload_crashed_session"
            boolean r7 = r7.optBoolean(r8, r0)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2952an.f1336t = r7     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C3158fi.m1957a()     // Catch:{ Exception -> 0x02fc }
            org.json.JSONObject r7 = r9.f2249a     // Catch:{ Exception -> 0x02fc }
            java.lang.String r8 = "appIcon"
            boolean r7 = r7.has(r8)     // Catch:{ Exception -> 0x02fc }
            if (r7 == 0) goto L_0x02a5
            boolean r7 = com.uxcam.internals.C2952an.f1322f     // Catch:{ Exception -> 0x02fc }
            if (r7 != 0) goto L_0x02a5
            com.uxcam.internals.ba r7 = new com.uxcam.internals.ba     // Catch:{ Exception -> 0x02fc }
            android.content.Context r8 = r9.f2250b     // Catch:{ Exception -> 0x02fc }
            r7.<init>(r8)     // Catch:{ Exception -> 0x02fc }
            android.content.Context r8 = r7.f1391a     // Catch:{ Exception -> 0x02fc }
            java.io.File r8 = com.uxcam.internals.C2968ba.m1231a(r8)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.ay r9 = new com.uxcam.internals.ay     // Catch:{ Exception -> 0x02fc }
            r9.<init>()     // Catch:{ Exception -> 0x02fc }
            android.content.Context r7 = r7.f1391a     // Catch:{ Exception -> 0x02fc }
            r9.mo38061a(r7, r8)     // Catch:{ Exception -> 0x02fc }
        L_0x02a5:
            return
        L_0x02a6:
            com.uxcam.internals.C3170fn.f2291b = r1     // Catch:{ Exception -> 0x02fc }
            java.lang.String r7 = ""
            java.lang.String r9 = "message"
            java.lang.String r9 = r8.optString(r9)     // Catch:{ Exception -> 0x02c5 }
            boolean r7 = r9.isEmpty()     // Catch:{ Exception -> 0x02c3 }
            if (r7 == 0) goto L_0x02cb
            java.lang.String r7 = "error"
            org.json.JSONObject r7 = r8.optJSONObject(r7)     // Catch:{ Exception -> 0x02c3 }
            java.lang.String r8 = "message"
            java.lang.String r7 = r7.optString(r8)     // Catch:{ Exception -> 0x02c3 }
            goto L_0x02cc
        L_0x02c3:
            r7 = move-exception
            goto L_0x02c8
        L_0x02c5:
            r8 = move-exception
            r9 = r7
            r7 = r8
        L_0x02c8:
            r7.printStackTrace()     // Catch:{ Exception -> 0x02fc }
        L_0x02cb:
            r7 = r9
        L_0x02cc:
            java.lang.String r8 = "UXCam 3.3.0[501] : Application Key verification failed. Error : "
            java.lang.String r9 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x02fc }
            java.lang.String r8 = r8.concat(r9)     // Catch:{ Exception -> 0x02fc }
            java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.C2970bc.m1236a(r8, r9)     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.ab r8 = com.uxcam.internals.C2928ab.m1105a()     // Catch:{ Exception -> 0x02fc }
            r8.f1231d = r0     // Catch:{ Exception -> 0x02fc }
            com.uxcam.internals.ab r8 = com.uxcam.internals.C2928ab.m1105a()     // Catch:{ Exception -> 0x02fc }
            java.util.List r8 = r8.f1233f     // Catch:{ Exception -> 0x02fc }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x02fc }
        L_0x02eb:
            boolean r9 = r8.hasNext()     // Catch:{ Exception -> 0x02fc }
            if (r9 == 0) goto L_0x02fb
            java.lang.Object r9 = r8.next()     // Catch:{ Exception -> 0x02fc }
            com.uxcam.OnVerificationListener r9 = (com.uxcam.OnVerificationListener) r9     // Catch:{ Exception -> 0x02fc }
            r9.onVerificationFailed(r7)     // Catch:{ Exception -> 0x02fc }
            goto L_0x02eb
        L_0x02fb:
            return
        L_0x02fc:
            r7 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r0]
            java.lang.String r9 = "Exception in VerificationHandler.httpVerifyApplication "
            r8[r1] = r9
            com.uxcam.internals.C2970bc.m1237b()
            java.lang.Object[] r8 = new java.lang.Object[r0]
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r8[r1] = r7
            com.uxcam.internals.C2970bc.m1237b()
        L_0x0311:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3184fz.m2063a(com.uxcam.internals.fz, org.json.JSONObject, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2064a(File file, String str) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str + ".usid");
        C2970bc.m1233a("file72");
        new StringBuilder("create backendAppId file ").append(file2.getAbsolutePath());
        File[] listFiles = file.listFiles(new FilenameFilter() {
            public final boolean accept(File file, String str) {
                return str.toLowerCase().endsWith(".usid");
            }
        });
        if (listFiles != null && listFiles.length == 0) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2065a(String str) {
        new C3175fs(this.f2322b).mo38466a(str, this.f2323c.toString());
    }

    /* renamed from: b */
    private JSONObject m2067b(String str) {
        try {
            return new JSONObject(new C3175fs(this.f2322b).mo38463a(str));
        } catch (JSONException e) {
            new Object[1][0] = String.valueOf(e);
            C2970bc.m1237b();
            return null;
        }
    }

    /* renamed from: a */
    public final void mo38480a() {
        C2970bc.m1233a(f2321a);
        String a = new C3175fs(this.f2322b).mo38463a("settings");
        if (a != null) {
            try {
                final JSONObject jSONObject = new JSONObject(a);
                File[] listFiles = new File(C2958as.m1199b()).listFiles(new FilenameFilter() {
                    public final boolean accept(File file, String str) {
                        boolean e = C3183fy.m2049e(new File(file, str));
                        C2970bc.m1233a("val72");
                        return e;
                    }
                });
                int length = listFiles == null ? 0 : listFiles.length;
                C2970bc.m1233a(f2321a);
                if (length >= jSONObject.getJSONObject("data").getJSONObject("settings").optInt("maxOfflineVideos", 0)) {
                    jSONObject.getJSONObject("data").put("videoRecording", false);
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        C3184fz.m2063a(C3184fz.this, jSONObject, true);
                    }
                });
                return;
            } catch (Exception unused) {
            }
        }
        C2970bc.m1233a(f2321a);
    }

    /* renamed from: a */
    public final void mo38481a(String str, C2981bj bjVar, String str2) {
        try {
            if (C3169fm.m1993a(this.f2322b)) {
                this.f2323c.put("appKey", str);
                String a = C3171fo.m1997a(this.f2322b);
                C3171fo.m1999b(this.f2322b);
                C3011ca b = new C3011ca.C3013aa().mo38155a((C3005bx) new C2969bb()).mo38154a().mo38158b();
                C2997bt.C2998aa aaVar = new C2997bt.C2998aa();
                aaVar.mo38107a("internalDebugEvents", a);
                boolean z = str2 != null && !str2.equalsIgnoreCase("");
                if (z) {
                    aaVar.mo38107a("sessionId", str2);
                    this.f2323c = m2067b(str2);
                    if (this.f2323c != null) {
                        m2060a(aaVar);
                    }
                    C2970bc.m1233a(f2321a);
                    Object[] objArr = {str2, this.f2323c.toString()};
                } else {
                    m2060a(aaVar);
                    C2970bc.m1233a(f2321a);
                    Object[] objArr2 = {str2, this.f2323c.toString()};
                }
                C2970bc.m1233a(f2321a);
                String a2 = C3182fx.m2027a();
                HashMap hashMap = new HashMap();
                hashMap.put("isOldSession", String.valueOf(z));
                C3171fo.m1998a(this.f2322b, "verificationStarted", hashMap);
                C3017cd a3 = new C3017cd.C3018aa().mo38170a(a2).mo38171a("POST", (C3019ce) aaVar.mo38108a()).mo38173a();
                C3130en enVar = new C3130en();
                a3.f1726d.mo38105a((C3131eo) enVar);
                C2970bc.m1233a(f2321a);
                StringBuilder sb = new StringBuilder("Request url : ");
                sb.append(a2);
                sb.append(", Request Body: ");
                sb.append(enVar.mo38395l());
                b.mo38146a(a3).mo38077a(bjVar);
                return;
            }
            C2970bc.m1233a(f2321a);
        } catch (Exception unused) {
            C2970bc.m1233a(f2321a);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("reason", "Exception");
            C3171fo.m1998a(this.f2322b, "verificationFailed", hashMap2);
        }
    }
}
