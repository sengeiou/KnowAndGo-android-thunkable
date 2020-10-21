package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.Set;

public class zzbnk {
    private final View view;
    private final zzbgz zzdbs;
    private final zzcxn zzfgx;
    private final zzbpb zzfgy;

    public zzbnk(View view2, @Nullable zzbgz zzbgz, zzbpb zzbpb, zzcxn zzcxn) {
        this.view = view2;
        this.zzdbs = zzbgz;
        this.zzfgy = zzbpb;
        this.zzfgx = zzcxn;
    }

    @Nullable
    public final zzbgz zzafn() {
        return this.zzdbs;
    }

    public final View zzafi() {
        return this.view;
    }

    public final zzbpb zzafo() {
        return this.zzfgy;
    }

    public final zzcxn zzafp() {
        return this.zzfgx;
    }

    public zzbso zza(Set<zzbuz<zzbsr>> set) {
        return new zzbso(set);
    }
}
