package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.HashMap;
import java.util.concurrent.Callable;

final /* synthetic */ class zzcxi implements Callable {
    static final Callable zzghi = new zzcxi();

    private zzcxi() {
    }

    public final Object call() {
        HashMap hashMap = new HashMap();
        String str = (String) zzyt.zzpe().zzd(zzacu.zzcmk);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzyt.zzpe().zzd(zzacu.zzcml)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    hashMap.put(str2, zzazr.zzeh(str2));
                }
            }
        }
        return new zzcxg(hashMap);
    }
}
