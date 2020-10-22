package com.uxcam.internals;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.uxcam.internals.fi */
public final class C3158fi {

    /* renamed from: c */
    private static final double[][] f2245c = {new double[]{0.5d, 320.0d}, new double[]{0.5d, 384.0d}, new double[]{1.0d, 432.0d}, new double[]{1.0d, 432.0d}, new double[]{0.5d, 128.0d}};

    /* renamed from: d */
    private static final double[][] f2246d = {new double[]{0.5d, 160.0d}, new double[]{0.5d, 240.0d}, new double[]{1.0d, 320.0d}, new double[]{1.0d, 432.0d}, new double[]{0.5d, 96.0d}};

    /* renamed from: e */
    private static final double[][] f2247e = {new double[]{0.5d, 160.0d}, new double[]{0.5d, 320.0d}, new double[]{0.5d, 320.0d}, new double[]{0.5d, 384.0d}, new double[]{0.5d, 128.0d}};

    /* renamed from: f */
    private static final double[][] f2248f = {new double[]{0.5d, 160.0d}, new double[]{0.5d, 240.0d}, new double[]{0.5d, 272.0d}, new double[]{0.5d, 320.0d}, new double[]{0.5d, 96.0d}};

    /* renamed from: a */
    public JSONObject f2249a;

    /* renamed from: b */
    public Context f2250b;

    /* renamed from: com.uxcam.internals.fi$aa */
    interface C3162aa {
        /* renamed from: a */
        void mo38441a(String str);
    }

