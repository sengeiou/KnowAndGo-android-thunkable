package com.google.android.gms.internal.ads;

final /* synthetic */ class zzckf implements Runnable {
    private final zzbgz zzemf;

    private zzckf(zzbgz zzbgz) {
        this.zzemf = zzbgz;
    }

    static Runnable zzo(zzbgz zzbgz) {
        return new zzckf(zzbgz);
    }

    public final void run() {
        this.zzemf.zzaav();
    }
}
