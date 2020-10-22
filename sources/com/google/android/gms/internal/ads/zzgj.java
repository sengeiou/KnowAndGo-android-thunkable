package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

final class zzgj extends Handler {
    private final /* synthetic */ zzgi zzabx;

    zzgj(zzgi zzgi) {
        this.zzabx = zzgi;
    }

    public final void handleMessage(Message message) {
        this.zzabx.zza(message);
    }
}
