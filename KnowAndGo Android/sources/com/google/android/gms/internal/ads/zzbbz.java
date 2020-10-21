package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;

@zzard
public final class zzbbz {
    public static void zza(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        new zzbca(view, onGlobalLayoutListener).attach();
    }

    public static void zza(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        new zzbcb(view, onScrollChangedListener).attach();
    }
}
