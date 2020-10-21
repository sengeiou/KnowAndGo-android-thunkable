package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;
import java.util.Map;

public final class zzcac implements zzbrw {
    private final zzbyt zzfmq;
    private final zzbyx zzfnq;

    public zzcac(zzbyt zzbyt, zzbyx zzbyx) {
        this.zzfmq = zzbyt;
        this.zzfnq = zzbyx;
    }

    public final void onAdImpression() {
        if (this.zzfmq.zzaib() != null) {
            zzbgz zzaia = this.zzfmq.zzaia();
            zzbgz zzahz = this.zzfmq.zzahz();
            if (zzaia == null) {
                zzaia = zzahz != null ? zzahz : null;
            }
            if (this.zzfnq.zzaih() && zzaia != null) {
                zzaia.zza("onSdkImpression", (Map<String, ?>) new ArrayMap());
            }
        }
    }
}
