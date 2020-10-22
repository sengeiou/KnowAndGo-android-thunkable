package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

public final class zzchv extends zzchx {
    public zzchv(Context context) {
        this.zzfxi = new zzarf(context, zzk.zzlu().zzwr(), this, this);
    }

    public final zzbbh<InputStream> zzf(zzarx zzarx) {
        synchronized (this.mLock) {
            if (this.zzfxf) {
                zzbbr zzbbr = this.zzddv;
                return zzbbr;
            }
            this.zzfxf = true;
            this.zzfxh = zzarx;
            this.zzfxi.checkAvailabilityAndConnect();
            this.zzddv.zza(new zzchw(this), zzbbm.zzeaf);
            zzbbr zzbbr2 = this.zzddv;
            return zzbbr2;
        }
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzawz.zzdp("Cannot connect to remote service, fallback to local instance.");
        this.zzddv.setException(new zzcie(0));
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzfxg) {
                this.zzfxg = true;
                try {
                    this.zzfxi.zztr().zza(this.zzfxh, (zzarr) new zzchy(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzddv.setException(new zzcie(0));
                } catch (Throwable th) {
                    zzk.zzlk().zza(th, "RemoteAdRequestClientTask.onConnected");
                    this.zzddv.setException(new zzcie(0));
                }
            }
        }
    }
}
