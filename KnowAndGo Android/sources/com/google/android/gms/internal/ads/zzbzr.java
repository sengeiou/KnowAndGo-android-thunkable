package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

final class zzbzr implements zzaho<Object> {
    private final /* synthetic */ zzagd zzfqf;
    private final /* synthetic */ zzbzq zzfqg;

    zzbzr(zzbzq zzbzq, zzagd zzagd) {
        this.zzfqg = zzbzq;
        this.zzfqf = zzagd;
    }

    public final void zza(Object obj, Map<String, String> map) {
        try {
            this.zzfqg.zzfqd = Long.valueOf(Long.parseLong(map.get("timestamp")));
        } catch (NumberFormatException unused) {
            zzawz.zzen("Failed to call parse unconfirmedClickTimestamp.");
        }
        this.zzfqg.zzfqc = map.get("id");
        String str = map.get("asset_id");
        if (this.zzfqf == null) {
            zzawz.zzdp("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            this.zzfqf.onUnconfirmedClickReceived(str);
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}
