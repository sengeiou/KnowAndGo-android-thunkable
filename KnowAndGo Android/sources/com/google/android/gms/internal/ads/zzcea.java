package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzb;
import java.util.concurrent.Executor;

public final class zzcea implements zzdti<zzcdp> {
    private final zzdtu<zzbtp> zzewe;
    private final zzdtu<zzbss> zzewk;
    private final zzdtu<zzbmn> zzewx;
    private final zzdtu<zzbse> zzexf;
    private final zzdtu<zzbri> zzexi;
    private final zzdtu<zzbsv> zzeya;
    private final zzdtu<zzbva> zzeyg;
    private final zzdtu<zzbtl> zzfbp;
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzavb> zzfjn;
    private final zzdtu<zzdh> zzfni;
    private final zzdtu<zzb> zzftn;
    private final zzdtu<zzbry> zzfto;

    private zzcea(zzdtu<zzbri> zzdtu, zzdtu<zzbse> zzdtu2, zzdtu<zzbss> zzdtu3, zzdtu<zzbsv> zzdtu4, zzdtu<zzbtp> zzdtu5, zzdtu<Executor> zzdtu6, zzdtu<zzbva> zzdtu7, zzdtu<zzbmn> zzdtu8, zzdtu<zzb> zzdtu9, zzdtu<zzbry> zzdtu10, zzdtu<zzavb> zzdtu11, zzdtu<zzdh> zzdtu12, zzdtu<zzbtl> zzdtu13) {
        this.zzexi = zzdtu;
        this.zzexf = zzdtu2;
        this.zzewk = zzdtu3;
        this.zzeya = zzdtu4;
        this.zzewe = zzdtu5;
        this.zzfgh = zzdtu6;
        this.zzeyg = zzdtu7;
        this.zzewx = zzdtu8;
        this.zzftn = zzdtu9;
        this.zzfto = zzdtu10;
        this.zzfjn = zzdtu11;
        this.zzfni = zzdtu12;
        this.zzfbp = zzdtu13;
    }

    public static zzcea zza(zzdtu<zzbri> zzdtu, zzdtu<zzbse> zzdtu2, zzdtu<zzbss> zzdtu3, zzdtu<zzbsv> zzdtu4, zzdtu<zzbtp> zzdtu5, zzdtu<Executor> zzdtu6, zzdtu<zzbva> zzdtu7, zzdtu<zzbmn> zzdtu8, zzdtu<zzb> zzdtu9, zzdtu<zzbry> zzdtu10, zzdtu<zzavb> zzdtu11, zzdtu<zzdh> zzdtu12, zzdtu<zzbtl> zzdtu13) {
        return new zzcea(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5, zzdtu6, zzdtu7, zzdtu8, zzdtu9, zzdtu10, zzdtu11, zzdtu12, zzdtu13);
    }

    public final /* synthetic */ Object get() {
        return new zzcdp(this.zzexi.get(), this.zzexf.get(), this.zzewk.get(), this.zzeya.get(), this.zzewe.get(), this.zzfgh.get(), this.zzeyg.get(), this.zzewx.get(), this.zzftn.get(), this.zzfto.get(), this.zzfjn.get(), this.zzfni.get(), this.zzfbp.get());
    }
}
