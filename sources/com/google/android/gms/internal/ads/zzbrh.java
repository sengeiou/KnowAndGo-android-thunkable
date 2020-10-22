package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

public final class zzbrh implements zzdti<zzavb> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzcxm> zzfgo;
    private final zzbrg zzfjx;
    private final zzdtu<zzbai> zzfjy;
    private final zzdtu<zzavd> zzfjz;

    private zzbrh(zzbrg zzbrg, zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<zzcxm> zzdtu3, zzdtu<zzavd> zzdtu4) {
        this.zzfjx = zzbrg;
        this.zzeoj = zzdtu;
        this.zzfjy = zzdtu2;
        this.zzfgo = zzdtu3;
        this.zzfjz = zzdtu4;
    }

    public static zzbrh zza(zzbrg zzbrg, zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<zzcxm> zzdtu3, zzdtu<zzavd> zzdtu4) {
        return new zzbrh(zzbrg, zzdtu, zzdtu2, zzdtu3, zzdtu4);
    }

    @Nullable
    public final /* synthetic */ Object get() {
        Context context = this.zzeoj.get();
        zzbai zzbai = this.zzfjy.get();
        zzcxm zzcxm = this.zzfgo.get();
        zzavd zzavd = this.zzfjz.get();
        if (zzcxm.zzgki != null) {
            return new zzauq(context, zzbai, zzcxm.zzgki, zzcxm.zzgke.zzdkn, zzavd);
        }
        return null;
    }
}
