package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

final class zzawh implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzbbr zzdsv;

    zzawh(zzawg zzawg, Context context, zzbbr zzbbr) {
        this.val$context = context;
        this.zzdsv = zzbbr;
    }

    public final void run() {
        try {
            this.zzdsv.set(AdvertisingIdClient.getAdvertisingIdInfo(this.val$context));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.zzdsv.setException(e);
            zzbad.zzc("Exception while getting advertising Id info", e);
        }
    }
}
