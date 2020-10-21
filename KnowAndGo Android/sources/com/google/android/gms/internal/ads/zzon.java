package com.google.android.gms.internal.ads;

final class zzon {
    public int index;
    public final int length;
    public long zzajx;
    public int zzbei;
    private final boolean zzbej;
    private final zzst zzbek;
    private final zzst zzbel;
    private int zzbem;
    private int zzben;

    public zzon(zzst zzst, zzst zzst2, boolean z) {
        this.zzbel = zzst;
        this.zzbek = zzst2;
        this.zzbej = z;
        zzst2.setPosition(12);
        this.length = zzst2.zzgg();
        zzst.setPosition(12);
        this.zzben = zzst.zzgg();
        zzsk.checkState(zzst.readInt() != 1 ? false : true, "first_chunk must be 1");
        this.index = -1;
    }

    public final boolean zzil() {
        long j;
        int i = this.index + 1;
        this.index = i;
        if (i == this.length) {
            return false;
        }
        if (this.zzbej) {
            j = this.zzbek.zzgh();
        } else {
            j = this.zzbek.zzge();
        }
        this.zzajx = j;
        if (this.index == this.zzbem) {
            this.zzbei = this.zzbel.zzgg();
            this.zzbel.zzac(4);
            int i2 = this.zzben - 1;
            this.zzben = i2;
            this.zzbem = i2 > 0 ? this.zzbel.zzgg() - 1 : -1;
        }
        return true;
    }
}
