package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzcsz implements zzcva<zzcsy> {
    private final zzcxv zzfjp;
    private final zzbbl zzfqw;

    public zzcsz(zzbbl zzbbl, zzcxv zzcxv) {
        this.zzfqw = zzbbl;
        this.zzfjp = zzcxv;
    }

    public final zzbbh<zzcsy> zzalm() {
        return this.zzfqw.zza(new zzcta(this));
    }

    private static int zzc(zzzy zzzy) {
        long j;
        if (zzzy != null) {
            try {
                j = zzzy.getValue();
            } catch (RemoteException unused) {
                zzawz.zzep("Cannot get correlation id, default to 0.");
            }
            return (int) j;
        }
        j = 0;
        return (int) j;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcsy zzalr() throws Exception {
        return new zzcsy(zzc(this.zzfjp.zzgkz), this.zzfjp.zzghg);
    }
}
