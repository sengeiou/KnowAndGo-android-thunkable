package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzk;

final class zzapp implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzapo zzdhw;

    zzapp(zzapo zzapo) {
        this.zzdhw = zzapo;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent createIntent = this.zzdhw.createIntent();
        zzk.zzlg();
        zzaxi.zza(this.zzdhw.zzlj, createIntent);
    }
}
