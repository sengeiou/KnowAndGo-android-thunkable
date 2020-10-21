package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzcru implements zzdti<zzcrs> {
    private final zzdtu<Set<String>> zzggm;

    private zzcru(zzdtu<Set<String>> zzdtu) {
        this.zzggm = zzdtu;
    }

    public static zzcru zzak(zzdtu<Set<String>> zzdtu) {
        return new zzcru(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzcrs(this.zzggm.get());
    }
}
