package com.google.android.play.core.assetpacks;

/* renamed from: com.google.android.play.core.assetpacks.bv */
final class C1890bv extends RuntimeException {

    /* renamed from: a */
    final int f477a;

    C1890bv(String str) {
        super(str);
        this.f477a = -1;
    }

    C1890bv(String str, int i) {
        super(str);
        this.f477a = i;
    }

    C1890bv(String str, Exception exc) {
        super(str, exc);
        this.f477a = -1;
    }

    C1890bv(String str, Exception exc, int i) {
        super(str, exc);
        this.f477a = i;
    }
}
