package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzard
public final class zzapt {
    private final zzbgz zzdbs;
    private final boolean zzdil;
    private final String zzdim;

    public zzapt(zzbgz zzbgz, Map<String, String> map) {
        this.zzdbs = zzbgz;
        this.zzdim = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzdil = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.zzdil = true;
        }
    }

    public final void execute() {
        int i;
        if (this.zzdbs == null) {
            zzawz.zzep("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.zzdim)) {
            zzk.zzli();
            i = 7;
        } else if ("landscape".equalsIgnoreCase(this.zzdim)) {
            zzk.zzli();
            i = 6;
        } else if (this.zzdil) {
            i = -1;
        } else {
            i = zzk.zzli().zzwf();
        }
        this.zzdbs.setRequestedOrientation(i);
    }
}
