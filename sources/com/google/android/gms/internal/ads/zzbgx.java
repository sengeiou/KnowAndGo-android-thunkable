package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

final class zzbgx implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzeiy;
    private final /* synthetic */ EditText zzeiz;

    zzbgx(JsPromptResult jsPromptResult, EditText editText) {
        this.zzeiy = jsPromptResult;
        this.zzeiz = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzeiy.confirm(this.zzeiz.getText().toString());
    }
}