    public C3158fi(JSONObject jSONObject, Context context) {
        this.f2249a = jSONObject.optJSONObject("data");
        this.f2250b = context;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|(2:4|(1:6)(16:7|(3:16|17|18)|19|20|(1:22)|23|(1:25)|26|(4:28|(5:32|33|34|35|36)|37|(1:39))|40|(2:42|(2:47|(1:49)(1:50))(1:46))|51|54|(2:57|55)|59|58))|8|10|12|14|16|17|18|19|20|(0)|23|(0)|26|(0)|40|(0)|51|54|(1:55)|59|58) */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x018c, code lost:
        com.uxcam.internals.C2970bc.m1233a(com.uxcam.internals.C2923aa.f1199a);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00e6 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078 A[Catch:{ Exception -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a9 A[Catch:{ Exception -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c6 A[Catch:{ Exception -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0127 A[Catch:{ Exception -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01a1 A[LOOP:0: B:55:0x019b->B:57:0x01a1, LOOP_END] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m1957a() {
        /*
            com.uxcam.internals.fk r0 = com.uxcam.internals.C3165fk.m1970a()
            r0.mo38447b()
            java.util.ArrayList r0 = com.uxcam.internals.C3170fn.f2292c
            r0.clear()
            r0 = 1
            com.uxcam.internals.C3170fn.f2290a = r0
            com.uxcam.internals.aa r1 = com.uxcam.internals.C2923aa.m1096a()
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x018c }
            com.uxcam.internals.C2923aa.f1200b = r2     // Catch:{ Exception -> 0x018c }
            boolean r2 = android.os.Debug.isDebuggerConnected()     // Catch:{ Exception -> 0x018c }
            r3 = 0
            if (r2 != 0) goto L_0x0029
            boolean r2 = android.os.Debug.waitingForDebugger()     // Catch:{ Exception -> 0x018c }
            if (r2 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r2 = 0
            goto L_0x002a
        L_0x0029:
            r2 = 1
        L_0x002a:
            if (r2 != 0) goto L_0x006c
            int[] r2 = com.uxcam.internals.C2952an.f1303F     // Catch:{ Exception -> 0x018c }
            r2 = r2[r3]     // Catch:{ Exception -> 0x018c }
            if (r2 <= 0) goto L_0x006c
            int[] r2 = com.uxcam.internals.C2952an.f1303F     // Catch:{ Exception -> 0x018c }
            r2 = r2[r0]     // Catch:{ Exception -> 0x018c }
            if (r2 <= 0) goto L_0x006c
            com.uxcam.internals.ah r2 = r1.f1203d     // Catch:{ Exception -> 0x018c }
            if (r2 != 0) goto L_0x006c
            java.lang.String r2 = "ANRTicker"
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r2)     // Catch:{ Exception -> 0x006c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006c }
            java.lang.String r4 = "ANRTicker started with params "
            r2.<init>(r4)     // Catch:{ Exception -> 0x006c }
            int[] r4 = com.uxcam.internals.C2952an.f1303F     // Catch:{ Exception -> 0x006c }
            java.lang.String r4 = java.util.Arrays.toString(r4)     // Catch:{ Exception -> 0x006c }
            r2.append(r4)     // Catch:{ Exception -> 0x006c }
            com.uxcam.internals.ah r2 = new com.uxcam.internals.ah     // Catch:{ Exception -> 0x006c }
            int[] r4 = com.uxcam.internals.C2952an.f1303F     // Catch:{ Exception -> 0x006c }
            r4 = r4[r3]     // Catch:{ Exception -> 0x006c }
            int[] r5 = com.uxcam.internals.C2952an.f1303F     // Catch:{ Exception -> 0x006c }
            r5 = r5[r0]     // Catch:{ Exception -> 0x006c }
            r2.<init>(r4, r5)     // Catch:{ Exception -> 0x006c }
            r1.f1203d = r2     // Catch:{ Exception -> 0x006c }
            com.uxcam.internals.ah r2 = r1.f1203d     // Catch:{ Exception -> 0x006c }
            com.uxcam.internals.aa$1 r4 = new com.uxcam.internals.aa$1     // Catch:{ Exception -> 0x006c }
            r4.<init>()     // Catch:{ Exception -> 0x006c }
            r2.f1262b = r4     // Catch:{ Exception -> 0x006c }
            r2.start()     // Catch:{ Exception -> 0x006c }
        L_0x006c:
            java.lang.Thread$UncaughtExceptionHandler r2 = java.lang.Thread.getDefaultUncaughtExceptionHandler()     // Catch:{ Exception -> 0x018c }
            java.lang.Thread$UncaughtExceptionHandler r4 = java.lang.Thread.getDefaultUncaughtExceptionHandler()     // Catch:{ Exception -> 0x018c }
            boolean r4 = r4 instanceof com.uxcam.internals.C2947ai     // Catch:{ Exception -> 0x018c }
            if (r4 != 0) goto L_0x0080
            com.uxcam.internals.ai r4 = new com.uxcam.internals.ai     // Catch:{ Exception -> 0x018c }
            r4.<init>(r2)     // Catch:{ Exception -> 0x018c }
            java.lang.Thread.setDefaultUncaughtExceptionHandler(r4)     // Catch:{ Exception -> 0x018c }
        L_0x0080:
            android.content.Context r2 = com.uxcam.internals.C3183fy.m2030a()     // Catch:{ Exception -> 0x018c }
            r1.f1202c = r2     // Catch:{ Exception -> 0x018c }
            java.lang.String r2 = "UXCam"
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r2)     // Catch:{ Exception -> 0x018c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018c }
            java.lang.String r4 = "screenRecordStatus "
            r2.<init>(r4)     // Catch:{ Exception -> 0x018c }
            boolean r4 = com.uxcam.internals.C2952an.f1323g     // Catch:{ Exception -> 0x018c }
            r2.append(r4)     // Catch:{ Exception -> 0x018c }
            java.lang.String r2 = com.uxcam.internals.C2958as.m1204d()     // Catch:{ Exception -> 0x018c }
            com.uxcam.internals.ar r4 = new com.uxcam.internals.ar     // Catch:{ Exception -> 0x018c }
            java.lang.String r5 = ""
            r4.<init>(r5)     // Catch:{ Exception -> 0x018c }
            com.uxcam.internals.C2956ar.m1191a(r2)     // Catch:{ Exception -> 0x018c }
            boolean r2 = com.uxcam.internals.C2952an.f1306I     // Catch:{ Exception -> 0x018c }
            if (r2 == 0) goto L_0x00c2
            java.util.Timer r2 = new java.util.Timer     // Catch:{ Exception -> 0x018c }
            r2.<init>()     // Catch:{ Exception -> 0x018c }
            r1.f1204e = r2     // Catch:{ Exception -> 0x018c }
            com.uxcam.internals.aa$3 r2 = new com.uxcam.internals.aa$3     // Catch:{ Exception -> 0x018c }
            r2.<init>()     // Catch:{ Exception -> 0x018c }
            r1.f1205f = r2     // Catch:{ Exception -> 0x018c }
            java.util.Timer r4 = r1.f1204e     // Catch:{ Exception -> 0x018c }
            java.util.TimerTask r5 = r1.f1205f     // Catch:{ Exception -> 0x018c }
            r6 = 0
            r8 = 1000(0x3e8, double:4.94E-321)
            r4.schedule(r5, r6, r8)     // Catch:{ Exception -> 0x018c }
        L_0x00c2:
            boolean r2 = com.uxcam.internals.C2952an.f1323g     // Catch:{ Exception -> 0x018c }
            if (r2 == 0) goto L_0x0114
            boolean r2 = com.uxcam.internals.C3196gd.f2355b     // Catch:{ Exception -> 0x018c }
            if (r2 == 0) goto L_0x00e9
            com.uxcam.internals.gg r2 = com.uxcam.internals.C3196gd.f2357d     // Catch:{ Exception -> 0x018c }
            if (r2 == 0) goto L_0x00e9
            com.uxcam.internals.gb r2 = com.uxcam.internals.C3196gd.f2354a     // Catch:{ Exception -> 0x018c }
            r2.clear()     // Catch:{ Exception -> 0x018c }
            com.uxcam.internals.ga r2 = new com.uxcam.internals.ga     // Catch:{ Exception -> 0x018c }
            com.uxcam.internals.gg r4 = com.uxcam.internals.C3196gd.f2357d     // Catch:{ Exception -> 0x018c }
            r2.<init>(r4)     // Catch:{ Exception -> 0x018c }
            com.uxcam.internals.C3192ga.m2075a()     // Catch:{ Exception -> 0x018c }
            com.uxcam.internals.C3195gc.f2343a = r3     // Catch:{ Exception -> 0x018c }
            com.uxcam.internals.C3196gd.f2355b = r3     // Catch:{ Exception -> 0x018c }
            com.uxcam.internals.gg r2 = com.uxcam.internals.C3196gd.f2357d     // Catch:{ IOException -> 0x00e6 }
            r2.mo38501a()     // Catch:{ IOException -> 0x00e6 }
        L_0x00e6:
            com.uxcam.internals.C3196gd.m2088d()     // Catch:{ Exception -> 0x018c }
        L_0x00e9:
            com.uxcam.internals.C3196gd.f2355b = r3     // Catch:{ Exception -> 0x018c }
            java.lang.String r2 = "UXCam"
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r2)     // Catch:{ Exception -> 0x018c }
            com.uxcam.internals.gd r2 = com.uxcam.internals.C3196gd.m2079a()     // Catch:{ Exception -> 0x018c }
            com.uxcam.internals.C3192ga.f2334a = r0     // Catch:{ Exception -> 0x018c }
            boolean r0 = com.uxcam.internals.C3196gd.f2369p     // Catch:{ Exception -> 0x018c }
            if (r0 != 0) goto L_0x0114
            java.util.Timer r0 = new java.util.Timer     // Catch:{ Exception -> 0x018c }
            r0.<init>()     // Catch:{ Exception -> 0x018c }
            r2.f2379r = r0     // Catch:{ Exception -> 0x018c }
            com.uxcam.internals.gd$4 r0 = new com.uxcam.internals.gd$4     // Catch:{ Exception -> 0x018c }
            r0.<init>()     // Catch:{ Exception -> 0x018c }
            r2.f2380s = r0     // Catch:{ Exception -> 0x018c }
            java.util.Timer r4 = r2.f2379r     // Catch:{ Exception -> 0x018c }
            java.util.TimerTask r5 = r2.f2380s     // Catch:{ Exception -> 0x018c }
            r6 = 0
            int r0 = com.uxcam.internals.C3196gd.f2370q     // Catch:{ Exception -> 0x018c }
            long r8 = (long) r0     // Catch:{ Exception -> 0x018c }
            r4.schedule(r5, r6, r8)     // Catch:{ Exception -> 0x018c }
        L_0x0114:
            com.uxcam.internals.C3183fy.m2055h()     // Catch:{ Exception -> 0x018c }
            android.content.Context r0 = com.uxcam.internals.C3183fy.m2038b()     // Catch:{ Exception -> 0x018c }
            java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x018c }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ Exception -> 0x018c }
            boolean r2 = com.uxcam.internals.C2928ab.f1219i     // Catch:{ Exception -> 0x018c }
            if (r2 != 0) goto L_0x0146
            java.lang.String r0 = com.uxcam.internals.C3165fk.f2263i     // Catch:{ Exception -> 0x018c }
            if (r0 == 0) goto L_0x0139
            java.lang.String r0 = com.uxcam.internals.C3165fk.f2263i     // Catch:{ Exception -> 0x018c }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x018c }
            if (r0 != 0) goto L_0x0139
            java.lang.String r0 = com.uxcam.internals.C3165fk.f2263i     // Catch:{ Exception -> 0x018c }
            r2 = 0
            com.uxcam.internals.C3165fk.f2263i = r2     // Catch:{ Exception -> 0x018c }
            goto L_0x0146
        L_0x0139:
            java.lang.String r0 = com.uxcam.internals.C3165fk.f2264j     // Catch:{ Exception -> 0x018c }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x018c }
            if (r0 == 0) goto L_0x0144
            java.lang.String r0 = "unknown"
            goto L_0x0146
        L_0x0144:
            java.lang.String r0 = com.uxcam.internals.C3165fk.f2264j     // Catch:{ Exception -> 0x018c }
        L_0x0146:
            com.uxcam.internals.fk r2 = com.uxcam.internals.C3165fk.m1970a()     // Catch:{ Exception -> 0x018c }
            android.content.Context r4 = r1.f1202c     // Catch:{ Exception -> 0x018c }
            r2.mo38445a((android.content.Context) r4, (java.lang.String) r0, (boolean) r3)     // Catch:{ Exception -> 0x018c }
            java.lang.String r0 = com.uxcam.internals.C2923aa.f1199a     // Catch:{ Exception -> 0x018c }
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r0)     // Catch:{ Exception -> 0x018c }
            java.lang.String r0 = "UXCam"
            com.uxcam.internals.bc$aa r0 = com.uxcam.internals.C2970bc.m1233a((java.lang.String) r0)     // Catch:{ Exception -> 0x018c }
            java.lang.String r2 = "UXCam 3.3.0[501] : Application key is verified, UXCam has started capturing data as per configuration from UXCam settings page."
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x018c }
            r0.mo38070a((java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x018c }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x018c }
            android.content.Context r2 = r1.f1202c     // Catch:{ Exception -> 0x018c }
            java.lang.Class<com.uxcam.service.HttpPostService> r3 = com.uxcam.service.HttpPostService.class
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x018c }
            java.lang.String r2 = "arg_which_service"
            java.lang.String r3 = "send_offline_data"
            r0.putExtra(r2, r3)     // Catch:{ Exception -> 0x018c }
            android.content.Context r2 = r1.f1202c     // Catch:{ Exception -> 0x018c }
            r2.startService(r0)     // Catch:{ Exception -> 0x018c }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x018c }
            android.content.Context r2 = r1.f1202c     // Catch:{ Exception -> 0x018c }
            java.lang.Class<com.uxcam.service.HttpPostService> r3 = com.uxcam.service.HttpPostService.class
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x018c }
            java.lang.String r2 = "arg_which_service"
            java.lang.String r3 = "stop_foreground"
            r0.putExtra(r2, r3)     // Catch:{ Exception -> 0x018c }
            android.content.Context r1 = r1.f1202c     // Catch:{ Exception -> 0x018c }
            r1.startService(r0)     // Catch:{ Exception -> 0x018c }
            goto L_0x0191
        L_0x018c:
            java.lang.String r0 = com.uxcam.internals.C2923aa.f1199a
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r0)
        L_0x0191:
            com.uxcam.internals.ab r0 = com.uxcam.internals.C2928ab.m1105a()
            java.util.List r0 = r0.f1233f
            java.util.Iterator r0 = r0.iterator()
        L_0x019b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01b3
            java.lang.Object r1 = r0.next()
            com.uxcam.OnVerificationListener r1 = (com.uxcam.OnVerificationListener) r1
            com.uxcam.internals.aq r2 = new com.uxcam.internals.aq
            com.uxcam.internals.C3183fy.m2030a()
            r2.<init>()
            r1.onVerificationSuccess()
            goto L_0x019b
        L_0x01b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3158fi.m1957a():void");
    }

    /* renamed from: a */
    public static void m1958a(JSONArray jSONArray, C3162aa aaVar) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    aaVar.mo38441a(jSONArray.get(i).toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo38439a(double d, int i, int i2) {
        int i3 = C3183fy.m2030a().getResources().getDisplayMetrics().widthPixels;
        if (i3 >= i || i2 == 1) {
            C2952an.f1335s = i;
            C2952an.f1324h = (int) (1000.0d / d);
            int i4 = 1000 / C2952an.f1324h;
            C3344kw.f2913a = i4;
            if (i4 <= 0) {
                C3344kw.f2913a = 1;
            }
            C3338kr.f2888a = C3344kw.f2913a;
            C2970bc.m1233a("SettingsHandler");
            StringBuilder sb = new StringBuilder("fps ");
            sb.append(d);
            sb.append(" width ");
            sb.append(i);
            sb.append(" frame time ");
            sb.append(C2952an.f1324h);
            sb.append(" deviceOriginalWidth ");
            sb.append(i3);
            return;
        }
        mo38440a(i2 - 1, true);
    }

    /* renamed from: a */
    public final void mo38440a(int i, boolean z) {
        double d;
        double d2;
        if (i > 5 || i <= 0) {
            C2970bc.m1233a("SettingsHandler");
            i = 2;
        }
        boolean c = C3172fp.m2004c(this.f2250b);
        C2970bc.m1233a("SettingsHandler");
        new Object[1][0] = "isUsingMediaCodec " + z + " isTablet " + c;
        if (z && c) {
            int i2 = i - 1;
            d = f2245c[i2][0];
            d2 = f2245c[i2][1];
        } else if (z) {
            int i3 = i - 1;
            d = f2246d[i3][0];
            d2 = f2246d[i3][1];
        } else if (c) {
            int i4 = i - 1;
            d = f2247e[i4][0];
            d2 = f2247e[i4][1];
        } else {
            int i5 = i - 1;
            d = f2248f[i5][0];
            d2 = f2248f[i5][1];
        }
        mo38439a(d, (int) d2, i);
    }
}
