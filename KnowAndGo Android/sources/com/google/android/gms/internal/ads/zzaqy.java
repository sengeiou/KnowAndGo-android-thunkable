package com.google.android.gms.internal.ads;

import java.lang.Thread;

final class zzaqy implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzdle;
    private final /* synthetic */ zzaqx zzdlf;

    zzaqy(zzaqx zzaqx, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdlf = zzaqx;
        this.zzdle = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzdlf.zza(thread, th);
            if (this.zzdle != null) {
                this.zzdle.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            if (this.zzdle != null) {
                this.zzdle.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
