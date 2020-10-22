package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

public final class zzcpa implements zzcou<zzbvx> {
    private final zzbws zzfzy;
    private final Context zzlj;

    public zzcpa(Context context, zzbws zzbws) {
        this.zzlj = context;
        this.zzfzy = zzbws;
    }

    public final /* synthetic */ Object zza(zzcxu zzcxu, zzcxm zzcxm, View view, zzcoz zzcoz) {
        zzbvy zza = this.zzfzy.zza(new zzbpr(zzcxu, zzcxm, (String) null), new zzcpc(this, zzcpb.zzgde));
        zzcoz.zza(new zzcpd(this, zza));
        return zza.zzaee();
    }
}
