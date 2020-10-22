package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcws implements zzdti<zzcwq> {
    private final zzdtu<ScheduledExecutorService> zzfjc;
    private final zzdtu<ApplicationInfo> zzfws;
    private final zzdtu<zzamg> zzgit;
    private final zzdtu<Boolean> zzgjl;

    public zzcws(zzdtu<zzamg> zzdtu, zzdtu<ScheduledExecutorService> zzdtu2, zzdtu<Boolean> zzdtu3, zzdtu<ApplicationInfo> zzdtu4) {
        this.zzgit = zzdtu;
        this.zzfjc = zzdtu2;
        this.zzgjl = zzdtu3;
        this.zzfws = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        return new zzcwq(this.zzgit.get(), this.zzfjc.get(), this.zzgjl.get().booleanValue(), this.zzfws.get());
    }
}
