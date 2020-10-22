package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* renamed from: com.uxcam.internals.jv */
public final class C3313jv {

    /* renamed from: a */
    protected long f2843a;

    /* renamed from: b */
    protected C3230ha f2844b;

    /* renamed from: c */
    private List f2845c;

    /* renamed from: d */
    private int f2846d;

    public C3313jv(C3230ha haVar, C3247hq hqVar) {
        this(haVar, hqVar.f2558c);
    }

    private C3313jv(C3230ha haVar, C3272im imVar) {
        this.f2845c = new ArrayList();
        this.f2846d = 1;
        this.f2844b = haVar;
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        imVar.mo38541b(allocate);
        new C3277ir("wide", 8).mo38545a(allocate);
        new C3277ir("mdat", 1).mo38545a(allocate);
        this.f2843a = (long) allocate.position();
        allocate.putLong(0);
        allocate.flip();
        haVar.write(allocate);
    }

    /* renamed from: a */
    public static C3307jr m2350a(String str, C3242hl hlVar, String str2) {
        return new C3307jr(new C3277ir(str), "jcod", (short) hlVar.f2543a, (short) hlVar.f2544b, str2);
    }

    /* renamed from: a */
    private void m2351a(C3283ix ixVar) {
        C3249hs.m2234a(this.f2844b, ixVar);
        this.f2844b.mo38508a(this.f2843a);
        C3229gz.m2203a((WritableByteChannel) this.f2844b, (this.f2844b.mo38507a() - this.f2843a) + 8);
    }

    /* renamed from: b */
    private C3283ix m2352b() {
        C3283ix ixVar = new C3283ix();
        C3284iy d = m2354d();
        ixVar.mo38547a(d);
        for (C3310jt a : this.f2845c) {
            C3255hx a2 = a.mo38552a(d);
            if (a2 != null) {
                ixVar.mo38546a(a2);
            }
        }
        return ixVar;
    }

    /* renamed from: c */
    private C3310jt m2353c() {
        for (C3310jt jtVar : this.f2845c) {
            if (jtVar.mo38558c()) {
                return jtVar;
            }
        }
        return null;
    }

    /* renamed from: d */
    private C3284iy m2354d() {
        int b = ((C3310jt) this.f2845c.get(0)).mo38556b();
        long a = ((C3310jt) this.f2845c.get(0)).mo38551a();
        C3310jt c = m2353c();
        if (c != null) {
            b = c.mo38556b();
            a = c.mo38551a();
        }
        return new C3284iy(b, a, new Date().getTime(), new Date().getTime(), new int[]{65536, 0, 0, 0, 65536, 0, 0, 0, 1073741824}, this.f2846d);
    }

    /* renamed from: a */
    public final C3312ju mo38561a(C3251hu huVar) {
        C3230ha haVar = this.f2844b;
        int i = this.f2846d;
        this.f2846d = i + 1;
        C3312ju juVar = new C3312ju(haVar, i, huVar);
        this.f2845c.add(juVar);
        return juVar;
    }

    /* renamed from: a */
    public final void mo38562a() {
        m2351a(m2352b());
    }
}
