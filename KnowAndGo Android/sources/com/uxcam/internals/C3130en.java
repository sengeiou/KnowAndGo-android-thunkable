package com.uxcam.internals;

import android.support.p002v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.C1470C;
import com.google.android.exoplayer2.extractor.p012ts.PsExtractor;
import java.io.EOFException;
import java.nio.charset.Charset;
import kotlin.UByte;

/* renamed from: com.uxcam.internals.en */
public final class C3130en implements C3131eo, C3132ep, Cloneable {

    /* renamed from: c */
    private static final byte[] f2156c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a */
    C3144ey f2157a;

    /* renamed from: b */
    public long f2158b;

    /* renamed from: a */
    private String m1745a(long j, Charset charset) {
        C3151fe.m1947a(this.f2158b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        } else if (j == 0) {
            return "";
        } else {
            C3144ey eyVar = this.f2157a;
            if (((long) eyVar.f2188b) + j > ((long) eyVar.f2189c)) {
                return new String(mo38378e(j), charset);
            }
            String str = new String(eyVar.f2187a, eyVar.f2188b, (int) j, charset);
            eyVar.f2188b = (int) (((long) eyVar.f2188b) + j);
            this.f2158b -= j;
            if (eyVar.f2188b == eyVar.f2189c) {
                this.f2157a = eyVar.mo38432a();
                C3145ez.m1914a(eyVar);
            }
            return str;
        }
    }

