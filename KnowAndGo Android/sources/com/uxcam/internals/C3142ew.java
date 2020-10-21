package com.uxcam.internals;

import android.support.p002v4.media.session.PlaybackStateCompat;

/* renamed from: com.uxcam.internals.ew */
final class C3142ew implements C3131eo {

    /* renamed from: a */
    public final C3130en f2181a = new C3130en();

    /* renamed from: b */
    public final C3147fb f2182b;

    /* renamed from: c */
    boolean f2183c;

    C3142ew(C3147fb fbVar) {
        if (fbVar != null) {
            this.f2182b = fbVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    /* renamed from: a */
    public final long mo38351a(C3148fc fcVar) {
        if (fcVar != null) {
            long j = 0;
            while (true) {
                long a = fcVar.mo38196a(this.f2181a, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (a == -1) {
                    return j;
                }
                j += a;
                mo38400q();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* renamed from: a */
    public final C3149fd mo38241a() {
        return this.f2182b.mo38241a();
    }

    /* renamed from: a_ */
    public final void mo38242a_(C3130en enVar, long j) {
        if (!this.f2183c) {
            this.f2181a.mo38242a_(enVar, j);
            mo38400q();
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: b */
    public final C3130en mo38362b() {
        return this.f2181a;
    }

    /* renamed from: b */
    public final C3131eo mo38364b(String str) {
        if (!this.f2183c) {
            this.f2181a.mo38364b(str);
            return mo38400q();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: b */
    public final C3131eo mo38365b(byte[] bArr) {
        if (!this.f2183c) {
            this.f2181a.mo38365b(bArr);
            return mo38400q();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: b */
    public final C3131eo mo38366b(byte[] bArr, int i, int i2) {
        if (!this.f2183c) {
            this.f2181a.mo38366b(bArr, i, i2);
            return mo38400q();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: c */
    public final C3131eo mo38369c(C3133eq eqVar) {
        if (!this.f2183c) {
            this.f2181a.mo38369c(eqVar);
            return mo38400q();
        }
        throw new IllegalStateException("closed");
    }

    public final void close() {
        if (!this.f2183c) {
            Throwable th = null;
            try {
                if (this.f2181a.f2158b > 0) {
                    this.f2182b.mo38242a_(this.f2181a, this.f2181a.f2158b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f2182b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f2183c = true;
            if (th != null) {
                C3151fe.m1948a(th);
            }
        }
    }

    /* renamed from: f */
    public final C3131eo mo38380f(int i) {
        if (!this.f2183c) {
            this.f2181a.mo38380f(i);
            return mo38400q();
        }
        throw new IllegalStateException("closed");
    }

    public final void flush() {
        if (!this.f2183c) {
            if (this.f2181a.f2158b > 0) {
                this.f2182b.mo38242a_(this.f2181a, this.f2181a.f2158b);
            }
            this.f2182b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: g */
    public final C3131eo mo38385g(int i) {
        if (!this.f2183c) {
            this.f2181a.mo38385g(i);
            return mo38400q();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: h */
    public final C3131eo mo38387h(int i) {
        if (!this.f2183c) {
            this.f2181a.mo38387h(i);
            return mo38400q();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: i */
    public final C3131eo mo38391i(long j) {
        if (!this.f2183c) {
            this.f2181a.mo38391i(j);
            return mo38400q();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: j */
    public final C3131eo mo38393j(long j) {
        if (!this.f2183c) {
            this.f2181a.mo38393j(j);
            return mo38400q();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: q */
    public final C3131eo mo38400q() {
        if (!this.f2183c) {
            long d = this.f2181a.mo38373d();
            if (d > 0) {
                this.f2182b.mo38242a_(this.f2181a, d);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final String toString() {
        return "buffer(" + this.f2182b + ")";
    }
}
