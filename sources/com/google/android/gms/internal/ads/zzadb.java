package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;

@zzard
public final class zzadb {
    public static boolean zza(@Nullable zzadi zzadi, @Nullable zzadg zzadg, String... strArr) {
        if (zzadi == null || zzadg == null || !zzadi.zzcxq || zzadg == null) {
            return false;
        }
        return zzadi.zza(zzadg, zzk.zzln().elapsedRealtime(), strArr);
    }

    @Nullable
    public static zzadg zzb(@Nullable zzadi zzadi) {
        if (zzadi == null) {
            return null;
        }
        return zzadi.zzfa(zzk.zzln().elapsedRealtime());
    }
}
