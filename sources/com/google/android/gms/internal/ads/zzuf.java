package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

final class zzuf implements Application.ActivityLifecycleCallbacks {
    private final Application zzww;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzwx;
    private boolean zzwy = false;

    public zzuf(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzwx = new WeakReference<>(activityLifecycleCallbacks);
        this.zzww = application;
    }

    private final void zza(zzun zzun) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzwx.get();
            if (activityLifecycleCallbacks != null) {
                zzun.zza(activityLifecycleCallbacks);
            } else if (!this.zzwy) {
                this.zzww.unregisterActivityLifecycleCallbacks(this);
                this.zzwy = true;
            }
        } catch (Exception e) {
            zzawz.zzc("Error while dispatching lifecycle callback.", e);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzug(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzuh(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzui(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzuj(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzuk(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzul(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzum(this, activity));
    }
}
