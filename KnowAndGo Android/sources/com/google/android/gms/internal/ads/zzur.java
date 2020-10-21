package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

@TargetApi(14)
final class zzur implements Application.ActivityLifecycleCallbacks {
    /* access modifiers changed from: private */
    public boolean foreground = true;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    public boolean zzbut = false;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public final List<zzut> zzbuu = new ArrayList();
    @GuardedBy("lock")
    private final List<zzvg> zzbuv = new ArrayList();
    private Runnable zzbuw;
    private long zzbux;
    private Context zzlj;
    private boolean zzxs = false;
    @Nullable
    private Activity zzzd;

    zzur() {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void zza(Application application, Context context) {
        if (!this.zzxs) {
            application.registerActivityLifecycleCallbacks(this);
            if (context instanceof Activity) {
                setActivity((Activity) context);
            }
            this.zzlj = application;
            this.zzbux = ((Long) zzyt.zzpe().zzd(zzacu.zzcox)).longValue();
            this.zzxs = true;
        }
    }

    public final void zza(zzut zzut) {
        synchronized (this.lock) {
            this.zzbuu.add(zzut);
        }
    }

    @Nullable
    public final Activity getActivity() {
        return this.zzzd;
    }

    @Nullable
    public final Context getContext() {
        return this.zzlj;
    }

    public final void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    public final void onActivityResumed(Activity activity) {
        setActivity(activity);
        this.zzbut = false;
        boolean z = !this.foreground;
        this.foreground = true;
        if (this.zzbuw != null) {
            zzaxi.zzdvv.removeCallbacks(this.zzbuw);
        }
        synchronized (this.lock) {
            for (zzvg onActivityResumed : this.zzbuv) {
                try {
                    onActivityResumed.onActivityResumed(activity);
                } catch (Exception e) {
                    zzk.zzlk().zza(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzbad.zzc("", e);
                }
            }
            if (z) {
                for (zzut zzp : this.zzbuu) {
                    try {
                        zzp.zzp(true);
                    } catch (Exception e2) {
                        zzbad.zzc("", e2);
                    }
                }
            } else {
                zzawz.zzdp("App is still foreground.");
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        setActivity(activity);
        synchronized (this.lock) {
            for (zzvg onActivityPaused : this.zzbuv) {
                try {
                    onActivityPaused.onActivityPaused(activity);
                } catch (Exception e) {
                    zzk.zzlk().zza(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzbad.zzc("", e);
                }
            }
        }
        this.zzbut = true;
        if (this.zzbuw != null) {
            zzaxi.zzdvv.removeCallbacks(this.zzbuw);
        }
        Handler handler = zzaxi.zzdvv;
        zzus zzus = new zzus(this);
        this.zzbuw = zzus;
        handler.postDelayed(zzus, this.zzbux);
    }

    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.lock) {
            if (this.zzzd != null) {
                if (this.zzzd.equals(activity)) {
                    this.zzzd = null;
                }
                Iterator<zzvg> it = this.zzbuv.iterator();
                while (it.hasNext()) {
                    try {
                        if (it.next().zza(activity)) {
                            it.remove();
                        }
                    } catch (Exception e) {
                        zzk.zzlk().zza(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        zzbad.zzc("", e);
                    }
                }
            }
        }
    }

    private final void setActivity(Activity activity) {
        synchronized (this.lock) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.zzzd = activity;
            }
        }
    }
}
