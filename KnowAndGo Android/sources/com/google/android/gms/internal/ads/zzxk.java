package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwt;
import java.io.IOException;

public final class zzxk extends zzdrr<zzxk> {
    public String zzcep = null;
    private zzwt.zza[] zzceq = new zzwt.zza[0];
    private zzwx zzcer = null;
    private zzwx zzces = null;
    private zzwx zzcet = null;

    public zzxk() {
        this.zzhno = null;
        this.zzhnx = -1;
    }

    public final void zza(zzdrp zzdrp) throws IOException {
        if (this.zzcep != null) {
            zzdrp.zzf(1, this.zzcep);
        }
        if (this.zzceq != null && this.zzceq.length > 0) {
            for (zzwt.zza zza : this.zzceq) {
                if (zza != null) {
                    zzdrp.zze(2, zza);
                }
            }
        }
        super.zza(zzdrp);
    }

    /* access modifiers changed from: protected */
    public final int zzor() {
        int zzor = super.zzor();
        if (this.zzcep != null) {
            zzor += zzdrp.zzg(1, this.zzcep);
        }
        if (this.zzceq != null && this.zzceq.length > 0) {
            for (zzwt.zza zza : this.zzceq) {
                if (zza != null) {
                    zzor += zzdni.zzc(2, (zzdpk) zza);
                }
            }
        }
        return zzor;
    }
}
