package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzk;

final /* synthetic */ class zzbhg implements zzbal {
    private final zzdh zzdcf;
    private final Context zzdef;
    private final zzbai zzejw;
    private final zza zzejx;
    private final String zzejy;

    zzbhg(Context context, zzdh zzdh, zzbai zzbai, zza zza, String str) {
        this.zzdef = context;
        this.zzdcf = zzdh;
        this.zzejw = zzbai;
        this.zzejx = zza;
        this.zzejy = str;
    }

    public final zzbbh zzf(Object obj) {
        Context context = this.zzdef;
        zzdh zzdh = this.zzdcf;
        zzbai zzbai = this.zzejw;
        zza zza = this.zzejx;
        String str = this.zzejy;
        zzk.zzlh();
        zzbgz zza2 = zzbhf.zza(context, zzbin.zzabu(), "", false, false, zzdh, zzbai, (zzadi) null, (zzj) null, zza, zzwj.zznl());
        zzbbq zzn = zzbbq.zzn(zza2);
        zza2.zzaai().zza((zzbij) new zzbhi(zzn));
        zza2.loadUrl(str);
        return zzn;
    }
}
