package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzcpo extends zzzg {
    private zzyz zzcjv;
    private final zzbjm zzgbc;
    private final Context zzgdr;
    @VisibleForTesting
    private final zzcxx zzgds = new zzcxx();
    @VisibleForTesting
    private final zzbze zzgdt = new zzbze();

    public zzcpo(zzbjm zzbjm, Context context, String str) {
        this.zzgbc = zzbjm;
        this.zzgds.zzft(str);
        this.zzgdr = context;
    }

    public final zzzc zzpk() {
        zzbzc zzaip = this.zzgdt.zzaip();
        this.zzgds.zzb(zzaip.zzain());
        this.zzgds.zzc(zzaip.zzaio());
        zzcxx zzcxx = this.zzgds;
        if (zzcxx.zzpn() == null) {
            zzcxx.zzd(zzyd.zzg(this.zzgdr));
        }
        return new zzcpp(this.zzgdr, this.zzgbc, this.zzgds, zzaip, this.zzcjv);
    }

    public final void zza(zzyz zzyz) {
        this.zzcjv = zzyz;
    }

    public final void zza(zzafi zzafi) {
        this.zzgdt.zzb(zzafi);
    }

    public final void zza(zzafx zzafx) {
        this.zzgdt.zzb(zzafx);
    }

    public final void zza(zzafl zzafl) {
        this.zzgdt.zzb(zzafl);
    }

    public final void zza(String str, zzafr zzafr, zzafo zzafo) {
        this.zzgdt.zzb(str, zzafr, zzafo);
    }

    public final void zza(zzady zzady) {
        this.zzgds.zzb(zzady);
    }

    public final void zza(zzaiy zzaiy) {
        this.zzgds.zzb(zzaiy);
    }

    public final void zza(zzaje zzaje) {
        this.zzgdt.zzb(zzaje);
    }

    public final void zza(zzzy zzzy) {
        this.zzgds.zzd(zzzy);
    }

    public final void zza(zzafu zzafu, zzyd zzyd) {
        this.zzgdt.zza(zzafu);
        this.zzgds.zzd(zzyd);
    }

    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzgds.zzb(publisherAdViewOptions);
    }
}
