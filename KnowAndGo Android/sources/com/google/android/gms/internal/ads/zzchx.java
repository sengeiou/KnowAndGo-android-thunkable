package com.google.android.gms.internal.ads;

import android.os.Binder;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.InputStream;

public abstract class zzchx implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final Object mLock = new Object();
    protected final zzbbr<InputStream> zzddv = new zzbbr<>();
    protected boolean zzfxf = false;
    protected boolean zzfxg = false;
    protected zzarx zzfxh;
    @VisibleForTesting(otherwise = 3)
    @GuardedBy("mLock")
    protected zzarf zzfxi;

    /* access modifiers changed from: protected */
    public final void zzakh() {
        synchronized (this.mLock) {
            this.zzfxg = true;
            if (this.zzfxi.isConnected() || this.zzfxi.isConnecting()) {
                this.zzfxi.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    public void onConnectionSuspended(int i) {
        zzawz.zzdp("Cannot connect to remote service, fallback to local instance.");
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzawz.zzdp("Disconnected from remote ad request service.");
        this.zzddv.setException(new zzcie(0));
    }
}
