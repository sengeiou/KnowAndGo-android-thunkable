package com.uxcam.internals;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import android.webkit.WebView;
import com.amplitude.api.AmplitudeClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.uxcam.OnVerificationListener;
import com.uxcam.UXCam;
import com.uxcam.internals.C2937ae;
import com.uxcam.internals.C2970bc;
import com.uxcam.service.HttpPostService;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.uxcam.internals.ab */
public class C2928ab {

    /* renamed from: a */
    public static String f1215a = null;

    /* renamed from: b */
    static C2940af f1216b = null;

    /* renamed from: g */
    public static boolean f1217g = true;

    /* renamed from: h */
    public static boolean f1218h = false;

    /* renamed from: i */
    public static boolean f1219i = true;

    /* renamed from: j */
    public static boolean f1220j = false;

    /* renamed from: k */
    static boolean f1221k = false;

    /* renamed from: n */
    public static String f1222n = null;

    /* renamed from: o */
    public static String f1223o = null;

    /* renamed from: p */
    private static final String f1224p = "ab";

    /* renamed from: q */
    private static C2928ab f1225q = null;

    /* renamed from: r */
    private static boolean f1226r = false;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public static boolean f1227u = false;

    /* renamed from: v */
    private static boolean f1228v = false;

    /* renamed from: w */
    private static boolean f1229w = false;

    /* renamed from: c */
    C2955aq f1230c;

    /* renamed from: d */
    public int f1231d = 0;

    /* renamed from: e */
    public boolean f1232e;

    /* renamed from: f */
    public List f1233f = new CopyOnWriteArrayList();

    /* renamed from: l */
    public C2954ap f1234l = new C2954ap();

    /* renamed from: m */
    public C2951am f1235m = new C2951am();

    /* renamed from: s */
    private Application.ActivityLifecycleCallbacks f1236s;

    /* renamed from: t */
    private Context f1237t;

    private C2928ab() {
    }

    /* renamed from: a */
    public static C2928ab m1105a() {
        if (f1225q == null) {
            f1225q = new C2928ab();
        }
        return f1225q;
    }

    /* renamed from: a */
    public static void m1106a(int i) {
        C3196gd.f2360g = (long) i;
    }

    @TargetApi(14)
    /* renamed from: a */
    public static void m1107a(Activity activity, String str) {
        f1215a = str;
        if (!f1226r && Build.VERSION.SDK_INT >= 14) {
            m1154t();
            f1226r = true;
            C2937ae aeVar = new C2937ae();
            m1105a().f1236s = aeVar;
            aeVar.onActivityStarted(activity);
            activity.getApplication().registerActivityLifecycleCallbacks(aeVar);
        }
    }

    @TargetApi(14)
    /* renamed from: a */
    public static void m1108a(Context context) {
        C3196gd.f2360g = 0;
        if (!C2952an.f1332p && m1105a().f1236s != null) {
            ((Application) context.getApplicationContext()).unregisterActivityLifecycleCallbacks(m1105a().f1236s);
            f1226r = false;
        }
        m1105a().f1232e = false;
        C2970bc.m1233a(f1224p);
        f1216b = null;
        C3195gc.f2348f = -1;
        m1105a().f1231d = 2;
        if (m1105a().f1231d == 1) {
            C3165fk.m1970a().f2269c = new ArrayList();
        }
        try {
            if (C3170fn.f2290a) {
                new C2955aq();
                C2955aq.m1188a(false);
                C2923aa.m1096a().mo37983a(C3183fy.m2030a(), "");
            } else if (C3170fn.f2291b) {
                C3170fn.f2291b = false;
                new C2956ar("").mo38053a(4, C2958as.m1199b() + "/" + UUID.randomUUID().toString() + "/");
            }
        } catch (Exception unused) {
            C2970bc.m1238c();
        }
    }

    /* renamed from: a */
    public static void m1109a(View view) {
        C3180fv fvVar = new C3180fv(true);
        fvVar.f2300b = new WeakReference(view);
        fvVar.f2301c = false;
        C3196gd.f2362i.add(fvVar);
    }

    /* renamed from: a */
    public static void m1110a(WebView webView) {
        C2952an.f1314Q = false;
        webView.addJavascriptInterface(new C2933ac(), "UXCam");
    }

