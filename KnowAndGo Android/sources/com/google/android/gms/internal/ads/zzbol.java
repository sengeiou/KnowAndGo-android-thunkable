package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.WorkerThread;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class zzbol extends zzbnf {
    private final Executor zzffv;
    private final zzaga zzfib;
    private final Runnable zzfic;

    public zzbol(zzaga zzaga, Runnable runnable, Executor executor) {
        this.zzfib = zzaga;
        this.zzfic = runnable;
        this.zzffv = executor;
    }

    public final zzaar getVideoController() {
        return null;
    }

    public final void zza(ViewGroup viewGroup, zzyd zzyd) {
    }

    public final View zzafi() {
        return null;
    }

    public final zzcxn zzafj() {
        return null;
    }

    public final int zzafk() {
        return 0;
    }

    public final void zzpm() {
    }

    @WorkerThread
    public final void zzafl() {
        this.zzffv.execute(new zzbon(this, new zzbom(new AtomicReference(this.zzfic))));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(Runnable runnable) {
        try {
            if (!this.zzfib.zzq(ObjectWrapper.wrap(runnable))) {
                runnable.run();
            }
        } catch (RemoteException unused) {
            runnable.run();
        }
    }
}
