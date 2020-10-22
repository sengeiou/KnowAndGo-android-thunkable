package com.uxcam.internals;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.uxcam.internals.ar */
public class C2956ar {

    /* renamed from: a */
    public static boolean f1355a = false;

    /* renamed from: b */
    public static boolean f1356b = false;

    /* renamed from: c */
    public static boolean f1357c = false;

    /* renamed from: d */
    private static final String f1358d = "ar";

    /* renamed from: e */
    private static final String[] f1359e = {"cordova", "xamarin", "react-native", "appcelerator"};

    /* renamed from: f */
    private String f1360f = "";

    /* renamed from: g */
    private long f1361g = -1;

    /* renamed from: h */
    private ArrayList f1362h = new ArrayList();

    /* renamed from: i */
    private int f1363i = -1;

    /* renamed from: j */
    private String f1364j = "";

    public C2956ar(String str) {
        this.f1360f = str;
    }

    /* renamed from: a */
    private double m1190a(Context context, DecimalFormat decimalFormat) {
        double c = (double) C3183fy.m2041c();
        File file = new File(C2958as.m1196a(), C2958as.m1202c());
        if (c < ((double) (((float) C2952an.f1324h) / 1000.0f)) + 0.3d) {
            f1356b = true;
            this.f1362h.add(6);
        } else if (file.exists()) {
            try {
                HashMap hashMap = new HashMap();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(context, Uri.fromFile(file));
                double intValue = (double) (((float) Integer.valueOf(mediaMetadataRetriever.extractMetadata(9)).intValue()) / 1000.0f);
                double d = intValue - c;
                if (intValue > c) {
                    hashMap.put("data-time", decimalFormat.format(c));
                    hashMap.put("video-time", decimalFormat.format(intValue));
                    hashMap.put("time-diff", decimalFormat.format(d));
                    C3171fo.m1998a(C3183fy.m2030a(), "totalTimeAdjusted", hashMap);
                    c = intValue;
                }
                this.f1361g = file.length();
            } catch (Exception unused) {
                C2970bc.m1233a(f1358d);
                C2970bc.m1233a(f1358d);
            }
        }
        return c;
    }

