package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

public final class zzbzc {
    public static final zzbzc zzfpd = new zzbze().zzaip();
    @Nullable
    private final zzafl zzfow;
    @Nullable
    private final zzafi zzfox;
    @Nullable
    private final zzafx zzfoy;
    @Nullable
    private final zzafu zzfoz;
    @Nullable
    private final zzaje zzfpa;
    private final SimpleArrayMap<String, zzafr> zzfpb;
    private final SimpleArrayMap<String, zzafo> zzfpc;

    @Nullable
    public final zzafl zzaii() {
        return this.zzfow;
    }

    @Nullable
    public final zzafi zzaij() {
        return this.zzfox;
    }

    @Nullable
    public final zzafx zzaik() {
        return this.zzfoy;
    }

    @Nullable
    public final zzafu zzail() {
        return this.zzfoz;
    }

    @Nullable
    public final zzaje zzaim() {
        return this.zzfpa;
    }

    @Nullable
    public final zzafr zzfn(String str) {
        return this.zzfpb.get(str);
    }

    @Nullable
    public final zzafo zzfo(String str) {
        return this.zzfpc.get(str);
    }

    public final ArrayList<String> zzain() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.zzfoy != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzfow != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzfox != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.zzfpb.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzfpa != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList<String> zzaio() {
        ArrayList<String> arrayList = new ArrayList<>(this.zzfpb.size());
        for (int i = 0; i < this.zzfpb.size(); i++) {
            arrayList.add(this.zzfpb.keyAt(i));
        }
        return arrayList;
    }

    private zzbzc(zzbze zzbze) {
        this.zzfow = zzbze.zzfow;
        this.zzfox = zzbze.zzfox;
        this.zzfoy = zzbze.zzfoy;
        this.zzfpb = new SimpleArrayMap<>(zzbze.zzfpb);
        this.zzfpc = new SimpleArrayMap<>(zzbze.zzfpc);
        this.zzfoz = zzbze.zzfoz;
        this.zzfpa = zzbze.zzfpa;
    }
}
