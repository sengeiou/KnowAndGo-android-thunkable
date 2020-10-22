package com.google.android.gms.internal.ads;

final class zzbch implements Runnable {
    private final /* synthetic */ zzbcd zzebm;
    private final /* synthetic */ String zzebn;
    private final /* synthetic */ String zzebo;

    zzbch(zzbcd zzbcd, String str, String str2) {
        this.zzebm = zzbcd;
        this.zzebn = str;
        this.zzebo = str2;
    }

    public final void run() {
        if (this.zzebm.zzebk != null) {
            this.zzebm.zzebk.zzl(this.zzebn, this.zzebo);
        }
    }
}
