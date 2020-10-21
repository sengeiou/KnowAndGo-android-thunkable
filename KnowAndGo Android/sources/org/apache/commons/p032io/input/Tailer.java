package org.apache.commons.p032io.input;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

/* renamed from: org.apache.commons.io.input.Tailer */
public class Tailer implements Runnable {
    private static final int DEFAULT_BUFSIZE = 4096;
    private static final Charset DEFAULT_CHARSET = Charset.defaultCharset();
    private static final int DEFAULT_DELAY_MILLIS = 1000;
    private static final String RAF_MODE = "r";
    private final Charset cset;
    private final long delayMillis;
    private final boolean end;
    private final File file;
    private final byte[] inbuf;
    private final TailerListener listener;
    private final boolean reOpen;
    private volatile boolean run;

    public Tailer(File file2, TailerListener tailerListener) {
        this(file2, tailerListener, 1000);
    }

    public Tailer(File file2, TailerListener tailerListener, long j) {
        this(file2, tailerListener, j, false);
    }

    public Tailer(File file2, TailerListener tailerListener, long j, boolean z) {
        this(file2, tailerListener, j, z, 4096);
    }

    public Tailer(File file2, TailerListener tailerListener, long j, boolean z, boolean z2) {
        this(file2, tailerListener, j, z, z2, 4096);
    }

    public Tailer(File file2, TailerListener tailerListener, long j, boolean z, int i) {
        this(file2, tailerListener, j, z, false, i);
    }

    public Tailer(File file2, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        this(file2, DEFAULT_CHARSET, tailerListener, j, z, z2, i);
    }

    public Tailer(File file2, Charset charset, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        this.run = true;
        this.file = file2;
        this.delayMillis = j;
        this.end = z;
        this.inbuf = new byte[i];
        this.listener = tailerListener;
        tailerListener.init(this);
        this.reOpen = z2;
        this.cset = charset;
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j, boolean z, int i) {
        return create(file2, tailerListener, j, z, false, i);
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        return create(file2, DEFAULT_CHARSET, tailerListener, j, z, z2, i);
    }

    public static Tailer create(File file2, Charset charset, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        Tailer tailer = new Tailer(file2, charset, tailerListener, j, z, z2, i);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j, boolean z) {
        return create(file2, tailerListener, j, z, 4096);
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j, boolean z, boolean z2) {
        return create(file2, tailerListener, j, z, z2, 4096);
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j) {
        return create(file2, tailerListener, j, false);
    }

    public static Tailer create(File file2, TailerListener tailerListener) {
        return create(file2, tailerListener, 1000, false);
    }

    public File getFile() {
        return this.file;
    }

    /* access modifiers changed from: protected */
    public boolean getRun() {
        return this.run;
    }

