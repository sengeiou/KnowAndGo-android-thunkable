package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

final /* synthetic */ class zzaye implements DialogInterface.OnClickListener {
    private final String zzdbk;
    private final zzayb zzdwi;

    zzaye(zzayb zzayb, String str) {
        this.zzdwi = zzayb;
        this.zzdbk = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdwi.zza(this.zzdbk, dialogInterface, i);
    }
}
