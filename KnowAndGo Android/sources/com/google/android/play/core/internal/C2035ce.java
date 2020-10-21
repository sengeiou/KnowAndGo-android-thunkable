package com.google.android.play.core.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.play.core.internal.ce */
final class C2035ce {

    /* renamed from: a */
    private final ConcurrentHashMap<C2034cd, List<Throwable>> f773a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b */
    private final ReferenceQueue<Throwable> f774b = new ReferenceQueue<>();

    C2035ce() {
    }

    /* renamed from: a */
    public final List<Throwable> mo33605a(Throwable th) {
        while (true) {
            Reference<? extends Throwable> poll = this.f774b.poll();
            if (poll == null) {
                break;
            }
            this.f773a.remove(poll);
        }
        List<Throwable> list = this.f773a.get(new C2034cd(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f773a.putIfAbsent(new C2034cd(th, this.f774b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
