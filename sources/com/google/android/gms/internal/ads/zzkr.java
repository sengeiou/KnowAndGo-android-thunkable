package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

final class zzkr implements ThreadFactory {
    private final /* synthetic */ String zzaqz;

    zzkr(String str) {
        this.zzaqz = str;
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.zzaqz);
    }
}
