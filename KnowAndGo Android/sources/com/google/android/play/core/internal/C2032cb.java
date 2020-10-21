package com.google.android.play.core.internal;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.internal.cb */
public final class C2032cb extends C2031ca {

    /* renamed from: a */
    private final C2031ca f769a;

    /* renamed from: b */
    private final long f770b;

    /* renamed from: c */
    private final long f771c;

    public C2032cb(C2031ca caVar, long j, long j2) {
        this.f769a = caVar;
        long a = m731a(j);
        this.f770b = a;
        this.f771c = m731a(a + j2);
    }

    /* renamed from: a */
    private final long m731a(long j) {
        if (j < 0) {
            return 0;
        }
        return j > this.f769a.mo33403a() ? this.f769a.mo33403a() : j;
    }

    /* renamed from: a */
    public final long mo33403a() {
        return this.f771c - this.f770b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final InputStream mo33404a(long j, long j2) throws IOException {
        long a = m731a(this.f770b);
        return this.f769a.mo33404a(a, m731a(j2 + a) - a);
    }

    public final void close() throws IOException {
    }
}
