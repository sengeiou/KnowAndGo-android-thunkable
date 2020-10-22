package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

final class zzsz implements ThreadFactory {
    private final /* synthetic */ String zzaqz;

    zzsz(String str) {
        this.zzaqz = str;
    }

    public final Thread newThread(@NonNull Runnable runnable) {
        return new Thread(runnable, this.zzaqz);
    }
}
