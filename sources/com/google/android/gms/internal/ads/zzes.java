package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzbp;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public final class zzes extends zzfk {
    public zzes(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 24);
    }

    public final Void zzcz() throws Exception {
        if (this.zzvd.isInitialized()) {
            return super.call();
        }
        if (!this.zzvd.zzcl()) {
            return null;
        }
        zzda();
        return null;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (this.zzvd.zzcl()) {
            zzda();
            return;
        }
        synchronized (this.zzzm) {
            this.zzzm.zzaf((String) this.zzzw.invoke((Object) null, new Object[]{this.zzvd.getContext()}));
        }
    }

    private final void zzda() {
        AdvertisingIdClient zzct = this.zzvd.zzct();
        if (zzct != null) {
            try {
                AdvertisingIdClient.Info info = zzct.getInfo();
                String zzap = zzef.zzap(info.getId());
                if (zzap != null) {
                    synchronized (this.zzzm) {
                        this.zzzm.zzaf(zzap);
                        this.zzzm.zzb(info.isLimitAdTrackingEnabled());
                        this.zzzm.zzb(zzbp.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    public final /* synthetic */ Object call() throws Exception {
        return call();
    }
}
