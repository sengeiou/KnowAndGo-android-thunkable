package org.apache.commons.p032io.input;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.BoundedInputStream */
public class BoundedInputStream extends InputStream {

    /* renamed from: in */
    private final InputStream f3026in;
    private long mark;
    private final long max;
    private long pos;
    private boolean propagateClose;

    public BoundedInputStream(InputStream inputStream, long j) {
        this.pos = 0;
        this.mark = -1;
        this.propagateClose = true;
        this.max = j;
        this.f3026in = inputStream;
    }

    public BoundedInputStream(InputStream inputStream) {
        this(inputStream, -1);
    }

    public int read() throws IOException {
        if (this.max >= 0 && this.pos >= this.max) {
            return -1;
        }
        int read = this.f3026in.read();
        this.pos++;
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.max >= 0 && this.pos >= this.max) {
            return -1;
        }
        int read = this.f3026in.read(bArr, i, (int) (this.max >= 0 ? Math.min((long) i2, this.max - this.pos) : (long) i2));
        if (read == -1) {
            return -1;
        }
        this.pos += (long) read;
        return read;
    }

    public long skip(long j) throws IOException {
        if (this.max >= 0) {
            j = Math.min(j, this.max - this.pos);
        }
        long skip = this.f3026in.skip(j);
        this.pos += skip;
        return skip;
    }

    public int available() throws IOException {
        if (this.max < 0 || this.pos < this.max) {
            return this.f3026in.available();
        }
        return 0;
    }

    public String toString() {
        return this.f3026in.toString();
    }

    public void close() throws IOException {
        if (this.propagateClose) {
            this.f3026in.close();
        }
    }

    public synchronized void reset() throws IOException {
        this.f3026in.reset();
        this.pos = this.mark;
    }

    public synchronized void mark(int i) {
        this.f3026in.mark(i);
        this.mark = this.pos;
    }

    public boolean markSupported() {
        return this.f3026in.markSupported();
    }

    public boolean isPropagateClose() {
        return this.propagateClose;
    }

    public void setPropagateClose(boolean z) {
        this.propagateClose = z;
    }
}
