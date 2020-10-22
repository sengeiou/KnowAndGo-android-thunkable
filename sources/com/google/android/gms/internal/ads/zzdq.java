package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzdq implements zzdu {
    private final /* synthetic */ Activity val$activity;

    zzdq(zzdm zzdm, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.val$activity);
    }
}
