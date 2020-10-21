package com.google.android.play.core.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.internal.ca */
public abstract class C2031ca implements Closeable {
    /* renamed from: a */
    public abstract long mo33403a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract InputStream mo33404a(long j, long j2) throws IOException;

    /* renamed from: b */
    public synchronized InputStream mo33600b() throws IOException {
        return mo33404a(0, mo33403a());
    }
}
