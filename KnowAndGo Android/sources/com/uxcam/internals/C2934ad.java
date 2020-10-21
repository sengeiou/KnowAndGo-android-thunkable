package com.uxcam.internals;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;

@TargetApi(14)
/* renamed from: com.uxcam.internals.ad */
public class C2934ad implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    public static final String f1241a = "com.uxcam.internals.ad";

    /* renamed from: b */
    public static boolean f1242b = false;

    /* renamed from: c */
    private boolean f1243c = false;

    /* renamed from: d */
    private boolean f1244d = true;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Handler f1245e = new Handler();

    /* renamed from: f */
    private Runnable f1246f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Runnable f1247g;

    /* renamed from: a */
    private void m1162a() {
        if (this.f1246f != null) {
            this.f1245e.removeCallbacks(this.f1246f);
            C3195gc.f2349g = false;
            f1242b = false;
        }
        if (this.f1247g != null) {
            this.f1245e.removeCallbacks(this.f1247g);
            f1242b = false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m1163a(C2934ad adVar) {
        f1242b = false;
        if (!adVar.f1243c || !adVar.f1244d) {
            C2970bc.m1233a("UXCam");
            new Object[1][0] = "still foreground";
            return;
        }
        adVar.f1243c = false;
        C2970bc.m1233a("UXCam");
        new Object[1][0] = "went background";
        C2928ab.m1131d();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        C2970bc.m1233a(f1241a);
        this.f1244d = true;
        m1162a();
        if (C3196gd.m2091g()) {
            f1242b = true;
        }
        C3195gc.f2349g = true;
        Handler handler = this.f1245e;
        C29351 r0 = new Runnable() {
            public final void run() {
                C3195gc.f2349g = false;
                if (C3196gd.f2360g > 0) {
                    C3196gd.f2359f = true;
                    C2970bc.m1233a("UXCam");
                    new Object[1][0] = "pauseForAnotherApp true";
                    C2934ad.this.f1245e.postDelayed(C2934ad.this.f1247g = new Runnable() {
                        public final void run() {
                            C2934ad.m1163a(C2934ad.this);
                            C3196gd.f2359f = false;
                            C2970bc.m1233a("UXCam");
                            new Object[1][0] = "pauseForAnotherApp false";
                        }
                    }, C3196gd.f2360g);
                    return;
                }
                C3196gd.f2359f = false;
                C2934ad.m1163a(C2934ad.this);
            }
        };
        this.f1246f = r0;
        handler.postDelayed(r0, (long) C2952an.f1317a);
    }

    public void onActivityResumed(Activity activity) {
        this.f1244d = false;
        boolean z = !this.f1243c;
        this.f1243c = true;
        m1162a();
        if (!z) {
            C2970bc.m1233a(f1241a);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        C3183fy.m2034a(activity);
        C2928ab.m1120a(false, activity);
    }

    public void onActivityStopped(Activity activity) {
        C3196gd.f2364k.remove(activity);
    }
}
