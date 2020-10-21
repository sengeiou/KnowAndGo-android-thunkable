package com.uxcam.internals;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.uxcam.internals.bt */
public final class C2997bt extends C3019ce {

    /* renamed from: a */
    private static final C3007by f1597a = C3007by.m1329a("application/x-www-form-urlencoded");

    /* renamed from: b */
    private final List f1598b;

    /* renamed from: c */
    private final List f1599c;

    /* renamed from: com.uxcam.internals.bt$aa */
    public static final class C2998aa {

        /* renamed from: a */
        private final List f1600a = new ArrayList();

        /* renamed from: b */
        private final List f1601b = new ArrayList();

        /* renamed from: a */
        public final C2998aa mo38107a(String str, String str2) {
            this.f1600a.add(C3002bw.m1297a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.f1601b.add(C3002bw.m1297a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        /* renamed from: a */
        public final C2997bt mo38108a() {
            return new C2997bt(this.f1600a, this.f1601b);
        }
    }

    C2997bt(List list, List list2) {
        this.f1598b = C3030cl.m1424a(list);
        this.f1599c = C3030cl.m1424a(list2);
    }

    /* renamed from: a */
    private long m1277a(C3131eo eoVar, boolean z) {
        C3130en enVar = z ? new C3130en() : eoVar.mo38362b();
        int size = this.f1598b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                enVar.mo38387h(38);
            }
            enVar.mo38364b((String) this.f1598b.get(i));
            enVar.mo38387h(61);
            enVar.mo38364b((String) this.f1599c.get(i));
        }
        if (!z) {
            return 0;
        }
        long j = enVar.f2158b;
        enVar.mo38398o();
        return j;
    }

    /* renamed from: a */
    public final C3007by mo38104a() {
        return f1597a;
    }

    /* renamed from: a */
    public final void mo38105a(C3131eo eoVar) {
        m1277a(eoVar, false);
    }

    /* renamed from: b */
    public final long mo38106b() {
        return m1277a((C3131eo) null, true);
    }
}
