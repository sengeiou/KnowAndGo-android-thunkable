package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.am */
final class C1989am extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ IBinder f734a;

    /* renamed from: b */
    final /* synthetic */ C1991ao f735b;

    C1989am(C1991ao aoVar, IBinder iBinder) {
        this.f735b = aoVar;
        this.f734a = iBinder;
    }

    /* renamed from: a */
    public final void mo33272a() {
        C1992ap apVar = this.f735b.f737a;
        apVar.f749l = (IInterface) apVar.f745h.mo33271a(this.f734a);
        C1992ap.m609f(this.f735b.f737a);
        this.f735b.f737a.f743f = false;
        for (Runnable run : this.f735b.f737a.f742e) {
            run.run();
        }
        this.f735b.f737a.f742e.clear();
    }
}