    /* renamed from: a */
    public static void m1111a(final MapFragment mapFragment) {
        try {
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                public final void onMapReady(GoogleMap googleMap) {
                    C3203ge.f2392e = googleMap;
                    C3203ge.f2391d = new WeakReference(mapFragment.getView());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m1112a(final MapView mapView) {
        try {
            mapView.getMapAsync(new OnMapReadyCallback() {
                public final void onMapReady(GoogleMap googleMap) {
                    C3203ge.f2392e = googleMap;
                    C3203ge.f2391d = new WeakReference(mapView);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m1113a(final SupportMapFragment supportMapFragment) {
        try {
            supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                public final void onMapReady(GoogleMap googleMap) {
                    C3203ge.f2392e = googleMap;
                    C3203ge.f2391d = new WeakReference(supportMapFragment.getView());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @TargetApi(14)
    /* renamed from: a */
    public static void m1114a(String str) {
        try {
            f1215a = str;
            m1139f(false);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @TargetApi(14)
    /* renamed from: a */
    public static void m1115a(String str, String str2) {
        C2952an.f1320d = str2;
        UXCam.startWithKey(str);
    }

    /* renamed from: a */
    public static void m1116a(String str, Map map) {
        StringBuilder sb;
        String str2;
        String str3;
        StringBuilder sb2;
        String str4;
        C3165fk a = C3165fk.m1970a();
        HashMap hashMap = new HashMap();
        int i = 0;
        int i2 = C2952an.f1304G[0];
        int i3 = C2952an.f1304G[1];
        int i4 = C2952an.f1304G[2];
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(" :::::::::::::");
        float c = C3183fy.m2041c();
        if (c > 0.0f) {
            if (a.f2269c == null) {
                a.f2269c = new ArrayList();
            }
            if (a.f2269c.size() >= i2) {
                sb2 = new StringBuilder("[");
                sb2.append(str);
                sb2.append("] event  will not be tracked. (event limit: ");
                sb2.append(i2);
                str4 = ")";
            } else if (C3165fk.m1969a(str) > 255) {
                sb2 = new StringBuilder();
                sb2.append(str);
                str4 = " evtest event will not be tracked. (byte size limit per event key: 255 bytes)";
            } else {
                if (map != null && map.size() <= i3) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (i >= i3) {
                            sb = new StringBuilder("[");
                            sb.append(entry.getKey());
                            sb.append(" : ");
                            sb.append(entry.getValue());
                            sb.append("] param will not be tracked. (param limit: ");
                            sb.append(i3);
                            str3 = ")";
                        } else {
                            if (C3165fk.m1969a(entry.getKey().toString()) > i4) {
                                sb = new StringBuilder("[");
                                sb.append(entry.getKey());
                                sb.append(" : ");
                                sb.append(entry.getValue());
                                str2 = "] param will not be tracked. (byte size limit per param key: ";
                            } else if (C3165fk.m1969a(entry.getValue().toString()) > i4) {
                                sb = new StringBuilder("[");
                                sb.append(entry.getKey());
                                sb.append(" : ");
                                sb.append(entry.getValue());
                                str2 = "] param will not be tracked. (byte size limit per param value: ";
                            } else {
                                hashMap.put(entry.getKey().toString(), entry.getValue().toString());
                                i++;
                            }
                            sb.append(str2);
                            sb.append(i4);
                            str3 = " bytes)";
                        }
                        sb.append(str3);
                        i++;
                    }
                } else if (map != null) {
                    String str5 = "Too many properties in this event: " + map.size() + ". Limit is " + i3 + ".";
                    hashMap.put("_UXCam_Overload", str5);
                    C2970bc.m1233a("UXCam").mo38070a(str5, new Object[0]);
                }
                a.f2269c.add(new C2948aj(str, c, C3165fk.m1970a().mo38448c(), hashMap));
            }
            sb2.append(str4);
        }
        if (str.equals("UXCam_ForceSessionUpload")) {
            f1220j = true;
            if (C2952an.f1318b != null && !C3170fn.f2290a) {
                new C3175fs(C3183fy.m2030a()).mo38468b(C2952an.f1318b);
            }
        }
    }

    /* renamed from: a */
    public static void m1117a(List list) {
        C2952an.f1310M.addAll(list);
    }

    /* renamed from: a */
    public static void m1118a(JSONArray jSONArray) {
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                Rect rect = new Rect();
                rect.left = jSONArray2.getInt(0);
                rect.top = jSONArray2.getInt(1);
                rect.right = jSONArray2.getInt(2);
                rect.bottom = jSONArray2.getInt(3);
                C3196gd.f2363j.add(rect);
                i++;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (C3203ge.f2389b.getCount() == 1) {
            C3203ge.f2389b.countDown();
        }
    }

    /* renamed from: a */
    public static void m1119a(boolean z) {
        C3196gd.m2082a(z);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(20:91|92|93|94|95|108|(0)(0)|112|(0)(0)|115|119|121|123|124|126|128|130|131|132|(0)(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0152, code lost:
        if (com.uxcam.internals.C3183fy.m2037a(com.uxcam.internals.C3183fy.f2315a) != false) goto L_0x0162;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:131:0x0296 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:94:0x01ab */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0200 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0211 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0227 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0232 A[Catch:{ Exception -> 0x0296 }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02b4 A[Catch:{ Exception -> 0x02bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m1120a(boolean r11, android.app.Activity r12) {
        /*
            java.util.ArrayList r0 = com.uxcam.internals.C3196gd.f2364k     // Catch:{ Exception -> 0x02bd }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x02bd }
        L_0x0006:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x02bd }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001e
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x02bd }
            android.app.Activity r1 = (android.app.Activity) r1     // Catch:{ Exception -> 0x02bd }
            if (r1 == 0) goto L_0x0006
            boolean r1 = r1.equals(r12)     // Catch:{ Exception -> 0x02bd }
            if (r1 == 0) goto L_0x0006
            r0 = 1
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            if (r0 != 0) goto L_0x003d
            java.util.ArrayList r0 = com.uxcam.internals.C3196gd.f2364k     // Catch:{ Exception -> 0x02bd }
            r0.add(r12)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r0 = "ActivityStack"
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r0)     // Catch:{ Exception -> 0x02bd }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02bd }
            java.lang.String r1 = "added :"
            r0.<init>(r1)     // Catch:{ Exception -> 0x02bd }
            java.lang.Class r1 = r12.getClass()     // Catch:{ Exception -> 0x02bd }
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ Exception -> 0x02bd }
            r0.append(r1)     // Catch:{ Exception -> 0x02bd }
        L_0x003d:
            com.uxcam.internals.C3196gd.f2359f = r3     // Catch:{ Exception -> 0x02bd }
            java.lang.String r0 = "UXCam"
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r0)     // Catch:{ Exception -> 0x02bd }
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x02bd }
            java.lang.String r1 = "pauseForAnotherApp false 2"
            r0[r3] = r1     // Catch:{ Exception -> 0x02bd }
            boolean r0 = com.uxcam.internals.C3196gd.f2359f     // Catch:{ Exception -> 0x02bd }
            if (r0 == 0) goto L_0x0054
            com.uxcam.internals.C3196gd.f2359f = r3     // Catch:{ Exception -> 0x02bd }
            r0 = 700(0x2bc, float:9.81E-43)
            com.uxcam.internals.C2952an.f1317a = r0     // Catch:{ Exception -> 0x02bd }
        L_0x0054:
            com.uxcam.internals.C3183fy.m2034a((android.app.Activity) r12)     // Catch:{ Exception -> 0x02bd }
            com.uxcam.internals.af r0 = new com.uxcam.internals.af     // Catch:{ Exception -> 0x02bd }
            r0.<init>(r12)     // Catch:{ Exception -> 0x02bd }
            f1216b = r0     // Catch:{ Exception -> 0x02bd }
            android.app.Activity r1 = r0.f1255a     // Catch:{ Exception -> 0x0296 }
            if (r1 == 0) goto L_0x0296
            com.uxcam.internals.ab r1 = m1105a()     // Catch:{ Exception -> 0x0296 }
            android.content.Context r4 = com.uxcam.internals.C3183fy.m2030a()     // Catch:{ Exception -> 0x0296 }
            com.uxcam.internals.ab r5 = m1105a()     // Catch:{ Exception -> 0x0296 }
            int r5 = r5.f1231d     // Catch:{ Exception -> 0x0296 }
            r6 = 3
            if (r5 != r6) goto L_0x0075
            r5 = 0
            goto L_0x0076
        L_0x0075:
            r5 = 1
        L_0x0076:
            boolean r7 = f1217g     // Catch:{ Exception -> 0x0296 }
            if (r7 != 0) goto L_0x007e
            if (r11 != 0) goto L_0x007e
            r11 = 0
            goto L_0x007f
        L_0x007e:
            r11 = 1
        L_0x007f:
            boolean r7 = r1.f1232e     // Catch:{ Exception -> 0x0296 }
            r8 = 0
            if (r7 != 0) goto L_0x01fa
            if (r5 == 0) goto L_0x01fa
            boolean r5 = f1227u     // Catch:{ Exception -> 0x0296 }
            if (r5 != 0) goto L_0x01fa
            java.lang.String r5 = f1215a     // Catch:{ Exception -> 0x01da }
            if (r5 != 0) goto L_0x0094
            java.lang.String r5 = com.uxcam.internals.C3183fy.m2031a((android.content.Context) r4)     // Catch:{ Exception -> 0x01da }
            f1215a = r5     // Catch:{ Exception -> 0x01da }
        L_0x0094:
            com.uxcam.internals.ab r5 = m1105a()     // Catch:{ Exception -> 0x01da }
            int r5 = r5.f1231d     // Catch:{ Exception -> 0x01da }
            r7 = 2
            if (r5 != r7) goto L_0x00a3
            com.uxcam.internals.ab r5 = m1105a()     // Catch:{ Exception -> 0x01da }
            r5.f1231d = r3     // Catch:{ Exception -> 0x01da }
        L_0x00a3:
            java.lang.String r5 = f1224p     // Catch:{ Exception -> 0x01da }
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r5)     // Catch:{ Exception -> 0x01da }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01da }
            java.lang.String r7 = "App key is "
            r5.<init>(r7)     // Catch:{ Exception -> 0x01da }
            java.lang.String r7 = f1215a     // Catch:{ Exception -> 0x01da }
            r5.append(r7)     // Catch:{ Exception -> 0x01da }
            com.uxcam.internals.aq r5 = new com.uxcam.internals.aq     // Catch:{ Exception -> 0x01da }
            r5.<init>()     // Catch:{ Exception -> 0x01da }
            r1.f1230c = r5     // Catch:{ Exception -> 0x01da }
            r1.f1237t = r4     // Catch:{ Exception -> 0x01da }
            com.uxcam.internals.fs r5 = new com.uxcam.internals.fs     // Catch:{ Exception -> 0x01da }
            r5.<init>(r4)     // Catch:{ Exception -> 0x01da }
            boolean r5 = r5.mo38470b()     // Catch:{ Exception -> 0x01da }
            if (r5 == 0) goto L_0x00cd
            java.lang.String r7 = "UXCam 3.3.0[501]"
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r7)     // Catch:{ Exception -> 0x01da }
        L_0x00cd:
            com.uxcam.internals.ab r7 = m1105a()     // Catch:{ Exception -> 0x01da }
            int r7 = r7.f1231d     // Catch:{ Exception -> 0x01da }
            if (r7 == r2) goto L_0x00d7
            r7 = 1
            goto L_0x00d8
        L_0x00d7:
            r7 = 0
        L_0x00d8:
            if (r5 != 0) goto L_0x00e2
            boolean r5 = com.uxcam.internals.C3170fn.f2290a     // Catch:{ Exception -> 0x01da }
            if (r5 != 0) goto L_0x00e2
            if (r7 == 0) goto L_0x00e2
            r5 = 1
            goto L_0x00e3
        L_0x00e2:
            r5 = 0
        L_0x00e3:
            if (r5 == 0) goto L_0x01ca
            if (r11 == 0) goto L_0x01ca
            boolean r11 = f1228v     // Catch:{ Exception -> 0x01da }
            if (r11 == 0) goto L_0x00f9
            java.lang.String r11 = "UXCam"
            com.uxcam.internals.bc$aa r11 = com.uxcam.internals.C2970bc.m1233a((java.lang.String) r11)     // Catch:{ Exception -> 0x01da }
            java.lang.String r5 = "UXCam 3.3.0[501] (Warning): Error in integration, UXCam.startWithKey(\"appKey\") is not called on the main thread. See integration docs for instruction."
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01da }
        L_0x00f5:
            r11.mo38070a((java.lang.String) r5, (java.lang.Object[]) r7)     // Catch:{ Exception -> 0x01da }
            goto L_0x0108
        L_0x00f9:
            boolean r11 = f1229w     // Catch:{ Exception -> 0x01da }
            if (r11 == 0) goto L_0x0108
            java.lang.String r11 = "UXCam"
            com.uxcam.internals.bc$aa r11 = com.uxcam.internals.C2970bc.m1233a((java.lang.String) r11)     // Catch:{ Exception -> 0x01da }
            java.lang.String r5 = "UXCam 3.3.0[501] (Warning): Error in integration, UXCam.startWithKey(\"appKey\") is not called from the onCreate() method of launching Activity. See integration docs for instruction."
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01da }
            goto L_0x00f5
        L_0x0108:
            java.lang.String r11 = f1224p     // Catch:{ Exception -> 0x01da }
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r11)     // Catch:{ Exception -> 0x01da }
            android.content.pm.PackageManager r11 = r4.getPackageManager()     // Catch:{ Exception -> 0x01da }
            android.content.ComponentName r5 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x0126 }
            java.lang.String r7 = r4.getPackageName()     // Catch:{ NameNotFoundException -> 0x0126 }
            java.lang.Class<com.uxcam.service.HttpPostService> r9 = com.uxcam.service.HttpPostService.class
            java.lang.String r9 = r9.getName()     // Catch:{ NameNotFoundException -> 0x0126 }
            r5.<init>(r7, r9)     // Catch:{ NameNotFoundException -> 0x0126 }
            r7 = 4
            r11.getServiceInfo(r5, r7)     // Catch:{ NameNotFoundException -> 0x0126 }
            r11 = 0
            goto L_0x0134
        L_0x0126:
            java.lang.String r11 = "UXCam 3.3.0[501]"
            com.uxcam.internals.bc$aa r11 = com.uxcam.internals.C2970bc.m1233a((java.lang.String) r11)     // Catch:{ Exception -> 0x01da }
            java.lang.String r5 = "HttpPostService service not included in project's manifest"
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01da }
            r11.mo38070a((java.lang.String) r5, (java.lang.Object[]) r7)     // Catch:{ Exception -> 0x01da }
            r11 = 1
        L_0x0134:
            java.lang.String r5 = f1215a     // Catch:{ Exception -> 0x01da }
            java.lang.String r7 = ""
            boolean r5 = r5.equals(r7)     // Catch:{ Exception -> 0x01da }
            if (r5 != 0) goto L_0x0142
            java.lang.String r5 = f1215a     // Catch:{ Exception -> 0x01da }
            if (r5 != 0) goto L_0x014c
        L_0x0142:
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01da }
            java.lang.String r5 = "No UXCam app key in UXCam.start(\"app_key\")"
            r11[r3] = r5     // Catch:{ Exception -> 0x01da }
            com.uxcam.internals.C2970bc.m1237b()     // Catch:{ Exception -> 0x01da }
            r11 = 1
        L_0x014c:
            java.lang.String[] r5 = com.uxcam.internals.C3183fy.f2315a     // Catch:{ Exception -> 0x0155 }
            boolean r5 = com.uxcam.internals.C3183fy.m2037a((java.lang.String[]) r5)     // Catch:{ Exception -> 0x0155 }
            if (r5 != 0) goto L_0x0162
            goto L_0x0161
        L_0x0155:
            r11 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01da }
            java.lang.String r11 = r11.getMessage()     // Catch:{ Exception -> 0x01da }
            r5[r3] = r11     // Catch:{ Exception -> 0x01da }
            com.uxcam.internals.C2970bc.m1237b()     // Catch:{ Exception -> 0x01da }
        L_0x0161:
            r11 = 1
        L_0x0162:
            float r5 = com.uxcam.internals.C3183fy.m2052g()     // Catch:{ Exception -> 0x01da }
            r7 = 1120403456(0x42c80000, float:100.0)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x017a
            java.lang.String r11 = "UXCam 3.3.0[501]"
            com.uxcam.internals.bc$aa r11 = com.uxcam.internals.C2970bc.m1233a((java.lang.String) r11)     // Catch:{ Exception -> 0x01da }
            java.lang.String r5 = "Unable to start session due to lack of storage"
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01da }
            r11.mo38070a((java.lang.String) r5, (java.lang.Object[]) r7)     // Catch:{ Exception -> 0x01da }
            r11 = 1
        L_0x017a:
            if (r11 != 0) goto L_0x01c2
            r1.f1232e = r2     // Catch:{ Exception -> 0x01da }
            java.lang.String r11 = f1215a     // Catch:{ Exception -> 0x01da }
            android.content.Context r5 = r1.f1237t     // Catch:{ Exception -> 0x01da }
            boolean r5 = com.uxcam.internals.C3169fm.m1993a(r5)     // Catch:{ Exception -> 0x01da }
            if (r5 == 0) goto L_0x01ba
            boolean r5 = com.uxcam.internals.C2952an.f1332p     // Catch:{ Exception -> 0x01da }
            if (r5 == 0) goto L_0x01af
            com.uxcam.internals.fz r5 = new com.uxcam.internals.fz     // Catch:{ Exception -> 0x01da }
            android.content.Context r7 = r1.f1237t     // Catch:{ Exception -> 0x01da }
            r5.<init>(r7)     // Catch:{ Exception -> 0x01da }
            java.lang.String r7 = com.uxcam.internals.C3184fz.f2321a     // Catch:{ Exception -> 0x01da }
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r7)     // Catch:{ Exception -> 0x01da }
            com.uxcam.internals.fz$1 r7 = new com.uxcam.internals.fz$1     // Catch:{ Exception -> 0x01da }
            r7.<init>()     // Catch:{ Exception -> 0x01da }
            com.uxcam.internals.C3170fn.f2291b = r2     // Catch:{ Exception -> 0x01da }
            com.uxcam.internals.fs r9 = new com.uxcam.internals.fs     // Catch:{ Exception -> 0x01ab }
            android.content.Context r10 = r5.f2322b     // Catch:{ Exception -> 0x01ab }
            r9.<init>(r10)     // Catch:{ Exception -> 0x01ab }
            java.lang.String r10 = "push_notification_token"
            r9.mo38463a((java.lang.String) r10)     // Catch:{ Exception -> 0x01ab }
        L_0x01ab:
            r5.mo38481a((java.lang.String) r11, (com.uxcam.internals.C2981bj) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x01da }
            goto L_0x01fa
        L_0x01af:
            com.uxcam.internals.fz r11 = new com.uxcam.internals.fz     // Catch:{ Exception -> 0x01da }
            android.content.Context r5 = r1.f1237t     // Catch:{ Exception -> 0x01da }
            r11.<init>(r5)     // Catch:{ Exception -> 0x01da }
        L_0x01b6:
            r11.mo38480a()     // Catch:{ Exception -> 0x01da }
            goto L_0x01fa
        L_0x01ba:
            com.uxcam.internals.fz r11 = new com.uxcam.internals.fz     // Catch:{ Exception -> 0x01da }
            android.content.Context r5 = r1.f1237t     // Catch:{ Exception -> 0x01da }
            r11.<init>(r5)     // Catch:{ Exception -> 0x01da }
            goto L_0x01b6
        L_0x01c2:
            java.lang.Exception r11 = new java.lang.Exception     // Catch:{ Exception -> 0x01da }
            java.lang.String r5 = "Pre-Condition validation failed"
            r11.<init>(r5)     // Catch:{ Exception -> 0x01da }
            throw r11     // Catch:{ Exception -> 0x01da }
        L_0x01ca:
            if (r11 != 0) goto L_0x01fa
            f1227u = r2     // Catch:{ Exception -> 0x01da }
            boolean r11 = com.uxcam.internals.C3170fn.f2290a     // Catch:{ Exception -> 0x01da }
            if (r11 != 0) goto L_0x01fa
            java.lang.String r11 = "UXCam 3.3.0[501] : Multi Session status FALSE"
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01da }
            com.uxcam.internals.C2970bc.m1236a(r11, r5)     // Catch:{ Exception -> 0x01da }
            goto L_0x01fa
        L_0x01da:
            r11 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0296 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0296 }
            java.lang.String r9 = "Exception while starting Uxcam :"
            r7.<init>(r9)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r11 = r11.getMessage()     // Catch:{ Exception -> 0x0296 }
            r7.append(r11)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r11 = r7.toString()     // Catch:{ Exception -> 0x0296 }
            r5[r3] = r11     // Catch:{ Exception -> 0x0296 }
            com.uxcam.internals.C2970bc.m1237b()     // Catch:{ Exception -> 0x0296 }
            com.uxcam.internals.ab r11 = m1105a()     // Catch:{ Exception -> 0x0296 }
            r11.f1231d = r6     // Catch:{ Exception -> 0x0296 }
        L_0x01fa:
            com.uxcam.internals.ap r11 = r1.f1234l     // Catch:{ Exception -> 0x0296 }
            java.lang.String r11 = r11.f1351a     // Catch:{ Exception -> 0x0296 }
            if (r11 == 0) goto L_0x0211
            com.uxcam.internals.fs r11 = new com.uxcam.internals.fs     // Catch:{ Exception -> 0x0296 }
            android.content.Context r5 = r1.f1237t     // Catch:{ Exception -> 0x0296 }
            r11.<init>(r5)     // Catch:{ Exception -> 0x0296 }
            com.uxcam.internals.ap r1 = r1.f1234l     // Catch:{ Exception -> 0x0296 }
            java.lang.String r1 = r1.f1351a     // Catch:{ Exception -> 0x0296 }
            java.lang.String r5 = "user_id"
            r11.mo38466a((java.lang.String) r5, (java.lang.String) r1)     // Catch:{ Exception -> 0x0296 }
            goto L_0x0222
        L_0x0211:
            com.uxcam.internals.ap r11 = r1.f1234l     // Catch:{ Exception -> 0x0296 }
            com.uxcam.internals.fs r5 = new com.uxcam.internals.fs     // Catch:{ Exception -> 0x0296 }
            android.content.Context r1 = r1.f1237t     // Catch:{ Exception -> 0x0296 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x0296 }
            java.lang.String r1 = "user_id"
            java.lang.String r1 = r5.mo38463a((java.lang.String) r1)     // Catch:{ Exception -> 0x0296 }
            r11.f1351a = r1     // Catch:{ Exception -> 0x0296 }
        L_0x0222:
            int r11 = com.uxcam.internals.C2952an.f1337u     // Catch:{ Exception -> 0x0296 }
            r1 = -1
            if (r11 != 0) goto L_0x0232
            com.uxcam.internals.fs r11 = new com.uxcam.internals.fs     // Catch:{ Exception -> 0x0296 }
            r11.<init>(r4)     // Catch:{ Exception -> 0x0296 }
            r11.mo38467a((boolean) r3)     // Catch:{ Exception -> 0x0296 }
        L_0x022f:
            com.uxcam.internals.C2952an.f1337u = r1     // Catch:{ Exception -> 0x0296 }
            goto L_0x023f
        L_0x0232:
            int r11 = com.uxcam.internals.C2952an.f1337u     // Catch:{ Exception -> 0x0296 }
            if (r11 != r2) goto L_0x023f
            com.uxcam.internals.fs r11 = new com.uxcam.internals.fs     // Catch:{ Exception -> 0x0296 }
            r11.<init>(r4)     // Catch:{ Exception -> 0x0296 }
            r11.mo38467a((boolean) r2)     // Catch:{ Exception -> 0x0296 }
            goto L_0x022f
        L_0x023f:
            android.app.Activity r11 = r0.f1255a     // Catch:{ Exception -> 0x0296 }
            r1 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r11 = r11.findViewById(r1)     // Catch:{ Exception -> 0x0296 }
            android.view.View r11 = r11.getRootView()     // Catch:{ Exception -> 0x0296 }
            android.view.ViewGroup r11 = (android.view.ViewGroup) r11     // Catch:{ Exception -> 0x0296 }
            com.uxcam.internals.C3203ge.m2117b((android.view.ViewGroup) r11)     // Catch:{ Exception -> 0x0296 }
            java.lang.ref.WeakReference r11 = com.uxcam.internals.C3196gd.f2361h     // Catch:{ Exception -> 0x0296 }
            if (r11 == 0) goto L_0x026d
            java.lang.ref.WeakReference r11 = com.uxcam.internals.C3196gd.f2361h     // Catch:{ Exception -> 0x0296 }
            java.lang.Object r11 = r11.get()     // Catch:{ Exception -> 0x0296 }
            if (r11 == 0) goto L_0x026d
            java.lang.ref.WeakReference r11 = com.uxcam.internals.C3196gd.f2361h     // Catch:{ Exception -> 0x0296 }
            java.lang.Object r11 = r11.get()     // Catch:{ Exception -> 0x0296 }
            android.webkit.WebView r11 = (android.webkit.WebView) r11     // Catch:{ Exception -> 0x0296 }
            com.uxcam.internals.af$1 r1 = new com.uxcam.internals.af$1     // Catch:{ Exception -> 0x0296 }
            r1.<init>()     // Catch:{ Exception -> 0x0296 }
            r11.post(r1)     // Catch:{ Exception -> 0x0296 }
        L_0x026d:
            java.lang.Thread r11 = new java.lang.Thread     // Catch:{ Exception -> 0x0296 }
            r11.<init>()     // Catch:{ Exception -> 0x0296 }
            r11.run()     // Catch:{ Exception -> 0x0296 }
            m1105a()     // Catch:{ Exception -> 0x0296 }
            com.uxcam.internals.aq r11 = new com.uxcam.internals.aq     // Catch:{ Exception -> 0x0296 }
            r11.<init>()     // Catch:{ Exception -> 0x0296 }
            boolean r11 = com.uxcam.internals.C2955aq.m1189a()     // Catch:{ Exception -> 0x0296 }
            if (r11 == 0) goto L_0x0296
            boolean r11 = com.uxcam.internals.C3170fn.f2290a     // Catch:{ Exception -> 0x0296 }
            if (r11 == 0) goto L_0x0296
            boolean r11 = f1219i     // Catch:{ Exception -> 0x0296 }
            if (r11 == 0) goto L_0x0296
            com.uxcam.internals.fk r11 = com.uxcam.internals.C3165fk.m1970a()     // Catch:{ Exception -> 0x0296 }
            android.content.Context r0 = com.uxcam.internals.C3183fy.m2030a()     // Catch:{ Exception -> 0x0296 }
            r11.mo38445a((android.content.Context) r0, (java.lang.String) r8, (boolean) r3)     // Catch:{ Exception -> 0x0296 }
        L_0x0296:
            android.view.Window r11 = r12.getWindow()     // Catch:{ Exception -> 0x02bd }
            android.view.Window$Callback r12 = r11.getCallback()     // Catch:{ Exception -> 0x02bd }
            if (r12 == 0) goto L_0x02b4
            java.lang.Class r0 = r12.getClass()     // Catch:{ Exception -> 0x02bd }
            java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x02bd }
            java.lang.Class<com.uxcam.internals.ag> r1 = com.uxcam.internals.C2942ag.class
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x02bd }
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x02bd }
            if (r0 != 0) goto L_0x02bc
        L_0x02b4:
            com.uxcam.internals.ag r0 = new com.uxcam.internals.ag     // Catch:{ Exception -> 0x02bd }
            r0.<init>(r12)     // Catch:{ Exception -> 0x02bd }
            r11.setCallback(r0)     // Catch:{ Exception -> 0x02bd }
        L_0x02bc:
            return
        L_0x02bd:
            r11 = move-exception
            r11.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C2928ab.m1120a(boolean, android.app.Activity):void");
    }

    /* renamed from: a */
    public static void m1121a(boolean z, boolean z2) {
        C3196gd.m2082a(z);
        C2952an.f1309L = !z2;
    }

    /* renamed from: b */
    public static void m1122b() {
        if (C3183fy.f2317c == null) {
            try {
                C3183fy.f2317c = m1155u();
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
                C2970bc.m1233a(f1224p);
            }
        }
    }

    /* renamed from: b */
    public static void m1123b(View view) {
        C3180fv fvVar = new C3180fv(true);
        fvVar.f2300b = new WeakReference(view);
        fvVar.f2301c = true;
        C3196gd.f2362i.add(fvVar);
    }

    /* renamed from: b */
    public static void m1124b(String str) {
        if (C3170fn.f2290a) {
            try {
                C3165fk.m1970a().mo38445a(C3183fy.m2030a(), str, true);
            } catch (Exception unused) {
            }
        } else {
            C3165fk.f2263i = str;
        }
    }

    /* renamed from: b */
    public static void m1125b(String str, String str2) {
        f1222n = str;
        f1223o = str2;
    }

    /* renamed from: b */
    public static void m1126b(List list) {
        C2952an.f1310M.removeAll(list);
    }

    /* renamed from: b */
    public static void m1127b(boolean z) {
        C2952an.f1339w = true;
        C2952an.f1340x = z;
        if (!z) {
            Iterator it = C3196gd.f2362i.iterator();
            while (it.hasNext()) {
                if (!((C3180fv) it.next()).f2299a) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: c */
    public static void m1128c() {
        try {
            if (f1215a == null || f1215a.isEmpty()) {
                C2970bc.m1233a(f1224p);
                return;
            }
            f1227u = true;
            m1139f(true);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public static void m1129c(View view) {
        if (!C3196gd.f2362i.isEmpty()) {
            Iterator it = C3196gd.f2362i.iterator();
            while (it.hasNext()) {
                C3181fw fwVar = (C3181fw) it.next();
                if (((View) fwVar.f2300b.get()).equals(view)) {
                    C3196gd.f2362i.remove(fwVar);
                }
            }
        }
    }

    /* renamed from: c */
    public static void m1130c(boolean z) {
        f1219i = z;
    }

    /* renamed from: d */
    public static void m1131d() {
        C2970bc.m1233a(f1224p);
        new Object[1][0] = "SESSION ENDED";
        f1227u = false;
        if (f1216b != null) {
            C2940af.m1167a();
        }
    }

    /* renamed from: d */
    public static void m1132d(String str) {
        C2952an.f1310M.add(str);
    }

    /* renamed from: d */
    public static void m1133d(boolean z) {
        f1218h = !z;
        m1122b();
        if (C3183fy.m2030a() != null) {
            new C3175fs(C3183fy.m2030a()).mo38467a(z);
        } else if (z) {
            C2952an.f1337u = 1;
        } else {
            C2952an.f1337u = 0;
        }
        if (!z) {
            C2952an.f1337u = 0;
            if (!C3170fn.f2290a) {
                UXCam.startNewSession();
            }
        } else if (C3170fn.f2290a) {
            UXCam.cancelCurrentSession();
            UXCam.stopSessionAndUploadData();
        }
    }

    /* renamed from: e */
    public static void m1134e() {
        f1227u = true;
        f1218h = false;
        m1105a();
        m1108a(C3183fy.m2030a());
    }

    /* renamed from: e */
    public static void m1135e(String str) {
        C2952an.f1310M.remove(str);
    }

    /* renamed from: e */
    public static void m1136e(boolean z) {
        C3196gd.f2360g = z ? 180000 : 0;
    }

    /* renamed from: f */
    public static C2940af m1137f() {
        return f1216b;
    }

    /* renamed from: f */
    public static void m1138f(String str) {
        m1122b();
        if (C3183fy.m2030a() != null) {
            new C3175fs(C3183fy.m2030a()).mo38466a("push_notification_token", str);
        }
    }

    @TargetApi(14)
    /* renamed from: f */
    private static void m1139f(boolean z) {
        m1154t();
        m1122b();
        C2970bc.m1233a("startWithKeyCalled");
        new StringBuilder("startWithKeyCalled : ").append(f1221k);
        Application application = (Application) C3183fy.m2030a();
        if (!z) {
            if (Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
                Context a = C3183fy.m2030a();
                f1229w = !m1141g(a.getPackageManager().getLaunchIntentForPackage(a.getPackageName()).getComponent().getClassName()) && !m1141g(C3183fy.m2030a().getClass().getName());
            } else {
                f1228v = true;
            }
        }
        if (f1215a.equalsIgnoreCase(new C3175fs(application).mo38463a("killed_app_key"))) {
            C2970bc.m1233a("UXCam");
            return;
        }
        if (!f1226r && Build.VERSION.SDK_INT >= 14) {
            f1226r = true;
            C2970bc.m1233a(f1224p);
            m1105a().f1236s = new C2937ae();
            application.registerActivityLifecycleCallbacks(m1105a().f1236s);
        }
        if (C3183fy.m2038b() != null && z && ((f1218h || f1227u) && Build.VERSION.SDK_INT >= 14)) {
            f1227u = false;
            m1120a(true, (Activity) C3183fy.m2038b());
        }
        if (!z) {
            return;
        }
        if ((f1218h || f1227u) && Build.VERSION.SDK_INT >= 14) {
            C2937ae aeVar = (C2937ae) m1105a().f1236s;
            if (aeVar.f1251a > 0) {
                f1227u = false;
                m1120a(true, (Activity) C3183fy.m2038b());
                return;
            }
            aeVar.f1252b = new C2937ae.C2939aa() {
                /* renamed from: a */
                public final void mo37992a(Activity activity) {
                    boolean unused = C2928ab.f1227u = false;
                    C2928ab.m1120a(true, activity);
                }
            };
        }
    }

    /* renamed from: g */
    public static void m1140g() {
        boolean isEmpty = HttpPostService.f2930c.isEmpty();
        File[] listFiles = new File(C2958as.m1199b()).listFiles();
        boolean z = (listFiles != null && listFiles.length == 0) && HttpPostService.f2929b;
        if (!isEmpty && !z) {
            StringBuilder sb = new StringBuilder("Notification NOT stopped isSendingFilesEmpty : ");
            sb.append(isEmpty);
            sb.append(" isRootFolderEmptyAndServiceRunning : false");
            C2970bc.m1233a(f1224p);
        } else if (!C3170fn.f2290a) {
            C2970bc.m1233a(f1224p);
            new Object[1][0] = "Notification stopped isSendingFilesEmpty : " + isEmpty + " isRootFolderEmptyAndServiceRunning : " + z;
            C2970bc.m1233a("UXCamHelper");
            C3183fy.m2030a().stopService(new Intent(C3183fy.m2030a(), HttpPostService.class));
            if (z) {
                C2970bc.m1233a("UXCam").mo38070a("UXCam 3.3.0[501] : session data sent successfully", new Object[0]);
            } else {
                C2970bc.m1233a("UXCam");
            }
        }
    }

    /* renamed from: g */
    private static boolean m1141g(String str) {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getClassName().equals(str) && stackTraceElement.getMethodName().equals("onCreate")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    public static String m1142h() {
        return C2952an.f1329m;
    }

    /* renamed from: i */
    public static String m1143i() {
        return C2952an.f1328l;
    }

    /* renamed from: j */
    public static boolean m1144j() {
        return C3170fn.f2290a;
    }

    /* renamed from: k */
    public static void m1145k() {
        m1122b();
        if (C3183fy.m2030a() != null) {
            new C3175fs(C3183fy.m2030a()).mo38469b(false);
        }
    }

    /* renamed from: l */
    public static void m1146l() {
        m1122b();
        if (C3183fy.m2030a() != null) {
            new C3175fs(C3183fy.m2030a()).mo38469b(true);
        }
        if (C3170fn.f2290a) {
            C2956ar.f1355a = true;
        }
    }

    /* renamed from: m */
    public static boolean m1147m() {
        if (C3183fy.m2030a() == null) {
            m1122b();
        }
        return !new C3175fs(C3183fy.m2030a()).mo38471c();
    }

    /* renamed from: n */
    public static boolean m1148n() {
        if (C3183fy.m2030a() == null) {
            m1122b();
        }
        return !new C3175fs(C3183fy.m2030a()).mo38470b();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:4|5|6|7) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0012 */
    /* renamed from: o */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m1149o() {
        /*
            r0 = 1
            com.uxcam.internals.fu r1 = new com.uxcam.internals.fu     // Catch:{ Exception -> 0x0024 }
            android.content.Context r2 = com.uxcam.internals.C3183fy.m2030a()     // Catch:{ Exception -> 0x0024 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0024 }
            boolean r2 = com.uxcam.internals.C2952an.f1332p     // Catch:{ Exception -> 0x0024 }
            if (r2 == 0) goto L_0x0015
            r1.mo38476a((boolean) r0)     // Catch:{ Exception -> 0x0012 }
            goto L_0x0015
        L_0x0012:
            com.uxcam.internals.C2970bc.m1238c()     // Catch:{ Exception -> 0x0024 }
        L_0x0015:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x0024 }
            r1.<init>()     // Catch:{ Exception -> 0x0024 }
            android.content.Context r2 = com.uxcam.internals.C3183fy.m2030a()     // Catch:{ Exception -> 0x0024 }
            java.lang.String r3 = "deletePendingUploadApiCalled"
            com.uxcam.internals.C3171fo.m1998a(r2, r3, r1)     // Catch:{ Exception -> 0x0024 }
            return
        L_0x0024:
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            java.lang.String r2 = "Exception in deletePending Uploads"
            r0[r1] = r2
            com.uxcam.internals.C2970bc.m1237b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C2928ab.m1149o():void");
    }

    /* renamed from: p */
    public static void m1150p() {
        C3196gd.f2360g = 0;
    }

    /* renamed from: q */
    public static void m1151q() {
        C2952an.f1310M = new TreeSet();
    }

    /* renamed from: r */
    public static List m1152r() {
        return new ArrayList(C2952an.f1310M);
    }

    /* renamed from: t */
    private static void m1154t() {
        if (!f1221k) {
            f1221k = true;
            C2970bc.m1235a((C2970bc.C2972aa) new C2973bd());
            C2970bc.m1233a("UXCam");
        }
    }

    /* renamed from: u */
    private static Application m1155u() {
        Application application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke((Object) null, (Object[]) null);
        C2970bc.m1233a(f1224p);
        new StringBuilder("Context is ").append(application);
        return application;
    }

    /* renamed from: a */
    public final void mo37988a(OnVerificationListener onVerificationListener) {
        this.f1233f.removeAll(this.f1233f);
        this.f1233f.add(onVerificationListener);
    }

    /* renamed from: a */
    public final void mo37989a(String str, Object obj) {
        this.f1234l.mo38051a(str, obj);
    }

    /* renamed from: b */
    public final void mo37990b(String str, Object obj) {
        if (C3183fy.m2041c() > 0.0f) {
            this.f1235m.mo38049a(str, obj);
            return;
        }
        C2970bc.m1233a("UXCam.setSessionProperty()").mo38070a("UXCam:setSessionProperty: No session is being recorded - session property ‘%s’ will be ignored", str);
    }

    /* renamed from: c */
    public final void mo37991c(String str) {
        if (this.f1237t == null) {
            this.f1234l.f1351a = str;
        } else if (this.f1234l.f1351a == null || str == null || str.equals(this.f1234l.f1351a)) {
            this.f1234l.f1351a = str;
            new C3175fs(this.f1237t).mo38466a(AmplitudeClient.USER_ID_KEY, this.f1234l.f1351a);
        } else {
            C2954ap apVar = new C2954ap(str);
            if (C3170fn.f2290a) {
                m1134e();
                UXCam.startNewSession();
                apVar.f1353c = new C2954ap(str);
            }
            this.f1234l = apVar;
        }
    }
}
