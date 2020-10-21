package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

final class zzuw implements Runnable {
    final /* synthetic */ zzuu zzbvm;
    private ValueCallback<String> zzbvn = new zzux(this);
    final /* synthetic */ zzuo zzbvo;
    final /* synthetic */ WebView zzbvp;
    final /* synthetic */ boolean zzbvq;

    zzuw(zzuu zzuu, zzuo zzuo, WebView webView, boolean z) {
        this.zzbvm = zzuu;
        this.zzbvo = zzuo;
        this.zzbvp = webView;
        this.zzbvq = z;
    }

    public final void run() {
        if (this.zzbvp.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzbvp.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzbvn);
            } catch (Throwable unused) {
                this.zzbvn.onReceiveValue("");
            }
        }
    }
}
