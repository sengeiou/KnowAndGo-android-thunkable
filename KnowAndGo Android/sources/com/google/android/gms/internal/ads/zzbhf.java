package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzbhf {
    public static zzbbh<zzbgz> zza(Context context, zzbai zzbai, String str, zzdh zzdh, zza zza) {
        return zzbar.zza(zzbar.zzm(null), new zzbhg(context, zzdh, zzbai, zza, str), zzbbm.zzeae);
    }

    public static zzbgz zza(Context context, zzbin zzbin, String str, boolean z, boolean z2, @Nullable zzdh zzdh, zzbai zzbai, zzadi zzadi, zzj zzj, zza zza, zzwj zzwj) throws zzbhj {
        zzacu.initialize(context);
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcoi)).booleanValue()) {
            return zzbit.zza(context, zzbin, str, z, z2, zzdh, zzbai, (zzadi) null, zzj, zza, zzwj);
        }
        try {
            return (zzbgz) zzazl.zzb(new zzbhh(context, zzbin, str, z, z2, zzdh, zzbai, (zzadi) null, zzj, zza, zzwj));
        } catch (Throwable th) {
            throw new zzbhj("Webview initialization failed.", th);
        }
    }
}
