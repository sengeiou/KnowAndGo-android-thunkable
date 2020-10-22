package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwt;
import java.io.IOException;

public final class zzxj extends zzdrr<zzxj> {
    public Integer zzcee = null;
    private zzwx zzcef = null;
    private zzwt.zzb zzceg = null;
    public zzxk zzceh = null;
    private zzwt.zza[] zzcei = new zzwt.zza[0];
    private zzwt.zzc zzcej = null;
    private zzwt.zzj zzcek = null;
    private zzwt.zzh zzcel = null;
    private zzwt.zze zzcem = null;
    private zzwt.zzf zzcen = null;
    private zzxp[] zzceo = zzxp.zzos();

    public zzxj() {
        this.zzhno = null;
        this.zzhnx = -1;
    }

    public final void zza(zzdrp zzdrp) throws IOException {
        if (this.zzcee != null) {
            zzdrp.zzx(7, this.zzcee.intValue());
        }
        if (this.zzceh != null) {
            zzdrp.zza(10, (zzdrw) this.zzceh);
        }
        if (this.zzcei != null && this.zzcei.length > 0) {
            for (zzwt.zza zza : this.zzcei) {
                if (zza != null) {
                    zzdrp.zze(11, zza);
                }
            }
        }
        if (this.zzceo != null && this.zzceo.length > 0) {
            for (zzxp zzxp : this.zzceo) {
                if (zzxp != null) {
                    zzdrp.zza(17, (zzdrw) zzxp);
                }
            }
        }
        super.zza(zzdrp);
    }

    /* access modifiers changed from: protected */
    public final int zzor() {
        int zzor = super.zzor();
        if (this.zzcee != null) {
            zzor += zzdrp.zzab(7, this.zzcee.intValue());
        }
        if (this.zzceh != null) {
            zzor += zzdrp.zzb(10, (zzdrw) this.zzceh);
        }
        if (this.zzcei != null && this.zzcei.length > 0) {
            int i = zzor;
            for (zzwt.zza zza : this.zzcei) {
                if (zza != null) {
                    i += zzdni.zzc(11, (zzdpk) zza);
                }
            }
            zzor = i;
        }
        if (this.zzceo != null && this.zzceo.length > 0) {
            for (zzxp zzxp : this.zzceo) {
                if (zzxp != null) {
                    zzor += zzdrp.zzb(17, (zzdrw) zzxp);
                }
            }
        }
        return zzor;
    }
}
