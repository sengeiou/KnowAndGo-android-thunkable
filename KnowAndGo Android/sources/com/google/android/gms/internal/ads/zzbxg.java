package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

public final class zzbxg implements zzbrl, zzbur {
    @Nullable
    private final View view;
    private final zzavg zzbsq;
    private final zzavf zzfio;
    private final int zzflt;
    private String zzflx;
    private final Context zzlj;

    public zzbxg(zzavf zzavf, Context context, zzavg zzavg, @Nullable View view2, int i) {
        this.zzfio = zzavf;
        this.zzlj = context;
        this.zzbsq = zzavg;
        this.view = view2;
        this.zzflt = i;
    }

    public final void onAdLeftApplication() {
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void onAdOpened() {
        if (!(this.view == null || this.zzflx == null)) {
            this.zzbsq.zzf(this.view.getContext(), this.zzflx);
        }
        this.zzfio.zzag(true);
    }

    public final void onAdClosed() {
        this.zzfio.zzag(false);
    }

    public final void zzagu() {
        this.zzflx = this.zzbsq.zzz(this.zzlj);
        String valueOf = String.valueOf(this.zzflx);
        String valueOf2 = String.valueOf(this.zzflt == 7 ? "/Rewarded" : "/Interstitial");
        this.zzflx = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    @ParametersAreNonnullByDefault
    public final void zzb(zzasr zzasr, String str, String str2) {
        if (this.zzbsq.zzx(this.zzlj)) {
            try {
                this.zzbsq.zza(this.zzlj, this.zzbsq.zzac(this.zzlj), this.zzfio.getAdUnitId(), zzasr.getType(), zzasr.getAmount());
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception to get reward item.", e);
            }
        }
    }
}
