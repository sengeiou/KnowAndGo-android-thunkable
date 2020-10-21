package com.uxcam.internals;

import java.util.concurrent.CountDownLatch;

/* renamed from: com.uxcam.internals.dw */
final class C3103dw {

    /* renamed from: a */
    final CountDownLatch f2098a = new CountDownLatch(1);

    /* renamed from: b */
    long f2099b = -1;

    /* renamed from: c */
    long f2100c = -1;

    C3103dw() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo38306a() {
        if (this.f2100c != -1 || this.f2099b == -1) {
            throw new IllegalStateException();
        }
        this.f2100c = this.f2099b - 1;
        this.f2098a.countDown();
    }
}
