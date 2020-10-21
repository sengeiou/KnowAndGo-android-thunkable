package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzdsq extends zzdrr<zzdsq> {
    public String zzhte = null;
    public Long zzhtf = null;
    public Boolean zzhtg = null;

    public zzdsq() {
        this.zzhno = null;
        this.zzhnx = -1;
    }

    public final void zza(zzdrp zzdrp) throws IOException {
        if (this.zzhte != null) {
            zzdrp.zzf(1, this.zzhte);
        }
        if (this.zzhtf != null) {
            long longValue = this.zzhtf.longValue();
            zzdrp.zzw(2, 0);
            zzdrp.zzfv(longValue);
        }
        if (this.zzhtg != null) {
            zzdrp.zzi(3, this.zzhtg.booleanValue());
        }
        super.zza(zzdrp);
    }

    /* access modifiers changed from: protected */
    public final int zzor() {
        int zzor = super.zzor();
        if (this.zzhte != null) {
            zzor += zzdrp.zzg(1, this.zzhte);
        }
        if (this.zzhtf != null) {
            zzor += zzdrp.zzgd(2) + zzdrp.zzfw(this.zzhtf.longValue());
        }
        if (this.zzhtg == null) {
            return zzor;
        }
        this.zzhtg.booleanValue();
        return zzor + zzdrp.zzgd(3) + 1;
    }
}
