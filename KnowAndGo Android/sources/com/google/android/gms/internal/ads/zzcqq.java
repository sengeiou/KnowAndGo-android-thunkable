package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbqy;
import com.google.android.gms.internal.ads.zzbtv;
import com.google.android.gms.internal.ads.zzcqt;

public final class zzcqq extends zzawb {
    private zzbjm zzgfq;

    public zzcqq(zzbjm zzbjm) {
        this.zzgfq = zzbjm;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzawc zzawc, zzavy zzavy) {
        String str = zzawc.zzchk;
        String str2 = zzawc.zzbsu;
        zzyd zzyd = zzawc.zzdsu;
        zzcqp zza = this.zzgfq.zzacn().zze(new zzbqy.zza().zzbt((Context) ObjectWrapper.unwrap(iObjectWrapper)).zza(new zzcxx().zzft(str).zzg(new zzya().zzot()).zzd(zzyd).zzamq()).zzagh()).zza(new zzcqt(new zzcqt.zza().zzfs(str2)));
        new zzbtv.zza().zzagt();
        zzbar.zza(zza.zzaem().zzaen(), new zzcqr(this, zzavy), this.zzgfq.zzace());
    }
}
