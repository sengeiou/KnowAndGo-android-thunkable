package com.uxcam.internals;

import android.content.Context;
import android.os.Handler;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.uxcam.internals.aa */
public class C2923aa {

    /* renamed from: a */
    public static final String f1199a = "aa";

    /* renamed from: b */
    public static long f1200b;

    /* renamed from: g */
    private static volatile C2923aa f1201g;

    /* renamed from: c */
    public Context f1202c;

    /* renamed from: d */
    public C2943ah f1203d;

    /* renamed from: e */
    public Timer f1204e;

    /* renamed from: f */
    public TimerTask f1205f;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final Handler f1206h = new Handler();

    private C2923aa() {
    }

    /* renamed from: a */
    public static C2923aa m1096a() {
        if (f1201g == null) {
            synchronized (C2923aa.class) {
                if (f1201g == null) {
                    f1201g = new C2923aa();
                }
            }
        }
        return f1201g;
    }

    /* renamed from: b */
    public static long m1098b() {
        return f1200b;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m1100b(String str, boolean z, Context context) {
        try {
            if (C2952an.f1332p) {
                C3171fo.m1998a(C3183fy.m2030a(), "WriteDataFile", new HashMap());
                File a = new C2956ar(str).mo38052a();
                C2970bc.m1233a(f1199a);
                if (a != null && !z) {
                    new C2964ay().mo38061a(context, a);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b6, code lost:
        if (r15.isEmpty() == false) goto L_0x00b8;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x00ad */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo37983a(android.content.Context r14, java.lang.String r15) {
        /*
            r13 = this;
            boolean r0 = r15.isEmpty()     // Catch:{ Exception -> 0x00c1 }
            r1 = 1
            r0 = r0 ^ r1
            r8 = 0
            com.uxcam.internals.C3170fn.f2290a = r8     // Catch:{ Exception -> 0x00c1 }
            java.util.Timer r2 = r13.f1204e     // Catch:{ Exception -> 0x00c1 }
            r9 = 0
            if (r2 == 0) goto L_0x0015
            java.util.Timer r2 = r13.f1204e     // Catch:{ Exception -> 0x00c1 }
            r2.cancel()     // Catch:{ Exception -> 0x00c1 }
            r13.f1204e = r9     // Catch:{ Exception -> 0x00c1 }
        L_0x0015:
            com.uxcam.internals.ah r2 = r13.f1203d     // Catch:{ Exception -> 0x00c1 }
            r2.f1263c = r8     // Catch:{ Exception -> 0x00c1 }
            r13.f1203d = r9     // Catch:{ Exception -> 0x00c1 }
            com.uxcam.internals.C3196gd.m2085b((boolean) r8)     // Catch:{ Exception -> 0x00c1 }
            com.uxcam.internals.C3196gd.f2361h = r9     // Catch:{ Exception -> 0x00c1 }
            com.uxcam.internals.C3203ge.f2388a = r8     // Catch:{ Exception -> 0x00c1 }
            java.util.TreeSet r2 = new java.util.TreeSet     // Catch:{ Exception -> 0x00c1 }
            r2.<init>()     // Catch:{ Exception -> 0x00c1 }
            com.uxcam.internals.C2952an.f1311N = r2     // Catch:{ Exception -> 0x00c1 }
            java.util.TreeSet r2 = new java.util.TreeSet     // Catch:{ Exception -> 0x00c1 }
            r2.<init>()     // Catch:{ Exception -> 0x00c1 }
            com.uxcam.internals.C2952an.f1312O = r2     // Catch:{ Exception -> 0x00c1 }
            boolean r2 = com.uxcam.internals.C2928ab.f1220j     // Catch:{ Exception -> 0x00c1 }
            if (r2 == 0) goto L_0x0042
            com.uxcam.internals.fs r2 = new com.uxcam.internals.fs     // Catch:{ Exception -> 0x00c1 }
            android.content.Context r3 = r13.f1202c     // Catch:{ Exception -> 0x00c1 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r3 = com.uxcam.internals.C2952an.f1318b     // Catch:{ Exception -> 0x00c1 }
            r2.mo38468b((java.lang.String) r3)     // Catch:{ Exception -> 0x00c1 }
            com.uxcam.internals.C2928ab.f1220j = r8     // Catch:{ Exception -> 0x00c1 }
        L_0x0042:
            java.lang.String r2 = f1199a     // Catch:{ Exception -> 0x00c1 }
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r2)     // Catch:{ Exception -> 0x00c1 }
            boolean r2 = com.uxcam.internals.C2952an.f1323g     // Catch:{ Exception -> 0x00c1 }
            if (r2 == 0) goto L_0x00b8
            com.uxcam.internals.fs r2 = new com.uxcam.internals.fs     // Catch:{ Exception -> 0x00c1 }
            android.content.Context r3 = r13.f1202c     // Catch:{ Exception -> 0x00c1 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00c1 }
            android.content.SharedPreferences r3 = r2.f2294a     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r4 = "recorded_video_count"
            int r3 = r3.getInt(r4, r8)     // Catch:{ Exception -> 0x00c1 }
            android.content.SharedPreferences r2 = r2.f2294a     // Catch:{ Exception -> 0x00c1 }
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r4 = "recorded_video_count"
            int r3 = r3 + r1
            android.content.SharedPreferences$Editor r2 = r2.putInt(r4, r3)     // Catch:{ Exception -> 0x00c1 }
            r2.apply()     // Catch:{ Exception -> 0x00c1 }
            java.util.concurrent.CountDownLatch r10 = new java.util.concurrent.CountDownLatch     // Catch:{ Exception -> 0x00c1 }
            r10.<init>(r1)     // Catch:{ Exception -> 0x00c1 }
            com.uxcam.internals.gd r11 = com.uxcam.internals.C3196gd.m2079a()     // Catch:{ Exception -> 0x00c1 }
            com.uxcam.internals.aa$2 r12 = new com.uxcam.internals.aa$2     // Catch:{ Exception -> 0x00c1 }
            r2 = r12
            r3 = r13
            r4 = r10
            r5 = r15
            r6 = r0
            r7 = r14
            r2.<init>(r4, r5, r6, r7)     // Catch:{ Exception -> 0x00c1 }
            r11.f2381t = r12     // Catch:{ Exception -> 0x00c1 }
            com.uxcam.internals.C3196gd.f2358e = r8     // Catch:{ Exception -> 0x00c1 }
            com.uxcam.internals.C3196gd.f2355b = r1     // Catch:{ Exception -> 0x00c1 }
            java.util.Timer r1 = r11.f2379r     // Catch:{ Exception -> 0x00c1 }
            if (r1 == 0) goto L_0x008f
            java.util.Timer r1 = r11.f2379r     // Catch:{ Exception -> 0x00c1 }
            r1.cancel()     // Catch:{ Exception -> 0x00c1 }
            r11.f2379r = r9     // Catch:{ Exception -> 0x00c1 }
        L_0x008f:
            java.util.Timer r1 = com.uxcam.internals.C3195gc.f2347e     // Catch:{ Exception -> 0x00c1 }
            if (r1 == 0) goto L_0x009a
            java.util.Timer r1 = com.uxcam.internals.C3195gc.f2347e     // Catch:{ Exception -> 0x00c1 }
            r1.cancel()     // Catch:{ Exception -> 0x00c1 }
            com.uxcam.internals.C3195gc.f2347e = r9     // Catch:{ Exception -> 0x00c1 }
        L_0x009a:
            boolean r1 = com.uxcam.internals.C3196gd.f2369p     // Catch:{ Exception -> 0x00c1 }
            if (r1 != 0) goto L_0x00a3
            com.uxcam.internals.gg r1 = com.uxcam.internals.C3196gd.f2357d     // Catch:{ Exception -> 0x00c1 }
            r11.mo38490a((com.uxcam.internals.C3210gg) r1)     // Catch:{ Exception -> 0x00c1 }
        L_0x00a3:
            com.uxcam.internals.C3196gd.f2356c = r8     // Catch:{ Exception -> 0x00c1 }
            r1 = 10
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x00ad }
            r10.await(r1, r3)     // Catch:{ InterruptedException -> 0x00ad }
            goto L_0x00b2
        L_0x00ad:
            java.lang.String r1 = f1199a     // Catch:{ Exception -> 0x00c1 }
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r1)     // Catch:{ Exception -> 0x00c1 }
        L_0x00b2:
            boolean r1 = r15.isEmpty()     // Catch:{ Exception -> 0x00c1 }
            if (r1 != 0) goto L_0x00bb
        L_0x00b8:
            m1100b(r15, r0, r14)     // Catch:{ Exception -> 0x00c1 }
        L_0x00bb:
            java.lang.String r14 = f1199a     // Catch:{ Exception -> 0x00c1 }
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r14)     // Catch:{ Exception -> 0x00c1 }
            return
        L_0x00c1:
            java.lang.String r14 = f1199a
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C2923aa.mo37983a(android.content.Context, java.lang.String):void");
    }
}
