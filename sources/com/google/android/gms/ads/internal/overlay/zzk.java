package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzawv;
import com.google.android.gms.internal.ads.zzaxi;

@zzard
final class zzk extends zzawv {
    final /* synthetic */ zzd zzdki;

    private zzk(zzd zzd) {
        this.zzdki = zzd;
    }

    public final void zzto() {
        Bitmap zza = com.google.android.gms.ads.internal.zzk.zzlz().zza(Integer.valueOf(this.zzdki.zzdjl.zzdkt.zzbrj));
        if (zza != null) {
            zzaxi.zzdvv.post(new zzl(this, com.google.android.gms.ads.internal.zzk.zzli().zza(this.zzdki.mActivity, zza, this.zzdki.zzdjl.zzdkt.zzbrh, this.zzdki.zzdjl.zzdkt.zzbri)));
        }
    }
}
