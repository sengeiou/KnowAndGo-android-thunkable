package com.google.android.gms.internal.ads;

@zzard
final class zzbdh implements Runnable {
    private boolean zzbut = false;
    private zzbcq zzecq;

    zzbdh(zzbcq zzbcq) {
        this.zzecq = zzbcq;
    }

    public final void run() {
        if (!this.zzbut) {
            this.zzecq.zzxt();
            zzyn();
        }
    }

    public final void pause() {
        this.zzbut = true;
        this.zzecq.zzxt();
    }

    public final void resume() {
        this.zzbut = false;
        zzyn();
    }

    private final void zzyn() {
        zzaxi.zzdvv.removeCallbacks(this);
        zzaxi.zzdvv.postDelayed(this, 250);
    }
}
