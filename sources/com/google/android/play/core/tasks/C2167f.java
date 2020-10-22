package com.google.android.play.core.tasks;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.f */
final class C2167f<ResultT> implements C2168g<ResultT> {

    /* renamed from: a */
    private final Executor f1027a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f1028b = new Object();
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c */
    public final OnSuccessListener<? super ResultT> f1029c;

    public C2167f(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.f1027a = executor;
        this.f1029c = onSuccessListener;
    }

    /* renamed from: a */
    public final void mo33800a(Task<ResultT> task) {
        if (task.isSuccessful()) {
            synchronized (this.f1028b) {
                if (this.f1029c != null) {
                    this.f1027a.execute(new C2166e(this, task));
                }
            }
        }
    }
}
