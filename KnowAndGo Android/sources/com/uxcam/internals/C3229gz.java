package com.uxcam.internals;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/* renamed from: com.uxcam.internals.gz */
public final class C3229gz {
    /* renamed from: a */
    public static int m2198a(ByteBuffer byteBuffer, int i) {
        int min = Math.min(byteBuffer.remaining(), i);
        byteBuffer.position(byteBuffer.position() + min);
        return min;
    }

    /* renamed from: a */
    public static ByteBuffer m2199a(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        allocate.put(byteBuffer.duplicate());
        allocate.flip();
        return allocate;
    }

    /* renamed from: a */
    public static void m2200a(ByteBuffer byteBuffer, String str, int i) {
        byteBuffer.put((byte) str.length());
        byteBuffer.put(C3227gx.m2197a(str));
        m2198a(byteBuffer, i - str.length());
    }

    /* renamed from: a */
    public static void m2201a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer2.hasArray()) {
            byteBuffer.put(byteBuffer2.array(), byteBuffer2.arrayOffset() + byteBuffer2.position(), Math.min(byteBuffer.remaining(), byteBuffer2.remaining()));
        } else {
            byteBuffer.put(m2204b(byteBuffer2, byteBuffer.remaining()));
        }
    }

    /* renamed from: a */
    public static void m2202a(ReadableByteChannel readableByteChannel) {
        if (readableByteChannel != null) {
            try {
                readableByteChannel.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m2203a(WritableByteChannel writableByteChannel, long j) {
        writableByteChannel.write((ByteBuffer) ByteBuffer.allocate(8).putLong(j).flip());
    }

    /* renamed from: b */
    private static byte[] m2204b(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[Math.min(byteBuffer.remaining(), i)];
        byteBuffer.duplicate().get(bArr);
        return bArr;
    }
}
