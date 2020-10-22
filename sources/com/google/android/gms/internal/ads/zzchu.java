package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzchu implements zzdti<zzchq> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzcxv> zzfhr;
    private final zzdtu<zzbai> zzfwo;

    private zzchu(zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<zzcxv> zzdtu3, zzdtu<Executor> zzdtu4) {
        this.zzeoj = zzdtu;
        this.zzfwo = zzdtu2;
        this.zzfhr = zzdtu3;
        this.zzfgh = zzdtu4;
    }

    public static zzchu zzd(zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<zzcxv> zzdtu3, zzdtu<Executor> zzdtu4) {
        return new zzchu(zzdtu, zzdtu2, zzdtu3, zzdtu4);
    }

    public final /* synthetic */ Object get() {
        return new zzchq(this.zzeoj.get(), this.zzfwo.get(), this.zzfhr.get(), this.zzfgh.get());
    }
}
