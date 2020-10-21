package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcnn implements Runnable {
    private final zzced zzgar;

    private zzcnn(zzced zzced) {
        this.zzgar = zzced;
    }

    static Runnable zza(zzced zzced) {
        return new zzcnn(zzced);
    }

    public final void run() {
        this.zzgar.zzajo();
    }
}
