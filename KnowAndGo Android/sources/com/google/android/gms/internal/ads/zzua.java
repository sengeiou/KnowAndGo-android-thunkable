package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
@zzard
public final class zzua implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final long zzbte = ((Long) zzyt.zzpe().zzd(zzacu.zzcqi)).longValue();
    private final WindowManager zzbtf;
    @Nullable
    @VisibleForTesting
    private BroadcastReceiver zzbtg;
    private WeakReference<View> zzbth;
    private zzuf zzbti;
    private zzazj zzbtj = new zzazj(zzbte);
    private boolean zzbtk = false;
    private final HashSet<zzue> zzbtl = new HashSet<>();
    private final Rect zzbtm;
    private final DisplayMetrics zzwb;
    private Application zzww;
    private final Context zzys;
    private final PowerManager zzyt;
    private final KeyguardManager zzyu;
    private WeakReference<ViewTreeObserver> zzyw;
    private int zzza = -1;

    public zzua(Context context, View view) {
        this.zzys = context.getApplicationContext();
        this.zzbtf = (WindowManager) context.getSystemService("window");
        this.zzyt = (PowerManager) this.zzys.getSystemService("power");
        this.zzyu = (KeyguardManager) context.getSystemService("keyguard");
        if (this.zzys instanceof Application) {
            this.zzww = (Application) this.zzys;
            this.zzbti = new zzuf((Application) this.zzys, this);
        }
        this.zzwb = context.getResources().getDisplayMetrics();
        this.zzbtm = new Rect();
        this.zzbtm.right = this.zzbtf.getDefaultDisplay().getWidth();
        this.zzbtm.bottom = this.zzbtf.getDefaultDisplay().getHeight();
        View view2 = this.zzbth != null ? (View) this.zzbth.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzf(view2);
        }
        this.zzbth = new WeakReference<>(view);
        if (view != null) {
            if (zzk.zzli().isAttachedToWindow(view)) {
                zze(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    public final void zza(zzue zzue) {
        this.zzbtl.add(zzue);
        zzbu(3);
    }

    public final void zzb(zzue zzue) {
        this.zzbtl.remove(zzue);
    }

    private final void zzcu() {
        zzk.zzlg();
        zzaxi.zzdvv.post(new zzub(this));
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzza = -1;
        zze(view);
        zzbu(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzza = -1;
        zzbu(3);
        zzcu();
        zzf(view);
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzbth != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View view = (View) this.zzbth.get();
            if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                this.zzza = i;
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzbu(3);
        zzcu();
    }

    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzbu(3);
        zzcu();
    }

    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzbu(3);
        zzcu();
    }

    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzbu(3);
        zzcu();
    }

    public final void onActivityStopped(Activity activity) {
        zzbu(3);
        zzcu();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzbu(3);
        zzcu();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzbu(3);
        zzcu();
    }

    public final void onGlobalLayout() {
        zzbu(2);
        zzcu();
    }

    public final void onScrollChanged() {
        zzbu(1);
    }

    /* access modifiers changed from: private */
    public final void zzbu(int i) {
        boolean z;
        boolean z2;
        List<Rect> list;
        int i2 = i;
        if (this.zzbtl.size() != 0 && this.zzbth != null) {
            View view = (View) this.zzbth.get();
            boolean z3 = i2 == 1;
            boolean z4 = view == null;
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            Rect rect3 = new Rect();
            Rect rect4 = new Rect();
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            if (view != null) {
                boolean globalVisibleRect = view.getGlobalVisibleRect(rect2);
                boolean localVisibleRect = view.getLocalVisibleRect(rect3);
                view.getHitRect(rect4);
                try {
                    view.getLocationOnScreen(iArr);
                    view.getLocationInWindow(iArr2);
                } catch (Exception e) {
                    zzawz.zzc("Failure getting view location.", e);
                }
                rect.left = iArr[0];
                rect.top = iArr[1];
                rect.right = rect.left + view.getWidth();
                rect.bottom = rect.top + view.getHeight();
                z2 = globalVisibleRect;
                z = localVisibleRect;
            } else {
                z2 = false;
                z = false;
            }
            if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcql)).booleanValue() || view == null) {
                list = Collections.emptyList();
            } else {
                list = zzh(view);
            }
            List<Rect> list2 = list;
            int windowVisibility = view != null ? view.getWindowVisibility() : 8;
            if (this.zzza != -1) {
                windowVisibility = this.zzza;
            }
            boolean z5 = !z4 && zzk.zzlg().zza(view, this.zzyt, this.zzyu) && z2 && z && windowVisibility == 0;
            if (z3 && !this.zzbtj.tryAcquire() && z5 == this.zzbtk) {
                return;
            }
            if (z5 || this.zzbtk || i2 != 1) {
                zzud zzud = new zzud(zzk.zzln().elapsedRealtime(), this.zzyt.isScreenOn(), view != null && zzk.zzli().isAttachedToWindow(view), view != null ? view.getWindowVisibility() : 8, zza(this.zzbtm), zza(rect), zza(rect2), z2, zza(rect3), z, zza(rect4), this.zzwb.density, z5, list2);
                Iterator<zzue> it = this.zzbtl.iterator();
                while (it.hasNext()) {
                    it.next().zza(zzud);
                }
                this.zzbtk = z5;
            }
        }
    }

    private final Rect zza(Rect rect) {
        return new Rect(zzbv(rect.left), zzbv(rect.top), zzbv(rect.right), zzbv(rect.bottom));
    }

    private final int zzbv(int i) {
        return (int) (((float) i) / this.zzwb.density);
    }

    private final List<Rect> zzh(View view) {
        boolean z;
        try {
            ArrayList arrayList = new ArrayList();
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                View view2 = (View) parent;
                Rect rect = new Rect();
                if (Build.VERSION.SDK_INT >= 16) {
                    z = view2.isScrollContainer();
                } else {
                    if (!(view2 instanceof ScrollView)) {
                        if (!(view2 instanceof ListView)) {
                            z = false;
                        }
                    }
                    z = true;
                }
                if (z && view2.getGlobalVisibleRect(rect)) {
                    arrayList.add(zza(rect));
                }
            }
            return arrayList;
        } catch (Exception e) {
            zzk.zzlk().zza(e, "PositionWatcher.getParentScrollViewRects");
            return Collections.emptyList();
        }
    }

    private final void zze(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzyw = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzbtg == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzbtg = new zzuc(this);
            zzk.zzmb().zza(this.zzys, this.zzbtg, intentFilter);
        }
        if (this.zzww != null) {
            try {
                this.zzww.registerActivityLifecycleCallbacks(this.zzbti);
            } catch (Exception e) {
                zzawz.zzc("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void zzf(View view) {
        try {
            if (this.zzyw != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.zzyw.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzyw = null;
            }
        } catch (Exception e) {
            zzawz.zzc("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zzawz.zzc("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.zzbtg != null) {
            try {
                zzk.zzmb().zza(this.zzys, this.zzbtg);
            } catch (IllegalStateException e3) {
                zzawz.zzc("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                zzk.zzlk().zza(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zzbtg = null;
        }
        if (this.zzww != null) {
            try {
                this.zzww.unregisterActivityLifecycleCallbacks(this.zzbti);
            } catch (Exception e5) {
                zzawz.zzc("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    public final void zzes(long j) {
        this.zzbtj.zzfe(j);
    }

    public final void zzmk() {
        this.zzbtj.zzfe(zzbte);
    }
}
