package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class zzazq extends BroadcastReceiver {
    private final /* synthetic */ zzazp zzdyg;

    zzazq(zzazp zzazp) {
        this.zzdyg = zzazp;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzdyg.zzc(context, intent);
    }
}
