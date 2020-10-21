package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzctk implements zzcuz<Bundle> {
    private final zzcxk zzfex;

    public zzctk(zzcxk zzcxk) {
        this.zzfex = zzcxk;
    }

    public final /* synthetic */ void zzt(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zzfex != null) {
            bundle.putBoolean("render_in_browser", this.zzfex.zzaml());
            bundle.putBoolean("disable_ml", this.zzfex.zzamm());
        }
    }
}
