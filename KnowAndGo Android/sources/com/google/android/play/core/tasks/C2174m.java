package com.google.android.play.core.tasks;

import androidx.annotation.Nullable;
import com.google.android.play.core.internal.C1998av;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.m */
final class C2174m<ResultT> extends Task<ResultT> {

    /* renamed from: a */
    private final Object f1035a = new Object();

    /* renamed from: b */
    private final C2169h<ResultT> f1036b = new C2169h<>();

    /* renamed from: c */
    private boolean f1037c;

    /* renamed from: d */
    private ResultT f1038d;

    /* renamed from: e */
    private Exception f1039e;

    C2174m() {
    }

    /* renamed from: a */
    private final void m1073a() {
        C1998av.m631a(this.f1037c, (Object) "Task is not yet complete");
    }

    /* renamed from: b */
    private final void m1074b() {
        C1998av.m631a(!this.f1037c, (Object) "Task is already complete");
    }

    /* renamed from: c */
    private final void m1075c() {
        synchronized (this.f1035a) {
            if (this.f1037c) {
                this.f1036b.mo33803a(this);
            }
        }
    }

    /* renamed from: a */
    public final void mo33812a(Exception exc) {
        synchronized (this.f1035a) {
            m1074b();
            this.f1037c = true;
            this.f1039e = exc;
        }
        this.f1036b.mo33803a(this);
    }

    /* renamed from: a */
    public final void mo33813a(ResultT resultt) {
        synchronized (this.f1035a) {
            m1074b();
            this.f1037c = true;
            this.f1038d = resultt;
        }
        this.f1036b.mo33803a(this);
    }

    public final Task<ResultT> addOnCompleteListener(OnCompleteListener<ResultT> onCompleteListener) {
        this.f1036b.mo33804a(new C2163b(TaskExecutors.MAIN_THREAD, onCompleteListener));
        m1075c();
        return this;
    }

    public final Task<ResultT> addOnCompleteListener(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.f1036b.mo33804a(new C2163b(executor, onCompleteListener));
        m1075c();
        return this;
    }

    public final Task<ResultT> addOnFailureListener(OnFailureListener onFailureListener) {
        addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        return this;
    }

    public final Task<ResultT> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.f1036b.mo33804a(new C2165d(executor, onFailureListener));
        m1075c();
        return this;
    }

    public final Task<ResultT> addOnSuccessListener(OnSuccessListener<? super ResultT> onSuccessListener) {
        addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
        return this;
    }

    public final Task<ResultT> addOnSuccessListener(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.f1036b.mo33804a(new C2167f(executor, onSuccessListener));
        m1075c();
        return this;
    }

    /* renamed from: b */
    public final boolean mo33814b(Exception exc) {
        synchronized (this.f1035a) {
            if (this.f1037c) {
                return false;
            }
            this.f1037c = true;
            this.f1039e = exc;
            this.f1036b.mo33803a(this);
            return true;
        }
    }

    /* renamed from: b */
    public final boolean mo33815b(ResultT resultt) {
        synchronized (this.f1035a) {
            if (this.f1037c) {
                return false;
            }
            this.f1037c = true;
            this.f1038d = resultt;
            this.f1036b.mo33803a(this);
            return true;
        }
    }

    @Nullable
    public final Exception getException() {
        Exception exc;
        synchronized (this.f1035a) {
            exc = this.f1039e;
        }
        return exc;
    }

    public final ResultT getResult() {
        ResultT resultt;
        synchronized (this.f1035a) {
            m1073a();
            Exception exc = this.f1039e;
            if (exc == null) {
                resultt = this.f1038d;
            } else {
                throw new RuntimeExecutionException(exc);
            }
        }
        return resultt;
    }

    public final <X extends Throwable> ResultT getResult(Class<X> cls) throws Throwable {
        ResultT resultt;
        synchronized (this.f1035a) {
            m1073a();
            if (!cls.isInstance(this.f1039e)) {
                Exception exc = this.f1039e;
                if (exc == null) {
                    resultt = this.f1038d;
                } else {
                    throw new RuntimeExecutionException(exc);
                }
            } else {
                throw ((Throwable) cls.cast(this.f1039e));
            }
        }
        return resultt;
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.f1035a) {
            z = this.f1037c;
        }
        return z;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.f1035a) {
            z = false;
            if (this.f1037c && this.f1039e == null) {
                z = true;
            }
        }
        return z;
    }
}
