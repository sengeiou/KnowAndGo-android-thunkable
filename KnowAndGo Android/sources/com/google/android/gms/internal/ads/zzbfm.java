package com.google.android.gms.internal.ads;

import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.List;

@zzard
public final class zzbfm implements zzbgd {
    public final zzbft zza(zzbdf zzbdf, int i, String str, zzbde zzbde) {
        if (Build.VERSION.SDK_INT >= 16 && i > 0) {
            List asList = Arrays.asList(zzbde.zzeeg.split(","));
            if (asList.contains(ExifInterface.GPS_MEASUREMENT_3D)) {
                int zzyq = zzbfa.zzyq();
                if (zzyq < zzbde.zzeej) {
                    return new zzbgp(zzbdf, zzbde);
                }
                if (zzyq < zzbde.zzeed) {
                    return new zzbgo(zzbdf, zzbde);
                }
                return new zzbgf(zzbdf);
            } else if (asList.contains("1")) {
                int zzyq2 = zzbdk.zzyq();
                if (zzyq2 < zzbde.zzeej) {
                    if (i == 1) {
                        return new zzbgk(zzbdf);
                    }
                    if (i == 2) {
                        return new zzbgh(zzbdf, (String) null);
                    }
                }
                if (zzyq2 < zzbde.zzeed) {
                    return new zzbgg(zzbdf, zzbde);
                }
                return new zzbgf(zzbdf);
            }
        }
        return new zzbge(zzbdf);
    }
}
