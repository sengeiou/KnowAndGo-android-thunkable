package com.google.android.gms.internal.ads;

import android.content.Context;

final /* synthetic */ class zzamj implements Runnable {
    private final String zzdbk;
    private final Context zzdef;

    zzamj(Context context, String str) {
        this.zzdef = context;
        this.zzdbk = str;
    }

    public final void run() {
        zzami.zzc(this.zzdef, this.zzdbk);
    }
}
