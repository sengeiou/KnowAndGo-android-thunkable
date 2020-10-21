package org.apache.commons.p032io.output;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: org.apache.commons.io.output.ClosedOutputStream */
public class ClosedOutputStream extends OutputStream {
    public static final ClosedOutputStream CLOSED_OUTPUT_STREAM = new ClosedOutputStream();

    public void write(int i) throws IOException {
        throw new IOException("write(" + i + ") failed: stream is closed");
    }

    public void flush() throws IOException {
        throw new IOException("flush() failed: stream is closed");
    }
}
