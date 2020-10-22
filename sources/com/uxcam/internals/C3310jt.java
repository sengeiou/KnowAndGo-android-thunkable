package com.uxcam.internals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.uxcam.internals.jt */
public abstract class C3310jt {

    /* renamed from: a */
    protected int f2812a;

    /* renamed from: b */
    protected C3251hu f2813b;

    /* renamed from: c */
    protected int f2814c;

    /* renamed from: d */
    protected C3240hj f2815d;

    /* renamed from: e */
    protected int f2816e;

    /* renamed from: f */
    protected long f2817f;

    /* renamed from: g */
    protected List f2818g = new ArrayList();

    /* renamed from: h */
    protected List f2819h = new ArrayList();

    /* renamed from: i */
    protected int f2820i = -1;

    /* renamed from: j */
    protected int f2821j = 0;

    /* renamed from: k */
    protected boolean f2822k;

    /* renamed from: l */
    protected List f2823l = new ArrayList();

    /* renamed from: m */
    protected List f2824m;

    /* renamed from: n */
    String f2825n;

    /* renamed from: com.uxcam.internals.jt$1 */
    static /* synthetic */ class C33111 {

        /* renamed from: a */
        static final /* synthetic */ int[] f2826a = new int[C3251hu.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.uxcam.internals.hu[] r0 = com.uxcam.internals.C3251hu.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2826a = r0
                int[] r0 = f2826a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.uxcam.internals.hu r1 = com.uxcam.internals.C3251hu.VIDEO     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f2826a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.uxcam.internals.hu r1 = com.uxcam.internals.C3251hu.SOUND     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f2826a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.uxcam.internals.hu r1 = com.uxcam.internals.C3251hu.TIMECODE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3310jt.C33111.<clinit>():void");
        }
    }

    public C3310jt(int i, C3251hu huVar) {
        this.f2812a = i;
        this.f2813b = huVar;
        this.f2814c = 1;
    }

    /* renamed from: a */
    public abstract long mo38551a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C3255hx mo38552a(C3284iy iyVar);

    /* renamed from: a */
    public final void mo38553a(C3240hj hjVar, int i) {
        this.f2815d = hjVar;
        this.f2816e = i;
    }

    /* renamed from: a */
    public final void mo38554a(C3292jf jfVar) {
        if (!this.f2822k) {
            this.f2823l.add(jfVar);
            return;
        }
        throw new IllegalStateException("The muxer track has finished muxing");
    }

    /* renamed from: a */
    public final void mo38555a(C3304jo joVar) {
        C3242hl d = mo38559d();
        if (this.f2813b == C3251hu.VIDEO) {
            C3286ja jaVar = new C3286ja(new C3277ir("tapt"));
            jaVar.mo38546a((C3255hx) new C3260ic(d.f2543a, d.f2544b));
            jaVar.mo38546a((C3255hx) new C3289jd(d.f2543a, d.f2544b));
            jaVar.mo38546a((C3255hx) new C3270ik(d.f2543a, d.f2544b));
            joVar.mo38546a((C3255hx) jaVar);
        }
    }

    /* renamed from: b */
    public final int mo38556b() {
        return this.f2814c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo38557b(C3304jo joVar) {
        if (this.f2824m != null) {
            C3286ja jaVar = new C3286ja(new C3277ir("edts"));
            jaVar.mo38546a((C3255hx) new C3269ij(this.f2824m));
            joVar.mo38546a((C3255hx) jaVar);
        }
    }

    /* renamed from: c */
    public final boolean mo38558c() {
        return this.f2813b == C3251hu.VIDEO;
    }

    /* renamed from: d */
    public final C3242hl mo38559d() {
        short s;
        int i = 0;
        if (this.f2823l.get(0) instanceof C3307jr) {
            C3307jr jrVar = (C3307jr) this.f2823l.get(0);
            Class<C3288jc> cls = C3288jc.class;
            String[] strArr = {C3288jc.m2304a()};
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 <= 0; i2++) {
                linkedList2.add(strArr[0]);
            }
            C3255hx.m2243a(jrVar, linkedList2, linkedList);
            Object[] array = linkedList.toArray((Object[]) Array.newInstance(cls, 0));
            C3288jc jcVar = array.length > 0 ? array[0] : null;
            C3240hj hjVar = jcVar != null ? new C3240hj(jcVar.f2687a, jcVar.f2688b) : new C3240hj(1, 1);
            i = (hjVar.f2537a * jrVar.f2732a) / hjVar.f2538b;
            s = jrVar.f2733b;
        } else {
            s = 0;
        }
        return new C3242hl(i, s);
    }
}
