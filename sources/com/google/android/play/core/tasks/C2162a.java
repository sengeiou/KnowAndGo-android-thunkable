package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.a */
final class C2162a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f1015a;

    /* renamed from: b */
    final /* synthetic */ C2163b f1016b;

    C2162a(C2163b bVar, Task task) {
        this.f1016b = bVar;
        this.f1015a = task;
    }

    public final void run() {
        synchronized (this.f1016b.f1018b) {
            if (this.f1016b.f1019c != null) {
                this.f1016b.f1019c.onComplete(this.f1015a);
            }
        }
    }
}
