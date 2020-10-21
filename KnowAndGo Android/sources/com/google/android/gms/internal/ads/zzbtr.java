package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

public final class zzbtr implements zzdti<zzbtp> {
    private final zzdtu<Set<zzbuz<AppEventListener>>> zzfhq;

    private zzbtr(zzdtu<Set<zzbuz<AppEventListener>>> zzdtu) {
        this.zzfhq = zzdtu;
    }

    public static zzbtr zzv(zzdtu<Set<zzbuz<AppEventListener>>> zzdtu) {
        return new zzbtr(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzbtp(this.zzfhq.get());
    }
}
