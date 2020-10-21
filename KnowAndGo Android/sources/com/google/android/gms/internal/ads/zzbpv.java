package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbpv implements zzo {
    private final zzbse zzfjg;
    private AtomicBoolean zzfjh = new AtomicBoolean(false);

    public zzbpv(zzbse zzbse) {
        this.zzfjg = zzbse;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void zzsz() {
        this.zzfjh.set(true);
        this.zzfjg.onAdClosed();
    }

    public final void zzta() {
        this.zzfjg.onAdOpened();
    }

    public final boolean isClosed() {
        return this.zzfjh.get();
    }
}
