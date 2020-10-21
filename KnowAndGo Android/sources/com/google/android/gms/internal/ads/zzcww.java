package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcww implements zzdti<zzcwu> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<ScheduledExecutorService> zzfjc;
    private final zzdtu<zzaqm> zzgit;

    public zzcww(zzdtu<zzaqm> zzdtu, zzdtu<ScheduledExecutorService> zzdtu2, zzdtu<Context> zzdtu3) {
        this.zzgit = zzdtu;
        this.zzfjc = zzdtu2;
        this.zzeoj = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        return new zzcwu(this.zzgit.get(), this.zzfjc.get(), this.zzeoj.get());
    }
}
