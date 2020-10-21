package com.google.android.play.core.tasks;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.d */
final class C2165d<ResultT> implements C2168g<ResultT> {

    /* renamed from: a */
    private final Executor f1022a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f1023b = new Object();
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c */
    public final OnFailureListener f1024c;

    public C2165d(Executor executor, OnFailureListener onFailureListener) {
        this.f1022a = executor;
        this.f1024c = onFailureListener;
    }

    /* renamed from: a */
    public final void mo33800a(Task<ResultT> task) {
        if (!task.isSuccessful()) {
            synchronized (this.f1023b) {
                if (this.f1024c != null) {
                    this.f1022a.execute(new C2164c(this, task));
                }
            }
        }
    }
}
