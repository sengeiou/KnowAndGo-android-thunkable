package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzdz implements ThreadFactory {
    private final ThreadFactory zzxv = Executors.defaultThreadFactory();
    private final AtomicInteger zzxw = new AtomicInteger(1);

    zzdz() {
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.zzxv.newThread(runnable);
        int andIncrement = this.zzxw.getAndIncrement();
        StringBuilder sb = new StringBuilder(16);
        sb.append("gads-");
        sb.append(andIncrement);
        newThread.setName(sb.toString());
        return newThread;
    }
}
