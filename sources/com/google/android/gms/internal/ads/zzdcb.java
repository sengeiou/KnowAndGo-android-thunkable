package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzdcb<P> {
    private final P zzgpl;
    private final byte[] zzgpm;
    private final zzdgu zzgpn;
    private final zzdhm zzgpo;

    public zzdcb(P p, byte[] bArr, zzdgu zzdgu, zzdhm zzdhm) {
        this.zzgpl = p;
        this.zzgpm = Arrays.copyOf(bArr, bArr.length);
        this.zzgpn = zzdgu;
        this.zzgpo = zzdhm;
    }

    public final P zzanv() {
        return this.zzgpl;
    }

    public final zzdhm zzanw() {
        return this.zzgpo;
    }

    public final byte[] zzanx() {
        if (this.zzgpm == null) {
            return null;
        }
        return Arrays.copyOf(this.zzgpm, this.zzgpm.length);
    }
}
