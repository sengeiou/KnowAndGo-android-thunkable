package com.google.android.gms.internal.ads;

final class zzbee implements zzgh {
    private final /* synthetic */ zzbdq zzegb;

    zzbee(zzbdq zzbdq) {
        this.zzegb = zzbdq;
    }

    public final void zzdo() {
    }

    public final void zza(boolean z, int i) {
        if (this.zzegb.zzeft != i) {
            int unused = this.zzegb.zzeft = i;
            switch (i) {
                case 4:
                    this.zzegb.zzyy();
                    return;
                case 5:
                    this.zzegb.zzyk();
                    return;
                default:
                    return;
            }
        }
    }

    public final void zza(zzgd zzgd) {
        this.zzegb.zzn("PlayerError", zzgd.getMessage());
    }
}
