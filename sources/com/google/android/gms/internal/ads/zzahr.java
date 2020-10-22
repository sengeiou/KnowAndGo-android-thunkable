package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;

@zzard
public final class zzahr implements zzaho<zzbgz> {
    private static final Map<String, Integer> zzdam = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final zzb zzdaj;
    private final zzapr zzdak;
    private final zzaqc zzdal;

    public zzahr(zzb zzb, zzapr zzapr, zzaqc zzaqc) {
        this.zzdaj = zzb;
        this.zzdak = zzapr;
        this.zzdal = zzaqc;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbgz zzbgz = (zzbgz) obj;
        int intValue = zzdam.get((String) map.get(NotificationBundleProcessor.PUSH_ADDITIONAL_DATA_KEY)).intValue();
        if (intValue != 5 && intValue != 7 && this.zzdaj != null && !this.zzdaj.zzkx()) {
            this.zzdaj.zzbk((String) null);
        } else if (intValue != 1) {
            switch (intValue) {
                case 3:
                    new zzapu(zzbgz, map).execute();
                    return;
                case 4:
                    new zzapo(zzbgz, map).execute();
                    return;
                case 5:
                    new zzapt(zzbgz, map).execute();
                    return;
                case 6:
                    this.zzdak.zzw(true);
                    return;
                case 7:
                    if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcmw)).booleanValue()) {
                        this.zzdal.zztd();
                        return;
                    }
                    return;
                default:
                    zzawz.zzeo("Unknown MRAID command called.");
                    return;
            }
        } else {
            this.zzdak.zzg(map);
        }
    }
}
