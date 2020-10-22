package com.google.zxing.pdf417.decoder;

class DetectionResultColumn {
    private static final int MAX_NEARBY_DISTANCE = 5;
    private final BoundingBox boundingBox;
    private final Codeword[] codewords;

    DetectionResultColumn(BoundingBox boundingBox2) {
        this.boundingBox = new BoundingBox(boundingBox2);
        this.codewords = new Codeword[((boundingBox2.getMaxY() - boundingBox2.getMinY()) + 1)];
    }

    /* access modifiers changed from: package-private */
    public final Codeword getCodewordNearby(int i) {
        Codeword codeword;
        Codeword codeword2;
        Codeword codeword3 = getCodeword(i);
        if (codeword3 != null) {
            return codeword3;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int imageRowToCodewordIndex = imageRowToCodewordIndex(i) - i2;
            if (imageRowToCodewordIndex >= 0 && (codeword2 = this.codewords[imageRowToCodewordIndex]) != null) {
                return codeword2;
            }
            int imageRowToCodewordIndex2 = imageRowToCodewordIndex(i) + i2;
            if (imageRowToCodewordIndex2 < this.codewords.length && (codeword = this.codewords[imageRowToCodewordIndex2]) != null) {
                return codeword;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final int imageRowToCodewordIndex(int i) {
        return i - this.boundingBox.getMinY();
    }

    /* access modifiers changed from: package-private */
    public final void setCodeword(int i, Codeword codeword) {
        this.codewords[imageRowToCodewordIndex(i)] = codeword;
    }

    /* access modifiers changed from: package-private */
    public final Codeword getCodeword(int i) {
        return this.codewords[imageRowToCodewordIndex(i)];
    }

    /* access modifiers changed from: package-private */
    public final BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    /* access modifiers changed from: package-private */
    public final Codeword[] getCodewords() {
        return this.codewords;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0055, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        if (r1 != null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0064, code lost:
        r0.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r12 = this;
            java.util.Formatter r0 = new java.util.Formatter
            r0.<init>()
            r1 = 0
            com.google.zxing.pdf417.decoder.Codeword[] r2 = r12.codewords     // Catch:{ Throwable -> 0x0057 }
            int r3 = r2.length     // Catch:{ Throwable -> 0x0057 }
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x000c:
            if (r5 >= r3) goto L_0x004d
            r7 = r2[r5]     // Catch:{ Throwable -> 0x0057 }
            r8 = 1
            if (r7 != 0) goto L_0x0024
            java.lang.String r7 = "%3d:    |   %n"
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ Throwable -> 0x0057 }
            int r9 = r6 + 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Throwable -> 0x0057 }
            r8[r4] = r6     // Catch:{ Throwable -> 0x0057 }
            r0.format(r7, r8)     // Catch:{ Throwable -> 0x0057 }
            r6 = r9
            goto L_0x004a
        L_0x0024:
            java.lang.String r9 = "%3d: %3d|%3d%n"
            r10 = 3
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ Throwable -> 0x0057 }
            int r11 = r6 + 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Throwable -> 0x0057 }
            r10[r4] = r6     // Catch:{ Throwable -> 0x0057 }
            int r6 = r7.getRowNumber()     // Catch:{ Throwable -> 0x0057 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Throwable -> 0x0057 }
            r10[r8] = r6     // Catch:{ Throwable -> 0x0057 }
            r6 = 2
            int r7 = r7.getValue()     // Catch:{ Throwable -> 0x0057 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Throwable -> 0x0057 }
            r10[r6] = r7     // Catch:{ Throwable -> 0x0057 }
            r0.format(r9, r10)     // Catch:{ Throwable -> 0x0057 }
            r6 = r11
        L_0x004a:
            int r5 = r5 + 1
            goto L_0x000c
        L_0x004d:
            java.lang.String r2 = r0.toString()     // Catch:{ Throwable -> 0x0057 }
            r0.close()
            return r2
        L_0x0055:
            r2 = move-exception
            goto L_0x0059
        L_0x0057:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0055 }
        L_0x0059:
            if (r1 == 0) goto L_0x0064
            r0.close()     // Catch:{ Throwable -> 0x005f }
            goto L_0x0067
        L_0x005f:
            r0 = move-exception
            r1.addSuppressed(r0)
            goto L_0x0067
        L_0x0064:
            r0.close()
        L_0x0067:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DetectionResultColumn.toString():java.lang.String");
    }
}
