package com.google.android.gms.internal.ads;

final /* synthetic */ class zzdaf implements Runnable {
    private final String zzdbk;
    private final zzdae zzgns;

    zzdaf(zzdae zzdae, String str) {
        this.zzgns = zzdae;
        this.zzdbk = str;
    }

    public final void run() {
        this.zzgns.zzga(this.zzdbk);
    }
}
