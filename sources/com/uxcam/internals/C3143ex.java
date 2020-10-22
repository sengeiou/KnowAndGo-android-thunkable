package com.uxcam.internals;

import android.support.p002v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.nio.charset.Charset;

/* renamed from: com.uxcam.internals.ex */
final class C3143ex implements C3132ep {

    /* renamed from: a */
    public final C3130en f2184a = new C3130en();

    /* renamed from: b */
    public final C3148fc f2185b;

    /* renamed from: c */
    boolean f2186c;

    C3143ex(C3148fc fcVar) {
        if (fcVar != null) {
            this.f2185b = fcVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    /* renamed from: a */
    private long m1890a(byte b, long j) {
        if (!this.f2186c) {
            while (true) {
                long a = this.f2184a.mo38350a(b, j);
                if (a != -1) {
                    return a;
                }
                long j2 = this.f2184a.f2158b;
                if (this.f2185b.mo38196a(this.f2184a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                j = Math.max(j, j2);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    /* renamed from: b */
    private boolean m1891b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (!this.f2186c) {
            while (this.f2184a.f2158b < j) {
                if (this.f2185b.mo38196a(this.f2184a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    /* renamed from: a */
    public final long mo38196a(C3130en enVar, long j) {
        if (enVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (this.f2186c) {
            throw new IllegalStateException("closed");
        } else if (this.f2184a.f2158b == 0 && this.f2185b.mo38196a(this.f2184a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        } else {
            return this.f2184a.mo38196a(enVar, Math.min(j, this.f2184a.f2158b));
        }
    }

    /* renamed from: a */
    public final C3149fd mo38197a() {
        return this.f2185b.mo38197a();
    }

    /* renamed from: a */
    public final String mo38359a(Charset charset) {
        if (charset != null) {
            this.f2184a.mo38351a(this.f2185b);
            return this.f2184a.mo38359a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    /* renamed from: a */
    public final void mo38360a(long j) {
        if (!m1891b(j)) {
            throw new EOFException();
        }
    }

    /* renamed from: b */
    public final C3130en mo38362b() {
        return this.f2184a;
    }

    /* renamed from: b */
    public final boolean mo38367b(C3133eq eqVar) {
        int g = eqVar.mo38415g();
        if (this.f2186c) {
            throw new IllegalStateException("closed");
        } else if (g < 0 || eqVar.mo38415g() - 0 < g) {
            return false;
        } else {
            for (int i = 0; i < g; i++) {
                long j = ((long) i) + 0;
                if (!m1891b(1 + j) || this.f2184a.mo38361b(j) != eqVar.mo38402a(i + 0)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: c */
    public final C3133eq mo38370c(long j) {
        mo38360a(j);
        return this.f2184a.mo38370c(j);
    }

    /* renamed from: c */
    public final boolean mo38371c() {
        if (!this.f2186c) {
            return this.f2184a.mo38371c() && this.f2185b.mo38196a(this.f2184a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
        }
        throw new IllegalStateException("closed");
    }

    public final void close() {
        if (!this.f2186c) {
            this.f2186c = true;
            this.f2185b.close();
            this.f2184a.mo38398o();
        }
    }

    /* renamed from: e */
    public final byte mo38376e() {
        mo38360a(1);
        return this.f2184a.mo38376e();
    }

    /* renamed from: e */
    public final byte[] mo38378e(long j) {
        mo38360a(j);
        return this.f2184a.mo38378e(j);
    }

    /* renamed from: f */
    public final short mo38381f() {
        mo38360a(2);
        return this.f2184a.mo38381f();
    }

    /* renamed from: f */
    public final void mo38382f(long j) {
        if (!this.f2186c) {
            while (j > 0) {
                if (this.f2184a.f2158b == 0 && this.f2185b.mo38196a(this.f2184a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f2184a.f2158b);
                this.f2184a.mo38382f(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: g */
    public final int mo38383g() {
        mo38360a(4);
        return this.f2184a.mo38383g();
    }

    /* renamed from: h */
    public final short mo38388h() {
        mo38360a(2);
        return C3151fe.m1946a(this.f2184a.mo38381f());
    }

    /* renamed from: i */
    public final int mo38390i() {
        mo38360a(4);
        return C3151fe.m1945a(this.f2184a.mo38383g());
    }

    /* renamed from: j */
    public final long mo38392j() {
        mo38360a(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!m1891b((long) i2)) {
                break;
            }
            byte b = this.f2184a.mo38361b((long) i);
            if ((b >= 48 && b <= 57) || ((b >= 97 && b <= 102) || (b >= 65 && b <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b)}));
            }
        }
        return this.f2184a.mo38392j();
    }

    /* renamed from: m */
    public final String mo38396m() {
        long a = m1890a((byte) 10, 0);
        if (a != -1) {
            return this.f2184a.mo38375d(a);
        }
        C3130en enVar = new C3130en();
        this.f2184a.mo38353a(enVar, 0, Math.min(32, this.f2184a.f2158b));
        throw new EOFException("\\n not found: size=" + this.f2184a.f2158b + " content=" + enVar.mo38394k().mo38412e() + "…");
    }

    /* renamed from: p */
    public final long mo38399p() {
        return m1890a((byte) 0, 0);
    }

    public final String toString() {
        return "buffer(" + this.f2185b + ")";
    }
}
