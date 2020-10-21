package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;

final class zzayk implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzayj zzdwu;

    zzayk(zzayj zzayj) {
        this.zzdwu = zzayj;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzk.zzlg();
        zzaxi.zza(this.zzdwu.val$context, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
