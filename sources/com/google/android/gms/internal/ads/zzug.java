package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

final class zzug implements zzun {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Bundle zzwz;

    zzug(zzuf zzuf, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzwz = bundle;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.val$activity, this.zzwz);
    }
}
