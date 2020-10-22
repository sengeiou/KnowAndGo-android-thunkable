package com.uxcam.internals;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: com.uxcam.internals.eu */
public final class C3137eu implements C3148fc {

    /* renamed from: a */
    private final C3132ep f2171a;

    /* renamed from: b */
    private final Inflater f2172b;

    /* renamed from: c */
    private int f2173c;

    /* renamed from: d */
    private boolean f2174d;

    C3137eu(C3132ep epVar, Inflater inflater) {
        if (epVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f2171a = epVar;
            this.f2172b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    /* renamed from: b */
    private void m1859b() {
        if (this.f2173c != 0) {
            int remaining = this.f2173c - this.f2172b.getRemaining();
            this.f2173c -= remaining;
            this.f2171a.mo38382f((long) remaining);
        }
    }

    /* renamed from: a */
    public final long mo38196a(C3130en enVar, long j) {
        C3144ey e;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (this.f2174d) {
            throw new IllegalStateException("closed");
        } else if (i == 0) {
            return 0;
        } else {
            while (true) {
                boolean z = false;
                if (this.f2172b.needsInput()) {
                    m1859b();
                    if (this.f2172b.getRemaining() != 0) {
                        throw new IllegalStateException("?");
                    } else if (this.f2171a.mo38371c()) {
                        z = true;
                    } else {
                        C3144ey eyVar = this.f2171a.mo38362b().f2157a;
                        this.f2173c = eyVar.f2189c - eyVar.f2188b;
                        this.f2172b.setInput(eyVar.f2187a, eyVar.f2188b, this.f2173c);
                    }
                }
                try {
                    e = enVar.mo38377e(1);
                    int inflate = this.f2172b.inflate(e.f2187a, e.f2189c, 8192 - e.f2189c);
                    if (inflate > 0) {
                        e.f2189c += inflate;
                        long j2 = (long) inflate;
                        enVar.f2158b += j2;
                        return j2;
                    } else if (this.f2172b.finished()) {
                        break;
                    } else if (this.f2172b.needsDictionary()) {
                        break;
                    } else if (z) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            m1859b();
            if (e.f2188b != e.f2189c) {
                return -1;
            }
            enVar.f2157a = e.mo38432a();
            C3145ez.m1914a(e);
            return -1;
        }
    }

    /* renamed from: a */
    public final C3149fd mo38197a() {
        return this.f2171a.mo38197a();
    }

    public final void close() {
        if (!this.f2174d) {
            this.f2172b.end();
            this.f2174d = true;
            this.f2171a.close();
        }
    }
}
