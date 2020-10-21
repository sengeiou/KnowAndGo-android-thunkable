package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

public final class zzcni extends zzcoj {
    private zzbvj zzgbr;
    private zzbrp zzgbs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcni(zzbri zzbri, zzbrt zzbrt, zzbse zzbse, zzbso zzbso, zzbrp zzbrp, zzbtp zzbtp, zzbvq zzbvq, zzbsv zzbsv, zzbvj zzbvj) {
        super(zzbri, zzbrt, zzbse, zzbso, zzbtp, zzbsv, zzbvq);
        this.zzgbr = zzbvj;
        this.zzgbs = zzbrp;
    }

    public final void zzb(Bundle bundle) throws RemoteException {
    }

    public final void zzsm() {
        this.zzgbr.zzrq();
    }

    public final void zzcs(int i) throws RemoteException {
        this.zzgbs.zzcs(i);
    }

    public final void zzsn() throws RemoteException {
        this.zzgbr.zzrr();
    }

    public final void zza(zzatq zzatq) throws RemoteException {
        this.zzgbr.zza(new zzato(zzatq.getType(), zzatq.getAmount()));
    }

    public final void zzb(zzato zzato) {
        this.zzgbr.zza(zzato);
    }

    public final void onVideoEnd() {
        this.zzgbr.zzrr();
    }
}
