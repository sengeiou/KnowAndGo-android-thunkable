package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

final class zzbgm implements zzbdo {
    private final /* synthetic */ zzbgl zzeiq;

    zzbgm(zzbgl zzbgl) {
        this.zzeiq = zzbgl;
    }

    public final void zzl(String str, @Nullable String str2) {
        zzbgl zzbgl = this.zzeiq;
        String valueOf = String.valueOf(str);
        String unused = zzbgl.zzeio = valueOf.length() != 0 ? "ExoPlayer caching failed. Type: ".concat(valueOf) : new String("ExoPlayer caching failed. Type: ");
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(str2).length());
        sb.append("ExoPlayer failed during precache: ");
        sb.append(str);
        sb.append(" Exception: ");
        sb.append(str2);
        zzawz.zzep(sb.toString());
        this.zzeiq.abort();
    }
}
