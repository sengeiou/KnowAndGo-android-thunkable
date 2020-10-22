package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.dd */
final class C1926dd {

    /* renamed from: a */
    private byte[] f594a = new byte[4096];

    /* renamed from: b */
    private int f595b;

    /* renamed from: c */
    private long f596c;

    /* renamed from: d */
    private long f597d;

    /* renamed from: e */
    private int f598e;

    /* renamed from: f */
    private int f599f;

    /* renamed from: g */
    private int f600g;

    /* renamed from: h */
    private boolean f601h;
    @Nullable

    /* renamed from: i */
    private String f602i;

    public C1926dd() {
        mo33474c();
    }

    /* renamed from: a */
    private final int m478a(int i, byte[] bArr, int i2, int i3) {
        int i4 = this.f595b;
        if (i4 >= i) {
            return 0;
        }
        int min = Math.min(i3, i - i4);
        System.arraycopy(bArr, i2, this.f594a, this.f595b, min);
        int i5 = this.f595b + min;
        this.f595b = i5;
        if (i5 < i) {
            return -1;
        }
        return min;
    }

    /* renamed from: a */
    public final int mo33471a(byte[] bArr, int i, int i2) {
        int a = m478a(30, bArr, i, i2);
        if (a == -1) {
            return -1;
        }
        if (this.f596c == -1) {
            long b = C1924db.m473b(this.f594a, 0);
            this.f596c = b;
            if (b == 67324752) {
                this.f601h = false;
                this.f597d = C1924db.m473b(this.f594a, 18);
                this.f600g = C1924db.m475c(this.f594a, 8);
                this.f598e = C1924db.m475c(this.f594a, 26);
                int c = this.f598e + 30 + C1924db.m475c(this.f594a, 28);
                this.f599f = c;
                int length = this.f594a.length;
                if (length < c) {
                    do {
                        length += length;
                    } while (length < c);
                    this.f594a = Arrays.copyOf(this.f594a, length);
                }
            } else {
                this.f601h = true;
            }
        }
        int a2 = m478a(this.f599f, bArr, i + a, i2 - a);
        if (a2 == -1) {
            return -1;
        }
        int i3 = a + a2;
        if (!this.f601h && this.f602i == null) {
            this.f602i = new String(this.f594a, 30, this.f598e);
        }
        return i3;
    }

    /* renamed from: a */
    public final C1946dx mo33472a() {
        int i = this.f595b;
        int i2 = this.f599f;
        if (i < i2) {
            return C1946dx.m518a(this.f602i, this.f597d, this.f600g, true, Arrays.copyOf(this.f594a, i), this.f601h);
        }
        C1946dx a = C1946dx.m518a(this.f602i, this.f597d, this.f600g, false, Arrays.copyOf(this.f594a, i2), this.f601h);
        mo33474c();
        return a;
    }

    /* renamed from: b */
    public final int mo33473b() {
        return this.f599f;
    }

    /* renamed from: c */
    public final void mo33474c() {
        this.f595b = 0;
        this.f598e = -1;
        this.f596c = -1;
        this.f601h = false;
        this.f599f = 30;
        this.f597d = -1;
        this.f600g = -1;
        this.f602i = null;
    }
}
