package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzadj extends zzadm {
    private final zzf zzcxu;
    @Nullable
    private final String zzcxv;
    private final String zzcxw;

    public zzadj(zzf zzf, @Nullable String str, String str2) {
        this.zzcxu = zzf;
        this.zzcxv = str;
        this.zzcxw = str2;
    }

    public final String zzqz() {
        return this.zzcxv;
    }

    public final String getContent() {
        return this.zzcxw;
    }

    public final void zzo(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.zzcxu.zzg((View) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public final void recordClick() {
        this.zzcxu.zzky();
    }

    public final void recordImpression() {
        this.zzcxu.zzkz();
    }
}
