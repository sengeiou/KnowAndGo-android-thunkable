package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

public final class zzbnj implements zzdti<zzbnh> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzbry> zzexa;
    private final zzdtu<zzbvd> zzext;
    private final zzdtu<zzbso> zzexw;
    private final zzdtu<zzcpm> zzfbc;
    private final zzdtu<zzcxu> zzfff;
    private final zzdtu<zzcxn> zzfhd;
    private final zzdtu<View> zzfhe;
    private final zzdtu<zzbgz> zzfhf;
    private final zzdtu<zzbpb> zzfhg;
    private final zzdtu<zzbzc> zzfhh;
    private final zzdtu<Executor> zzfhi;
    private final zzdtu<zzcxm> zzfhj;
    private final zzdtu<String> zzfhk;

    public zzbnj(zzdtu<Context> zzdtu, zzdtu<zzcxn> zzdtu2, zzdtu<View> zzdtu3, zzdtu<zzbgz> zzdtu4, zzdtu<zzbpb> zzdtu5, zzdtu<zzbzc> zzdtu6, zzdtu<zzbvd> zzdtu7, zzdtu<zzcpm> zzdtu8, zzdtu<Executor> zzdtu9, zzdtu<zzcxu> zzdtu10, zzdtu<zzcxm> zzdtu11, zzdtu<zzbry> zzdtu12, zzdtu<zzbso> zzdtu13, zzdtu<String> zzdtu14) {
        this.zzeoj = zzdtu;
        this.zzfhd = zzdtu2;
        this.zzfhe = zzdtu3;
        this.zzfhf = zzdtu4;
        this.zzfhg = zzdtu5;
        this.zzfhh = zzdtu6;
        this.zzext = zzdtu7;
        this.zzfbc = zzdtu8;
        this.zzfhi = zzdtu9;
        this.zzfff = zzdtu10;
        this.zzfhj = zzdtu11;
        this.zzexa = zzdtu12;
        this.zzexw = zzdtu13;
        this.zzfhk = zzdtu14;
    }

    public static zzbnh zza(Context context, zzcxn zzcxn, View view, zzbgz zzbgz, zzbpb zzbpb, zzbzc zzbzc, zzbvd zzbvd, zzdte<zzcpm> zzdte, Executor executor) {
        return new zzbnh(context, zzcxn, view, zzbgz, zzbpb, zzbzc, zzbvd, zzdte, executor);
    }

    public final /* synthetic */ Object get() {
        zzbnh zzbnh = new zzbnh(this.zzeoj.get(), this.zzfhd.get(), this.zzfhe.get(), this.zzfhf.get(), this.zzfhg.get(), this.zzfhh.get(), this.zzext.get(), zzdth.zzap(this.zzfbc), this.zzfhi.get());
        zzbql.zza((zzbpc) zzbnh, this.zzfff.get());
        zzbql.zza((zzbpc) zzbnh, this.zzfhj.get());
        zzbql.zza((zzbpc) zzbnh, this.zzexa.get());
        zzbql.zza((zzbpc) zzbnh, this.zzexw.get());
        zzbql.zza((zzbpc) zzbnh, this.zzfhk.get());
        return zzbnh;
    }
}
