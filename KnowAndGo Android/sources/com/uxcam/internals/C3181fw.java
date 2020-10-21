package com.uxcam.internals;

import android.graphics.Rect;
import java.lang.ref.WeakReference;

/* renamed from: com.uxcam.internals.fw */
public class C3181fw {

    /* renamed from: b */
    public WeakReference f2300b;

    /* renamed from: c */
    public boolean f2301c;

    /* renamed from: d */
    public Rect f2302d = new Rect();

    /* renamed from: e */
    public int f2303e;

    /* renamed from: f */
    public boolean f2304f = false;

    /* renamed from: g */
    public boolean f2305g = false;

    /* renamed from: h */
    public boolean f2306h;

    /* renamed from: i */
    public boolean f2307i;

    /* renamed from: j */
    public boolean f2308j;

    /* renamed from: k */
    public boolean f2309k;

    /* renamed from: l */
    public boolean f2310l = false;

    /* renamed from: m */
    public boolean f2311m = false;

    /* renamed from: n */
    public boolean f2312n = false;

    public C3181fw() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0054, code lost:
        if (com.uxcam.internals.C3176ft.m2021a("mOnCheckedChangeListener", (java.lang.Object) r4) != null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0061, code lost:
        if (com.uxcam.internals.C3176ft.m2021a("mOnSeekBarChangeListener", (java.lang.Object) r4) != null) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C3181fw(android.view.View r4) {
        /*
            r3 = this;
            r3.<init>()
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r3.f2302d = r0
            r0 = 0
            r3.f2304f = r0
            r3.f2305g = r0
            r3.f2310l = r0
            r3.f2311m = r0
            r3.f2312n = r0
            android.graphics.Rect r0 = r3.f2302d
            r4.getGlobalVisibleRect(r0)
            boolean r0 = r4.isEnabled()
            r3.f2305g = r0
            boolean r0 = r4.isClickable()
            r3.f2304f = r0
            r0 = 1
            boolean r1 = r4.canScrollVertically(r0)
            r3.f2306h = r1
            r1 = -1
            boolean r2 = r4.canScrollVertically(r1)
            r3.f2307i = r2
            boolean r1 = r4.canScrollHorizontally(r1)
            r3.f2308j = r1
            boolean r1 = r4.canScrollHorizontally(r0)
            r3.f2309k = r1
            boolean r1 = r4 instanceof android.view.ViewGroup
            r3.f2310l = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r1 < r2) goto L_0x0070
            boolean r1 = r4 instanceof android.widget.CompoundButton
            if (r1 == 0) goto L_0x0057
            java.lang.String r1 = "mOnCheckedChangeListener"
            java.lang.Object r1 = com.uxcam.internals.C3176ft.m2021a((java.lang.String) r1, (java.lang.Object) r4)
            if (r1 == 0) goto L_0x006a
        L_0x0056:
            goto L_0x0068
        L_0x0057:
            boolean r1 = r4 instanceof android.widget.SeekBar
            if (r1 == 0) goto L_0x0064
            java.lang.String r1 = "mOnSeekBarChangeListener"
            java.lang.Object r1 = com.uxcam.internals.C3176ft.m2021a((java.lang.String) r1, (java.lang.Object) r4)
            if (r1 == 0) goto L_0x006a
            goto L_0x0056
        L_0x0064:
            boolean r0 = r4.hasOnClickListeners()
        L_0x0068:
            r3.f2312n = r0
        L_0x006a:
            boolean r0 = r4.isScrollContainer()
            r3.f2311m = r0
        L_0x0070:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r4)
            r3.f2300b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3181fw.<init>(android.view.View):void");
    }

    /* renamed from: a */
    public final boolean mo38479a() {
        return this.f2306h || this.f2307i || this.f2308j || this.f2309k;
    }
}
