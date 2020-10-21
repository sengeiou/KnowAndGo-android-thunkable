package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaqh;
import com.google.android.gms.internal.ads.zzard;

@zzard
public final class zzt extends zzaqh {
    private AdOverlayInfoParcel zzdkw;
    private boolean zzdkx = false;
    private boolean zzdky = false;
    private Activity zzzd;

    public zzt(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdkw = adOverlayInfoParcel;
        this.zzzd = activity;
    }

    public final void onActivityResult(int i, int i2, Intent intent) throws RemoteException {
    }

    public final void onBackPressed() throws RemoteException {
    }

    public final void onRestart() throws RemoteException {
    }

    public final void onStart() throws RemoteException {
    }

    public final void zzac(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzdd() throws RemoteException {
    }

    public final boolean zztg() throws RemoteException {
        return false;
    }

    public final void onCreate(Bundle bundle) {
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        if (this.zzdkw == null) {
            this.zzzd.finish();
        } else if (z) {
            this.zzzd.finish();
        } else {
            if (bundle == null) {
                if (this.zzdkw.zzcgi != null) {
                    this.zzdkw.zzcgi.onAdClicked();
                }
                if (!(this.zzzd.getIntent() == null || !this.zzzd.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) || this.zzdkw.zzdkm == null)) {
                    this.zzdkw.zzdkm.zzta();
                }
            }
            zzk.zzle();
            if (!zza.zza((Context) this.zzzd, this.zzdkw.zzdkl, this.zzdkw.zzdkq)) {
                this.zzzd.finish();
            }
        }
    }

    public final void onResume() throws RemoteException {
        if (this.zzdkx) {
            this.zzzd.finish();
            return;
        }
        this.zzdkx = true;
        if (this.zzdkw.zzdkm != null) {
            this.zzdkw.zzdkm.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdkx);
    }

    public final void onPause() throws RemoteException {
        if (this.zzdkw.zzdkm != null) {
            this.zzdkw.zzdkm.onPause();
        }
        if (this.zzzd.isFinishing()) {
            zztp();
        }
    }

    public final void onStop() throws RemoteException {
        if (this.zzzd.isFinishing()) {
            zztp();
        }
    }

    public final void onDestroy() throws RemoteException {
        if (this.zzzd.isFinishing()) {
            zztp();
        }
    }

    private final synchronized void zztp() {
        if (!this.zzdky) {
            if (this.zzdkw.zzdkm != null) {
                this.zzdkw.zzdkm.zzsz();
            }
            this.zzdky = true;
        }
    }
}
