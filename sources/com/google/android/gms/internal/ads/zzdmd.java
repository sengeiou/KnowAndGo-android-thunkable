package com.google.android.gms.internal.ads;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzdmd {
    private final ConcurrentHashMap<zzdme, List<Throwable>> zzhby = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzhbz = new ReferenceQueue<>();

    zzdmd() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.zzhbz.poll();
        while (poll != null) {
            this.zzhby.remove(poll);
            poll = this.zzhbz.poll();
        }
        List<Throwable> list = this.zzhby.get(new zzdme(th, (ReferenceQueue<Throwable>) null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zzhby.putIfAbsent(new zzdme(th, this.zzhbz), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
