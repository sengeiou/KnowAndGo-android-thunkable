package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class zzi implements zzab {
    private final Executor zzv;

    public zzi(Handler handler) {
        this.zzv = new zzj(this, handler);
    }

    public final void zzb(zzr<?> zzr, zzy<?> zzy) {
        zza(zzr, zzy, (Runnable) null);
    }

    public final void zza(zzr<?> zzr, zzy<?> zzy, Runnable runnable) {
        zzr.zzk();
        zzr.zzb("post-response");
        this.zzv.execute(new zzk(zzr, zzy, runnable));
    }

    public final void zza(zzr<?> zzr, zzaf zzaf) {
        zzr.zzb("post-error");
        this.zzv.execute(new zzk(zzr, zzy.zzc(zzaf), (Runnable) null));
    }
}
