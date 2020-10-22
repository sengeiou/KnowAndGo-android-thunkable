package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzu;

final class zzccq implements zzo, zzu, zzagv, zzagx, zzxr {
    private zzxr zzcgi;
    private zzagv zzczo;
    private zzagx zzczp;
    private zzo zzdkm;
    private zzu zzdkq;

    private zzccq() {
    }

    public final synchronized void onAdClicked() {
        if (this.zzcgi != null) {
            this.zzcgi.onAdClicked();
        }
    }

    public final synchronized void zzsz() {
        if (this.zzdkm != null) {
            this.zzdkm.zzsz();
        }
    }

    public final synchronized void onPause() {
        if (this.zzdkm != null) {
            this.zzdkm.onPause();
        }
    }

    public final synchronized void onResume() {
        if (this.zzdkm != null) {
            this.zzdkm.onResume();
        }
    }

    public final synchronized void zzta() {
        if (this.zzdkm != null) {
            this.zzdkm.zzta();
        }
    }

    public final synchronized void zztq() {
        if (this.zzdkq != null) {
            this.zzdkq.zztq();
        }
    }

    public final synchronized void zza(String str, Bundle bundle) {
        if (this.zzczo != null) {
            this.zzczo.zza(str, bundle);
        }
    }

    public final synchronized void onAppEvent(String str, @Nullable String str2) {
        if (this.zzczp != null) {
            this.zzczp.onAppEvent(str, str2);
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void zza(zzxr zzxr, zzagv zzagv, zzo zzo, zzagx zzagx, zzu zzu) {
        this.zzcgi = zzxr;
        this.zzczo = zzagv;
        this.zzdkm = zzo;
        this.zzczp = zzagx;
        this.zzdkq = zzu;
    }

    /* synthetic */ zzccq(zzccm zzccm) {
        this();
    }
}
