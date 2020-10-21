package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzk;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzbit {
    public static zzbgz zza(Context context, zzbin zzbin, String str, boolean z, boolean z2, @Nullable zzdh zzdh, zzbai zzbai, zzadi zzadi, zzj zzj, zza zza, zzwj zzwj) throws zzbhj {
        try {
            return (zzbgz) zzazl.zzb(new zzbiu(context, zzbin, str, z, z2, zzdh, zzbai, (zzadi) null, zzj, zza, zzwj));
        } catch (Throwable th) {
            zzk.zzlk().zza(th, "AdWebViewFactory.newAdWebView2");
            throw new zzbhj("Webview initialization failed.", th);
        }
    }
}
