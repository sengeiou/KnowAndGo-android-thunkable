package org.apache.commons.p032io.output;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/* renamed from: org.apache.commons.io.output.FileWriterWithEncoding */
public class FileWriterWithEncoding extends Writer {
    private final Writer out;

    public FileWriterWithEncoding(String str, String str2) throws IOException {
        this(new File(str), str2, false);
    }

    public FileWriterWithEncoding(String str, String str2, boolean z) throws IOException {
        this(new File(str), str2, z);
    }

    public FileWriterWithEncoding(String str, Charset charset) throws IOException {
        this(new File(str), charset, false);
    }

    public FileWriterWithEncoding(String str, Charset charset, boolean z) throws IOException {
        this(new File(str), charset, z);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder) throws IOException {
        this(new File(str), charsetEncoder, false);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder, boolean z) throws IOException {
        this(new File(str), charsetEncoder, z);
    }

    public FileWriterWithEncoding(File file, String str) throws IOException {
        this(file, str, false);
    }

    public FileWriterWithEncoding(File file, String str, boolean z) throws IOException {
        this.out = initWriter(file, str, z);
    }

    public FileWriterWithEncoding(File file, Charset charset) throws IOException {
        this(file, charset, false);
    }

    public FileWriterWithEncoding(File file, Charset charset, boolean z) throws IOException {
        this.out = initWriter(file, charset, z);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder) throws IOException {
        this(file, charsetEncoder, false);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder, boolean z) throws IOException {
        this.out = initWriter(file, charsetEncoder, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034 A[SYNTHETIC, Splitter:B:20:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.Writer initWriter(java.io.File r3, java.lang.Object r4, boolean r5) throws java.io.IOException {
        /*
            if (r3 == 0) goto L_0x004a
            if (r4 == 0) goto L_0x0042
            r0 = 0
            boolean r1 = r3.exists()
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException | RuntimeException -> 0x0030 }
            r2.<init>(r3, r5)     // Catch:{ IOException | RuntimeException -> 0x0030 }
            boolean r5 = r4 instanceof java.nio.charset.Charset     // Catch:{ IOException | RuntimeException -> 0x002e }
            if (r5 == 0) goto L_0x001a
            java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ IOException | RuntimeException -> 0x002e }
            java.nio.charset.Charset r4 = (java.nio.charset.Charset) r4     // Catch:{ IOException | RuntimeException -> 0x002e }
            r5.<init>(r2, r4)     // Catch:{ IOException | RuntimeException -> 0x002e }
            return r5
        L_0x001a:
            boolean r5 = r4 instanceof java.nio.charset.CharsetEncoder     // Catch:{ IOException | RuntimeException -> 0x002e }
            if (r5 == 0) goto L_0x0026
            java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ IOException | RuntimeException -> 0x002e }
            java.nio.charset.CharsetEncoder r4 = (java.nio.charset.CharsetEncoder) r4     // Catch:{ IOException | RuntimeException -> 0x002e }
            r5.<init>(r2, r4)     // Catch:{ IOException | RuntimeException -> 0x002e }
            return r5
        L_0x0026:
            java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ IOException | RuntimeException -> 0x002e }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException | RuntimeException -> 0x002e }
            r5.<init>(r2, r4)     // Catch:{ IOException | RuntimeException -> 0x002e }
            return r5
        L_0x002e:
            r4 = move-exception
            goto L_0x0032
        L_0x0030:
            r4 = move-exception
            r2 = r0
        L_0x0032:
            if (r2 == 0) goto L_0x003c
            r2.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r5 = move-exception
            r4.addSuppressed(r5)
        L_0x003c:
            if (r1 != 0) goto L_0x0041
            org.apache.commons.p032io.FileUtils.deleteQuietly(r3)
        L_0x0041:
            throw r4
        L_0x0042:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "Encoding is missing"
            r3.<init>(r4)
            throw r3
        L_0x004a:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "File is missing"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p032io.output.FileWriterWithEncoding.initWriter(java.io.File, java.lang.Object, boolean):java.io.Writer");
    }

    public void write(int i) throws IOException {
        this.out.write(i);
    }

    public void write(char[] cArr) throws IOException {
        this.out.write(cArr);
    }

    public void write(char[] cArr, int i, int i2) throws IOException {
        this.out.write(cArr, i, i2);
    }

    public void write(String str) throws IOException {
        this.out.write(str);
    }

    public void write(String str, int i, int i2) throws IOException {
        this.out.write(str, i, i2);
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void close() throws IOException {
        this.out.close();
    }
}
