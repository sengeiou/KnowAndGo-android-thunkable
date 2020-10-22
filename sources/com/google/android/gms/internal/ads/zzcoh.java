package com.google.android.gms.internal.ads;

final class zzcoh implements zzbsn {
    private final /* synthetic */ zzcjy zzgbz;
    private final /* synthetic */ zzbbr zzgck;

    zzcoh(zzcoe zzcoe, zzbbr zzbbr, zzcjy zzcjy) {
        this.zzgck = zzbbr;
        this.zzgbz = zzcjy;
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvj)).booleanValue()) {
            i = 3;
        }
        zzbbr zzbbr = this.zzgck;
        String str = this.zzgbz.zzfis;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("adapter ");
        sb.append(str);
        sb.append(" failed to load");
        zzbbr.setException(new zzcmw(sb.toString(), i));
    }

    public final synchronized void onAdLoaded() {
        this.zzgck.set(null);
    }
}
