package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import javax.annotation.concurrent.GuardedBy;

public final class zzcoz implements zzf {
    @GuardedBy("this")
    private zzf zzgdd;

    public final synchronized void zza(zzf zzf) {
        this.zzgdd = zzf;
    }

    public final synchronized void zzg(View view) {
        if (this.zzgdd != null) {
            this.zzgdd.zzg(view);
        }
    }

    public final synchronized void zzky() {
        if (this.zzgdd != null) {
            this.zzgdd.zzky();
        }
    }

    public final synchronized void zzkz() {
        if (this.zzgdd != null) {
            this.zzgdd.zzkz();
        }
    }
}
