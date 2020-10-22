package com.google.android.gms.internal.ads;

import java.lang.Thread;

final class zzaqz implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ zzaqx zzdlf;
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzdlg;

    zzaqz(zzaqx zzaqx, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdlf = zzaqx;
        this.zzdlg = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzdlf.zza(thread, th);
            if (this.zzdlg != null) {
                this.zzdlg.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            if (this.zzdlg != null) {
                this.zzdlg.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
