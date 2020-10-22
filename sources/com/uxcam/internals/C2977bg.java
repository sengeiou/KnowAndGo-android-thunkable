package com.uxcam.internals;

import java.io.Closeable;
import java.io.Flushable;

/* renamed from: com.uxcam.internals.bg */
public final class C2977bg implements Closeable, Flushable {

    /* renamed from: a */
    final C3040cq f1409a;

    /* renamed from: b */
    final C3037cp f1410b;

    public final void close() {
        this.f1410b.close();
    }

    public final void flush() {
        this.f1410b.flush();
    }
}
