package com.uxcam.internals;

import com.uxcam.internals.C3005bx;
import com.uxcam.internals.C3022cf;
import java.net.ProtocolException;

/* renamed from: com.uxcam.internals.cz */
public final class C3050cz implements C3005bx {

    /* renamed from: a */
    private final boolean f1884a;

    public C3050cz(boolean z) {
        this.f1884a = z;
    }

    /* renamed from: a */
    public final C3022cf mo38068a(C3005bx.C3006aa aaVar) {
        C3022cf cfVar;
        C3056de deVar = (C3056de) aaVar;
        C3051da daVar = deVar.f1890b;
        C3047cx cxVar = deVar.f1889a;
        C3017cd a = aaVar.mo38137a();
        long currentTimeMillis = System.currentTimeMillis();
        daVar.mo38231a(a);
        if (C3055dd.m1507b(a.f1724b) && a.f1726d != null) {
            C3131eo a2 = C3138ev.m1862a(daVar.mo38229a(a, a.f1726d.mo38106b()));
            a.f1726d.mo38105a(a2);
            a2.close();
        }
        daVar.mo38230a();
        C3022cf.C3023aa b = daVar.mo38232b();
        b.f1753a = a;
        b.f1757e = cxVar.mo38224b().f1848c;
        b.f1763k = currentTimeMillis;
        b.f1764l = System.currentTimeMillis();
        C3022cf a3 = b.mo38185a();
        int i = a3.f1742c;
        if (!this.f1884a || i != 101) {
            C3022cf.C3023aa b2 = a3.mo38177b();
            b2.f1759g = daVar.mo38228a(a3);
            cfVar = b2.mo38185a();
        } else {
            C3022cf.C3023aa b3 = a3.mo38177b();
            b3.f1759g = C3030cl.f1782c;
            cfVar = b3.mo38185a();
        }
        if ("close".equalsIgnoreCase(cfVar.f1740a.mo38166a("Connection")) || "close".equalsIgnoreCase(cfVar.mo38178b("Connection"))) {
            cxVar.mo38223a(true, false, false);
        }
        if ((i != 204 && i != 205) || cfVar.f1746g.mo38188b() <= 0) {
            return cfVar;
        }
        throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + cfVar.f1746g.mo38188b());
    }
}