    /* renamed from: c */
    private void m1746c(byte[] bArr) {
        int i;
        int i2 = 0;
        while (i2 < bArr.length) {
            int length = bArr.length - i2;
            C3151fe.m1947a((long) bArr.length, (long) i2, (long) length);
            C3144ey eyVar = this.f2157a;
            if (eyVar == null) {
                i = -1;
            } else {
                i = Math.min(length, eyVar.f2189c - eyVar.f2188b);
                System.arraycopy(eyVar.f2187a, eyVar.f2188b, bArr, i2, i);
                eyVar.f2188b += i;
                this.f2158b -= (long) i;
                if (eyVar.f2188b == eyVar.f2189c) {
                    this.f2157a = eyVar.mo38432a();
                    C3145ez.m1914a(eyVar);
                }
            }
            if (i != -1) {
                i2 += i;
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: k */
    private String m1747k(long j) {
        return m1745a(j, C3151fe.f2202a);
    }

    /* renamed from: a */
    public final long mo38350a(byte b, long j) {
        long j2;
        long j3 = 0;
        if (j >= 0) {
            C3144ey eyVar = this.f2157a;
            if (eyVar == null) {
                return -1;
            }
            if (this.f2158b - j >= j) {
                while (true) {
                    long j4 = ((long) (eyVar.f2189c - eyVar.f2188b)) + j2;
                    if (j4 >= j) {
                        break;
                    }
                    eyVar = eyVar.f2192f;
                    j3 = j4;
                }
            } else {
                j2 = this.f2158b;
                while (j2 > j) {
                    eyVar = eyVar.f2193g;
                    j2 -= (long) (eyVar.f2189c - eyVar.f2188b);
                }
            }
            while (j2 < this.f2158b) {
                byte[] bArr = eyVar.f2187a;
                int i = eyVar.f2189c;
                for (int i2 = (int) ((((long) eyVar.f2188b) + j) - j2); i2 < i; i2++) {
                    if (bArr[i2] == b) {
                        return ((long) (i2 - eyVar.f2188b)) + j2;
                    }
                }
                j = ((long) (eyVar.f2189c - eyVar.f2188b)) + j2;
                eyVar = eyVar.f2192f;
                j2 = j;
            }
            return -1;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    /* renamed from: a */
    public final long mo38196a(C3130en enVar, long j) {
        if (enVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (this.f2158b == 0) {
            return -1;
        } else {
            if (j > this.f2158b) {
                j = this.f2158b;
            }
            enVar.mo38242a_(this, j);
            return j;
        }
    }

    /* renamed from: a */
    public final long mo38351a(C3148fc fcVar) {
        if (fcVar != null) {
            long j = 0;
            while (true) {
                long a = fcVar.mo38196a(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (a == -1) {
                    return j;
                }
                j += a;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* renamed from: a */
    public final C3130en mo38352a(int i) {
        int i2;
        int i3;
        if (i >= 128) {
            if (i < 2048) {
                i3 = (i >> 6) | 192;
            } else {
                if (i < 65536) {
                    if (i < 55296 || i > 57343) {
                        i2 = (i >> 12) | 224;
                    } else {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                    }
                } else if (i <= 1114111) {
                    mo38387h((i >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                    i2 = ((i >> 12) & 63) | 128;
                } else {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                }
                mo38387h(i2);
                i3 = ((i >> 6) & 63) | 128;
            }
            mo38387h(i3);
            i = (i & 63) | 128;
        }
        mo38387h(i);
        return this;
    }

    /* renamed from: a */
    public final C3130en mo38353a(C3130en enVar, long j, long j2) {
        if (enVar != null) {
            C3151fe.m1947a(this.f2158b, j, j2);
            if (j2 == 0) {
                return this;
            }
            enVar.f2158b += j2;
            C3144ey eyVar = this.f2157a;
            while (j >= ((long) (eyVar.f2189c - eyVar.f2188b))) {
                j -= (long) (eyVar.f2189c - eyVar.f2188b);
                eyVar = eyVar.f2192f;
            }
            while (j2 > 0) {
                C3144ey eyVar2 = new C3144ey(eyVar);
                eyVar2.f2188b = (int) (((long) eyVar2.f2188b) + j);
                eyVar2.f2189c = Math.min(eyVar2.f2188b + ((int) j2), eyVar2.f2189c);
                if (enVar.f2157a == null) {
                    eyVar2.f2193g = eyVar2;
                    eyVar2.f2192f = eyVar2;
                    enVar.f2157a = eyVar2;
                } else {
                    enVar.f2157a.f2193g.mo38433a(eyVar2);
                }
                j2 -= (long) (eyVar2.f2189c - eyVar2.f2188b);
                eyVar = eyVar.f2192f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: a */
    public final C3130en mo38369c(C3133eq eqVar) {
        if (eqVar != null) {
            eqVar.mo38405a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: a */
    public final C3130en mo38364b(String str) {
        return mo38356a(str, 0, str.length());
    }

    /* renamed from: a */
    public final C3130en mo38356a(String str, int i, int i2) {
        int i3;
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i)));
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 128) {
                    C3144ey e = mo38377e(1);
                    byte[] bArr = e.f2187a;
                    int i4 = e.f2189c - i;
                    int min = Math.min(i2, 8192 - i4);
                    int i5 = i + 1;
                    bArr[i + i4] = (byte) charAt2;
                    while (true) {
                        i = i5;
                        if (i >= min || (charAt = str.charAt(i)) >= 128) {
                            int i6 = (i4 + i) - e.f2189c;
                            e.f2189c += i6;
                            this.f2158b += (long) i6;
                        } else {
                            i5 = i + 1;
                            bArr[i + i4] = (byte) charAt;
                        }
                    }
                    int i62 = (i4 + i) - e.f2189c;
                    e.f2189c += i62;
                    this.f2158b += (long) i62;
                } else {
                    if (charAt2 < 2048) {
                        i3 = (charAt2 >> 6) | 192;
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        mo38387h((charAt2 >> 12) | 224);
                        i3 = ((charAt2 >> 6) & 63) | 128;
                    } else {
                        int i7 = i + 1;
                        char charAt3 = i7 < i2 ? str.charAt(i7) : 0;
                        if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            mo38387h(63);
                            i = i7;
                        } else {
                            int i8 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 0;
                            mo38387h((i8 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                            mo38387h(((i8 >> 12) & 63) | 128);
                            mo38387h(((i8 >> 6) & 63) | 128);
                            mo38387h((i8 & 63) | 128);
                            i += 2;
                        }
                    }
                    mo38387h(i3);
                    mo38387h((int) (charAt2 & '?') | 128);
                    i++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
    }

    /* renamed from: a */
    public final C3130en mo38365b(byte[] bArr) {
        if (bArr != null) {
            return mo38366b(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public final C3130en mo38366b(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            C3151fe.m1947a((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                C3144ey e = mo38377e(1);
                int min = Math.min(i3 - i, 8192 - e.f2189c);
                System.arraycopy(bArr, i, e.f2187a, e.f2189c, min);
                i += min;
                e.f2189c += min;
            }
            this.f2158b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public final C3149fd mo38241a() {
        return C3149fd.f2198b;
    }

    /* renamed from: a */
    public final String mo38359a(Charset charset) {
        try {
            return m1745a(this.f2158b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public final void mo38360a(long j) {
        if (this.f2158b < j) {
            throw new EOFException();
        }
    }

    /* renamed from: a_ */
    public final void mo38242a_(C3130en enVar, long j) {
        C3144ey eyVar;
        if (enVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (enVar != this) {
            C3151fe.m1947a(enVar.f2158b, 0, j);
            while (j > 0) {
                int i = 0;
                if (j < ((long) (enVar.f2157a.f2189c - enVar.f2157a.f2188b))) {
                    C3144ey eyVar2 = this.f2157a != null ? this.f2157a.f2193g : null;
                    if (eyVar2 != null && eyVar2.f2191e) {
                        if ((((long) eyVar2.f2189c) + j) - ((long) (eyVar2.f2190d ? 0 : eyVar2.f2188b)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            enVar.f2157a.mo38434a(eyVar2, (int) j);
                            enVar.f2158b -= j;
                            this.f2158b += j;
                            return;
                        }
                    }
                    C3144ey eyVar3 = enVar.f2157a;
                    int i2 = (int) j;
                    if (i2 <= 0 || i2 > eyVar3.f2189c - eyVar3.f2188b) {
                        throw new IllegalArgumentException();
                    }
                    if (i2 >= 1024) {
                        eyVar = new C3144ey(eyVar3);
                    } else {
                        eyVar = C3145ez.m1913a();
                        System.arraycopy(eyVar3.f2187a, eyVar3.f2188b, eyVar.f2187a, 0, i2);
                    }
                    eyVar.f2189c = eyVar.f2188b + i2;
                    eyVar3.f2188b += i2;
                    eyVar3.f2193g.mo38433a(eyVar);
                    enVar.f2157a = eyVar;
                }
                C3144ey eyVar4 = enVar.f2157a;
                long j2 = (long) (eyVar4.f2189c - eyVar4.f2188b);
                enVar.f2157a = eyVar4.mo38432a();
                if (this.f2157a == null) {
                    this.f2157a = eyVar4;
                    C3144ey eyVar5 = this.f2157a;
                    C3144ey eyVar6 = this.f2157a;
                    C3144ey eyVar7 = this.f2157a;
                    eyVar6.f2193g = eyVar7;
                    eyVar5.f2192f = eyVar7;
                } else {
                    C3144ey a = this.f2157a.f2193g.mo38433a(eyVar4);
                    if (a.f2193g == a) {
                        throw new IllegalStateException();
                    } else if (a.f2193g.f2191e) {
                        int i3 = a.f2189c - a.f2188b;
                        int i4 = 8192 - a.f2193g.f2189c;
                        if (!a.f2193g.f2190d) {
                            i = a.f2193g.f2188b;
                        }
                        if (i3 <= i4 + i) {
                            a.mo38434a(a.f2193g, i3);
                            a.mo38432a();
                            C3145ez.m1914a(a);
                        }
                    }
                }
                enVar.f2158b -= j2;
                this.f2158b += j2;
                j -= j2;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    /* renamed from: b */
    public final byte mo38361b(long j) {
        C3151fe.m1947a(this.f2158b, j, 1);
        C3144ey eyVar = this.f2157a;
        while (true) {
            long j2 = (long) (eyVar.f2189c - eyVar.f2188b);
            if (j < j2) {
                return eyVar.f2187a[eyVar.f2188b + ((int) j)];
            }
            j -= j2;
            eyVar = eyVar.f2192f;
        }
    }

    /* renamed from: b */
    public final C3130en mo38362b() {
        return this;
    }

    /* renamed from: b */
    public final C3130en mo38387h(int i) {
        C3144ey e = mo38377e(1);
        byte[] bArr = e.f2187a;
        int i2 = e.f2189c;
        e.f2189c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f2158b++;
        return this;
    }

    /* renamed from: b */
    public final boolean mo38367b(C3133eq eqVar) {
        int g = eqVar.mo38415g();
        if (g < 0 || this.f2158b - 0 < ((long) g) || eqVar.mo38415g() - 0 < g) {
            return false;
        }
        for (int i = 0; i < g; i++) {
            if (mo38361b(((long) i) + 0) != eqVar.mo38402a(i + 0)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public final C3130en mo38385g(int i) {
        C3144ey e = mo38377e(2);
        byte[] bArr = e.f2187a;
        int i2 = e.f2189c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        e.f2189c = i3 + 1;
        this.f2158b += 2;
        return this;
    }

    /* renamed from: c */
    public final C3133eq mo38370c(long j) {
        return new C3133eq(mo38378e(j));
    }

    /* renamed from: c */
    public final boolean mo38371c() {
        return this.f2158b == 0;
    }

    public final /* synthetic */ Object clone() {
        C3130en enVar = new C3130en();
        if (this.f2158b == 0) {
            return enVar;
        }
        enVar.f2157a = new C3144ey(this.f2157a);
        C3144ey eyVar = enVar.f2157a;
        C3144ey eyVar2 = enVar.f2157a;
        C3144ey eyVar3 = enVar.f2157a;
        eyVar2.f2193g = eyVar3;
        eyVar.f2192f = eyVar3;
        C3144ey eyVar4 = this.f2157a;
        while (true) {
            eyVar4 = eyVar4.f2192f;
            if (eyVar4 != this.f2157a) {
                enVar.f2157a.f2193g.mo38433a(new C3144ey(eyVar4));
            } else {
                enVar.f2158b = this.f2158b;
                return enVar;
            }
        }
    }

    public final void close() {
    }

    /* renamed from: d */
    public final long mo38373d() {
        long j = this.f2158b;
        if (j == 0) {
            return 0;
        }
        C3144ey eyVar = this.f2157a.f2193g;
        return (eyVar.f2189c >= 8192 || !eyVar.f2191e) ? j : j - ((long) (eyVar.f2189c - eyVar.f2188b));
    }

    /* renamed from: d */
    public final C3130en mo38380f(int i) {
        C3144ey e = mo38377e(4);
        byte[] bArr = e.f2187a;
        int i2 = e.f2189c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        e.f2189c = i5 + 1;
        this.f2158b += 4;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final String mo38375d(long j) {
        String k;
        long j2 = 1;
        if (j > 0) {
            long j3 = j - 1;
            if (mo38361b(j3) == 13) {
                k = m1747k(j3);
                j2 = 2;
                mo38382f(j2);
                return k;
            }
        }
        k = m1747k(j);
        mo38382f(j2);
        return k;
    }

    /* renamed from: e */
    public final byte mo38376e() {
        if (this.f2158b != 0) {
            C3144ey eyVar = this.f2157a;
            int i = eyVar.f2188b;
            int i2 = eyVar.f2189c;
            int i3 = i + 1;
            byte b = eyVar.f2187a[i];
            this.f2158b--;
            if (i3 == i2) {
                this.f2157a = eyVar.mo38432a();
                C3145ez.m1914a(eyVar);
            } else {
                eyVar.f2188b = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final C3144ey mo38377e(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        } else if (this.f2157a == null) {
            this.f2157a = C3145ez.m1913a();
            C3144ey eyVar = this.f2157a;
            C3144ey eyVar2 = this.f2157a;
            C3144ey eyVar3 = this.f2157a;
            eyVar2.f2193g = eyVar3;
            eyVar.f2192f = eyVar3;
            return eyVar3;
        } else {
            C3144ey eyVar4 = this.f2157a.f2193g;
            return (eyVar4.f2189c + i > 8192 || !eyVar4.f2191e) ? eyVar4.mo38433a(C3145ez.m1913a()) : eyVar4;
        }
    }

    /* renamed from: e */
    public final byte[] mo38378e(long j) {
        C3151fe.m1947a(this.f2158b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            m1746c(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3130en)) {
            return false;
        }
        C3130en enVar = (C3130en) obj;
        if (this.f2158b != enVar.f2158b) {
            return false;
        }
        long j = 0;
        if (this.f2158b == 0) {
            return true;
        }
        C3144ey eyVar = this.f2157a;
        C3144ey eyVar2 = enVar.f2157a;
        int i = eyVar.f2188b;
        int i2 = eyVar2.f2188b;
        while (j < this.f2158b) {
            long min = (long) Math.min(eyVar.f2189c - i, eyVar2.f2189c - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (((long) i5) < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (eyVar.f2187a[i4] != eyVar2.f2187a[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == eyVar.f2189c) {
                eyVar = eyVar.f2192f;
                i = eyVar.f2188b;
            } else {
                i = i4;
            }
            if (i3 == eyVar2.f2189c) {
                eyVar2 = eyVar2.f2192f;
                i2 = eyVar2.f2188b;
            } else {
                i2 = i3;
            }
            j += min;
        }
        return true;
    }

    /* renamed from: f */
    public final short mo38381f() {
        if (this.f2158b >= 2) {
            C3144ey eyVar = this.f2157a;
            int i = eyVar.f2188b;
            int i2 = eyVar.f2189c;
            if (i2 - i < 2) {
                return (short) (((mo38376e() & UByte.MAX_VALUE) << 8) | (mo38376e() & UByte.MAX_VALUE));
            }
            byte[] bArr = eyVar.f2187a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & UByte.MAX_VALUE) << 8) | (bArr[i3] & UByte.MAX_VALUE);
            this.f2158b -= 2;
            if (i4 == i2) {
                this.f2157a = eyVar.mo38432a();
                C3145ez.m1914a(eyVar);
            } else {
                eyVar.f2188b = i4;
            }
            return (short) b;
        }
        throw new IllegalStateException("size < 2: " + this.f2158b);
    }

    /* renamed from: f */
    public final void mo38382f(long j) {
        while (j > 0) {
            if (this.f2157a != null) {
                int min = (int) Math.min(j, (long) (this.f2157a.f2189c - this.f2157a.f2188b));
                long j2 = (long) min;
                this.f2158b -= j2;
                j -= j2;
                this.f2157a.f2188b += min;
                if (this.f2157a.f2188b == this.f2157a.f2189c) {
                    C3144ey eyVar = this.f2157a;
                    this.f2157a = eyVar.mo38432a();
                    C3145ez.m1914a(eyVar);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final void flush() {
    }

    /* renamed from: g */
    public final int mo38383g() {
        if (this.f2158b >= 4) {
            C3144ey eyVar = this.f2157a;
            int i = eyVar.f2188b;
            int i2 = eyVar.f2189c;
            if (i2 - i < 4) {
                return ((mo38376e() & UByte.MAX_VALUE) << 24) | ((mo38376e() & UByte.MAX_VALUE) << 16) | ((mo38376e() & UByte.MAX_VALUE) << 8) | (mo38376e() & UByte.MAX_VALUE);
            }
            byte[] bArr = eyVar.f2187a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i3] & UByte.MAX_VALUE) << 16);
            int i5 = i4 + 1;
            byte b2 = b | ((bArr[i4] & UByte.MAX_VALUE) << 8);
            int i6 = i5 + 1;
            byte b3 = b2 | (bArr[i5] & UByte.MAX_VALUE);
            this.f2158b -= 4;
            if (i6 == i2) {
                this.f2157a = eyVar.mo38432a();
                C3145ez.m1914a(eyVar);
            } else {
                eyVar.f2188b = i6;
            }
            return b3;
        }
        throw new IllegalStateException("size < 4: " + this.f2158b);
    }

    /* renamed from: g */
    public final C3130en mo38393j(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return mo38387h(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return mo38364b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < C1470C.NANOS_PER_SECOND ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        C3144ey e = mo38377e(i2);
        byte[] bArr = e.f2187a;
        int i3 = e.f2189c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = f2156c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        e.f2189c += i2;
        this.f2158b += (long) i2;
        return this;
    }

    /* renamed from: h */
    public final C3130en mo38391i(long j) {
        if (j == 0) {
            return mo38387h(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        C3144ey e = mo38377e(numberOfTrailingZeros);
        byte[] bArr = e.f2187a;
        int i = e.f2189c;
        for (int i2 = (e.f2189c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f2156c[(int) (15 & j)];
            j >>>= 4;
        }
        e.f2189c += numberOfTrailingZeros;
        this.f2158b += (long) numberOfTrailingZeros;
        return this;
    }

    /* renamed from: h */
    public final short mo38388h() {
        return C3151fe.m1946a(mo38381f());
    }

    public final int hashCode() {
        C3144ey eyVar = this.f2157a;
        if (eyVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = eyVar.f2189c;
            for (int i3 = eyVar.f2188b; i3 < i2; i3++) {
                i = (i * 31) + eyVar.f2187a[i3];
            }
            eyVar = eyVar.f2192f;
        } while (eyVar != this.f2157a);
        return i;
    }

    /* renamed from: i */
    public final int mo38390i() {
        return C3151fe.m1945a(mo38383g());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008b, code lost:
        if (r8 != r9) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008d, code lost:
        r14.f2157a = r6.mo38432a();
        com.uxcam.internals.C3145ez.m1914a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0097, code lost:
        r6.f2188b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0099, code lost:
        if (r1 != false) goto L_0x009f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0073 A[SYNTHETIC] */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long mo38392j() {
        /*
            r14 = this;
            long r0 = r14.f2158b
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00a6
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000b:
            com.uxcam.internals.ey r6 = r14.f2157a
            byte[] r7 = r6.f2187a
            int r8 = r6.f2188b
            int r9 = r6.f2189c
        L_0x0013:
            if (r8 >= r9) goto L_0x008b
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x003a
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002f
            int r11 = r10 + -97
        L_0x002c:
            int r11 = r11 + 10
            goto L_0x003a
        L_0x002f:
            r11 = 65
            if (r10 < r11) goto L_0x006f
            r11 = 70
            if (r10 > r11) goto L_0x006f
            int r11 = r10 + -65
            goto L_0x002c
        L_0x003a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x004a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0013
        L_0x004a:
            com.uxcam.internals.en r0 = new com.uxcam.internals.en
            r0.<init>()
            com.uxcam.internals.en r0 = r0.mo38391i((long) r4)
            com.uxcam.internals.en r0 = r0.mo38387h((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Number too large: "
            r2.<init>(r3)
            java.lang.String r0 = r0.mo38395l()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x006f:
            if (r0 == 0) goto L_0x0073
            r1 = 1
            goto L_0x008b
        L_0x0073:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.<init>(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x008b:
            if (r8 != r9) goto L_0x0097
            com.uxcam.internals.ey r7 = r6.mo38432a()
            r14.f2157a = r7
            com.uxcam.internals.C3145ez.m1914a(r6)
            goto L_0x0099
        L_0x0097:
            r6.f2188b = r8
        L_0x0099:
            if (r1 != 0) goto L_0x009f
            com.uxcam.internals.ey r6 = r14.f2157a
            if (r6 != 0) goto L_0x000b
        L_0x009f:
            long r1 = r14.f2158b
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.f2158b = r1
            return r4
        L_0x00a6:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3130en.mo38392j():long");
    }

    /* renamed from: k */
    public final C3133eq mo38394k() {
        return new C3133eq(mo38397n());
    }

    /* renamed from: l */
    public final String mo38395l() {
        try {
            return m1745a(this.f2158b, C3151fe.f2202a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: m */
    public final String mo38396m() {
        long a = mo38350a((byte) 10, 0);
        if (a != -1) {
            return mo38375d(a);
        }
        C3130en enVar = new C3130en();
        mo38353a(enVar, 0, Math.min(32, this.f2158b));
        throw new EOFException("\\n not found: size=" + this.f2158b + " content=" + enVar.mo38394k().mo38412e() + "…");
    }

    /* renamed from: n */
    public final byte[] mo38397n() {
        try {
            return mo38378e(this.f2158b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: o */
    public final void mo38398o() {
        try {
            mo38382f(this.f2158b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: p */
    public final long mo38399p() {
        return mo38350a((byte) 0, 0);
    }

    /* renamed from: q */
    public final /* bridge */ /* synthetic */ C3131eo mo38400q() {
        return this;
    }

    public final String toString() {
        if (this.f2158b <= 2147483647L) {
            int i = (int) this.f2158b;
            return (i == 0 ? C3133eq.f2160b : new C3146fa(this, i)).toString();
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f2158b);
    }
}
