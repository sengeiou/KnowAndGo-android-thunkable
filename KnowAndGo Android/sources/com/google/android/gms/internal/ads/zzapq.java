package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

final class zzapq implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzapo zzdhw;

    zzapq(zzapo zzapo) {
        this.zzdhw = zzapo;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdhw.zzdh("Operation denied by user.");
    }
}
