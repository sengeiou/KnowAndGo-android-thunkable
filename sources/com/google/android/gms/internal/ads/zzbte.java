package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

final class zzbte implements Runnable {
    private final WeakReference<zzbtb> zzfkj;

    private zzbte(zzbtb zzbtb) {
        this.zzfkj = new WeakReference<>(zzbtb);
    }

    public final void run() {
        zzbtb zzbtb = (zzbtb) this.zzfkj.get();
        if (zzbtb != null) {
            zzbtb.zzagj();
        }
    }
}
