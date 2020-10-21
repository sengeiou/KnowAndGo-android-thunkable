package com.uxcam.internals;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* renamed from: com.uxcam.internals.et */
public final class C3136et implements C3148fc {

    /* renamed from: a */
    private int f2166a = 0;

    /* renamed from: b */
    private final C3132ep f2167b;

    /* renamed from: c */
    private final Inflater f2168c;

    /* renamed from: d */
    private final C3137eu f2169d;

    /* renamed from: e */
    private final CRC32 f2170e = new CRC32();

    public C3136et(C3148fc fcVar) {
        if (fcVar != null) {
            this.f2168c = new Inflater(true);
            this.f2167b = C3138ev.m1863a(fcVar);
            this.f2169d = new C3137eu(this.f2167b, this.f2168c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    private void m1855a(C3130en enVar, long j, long j2) {
        C3144ey eyVar = enVar.f2157a;
        while (j >= ((long) (eyVar.f2189c - eyVar.f2188b))) {
            j -= (long) (eyVar.f2189c - eyVar.f2188b);
            eyVar = eyVar.f2192f;
        }
        while (j2 > 0) {
            int i = (int) (((long) eyVar.f2188b) + j);
            int min = (int) Math.min((long) (eyVar.f2189c - i), j2);
            this.f2170e.update(eyVar.f2187a, i, min);
            j2 -= (long) min;
            eyVar = eyVar.f2192f;
            j = 0;
        }
    }

    /* renamed from: a */
    private static void m1856a(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }

    /* renamed from: a */
    public final long mo38196a(C3130en enVar, long j) {
        long j2;
        C3130en enVar2 = enVar;
        long j3 = j;
        int i = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (i == 0) {
            return 0;
        } else {
            if (this.f2166a == 0) {
                this.f2167b.mo38360a(10);
                byte b = this.f2167b.mo38362b().mo38361b(3);
                boolean z = ((b >> 1) & 1) == 1;
                if (z) {
                    m1855a(this.f2167b.mo38362b(), 0, 10);
                }
                m1856a("ID1ID2", 8075, (int) this.f2167b.mo38381f());
                this.f2167b.mo38382f(8);
                if (((b >> 2) & 1) == 1) {
                    this.f2167b.mo38360a(2);
                    if (z) {
                        m1855a(this.f2167b.mo38362b(), 0, 2);
                    }
                    long h = (long) this.f2167b.mo38362b().mo38388h();
                    this.f2167b.mo38360a(h);
                    if (z) {
                        j2 = h;
                        m1855a(this.f2167b.mo38362b(), 0, h);
                    } else {
                        j2 = h;
                    }
                    this.f2167b.mo38382f(j2);
                }
                if (((b >> 3) & 1) == 1) {
                    long p = this.f2167b.mo38399p();
                    if (p != -1) {
                        if (z) {
                            m1855a(this.f2167b.mo38362b(), 0, p + 1);
                        }
                        this.f2167b.mo38382f(p + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (((b >> 4) & 1) == 1) {
                    long p2 = this.f2167b.mo38399p();
                    if (p2 != -1) {
                        if (z) {
                            m1855a(this.f2167b.mo38362b(), 0, p2 + 1);
                        }
                        this.f2167b.mo38382f(p2 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (z) {
                    m1856a("FHCRC", (int) this.f2167b.mo38388h(), (int) (short) ((int) this.f2170e.getValue()));
                    this.f2170e.reset();
                }
                this.f2166a = 1;
            }
            if (this.f2166a == 1) {
                long j4 = enVar2.f2158b;
                long a = this.f2169d.mo38196a(enVar2, j3);
                if (a != -1) {
                    m1855a(enVar, j4, a);
                    return a;
                }
                this.f2166a = 2;
            }
            if (this.f2166a == 2) {
                m1856a("CRC", this.f2167b.mo38390i(), (int) this.f2170e.getValue());
                m1856a("ISIZE", this.f2167b.mo38390i(), (int) this.f2168c.getBytesWritten());
                this.f2166a = 3;
                if (!this.f2167b.mo38371c()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    /* renamed from: a */
    public final C3149fd mo38197a() {
        return this.f2167b.mo38197a();
    }

    public final void close() {
        this.f2169d.close();
    }
}
