package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* renamed from: com.uxcam.internals.gu */
public final class C3224gu implements C3230ha {

    /* renamed from: a */
    private FileChannel f2465a;

    public C3224gu(FileChannel fileChannel) {
        this.f2465a = fileChannel;
    }

    /* renamed from: a */
    public final long mo38507a() {
        return this.f2465a.position();
    }

    /* renamed from: a */
    public final C3230ha mo38508a(long j) {
        this.f2465a.position(j);
        return this;
    }

    public final void close() {
        this.f2465a.close();
    }

    public final boolean isOpen() {
        return this.f2465a.isOpen();
    }

    public final int read(ByteBuffer byteBuffer) {
        return this.f2465a.read(byteBuffer);
    }

    public final int write(ByteBuffer byteBuffer) {
        return this.f2465a.write(byteBuffer);
    }
}
