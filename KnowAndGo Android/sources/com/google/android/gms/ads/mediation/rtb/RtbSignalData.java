package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import javax.annotation.Nullable;

public class RtbSignalData {
    private final Bundle zzcgv;
    @Nullable
    private final AdSize zzdh;
    private final MediationConfiguration zzeoc;
    private final Context zzlj;

    public RtbSignalData(Context context, MediationConfiguration mediationConfiguration, Bundle bundle, @Nullable AdSize adSize) {
        this.zzlj = context;
        this.zzeoc = mediationConfiguration;
        this.zzcgv = bundle;
        this.zzdh = adSize;
    }

    public Context getContext() {
        return this.zzlj;
    }

    public MediationConfiguration getConfiguration() {
        return this.zzeoc;
    }

    public Bundle getNetworkExtras() {
        return this.zzcgv;
    }

    @Nullable
    public AdSize getAdSize() {
        return this.zzdh;
    }
}
