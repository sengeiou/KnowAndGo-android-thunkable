package com.uxcam.internals;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.uxcam.internals.fd */
public class C3149fd {

    /* renamed from: b */
    public static final C3149fd f2198b = new C3149fd() {
        /* renamed from: a */
        public final C3149fd mo38420a(long j) {
            return this;
        }

        /* renamed from: a */
        public final C3149fd mo38421a(long j, TimeUnit timeUnit) {
            return this;
        }

        /* renamed from: f_ */
        public final void mo38427f_() {
        }
    };

    /* renamed from: a */
    private boolean f2199a;

    /* renamed from: c */
    private long f2200c;

    /* renamed from: d */
    private long f2201d;

    /* renamed from: a */
    public C3149fd mo38420a(long j) {
        this.f2199a = true;
        this.f2200c = j;
        return this;
    }

    /* renamed from: a */
    public C3149fd mo38421a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: ".concat(String.valueOf(j)));
        } else if (timeUnit != null) {
            this.f2201d = timeUnit.toNanos(j);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    /* renamed from: c */
    public long mo38422c() {
        if (this.f2199a) {
            return this.f2200c;
        }
        throw new IllegalStateException("No deadline");
    }

    /* renamed from: c_ */
    public long mo38423c_() {
        return this.f2201d;
    }

    /* renamed from: d */
    public C3149fd mo38424d() {
        this.f2201d = 0;
        return this;
    }

    /* renamed from: d_ */
    public boolean mo38425d_() {
        return this.f2199a;
    }

    /* renamed from: e_ */
    public C3149fd mo38426e_() {
        this.f2199a = false;
        return this;
    }

    /* renamed from: f_ */
    public void mo38427f_() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f2199a && this.f2200c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
