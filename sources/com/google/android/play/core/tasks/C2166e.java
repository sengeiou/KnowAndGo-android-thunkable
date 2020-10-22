package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.e */
final class C2166e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f1025a;

    /* renamed from: b */
    final /* synthetic */ C2167f f1026b;

    C2166e(C2167f fVar, Task task) {
        this.f1026b = fVar;
        this.f1025a = task;
    }

    public final void run() {
        synchronized (this.f1026b.f1028b) {
            if (this.f1026b.f1029c != null) {
                this.f1026b.f1029c.onSuccess(this.f1025a.getResult());
            }
        }
    }
}
