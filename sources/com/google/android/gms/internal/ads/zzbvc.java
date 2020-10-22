package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

public final class zzbvc implements zzdti<zzbva> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzcxm> zzfhj;
    private final zzdtu<Set<zzbuz<zzue>>> zzfhq;

    private zzbvc(zzdtu<Context> zzdtu, zzdtu<Set<zzbuz<zzue>>> zzdtu2, zzdtu<zzcxm> zzdtu3) {
        this.zzeoj = zzdtu;
        this.zzfhq = zzdtu2;
        this.zzfhj = zzdtu3;
    }

    public static zzbvc zzh(zzdtu<Context> zzdtu, zzdtu<Set<zzbuz<zzue>>> zzdtu2, zzdtu<zzcxm> zzdtu3) {
        return new zzbvc(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return new zzbva(this.zzeoj.get(), this.zzfhq.get(), this.zzfhj.get());
    }
}
