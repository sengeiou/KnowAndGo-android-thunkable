package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzcyu implements ThreadFactory {
    private final AtomicInteger zzxw = new AtomicInteger(1);

    zzcyu() {
    }

    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.zzxw.getAndIncrement();
        StringBuilder sb = new StringBuilder(25);
        sb.append("AdWorker(NG) #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
