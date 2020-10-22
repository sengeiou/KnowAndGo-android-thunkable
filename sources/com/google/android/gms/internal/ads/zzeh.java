package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

public final class zzeh implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final Handler zzyr = new Handler(Looper.getMainLooper());
    private final zzdy zzvd;
    private Application zzww;
    private final Context zzys;
    @Nullable
    private final PowerManager zzyt;
    @Nullable
    private final KeyguardManager zzyu;
    private BroadcastReceiver zzyv;
    private WeakReference<ViewTreeObserver> zzyw;
    private WeakReference<View> zzyx;
    private zzdm zzyy;
    private byte zzyz = -1;
    private int zzza = -1;
    private long zzzb = -3;

    public zzeh(zzdy zzdy, View view) {
        this.zzvd = zzdy;
        this.zzys = zzdy.zzlj;
        this.zzyt = (PowerManager) this.zzys.getSystemService("power");
        this.zzyu = (KeyguardManager) this.zzys.getSystemService("keyguard");
        if (this.zzys instanceof Application) {
            this.zzww = (Application) this.zzys;
            this.zzyy = new zzdm((Application) this.zzys, this);
        }
        zzd(view);
    }

    /* access modifiers changed from: package-private */
    public final void zzd(View view) {
        View view2 = this.zzyx != null ? (View) this.zzyx.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzf(view2);
        }
        this.zzyx = new WeakReference<>(view);
        if (view != null) {
            if ((view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true) {
                zze(view);
            }
            view.addOnAttachStateChangeListener(this);
            this.zzzb = -2;
            return;
        }
        this.zzzb = -3;
    }

    private final void zzcu() {
        zzyr.post(new zzei(this));
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzza = -1;
        zze(view);
        zzcw();
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzza = -1;
        zzcw();
        zzcu();
        zzf(view);
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzyx != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View view = (View) this.zzyx.get();
            if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                this.zzza = i;
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzcw();
    }

    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzcw();
    }

    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzcw();
        zzcu();
    }

    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzcw();
    }

    public final void onActivityStopped(Activity activity) {
        zzcw();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzcw();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzcw();
    }

    public final void onGlobalLayout() {
        zzcw();
    }

    public final void onScrollChanged() {
        zzcw();
    }

    public final long zzcv() {
        if (this.zzzb <= -2 && this.zzyx.get() == null) {
            this.zzzb = -3;
        }
        return this.zzzb;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006c, code lost:
        if (r7 == false) goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzcw() {
        /*
            r9 = this;
            java.lang.ref.WeakReference<android.view.View> r0 = r9.zzyx
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.ref.WeakReference<android.view.View> r0 = r9.zzyx
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            r1 = -1
            r2 = -3
            if (r0 != 0) goto L_0x0017
            r9.zzzb = r2
            r9.zzyz = r1
            return
        L_0x0017:
            int r4 = r0.getVisibility()
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0021
            r4 = 1
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            boolean r7 = r0.isShown()
            if (r7 != 0) goto L_0x002b
            r4 = r4 | 2
            byte r4 = (byte) r4
        L_0x002b:
            android.os.PowerManager r7 = r9.zzyt
            if (r7 == 0) goto L_0x003a
            android.os.PowerManager r7 = r9.zzyt
            boolean r7 = r7.isScreenOn()
            if (r7 != 0) goto L_0x003a
            r4 = r4 | 4
            byte r4 = (byte) r4
        L_0x003a:
            com.google.android.gms.internal.ads.zzdy r7 = r9.zzvd
            boolean r7 = r7.zzco()
            if (r7 != 0) goto L_0x0070
            android.app.KeyguardManager r7 = r9.zzyu
            if (r7 == 0) goto L_0x006f
            android.app.KeyguardManager r7 = r9.zzyu
            boolean r7 = r7.inKeyguardRestrictedInputMode()
            if (r7 == 0) goto L_0x006f
            android.app.Activity r7 = com.google.android.gms.internal.ads.zzef.zzc(r0)
            if (r7 == 0) goto L_0x006b
            android.view.Window r7 = r7.getWindow()
            if (r7 != 0) goto L_0x005c
            r7 = 0
            goto L_0x0060
        L_0x005c:
            android.view.WindowManager$LayoutParams r7 = r7.getAttributes()
        L_0x0060:
            if (r7 == 0) goto L_0x006b
            int r7 = r7.flags
            r8 = 524288(0x80000, float:7.34684E-40)
            r7 = r7 & r8
            if (r7 == 0) goto L_0x006b
            r7 = 1
            goto L_0x006c
        L_0x006b:
            r7 = 0
        L_0x006c:
            if (r7 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r5 = 0
        L_0x0070:
            if (r5 != 0) goto L_0x0075
            r4 = r4 | 8
            byte r4 = (byte) r4
        L_0x0075:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getGlobalVisibleRect(r5)
            if (r5 != 0) goto L_0x0083
            r4 = r4 | 16
            byte r4 = (byte) r4
        L_0x0083:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getLocalVisibleRect(r5)
            if (r5 != 0) goto L_0x0091
            r4 = r4 | 32
            byte r4 = (byte) r4
        L_0x0091:
            int r0 = r0.getWindowVisibility()
            int r5 = r9.zzza
            if (r5 == r1) goto L_0x009b
            int r0 = r9.zzza
        L_0x009b:
            if (r0 == 0) goto L_0x00a0
            r0 = r4 | 64
            byte r4 = (byte) r0
        L_0x00a0:
            byte r0 = r9.zzyz
            if (r0 == r4) goto L_0x00b6
            r9.zzyz = r4
            byte r0 = r9.zzyz
            if (r0 != 0) goto L_0x00af
            long r0 = android.os.SystemClock.elapsedRealtime()
            goto L_0x00b4
        L_0x00af:
            byte r0 = r9.zzyz
            long r0 = (long) r0
            long r0 = r2 - r0
        L_0x00b4:
            r9.zzzb = r0
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeh.zzcw():void");
    }

    private final void zze(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzyw = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzyv == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzyv = new zzej(this);
            this.zzys.registerReceiver(this.zzyv, intentFilter);
        }
        if (this.zzww != null) {
            try {
                this.zzww.registerActivityLifecycleCallbacks(this.zzyy);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001d */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027 A[Catch:{ Exception -> 0x002d }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031 A[SYNTHETIC, Splitter:B:17:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e A[SYNTHETIC, Splitter:B:23:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzf(android.view.View r4) {
        /*
            r3 = this;
            r0 = 0
            java.lang.ref.WeakReference<android.view.ViewTreeObserver> r1 = r3.zzyw     // Catch:{ Exception -> 0x001d }
            if (r1 == 0) goto L_0x001d
            java.lang.ref.WeakReference<android.view.ViewTreeObserver> r1 = r3.zzyw     // Catch:{ Exception -> 0x001d }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x001d }
            android.view.ViewTreeObserver r1 = (android.view.ViewTreeObserver) r1     // Catch:{ Exception -> 0x001d }
            if (r1 == 0) goto L_0x001b
            boolean r2 = r1.isAlive()     // Catch:{ Exception -> 0x001d }
            if (r2 == 0) goto L_0x001b
            r1.removeOnScrollChangedListener(r3)     // Catch:{ Exception -> 0x001d }
            r1.removeGlobalOnLayoutListener(r3)     // Catch:{ Exception -> 0x001d }
        L_0x001b:
            r3.zzyw = r0     // Catch:{ Exception -> 0x001d }
        L_0x001d:
            android.view.ViewTreeObserver r4 = r4.getViewTreeObserver()     // Catch:{ Exception -> 0x002d }
            boolean r1 = r4.isAlive()     // Catch:{ Exception -> 0x002d }
            if (r1 == 0) goto L_0x002d
            r4.removeOnScrollChangedListener(r3)     // Catch:{ Exception -> 0x002d }
            r4.removeGlobalOnLayoutListener(r3)     // Catch:{ Exception -> 0x002d }
        L_0x002d:
            android.content.BroadcastReceiver r4 = r3.zzyv
            if (r4 == 0) goto L_0x003a
            android.content.Context r4 = r3.zzys     // Catch:{ Exception -> 0x0038 }
            android.content.BroadcastReceiver r1 = r3.zzyv     // Catch:{ Exception -> 0x0038 }
            r4.unregisterReceiver(r1)     // Catch:{ Exception -> 0x0038 }
        L_0x0038:
            r3.zzyv = r0
        L_0x003a:
            android.app.Application r4 = r3.zzww
            if (r4 == 0) goto L_0x0046
            android.app.Application r4 = r3.zzww     // Catch:{ Exception -> 0x0046 }
            com.google.android.gms.internal.ads.zzdm r0 = r3.zzyy     // Catch:{ Exception -> 0x0046 }
            r4.unregisterActivityLifecycleCallbacks(r0)     // Catch:{ Exception -> 0x0046 }
            return
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeh.zzf(android.view.View):void");
    }
}
