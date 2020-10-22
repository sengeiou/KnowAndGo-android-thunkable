package com.google.android.gms.internal.ads;

final class zzara implements Runnable {
    private final /* synthetic */ zzbah zzdlh;
    private final /* synthetic */ String zzdli;

    zzara(zzaqx zzaqx, zzbah zzbah, String str) {
        this.zzdlh = zzbah;
        this.zzdli = str;
    }

    public final void run() {
        this.zzdlh.zzed(this.zzdli);
    }
}
