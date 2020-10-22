package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

final class zzbbn implements Executor {
    private final Handler zzeai = new zzaxa(Looper.getMainLooper());

    zzbbn() {
    }

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzk.zzlg();
                zzaxi.zza(zzk.zzlk().getApplicationContext(), th);
                throw th;
            }
        } else {
            this.zzeai.post(runnable);
        }
    }
}
