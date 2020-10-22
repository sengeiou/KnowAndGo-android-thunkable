package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.exoplayer2.C1470C;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzaxi;

@zzard
public final class zzm {
    public static void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.zzdkr == 4 && adOverlayInfoParcel.zzdkm == null) {
            if (adOverlayInfoParcel.zzcgi != null) {
                adOverlayInfoParcel.zzcgi.onAdClicked();
            }
            zzk.zzle();
            zza.zza(context, adOverlayInfoParcel.zzdkl, adOverlayInfoParcel.zzdkq);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzbtc.zzdze);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.zza(intent, adOverlayInfoParcel);
        if (!PlatformVersion.isAtLeastLollipop()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(C1470C.ENCODING_PCM_MU_LAW);
        }
        zzk.zzlg();
        zzaxi.zza(context, intent);
    }
}
