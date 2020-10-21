package com.uxcam.internals;

import com.uxcam.internals.C3005bx;
import com.uxcam.internals.C3022cf;

/* renamed from: com.uxcam.internals.bb */
public final class C2969bb implements C3005bx {
    /* renamed from: a */
    public final C3022cf mo38068a(C3005bx.C3006aa aaVar) {
        C3017cd a = aaVar.mo38137a();
        long nanoTime = System.nanoTime();
        C2970bc.m1233a("UXOkHttp");
        String.format("--> Sending request %s", new Object[]{a.f1723a});
        C3022cf a2 = aaVar.mo38138a(a);
        long nanoTime2 = System.nanoTime();
        C2970bc.m1233a("UXOkHttp");
        String.format("<-- Received response for %s in %.1fms%n%s", new Object[]{a2.f1740a.f1723a, Double.valueOf(((double) (nanoTime2 - nanoTime)) / 1000000.0d), a2.f1745f});
        C3007by a3 = a2.f1746g.mo38187a();
        String d = a2.f1746g.mo38191d();
        C2970bc.m1233a("UXOkHttp");
        C3024cg a4 = C3024cg.m1398a(a3, d);
        C3022cf.C3023aa b = a2.mo38177b();
        b.f1759g = a4;
        return b.mo38185a();
    }
}
