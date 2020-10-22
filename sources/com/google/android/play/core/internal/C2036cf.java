package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.cf */
final class C2036cf extends C2033cc {

    /* renamed from: a */
    private final C2035ce f775a = new C2035ce();

    C2036cf() {
    }

    /* renamed from: a */
    public final void mo33602a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.f775a.mo33605a(th).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
