package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

@zzard
public class zzyv extends AdListener {
    private final Object lock = new Object();
    private AdListener zzcio;

    public final void zza(AdListener adListener) {
        synchronized (this.lock) {
            this.zzcio = adListener;
        }
    }

    public void onAdClosed() {
        synchronized (this.lock) {
            if (this.zzcio != null) {
                this.zzcio.onAdClosed();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.lock) {
            if (this.zzcio != null) {
                this.zzcio.onAdFailedToLoad(i);
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.lock) {
            if (this.zzcio != null) {
                this.zzcio.onAdLeftApplication();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.lock) {
            if (this.zzcio != null) {
                this.zzcio.onAdOpened();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.lock) {
            if (this.zzcio != null) {
                this.zzcio.onAdLoaded();
            }
        }
    }
}
