package com.google.android.gms.internal.ads;

public final class zzcjg implements zzbro, zzbsr {
    private static final Object zzfyh = new Object();
    private static int zzfyi = 0;
    private final zzcjm zzfyj;

    public zzcjg(zzcjm zzcjm) {
        this.zzfyj = zzcjm;
    }

    public final void onAdLoaded() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwt)).booleanValue() && zzakk()) {
            this.zzfyj.zzba(true);
            zzakj();
        }
    }

    public final void onAdFailedToLoad(int i) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwt)).booleanValue() && zzakk()) {
            this.zzfyj.zzba(false);
            zzakj();
        }
    }

    private static void zzakj() {
        synchronized (zzfyh) {
            zzfyi++;
        }
    }

    private static boolean zzakk() {
        boolean z;
        synchronized (zzfyh) {
            z = zzfyi < ((Integer) zzyt.zzpe().zzd(zzacu.zzcwu)).intValue();
        }
        return z;
    }
}
