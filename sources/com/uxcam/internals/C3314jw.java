package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: com.uxcam.internals.jw */
public final class C3314jw extends C3312ju {

    /* renamed from: o */
    List f2847o;

    /* renamed from: p */
    private C3243hm f2848p;

    /* renamed from: q */
    private C3243hm f2849q;

    /* renamed from: r */
    private int f2850r;

    /* renamed from: s */
    private long f2851s;

    /* renamed from: t */
    private long f2852t;

    /* renamed from: u */
    private int f2853u;

    /* renamed from: v */
    private List f2854v;

    /* renamed from: a */
    private static int m2357a(C3243hm hmVar) {
        return (hmVar.f2545a * 3600) + (hmVar.f2546b * 60) + hmVar.f2547c;
    }

    /* renamed from: a */
    private static int m2358a(C3243hm hmVar, int i) {
        int a = (m2357a(hmVar) * i) + hmVar.f2548d;
        return hmVar.f2549e ? (int) (((long) a) - ((((long) (a / 18000)) * 18) + (((((long) (a % 18000)) - 2) / 1800) * 2))) : a;
    }

    /* renamed from: f */
    private void m2359f() {
        if (this.f2851s <= 0) {
            return;
        }
        if (this.f2849q != null) {
            if (this.f2850r == -1) {
                this.f2850r = this.f2848p.f2548d + 1;
            }
            boolean z = this.f2849q.f2549e;
            int i = this.f2850r;
            this.f2823l.add(new C3301jm(z ? 1 : 0, this.f2814c, (int) (this.f2851s / ((long) this.f2853u)), i));
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(m2358a(this.f2849q, this.f2850r));
            allocate.flip();
            mo38560a(new C3248hr(allocate, this.f2852t, (long) this.f2814c, this.f2851s, 0, this.f2852t, this.f2823l.size() - 1));
            this.f2854v.add(new C3268ii(this.f2851s, this.f2852t));
            return;
        }
        this.f2854v.add(new C3268ii(this.f2851s, -1));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.util.List} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.uxcam.internals.C3255hx mo38552a(com.uxcam.internals.C3284iy r12) {
        /*
            r11 = this;
            r11.mo38563e()
            r11.m2359f()
            java.util.List r0 = r11.f2823l
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0010
            r12 = 0
            return r12
        L_0x0010:
            java.util.List r0 = r11.f2824m
            if (r0 == 0) goto L_0x006a
            com.uxcam.internals.hj r0 = new com.uxcam.internals.hj
            r1 = 1
            r0.<init>(r1, r1)
            java.util.List r1 = r11.f2854v
            java.util.List r2 = r11.f2824m
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r1)
            java.util.Iterator r1 = r2.iterator()
        L_0x002c:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0067
            java.lang.Object r2 = r1.next()
            com.uxcam.internals.ii r2 = (com.uxcam.internals.C3268ii) r2
            long r5 = r2.f2640b
            int r7 = r0.f2537a
            long r7 = (long) r7
            long r7 = r7 * r5
            int r5 = r0.f2538b
            long r5 = (long) r5
            long r7 = r7 / r5
            com.uxcam.internals.hj r5 = r0.mo38530a()
            com.uxcam.internals.jx$aa r4 = com.uxcam.internals.C3316jx.m2362a(r4, r5, r7)
            java.lang.Object r4 = r4.f2857b
            java.util.List r4 = (java.util.List) r4
            com.uxcam.internals.hj r5 = r0.mo38530a()
            long r9 = r2.f2639a
            long r7 = r7 + r9
            com.uxcam.internals.jx$aa r2 = com.uxcam.internals.C3316jx.m2362a(r4, r5, r7)
            java.lang.Object r4 = r2.f2856a
            java.util.Collection r4 = (java.util.Collection) r4
            r3.addAll(r4)
            java.lang.Object r2 = r2.f2857b
            r4 = r2
            java.util.List r4 = (java.util.List) r4
            goto L_0x002c
        L_0x0067:
            r11.f2824m = r3
            goto L_0x006e
        L_0x006a:
            java.util.List r0 = r11.f2854v
            r11.f2824m = r0
        L_0x006e:
            com.uxcam.internals.hx r12 = super.mo38552a((com.uxcam.internals.C3284iy) r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3314jw.mo38552a(com.uxcam.internals.iy):com.uxcam.internals.hx");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
        if (r7 != 1) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0082, code lost:
        if (r3.f2548d == (r9.f2850r - 1)) goto L_0x0086;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a5 A[SYNTHETIC] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo38563e() {
        /*
            r9 = this;
            java.util.List r0 = r9.f2847o
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00b8
            java.util.List r0 = r9.f2847o
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            com.uxcam.internals.jw$1 r0 = new com.uxcam.internals.jw$1
            r0.<init>()
            java.util.Collections.sort(r1, r0)
            java.util.Iterator r0 = r1.iterator()
        L_0x001b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00b3
            java.lang.Object r1 = r0.next()
            com.uxcam.internals.hh r1 = (com.uxcam.internals.C3238hh) r1
            com.uxcam.internals.hm r2 = r1.f2528e
            com.uxcam.internals.hm r3 = r9.f2848p
            r4 = -1
            r5 = 0
            r6 = 1
            if (r3 != 0) goto L_0x0032
            if (r2 != 0) goto L_0x0084
        L_0x0032:
            if (r3 == 0) goto L_0x0086
            if (r2 == 0) goto L_0x0084
            boolean r7 = r3.f2549e
            boolean r8 = r2.f2549e
            if (r7 != r8) goto L_0x0084
            int r7 = m2357a((com.uxcam.internals.C3243hm) r2)
            int r8 = m2357a((com.uxcam.internals.C3243hm) r3)
            int r8 = r7 - r8
            if (r8 != 0) goto L_0x005a
            byte r7 = r2.f2548d
            byte r3 = r3.f2548d
            int r7 = r7 - r3
            int r3 = r9.f2850r
            if (r3 == r4) goto L_0x0057
            int r3 = r9.f2850r
            int r7 = r7 + r3
            int r3 = r9.f2850r
            int r7 = r7 % r3
        L_0x0057:
            if (r7 == r6) goto L_0x0086
            goto L_0x0084
        L_0x005a:
            if (r8 != r6) goto L_0x0084
            int r8 = r9.f2850r
            if (r8 != r4) goto L_0x006a
            byte r7 = r2.f2548d
            if (r7 != 0) goto L_0x0084
            byte r3 = r3.f2548d
            int r3 = r3 + r6
            r9.f2850r = r3
            goto L_0x0086
        L_0x006a:
            boolean r8 = r2.f2549e
            if (r8 == 0) goto L_0x0078
            int r8 = r7 % 60
            if (r8 != 0) goto L_0x0078
            int r7 = r7 % 600
            if (r7 == 0) goto L_0x0078
            r7 = 2
            goto L_0x0079
        L_0x0078:
            r7 = 0
        L_0x0079:
            byte r8 = r2.f2548d
            if (r8 != r7) goto L_0x0084
            byte r3 = r3.f2548d
            int r7 = r9.f2850r
            int r7 = r7 - r6
            if (r3 == r7) goto L_0x0086
        L_0x0084:
            r3 = 1
            goto L_0x0087
        L_0x0086:
            r3 = 0
        L_0x0087:
            r9.f2848p = r2
            if (r3 == 0) goto L_0x00a5
            r9.m2359f()
            r9.f2849q = r2
            boolean r2 = r2.f2549e
            if (r2 == 0) goto L_0x0096
            r4 = 30
        L_0x0096:
            r9.f2850r = r4
            long r2 = r9.f2852t
            long r7 = r9.f2851s
            long r2 = r2 + r7
            r9.f2852t = r2
            r2 = 0
            r9.f2851s = r2
            r9.f2853u = r5
        L_0x00a5:
            long r2 = r9.f2851s
            long r4 = r1.f2526c
            long r2 = r2 + r4
            r9.f2851s = r2
            int r1 = r9.f2853u
            int r1 = r1 + r6
            r9.f2853u = r1
            goto L_0x001b
        L_0x00b3:
            java.util.List r0 = r9.f2847o
            r0.clear()
        L_0x00b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3314jw.mo38563e():void");
    }
}
