package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
@zzard
public final class zzbzi extends zzaes implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcab {
    private final WeakReference<View> zzfpf;
    private final Map<String, WeakReference<View>> zzfpg = new HashMap();
    private final Map<String, WeakReference<View>> zzfph = new HashMap();
    private final Map<String, WeakReference<View>> zzfpi = new HashMap();
    @GuardedBy("this")
    private zzbyn zzfpj;
    private zzua zzfpk;

    public zzbzi(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        zzk.zzmd();
        zzbbz.zza(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzk.zzmd();
        zzbbz.zza(view, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzfpf = new WeakReference<>(view);
        for (Map.Entry next : hashMap.entrySet()) {
            String str = (String) next.getKey();
            View view2 = (View) next.getValue();
            if (view2 != null) {
                this.zzfpg.put(str, new WeakReference(view2));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
                    view2.setOnTouchListener(this);
                    view2.setClickable(true);
                    view2.setOnClickListener(this);
                }
            }
        }
        this.zzfpi.putAll(this.zzfpg);
        for (Map.Entry next2 : hashMap2.entrySet()) {
            View view3 = (View) next2.getValue();
            if (view3 != null) {
                this.zzfph.put((String) next2.getKey(), new WeakReference(view3));
                view3.setOnTouchListener(this);
                view3.setClickable(false);
            }
        }
        this.zzfpi.putAll(this.zzfph);
        this.zzfpk = new zzua(view.getContext(), view);
    }

    @Nullable
    public final FrameLayout zzair() {
        return null;
    }

    public final synchronized void unregisterNativeAd() {
        if (this.zzfpj != null) {
            this.zzfpj.zzb(this);
            this.zzfpj = null;
        }
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof zzbyn)) {
            zzawz.zzep("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        if (this.zzfpj != null) {
            this.zzfpj.zzb(this);
        }
        if (((zzbyn) unwrap).zzahs()) {
            this.zzfpj = (zzbyn) unwrap;
            this.zzfpj.zza((zzcab) this);
            this.zzfpj.zzy(zzafi());
            return;
        }
        zzawz.zzen("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
    }

    @Nullable
    public final View zzafi() {
        return (View) this.zzfpf.get();
    }

    public final zzua zzais() {
        return this.zzfpk;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r3 != 0) goto L_0x0016
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzfpi     // Catch:{ all -> 0x0014 }
            r3.remove(r2)     // Catch:{ all -> 0x0014 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzfpg     // Catch:{ all -> 0x0014 }
            r3.remove(r2)     // Catch:{ all -> 0x0014 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzfph     // Catch:{ all -> 0x0014 }
            r3.remove(r2)     // Catch:{ all -> 0x0014 }
            monitor-exit(r1)
            return
        L_0x0014:
            r2 = move-exception
            goto L_0x0049
        L_0x0016:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzfpi     // Catch:{ all -> 0x0014 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0014 }
            r0.<init>(r3)     // Catch:{ all -> 0x0014 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0014 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0014 }
            if (r4 != 0) goto L_0x0047
            java.lang.String r4 = "3011"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0014 }
            if (r4 == 0) goto L_0x0031
            goto L_0x0047
        L_0x0031:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzfpg     // Catch:{ all -> 0x0014 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0014 }
            r0.<init>(r3)     // Catch:{ all -> 0x0014 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0014 }
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0014 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0014 }
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0014 }
            monitor-exit(r1)
            return
        L_0x0047:
            monitor-exit(r1)
            return
        L_0x0049:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzi.zza(java.lang.String, android.view.View, boolean):void");
    }

    public final synchronized Map<String, WeakReference<View>> zzait() {
        return this.zzfpi;
    }

    public final synchronized Map<String, WeakReference<View>> zzaiu() {
        return this.zzfpg;
    }

    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzaiv() {
        return this.zzfph;
    }

    public final synchronized View zzfp(String str) {
        WeakReference weakReference = this.zzfpi.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public final synchronized String zzaiw() {
        return NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzfpj != null) {
            this.zzfpj.zza(view, motionEvent, zzafi());
        }
        return false;
    }

    public final synchronized void onClick(View view) {
        if (this.zzfpj != null) {
            this.zzfpj.zza(view, zzafi(), zzait(), zzaiu(), true);
        }
    }

    public final synchronized void onGlobalLayout() {
        if (this.zzfpj != null) {
            this.zzfpj.zzb(zzafi(), zzait(), zzaiu(), zzbyn.zzx(zzafi()));
        }
    }

    public final synchronized void onScrollChanged() {
        if (this.zzfpj != null) {
            this.zzfpj.zzb(zzafi(), zzait(), zzaiu(), zzbyn.zzx(zzafi()));
        }
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        if (this.zzfpj != null) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof View)) {
                zzawz.zzep("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.zzfpj.setClickConfirmingView((View) unwrap);
        }
    }
}
