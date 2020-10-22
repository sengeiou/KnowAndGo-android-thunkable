package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.polidea.multiplatformbleadapter.utils.Constants;

final class zzayj implements Runnable {
    final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzdwr;
    private final /* synthetic */ boolean zzdws;
    private final /* synthetic */ boolean zzdwt;

    zzayj(zzayi zzayi, Context context, String str, boolean z, boolean z2) {
        this.val$context = context;
        this.zzdwr = str;
        this.zzdws = z;
        this.zzdwt = z2;
    }

    public final void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.val$context);
        builder.setMessage(this.zzdwr);
        if (this.zzdws) {
            builder.setTitle(Constants.BluetoothLogLevel.ERROR);
        } else {
            builder.setTitle(Constants.BluetoothLogLevel.INFO);
        }
        if (this.zzdwt) {
            builder.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builder.setPositiveButton("Learn More", new zzayk(this));
            builder.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builder.create().show();
    }
}
