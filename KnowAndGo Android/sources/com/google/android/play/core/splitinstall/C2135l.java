package com.google.android.play.core.splitinstall;

import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.play.core.splitinstall.l */
public enum C2135l implements C2128e {
    ;
    

    /* renamed from: b */
    private static final AtomicReference<C2129f> f929b = null;

    static {
        f928a = new C2135l();
        new C2135l[1][0] = f928a;
        f929b = new AtomicReference<>((Object) null);
    }

    private C2135l() {
    }

    @Nullable
    /* renamed from: a */
    public final C2129f mo33762a() {
        return f929b.get();
    }

    /* renamed from: a */
    public final void mo33766a(C2129f fVar) {
        f929b.set(fVar);
    }
}
