package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.TimeUnit;

public final class zzchc implements zzdti<zzbbh<String>> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzczt> zzfhv;

    private zzchc(zzdtu<zzczt> zzdtu, zzdtu<Context> zzdtu2) {
        this.zzfhv = zzdtu;
        this.zzeoj = zzdtu2;
    }

    public static zzchc zzaa(zzdtu<zzczt> zzdtu, zzdtu<Context> zzdtu2) {
        return new zzchc(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (zzbbh) zzdto.zza(this.zzfhv.get().zzv(zzczs.WEBVIEW_COOKIE).zzd(new zzcgu(this.zzeoj.get())).zza(1, TimeUnit.SECONDS).zza(Exception.class, zzcgv.zzfvz).zzane(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
