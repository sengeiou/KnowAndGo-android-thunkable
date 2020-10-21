package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzdo implements zzdu {
    private final /* synthetic */ Activity val$activity;

    zzdo(zzdm zzdm, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.val$activity);
    }
}
