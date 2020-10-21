package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

public final class zzbss extends zzbts<AdMetadataListener> implements zzagv {
    private Bundle zzfke = new Bundle();

    public zzbss(Set<zzbuz<AdMetadataListener>> set) {
        super(set);
    }

    public final synchronized void zza(String str, Bundle bundle) {
        this.zzfke.putAll(bundle);
        zza(zzbst.zzfka);
    }

    public final synchronized Bundle getAdMetadata() {
        return new Bundle(this.zzfke);
    }
}
