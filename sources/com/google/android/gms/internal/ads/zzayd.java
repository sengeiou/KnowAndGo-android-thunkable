package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

final /* synthetic */ class zzayd implements DialogInterface.OnClickListener {
    private final zzayb zzdwi;
    private final int zzdwj;
    private final int zzdwk;
    private final int zzdwl;

    zzayd(zzayb zzayb, int i, int i2, int i3) {
        this.zzdwi = zzayb;
        this.zzdwj = i;
        this.zzdwk = i2;
        this.zzdwl = i3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdwi.zza(this.zzdwj, this.zzdwk, this.zzdwl, dialogInterface, i);
    }
}
