package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzk;

final /* synthetic */ class zzckt implements zzbwz {
    private final zzbbr zzbxh;

    zzckt(zzbbr zzbbr) {
        this.zzbxh = zzbbr;
    }

    public final void zza(boolean z, Context context) {
        zzbbr zzbbr = this.zzbxh;
        try {
            zzk.zzlf();
            zzm.zza(context, (AdOverlayInfoParcel) zzbbr.get(), true);
        } catch (Exception unused) {
        }
    }
}
