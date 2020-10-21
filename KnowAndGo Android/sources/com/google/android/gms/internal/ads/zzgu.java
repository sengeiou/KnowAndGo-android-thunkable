package com.google.android.gms.internal.ads;

final class zzgu implements Runnable {
    private final /* synthetic */ zzgr zzaej;
    private final /* synthetic */ String zzael;
    private final /* synthetic */ long zzaem;
    private final /* synthetic */ long zzaen;

    zzgu(zzgr zzgr, String str, long j, long j2) {
        this.zzaej = zzgr;
        this.zzael = str;
        this.zzaem = j;
        this.zzaen = j2;
    }

    public final void run() {
        this.zzaej.zzadn.zza(this.zzael, this.zzaem, this.zzaen);
    }
}
