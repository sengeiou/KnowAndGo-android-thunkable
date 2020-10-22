package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwt;
import java.io.IOException;

public final class zzxl extends zzdrr<zzxl> {
    public String zzceu = null;
    private zzwt.zzn zzcev = null;
    private Integer zzcew = null;
    public zzxo zzcex = null;
    private Integer zzcey = null;
    private zzwx zzcez = null;
    private zzwx zzcfa = null;
    private zzwx zzcfb = null;

    public zzxl() {
        this.zzhno = null;
        this.zzhnx = -1;
    }

    public final void zza(zzdrp zzdrp) throws IOException {
        if (this.zzceu != null) {
            zzdrp.zzf(1, this.zzceu);
        }
        if (this.zzcex != null) {
            zzdrp.zza(4, (zzdrw) this.zzcex);
        }
        super.zza(zzdrp);
    }

    /* access modifiers changed from: protected */
    public final int zzor() {
        int zzor = super.zzor();
        if (this.zzceu != null) {
            zzor += zzdrp.zzg(1, this.zzceu);
        }
        return this.zzcex != null ? zzor + zzdrp.zzb(4, (zzdrw) this.zzcex) : zzor;
    }
}
