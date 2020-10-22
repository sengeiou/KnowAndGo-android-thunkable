package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.WindowInsets;

final /* synthetic */ class zzaxz implements View.OnApplyWindowInsetsListener {
    private final zzaxy zzdwc;
    private final Activity zzdwd;

    zzaxz(zzaxy zzaxy, Activity activity) {
        this.zzdwc = zzaxy;
        this.zzdwd = activity;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return zzaxy.zza(this.zzdwd, view, windowInsets);
    }
}
