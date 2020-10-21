package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzada {
    public static void zza(zzacy zzacy, @Nullable zzacx zzacx) {
        if (zzacx.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(zzacx.zzmg())) {
            zzacy.zza(zzacx.getContext(), zzacx.zzmg(), zzacx.zzqr(), zzacx.zzqs());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
