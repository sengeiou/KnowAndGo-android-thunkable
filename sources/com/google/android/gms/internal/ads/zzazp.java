package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

@zzard
public final class zzazp {
    @GuardedBy("this")
    private final BroadcastReceiver zzdyd = new zzazq(this);
    @GuardedBy("this")
    private final Map<BroadcastReceiver, IntentFilter> zzdye = new WeakHashMap();
    private boolean zzdyf;
    private boolean zzxs = false;
    private Context zzys;

    public final synchronized void initialize(Context context) {
        if (!this.zzxs) {
            this.zzys = context.getApplicationContext();
            if (this.zzys == null) {
                this.zzys = context;
            }
            zzacu.initialize(this.zzys);
            this.zzdyf = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcsj)).booleanValue();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzys.registerReceiver(this.zzdyd, intentFilter);
            this.zzxs = true;
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.zzdyf) {
            this.zzdye.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.zzdyf) {
            this.zzdye.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void zzc(Context context, Intent intent) {
        for (Map.Entry next : this.zzdye.entrySet()) {
            if (((IntentFilter) next.getValue()).hasAction(intent.getAction())) {
                ((BroadcastReceiver) next.getKey()).onReceive(context, intent);
            }
        }
    }
}
