package com.uxcam.internals;

import com.uxcam.internals.C3015cc;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.uxcam.internals.br */
public final class C2994br {

    /* renamed from: a */
    private int f1589a = 64;

    /* renamed from: b */
    private int f1590b = 5;

    /* renamed from: c */
    private Runnable f1591c;

    /* renamed from: d */
    private ExecutorService f1592d;

    /* renamed from: e */
    private final Deque f1593e = new ArrayDeque();

    /* renamed from: f */
    private final Deque f1594f = new ArrayDeque();

    /* renamed from: g */
    private final Deque f1595g = new ArrayDeque();

    /* renamed from: a */
    private synchronized ExecutorService m1269a() {
        if (this.f1592d == null) {
            this.f1592d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C3030cl.m1426a("OkHttp Dispatcher", false));
        }
        return this.f1592d;
    }

    /* renamed from: b */
    private void m1270b() {
        if (this.f1594f.size() < this.f1589a && !this.f1593e.isEmpty()) {
            Iterator it = this.f1593e.iterator();
            while (it.hasNext()) {
                C3015cc.C3016aa aaVar = (C3015cc.C3016aa) it.next();
                if (m1272c(aaVar) < this.f1590b) {
                    it.remove();
                    this.f1594f.add(aaVar);
                    m1269a().execute(aaVar);
                }
                if (this.f1594f.size() >= this.f1589a) {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    private synchronized int m1271c() {
        return this.f1594f.size() + this.f1595g.size();
    }

    /* renamed from: c */
    private int m1272c(C3015cc.C3016aa aaVar) {
        int i = 0;
        for (C3015cc.C3016aa a : this.f1594f) {
            if (a.mo38163a().equals(aaVar.mo38163a())) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo38101a(C3015cc.C3016aa aaVar) {
        if (this.f1594f.size() >= this.f1589a || m1272c(aaVar) >= this.f1590b) {
            this.f1593e.add(aaVar);
            return;
        }
        this.f1594f.add(aaVar);
        m1269a().execute(aaVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo38102b(C3015cc.C3016aa aaVar) {
        int c;
        Runnable runnable;
        Deque deque = this.f1594f;
        synchronized (this) {
            if (deque.remove(aaVar)) {
                m1270b();
                c = m1271c();
                runnable = this.f1591c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (c == 0 && runnable != null) {
            runnable.run();
        }
    }
}
