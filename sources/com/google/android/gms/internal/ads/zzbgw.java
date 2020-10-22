package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

final class zzbgw implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzeiy;

    zzbgw(JsPromptResult jsPromptResult) {
        this.zzeiy = jsPromptResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzeiy.cancel();
    }
}
