package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;

public final class zzcfb implements zzbro, zzbsr, zzbtk {
    private final String zzcwz = ((String) zzyt.zzpe().zzd(zzacu.zzcmy));
    private final zzdae zzffb;
    private final zzcfi zzfuo;

    public zzcfb(zzcfi zzcfi, zzdae zzdae) {
        this.zzfuo = zzcfi;
        this.zzffb = zzdae;
    }

    public final void onAdLoaded() {
        zzm(this.zzfuo.zzqy());
    }

    public final void onAdFailedToLoad(int i) {
        zzm(this.zzfuo.zzqy());
    }

    private final void zzm(Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse(this.zzcwz).buildUpon();
        for (Map.Entry next : map.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        String uri = buildUpon.build().toString();
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcmx)).booleanValue()) {
            this.zzffb.zzed(uri);
        }
        zzawz.zzds(uri);
    }

    public final void zzb(zzarx zzarx) {
        this.zzfuo.zzi(zzarx.zzdot);
    }

    public final void zza(zzcxu zzcxu) {
        this.zzfuo.zzb(zzcxu);
    }
}
