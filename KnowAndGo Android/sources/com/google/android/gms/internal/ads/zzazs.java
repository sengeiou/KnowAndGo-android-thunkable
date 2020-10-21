package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.ads.internal.zzk;

@zzard
public final class zzazs {
    private final View view;
    private boolean zzbtp;
    private boolean zzbxm;
    private Activity zzdyk;
    private boolean zzdyl;
    private ViewTreeObserver.OnGlobalLayoutListener zzdym;
    private ViewTreeObserver.OnScrollChangedListener zzdyn = null;

    public zzazs(Activity activity, View view2, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzdyk = activity;
        this.view = view2;
        this.zzdym = onGlobalLayoutListener;
    }

    public final void zzh(Activity activity) {
        this.zzdyk = activity;
    }

    public final void zzwt() {
        this.zzbxm = true;
        if (this.zzbtp) {
            zzwv();
        }
    }

    public final void zzwu() {
        this.zzbxm = false;
        zzww();
    }

    public final void onAttachedToWindow() {
        this.zzbtp = true;
        if (this.zzbxm) {
            zzwv();
        }
    }

    public final void onDetachedFromWindow() {
        this.zzbtp = false;
        zzww();
    }

    private final void zzwv() {
        if (!this.zzdyl) {
            if (this.zzdym != null) {
                if (this.zzdyk != null) {
                    Activity activity = this.zzdyk;
                    ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzdym;
                    ViewTreeObserver zzi = zzi(activity);
                    if (zzi != null) {
                        zzi.addOnGlobalLayoutListener(onGlobalLayoutListener);
                    }
                }
                zzk.zzmd();
                zzbbz.zza(this.view, this.zzdym);
            }
            this.zzdyl = true;
        }
    }

    private final void zzww() {
        if (this.zzdyk != null && this.zzdyl) {
            if (this.zzdym != null) {
                Activity activity = this.zzdyk;
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzdym;
                ViewTreeObserver zzi = zzi(activity);
                if (zzi != null) {
                    zzk.zzli().zza(zzi, onGlobalLayoutListener);
                }
            }
            this.zzdyl = false;
        }
    }

    private static ViewTreeObserver zzi(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }
}
