package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.j */
public abstract class C2171j extends RuntimeException {
    public C2171j(String str) {
        super(str);
    }

    public C2171j(Throwable th) {
        super(th);
    }

    public abstract int getErrorCode();
}
