package com.google.android.gms.internal.ads;

final class zzdmz {
    private final byte[] buffer;
    private final zzdni zzhcx;

    private zzdmz(int i) {
        this.buffer = new byte[i];
        this.zzhcx = zzdni.zzab(this.buffer);
    }

    public final zzdmr zzavs() {
        this.zzhcx.zzawv();
        return new zzdnb(this.buffer);
    }

    public final zzdni zzavt() {
        return this.zzhcx;
    }

    /* synthetic */ zzdmz(int i, zzdms zzdms) {
        this(i);
    }
}
