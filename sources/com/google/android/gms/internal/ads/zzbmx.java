package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzbmx implements zzdti<Set<zzbuz<zzo>>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzbmn> zzfgm;
    private final zzdtu<JSONObject> zzfgn;

    private zzbmx(zzdtu<zzbmn> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<JSONObject> zzdtu3) {
        this.zzfgm = zzdtu;
        this.zzfgh = zzdtu2;
        this.zzfgn = zzdtu3;
    }

    public static zzbmx zzf(zzdtu<zzbmn> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<JSONObject> zzdtu3) {
        return new zzbmx(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        Set set;
        zzbmn zzbmn = this.zzfgm.get();
        Executor executor = this.zzfgh.get();
        if (this.zzfgn.get() == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzbuz(zzbmn, executor));
        }
        return (Set) zzdto.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
