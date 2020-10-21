package com.uxcam.internals;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

@TargetApi(14)
/* renamed from: com.uxcam.internals.ae */
public final class C2937ae implements Application.ActivityLifecycleCallbacks {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static int f1250c;

    /* renamed from: a */
    public int f1251a = 0;

    /* renamed from: b */
    public C2939aa f1252b;

    /* renamed from: com.uxcam.internals.ae$aa */
    public interface C2939aa {
        /* renamed from: a */
        void mo37992a(Activity activity);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        C3183fy.m2034a(activity);
        f1250c++;
        if (this.f1252b != null && this.f1251a == 0) {
            this.f1252b.mo37992a(activity);
        }
        this.f1251a++;
        C2928ab.m1120a(false, activity);
    }

    public final void onActivityStopped(Activity activity) {
        C3196gd.f2364k.remove(activity);
        if (f1250c == 0) {
            C2970bc.m1233a("UXCam").mo38070a("UXCam 3.3.0[501](Warning): Error in integration, see integration docs for instruction.", new Object[0]);
            C2970bc.m1233a("UXCamActivityData -> onStopTaskForLollipop");
            new StringBuilder("onStopTaskForLollipop (wrong integration): actitivityCount -> ").append(f1250c);
            C2928ab.m1131d();
        }
        f1250c--;
        new StringBuilder("onStopTaskForLollipop: actitivityCount -> ").append(f1250c);
        C2970bc.m1233a("ctest");
        StringBuilder sb = new StringBuilder(" onstop called for activity ");
        sb.append(getClass().getName());
        sb.append(" activitycount ");
        sb.append(f1250c);
        if (f1250c == 0) {
            if (C3196gd.m2091g()) {
                C2934ad.f1242b = true;
            }
            new Thread(new Runnable() {
                public final void run() {
                    try {
                        C3195gc.f2349g = true;
                        Thread.sleep((long) C2952an.f1317a);
                        C3195gc.f2349g = false;
                        if (C3196gd.f2360g > 0) {
                            C3196gd.f2359f = true;
                            Thread.sleep(C3196gd.f2360g);
                        }
                        C3196gd.f2359f = false;
                        C2934ad.f1242b = false;
                        if (C2937ae.f1250c == 0) {
                            StringBuilder sb = new StringBuilder("onStopTaskForLollipop (after sleep for -> ");
                            sb.append(C2952an.f1317a);
                            sb.append("): actitivityCount -> ");
                            sb.append(C2937ae.f1250c);
                            C2928ab.m1131d();
                        }
                    } catch (InterruptedException unused) {
                        C2970bc.m1233a("UXCam");
                    }
                }
            }).start();
        }
    }
}
