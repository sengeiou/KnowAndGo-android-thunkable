package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

public final class zzbva extends zzbts<zzue> implements zzue {
    private final zzcxm zzfig;
    @GuardedBy("this")
    private Map<View, zzua> zzfld = new WeakHashMap(1);
    private final Context zzlj;

    public zzbva(Context context, Set<zzbuz<zzue>> set, zzcxm zzcxm) {
        super(set);
        this.zzlj = context;
        this.zzfig = zzcxm;
    }

    public final synchronized void zza(zzud zzud) {
        zza(new zzbvb(zzud));
    }

    public final synchronized void zzq(View view) {
        zzua zzua = this.zzfld.get(view);
        if (zzua == null) {
            zzua = new zzua(this.zzlj, view);
            zzua.zza((zzue) this);
            this.zzfld.put(view, zzua);
        }
        if (this.zzfig != null && this.zzfig.zzdol) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqk)).booleanValue()) {
                zzua.zzes(((Long) zzyt.zzpe().zzd(zzacu.zzcqj)).longValue());
                return;
            }
        }
        zzua.zzmk();
    }

    public final synchronized void zzr(View view) {
        if (this.zzfld.containsKey(view)) {
            this.zzfld.get(view).zzb(this);
            this.zzfld.remove(view);
        }
    }
}
