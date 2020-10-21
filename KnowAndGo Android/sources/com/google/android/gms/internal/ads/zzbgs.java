package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

final class zzbgs implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsResult zzeix;

    zzbgs(JsResult jsResult) {
        this.zzeix = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zzeix.cancel();
    }
}
