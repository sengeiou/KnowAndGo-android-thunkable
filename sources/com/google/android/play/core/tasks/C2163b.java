package com.google.android.play.core.tasks;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.b */
final class C2163b<ResultT> implements C2168g<ResultT> {

    /* renamed from: a */
    private final Executor f1017a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f1018b = new Object();
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c */
    public final OnCompleteListener<ResultT> f1019c;

    public C2163b(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.f1017a = executor;
        this.f1019c = onCompleteListener;
    }

    /* renamed from: a */
    public final void mo33800a(Task<ResultT> task) {
        synchronized (this.f1018b) {
            if (this.f1019c != null) {
                this.f1017a.execute(new C2162a(this, task));
            }
        }
    }
}
