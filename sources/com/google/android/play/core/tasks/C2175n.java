package com.google.android.play.core.tasks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.play.core.tasks.n */
final class C2175n implements OnSuccessListener, OnFailureListener {

    /* renamed from: a */
    private final CountDownLatch f1040a = new CountDownLatch(1);

    private C2175n() {
    }

    /* synthetic */ C2175n(byte[] bArr) {
    }

    /* renamed from: a */
    public final void mo33816a() throws InterruptedException {
        this.f1040a.await();
    }

    /* renamed from: a */
    public final boolean mo33817a(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f1040a.await(j, timeUnit);
    }

    public final void onFailure(Exception exc) {
        this.f1040a.countDown();
    }

    public final void onSuccess(Object obj) {
        this.f1040a.countDown();
    }
}
