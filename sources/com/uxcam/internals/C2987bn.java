package com.uxcam.internals;

import com.uxcam.internals.C3047cx;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.uxcam.internals.bn */
public final class C2987bn {

    /* renamed from: a */
    static final Executor f1554a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C3030cl.m1426a("OkHttp ConnectionPool", true));

    /* renamed from: g */
    static final /* synthetic */ boolean f1555g = (!C2987bn.class.desiredAssertionStatus());

    /* renamed from: b */
    final int f1556b;

    /* renamed from: c */
    final Runnable f1557c;

    /* renamed from: d */
    final Deque f1558d;

    /* renamed from: e */
    final C3044cu f1559e;

    /* renamed from: f */
    boolean f1560f;

    /* renamed from: h */
    private final long f1561h;

    public C2987bn() {
        this(TimeUnit.MINUTES);
    }

    private C2987bn(TimeUnit timeUnit) {
        this.f1557c = new Runnable() {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002b */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r6 = this;
                L_0x0000:
                    com.uxcam.internals.bn r0 = com.uxcam.internals.C2987bn.this
                    long r1 = java.lang.System.nanoTime()
                    long r0 = r0.mo38086a(r1)
                    r2 = -1
                    int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r2 != 0) goto L_0x0011
                    return
                L_0x0011:
                    r2 = 0
                    int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r2 <= 0) goto L_0x0000
                    r2 = 1000000(0xf4240, double:4.940656E-318)
                    long r4 = r0 / r2
                    long r2 = r2 * r4
                    long r0 = r0 - r2
                    com.uxcam.internals.bn r2 = com.uxcam.internals.C2987bn.this
                    monitor-enter(r2)
                    com.uxcam.internals.bn r3 = com.uxcam.internals.C2987bn.this     // Catch:{ InterruptedException -> 0x002b }
                    int r0 = (int) r0     // Catch:{ InterruptedException -> 0x002b }
                    r3.wait(r4, r0)     // Catch:{ InterruptedException -> 0x002b }
                    goto L_0x002b
                L_0x0029:
                    r0 = move-exception
                    goto L_0x002d
                L_0x002b:
                    monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                    goto L_0x0000
                L_0x002d:
                    monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C2987bn.C29881.run():void");
            }
        };
        this.f1558d = new ArrayDeque();
        this.f1559e = new C3044cu();
        this.f1556b = 5;
        this.f1561h = timeUnit.toNanos(5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final long mo38086a(long j) {
        int size;
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            C3043ct ctVar = null;
            int i = 0;
            int i2 = 0;
            for (C3043ct ctVar2 : this.f1558d) {
                List list = ctVar2.f1854i;
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        size = list.size();
                        break;
                    }
                    Reference reference = (Reference) list.get(i3);
                    if (reference.get() != null) {
                        i3++;
                    } else {
                        C3117ef.m1702b().mo38317a("A connection to " + ctVar2.f1846a.f1768a.f1397a + " was leaked. Did you forget to close a response body?", ((C3047cx.C3048aa) reference).f1882a);
                        list.remove(i3);
                        ctVar2.f1855j = true;
                        if (list.isEmpty()) {
                            ctVar2.f1856k = j - this.f1561h;
                            size = 0;
                            break;
                        }
                    }
                }
                if (size > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - ctVar2.f1856k;
                    if (j3 > j2) {
                        ctVar = ctVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f1561h) {
                if (i <= this.f1556b) {
                    if (i > 0) {
                        long j4 = this.f1561h - j2;
                        return j4;
                    } else if (i2 > 0) {
                        long j5 = this.f1561h;
                        return j5;
                    } else {
                        this.f1560f = false;
                        return -1;
                    }
                }
            }
            this.f1558d.remove(ctVar);
            C3030cl.m1429a(ctVar.f1847b);
            return 0;
        }
    }
}
