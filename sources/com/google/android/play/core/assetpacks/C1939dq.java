package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;

/* renamed from: com.google.android.play.core.assetpacks.dq */
final class C1939dq {

    /* renamed from: a */
    private final int f641a;

    /* renamed from: b */
    private final String f642b;

    /* renamed from: c */
    private final long f643c;

    /* renamed from: d */
    private final long f644d;

    /* renamed from: e */
    private final int f645e;

    C1939dq() {
    }

    C1939dq(int i, @Nullable String str, long j, long j2, int i2) {
        this();
        this.f641a = i;
        this.f642b = str;
        this.f643c = j;
        this.f644d = j2;
        this.f645e = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo33480a() {
        return this.f641a;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: b */
    public String mo33481b() {
        return this.f642b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo33482c() {
        return this.f643c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public long mo33483d() {
        return this.f644d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo33484e() {
        return this.f645e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r1 = r7.f642b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.android.play.core.assetpacks.C1939dq
            r2 = 0
            if (r1 == 0) goto L_0x0046
            com.google.android.play.core.assetpacks.dq r8 = (com.google.android.play.core.assetpacks.C1939dq) r8
            int r1 = r7.f641a
            int r3 = r8.mo33480a()
            if (r1 != r3) goto L_0x0046
            java.lang.String r1 = r7.f642b
            if (r1 != 0) goto L_0x001e
            java.lang.String r1 = r8.mo33481b()
            if (r1 != 0) goto L_0x0046
            goto L_0x0029
        L_0x001e:
            java.lang.String r3 = r8.mo33481b()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0029
            goto L_0x0046
        L_0x0029:
            long r3 = r7.f643c
            long r5 = r8.mo33482c()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0046
            long r3 = r7.f644d
            long r5 = r8.mo33483d()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0046
            int r1 = r7.f645e
            int r8 = r8.mo33484e()
            if (r1 != r8) goto L_0x0046
            return r0
        L_0x0046:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C1939dq.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = (this.f641a ^ 1000003) * 1000003;
        String str = this.f642b;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f643c;
        long j2 = this.f644d;
        return ((((((i ^ hashCode) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f645e;
    }

    public String toString() {
        int i = this.f641a;
        String str = this.f642b;
        long j = this.f643c;
        long j2 = this.f644d;
        int i2 = this.f645e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 157);
        sb.append("SliceCheckpoint{fileExtractionStatus=");
        sb.append(i);
        sb.append(", filePath=");
        sb.append(str);
        sb.append(", fileOffset=");
        sb.append(j);
        sb.append(", remainingBytes=");
        sb.append(j2);
        sb.append(", previousChunk=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