    /* renamed from: a */
    public static void m1191a(String str) {
        try {
            File file = new File(C2958as.m1196a());
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str));
            fileOutputStream.write("".getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private boolean m1192b() {
        return this.f1363i > 0;
    }

    /* renamed from: c */
    private static String m1193c() {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -v long -d").getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
                sb.append(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return StringUtils.SPACE;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0384 A[Catch:{ JSONException -> 0x065a }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0397 A[Catch:{ JSONException -> 0x065a }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x03b6 A[Catch:{ JSONException -> 0x065a }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x03d9 A[Catch:{ JSONException -> 0x065a }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x03eb A[Catch:{ JSONException -> 0x065a }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0449 A[Catch:{ JSONException -> 0x065a }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x044e A[Catch:{ JSONException -> 0x065a }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0459 A[Catch:{ JSONException -> 0x065a }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0465 A[Catch:{ JSONException -> 0x065a }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.File mo38052a() {
        /*
            r22 = this;
            r1 = r22
            com.uxcam.internals.fk r0 = com.uxcam.internals.C3165fk.m1970a()
            com.uxcam.internals.fl r0 = r0.f2268b
            r2 = 0
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ JSONException -> 0x0659 }
            r3.<init>()     // Catch:{ JSONException -> 0x0659 }
            android.content.Context r4 = com.uxcam.internals.C3183fy.m2030a()     // Catch:{ JSONException -> 0x0659 }
            java.lang.String r5 = "fileWriteStarted"
            com.uxcam.internals.C3171fo.m1998a(r4, r5, r3)     // Catch:{ JSONException -> 0x0659 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0659 }
            r3.<init>()     // Catch:{ JSONException -> 0x0659 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0659 }
            r4.<init>()     // Catch:{ JSONException -> 0x0659 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0659 }
            r5.<init>()     // Catch:{ JSONException -> 0x0659 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0659 }
            r6.<init>()     // Catch:{ JSONException -> 0x0659 }
            com.uxcam.internals.ab r7 = com.uxcam.internals.C2928ab.m1105a()     // Catch:{ JSONException -> 0x0659 }
            com.uxcam.internals.ap r7 = r7.f1234l     // Catch:{ JSONException -> 0x0659 }
            com.uxcam.internals.ap r8 = r7.f1353c     // Catch:{ JSONException -> 0x0659 }
            if (r8 != 0) goto L_0x0041
            org.json.JSONObject r8 = r7.mo38050a()     // Catch:{ JSONException -> 0x0659 }
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ JSONException -> 0x0659 }
            r9.<init>()     // Catch:{ JSONException -> 0x0659 }
            r7.f1352b = r9     // Catch:{ JSONException -> 0x0659 }
            goto L_0x0049
        L_0x0041:
            com.uxcam.internals.ap r8 = r7.f1353c     // Catch:{ JSONException -> 0x0659 }
            org.json.JSONObject r8 = r8.mo38050a()     // Catch:{ JSONException -> 0x0659 }
            r7.f1353c = r2     // Catch:{ JSONException -> 0x0659 }
        L_0x0049:
            java.lang.String r7 = "usr"
            r3.put(r7, r8)     // Catch:{ JSONException -> 0x0659 }
            java.lang.String r7 = "userTest"
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r7)     // Catch:{ JSONException -> 0x0659 }
            android.content.Context r7 = com.uxcam.internals.C3183fy.m2030a()     // Catch:{ JSONException -> 0x0659 }
            r8 = 0
            boolean r10 = r22.m1192b()     // Catch:{ JSONException -> 0x0659 }
            if (r10 != 0) goto L_0x00ad
            com.uxcam.internals.ab r8 = com.uxcam.internals.C2928ab.m1105a()     // Catch:{ JSONException -> 0x0659 }
            com.uxcam.internals.am r8 = r8.f1235m     // Catch:{ JSONException -> 0x0659 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0659 }
            java.util.Map r8 = r8.f1297a     // Catch:{ JSONException -> 0x0659 }
            r9.<init>(r8)     // Catch:{ JSONException -> 0x0659 }
            java.lang.String r8 = "cust"
            r4.put(r8, r9)     // Catch:{ JSONException -> 0x0659 }
            com.uxcam.internals.ab r8 = com.uxcam.internals.C2928ab.m1105a()     // Catch:{ JSONException -> 0x0659 }
            com.uxcam.internals.am r8 = r8.f1235m     // Catch:{ JSONException -> 0x0659 }
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ JSONException -> 0x0659 }
            r9.<init>()     // Catch:{ JSONException -> 0x0659 }
            r8.f1297a = r9     // Catch:{ JSONException -> 0x0659 }
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ JSONException -> 0x0659 }
            java.text.NumberFormat r8 = java.text.NumberFormat.getNumberInstance(r8)     // Catch:{ JSONException -> 0x0659 }
            java.text.DecimalFormat r8 = (java.text.DecimalFormat) r8     // Catch:{ JSONException -> 0x0659 }
            java.lang.String r9 = "0.000"
            r8.applyPattern(r9)     // Catch:{ JSONException -> 0x0659 }
            double r9 = r1.m1190a((android.content.Context) r7, (java.text.DecimalFormat) r8)     // Catch:{ JSONException -> 0x0659 }
            if (r0 == 0) goto L_0x009f
            float r11 = (float) r9     // Catch:{ JSONException -> 0x0659 }
            com.uxcam.internals.fk r12 = com.uxcam.internals.C3165fk.m1970a()     // Catch:{ JSONException -> 0x0659 }
            com.uxcam.internals.fl r12 = r12.f2268b     // Catch:{ JSONException -> 0x0659 }
            com.uxcam.internals.ao r12 = r12.f2277c     // Catch:{ JSONException -> 0x0659 }
            float r13 = r12.f1344b     // Catch:{ JSONException -> 0x0659 }
            float r11 = r11 - r13
            r12.f1346d = r11     // Catch:{ JSONException -> 0x0659 }
        L_0x009f:
            java.lang.String r11 = "tt"
            java.lang.String r8 = r8.format(r9)     // Catch:{ JSONException -> 0x0659 }
            java.lang.Double r8 = java.lang.Double.valueOf(r8)     // Catch:{ JSONException -> 0x0659 }
            r4.put(r11, r8)     // Catch:{ JSONException -> 0x0659 }
            r8 = r9
        L_0x00ad:
            java.lang.String r10 = "nt"
            java.lang.String r11 = com.uxcam.internals.C3183fy.m2054h(r7)     // Catch:{ JSONException -> 0x0659 }
            r4.put(r10, r11)     // Catch:{ JSONException -> 0x0659 }
            java.lang.String r10 = "isvo"
            boolean r11 = com.uxcam.internals.C2952an.f1305H     // Catch:{ JSONException -> 0x0659 }
            r4.put(r10, r11)     // Catch:{ JSONException -> 0x0659 }
            java.lang.String r10 = r1.f1360f     // Catch:{ JSONException -> 0x0659 }
            boolean r10 = r10.isEmpty()     // Catch:{ JSONException -> 0x0659 }
            if (r10 != 0) goto L_0x00d3
            java.lang.String r10 = "crashData"
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0659 }
            java.lang.String r14 = r1.f1360f     // Catch:{ JSONException -> 0x0659 }
            r13.<init>(r14)     // Catch:{ JSONException -> 0x0659 }
            r3.put(r10, r13)     // Catch:{ JSONException -> 0x0659 }
            r10 = 1
            goto L_0x00d4
        L_0x00d3:
            r10 = 0
        L_0x00d4:
            java.lang.String r13 = "isc"
            r4.put(r13, r10)     // Catch:{ JSONException -> 0x0659 }
            java.lang.String r13 = "session"
            r3.put(r13, r4)     // Catch:{ JSONException -> 0x0659 }
            java.lang.String r13 = "did"
            java.lang.String r14 = com.uxcam.internals.C3172fp.m2003b(r7)     // Catch:{ JSONException -> 0x0659 }
            r5.put(r13, r14)     // Catch:{ JSONException -> 0x0659 }
            java.lang.String r13 = "osn"
            java.lang.String r14 = com.uxcam.internals.C3172fp.m2002a()     // Catch:{ JSONException -> 0x0659 }
            r5.put(r13, r14)     // Catch:{ JSONException -> 0x0659 }
            java.lang.String r13 = "dvt"
            java.lang.String r14 = com.uxcam.internals.C3172fp.m2005d(r7)     // Catch:{ JSONException -> 0x0659 }
            r5.put(r13, r14)     // Catch:{ JSONException -> 0x0659 }
            android.graphics.Point r13 = com.uxcam.internals.C3172fp.m2001a(r7)     // Catch:{ JSONException -> 0x0659 }
            int r14 = r13.y     // Catch:{ JSONException -> 0x0659 }
            int r13 = r13.x     // Catch:{ JSONException -> 0x0659 }
            if (r13 <= r14) goto L_0x0116
            java.lang.String r15 = "dwt"
            java.lang.String r14 = java.lang.Integer.toString(r14)     // Catch:{ JSONException -> 0x0659 }
            r5.put(r15, r14)     // Catch:{ JSONException -> 0x0659 }
            java.lang.String r14 = "dht"
            java.lang.String r13 = java.lang.Integer.toString(r13)     // Catch:{ JSONException -> 0x0659 }
            r5.put(r14, r13)     // Catch:{ JSONException -> 0x0659 }
            goto L_0x0120
        L_0x0116:
            java.lang.String r15 = "dwt"
            r5.put(r15, r13)     // Catch:{ JSONException -> 0x0659 }
            java.lang.String r13 = "dht"
            r5.put(r13, r14)     // Catch:{ JSONException -> 0x0659 }
        L_0x0120:
            java.lang.String r13 = "ahp"
            int r14 = com.uxcam.internals.C3196gd.f2367n     // Catch:{ JSONException -> 0x0659 }
            r5.put(r13, r14)     // Catch:{ JSONException -> 0x0659 }
            android.graphics.Point r13 = com.uxcam.internals.C3172fp.m2001a(r7)     // Catch:{ JSONException -> 0x0659 }
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0659 }
            r14.<init>()     // Catch:{ JSONException -> 0x0659 }
            int r15 = r13.x     // Catch:{ JSONException -> 0x0659 }
            r14.put(r15)     // Catch:{ JSONException -> 0x0659 }
            int r13 = r13.y     // Catch:{ JSONException -> 0x0659 }
            r14.put(r13)     // Catch:{ JSONException -> 0x0659 }
            java.lang.String r13 = "ar"
            r5.put(r13, r14)     // Catch:{ JSONException -> 0x0659 }
            android.content.res.Resources r13 = r7.getResources()     // Catch:{ JSONException -> 0x0659 }
            android.util.DisplayMetrics r13 = r13.getDisplayMetrics()     // Catch:{ JSONException -> 0x0659 }
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0659 }
            r14.<init>()     // Catch:{ JSONException -> 0x0659 }
            float r15 = r13.xdpi     // Catch:{ JSONException -> 0x0659 }
            double r11 = (double) r15     // Catch:{ JSONException -> 0x0659 }
            r14.put(r11)     // Catch:{ JSONException -> 0x0659 }
            float r11 = r13.ydpi     // Catch:{ JSONException -> 0x0659 }
            double r11 = (double) r11     // Catch:{ JSONException -> 0x0659 }
            r14.put(r11)     // Catch:{ JSONException -> 0x0659 }
            java.lang.String r11 = "xyDpi"
            r5.put(r11, r14)     // Catch:{ JSONException -> 0x0659 }
            java.lang.String r11 = "dpi"
            android.graphics.Point r12 = com.uxcam.internals.C3172fp.m2001a(r7)     // Catch:{ JSONException -> 0x0659 }
            int r13 = r12.x     // Catch:{ JSONException -> 0x0659 }
            int r14 = r12.x     // Catch:{ JSONException -> 0x0659 }
            int r13 = r13 * r14
            int r14 = r12.y     // Catch:{ JSONException -> 0x0659 }
            int r12 = r12.y     // Catch:{ JSONException -> 0x0659 }
            int r14 = r14 * r12
            int r13 = r13 + r14
            double r12 = (double) r13     // Catch:{ JSONException -> 0x0659 }
            double r12 = java.lang.Math.sqrt(r12)     // Catch:{ JSONException -> 0x0659 }
            android.graphics.Point r14 = com.uxcam.internals.C3172fp.m2001a(r7)     // Catch:{ JSONException -> 0x0659 }
            android.content.res.Resources r15 = r7.getResources()     // Catch:{ JSONException -> 0x0659 }
            android.util.DisplayMetrics r15 = r15.getDisplayMetrics()     // Catch:{ JSONException -> 0x0659 }
            int r2 = r14.x     // Catch:{ JSONException -> 0x0659 }
            float r2 = (float) r2     // Catch:{ JSONException -> 0x0659 }
            r21 = r0
            float r0 = r15.xdpi     // Catch:{ JSONException -> 0x0659 }
            float r2 = r2 / r0
            double r0 = (double) r2
            int r2 = r14.y     // Catch:{ JSONException -> 0x0656 }
            float r2 = (float) r2     // Catch:{ JSONException -> 0x0656 }
            float r14 = r15.ydpi     // Catch:{ JSONException -> 0x0656 }
            float r2 = r2 / r14
            double r14 = (double) r2     // Catch:{ JSONException -> 0x0656 }
            android.util.Pair r2 = new android.util.Pair     // Catch:{ JSONException -> 0x0656 }
            java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch:{ JSONException -> 0x0656 }
            java.lang.Double r1 = java.lang.Double.valueOf(r14)     // Catch:{ JSONException -> 0x0656 }
            r2.<init>(r0, r1)     // Catch:{ JSONException -> 0x0656 }
            java.lang.Object r0 = r2.first     // Catch:{ JSONException -> 0x0656 }
            java.lang.Double r0 = (java.lang.Double) r0     // Catch:{ JSONException -> 0x0656 }
            double r0 = r0.doubleValue()     // Catch:{ JSONException -> 0x0656 }
            java.lang.Object r14 = r2.first     // Catch:{ JSONException -> 0x0656 }
            java.lang.Double r14 = (java.lang.Double) r14     // Catch:{ JSONException -> 0x0656 }
            double r14 = r14.doubleValue()     // Catch:{ JSONException -> 0x0656 }
            double r0 = r0 * r14
            java.lang.Object r14 = r2.second     // Catch:{ JSONException -> 0x0656 }
            java.lang.Double r14 = (java.lang.Double) r14     // Catch:{ JSONException -> 0x0656 }
            double r14 = r14.doubleValue()     // Catch:{ JSONException -> 0x0656 }
            java.lang.Object r2 = r2.second     // Catch:{ JSONException -> 0x0656 }
            java.lang.Double r2 = (java.lang.Double) r2     // Catch:{ JSONException -> 0x0656 }
            double r16 = r2.doubleValue()     // Catch:{ JSONException -> 0x0656 }
            double r14 = r14 * r16
            r2 = 0
            double r0 = r0 + r14
            double r0 = java.lang.Math.sqrt(r0)     // Catch:{ JSONException -> 0x0656 }
            double r12 = r12 / r0
            int r0 = (int) r12     // Catch:{ JSONException -> 0x0656 }
            r5.put(r11, r0)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r0 = "osv"
            java.lang.String r1 = android.os.Build.VERSION.RELEASE     // Catch:{ JSONException -> 0x0656 }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r0 = "mnf"
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ JSONException -> 0x0656 }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r0 = "mdl"
            java.lang.String r1 = android.os.Build.MODEL     // Catch:{ JSONException -> 0x0656 }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r0 = "isr"
            boolean r1 = com.uxcam.internals.C3183fy.m2046d()     // Catch:{ JSONException -> 0x0656 }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x0656 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ JSONException -> 0x0656 }
            r1 = 16
            if (r0 < r1) goto L_0x01fa
            java.lang.String r0 = "ttr"
            int r1 = com.uxcam.internals.C3183fy.m2053g(r7)     // Catch:{ JSONException -> 0x0656 }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x0656 }
        L_0x01fa:
            java.lang.String r0 = "tts"
            float r1 = com.uxcam.internals.C3183fy.m2050f()     // Catch:{ JSONException -> 0x0656 }
            int r1 = (int) r1     // Catch:{ JSONException -> 0x0656 }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r0 = "cr"
            java.lang.String r1 = com.uxcam.internals.C3183fy.m2048e((android.content.Context) r7)     // Catch:{ JSONException -> 0x0656 }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r0 = "cc"
            java.lang.String r1 = com.uxcam.internals.C3183fy.m2051f(r7)     // Catch:{ JSONException -> 0x0656 }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r0 = "cnt"
            java.util.Locale r1 = java.util.Locale.getDefault()     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r1 = r1.getDisplayCountry()     // Catch:{ JSONException -> 0x0656 }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r0 = "lng"
            java.util.Locale r1 = java.util.Locale.getDefault()     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r1 = r1.getDisplayLanguage()     // Catch:{ JSONException -> 0x0656 }
            r5.put(r0, r1)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r0 = ""
            java.lang.String r1 = ""
            java.lang.String r2 = com.uxcam.internals.C2928ab.f1222n     // Catch:{ JSONException -> 0x0656 }
            if (r2 == 0) goto L_0x024a
            java.lang.String[] r2 = f1359e     // Catch:{ JSONException -> 0x0656 }
            java.util.List r2 = java.util.Arrays.asList(r2)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r11 = com.uxcam.internals.C2928ab.f1222n     // Catch:{ JSONException -> 0x0656 }
            boolean r2 = r2.contains(r11)     // Catch:{ JSONException -> 0x0656 }
            if (r2 == 0) goto L_0x024a
            java.lang.String r0 = com.uxcam.internals.C2928ab.f1222n     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r1 = com.uxcam.internals.C2928ab.f1223o     // Catch:{ JSONException -> 0x0656 }
        L_0x024a:
            java.lang.String r2 = "plf"
            java.lang.String r11 = "android"
            r5.put(r2, r11)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r2 = "device"
            r3.put(r2, r5)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r2 = f1358d     // Catch:{ JSONException -> 0x0656 }
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r2)     // Catch:{ JSONException -> 0x0656 }
            r2 = 1
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r2 = r5.toString()     // Catch:{ JSONException -> 0x0656 }
            r5 = 0
            r11[r5] = r2     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r2 = "version"
            java.lang.String r5 = "3.3.0"
            r6.put(r2, r5)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r2 = "versionNumber"
            r5 = 501(0x1f5, float:7.02E-43)
            r6.put(r2, r5)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r2 = "pluginType"
            r6.put(r2, r0)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r0 = "pluginVersion"
            r6.put(r0, r1)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r0 = "sdkv"
            r3.put(r0, r6)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r0 = "aid"
            java.lang.String r1 = com.uxcam.internals.C2952an.f1321e     // Catch:{ JSONException -> 0x0656 }
            r3.put(r0, r1)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r0 = "ron"
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r2 = "yyyy-MM-dd HH:mm:ss:SSS z"
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ JSONException -> 0x0656 }
            r1.<init>(r2, r5)     // Catch:{ JSONException -> 0x0656 }
            java.util.Calendar r2 = java.util.Calendar.getInstance()     // Catch:{ JSONException -> 0x0656 }
            r5 = 14
            int r6 = r2.get(r5)     // Catch:{ JSONException -> 0x0656 }
            double r11 = (double) r6     // Catch:{ JSONException -> 0x0656 }
            r13 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r13 = r13 * r8
            double r11 = r11 - r13
            int r6 = (int) r11     // Catch:{ JSONException -> 0x0656 }
            r2.set(r5, r6)     // Catch:{ JSONException -> 0x0656 }
            java.util.Date r2 = r2.getTime()     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r1 = r1.format(r2)     // Catch:{ JSONException -> 0x0656 }
            r3.put(r0, r1)     // Catch:{ JSONException -> 0x0656 }
            android.util.Pair r0 = com.uxcam.internals.C3183fy.m2045d((android.content.Context) r7)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r1 = "appv"
            java.lang.Object r2 = r0.first     // Catch:{ JSONException -> 0x0656 }
            r3.put(r1, r2)     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r1 = "appvc"
            java.lang.Object r0 = r0.second     // Catch:{ JSONException -> 0x0656 }
            r3.put(r1, r0)     // Catch:{ JSONException -> 0x0656 }
            boolean r0 = com.uxcam.internals.C2952an.f1322f     // Catch:{ JSONException -> 0x0656 }
            if (r0 != 0) goto L_0x02d9
            java.lang.String r0 = "appn"
            android.content.Context r1 = com.uxcam.internals.C3183fy.m2030a()     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r1 = com.uxcam.internals.C3183fy.m2039b((android.content.Context) r1)     // Catch:{ JSONException -> 0x0656 }
            r3.put(r0, r1)     // Catch:{ JSONException -> 0x0656 }
        L_0x02d9:
            java.lang.String r0 = "misc"
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0656 }
            java.lang.String r2 = com.uxcam.internals.C2952an.f1331o     // Catch:{ JSONException -> 0x0656 }
            r1.<init>(r2)     // Catch:{ JSONException -> 0x0656 }
            r3.put(r0, r1)     // Catch:{ JSONException -> 0x0656 }
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0656 }
            r1.<init>()     // Catch:{ JSONException -> 0x0656 }
            boolean r0 = r22.m1192b()     // Catch:{ JSONException -> 0x0656 }
            if (r0 != 0) goto L_0x0490
            com.uxcam.internals.fk r0 = com.uxcam.internals.C3165fk.m1970a()     // Catch:{ JSONException -> 0x0656 }
            int r0 = r0.mo38450e()     // Catch:{ JSONException -> 0x0656 }
            org.json.JSONArray r2 = com.uxcam.internals.C2952an.f1341y     // Catch:{ JSONException -> 0x0656 }
            if (r2 == 0) goto L_0x0346
            org.json.JSONArray r2 = com.uxcam.internals.C2952an.f1341y     // Catch:{ JSONException -> 0x0656 }
            int r2 = r2.length()     // Catch:{ JSONException -> 0x0656 }
            if (r2 <= 0) goto L_0x0346
            int r2 = (int) r8     // Catch:{ JSONException -> 0x0656 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0656 }
            r5.<init>()     // Catch:{ JSONException -> 0x0656 }
            com.uxcam.internals.fk r6 = com.uxcam.internals.C3165fk.m1970a()     // Catch:{ JSONException -> 0x0656 }
            java.util.Set r6 = r6.mo38451f()     // Catch:{ JSONException -> 0x0656 }
            r5.addAll(r6)     // Catch:{ JSONException -> 0x0656 }
            com.uxcam.internals.fk r6 = com.uxcam.internals.C3165fk.m1970a()     // Catch:{ JSONException -> 0x0656 }
            java.util.ArrayList r6 = r6.f2269c     // Catch:{ JSONException -> 0x0656 }
            r5.addAll(r6)     // Catch:{ JSONException -> 0x0656 }
            com.uxcam.internals.ax r6 = new com.uxcam.internals.ax     // Catch:{ JSONException -> 0x0656 }
            org.json.JSONArray r17 = com.uxcam.internals.C2952an.f1341y     // Catch:{ JSONException -> 0x0656 }
            r15 = r6
            r16 = r5
            r18 = r10
            r19 = r2
            r20 = r0
            r15.<init>(r16, r17, r18, r19, r20)     // Catch:{ JSONException -> 0x0656 }
            boolean r2 = r6.mo38060a()     // Catch:{ JSONException -> 0x0656 }
            if (r2 != 0) goto L_0x0346
            r2 = r22
            java.util.ArrayList r5 = r2.f1362h     // Catch:{ JSONException -> 0x065a }
            java.util.ArrayList r6 = r6.f1373a     // Catch:{ JSONException -> 0x065a }
            r5.addAll(r6)     // Catch:{ JSONException -> 0x065a }
            r5 = 1
            com.uxcam.internals.C2952an.f1334r = r5     // Catch:{ JSONException -> 0x065a }
            java.lang.String r5 = "filter11"
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r5)     // Catch:{ JSONException -> 0x065a }
            goto L_0x0348
        L_0x0346:
            r2 = r22
        L_0x0348:
            org.json.JSONArray r5 = com.uxcam.internals.C2952an.f1342z     // Catch:{ JSONException -> 0x065a }
            if (r5 == 0) goto L_0x0393
            org.json.JSONArray r5 = com.uxcam.internals.C2952an.f1342z     // Catch:{ JSONException -> 0x065a }
            int r5 = r5.length()     // Catch:{ JSONException -> 0x065a }
            if (r5 <= 0) goto L_0x0393
            int r5 = (int) r8     // Catch:{ JSONException -> 0x065a }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ JSONException -> 0x065a }
            r6.<init>()     // Catch:{ JSONException -> 0x065a }
            com.uxcam.internals.fk r8 = com.uxcam.internals.C3165fk.m1970a()     // Catch:{ JSONException -> 0x065a }
            java.util.Set r8 = r8.mo38451f()     // Catch:{ JSONException -> 0x065a }
            r6.addAll(r8)     // Catch:{ JSONException -> 0x065a }
            com.uxcam.internals.fk r8 = com.uxcam.internals.C3165fk.m1970a()     // Catch:{ JSONException -> 0x065a }
            java.util.ArrayList r8 = r8.f2269c     // Catch:{ JSONException -> 0x065a }
            r6.addAll(r8)     // Catch:{ JSONException -> 0x065a }
            com.uxcam.internals.ax r8 = new com.uxcam.internals.ax     // Catch:{ JSONException -> 0x065a }
            org.json.JSONArray r17 = com.uxcam.internals.C2952an.f1342z     // Catch:{ JSONException -> 0x065a }
            r15 = r8
            r16 = r6
            r18 = r10
            r19 = r5
            r20 = r0
            r15.<init>(r16, r17, r18, r19, r20)     // Catch:{ JSONException -> 0x065a }
            boolean r0 = r8.mo38060a()     // Catch:{ JSONException -> 0x065a }
            if (r0 != 0) goto L_0x0393
            java.util.ArrayList r0 = r2.f1362h     // Catch:{ JSONException -> 0x065a }
            java.util.ArrayList r5 = r8.f1373a     // Catch:{ JSONException -> 0x065a }
            r0.addAll(r5)     // Catch:{ JSONException -> 0x065a }
            r0 = 1
            f1355a = r0     // Catch:{ JSONException -> 0x065a }
            java.lang.String r0 = "filter11"
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r0)     // Catch:{ JSONException -> 0x065a }
        L_0x0393:
            boolean r0 = f1357c     // Catch:{ JSONException -> 0x065a }
            if (r0 == 0) goto L_0x03a2
            java.util.ArrayList r0 = r2.f1362h     // Catch:{ JSONException -> 0x065a }
            r5 = 8
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ JSONException -> 0x065a }
            r0.add(r5)     // Catch:{ JSONException -> 0x065a }
        L_0x03a2:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x065a }
            r0.<init>()     // Catch:{ JSONException -> 0x065a }
            java.lang.String r5 = "recordStatus"
            boolean r6 = com.uxcam.internals.C2952an.f1323g     // Catch:{ JSONException -> 0x065a }
            r0.put(r5, r6)     // Catch:{ JSONException -> 0x065a }
            java.util.ArrayList r5 = r2.f1362h     // Catch:{ JSONException -> 0x065a }
            boolean r5 = r5.isEmpty()     // Catch:{ JSONException -> 0x065a }
            if (r5 != 0) goto L_0x03d5
            java.util.ArrayList r5 = r2.f1362h     // Catch:{ JSONException -> 0x065a }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ JSONException -> 0x065a }
        L_0x03bc:
            boolean r6 = r5.hasNext()     // Catch:{ JSONException -> 0x065a }
            if (r6 == 0) goto L_0x03d0
            java.lang.Object r6 = r5.next()     // Catch:{ JSONException -> 0x065a }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ JSONException -> 0x065a }
            int r6 = r6.intValue()     // Catch:{ JSONException -> 0x065a }
            r1.put(r6)     // Catch:{ JSONException -> 0x065a }
            goto L_0x03bc
        L_0x03d0:
            java.lang.String r5 = "reasonForNoVideo"
            r0.putOpt(r5, r1)     // Catch:{ JSONException -> 0x065a }
        L_0x03d5:
            boolean r5 = com.uxcam.internals.C2952an.f1323g     // Catch:{ JSONException -> 0x065a }
            if (r5 == 0) goto L_0x03e4
            java.lang.String r5 = "videoSize"
            long r8 = r2.f1361g     // Catch:{ JSONException -> 0x065a }
            java.lang.Long r6 = java.lang.Long.valueOf(r8)     // Catch:{ JSONException -> 0x065a }
            r0.putOpt(r5, r6)     // Catch:{ JSONException -> 0x065a }
        L_0x03e4:
            java.lang.String r5 = "video"
            r4.put(r5, r0)     // Catch:{ JSONException -> 0x065a }
            if (r21 == 0) goto L_0x03f2
            r0 = r21
            com.uxcam.internals.fj r0 = r0.f2276b     // Catch:{ JSONException -> 0x065a }
            r0.mo38442a()     // Catch:{ JSONException -> 0x065a }
        L_0x03f2:
            java.lang.String r0 = "evt"
            com.uxcam.internals.fk r5 = com.uxcam.internals.C3165fk.m1970a()     // Catch:{ JSONException -> 0x065a }
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ JSONException -> 0x065a }
            r6.<init>()     // Catch:{ JSONException -> 0x065a }
            java.util.ArrayList r8 = r5.f2269c     // Catch:{ JSONException -> 0x065a }
            com.uxcam.internals.C3165fk.m1971a(r8, r6)     // Catch:{ JSONException -> 0x065a }
            java.util.ArrayList r5 = r5.f2270d     // Catch:{ JSONException -> 0x065a }
            com.uxcam.internals.C3165fk.m1971a(r5, r6)     // Catch:{ JSONException -> 0x065a }
            r3.put(r0, r6)     // Catch:{ JSONException -> 0x065a }
            java.lang.String r0 = "anr"
            com.uxcam.internals.fk r5 = com.uxcam.internals.C3165fk.m1970a()     // Catch:{ JSONException -> 0x065a }
            org.json.JSONArray r5 = r5.f2271e     // Catch:{ JSONException -> 0x065a }
            r3.put(r0, r5)     // Catch:{ JSONException -> 0x065a }
            com.uxcam.internals.fk r0 = com.uxcam.internals.C3165fk.m1970a()     // Catch:{ JSONException -> 0x065a }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ JSONException -> 0x065a }
            r5.<init>()     // Catch:{ JSONException -> 0x065a }
            r0.f2269c = r5     // Catch:{ JSONException -> 0x065a }
            com.uxcam.internals.fk r0 = com.uxcam.internals.C3165fk.m1970a()     // Catch:{ JSONException -> 0x065a }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ JSONException -> 0x065a }
            r5.<init>()     // Catch:{ JSONException -> 0x065a }
            r0.f2270d = r5     // Catch:{ JSONException -> 0x065a }
            com.uxcam.internals.fk r0 = com.uxcam.internals.C3165fk.m1970a()     // Catch:{ JSONException -> 0x065a }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x065a }
            r5.<init>()     // Catch:{ JSONException -> 0x065a }
            r0.f2271e = r5     // Catch:{ JSONException -> 0x065a }
            java.lang.String r0 = f1358d     // Catch:{ JSONException -> 0x065a }
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r0)     // Catch:{ JSONException -> 0x065a }
            java.lang.String r0 = "st"
            com.uxcam.internals.fk r5 = com.uxcam.internals.C3165fk.m1970a()     // Catch:{ JSONException -> 0x065a }
            java.util.ArrayList r6 = r5.f2267a     // Catch:{ JSONException -> 0x065a }
            boolean r6 = r6.isEmpty()     // Catch:{ JSONException -> 0x065a }
            if (r6 != 0) goto L_0x044e
            org.json.JSONArray r6 = r5.mo38449d()     // Catch:{ JSONException -> 0x065a }
            goto L_0x044f
        L_0x044e:
            r6 = 0
        L_0x044f:
            r5.mo38447b()     // Catch:{ JSONException -> 0x065a }
            r3.put(r0, r6)     // Catch:{ JSONException -> 0x065a }
            boolean r0 = com.uxcam.internals.C2952an.f1333q     // Catch:{ JSONException -> 0x065a }
            if (r0 == 0) goto L_0x0465
            java.lang.String r0 = "sessionCancelled"
            r5 = 1
            r3.put(r0, r5)     // Catch:{ JSONException -> 0x065a }
            f1355a = r5     // Catch:{ JSONException -> 0x065a }
            r5 = 0
            com.uxcam.internals.C2952an.f1333q = r5     // Catch:{ JSONException -> 0x065a }
            goto L_0x0492
        L_0x0465:
            boolean r0 = com.uxcam.internals.C2952an.f1334r     // Catch:{ JSONException -> 0x065a }
            if (r0 == 0) goto L_0x0476
            java.lang.String r0 = "sessionCancelled"
            r5 = 6
            r3.put(r0, r5)     // Catch:{ JSONException -> 0x065a }
            r0 = 1
            f1355a = r0     // Catch:{ JSONException -> 0x065a }
            r5 = 0
            com.uxcam.internals.C2952an.f1334r = r5     // Catch:{ JSONException -> 0x065a }
            goto L_0x0492
        L_0x0476:
            boolean r0 = f1355a     // Catch:{ JSONException -> 0x065a }
            if (r0 == 0) goto L_0x0485
            boolean r0 = com.uxcam.internals.C2952an.f1301D     // Catch:{ JSONException -> 0x065a }
            if (r0 == 0) goto L_0x0485
            java.lang.String r0 = "sessionCancelled"
            r5 = 7
            r3.put(r0, r5)     // Catch:{ JSONException -> 0x065a }
            goto L_0x0492
        L_0x0485:
            boolean r0 = f1356b     // Catch:{ JSONException -> 0x065a }
            if (r0 == 0) goto L_0x0492
            r5 = 0
            f1356b = r5     // Catch:{ JSONException -> 0x065a }
            r0 = 1
            f1355a = r0     // Catch:{ JSONException -> 0x065a }
            goto L_0x0492
        L_0x0490:
            r2 = r22
        L_0x0492:
            boolean r0 = r22.m1192b()     // Catch:{ JSONException -> 0x065a }
            if (r0 == 0) goto L_0x049f
            java.lang.String r0 = "sessionCancelled"
            int r5 = r2.f1363i     // Catch:{ JSONException -> 0x065a }
            r3.put(r0, r5)     // Catch:{ JSONException -> 0x065a }
        L_0x049f:
            java.lang.String r0 = f1358d     // Catch:{ JSONException -> 0x065a }
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r0)     // Catch:{ JSONException -> 0x065a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x065a }
            java.lang.String r5 = "data file content :: "
            r0.<init>(r5)     // Catch:{ JSONException -> 0x065a }
            java.lang.String r5 = r3.toString()     // Catch:{ JSONException -> 0x065a }
            r0.append(r5)     // Catch:{ JSONException -> 0x065a }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x065a }
            long r8 = com.uxcam.internals.C3183fy.m2047e()     // Catch:{ JSONException -> 0x065a }
            r10 = 10000000(0x989680, double:4.9406565E-317)
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x04cf
            java.lang.String r0 = "appLog"
            java.lang.String r8 = m1193c()     // Catch:{ Exception -> 0x04cb }
            r4.put(r0, r8)     // Catch:{ Exception -> 0x04cb }
            goto L_0x04cf
        L_0x04cb:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ JSONException -> 0x065a }
        L_0x04cf:
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x065a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x065a }
            java.lang.String r4 = "time taken to fetch log is "
            r0.<init>(r4)     // Catch:{ JSONException -> 0x065a }
            r4 = 0
            long r8 = r8 - r5
            r0.append(r8)     // Catch:{ JSONException -> 0x065a }
            boolean r0 = r22.m1192b()     // Catch:{ JSONException -> 0x065a }
            if (r0 == 0) goto L_0x04e8
            java.lang.String r0 = r2.f1364j     // Catch:{ JSONException -> 0x065a }
            goto L_0x04ec
        L_0x04e8:
            java.lang.String r0 = com.uxcam.internals.C2958as.m1196a()     // Catch:{ JSONException -> 0x065a }
        L_0x04ec:
            r4 = r0
            java.lang.String r0 = r3.toString()     // Catch:{ JSONException -> 0x065a }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            boolean r5 = r3.exists()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            if (r5 != 0) goto L_0x04ff
            r3.mkdirs()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
        L_0x04ff:
            boolean r5 = com.uxcam.internals.C2952an.f1307J     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            if (r5 == 0) goto L_0x057a
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            java.io.File r6 = new java.io.File     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            java.lang.String r8 = com.uxcam.internals.C2958as.m1204d()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r6.<init>(r3, r8)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r5.<init>(r6)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            java.util.zip.ZipOutputStream r3 = new java.util.zip.ZipOutputStream     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r3.<init>(r5)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r5.<init>()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            com.uxcam.internals.at r6 = new com.uxcam.internals.at     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r6.<init>()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            javax.crypto.CipherOutputStream r8 = r6.mo38056a(r5)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            java.util.zip.GZIPOutputStream r9 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r9.<init>(r8)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r9.write(r0)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r9.close()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            java.util.zip.ZipEntry r0 = new java.util.zip.ZipEntry     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            java.lang.String r8 = "data.json.gz.aes"
            r0.<init>(r8)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r3.putNextEntry(r0)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            byte[] r0 = r5.toByteArray()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r3.write(r0)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r3.closeEntry()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            java.util.zip.ZipEntry r0 = new java.util.zip.ZipEntry     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            java.lang.String r5 = "metadata.json"
            r0.<init>(r5)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r3.putNextEntry(r0)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r0.<init>()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            java.lang.String r5 = "decryptKey"
            java.lang.String r8 = r6.mo38055a()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r0.put(r5, r8)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            java.lang.String r5 = "decryptiv"
            java.lang.String r6 = r6.mo38057b()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r0.put(r5, r6)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r3.write(r0)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r3.closeEntry()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r3.close()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            goto L_0x059c
        L_0x057a:
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            java.io.File r6 = new java.io.File     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            java.lang.String r8 = com.uxcam.internals.C2958as.m1204d()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r6.<init>(r3, r8)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r5.<init>(r6)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r5.write(r0)     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            r5.close()     // Catch:{ IOException -> 0x0598, JSONException -> 0x0593 }
            goto L_0x059c
        L_0x0593:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ JSONException -> 0x065a }
            goto L_0x059c
        L_0x0598:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ JSONException -> 0x065a }
        L_0x059c:
            java.io.File r3 = new java.io.File     // Catch:{ JSONException -> 0x065a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x065a }
            r0.<init>()     // Catch:{ JSONException -> 0x065a }
            r0.append(r4)     // Catch:{ JSONException -> 0x065a }
            java.lang.String r4 = com.uxcam.internals.C2958as.m1204d()     // Catch:{ JSONException -> 0x065a }
            r0.append(r4)     // Catch:{ JSONException -> 0x065a }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x065a }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x065a }
            boolean r0 = f1355a     // Catch:{ JSONException -> 0x065a }
            if (r0 == 0) goto L_0x0624
            boolean r0 = r22.m1192b()     // Catch:{ JSONException -> 0x065a }
            if (r0 != 0) goto L_0x0624
            r4 = 0
            f1355a = r4     // Catch:{ JSONException -> 0x065a }
            java.io.File r0 = r3.getParentFile()     // Catch:{ Exception -> 0x0617 }
            com.uxcam.internals.ar$1 r5 = new com.uxcam.internals.ar$1     // Catch:{ Exception -> 0x0617 }
            r5.<init>()     // Catch:{ Exception -> 0x0617 }
            java.io.File[] r0 = r0.listFiles(r5)     // Catch:{ Exception -> 0x0617 }
            r5 = r0[r4]     // Catch:{ Exception -> 0x0617 }
            com.uxcam.internals.C3183fy.m2035a((java.io.File) r5)     // Catch:{ Exception -> 0x0617 }
            java.lang.String r4 = "filter11"
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r4)     // Catch:{ Exception -> 0x0617 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0617 }
            java.lang.String r5 = "deleted file "
            r4.<init>(r5)     // Catch:{ Exception -> 0x0617 }
            r5 = 0
            r0 = r0[r5]     // Catch:{ Exception -> 0x0617 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x0617 }
            r4.append(r0)     // Catch:{ Exception -> 0x0617 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0617 }
            r0.<init>()     // Catch:{ Exception -> 0x0617 }
            java.lang.String r4 = "recordStatus"
            boolean r5 = com.uxcam.internals.C2952an.f1323g     // Catch:{ Exception -> 0x0617 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x0617 }
            r0.put(r4, r5)     // Catch:{ Exception -> 0x0617 }
            java.lang.String r4 = "ignoreScreenVideo"
            boolean r5 = f1355a     // Catch:{ Exception -> 0x0617 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x0617 }
            r0.put(r4, r5)     // Catch:{ Exception -> 0x0617 }
            java.lang.String r4 = "reasonForNoVideo"
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0617 }
            r0.put(r4, r1)     // Catch:{ Exception -> 0x0617 }
            android.content.Context r1 = com.uxcam.internals.C3183fy.m2030a()     // Catch:{ Exception -> 0x0617 }
            java.lang.String r4 = "screenVideoIgnored"
            com.uxcam.internals.C3171fo.m1998a(r1, r4, r0)     // Catch:{ Exception -> 0x0617 }
            goto L_0x061b
        L_0x0617:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ JSONException -> 0x065a }
        L_0x061b:
            com.uxcam.internals.fs r0 = new com.uxcam.internals.fs     // Catch:{ JSONException -> 0x065a }
            r0.<init>(r7)     // Catch:{ JSONException -> 0x065a }
        L_0x0620:
            r0.mo38464a()     // Catch:{ JSONException -> 0x065a }
            goto L_0x062a
        L_0x0624:
            com.uxcam.internals.fs r0 = new com.uxcam.internals.fs     // Catch:{ JSONException -> 0x065a }
            r0.<init>(r7)     // Catch:{ JSONException -> 0x065a }
            goto L_0x0620
        L_0x062a:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ JSONException -> 0x065a }
            r0.<init>()     // Catch:{ JSONException -> 0x065a }
            java.lang.String r1 = "file_size"
            long r4 = r3.length()     // Catch:{ JSONException -> 0x065a }
            r6 = 1024(0x400, double:5.06E-321)
            long r4 = r4 / r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ JSONException -> 0x065a }
            r0.put(r1, r4)     // Catch:{ JSONException -> 0x065a }
            android.content.Context r1 = com.uxcam.internals.C3183fy.m2030a()     // Catch:{ JSONException -> 0x065a }
            java.lang.String r4 = "fileWriteCompleted"
            com.uxcam.internals.C3171fo.m1998a(r1, r4, r0)     // Catch:{ JSONException -> 0x065a }
            boolean r0 = r22.m1192b()     // Catch:{ JSONException -> 0x065a }
            if (r0 != 0) goto L_0x0655
            r1 = 0
            f1357c = r1     // Catch:{ JSONException -> 0x065a }
            r0 = 0
            com.uxcam.internals.C2923aa.f1200b = r0     // Catch:{ JSONException -> 0x065a }
        L_0x0655:
            return r3
        L_0x0656:
            r2 = r22
            goto L_0x065a
        L_0x0659:
            r2 = r1
        L_0x065a:
            java.lang.String r0 = f1358d
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r0)
            com.uxcam.internals.C2970bc.m1238c()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            android.content.Context r1 = com.uxcam.internals.C3183fy.m2030a()
            java.lang.String r3 = "textFileWriteException"
            com.uxcam.internals.C3171fo.m1998a(r1, r3, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C2956ar.mo38052a():java.io.File");
    }

    /* renamed from: a */
    public final void mo38053a(int i, String str) {
        this.f1363i = i;
        this.f1364j = str;
        mo38052a();
    }
}
