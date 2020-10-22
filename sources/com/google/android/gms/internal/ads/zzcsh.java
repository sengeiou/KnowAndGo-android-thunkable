package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public final class zzcsh implements zzcva<zzcsg> {
    private final zzbbl zzfqw;
    private final Context zzlj;

    public zzcsh(zzbbl zzbbl, Context context) {
        this.zzfqw = zzbbl;
        this.zzlj = context;
    }

    public final zzbbh<zzcsg> zzalm() {
        return this.zzfqw.zza(new zzcsi(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcsg zzalp() throws Exception {
        double d;
        Intent registerReceiver = this.zzlj.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            d = ((double) registerReceiver.getIntExtra("level", -1)) / ((double) registerReceiver.getIntExtra("scale", -1));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        } else {
            d = -1.0d;
        }
        return new zzcsg(d, z);
    }
}
