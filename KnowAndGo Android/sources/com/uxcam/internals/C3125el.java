package com.uxcam.internals;

import com.polidea.rxandroidble.ClientComponent;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.uxcam.internals.el */
public class C3125el extends C3149fd {

    /* renamed from: a */
    private static final long f2144a = TimeUnit.SECONDS.toMillis(60);

    /* renamed from: c */
    private static final long f2145c = TimeUnit.MILLISECONDS.toNanos(f2144a);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static C3125el f2146d;

    /* renamed from: e */
    private boolean f2147e;

    /* renamed from: f */
    private C3125el f2148f;

    /* renamed from: g */
    private long f2149g;

    /* renamed from: com.uxcam.internals.el$aa */
    static final class C3128aa extends Thread {
        public C3128aa() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.mo38292a();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<com.uxcam.internals.el> r0 = com.uxcam.internals.C3125el.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                com.uxcam.internals.el r1 = com.uxcam.internals.C3125el.m1730e()     // Catch:{ all -> 0x001b }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x001b }
                goto L_0x0000
            L_0x000b:
                com.uxcam.internals.el r2 = com.uxcam.internals.C3125el.f2146d     // Catch:{ all -> 0x001b }
                if (r1 != r2) goto L_0x0016
                com.uxcam.internals.C3125el unused = com.uxcam.internals.C3125el.f2146d = null     // Catch:{ all -> 0x001b }
                monitor-exit(r0)     // Catch:{ all -> 0x001b }
                return
            L_0x0016:
                monitor-exit(r0)     // Catch:{ all -> 0x001b }
                r1.mo38292a()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x001b:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x001b }
                throw r1     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3125el.C3128aa.run():void");
        }
    }

    /* renamed from: a */
    private static synchronized void m1728a(C3125el elVar, long j, boolean z) {
        synchronized (C3125el.class) {
            if (f2146d == null) {
                f2146d = new C3125el();
                new C3128aa().start();
            }
            long nanoTime = System.nanoTime();
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i != 0 && z) {
                elVar.f2149g = Math.min(j, elVar.mo38422c() - nanoTime) + nanoTime;
            } else if (i != 0) {
                elVar.f2149g = j + nanoTime;
            } else if (z) {
                elVar.f2149g = elVar.mo38422c();
            } else {
                throw new AssertionError();
            }
            long j2 = elVar.f2149g - nanoTime;
            C3125el elVar2 = f2146d;
            while (true) {
                if (elVar2.f2148f == null) {
                    break;
                } else if (j2 < elVar2.f2148f.f2149g - nanoTime) {
                    break;
                } else {
                    elVar2 = elVar2.f2148f;
                }
            }
            elVar.f2148f = elVar2.f2148f;
            elVar2.f2148f = elVar;
            if (elVar2 == f2146d) {
                C3125el.class.notify();
            }
        }
    }

    /* renamed from: a */
    private static synchronized boolean m1729a(C3125el elVar) {
        boolean z;
        synchronized (C3125el.class) {
            C3125el elVar2 = f2146d;
            while (true) {
                if (elVar2 == null) {
                    z = true;
                    break;
                } else if (elVar2.f2148f == elVar) {
                    elVar2.f2148f = elVar.f2148f;
                    elVar.f2148f = null;
                    z = false;
                    break;
                } else {
                    elVar2 = elVar2.f2148f;
                }
            }
        }
        return z;
    }

    /* renamed from: e */
    static C3125el m1730e() {
        C3125el elVar = f2146d.f2148f;
        if (elVar == null) {
            long nanoTime = System.nanoTime();
            C3125el.class.wait(f2144a);
            if (f2146d.f2148f != null || System.nanoTime() - nanoTime < f2145c) {
                return null;
            }
            return f2146d;
        }
        long nanoTime2 = elVar.f2149g - System.nanoTime();
        if (nanoTime2 > 0) {
            long j = nanoTime2 / 1000000;
            C3125el.class.wait(j, (int) (nanoTime2 - (1000000 * j)));
            return null;
        }
        f2146d.f2148f = elVar.f2148f;
        elVar.f2148f = null;
        return elVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public IOException mo38291a(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException(ClientComponent.NamedSchedulers.TIMEOUT);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo38292a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo38343a(boolean z) {
        if (mo38346b_() && z) {
            throw mo38291a((IOException) null);
        }
    }

    /* renamed from: a_ */
    public final void mo38344a_() {
        if (!this.f2147e) {
            long c_ = mo38423c_();
            boolean d_ = mo38425d_();
            if (c_ != 0 || d_) {
                this.f2147e = true;
                m1728a(this, c_, d_);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final IOException mo38345b(IOException iOException) {
        return !mo38346b_() ? iOException : mo38291a(iOException);
    }

    /* renamed from: b_ */
    public final boolean mo38346b_() {
        if (!this.f2147e) {
            return false;
        }
        this.f2147e = false;
        return m1729a(this);
    }
}
