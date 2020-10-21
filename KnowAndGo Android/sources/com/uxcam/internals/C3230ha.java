package com.uxcam.internals;

import java.io.Closeable;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/* renamed from: com.uxcam.internals.ha */
public interface C3230ha extends Closeable, ByteChannel, Channel, ReadableByteChannel, WritableByteChannel {
    /* renamed from: a */
    long mo38507a();

    /* renamed from: a */
    C3230ha mo38508a(long j);
}
