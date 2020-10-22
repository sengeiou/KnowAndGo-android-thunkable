package com.google.android.gms.internal.ads;

import android.net.Uri;

final /* synthetic */ class zzbhu implements zzbhw {
    private final zzbgz zzemf;

    zzbhu(zzbgz zzbgz) {
        this.zzemf = zzbgz;
    }

    public final void zzh(Uri uri) {
        zzbii zzaai = this.zzemf.zzaai();
        if (zzaai == null) {
            zzawz.zzen("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzaai.zzh(uri);
        }
    }
}
