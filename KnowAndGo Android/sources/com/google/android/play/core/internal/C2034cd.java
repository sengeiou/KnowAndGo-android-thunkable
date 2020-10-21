package com.google.android.play.core.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.play.core.internal.cd */
final class C2034cd extends WeakReference<Throwable> {

    /* renamed from: a */
    private final int f772a;

    public C2034cd(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.f772a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            C2034cd cdVar = (C2034cd) obj;
            return this.f772a == cdVar.f772a && get() == cdVar.get();
        }
    }

    public final int hashCode() {
        return this.f772a;
    }
}
