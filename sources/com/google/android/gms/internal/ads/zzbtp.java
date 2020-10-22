package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

public final class zzbtp extends zzbts<AppEventListener> implements zzagx {
    public zzbtp(Set<zzbuz<AppEventListener>> set) {
        super(set);
    }

    public final synchronized void onAppEvent(String str, String str2) {
        zza(new zzbtq(str, str2));
    }
}
