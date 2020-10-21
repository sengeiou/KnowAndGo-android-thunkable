package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzahk implements zzaho<zzbgz> {
    zzahk() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbgz zzbgz = (zzbgz) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzbgz.zzlc();
        } else if ("resume".equals(str)) {
            zzbgz.zzld();
        }
    }
}
