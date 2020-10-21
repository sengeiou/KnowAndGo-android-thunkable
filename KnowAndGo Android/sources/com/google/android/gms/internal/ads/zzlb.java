package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class zzlb extends Handler {
    private final /* synthetic */ zzla zzash;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzlb(zzla zzla, Looper looper) {
        super(looper);
        this.zzash = zzla;
    }

    public final void handleMessage(Message message) {
        this.zzash.zza(message);
    }
}
