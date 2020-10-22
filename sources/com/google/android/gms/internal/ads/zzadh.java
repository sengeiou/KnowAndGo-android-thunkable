package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzadh {
    private final Map<String, zzadg> zzcxo = new HashMap();
    @Nullable
    private final zzadi zzcxp;

    public zzadh(@Nullable zzadi zzadi) {
        this.zzcxp = zzadi;
    }

    public final void zza(String str, zzadg zzadg) {
        this.zzcxo.put(str, zzadg);
    }

    public final void zza(String str, String str2, long j) {
        zzadg zzadg;
        zzadi zzadi = this.zzcxp;
        zzadg zzadg2 = this.zzcxo.get(str2);
        String[] strArr = {str};
        if (!(zzadi == null || zzadg2 == null)) {
            zzadi.zza(zzadg2, j, strArr);
        }
        Map<String, zzadg> map = this.zzcxo;
        zzadi zzadi2 = this.zzcxp;
        if (zzadi2 == null) {
            zzadg = null;
        } else {
            zzadg = zzadi2.zzfa(j);
        }
        map.put(str, zzadg);
    }

    @Nullable
    public final zzadi zzqw() {
        return this.zzcxp;
    }
}
