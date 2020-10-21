package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbk;
import com.google.android.gms.internal.ads.zzbp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class zzdg extends zzdf {
    public static zzdg zza(String str, Context context, boolean z) {
        zza(context, z);
        return new zzdg(context, str, z);
    }

    private zzdg(Context context, String str, boolean z) {
        super(context, str, z);
    }

    /* access modifiers changed from: protected */
    public final List<Callable<Void>> zzb(zzdy zzdy, Context context, zzbp.zza.C4378zza zza, zzbk.zza zza2) {
        if (zzdy.zzch() == null || !this.zzwf) {
            return super.zzb(zzdy, context, zza, zza2);
        }
        int zzcd = zzdy.zzcd();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzb(zzdy, context, zza, zza2));
        arrayList.add(new zzes(zzdy, "3pegtvj7nkb7e3rwh5b+3dnQATJj6aqtaosJ3DkOYPzNGN2w+CoarbJEsY1UQgeA", "/kRTFQbKQx44ublaFMNQ8yNL6QxOrgEofiWDpZSH6zA=", zza, zzcd, 24));
        return arrayList;
    }
}
