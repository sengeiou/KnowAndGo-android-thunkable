package org.apache.commons.p032io.input;

import java.io.InputStream;
import kotlin.UByte;

/* renamed from: org.apache.commons.io.input.InfiniteCircularInputStream */
public class InfiniteCircularInputStream extends InputStream {
    private int position = -1;
    private final byte[] repeatedContent;

    public InfiniteCircularInputStream(byte[] bArr) {
        this.repeatedContent = bArr;
    }

    public int read() {
        this.position = (this.position + 1) % this.repeatedContent.length;
        return this.repeatedContent[this.position] & UByte.MAX_VALUE;
    }
}
