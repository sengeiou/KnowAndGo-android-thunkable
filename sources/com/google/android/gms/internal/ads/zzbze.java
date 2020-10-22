package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

public final class zzbze {
    zzafl zzfow;
    zzafi zzfox;
    zzafx zzfoy;
    zzafu zzfoz;
    zzaje zzfpa;
    final SimpleArrayMap<String, zzafr> zzfpb = new SimpleArrayMap<>();
    final SimpleArrayMap<String, zzafo> zzfpc = new SimpleArrayMap<>();

    public final zzbze zzb(zzafl zzafl) {
        this.zzfow = zzafl;
        return this;
    }

    public final zzbze zzb(zzafi zzafi) {
        this.zzfox = zzafi;
        return this;
    }

    public final zzbze zzb(zzafx zzafx) {
        this.zzfoy = zzafx;
        return this;
    }

    public final zzbze zza(zzafu zzafu) {
        this.zzfoz = zzafu;
        return this;
    }

    public final zzbze zzb(zzaje zzaje) {
        this.zzfpa = zzaje;
        return this;
    }

    public final zzbze zzb(String str, zzafr zzafr, zzafo zzafo) {
        this.zzfpb.put(str, zzafr);
        this.zzfpc.put(str, zzafo);
        return this;
    }

    public final zzbzc zzaip() {
        return new zzbzc(this);
    }
}
