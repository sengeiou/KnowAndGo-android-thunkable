package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.internal.C2040cj;
import java.io.File;

/* renamed from: com.google.android.play.core.assetpacks.bt */
final class C1888bt {

    /* renamed from: a */
    private static final C1982af f467a = new C1982af("ExtractChunkTaskHandler");

    /* renamed from: b */
    private final byte[] f468b = new byte[8192];

    /* renamed from: c */
    private final C1870bb f469c;

    /* renamed from: d */
    private final C2040cj<C1966w> f470d;

    /* renamed from: e */
    private final C2040cj<C1864aw> f471e;

    /* renamed from: f */
    private final C1894bz f472f;

    C1888bt(C1870bb bbVar, C2040cj<C1966w> cjVar, C2040cj<C1864aw> cjVar2, C1894bz bzVar) {
        this.f469c = bbVar;
        this.f470d = cjVar;
        this.f471e = cjVar2;
        this.f472f = bzVar;
    }

    /* renamed from: b */
    private final File m399b(C1887bs bsVar) {
        File a = this.f469c.mo33375a(bsVar.f551k, bsVar.f458a, bsVar.f459b, bsVar.f460c);
        if (!a.exists()) {
            a.mkdirs();
        }
        return a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0074, code lost:
        r4 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01a2 A[Catch:{ all -> 0x0329, all -> 0x032f, IOException -> 0x0335 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01d2 A[Catch:{ all -> 0x0329, all -> 0x032f, IOException -> 0x0335 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01eb A[Catch:{ all -> 0x0329, all -> 0x032f, IOException -> 0x0335 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0201 A[Catch:{ all -> 0x0329, all -> 0x032f, IOException -> 0x0335 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo33430a(com.google.android.play.core.assetpacks.C1887bs r23) {
        /*
            r22 = this;
            r1 = r22
            r2 = r23
            com.google.android.play.core.assetpacks.dr r0 = new com.google.android.play.core.assetpacks.dr
            com.google.android.play.core.assetpacks.bb r4 = r1.f469c
            java.lang.String r5 = r2.f551k
            int r6 = r2.f458a
            long r7 = r2.f459b
            java.lang.String r9 = r2.f460c
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r9)
            com.google.android.play.core.assetpacks.bb r10 = r1.f469c
            java.lang.String r11 = r2.f551k
            int r12 = r2.f458a
            long r13 = r2.f459b
            java.lang.String r15 = r2.f460c
            java.io.File r3 = r10.mo33397f(r11, r12, r13, r15)
            boolean r4 = r3.exists()
            if (r4 != 0) goto L_0x002b
            r3.mkdirs()
        L_0x002b:
            r12 = 2
            r13 = 1
            r14 = 0
            java.io.InputStream r3 = r2.f466i     // Catch:{ IOException -> 0x0335 }
            int r4 = r2.f461d     // Catch:{ IOException -> 0x0335 }
            if (r4 == r13) goto L_0x0036
            r15 = r3
            goto L_0x003f
        L_0x0036:
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0335 }
            byte[] r5 = r1.f468b     // Catch:{ IOException -> 0x0335 }
            int r5 = r5.length     // Catch:{ IOException -> 0x0335 }
            r4.<init>(r3, r5)     // Catch:{ IOException -> 0x0335 }
            r15 = r4
        L_0x003f:
            int r3 = r2.f462e     // Catch:{ all -> 0x0329 }
            r16 = 0
            if (r3 <= 0) goto L_0x017a
            com.google.android.play.core.assetpacks.dq r3 = r0.mo33488a()     // Catch:{ all -> 0x0329 }
            int r4 = r3.mo33484e()     // Catch:{ all -> 0x0329 }
            int r5 = r2.f462e     // Catch:{ all -> 0x0329 }
            int r6 = r5 + -1
            if (r4 != r6) goto L_0x015a
            int r4 = r3.mo33480a()     // Catch:{ all -> 0x0329 }
            switch(r4) {
                case 1: goto L_0x00bf;
                case 2: goto L_0x0082;
                case 3: goto L_0x005e;
                default: goto L_0x005a;
            }     // Catch:{ all -> 0x0329 }
        L_0x005a:
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0329 }
            goto L_0x0142
        L_0x005e:
            com.google.android.play.core.internal.af r4 = f467a     // Catch:{ all -> 0x0329 }
            java.lang.String r5 = "Resuming central directory from last chunk."
            java.lang.Object[] r6 = new java.lang.Object[r14]     // Catch:{ all -> 0x0329 }
            r4.mo33550a(r5, r6)     // Catch:{ all -> 0x0329 }
            long r3 = r3.mo33482c()     // Catch:{ all -> 0x0329 }
            r0.mo33491a((java.io.InputStream) r15, (long) r3)     // Catch:{ all -> 0x0329 }
            boolean r3 = r23.mo33429a()     // Catch:{ all -> 0x0329 }
            if (r3 == 0) goto L_0x0078
        L_0x0074:
            r4 = r16
            goto L_0x017b
        L_0x0078:
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0329 }
            java.lang.String r3 = "Chunk has ended twice during central directory. This should not be possible with chunk sizes of 50MB."
            int r4 = r2.f550j     // Catch:{ all -> 0x0329 }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x0329 }
            throw r0     // Catch:{ all -> 0x0329 }
        L_0x0082:
            com.google.android.play.core.internal.af r3 = f467a     // Catch:{ all -> 0x0329 }
            java.lang.String r4 = "Resuming zip entry from last chunk during local file header."
            java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ all -> 0x0329 }
            r3.mo33550a(r4, r5)     // Catch:{ all -> 0x0329 }
            com.google.android.play.core.assetpacks.bb r3 = r1.f469c     // Catch:{ all -> 0x0329 }
            java.lang.String r4 = r2.f551k     // Catch:{ all -> 0x0329 }
            int r5 = r2.f458a     // Catch:{ all -> 0x0329 }
            long r6 = r2.f459b     // Catch:{ all -> 0x0329 }
            java.lang.String r8 = r2.f460c     // Catch:{ all -> 0x0329 }
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r21 = r8
            java.io.File r3 = r16.mo33389d(r17, r18, r19, r21)     // Catch:{ all -> 0x0329 }
            boolean r4 = r3.exists()     // Catch:{ all -> 0x0329 }
            if (r4 == 0) goto L_0x00b5
            java.io.SequenceInputStream r4 = new java.io.SequenceInputStream     // Catch:{ all -> 0x0329 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x0329 }
            r5.<init>(r3)     // Catch:{ all -> 0x0329 }
            r4.<init>(r5, r15)     // Catch:{ all -> 0x0329 }
            goto L_0x017b
        L_0x00b5:
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0329 }
            java.lang.String r3 = "Checkpoint extension file not found."
            int r4 = r2.f550j     // Catch:{ all -> 0x0329 }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x0329 }
            throw r0     // Catch:{ all -> 0x0329 }
        L_0x00bf:
            com.google.android.play.core.internal.af r4 = f467a     // Catch:{ all -> 0x0329 }
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch:{ all -> 0x0329 }
            java.lang.String r6 = r3.mo33481b()     // Catch:{ all -> 0x0329 }
            r5[r14] = r6     // Catch:{ all -> 0x0329 }
            java.lang.String r6 = "Resuming zip entry from last chunk during file %s."
            r4.mo33550a(r6, r5)     // Catch:{ all -> 0x0329 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0329 }
            java.lang.String r5 = r3.mo33481b()     // Catch:{ all -> 0x0329 }
            r4.<init>(r5)     // Catch:{ all -> 0x0329 }
            boolean r5 = r4.exists()     // Catch:{ all -> 0x0329 }
            if (r5 == 0) goto L_0x0138
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0329 }
            java.lang.String r6 = "rw"
            r5.<init>(r4, r6)     // Catch:{ all -> 0x0329 }
            long r6 = r3.mo33482c()     // Catch:{ all -> 0x0329 }
            r5.seek(r6)     // Catch:{ all -> 0x0329 }
            long r6 = r3.mo33483d()     // Catch:{ all -> 0x0329 }
        L_0x00ef:
            byte[] r3 = r1.f468b     // Catch:{ all -> 0x0329 }
            int r3 = r3.length     // Catch:{ all -> 0x0329 }
            long r8 = (long) r3     // Catch:{ all -> 0x0329 }
            long r8 = java.lang.Math.min(r6, r8)     // Catch:{ all -> 0x0329 }
            int r3 = (int) r8     // Catch:{ all -> 0x0329 }
            byte[] r8 = r1.f468b     // Catch:{ all -> 0x0329 }
            int r8 = r15.read(r8, r14, r3)     // Catch:{ all -> 0x0329 }
            int r8 = java.lang.Math.max(r8, r14)     // Catch:{ all -> 0x0329 }
            if (r8 <= 0) goto L_0x0109
            byte[] r9 = r1.f468b     // Catch:{ all -> 0x0329 }
            r5.write(r9, r14, r8)     // Catch:{ all -> 0x0329 }
        L_0x0109:
            long r10 = (long) r8     // Catch:{ all -> 0x0329 }
            long r9 = r6 - r10
            r6 = 0
            int r6 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x0117
            if (r8 > 0) goto L_0x0115
            goto L_0x0117
        L_0x0115:
            r6 = r9
            goto L_0x00ef
        L_0x0117:
            long r6 = r5.length()     // Catch:{ all -> 0x0329 }
            r5.close()     // Catch:{ all -> 0x0329 }
            if (r8 == r3) goto L_0x017a
            com.google.android.play.core.internal.af r3 = f467a     // Catch:{ all -> 0x0329 }
            java.lang.String r5 = "Chunk has ended while resuming the previous chunks file content."
            java.lang.Object[] r8 = new java.lang.Object[r14]     // Catch:{ all -> 0x0329 }
            r3.mo33550a(r5, r8)     // Catch:{ all -> 0x0329 }
            java.lang.String r4 = r4.getCanonicalPath()     // Catch:{ all -> 0x0329 }
            int r11 = r2.f462e     // Catch:{ all -> 0x0329 }
            r3 = r0
            r5 = r6
            r7 = r9
            r9 = r11
            r3.mo33492a((java.lang.String) r4, (long) r5, (long) r7, (int) r9)     // Catch:{ all -> 0x0329 }
            goto L_0x0074
        L_0x0138:
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0329 }
            java.lang.String r3 = "Partial file specified in checkpoint does not exist. Corrupt directory."
            int r4 = r2.f550j     // Catch:{ all -> 0x0329 }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x0329 }
            throw r0     // Catch:{ all -> 0x0329 }
        L_0x0142:
            java.lang.Object[] r4 = new java.lang.Object[r13]     // Catch:{ all -> 0x0329 }
            int r3 = r3.mo33480a()     // Catch:{ all -> 0x0329 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0329 }
            r4[r14] = r3     // Catch:{ all -> 0x0329 }
            java.lang.String r3 = "Slice checkpoint file corrupt. Unexpected FileExtractionStatus %s."
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ all -> 0x0329 }
            int r4 = r2.f550j     // Catch:{ all -> 0x0329 }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x0329 }
            throw r0     // Catch:{ all -> 0x0329 }
        L_0x015a:
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0329 }
            java.lang.String r4 = "Trying to resume with chunk number %s when previously processed chunk was number %s."
            java.lang.Object[] r6 = new java.lang.Object[r12]     // Catch:{ all -> 0x0329 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0329 }
            r6[r14] = r5     // Catch:{ all -> 0x0329 }
            int r3 = r3.mo33484e()     // Catch:{ all -> 0x0329 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0329 }
            r6[r13] = r3     // Catch:{ all -> 0x0329 }
            java.lang.String r3 = java.lang.String.format(r4, r6)     // Catch:{ all -> 0x0329 }
            int r4 = r2.f550j     // Catch:{ all -> 0x0329 }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x0329 }
            throw r0     // Catch:{ all -> 0x0329 }
        L_0x017a:
            r4 = r15
        L_0x017b:
            if (r4 == 0) goto L_0x0285
            com.google.android.play.core.assetpacks.bm r3 = new com.google.android.play.core.assetpacks.bm     // Catch:{ all -> 0x0329 }
            r3.<init>(r4)     // Catch:{ all -> 0x0329 }
            java.io.File r5 = r22.m399b(r23)     // Catch:{ all -> 0x0329 }
        L_0x0186:
            com.google.android.play.core.assetpacks.dx r6 = r3.mo33419a()     // Catch:{ all -> 0x0329 }
            boolean r7 = r6.mo33509f()     // Catch:{ all -> 0x0329 }
            if (r7 != 0) goto L_0x01d9
            boolean r7 = r3.mo33421c()     // Catch:{ all -> 0x0329 }
            if (r7 != 0) goto L_0x01d9
            boolean r7 = r6.mo33504b()     // Catch:{ all -> 0x0329 }
            if (r7 == 0) goto L_0x01d2
            boolean r7 = r6.mo33503a()     // Catch:{ all -> 0x0329 }
            if (r7 != 0) goto L_0x01d2
            byte[] r7 = r6.mo33511h()     // Catch:{ all -> 0x0329 }
            r0.mo33493a((byte[]) r7)     // Catch:{ all -> 0x0329 }
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x0329 }
            java.lang.String r8 = r6.mo33505c()     // Catch:{ all -> 0x0329 }
            r7.<init>(r5, r8)     // Catch:{ all -> 0x0329 }
            java.io.File r8 = r7.getParentFile()     // Catch:{ all -> 0x0329 }
            r8.mkdirs()     // Catch:{ all -> 0x0329 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ all -> 0x0329 }
            r8.<init>(r7)     // Catch:{ all -> 0x0329 }
            byte[] r7 = r1.f468b     // Catch:{ all -> 0x0329 }
        L_0x01c0:
            int r7 = r3.read(r7)     // Catch:{ all -> 0x0329 }
            if (r7 <= 0) goto L_0x01ce
            byte[] r9 = r1.f468b     // Catch:{ all -> 0x0329 }
            r8.write(r9, r14, r7)     // Catch:{ all -> 0x0329 }
            byte[] r7 = r1.f468b     // Catch:{ all -> 0x0329 }
            goto L_0x01c0
        L_0x01ce:
            r8.close()     // Catch:{ all -> 0x0329 }
            goto L_0x01d9
        L_0x01d2:
            byte[] r7 = r6.mo33511h()     // Catch:{ all -> 0x0329 }
            r0.mo33495a((byte[]) r7, (java.io.InputStream) r3)     // Catch:{ all -> 0x0329 }
        L_0x01d9:
            boolean r7 = r3.mo33420b()     // Catch:{ all -> 0x0329 }
            if (r7 != 0) goto L_0x01e5
            boolean r7 = r3.mo33421c()     // Catch:{ all -> 0x0329 }
            if (r7 == 0) goto L_0x0186
        L_0x01e5:
            boolean r5 = r3.mo33421c()     // Catch:{ all -> 0x0329 }
            if (r5 == 0) goto L_0x01fb
            com.google.android.play.core.internal.af r5 = f467a     // Catch:{ all -> 0x0329 }
            java.lang.String r7 = "Writing central directory metadata."
            java.lang.Object[] r8 = new java.lang.Object[r14]     // Catch:{ all -> 0x0329 }
            r5.mo33550a(r7, r8)     // Catch:{ all -> 0x0329 }
            byte[] r5 = r6.mo33511h()     // Catch:{ all -> 0x0329 }
            r0.mo33495a((byte[]) r5, (java.io.InputStream) r4)     // Catch:{ all -> 0x0329 }
        L_0x01fb:
            boolean r4 = r23.mo33429a()     // Catch:{ all -> 0x0329 }
            if (r4 != 0) goto L_0x0285
            boolean r4 = r6.mo33509f()     // Catch:{ all -> 0x0329 }
            if (r4 == 0) goto L_0x021a
            com.google.android.play.core.internal.af r3 = f467a     // Catch:{ all -> 0x0329 }
            java.lang.String r4 = "Writing slice checkpoint for partial local file header."
            java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ all -> 0x0329 }
            r3.mo33550a(r4, r5)     // Catch:{ all -> 0x0329 }
            byte[] r3 = r6.mo33511h()     // Catch:{ all -> 0x0329 }
            int r4 = r2.f462e     // Catch:{ all -> 0x0329 }
            r0.mo33494a((byte[]) r3, (int) r4)     // Catch:{ all -> 0x0329 }
            goto L_0x0285
        L_0x021a:
            boolean r4 = r3.mo33421c()     // Catch:{ all -> 0x0329 }
            if (r4 == 0) goto L_0x022f
            com.google.android.play.core.internal.af r3 = f467a     // Catch:{ all -> 0x0329 }
            java.lang.String r4 = "Writing slice checkpoint for central directory."
            java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ all -> 0x0329 }
            r3.mo33550a(r4, r5)     // Catch:{ all -> 0x0329 }
            int r3 = r2.f462e     // Catch:{ all -> 0x0329 }
            r0.mo33489a((int) r3)     // Catch:{ all -> 0x0329 }
            goto L_0x0285
        L_0x022f:
            int r4 = r6.mo33507e()     // Catch:{ all -> 0x0329 }
            if (r4 != 0) goto L_0x0266
            com.google.android.play.core.internal.af r4 = f467a     // Catch:{ all -> 0x0329 }
            java.lang.String r5 = "Writing slice checkpoint for partial file."
            java.lang.Object[] r7 = new java.lang.Object[r14]     // Catch:{ all -> 0x0329 }
            r4.mo33550a(r5, r7)     // Catch:{ all -> 0x0329 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0329 }
            java.io.File r5 = r22.m399b(r23)     // Catch:{ all -> 0x0329 }
            java.lang.String r7 = r6.mo33505c()     // Catch:{ all -> 0x0329 }
            r4.<init>(r5, r7)     // Catch:{ all -> 0x0329 }
            long r5 = r6.mo33506d()     // Catch:{ all -> 0x0329 }
            long r7 = r3.mo33422d()     // Catch:{ all -> 0x0329 }
            r9 = 0
            long r5 = r5 - r7
            long r7 = r4.length()     // Catch:{ all -> 0x0329 }
            int r7 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x025e
            goto L_0x0277
        L_0x025e:
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0329 }
            java.lang.String r3 = "Partial file is of unexpected size."
            r0.<init>(r3)     // Catch:{ all -> 0x0329 }
            throw r0     // Catch:{ all -> 0x0329 }
        L_0x0266:
            com.google.android.play.core.internal.af r4 = f467a     // Catch:{ all -> 0x0329 }
            java.lang.String r5 = "Writing slice checkpoint for partial unextractable file."
            java.lang.Object[] r6 = new java.lang.Object[r14]     // Catch:{ all -> 0x0329 }
            r4.mo33550a(r5, r6)     // Catch:{ all -> 0x0329 }
            java.io.File r4 = r0.mo33496b()     // Catch:{ all -> 0x0329 }
            long r5 = r4.length()     // Catch:{ all -> 0x0329 }
        L_0x0277:
            java.lang.String r4 = r4.getCanonicalPath()     // Catch:{ all -> 0x0329 }
            long r7 = r3.mo33422d()     // Catch:{ all -> 0x0329 }
            int r9 = r2.f462e     // Catch:{ all -> 0x0329 }
            r3 = r0
            r3.mo33492a((java.lang.String) r4, (long) r5, (long) r7, (int) r9)     // Catch:{ all -> 0x0329 }
        L_0x0285:
            r15.close()     // Catch:{ IOException -> 0x0335 }
            boolean r3 = r23.mo33429a()
            if (r3 == 0) goto L_0x02ae
            int r3 = r2.f462e     // Catch:{ IOException -> 0x0294 }
            r0.mo33497b(r3)     // Catch:{ IOException -> 0x0294 }
            goto L_0x02ae
        L_0x0294:
            r0 = move-exception
            com.google.android.play.core.internal.af r3 = f467a
            java.lang.Object[] r4 = new java.lang.Object[r13]
            java.lang.String r5 = r0.getMessage()
            r4[r14] = r5
            java.lang.String r5 = "Writing extraction finished checkpoint failed with %s."
            r3.mo33552b(r5, r4)
            com.google.android.play.core.assetpacks.bv r3 = new com.google.android.play.core.assetpacks.bv
            int r2 = r2.f550j
            java.lang.String r4 = "Writing extraction finished checkpoint failed."
            r3.<init>(r4, r0, r2)
            throw r3
        L_0x02ae:
            com.google.android.play.core.internal.af r0 = f467a
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r4 = r2.f462e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r14] = r4
            java.lang.String r4 = r2.f460c
            r3[r13] = r4
            java.lang.String r4 = r2.f551k
            r3[r12] = r4
            int r4 = r2.f550j
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 3
            r3[r5] = r4
            java.lang.String r4 = "Extraction finished for chunk %s of slice %s of pack %s of session %s."
            r0.mo33553c(r4, r3)
            com.google.android.play.core.internal.cj<com.google.android.play.core.assetpacks.w> r0 = r1.f470d
            java.lang.Object r0 = r0.mo33606a()
            com.google.android.play.core.assetpacks.w r0 = (com.google.android.play.core.assetpacks.C1966w) r0
            int r3 = r2.f550j
            java.lang.String r4 = r2.f551k
            java.lang.String r5 = r2.f460c
            int r6 = r2.f462e
            r0.mo33359a(r3, r4, r5, r6)
            java.io.InputStream r0 = r2.f466i     // Catch:{ IOException -> 0x02ea }
            r0.close()     // Catch:{ IOException -> 0x02ea }
            goto L_0x0304
        L_0x02ea:
            com.google.android.play.core.internal.af r0 = f467a
            r3 = 3
            java.lang.Object[] r4 = new java.lang.Object[r3]
            int r3 = r2.f462e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4[r14] = r3
            java.lang.String r3 = r2.f460c
            r4[r13] = r3
            java.lang.String r3 = r2.f551k
            r4[r12] = r3
            java.lang.String r3 = "Could not close file for chunk %s of slice %s of pack %s."
            r0.mo33554d(r3, r4)
        L_0x0304:
            int r0 = r2.f465h
            r3 = 3
            if (r0 != r3) goto L_0x0328
            com.google.android.play.core.internal.cj<com.google.android.play.core.assetpacks.aw> r0 = r1.f471e
            java.lang.Object r0 = r0.mo33606a()
            com.google.android.play.core.assetpacks.aw r0 = (com.google.android.play.core.assetpacks.C1864aw) r0
            java.lang.String r3 = r2.f551k
            long r7 = r2.f464g
            r4 = 3
            r5 = 0
            com.google.android.play.core.assetpacks.bz r6 = r1.f472f
            double r9 = r6.mo33435a(r3, r2)
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            com.google.android.play.core.assetpacks.AssetPackState r2 = com.google.android.play.core.assetpacks.AssetPackState.m261a(r2, r3, r4, r5, r7, r9)
            r0.mo33368a((com.google.android.play.core.assetpacks.AssetPackState) r2)
        L_0x0328:
            return
        L_0x0329:
            r0 = move-exception
            r3 = r0
            r15.close()     // Catch:{ all -> 0x032f }
            goto L_0x0334
        L_0x032f:
            r0 = move-exception
            r4 = r0
            com.google.android.play.core.internal.C2039ci.m739a(r3, r4)     // Catch:{ IOException -> 0x0335 }
        L_0x0334:
            throw r3     // Catch:{ IOException -> 0x0335 }
        L_0x0335:
            r0 = move-exception
            com.google.android.play.core.internal.af r3 = f467a
            java.lang.Object[] r4 = new java.lang.Object[r13]
            java.lang.String r5 = r0.getMessage()
            r4[r14] = r5
            java.lang.String r5 = "IOException during extraction %s."
            r3.mo33552b(r5, r4)
            com.google.android.play.core.assetpacks.bv r3 = new com.google.android.play.core.assetpacks.bv
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]
            int r5 = r2.f462e
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4[r14] = r5
            java.lang.String r5 = r2.f460c
            r4[r13] = r5
            java.lang.String r5 = r2.f551k
            r4[r12] = r5
            int r5 = r2.f550j
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6 = 3
            r4[r6] = r5
            java.lang.String r5 = "Error extracting chunk %s of slice %s of pack %s of session %s."
            java.lang.String r4 = java.lang.String.format(r5, r4)
            int r2 = r2.f550j
            r3.<init>(r4, r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C1888bt.mo33430a(com.google.android.play.core.assetpacks.bs):void");
    }
}
