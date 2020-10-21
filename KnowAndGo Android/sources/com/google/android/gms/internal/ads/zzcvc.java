package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

final /* synthetic */ class zzcvc implements Runnable {
    private final zzcva zzgii;
    private final long zzgij;

    zzcvc(zzcva zzcva, long j) {
        this.zzgii = zzcva;
        this.zzgij = j;
    }

    public final void run() {
        zzcva zzcva = this.zzgii;
        long j = this.zzgij;
        String canonicalName = zzcva.getClass().getCanonicalName();
        long elapsedRealtime = zzk.zzln().elapsedRealtime() - j;
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 40);
        sb.append("Signal runtime : ");
        sb.append(canonicalName);
        sb.append(" = ");
        sb.append(elapsedRealtime);
        zzawz.zzds(sb.toString());
    }
}
