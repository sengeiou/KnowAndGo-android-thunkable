package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.List;

public final class zzcxy {
    public static zzyd zza(Context context, List<zzcxn> list) {
        ArrayList arrayList = new ArrayList();
        for (zzcxn next : list) {
            if (next.zzgkq) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(next.width, next.height));
            }
        }
        return new zzyd(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }
}
