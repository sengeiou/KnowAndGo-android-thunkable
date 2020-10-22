package com.google.android.gms.internal.ads;

final /* synthetic */ class zzclg implements Runnable {
    private final zzced zzgar;

    private zzclg(zzced zzced) {
        this.zzgar = zzced;
    }

    static Runnable zza(zzced zzced) {
        return new zzclg(zzced);
    }

    public final void run() {
        this.zzgar.zzajo();
    }
}
