package com.google.android.gms.internal.ads;

final class zztq implements Runnable {
    private final /* synthetic */ String zzael;
    private final /* synthetic */ long zzavl;
    private final /* synthetic */ long zzavm;
    private final /* synthetic */ zzto zzbpu;

    zztq(zzto zzto, String str, long j, long j2) {
        this.zzbpu = zzto;
        this.zzael = str;
        this.zzavl = j;
        this.zzavm = j2;
    }

    public final void run() {
        this.zzbpu.zzbpt.zze(this.zzael, this.zzavl, this.zzavm);
    }
}
