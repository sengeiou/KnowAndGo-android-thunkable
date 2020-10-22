package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;

public final class zzcdb extends zzbpc {
    private final zzatq zzdqw;
    private final zzbup zzflh;
    private final zzbpv zzflj;
    private final zzdan zzflk;
    private boolean zzfll = false;
    private final zzbwz zzflm;
    private final zzbrp zzftc;
    private final Context zzlj;

    zzcdb(Context context, zzbwz zzbwz, zzbup zzbup, zzbrp zzbrp, zzbry zzbry, zzbpv zzbpv, zzcxm zzcxm, zzdan zzdan) {
        this.zzlj = context;
        this.zzflm = zzbwz;
        this.zzflh = zzbup;
        this.zzftc = zzbrp;
        this.zzfiq = zzbry;
        this.zzflj = zzbpv;
        this.zzflk = zzdan;
        this.zzdqw = new zzaup(zzcxm.zzdnx);
    }

    public final void zzb(boolean z, @Nullable Activity activity) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcoe)).booleanValue()) {
            zzk.zzlg();
            if (zzaxi.zzaq(this.zzlj)) {
                zzawz.zzep("Rewarded ad can not be shown when app is not in foreground.");
                this.zzftc.zzcs(3);
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcof)).booleanValue()) {
                    this.zzflk.zzgb(this.zzffa.zzgky.zzgku.zzcep);
                    return;
                }
                return;
            }
        }
        if (this.zzfll) {
            zzawz.zzep("The rewarded ad have been showed.");
            this.zzftc.zzcs(1);
            return;
        }
        this.zzfll = true;
        this.zzflh.zzagu();
        Context context = activity;
        if (activity == null) {
            context = this.zzlj;
        }
        this.zzflm.zza(z, context);
    }

    public final zzatq zzqh() {
        return this.zzdqw;
    }

    public final zzbry zzadd() {
        return this.zzfiq;
    }

    public final boolean isClosed() {
        return this.zzflj.isClosed();
    }
}
