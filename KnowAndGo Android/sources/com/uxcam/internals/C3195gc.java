package com.uxcam.internals;

import android.graphics.Bitmap;
import java.util.Timer;

/* renamed from: com.uxcam.internals.gc */
public class C3195gc {

    /* renamed from: a */
    public static int f2343a = 0;

    /* renamed from: b */
    public static Bitmap f2344b = null;

    /* renamed from: c */
    public static Bitmap f2345c = null;

    /* renamed from: d */
    public static boolean f2346d = false;

    /* renamed from: e */
    public static Timer f2347e = null;

    /* renamed from: f */
    public static int f2348f = -1;

    /* renamed from: g */
    public static boolean f2349g = false;

    /* renamed from: h */
    private static String f2350h = "gc";

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d2 A[Catch:{ Exception -> 0x013a }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap m2077a() {
        /*
            android.content.Context r0 = com.uxcam.internals.C3183fy.m2038b()
            android.app.Activity r0 = (android.app.Activity) r0
            android.content.res.Resources r1 = r0.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.orientation
            int r2 = f2348f
            r3 = 0
            if (r2 == r1) goto L_0x003c
            boolean r2 = f2349g
            if (r2 != 0) goto L_0x003c
            f2348f = r1
            java.lang.String r1 = "scrolltest 2"
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "ORIENTATION CHANGED, waitingToStop "
            r1.<init>(r2)
            boolean r2 = f2349g
            r1.append(r2)
            com.uxcam.internals.fk r1 = com.uxcam.internals.C3165fk.m1970a()
            com.uxcam.internals.fl r1 = r1.f2268b
            r2 = 10
            r4 = 0
            r1.mo38452a(r2, r4, r4)
            com.uxcam.internals.C3203ge.f2390c = r3
            com.uxcam.internals.C3196gd.f2365l = r3
        L_0x003c:
            boolean r1 = f2349g
            if (r1 == 0) goto L_0x0043
            android.graphics.Bitmap r0 = f2344b
            return r0
        L_0x0043:
            android.content.res.Resources r1 = r0.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            int r2 = r1.widthPixels
            int r1 = r1.heightPixels
            r4 = 1
            if (r2 <= r1) goto L_0x0054
            r1 = 1
            goto L_0x0055
        L_0x0054:
            r1 = 0
        L_0x0055:
            if (r1 == 0) goto L_0x0060
            int r2 = com.uxcam.internals.C3196gd.m2083b()
            int r5 = com.uxcam.internals.C3196gd.m2086c()
            goto L_0x0068
        L_0x0060:
            int r2 = com.uxcam.internals.C3196gd.m2086c()
            int r5 = com.uxcam.internals.C3196gd.m2083b()
        L_0x0068:
            android.graphics.Bitmap r6 = f2344b
            if (r6 != 0) goto L_0x0074
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r5, r2, r6)
            f2344b = r6
        L_0x0074:
            android.graphics.Bitmap r6 = f2344b
            int r6 = r6.getHeight()
            if (r6 == r2) goto L_0x0084
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r5, r2, r6)
            f2344b = r2
        L_0x0084:
            com.uxcam.internals.ge r2 = new com.uxcam.internals.ge     // Catch:{ Exception -> 0x013a }
            r2.<init>()     // Catch:{ Exception -> 0x013a }
            android.graphics.Bitmap r5 = f2344b     // Catch:{ Exception -> 0x013a }
            if (r0 == 0) goto L_0x0132
            com.uxcam.internals.C3203ge.m2109a((android.app.Activity) r0)     // Catch:{ Exception -> 0x013a }
            boolean r6 = com.uxcam.internals.C3196gd.m2091g()     // Catch:{ Exception -> 0x013a }
            if (r6 != 0) goto L_0x009d
            boolean r6 = com.uxcam.internals.C2934ad.f1242b     // Catch:{ Exception -> 0x013a }
            if (r6 == 0) goto L_0x009b
            goto L_0x009d
        L_0x009b:
            r6 = 0
            goto L_0x009e
        L_0x009d:
            r6 = 1
        L_0x009e:
            boolean r7 = com.uxcam.internals.C3203ge.f2388a     // Catch:{ Exception -> 0x013a }
            com.uxcam.internals.C3203ge.f2388a = r6     // Catch:{ Exception -> 0x013a }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013a }
            java.lang.String r9 = "to occlude check for "
            r8.<init>(r9)     // Catch:{ Exception -> 0x013a }
            java.lang.Class r9 = r0.getClass()     // Catch:{ Exception -> 0x013a }
            java.lang.String r9 = r9.getSimpleName()     // Catch:{ Exception -> 0x013a }
            r8.append(r9)     // Catch:{ Exception -> 0x013a }
            java.lang.String r9 = ", result:  "
            r8.append(r9)     // Catch:{ Exception -> 0x013a }
            java.lang.Class r9 = r0.getClass()     // Catch:{ Exception -> 0x013a }
            java.lang.String r9 = r9.getSimpleName()     // Catch:{ Exception -> 0x013a }
            boolean r9 = com.uxcam.internals.C3203ge.m2115a((java.lang.String) r9)     // Catch:{ Exception -> 0x013a }
            r8.append(r9)     // Catch:{ Exception -> 0x013a }
            java.lang.String r9 = ", firstFrameAfterOcclude: "
            r8.append(r9)     // Catch:{ Exception -> 0x013a }
            r8.append(r7)     // Catch:{ Exception -> 0x013a }
            if (r7 != 0) goto L_0x0127
            if (r6 == 0) goto L_0x00d5
            goto L_0x0127
        L_0x00d5:
            r6 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r6 = r0.findViewById(r6)     // Catch:{ Exception -> 0x013a }
            android.view.View r6 = r6.getRootView()     // Catch:{ Exception -> 0x013a }
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6     // Catch:{ Exception -> 0x013a }
            java.util.concurrent.CountDownLatch r7 = new java.util.concurrent.CountDownLatch     // Catch:{ Exception -> 0x013a }
            r7.<init>(r4)     // Catch:{ Exception -> 0x013a }
            com.uxcam.internals.C3203ge.f2389b = r7     // Catch:{ Exception -> 0x013a }
            com.uxcam.internals.C3203ge.m2114a((boolean) r3)     // Catch:{ Exception -> 0x013a }
            java.lang.String r3 = "io.flutter.app.FlutterApplication"
            boolean r3 = com.uxcam.internals.C3183fy.m2036a((java.lang.String) r3)     // Catch:{ Exception -> 0x013a }
            if (r3 == 0) goto L_0x00f9
            com.uxcam.internals.C3203ge.m2112a((android.view.ViewGroup) r6)     // Catch:{ Exception -> 0x013a }
            com.uxcam.internals.C2952an.f1316S = r4     // Catch:{ Exception -> 0x013a }
        L_0x00f9:
            java.util.List r3 = r2.mo38497b((android.app.Activity) r0)     // Catch:{ Exception -> 0x013a }
            android.os.Looper r6 = android.os.Looper.myLooper()     // Catch:{ Exception -> 0x013a }
            android.os.Looper r7 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x013a }
            if (r6 != r7) goto L_0x010b
            r2.mo38496a((java.util.List) r3, (android.graphics.Bitmap) r5)     // Catch:{ Exception -> 0x013a }
            goto L_0x011f
        L_0x010b:
            java.util.concurrent.CountDownLatch r6 = new java.util.concurrent.CountDownLatch     // Catch:{ Exception -> 0x013a }
            r6.<init>(r4)     // Catch:{ Exception -> 0x013a }
            com.uxcam.internals.ge$2 r4 = new com.uxcam.internals.ge$2     // Catch:{ Exception -> 0x013a }
            r4.<init>(r3, r5, r6)     // Catch:{ Exception -> 0x013a }
            r0.runOnUiThread(r4)     // Catch:{ Exception -> 0x013a }
            r2 = 350(0x15e, double:1.73E-321)
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x013a }
            r6.await(r2, r0)     // Catch:{ Exception -> 0x013a }
        L_0x011f:
            boolean r0 = com.uxcam.internals.C2952an.f1313P     // Catch:{ Exception -> 0x013a }
            if (r0 == 0) goto L_0x0149
            com.uxcam.internals.C3154fg.m1953a()     // Catch:{ Exception -> 0x013a }
            goto L_0x0149
        L_0x0127:
            android.graphics.Canvas r0 = new android.graphics.Canvas     // Catch:{ Exception -> 0x013a }
            r0.<init>(r5)     // Catch:{ Exception -> 0x013a }
            r2 = -65536(0xffffffffffff0000, float:NaN)
            r0.drawColor(r2)     // Catch:{ Exception -> 0x013a }
            goto L_0x0149
        L_0x0132:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x013a }
            java.lang.String r2 = "Parameter activity cannot be null."
            r0.<init>(r2)     // Catch:{ Exception -> 0x013a }
            throw r0     // Catch:{ Exception -> 0x013a }
        L_0x013a:
            r0 = move-exception
            r0.printStackTrace()
            android.graphics.Paint r0 = new android.graphics.Paint
            r0.<init>()
            r2 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r0.setColor(r2)
        L_0x0149:
            if (r1 != 0) goto L_0x014e
            android.graphics.Bitmap r0 = f2344b
            return r0
        L_0x014e:
            android.graphics.Matrix r6 = new android.graphics.Matrix
            r6.<init>()
            r0 = 1119092736(0x42b40000, float:90.0)
            r6.postRotate(r0)
            android.graphics.Bitmap r1 = f2344b
            r2 = 0
            r3 = 0
            android.graphics.Bitmap r0 = f2344b
            int r4 = r0.getWidth()
            android.graphics.Bitmap r0 = f2344b
            int r5 = r0.getHeight()
            r7 = 1
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r1, r2, r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3195gc.m2077a():android.graphics.Bitmap");
    }

    /* renamed from: a */
    public static void m2078a(boolean z) {
        if (!z) {
            try {
                int size = C3196gd.f2354a.size();
                if (size < 10) {
                    f2343a++;
                    f2344b = m2077a();
                    int e = C3196gd.m2089e();
                    C2970bc.m1233a(f2350h);
                    StringBuilder sb = new StringBuilder("vtest imagecount is ");
                    sb.append(f2343a);
                    sb.append(" frametime: ");
                    sb.append(e);
                    if (f2344b != null) {
                        C3196gd.f2354a.add(new C2950al(f2344b, size, f2343a));
                        Bitmap bitmap = f2344b;
                        f2344b = bitmap.copy(bitmap.getConfig(), true);
                        return;
                    }
                    return;
                }
                f2343a++;
                if (f2344b != null) {
                    C3196gd.f2354a.add(new C2950al(f2344b, size, f2343a));
                    Bitmap bitmap2 = f2344b;
                    f2344b = bitmap2.copy(bitmap2.getConfig(), true);
                }
            } catch (Exception unused) {
            }
        } else {
            if (!C3196gd.f2356c) {
                if (C3196gd.f2368o == 0) {
                    f2344b = m2077a();
                } else {
                    C3196gd.f2368o--;
                    C2970bc.m1233a(f2350h);
                }
            }
            f2346d = false;
        }
    }
}
