package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

final class zzbgv implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsPromptResult zzeiy;

    zzbgv(JsPromptResult jsPromptResult) {
        this.zzeiy = jsPromptResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zzeiy.cancel();
    }
}
