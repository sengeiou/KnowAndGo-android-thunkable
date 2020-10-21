package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

public final class zzfh extends zzfk {
    private final View zzze;

    public zzfh(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2, View view) {
        super(zzdy, str, str2, zza, i, 57);
        this.zzze = view;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (this.zzze != null) {
            Boolean bool = (Boolean) zzyt.zzpe().zzd(zzacu.zzcrr);
            DisplayMetrics displayMetrics = this.zzvd.getContext().getResources().getDisplayMetrics();
            zzeg zzeg = new zzeg((String) this.zzzw.invoke((Object) null, new Object[]{this.zzze, displayMetrics, bool}));
            zzbp.zza.zzf.C4380zza zzat = zzbp.zza.zzf.zzat();
            zzat.zzdc(zzeg.zzyn.longValue()).zzdd(zzeg.zzyo.longValue()).zzde(zzeg.zzyp.longValue());
            if (bool.booleanValue()) {
                zzat.zzdf(zzeg.zzyq.longValue());
            }
            this.zzzm.zzb((zzbp.zza.zzf) ((zzdob) zzat.zzaya()));
        }
    }
}