    public long getDelay() {
        return this.delayMillis;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r12.listener.fileNotFound();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0019 */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0130 A[SYNTHETIC, Splitter:B:106:0x0130] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0139 A[SYNTHETIC, Splitter:B:111:0x0139] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x00a7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0113 A[SYNTHETIC, Splitter:B:97:0x0113] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:103:0x0122=Splitter:B:103:0x0122, B:94:0x010c=Splitter:B:94:0x010c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r12 = this;
            r0 = 0
            r1 = 0
            r3 = r0
            r4 = r1
            r6 = r4
        L_0x0006:
            boolean r8 = r12.getRun()     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            if (r8 == 0) goto L_0x003d
            if (r3 != 0) goto L_0x003d
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0019 }
            java.io.File r9 = r12.file     // Catch:{ FileNotFoundException -> 0x0019 }
            java.lang.String r10 = "r"
            r8.<init>(r9, r10)     // Catch:{ FileNotFoundException -> 0x0019 }
            r3 = r8
            goto L_0x001e
        L_0x0019:
            org.apache.commons.io.input.TailerListener r8 = r12.listener     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            r8.fileNotFound()     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
        L_0x001e:
            if (r3 != 0) goto L_0x0026
            long r8 = r12.delayMillis     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            java.lang.Thread.sleep(r8)     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            goto L_0x0006
        L_0x0026:
            boolean r4 = r12.end     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            if (r4 == 0) goto L_0x0032
            java.io.File r4 = r12.file     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            long r4 = r4.length()     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            r6 = r4
            goto L_0x0033
        L_0x0032:
            r6 = r1
        L_0x0033:
            java.io.File r4 = r12.file     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            long r4 = r4.lastModified()     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            r3.seek(r6)     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            goto L_0x0006
        L_0x003d:
            boolean r8 = r12.getRun()     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            if (r8 == 0) goto L_0x0101
            java.io.File r8 = r12.file     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            boolean r8 = org.apache.commons.p032io.FileUtils.isFileNewer((java.io.File) r8, (long) r4)     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            java.io.File r9 = r12.file     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            long r9 = r9.length()     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            int r9 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r9 >= 0) goto L_0x00c0
            org.apache.commons.io.input.TailerListener r8 = r12.listener     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            r8.fileRotated()     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch:{ Throwable -> 0x0090, all -> 0x008c }
            java.io.File r9 = r12.file     // Catch:{ Throwable -> 0x0090, all -> 0x008c }
            java.lang.String r10 = "r"
            r8.<init>(r9, r10)     // Catch:{ Throwable -> 0x0090, all -> 0x008c }
            r12.readLines(r3)     // Catch:{ IOException -> 0x006e }
            goto L_0x0074
        L_0x0065:
            r9 = move-exception
            r10 = r8
            r8 = r0
            goto L_0x0097
        L_0x0069:
            r9 = move-exception
            r11 = r9
            r9 = r8
            r8 = r11
            goto L_0x0092
        L_0x006e:
            r9 = move-exception
            org.apache.commons.io.input.TailerListener r10 = r12.listener     // Catch:{ Throwable -> 0x0069, all -> 0x0065 }
            r10.handle((java.lang.Exception) r9)     // Catch:{ Throwable -> 0x0069, all -> 0x0065 }
        L_0x0074:
            if (r3 == 0) goto L_0x0089
            r3.close()     // Catch:{ FileNotFoundException -> 0x0086 }
            goto L_0x0089
        L_0x007a:
            r0 = move-exception
            r3 = r8
            goto L_0x0137
        L_0x007e:
            r0 = move-exception
            r3 = r8
            goto L_0x010c
        L_0x0082:
            r0 = move-exception
            r3 = r8
            goto L_0x0122
        L_0x0086:
            r6 = r1
            r3 = r8
            goto L_0x00b4
        L_0x0089:
            r6 = r1
        L_0x008a:
            r3 = r8
            goto L_0x003d
        L_0x008c:
            r9 = move-exception
            r8 = r0
            r10 = r3
            goto L_0x0097
        L_0x0090:
            r8 = move-exception
            r9 = r3
        L_0x0092:
            throw r8     // Catch:{ all -> 0x0093 }
        L_0x0093:
            r10 = move-exception
            r11 = r10
            r10 = r9
            r9 = r11
        L_0x0097:
            if (r3 == 0) goto L_0x00a7
            if (r8 == 0) goto L_0x00a4
            r3.close()     // Catch:{ Throwable -> 0x009f }
            goto L_0x00a7
        L_0x009f:
            r3 = move-exception
            r8.addSuppressed(r3)     // Catch:{ FileNotFoundException -> 0x00b3, InterruptedException -> 0x00af, Exception -> 0x00ac, all -> 0x00a8 }
            goto L_0x00a7
        L_0x00a4:
            r3.close()     // Catch:{ FileNotFoundException -> 0x00b3, InterruptedException -> 0x00af, Exception -> 0x00ac, all -> 0x00a8 }
        L_0x00a7:
            throw r9     // Catch:{ FileNotFoundException -> 0x00b3, InterruptedException -> 0x00af, Exception -> 0x00ac, all -> 0x00a8 }
        L_0x00a8:
            r0 = move-exception
            r3 = r10
            goto L_0x0137
        L_0x00ac:
            r0 = move-exception
            r3 = r10
            goto L_0x010c
        L_0x00af:
            r0 = move-exception
            r3 = r10
            goto L_0x0122
        L_0x00b3:
            r3 = r10
        L_0x00b4:
            org.apache.commons.io.input.TailerListener r8 = r12.listener     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            r8.fileNotFound()     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            long r8 = r12.delayMillis     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            java.lang.Thread.sleep(r8)     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            goto L_0x003d
        L_0x00c0:
            if (r9 <= 0) goto L_0x00cd
            long r6 = r12.readLines(r3)     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            java.io.File r4 = r12.file     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            long r4 = r4.lastModified()     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            goto L_0x00dc
        L_0x00cd:
            if (r8 == 0) goto L_0x00dc
            r3.seek(r1)     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            long r6 = r12.readLines(r3)     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            java.io.File r4 = r12.file     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            long r4 = r4.lastModified()     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
        L_0x00dc:
            boolean r8 = r12.reOpen     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            if (r8 == 0) goto L_0x00e5
            if (r3 == 0) goto L_0x00e5
            r3.close()     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
        L_0x00e5:
            long r8 = r12.delayMillis     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            java.lang.Thread.sleep(r8)     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            boolean r8 = r12.getRun()     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            if (r8 == 0) goto L_0x003d
            boolean r8 = r12.reOpen     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            if (r8 == 0) goto L_0x003d
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            java.io.File r9 = r12.file     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            java.lang.String r10 = "r"
            r8.<init>(r9, r10)     // Catch:{ InterruptedException -> 0x0121, Exception -> 0x010b }
            r8.seek(r6)     // Catch:{ InterruptedException -> 0x0082, Exception -> 0x007e, all -> 0x007a }
            goto L_0x008a
        L_0x0101:
            if (r3 == 0) goto L_0x011d
            r3.close()     // Catch:{ IOException -> 0x0107 }
            goto L_0x011d
        L_0x0107:
            r0 = move-exception
            goto L_0x0118
        L_0x0109:
            r0 = move-exception
            goto L_0x0137
        L_0x010b:
            r0 = move-exception
        L_0x010c:
            org.apache.commons.io.input.TailerListener r1 = r12.listener     // Catch:{ all -> 0x0109 }
            r1.handle((java.lang.Exception) r0)     // Catch:{ all -> 0x0109 }
            if (r3 == 0) goto L_0x011d
            r3.close()     // Catch:{ IOException -> 0x0117 }
            goto L_0x011d
        L_0x0117:
            r0 = move-exception
        L_0x0118:
            org.apache.commons.io.input.TailerListener r1 = r12.listener
            r1.handle((java.lang.Exception) r0)
        L_0x011d:
            r12.stop()
            goto L_0x0136
        L_0x0121:
            r0 = move-exception
        L_0x0122:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0109 }
            r1.interrupt()     // Catch:{ all -> 0x0109 }
            org.apache.commons.io.input.TailerListener r1 = r12.listener     // Catch:{ all -> 0x0109 }
            r1.handle((java.lang.Exception) r0)     // Catch:{ all -> 0x0109 }
            if (r3 == 0) goto L_0x011d
            r3.close()     // Catch:{ IOException -> 0x0134 }
            goto L_0x011d
        L_0x0134:
            r0 = move-exception
            goto L_0x0118
        L_0x0136:
            return
        L_0x0137:
            if (r3 == 0) goto L_0x0143
            r3.close()     // Catch:{ IOException -> 0x013d }
            goto L_0x0143
        L_0x013d:
            r1 = move-exception
            org.apache.commons.io.input.TailerListener r2 = r12.listener
            r2.handle((java.lang.Exception) r1)
        L_0x0143:
            r12.stop()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p032io.input.Tailer.run():void");
    }

    public void stop() {
        this.run = false;
    }

    private long readLines(RandomAccessFile randomAccessFile) throws IOException {
        Throwable th;
        int read;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(64);
        try {
            long filePointer = randomAccessFile.getFilePointer();
            long j = filePointer;
            boolean z = false;
            while (getRun() && (read = randomAccessFile.read(this.inbuf)) != -1) {
                long j2 = filePointer;
                for (int i = 0; i < read; i++) {
                    byte b = this.inbuf[i];
                    if (b == 10) {
                        this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.cset));
                        byteArrayOutputStream.reset();
                        j2 = ((long) i) + j + 1;
                        z = false;
                    } else if (b != 13) {
                        if (z) {
                            this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.cset));
                            byteArrayOutputStream.reset();
                            j2 = ((long) i) + j + 1;
                            z = false;
                        }
                        byteArrayOutputStream.write(b);
                    } else {
                        if (z) {
                            byteArrayOutputStream.write(13);
                        }
                        z = true;
                    }
                }
                j = randomAccessFile.getFilePointer();
                filePointer = j2;
            }
            randomAccessFile.seek(filePointer);
            if (this.listener instanceof TailerListenerAdapter) {
                ((TailerListenerAdapter) this.listener).endOfFileReached();
            }
            byteArrayOutputStream.close();
            return filePointer;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }
}
