package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class zzbzj extends zzaen implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcab {
    public static final String[] zzfpm = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO, UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO};
    private FrameLayout zzbqi;
    private boolean zzeky = false;
    @GuardedBy("this")
    private zzbyn zzfpj;
    private zzua zzfpk;
    private final String zzfpl;
    @GuardedBy("this")
    private Map<String, WeakReference<View>> zzfpn = new HashMap();
    private FrameLayout zzfpo;
    private zzbbl zzfpp;
    private View zzfpq;

    public zzbzj(FrameLayout frameLayout, FrameLayout frameLayout2) {
        String str;
        this.zzfpo = frameLayout;
        this.zzbqi = frameLayout2;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = NativeAppInstallAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.zzfpl = str;
        zzk.zzmd();
        zzbbz.zza((View) frameLayout, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzk.zzmd();
        zzbbz.zza((View) frameLayout, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzfpp = zzbbm.zzeag;
        this.zzfpk = new zzua(this.zzfpo.getContext(), this.zzfpo);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    public final synchronized void zzc(String str, IObjectWrapper iObjectWrapper) {
        zza(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r4 = r1.zzeky     // Catch:{ all -> 0x0039 }
            if (r4 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            if (r3 != 0) goto L_0x0010
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzfpn     // Catch:{ all -> 0x0039 }
            r3.remove(r2)     // Catch:{ all -> 0x0039 }
            monitor-exit(r1)
            return
        L_0x0010:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzfpn     // Catch:{ all -> 0x0039 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0039 }
            r0.<init>(r3)     // Catch:{ all -> 0x0039 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0039 }
            if (r4 != 0) goto L_0x0037
            java.lang.String r4 = "3011"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x002b
            goto L_0x0037
        L_0x002b:
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0039 }
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0039 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0039 }
            monitor-exit(r1)
            return
        L_0x0037:
            monitor-exit(r1)
            return
        L_0x0039:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzj.zza(java.lang.String, android.view.View, boolean):void");
    }

    public final synchronized IObjectWrapper zzcf(String str) {
        return ObjectWrapper.wrap(zzfp(str));
    }

    public final synchronized View zzfp(String str) {
        if (this.zzeky) {
            return null;
        }
        WeakReference weakReference = this.zzfpn.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        if (!this.zzeky) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof zzbyn)) {
                zzawz.zzep("Not an instance of native engine. This is most likely a transient error");
                return;
            }
            if (this.zzfpj != null) {
                this.zzfpj.zzb(this);
            }
            zzaix();
            this.zzfpj = (zzbyn) unwrap;
            this.zzfpj.zza((zzcab) this);
            this.zzfpj.zzy(this.zzfpo);
        }
    }

    private final synchronized void zzaix() {
        this.zzfpp.execute(new zzbzk(this));
    }

    public final synchronized void destroy() {
        if (!this.zzeky) {
            if (this.zzfpj != null) {
                this.zzfpj.zzb(this);
                this.zzfpj = null;
            }
            this.zzfpn.clear();
            this.zzfpo.removeAllViews();
            this.zzbqi.removeAllViews();
            this.zzfpn = null;
            this.zzfpo = null;
            this.zzbqi = null;
            this.zzfpq = null;
            this.zzfpk = null;
            this.zzeky = true;
        }
    }

    public final synchronized void zzc(IObjectWrapper iObjectWrapper, int i) {
    }

    public final synchronized void onClick(View view) {
        if (this.zzfpj != null) {
            this.zzfpj.cancelUnconfirmedClick();
            this.zzfpj.zza(view, this.zzfpo, zzait(), zzaiu(), false);
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzfpj != null) {
            this.zzfpj.zza(view, motionEvent, this.zzfpo);
        }
        return false;
    }

    public final synchronized void onGlobalLayout() {
        if (this.zzfpj != null) {
            this.zzfpj.zzb(this.zzfpo, zzait(), zzaiu(), zzbyn.zzx(this.zzfpo));
        }
    }

    public final synchronized void onScrollChanged() {
        if (this.zzfpj != null) {
            this.zzfpj.zzb(this.zzfpo, zzait(), zzaiu(), zzbyn.zzx(this.zzfpo));
        }
    }

    public final synchronized Map<String, WeakReference<View>> zzait() {
        return this.zzfpn;
    }

    public final synchronized Map<String, WeakReference<View>> zzaiu() {
        return this.zzfpn;
    }

    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzaiv() {
        return null;
    }

    public final synchronized String zzaiw() {
        return this.zzfpl;
    }

    public final FrameLayout zzair() {
        return this.zzbqi;
    }

    public final zzua zzais() {
        return this.zzfpk;
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        this.zzfpj.setClickConfirmingView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final /* synthetic */ View zzafi() {
        return this.zzfpo;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaiy() {
        if (this.zzfpq == null) {
            this.zzfpq = new View(this.zzfpo.getContext());
            this.zzfpq.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzfpo != this.zzfpq.getParent()) {
            this.zzfpo.addView(this.zzfpq);
        }
    }
}
