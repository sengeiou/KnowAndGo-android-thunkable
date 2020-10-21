package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcus implements zzcva<zzcur> {
    private final zzavg zzbsq;
    private final zzbbl zzfqw;
    private final Context zzlj;

    public zzcus(zzavg zzavg, zzbbl zzbbl, Context context) {
        this.zzbsq = zzavg;
        this.zzfqw = zzbbl;
        this.zzlj = context;
    }

    public final zzbbh<zzcur> zzalm() {
        return this.zzfqw.zza(new zzcut(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcur zzalx() throws Exception {
        Long l;
        if (!this.zzbsq.zzx(this.zzlj)) {
            return new zzcur((String) null, (String) null, (String) null, (String) null, (Long) null);
        }
        String zzaa = this.zzbsq.zzaa(this.zzlj);
        if (zzaa == null) {
            zzaa = "";
        }
        String str = zzaa;
        String zzab = this.zzbsq.zzab(this.zzlj);
        if (zzab == null) {
            zzab = "";
        }
        String str2 = zzab;
        String zzac = this.zzbsq.zzac(this.zzlj);
        if (zzac == null) {
            zzac = "";
        }
        String str3 = zzac;
        String zzad = this.zzbsq.zzad(this.zzlj);
        if (zzad == null) {
            zzad = "";
        }
        String str4 = zzad;
        if ("TIME_OUT".equals(str2)) {
            l = (Long) zzyt.zzpe().zzd(zzacu.zzcnx);
        } else {
            l = null;
        }
        return new zzcur(str, str2, str3, str4, l);
    }
}
