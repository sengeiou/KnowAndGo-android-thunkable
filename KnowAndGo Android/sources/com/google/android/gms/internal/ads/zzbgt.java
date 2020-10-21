package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

final class zzbgt implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsResult zzeix;

    zzbgt(JsResult jsResult) {
        this.zzeix = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzeix.cancel();
    }
}
