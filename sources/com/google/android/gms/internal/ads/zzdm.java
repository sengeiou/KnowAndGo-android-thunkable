package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

final class zzdm implements Application.ActivityLifecycleCallbacks {
    private final Application zzww;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzwx;
    private boolean zzwy = false;

    public zzdm(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzwx = new WeakReference<>(activityLifecycleCallbacks);
        this.zzww = application;
    }

    private final void zza(zzdu zzdu) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzwx.get();
            if (activityLifecycleCallbacks != null) {
                zzdu.zza(activityLifecycleCallbacks);
            } else if (!this.zzwy) {
                this.zzww.unregisterActivityLifecycleCallbacks(this);
                this.zzwy = true;
            }
        } catch (Exception unused) {
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzdn(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzdo(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzdp(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzdq(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzdr(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzds(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzdt(this, activity));
    }
}
