package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.concurrent.Future;
import javax.annotation.concurrent.GuardedBy;

@zzard
public final class zzwb {
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    @Nullable
    public zzvu zzbwo;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public boolean zzbwz;
    private final Context zzlj;

    zzwb(Context context) {
        this.zzlj = context;
    }

    /* access modifiers changed from: package-private */
    public final Future<InputStream> zzb(zzvv zzvv) {
        zzwc zzwc = new zzwc(this);
        zzwd zzwd = new zzwd(this, zzvv, zzwc);
        zzwh zzwh = new zzwh(this, zzwc);
        synchronized (this.lock) {
            this.zzbwo = new zzvu(this.zzlj, zzk.zzlu().zzwr(), zzwd, zzwh);
            this.zzbwo.checkAvailabilityAndConnect();
        }
        return zzwc;
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbwo != null) {
                this.zzbwo.disconnect();
                this.zzbwo = null;
                Binder.flushPendingCommands();
            }
        }
    }
}
