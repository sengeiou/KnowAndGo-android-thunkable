package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzdao implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final Object lock = new Object();
    private boolean zzfxf = false;
    private boolean zzfxg = false;
    private final zzdba zzgoc;
    private final zzdau zzgod;

    zzdao(@NonNull Context context, @NonNull Looper looper, @NonNull zzdau zzdau) {
        this.zzgod = zzdau;
        this.zzgoc = new zzdba(context, looper, this, this);
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    public final void onConnectionSuspended(int i) {
    }

    /* access modifiers changed from: package-private */
    public final void zzanh() {
        synchronized (this.lock) {
            if (!this.zzfxf) {
                this.zzfxf = true;
                this.zzgoc.checkAvailabilityAndConnect();
            }
        }
    }

    private final void zzakh() {
        synchronized (this.lock) {
            if (this.zzgoc.isConnected() || this.zzgoc.isConnecting()) {
                this.zzgoc.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.lock) {
            if (!this.zzfxg) {
                this.zzfxg = true;
                try {
                    this.zzgoc.zzanm().zza(new zzday(this.zzgod.toByteArray()));
                    zzakh();
                } catch (Exception unused) {
                    zzakh();
                } catch (Throwable th) {
                    zzakh();
                    throw th;
                }
            }
        }
    }
}
