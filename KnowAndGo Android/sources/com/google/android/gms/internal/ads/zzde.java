package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzbk;
import com.google.android.gms.internal.ads.zzbp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class zzde extends zzdf {
    private static final String TAG = "zzde";
    private AdvertisingIdClient.Info zzwc;

    public static zzde zzb(Context context) {
        zza(context, true);
        return new zzde(context);
    }

    /* access modifiers changed from: protected */
    public final zzbp.zza.C4378zza zza(Context context, View view, Activity activity) {
        return null;
    }

    private zzde(Context context) {
        super(context, "");
    }

    public static String zza(String str, String str2) {
        return zzci.zza(str, str2, true);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzdy zzdy, Context context, zzbp.zza.C4378zza zza, zzbk.zza zza2) {
        if (!zzdy.zzxp) {
            zza(zzb(zzdy, context, zza, zza2));
        } else if (this.zzwc != null) {
            String id = this.zzwc.getId();
            if (!TextUtils.isEmpty(id)) {
                zza.zzaf(zzef.zzap(id));
                zza.zzb(zzbp.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                zza.zzb(this.zzwc.isLimitAdTrackingEnabled());
            }
            this.zzwc = null;
        }
    }

    /* access modifiers changed from: protected */
    public final List<Callable<Void>> zzb(zzdy zzdy, Context context, zzbp.zza.C4378zza zza, zzbk.zza zza2) {
        ArrayList arrayList = new ArrayList();
        if (zzdy.zzch() == null) {
            return arrayList;
        }
        arrayList.add(new zzes(zzdy, "3pegtvj7nkb7e3rwh5b+3dnQATJj6aqtaosJ3DkOYPzNGN2w+CoarbJEsY1UQgeA", "/kRTFQbKQx44ublaFMNQ8yNL6QxOrgEofiWDpZSH6zA=", zza, zzdy.zzcd(), 24));
        return arrayList;
    }

    public final void zza(AdvertisingIdClient.Info info) {
        this.zzwc = info;
    }
}
