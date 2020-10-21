package com.google.android.gms.internal.ads;

final class zzake implements Runnable {
    private final /* synthetic */ zzajy zzdbx;
    private final /* synthetic */ String zzdby;

    zzake(zzajy zzajy, String str) {
        this.zzdbx = zzajy;
        this.zzdby = str;
    }

    public final void run() {
        this.zzdbx.zzdbs.loadUrl(this.zzdby);
    }
}
