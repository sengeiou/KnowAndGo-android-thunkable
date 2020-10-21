package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzbmj implements zzaho<Object> {
    final /* synthetic */ zzbmg zzffm;

    zzbmj(zzbmg zzbmg) {
        this.zzffm = zzbmg;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzffm.zzl(map)) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvs)).booleanValue()) {
                this.zzffm.zzffi.execute(new zzbmk(this));
            } else {
                this.zzffm.zzffj.zzaff();
            }
        }
    }
}
