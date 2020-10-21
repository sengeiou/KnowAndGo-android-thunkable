package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzdsk extends zzdrr<zzdsk> {
    public String zzdrr = null;

    public zzdsk() {
        this.zzhno = null;
        this.zzhnx = -1;
    }

    public final void zza(zzdrp zzdrp) throws IOException {
        if (this.zzdrr != null) {
            zzdrp.zzf(1, this.zzdrr);
        }
        super.zza(zzdrp);
    }

    /* access modifiers changed from: protected */
    public final int zzor() {
        int zzor = super.zzor();
        return this.zzdrr != null ? zzor + zzdrp.zzg(1, this.zzdrr) : zzor;
    }
}
