package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzavu implements ThreadFactory {
    private final AtomicInteger zzxw = new AtomicInteger(1);

    zzavu(zzavg zzavg) {
    }

    public final Thread newThread(@NonNull Runnable runnable) {
        int andIncrement = this.zzxw.getAndIncrement();
        StringBuilder sb = new StringBuilder(42);
        sb.append("AdWorker(SCION_TASK_EXECUTOR) #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
