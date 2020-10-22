package com.google.android.gms.internal.ads;

final class zzalw implements zzbbt {
    private final /* synthetic */ zzbbr zzdar;
    private final /* synthetic */ zzakw zzddr;

    zzalw(zzalu zzalu, zzbbr zzbbr, zzakw zzakw) {
        this.zzdar = zzbbr;
        this.zzddr = zzakw;
    }

    public final void run() {
        this.zzdar.setException(new zzali("Unable to obtain a JavascriptEngine."));
        this.zzddr.release();
    }
}
