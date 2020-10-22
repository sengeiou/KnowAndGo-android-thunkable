package com.google.android.play.core.assetpacks;

/* renamed from: com.google.android.play.core.assetpacks.di */
final /* synthetic */ class C1931di implements Runnable {

    /* renamed from: a */
    private final C1870bb f611a;

    private C1931di(C1870bb bbVar) {
        this.f611a = bbVar;
    }

    /* renamed from: a */
    static Runnable m486a(C1870bb bbVar) {
        return new C1931di(bbVar);
    }

    public final void run() {
        this.f611a.mo33387c();
    }
}
