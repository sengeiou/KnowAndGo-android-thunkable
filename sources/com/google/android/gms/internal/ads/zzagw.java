package com.google.android.gms.internal.ads;

import java.util.Map;

@zzard
public final class zzagw implements zzaho<Object> {
    private final zzagx zzczp;

    public zzagw(zzagx zzagx) {
        this.zzczp = zzagx;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzawz.zzep("App event with no name parameter.");
        } else {
            this.zzczp.onAppEvent(str, map.get("info"));
        }
    }
}
