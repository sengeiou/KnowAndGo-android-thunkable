package com.google.android.play.core.splitinstall;

import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.play.core.splitinstall.o */
public final class C2139o {

    /* renamed from: a */
    private static final AtomicReference<C2138n> f932a = new AtomicReference<>((Object) null);

    @Nullable
    /* renamed from: a */
    static C2138n m996a() {
        return f932a.get();
    }

    /* renamed from: a */
    public static void m997a(C2138n nVar) {
        f932a.compareAndSet((Object) null, nVar);
    }
}
