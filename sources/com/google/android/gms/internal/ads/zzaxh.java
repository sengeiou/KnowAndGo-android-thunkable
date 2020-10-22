package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzaxh implements ThreadFactory {
    private final /* synthetic */ String zzdvs;
    private final AtomicInteger zzxw = new AtomicInteger(1);

    zzaxh(String str) {
        this.zzdvs = str;
    }

    public final Thread newThread(Runnable runnable) {
        String str = this.zzdvs;
        int andIncrement = this.zzxw.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
