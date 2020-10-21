package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrz;
import java.io.IOException;

public final class zzdsm extends zzdrr<zzdsm> {
    private zzdrz.zzb.zzd.C4384zzb zzhsp = null;
    public zzdsl[] zzhsq = zzdsl.zzbaz();
    private byte[] zzhsr = null;
    private byte[] zzhss = null;
    private Integer zzhst = null;

    public zzdsm() {
        this.zzhno = null;
        this.zzhnx = -1;
    }

    public final void zza(zzdrp zzdrp) throws IOException {
        if (this.zzhsq != null && this.zzhsq.length > 0) {
            for (zzdsl zzdsl : this.zzhsq) {
                if (zzdsl != null) {
                    zzdrp.zza(2, (zzdrw) zzdsl);
                }
            }
        }
        super.zza(zzdrp);
    }

    /* access modifiers changed from: protected */
    public final int zzor() {
        int zzor = super.zzor();
        if (this.zzhsq != null && this.zzhsq.length > 0) {
            for (zzdsl zzdsl : this.zzhsq) {
                if (zzdsl != null) {
                    zzor += zzdrp.zzb(2, (zzdrw) zzdsl);
                }
            }
        }
        return zzor;
    }
}
