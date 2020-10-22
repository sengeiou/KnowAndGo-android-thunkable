package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzbsm;
import java.util.Iterator;

public final class zzcoe<AdT, AdapterT, ListenerT extends zzbsm> implements zzcjv<AdT> {
    private final zzcjz<AdapterT, ListenerT> zzfef;
    private final zzczt zzgbk;
    private final zzcka<AdT, AdapterT, ListenerT> zzgch;
    private final zzbbl zzgci;

    public zzcoe(zzczt zzczt, zzbbl zzbbl, zzcjz<AdapterT, ListenerT> zzcjz, zzcka<AdT, AdapterT, ListenerT> zzcka) {
        this.zzgbk = zzczt;
        this.zzgci = zzbbl;
        this.zzgch = zzcka;
        this.zzfef = zzcjz;
    }

    public final boolean zza(zzcxu zzcxu, zzcxm zzcxm) {
        return !zzcxm.zzgkf.isEmpty();
    }

    public final zzbbh<AdT> zzb(zzcxu zzcxu, zzcxm zzcxm) {
        zzcjy<AdapterT, ListenerT> zzcjy;
        Iterator<String> it = zzcxm.zzgkf.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzcjy = null;
                break;
            }
            try {
                zzcjy = this.zzfef.zzd(it.next(), zzcxm.zzgkh);
                break;
            } catch (Throwable unused) {
            }
        }
        if (zzcjy == null) {
            return zzbar.zzd(new zzcmk("unable to instantiate mediation adapter class"));
        }
        zzbbr zzbbr = new zzbbr();
        zzcjy.zzfzn.zza(new zzcoh(this, zzbbr, zzcjy));
        if (zzcxm.zzdpc) {
            Bundle bundle = zzcxu.zzgkx.zzfjp.zzghg.zzcgv;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        return this.zzgbk.zzv(zzczs.ADAPTER_LOAD_AD_SYN).zza((zzczd) new zzcof(this, zzcxu, zzcxm, zzcjy), this.zzgci).zzx(zzczs.ADAPTER_LOAD_AD_ACK).zzb(zzbbr).zzx(zzczs.ADAPTER_WRAP_ADAPTER).zzb(new zzcog(this, zzcxu, zzcxm, zzcjy)).zzane();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy, Void voidR) throws Exception {
        return this.zzgch.zzb(zzcxu, zzcxm, zzcjy);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws Exception {
        this.zzgch.zza(zzcxu, zzcxm, zzcjy);
    }
}
