package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

public final class BufferedOutputStream extends OutputStream {
    private ArrayPool arrayPool;
    private byte[] buffer;
    private int index;
    @NonNull
    private final OutputStream out;

    public BufferedOutputStream(@NonNull OutputStream outputStream, @NonNull ArrayPool arrayPool2) {
        this(outputStream, arrayPool2, 65536);
    }

    @VisibleForTesting
    BufferedOutputStream(@NonNull OutputStream outputStream, ArrayPool arrayPool2, int i) {
        this.out = outputStream;
        this.arrayPool = arrayPool2;
        this.buffer = (byte[]) arrayPool2.get(i, byte[].class);
    }

    public void write(int i) throws IOException {
        byte[] bArr = this.buffer;
        int i2 = this.index;
        this.index = i2 + 1;
        bArr[i2] = (byte) i;
        maybeFlushBuffer();
    }

    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            if (this.index != 0 || i4 < this.buffer.length) {
                int min = Math.min(i4, this.buffer.length - this.index);
                System.arraycopy(bArr, i5, this.buffer, this.index, min);
                this.index += min;
                i3 += min;
                maybeFlushBuffer();
            } else {
                this.out.write(bArr, i5, i4);
                return;
            }
        } while (i3 < i2);
    }

    public void flush() throws IOException {
        flushBuffer();
        this.out.flush();
    }

    private void flushBuffer() throws IOException {
        if (this.index > 0) {
            this.out.write(this.buffer, 0, this.index);
            this.index = 0;
        }
    }

    private void maybeFlushBuffer() throws IOException {
        if (this.index == this.buffer.length) {
            flushBuffer();
        }
    }

    /* JADX INFO: finally extract failed */
    public void close() throws IOException {
        try {
            flush();
            this.out.close();
            release();
        } catch (Throwable th) {
            this.out.close();
            throw th;
        }
    }

    private void release() {
        if (this.buffer != null) {
            this.arrayPool.put(this.buffer);
            this.buffer = null;
        }
    }
}