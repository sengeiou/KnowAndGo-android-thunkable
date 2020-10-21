package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.c */
final class C2164c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f1020a;

    /* renamed from: b */
    final /* synthetic */ C2165d f1021b;

    C2164c(C2165d dVar, Task task) {
        this.f1021b = dVar;
        this.f1020a = task;
    }

    public final void run() {
        synchronized (this.f1021b.f1023b) {
            if (this.f1021b.f1024c != null) {
                this.f1021b.f1024c.onFailure(this.f1020a.getException());
            }
        }
    }
}
