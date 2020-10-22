package com.google.android.play.core.assetpacks;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.bm */
final class C1881bm extends FilterInputStream {

    /* renamed from: a */
    private final C1926dd f424a = new C1926dd();

    /* renamed from: b */
    private byte[] f425b = new byte[4096];

    /* renamed from: c */
    private long f426c;

    /* renamed from: d */
    private boolean f427d = false;

    /* renamed from: e */
    private boolean f428e = false;

    C1881bm(InputStream inputStream) {
        super(inputStream);
    }

    /* renamed from: a */
    private final int m383a(byte[] bArr, int i, int i2) throws IOException {
        return Math.max(0, super.read(bArr, i, i2));
    }

    /* renamed from: a */
    private final boolean m384a(int i) throws IOException {
        int a = m383a(this.f425b, 0, i);
        if (a != i) {
            int i2 = i - a;
            if (m383a(this.f425b, a, i2) != i2) {
                this.f424a.mo33471a(this.f425b, 0, a);
                return false;
            }
        }
        this.f424a.mo33471a(this.f425b, 0, i);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C1946dx mo33419a() throws IOException {
        byte[] bArr;
        if (this.f426c > 0) {
            do {
                bArr = this.f425b;
            } while (read(bArr, 0, bArr.length) != -1);
        }
        if (this.f427d || this.f428e) {
            return new C1946dx((String) null, -1, -1, false, false, (byte[]) null);
        }
        if (!m384a(30)) {
            this.f427d = true;
            return this.f424a.mo33472a();
        }
        C1946dx a = this.f424a.mo33472a();
        if (a.mo33510g()) {
            this.f428e = true;
            return a;
        } else if (a.mo33506d() != 4294967295L) {
            int b = this.f424a.mo33473b() - 30;
            long j = (long) b;
            int length = this.f425b.length;
            if (j > ((long) length)) {
                do {
                    length += length;
                } while (((long) length) < j);
                this.f425b = Arrays.copyOf(this.f425b, length);
            }
            if (!m384a(b)) {
                this.f427d = true;
                return this.f424a.mo33472a();
            }
            C1946dx a2 = this.f424a.mo33472a();
            this.f426c = a2.mo33506d();
            return a2;
        } else {
            throw new C1890bv("Files bigger than 4GiB are not supported.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo33420b() {
        return this.f427d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final boolean mo33421c() {
        return this.f428e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final long mo33422d() {
        return this.f426c;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f426c;
        if (j <= 0 || this.f427d) {
            return -1;
        }
        int a = m383a(bArr, i, (int) Math.min(j, (long) i2));
        this.f426c -= (long) a;
        if (a != 0) {
            return a;
        }
        this.f427d = true;
        return 0;
    }
}
