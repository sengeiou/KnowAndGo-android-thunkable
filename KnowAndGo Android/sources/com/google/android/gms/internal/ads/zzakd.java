package com.google.android.gms.internal.ads;

import p022fi.iki.elonen.NanoHTTPD;

final class zzakd implements Runnable {
    private final /* synthetic */ String zzdbw;
    private final /* synthetic */ zzajy zzdbx;

    zzakd(zzajy zzajy, String str) {
        this.zzdbx = zzajy;
        this.zzdbw = str;
    }

    public final void run() {
        this.zzdbx.zzdbs.loadData(this.zzdbw, NanoHTTPD.MIME_HTML, "UTF-8");
    }
}
