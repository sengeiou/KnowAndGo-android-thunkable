package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

public final class zzbvx extends zzbpc {
    private final zzbup zzflh;
    private final zzbwz zzfli;
    private final zzbpv zzflj;
    private final zzdan zzflk;
    private boolean zzfll = false;
    private final Context zzlj;

    zzbvx(Context context, zzbry zzbry, zzbup zzbup, zzbwz zzbwz, zzbpv zzbpv, zzdan zzdan) {
        this.zzlj = context;
        this.zzfiq = zzbry;
        this.zzflh = zzbup;
        this.zzfli = zzbwz;
        this.zzflj = zzbpv;
        this.zzflk = zzdan;
    }

    public final void show(boolean z) {
        this.zzflh.zzagu();
        this.zzfli.zza(z, this.zzlj);
        this.zzfll = true;
    }

    public final zzbry zzadd() {
        return this.zzfiq;
    }

    public final boolean isClosed() {
        return this.zzflj.isClosed();
    }

    public final boolean zzagz() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcoe)).booleanValue()) {
            zzk.zzlg();
            if (zzaxi.zzaq(this.zzlj)) {
                zzawz.zzep("It is not recommended to show an interstitial when app is not in foreground.");
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcof)).booleanValue()) {
                    this.zzflk.zzgb(this.zzffa.zzgky.zzgku.zzcep);
                }
                return false;
            }
        }
        if (!this.zzfll) {
            return true;
        }
        return false;
    }
}
