package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

@zzard
public final class zzawg implements zzawi {
    public final zzbbh<String> zza(String str, PackageInfo packageInfo) {
        return zzbar.zzm(str);
    }

    public final zzbbh<AdvertisingIdClient.Info> zzag(Context context) {
        zzbbr zzbbr = new zzbbr();
        zzyt.zzpa();
        if (zzazt.zzbg(context)) {
            zzaxg.zzc(new zzawh(this, context, zzbbr));
        }
        return zzbbr;
    }
}
