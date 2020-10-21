package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;

public final class zzchz extends zzchx {
    public zzchz(Context context) {
        this.zzfxi = new zzarf(context, zzk.zzlu().zzwr(), this, this);
    }

    public final zzbbh<InputStream> zzg(zzarx zzarx) {
        synchronized (this.mLock) {
            if (this.zzfxf) {
                zzbbr zzbbr = this.zzddv;
                return zzbbr;
            }
            this.zzfxf = true;
            this.zzfxh = zzarx;
            this.zzfxi.checkAvailabilityAndConnect();
            this.zzddv.zza(new zzcia(this), zzbbm.zzeaf);
            zzbbr zzbbr2 = this.zzddv;
            return zzbbr2;
        }
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzfxg) {
                this.zzfxg = true;
                try {
                    this.zzfxi.zztr().zzb(this.zzfxh, new zzchy(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzddv.setException(new zzcie(0));
                } catch (Throwable th) {
                    zzk.zzlk().zza(th, "RemoteSignalsClientTask.onConnected");
                    this.zzddv.setException(new zzcie(0));
                }
            }
        }
    }
}
