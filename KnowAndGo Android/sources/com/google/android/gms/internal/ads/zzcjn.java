package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzwt;
import java.util.ArrayList;

final class zzcjn implements zzban<Bundle> {
    private final /* synthetic */ boolean zzfza;
    final /* synthetic */ zzcjm zzfzb;

    zzcjn(zzcjm zzcjm, boolean z) {
        this.zzfzb = zzcjm;
        this.zzfza = z;
    }

    public final void zzb(Throwable th) {
        zzawz.zzen("Failed to get signals bundle");
    }

    public final /* synthetic */ void zzk(Object obj) {
        Bundle bundle = (Bundle) obj;
        ArrayList zza = zzcjm.zzl(bundle);
        zzwt.zzi.zzc zzb = zzcjm.zzk(bundle);
        this.zzfzb.zzfyx.zza(new zzcjo(this, this.zzfza, zza, this.zzfzb.zzj(bundle), zzb));
    }
}
