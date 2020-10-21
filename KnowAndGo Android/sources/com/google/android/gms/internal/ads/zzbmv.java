package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzbmv implements zzdti<Set<zzbuz<zzbrx>>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzbmn> zzfgm;
    private final zzdtu<JSONObject> zzfgn;

    private zzbmv(zzdtu<zzbmn> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<JSONObject> zzdtu3) {
        this.zzfgm = zzdtu;
        this.zzfgh = zzdtu2;
        this.zzfgn = zzdtu3;
    }

    public static zzbmv zzd(zzdtu<zzbmn> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<JSONObject> zzdtu3) {
        return new zzbmv(zzdtu, zzdtu2, zzdtu3);
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
