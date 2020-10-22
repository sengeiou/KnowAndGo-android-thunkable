package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;
import java.util.concurrent.Callable;

final /* synthetic */ class zzbiu implements Callable {
    private final Context zzdef;
    private final String zzdsr;
    private final zzbin zzejz;
    private final boolean zzeka;
    private final boolean zzekb;
    private final zzdh zzekc;
    private final zzbai zzekd;
    private final zzadi zzeke;
    private final zzj zzekf;
    private final zza zzekg;
    private final zzwj zzekh;

    zzbiu(Context context, zzbin zzbin, String str, boolean z, boolean z2, zzdh zzdh, zzbai zzbai, zzadi zzadi, zzj zzj, zza zza, zzwj zzwj) {
        this.zzdef = context;
        this.zzejz = zzbin;
        this.zzdsr = str;
        this.zzeka = z;
        this.zzekb = z2;
        this.zzekc = zzdh;
        this.zzekd = zzbai;
        this.zzeke = zzadi;
        this.zzekf = zzj;
        this.zzekg = zza;
        this.zzekh = zzwj;
    }

    public final Object call() {
        Context context = this.zzdef;
        zzbin zzbin = this.zzejz;
        String str = this.zzdsr;
        boolean z = this.zzeka;
        boolean z2 = this.zzekb;
        zzdh zzdh = this.zzekc;
        zzbai zzbai = this.zzekd;
        zzadi zzadi = this.zzeke;
        zzj zzj = this.zzekf;
        zza zza = this.zzekg;
        zzwj zzwj = this.zzekh;
        zzbio zzbio = new zzbio();
        zzbiv zzbiv = new zzbiv(new zzbim(context), zzbio, zzbin, str, z, z2, zzdh, zzbai, zzadi, zzj, zza, zzwj);
        zzbhk zzbhk = new zzbhk(zzbiv);
        zzbiv.setWebChromeClient(new zzbgr(zzbhk));
        zzbio.zza((zzbgz) zzbhk, z2);
        return zzbhk;
    }
}
