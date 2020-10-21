package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class zzuc extends BroadcastReceiver {
    private final /* synthetic */ zzua zzbtn;

    zzuc(zzua zzua) {
        this.zzbtn = zzua;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzbtn.zzbu(3);
    }
}
