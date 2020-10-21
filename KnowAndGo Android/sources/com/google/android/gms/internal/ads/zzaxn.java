package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class zzaxn extends BroadcastReceiver {
    private final /* synthetic */ zzaxi zzdvz;

    private zzaxn(zzaxi zzaxi) {
        this.zzdvz = zzaxi;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            boolean unused = this.zzdvz.zzxt = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            boolean unused2 = this.zzdvz.zzxt = false;
        }
    }

    /* synthetic */ zzaxn(zzaxi zzaxi, zzaxj zzaxj) {
        this(zzaxi);
    }
}
