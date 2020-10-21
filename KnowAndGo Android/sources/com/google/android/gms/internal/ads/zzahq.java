package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzard
public final class zzahq implements zzaho<Object> {
    private final Context zzlj;

    public zzahq(Context context) {
        this.zzlj = context;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (zzk.zzme().zzx(this.zzlj)) {
            String str = map.get("eventName");
            String str2 = map.get("eventId");
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 94399) {
                if (hashCode != 94401) {
                    if (hashCode == 94407 && str.equals("_ai")) {
                        c = 1;
                    }
                } else if (str.equals("_ac")) {
                    c = 0;
                }
            } else if (str.equals("_aa")) {
                c = 2;
            }
            switch (c) {
                case 0:
                    zzk.zzme().zzg(this.zzlj, str2);
                    return;
                case 1:
                    zzk.zzme().zzh(this.zzlj, str2);
                    return;
                case 2:
                    zzk.zzme().zzj(this.zzlj, str2);
                    return;
                default:
                    zzawz.zzen("logScionEvent gmsg contained unsupported eventName");
                    return;
            }
        }
    }
}
