package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

final class zzapw implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzapu zzdip;

    zzapw(zzapu zzapu) {
        this.zzdip = zzapu;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdip.zzdh("User canceled the download.");
    }
}
