package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.C2042cl;
import com.google.android.play.core.internal.C2044cn;

/* renamed from: com.google.android.play.core.appupdate.y */
public final class C1840y {

    /* renamed from: a */
    private C2044cn<Context> f287a;

    /* renamed from: b */
    private C2044cn<C1833r> f288b = C2042cl.m743a(new C1834s(this.f287a));

    /* renamed from: c */
    private C2044cn<C1831p> f289c = C2042cl.m743a(new C1832q(this.f287a, this.f288b));

    /* renamed from: d */
    private C2044cn<C1816a> f290d = C2042cl.m743a(new C1817b(this.f287a));

    /* renamed from: e */
    private C2044cn<C1820e> f291e = C2042cl.m743a(new C1821f(this.f289c, this.f290d, this.f287a));

    /* renamed from: f */
    private C2044cn<AppUpdateManager> f292f = C2042cl.m743a(new C1823h(this.f291e));

    /* synthetic */ C1840y(C1822g gVar) {
        this.f287a = new C1824i(gVar);
    }

    /* renamed from: a */
    public final AppUpdateManager mo33305a() {
        return this.f292f.mo33266a();
    }
}
