package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcew implements zzdti<Set<zzbuz<zzczz>>> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<String> zzfuh;
    private final zzdtu<Map<zzczs, zzcez>> zzfui;

    public zzcew(zzdtu<String> zzdtu, zzdtu<Context> zzdtu2, zzdtu<Executor> zzdtu3, zzdtu<Map<zzczs, zzcez>> zzdtu4) {
        this.zzfuh = zzdtu;
        this.zzeoj = zzdtu2;
        this.zzfgh = zzdtu3;
        this.zzfui = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        Set set;
        String str = this.zzfuh.get();
        Context context = this.zzeoj.get();
        Executor executor = this.zzfgh.get();
        Map map = this.zzfui.get();
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcul)).booleanValue()) {
            zzwj zzwj = new zzwj(new zzwo(context));
            zzwj.zza((zzwk) new zzcey(str));
            set = Collections.singleton(new zzbuz(new zzcex(zzwj, map), executor));
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzdto.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
