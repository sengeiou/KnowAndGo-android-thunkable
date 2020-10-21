package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzd;
import java.util.Map;

final class zzahf implements zzaho<zzbgz> {
    zzahf() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbgz zzbgz = (zzbgz) obj;
        zzd zzaae = zzbgz.zzaae();
        if (zzaae != null) {
            zzaae.close();
            return;
        }
        zzd zzaaf = zzbgz.zzaaf();
        if (zzaaf != null) {
            zzaaf.close();
        } else {
            zzawz.zzep("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
