package com.google.android.play.core.internal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.google.android.play.core.internal.a */
final class C1976a implements C2003b {

    /* renamed from: a */
    private final ByteBuffer f726a;

    public C1976a(ByteBuffer byteBuffer) {
        this.f726a = byteBuffer.slice();
    }

    /* renamed from: a */
    public final long mo33542a() {
        return (long) this.f726a.capacity();
    }

    /* renamed from: a */
    public final void mo33543a(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        ByteBuffer slice;
        synchronized (this.f726a) {
            int i2 = (int) j;
            this.f726a.position(i2);
            this.f726a.limit(i2 + i);
            slice = this.f726a.slice();
        }
        for (MessageDigest update : messageDigestArr) {
            slice.position(0);
            update.update(slice);
        }
    }
}
