package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzcmu {
    /* access modifiers changed from: private */
    public final Clock zzbsa;
    private final List<String> zzgbg = Collections.synchronizedList(new ArrayList());

    public zzcmu(Clock clock) {
        this.zzbsa = clock;
    }

    public final <T> zzbbh<T> zza(zzcxm zzcxm, zzbbh<T> zzbbh) {
        long elapsedRealtime = this.zzbsa.elapsedRealtime();
        String str = zzcxm.zzdej;
        if (str != null) {
            zzbar.zza(zzbbh, new zzcmv(this, str, elapsedRealtime), zzbbm.zzeaf);
        }
        return zzbbh;
    }

    /* access modifiers changed from: private */
    public final void zza(String str, int i, long j) {
        List<String> list = this.zzgbg;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
        sb.append(str);
        sb.append(".");
        sb.append(i);
        sb.append(".");
        sb.append(j);
        list.add(sb.toString());
    }

    public final String zzaku() {
        return TextUtils.join("_", this.zzgbg);
    }
}
