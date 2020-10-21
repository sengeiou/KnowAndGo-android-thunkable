package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwt;
import java.io.IOException;

public final class zzxn extends zzdrr<zzxn> {
    private Integer zzcfc = null;
    public String zzcfd = null;
    private Integer zzcfe = null;
    private zzwx zzcff = null;
    private zzxo zzcfg = null;
    public long[] zzcfh = zzdry.zzhoc;
    public zzxl zzcfi = null;
    private zzxm zzcfj = null;
    private zzwt.zzg zzcfk = null;
    public zzxj zzcfl = null;
    public zzwt.zzi zzcfm = null;
    public zzwt.zzv zzcfn = null;

    public zzxn() {
        this.zzhno = null;
        this.zzhnx = -1;
    }

    public final void zza(zzdrp zzdrp) throws IOException {
        if (this.zzcfd != null) {
            zzdrp.zzf(10, this.zzcfd);
        }
        if (this.zzcfh != null && this.zzcfh.length > 0) {
            for (long zzfv : this.zzcfh) {
                zzdrp.zzw(14, 0);
                zzdrp.zzfv(zzfv);
            }
        }
        if (this.zzcfi != null) {
            zzdrp.zza(15, (zzdrw) this.zzcfi);
        }
        if (this.zzcfl != null) {
            zzdrp.zza(18, (zzdrw) this.zzcfl);
        }
        if (this.zzcfm != null) {
            zzdrp.zze(19, this.zzcfm);
        }
        if (this.zzcfn != null) {
            zzdrp.zze(20, this.zzcfn);
        }
        super.zza(zzdrp);
    }

    /* access modifiers changed from: protected */
    public final int zzor() {
        int zzor = super.zzor();
        if (this.zzcfd != null) {
            zzor += zzdrp.zzg(10, this.zzcfd);
        }
        if (this.zzcfh != null && this.zzcfh.length > 0) {
            int i = 0;
            for (long zzfw : this.zzcfh) {
                i += zzdrp.zzfw(zzfw);
            }
            zzor = zzor + i + (this.zzcfh.length * 1);
        }
        if (this.zzcfi != null) {
            zzor += zzdrp.zzb(15, (zzdrw) this.zzcfi);
        }
        if (this.zzcfl != null) {
            zzor += zzdrp.zzb(18, (zzdrw) this.zzcfl);
        }
        if (this.zzcfm != null) {
            zzor += zzdni.zzc(19, (zzdpk) this.zzcfm);
        }
        return this.zzcfn != null ? zzor + zzdni.zzc(20, (zzdpk) this.zzcfn) : zzor;
    }
}
