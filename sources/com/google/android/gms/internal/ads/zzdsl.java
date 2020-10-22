package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzdsl extends zzdrr<zzdsl> {
    private static volatile zzdsl[] zzhsm;
    public byte[] zzhsn = null;
    public byte[] zzhso = null;

    public static zzdsl[] zzbaz() {
        if (zzhsm == null) {
            synchronized (zzdrv.zzhnw) {
                if (zzhsm == null) {
                    zzhsm = new zzdsl[0];
                }
            }
        }
        return zzhsm;
    }

    public zzdsl() {
        this.zzhno = null;
        this.zzhnx = -1;
    }

    public final void zza(zzdrp zzdrp) throws IOException {
        zzdrp.zza(1, this.zzhsn);
        if (this.zzhso != null) {
            zzdrp.zza(2, this.zzhso);
        }
        super.zza(zzdrp);
    }

    /* access modifiers changed from: protected */
    public final int zzor() {
        int zzor = super.zzor() + zzdrp.zzb(1, this.zzhsn);
        return this.zzhso != null ? zzor + zzdrp.zzb(2, this.zzhso) : zzor;
    }
}
