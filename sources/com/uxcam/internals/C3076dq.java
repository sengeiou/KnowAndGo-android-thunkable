package com.uxcam.internals;

import com.uxcam.internals.C3000bv;
import com.uxcam.internals.C3022cf;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: com.uxcam.internals.dq */
public final class C3076dq implements C3051da {

    /* renamed from: b */
    private static final C3133eq f1970b = C3133eq.m1828a("connection");

    /* renamed from: c */
    private static final C3133eq f1971c = C3133eq.m1828a("host");

    /* renamed from: d */
    private static final C3133eq f1972d = C3133eq.m1828a("keep-alive");

    /* renamed from: e */
    private static final C3133eq f1973e = C3133eq.m1828a("proxy-connection");

    /* renamed from: f */
    private static final C3133eq f1974f = C3133eq.m1828a("transfer-encoding");

    /* renamed from: g */
    private static final C3133eq f1975g = C3133eq.m1828a("te");

    /* renamed from: h */
    private static final C3133eq f1976h = C3133eq.m1828a("encoding");

    /* renamed from: i */
    private static final C3133eq f1977i = C3133eq.m1828a("upgrade");

    /* renamed from: j */
    private static final List f1978j = C3030cl.m1425a((Object[]) new C3133eq[]{f1970b, f1971c, f1972d, f1973e, f1975g, f1974f, f1976h, f1977i, C3071dn.f1939c, C3071dn.f1940d, C3071dn.f1941e, C3071dn.f1942f});

    /* renamed from: k */
    private static final List f1979k = C3030cl.m1425a((Object[]) new C3133eq[]{f1970b, f1971c, f1972d, f1973e, f1975g, f1974f, f1976h, f1977i});

    /* renamed from: a */
    final C3047cx f1980a;

    /* renamed from: l */
    private final C3011ca f1981l;

    /* renamed from: m */
    private final C3078dr f1982m;

    /* renamed from: n */
    private C3096dt f1983n;

    /* renamed from: com.uxcam.internals.dq$aa */
    class C3077aa extends C3134er {
        public C3077aa(C3148fc fcVar) {
            super(fcVar);
        }

        public final void close() {
            C3076dq.this.f1980a.mo38222a(false, (C3051da) C3076dq.this);
            super.close();
        }
    }

    public C3076dq(C3011ca caVar, C3047cx cxVar, C3078dr drVar) {
        this.f1981l = caVar;
        this.f1980a = cxVar;
        this.f1982m = drVar;
    }

    /* renamed from: a */
    public final C3024cg mo38228a(C3022cf cfVar) {
        return new C3057df(cfVar.f1745f, C3138ev.m1863a((C3148fc) new C3077aa(this.f1983n.f2065f)));
    }

    /* renamed from: a */
    public final C3147fb mo38229a(C3017cd cdVar, long j) {
        return this.f1983n.mo38285d();
    }

    /* renamed from: a */
    public final void mo38230a() {
        this.f1983n.mo38285d().close();
    }

    /* renamed from: a */
    public final void mo38231a(C3017cd cdVar) {
        if (this.f1983n == null) {
            boolean z = cdVar.f1726d != null;
            C3000bv bvVar = cdVar.f1725c;
            ArrayList arrayList = new ArrayList((bvVar.f1606a.length / 2) + 4);
            arrayList.add(new C3071dn(C3071dn.f1939c, cdVar.f1724b));
            arrayList.add(new C3071dn(C3071dn.f1940d, C3058dg.m1515a(cdVar.f1723a)));
            arrayList.add(new C3071dn(C3071dn.f1942f, C3030cl.m1420a(cdVar.f1723a, false)));
            arrayList.add(new C3071dn(C3071dn.f1941e, cdVar.f1723a.f1609a));
            int length = bvVar.f1606a.length / 2;
            for (int i = 0; i < length; i++) {
                C3133eq a = C3133eq.m1828a(bvVar.mo38112a(i).toLowerCase(Locale.US));
                if (!f1978j.contains(a)) {
                    arrayList.add(new C3071dn(a, bvVar.mo38114b(i)));
                }
            }
            this.f1983n = this.f1982m.mo38254a((List) arrayList, z);
            this.f1983n.f2067h.mo38421a((long) this.f1981l.f1683z, TimeUnit.MILLISECONDS);
            this.f1983n.f2068i.mo38421a((long) this.f1981l.f1658A, TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: b */
    public final C3022cf.C3023aa mo38232b() {
        List c = this.f1983n.mo38283c();
        C3000bv.C3001aa aaVar = new C3000bv.C3001aa();
        int size = c.size();
        String str = null;
        for (int i = 0; i < size; i++) {
            C3133eq eqVar = ((C3071dn) c.get(i)).f1943g;
            String a = ((C3071dn) c.get(i)).f1944h.mo38404a();
            if (eqVar.equals(C3071dn.f1938b)) {
                str = a;
            } else if (!f1979k.contains(eqVar)) {
                C3028cj.f1778a.mo38151a(aaVar, eqVar.mo38404a(), a);
            }
        }
        if (str != null) {
            C3060di a2 = C3060di.m1521a("HTTP/1.1 ".concat(String.valueOf(str)));
            C3022cf.C3023aa aaVar2 = new C3022cf.C3023aa();
            aaVar2.f1754b = C3014cb.HTTP_2;
            aaVar2.f1755c = a2.f1904b;
            aaVar2.f1756d = a2.f1905c;
            return aaVar2.mo38182a(aaVar.mo38120a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }
}
