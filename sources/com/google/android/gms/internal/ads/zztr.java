package com.google.android.gms.internal.ads;

final class zztr implements Runnable {
    private final /* synthetic */ zzlh zzavn;
    private final /* synthetic */ zzto zzbpu;

    zztr(zzto zzto, zzlh zzlh) {
        this.zzbpu = zzto;
        this.zzavn = zzlh;
    }

    public final void run() {
        this.zzbpu.zzbpt.zzk(this.zzavn);
    }
}
