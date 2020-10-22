package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
@zzard
public final class zzalk {
    private final Object zzdde = new Object();
    private final Object zzddf = new Object();
    @GuardedBy("lockClient")
    private zzalr zzddg;
    @GuardedBy("lockService")
    private zzalr zzddh;

    public final zzalr zza(Context context, zzbai zzbai) {
        zzalr zzalr;
        synchronized (this.zzddf) {
            if (this.zzddh == null) {
                this.zzddh = new zzalr(zzk(context), zzbai, (String) zzyt.zzpe().zzd(zzacu.zzcku));
            }
            zzalr = this.zzddh;
        }
        return zzalr;
    }

    public final zzalr zzb(Context context, zzbai zzbai) {
        zzalr zzalr;
        synchronized (this.zzdde) {
            if (this.zzddg == null) {
                this.zzddg = new zzalr(zzk(context), zzbai, (String) zzyt.zzpe().zzd(zzacu.zzckv));
            }
            zzalr = this.zzddg;
        }
        return zzalr;
    }

    private static Context zzk(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }
}
