package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzdso extends zzdrr<zzdso> {
    public String mimeType = null;
    public Integer zzhrv = null;
    public byte[] zzhsu = null;

    public zzdso() {
        this.zzhno = null;
        this.zzhnx = -1;
    }

    public final void zza(zzdrp zzdrp) throws IOException {
        if (this.zzhrv != null) {
            zzdrp.zzx(1, this.zzhrv.intValue());
        }
        if (this.mimeType != null) {
            zzdrp.zzf(2, this.mimeType);
        }
        if (this.zzhsu != null) {
            zzdrp.zza(3, this.zzhsu);
        }
        super.zza(zzdrp);
    }

    /* access modifiers changed from: protected */
    public final int zzor() {
        int zzor = super.zzor();
        if (this.zzhrv != null) {
            zzor += zzdrp.zzab(1, this.zzhrv.intValue());
        }
        if (this.mimeType != null) {
            zzor += zzdrp.zzg(2, this.mimeType);
        }
        return this.zzhsu != null ? zzor + zzdrp.zzb(3, this.zzhsu) : zzor;
    }
}
