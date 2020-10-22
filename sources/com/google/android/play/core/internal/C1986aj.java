package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.aj */
final class C1986aj extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ C1992ap f733a;

    C1986aj(C1992ap apVar) {
        this.f733a = apVar;
    }

    /* renamed from: a */
    public final void mo33272a() {
        if (this.f733a.f749l != null) {
            this.f733a.f740c.mo33553c("Unbind from service.", new Object[0]);
            this.f733a.f739b.unbindService(this.f733a.f748k);
            this.f733a.f743f = false;
            this.f733a.f749l = null;
            this.f733a.f748k = null;
        }
    }
}
