package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbcr implements Runnable {
    private final zzbco zzeck;

    private zzbcr(zzbco zzbco) {
        this.zzeck = zzbco;
    }

    static Runnable zza(zzbco zzbco) {
        return new zzbcr(zzbco);
    }

    public final void run() {
        this.zzeck.stop();
    }
}
