package com.uxcam.internals;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.ScaleGestureDetector;

/* renamed from: com.uxcam.internals.af */
public class C2940af {

    /* renamed from: b */
    private static final String f1254b = "af";

    /* renamed from: a */
    public Activity f1255a;

    /* renamed from: c */
    private GestureDetector f1256c;

    /* renamed from: d */
    private ScaleGestureDetector f1257d;

    public C2940af(Activity activity) {
        this.f1255a = activity;
    }

    /* renamed from: a */
    public static void m1167a() {
        try {
            C2928ab.m1105a();
            C2928ab.m1108a(C3183fy.m2030a());
            C2970bc.m1233a(f1254b);
        } catch (Exception unused) {
            C2970bc.m1233a(f1254b);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031 A[SYNTHETIC, Splitter:B:8:0x0031] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo38010a(android.view.MotionEvent r4) {
        /*
            r3 = this;
            android.view.GestureDetector r0 = r3.f1256c
            if (r0 == 0) goto L_0x000a
        L_0x0004:
            android.view.GestureDetector r0 = r3.f1256c
            r0.onTouchEvent(r4)
            goto L_0x002d
        L_0x000a:
            com.uxcam.internals.fk r0 = com.uxcam.internals.C3165fk.m1970a()
            com.uxcam.internals.fl r0 = r0.f2268b
            if (r0 == 0) goto L_0x002d
            android.view.GestureDetector r0 = new android.view.GestureDetector
            android.content.Context r1 = com.uxcam.internals.C3183fy.m2030a()
            com.uxcam.internals.fk r2 = com.uxcam.internals.C3165fk.m1970a()
            com.uxcam.internals.fl r2 = r2.f2268b
            r0.<init>(r1, r2)
            com.uxcam.internals.fk r1 = com.uxcam.internals.C3165fk.m1970a()
            com.uxcam.internals.fl r1 = r1.f2268b
            r0.setOnDoubleTapListener(r1)
            r3.f1256c = r0
            goto L_0x0004
        L_0x002d:
            android.view.ScaleGestureDetector r0 = r3.f1257d
            if (r0 == 0) goto L_0x003d
            android.view.ScaleGestureDetector r0 = r3.f1257d     // Catch:{ Exception -> 0x0037 }
            r0.onTouchEvent(r4)     // Catch:{ Exception -> 0x0037 }
            return
        L_0x0037:
            java.lang.String r4 = "UXCamActivityData -> dispatchTouchEvent"
            com.uxcam.internals.C2970bc.m1233a((java.lang.String) r4)
            return
        L_0x003d:
            com.uxcam.internals.fk r0 = com.uxcam.internals.C3165fk.m1970a()
            com.uxcam.internals.fl r0 = r0.f2268b
            if (r0 == 0) goto L_0x0059
            android.view.ScaleGestureDetector r0 = new android.view.ScaleGestureDetector
            android.content.Context r1 = com.uxcam.internals.C3183fy.m2030a()
            com.uxcam.internals.fk r2 = com.uxcam.internals.C3165fk.m1970a()
            com.uxcam.internals.fl r2 = r2.f2268b
            r0.<init>(r1, r2)
            r3.f1257d = r0
            r0.onTouchEvent(r4)
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C2940af.mo38010a(android.view.MotionEvent):void");
    }
}
