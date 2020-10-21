package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrz;
import java.io.IOException;

public final class zzdsj extends zzdrr<zzdsj> {
    public String url = null;
    public Integer zzhrv = null;
    private zzdrz.zza.zzc zzhrw = null;
    public String zzhrx = null;
    private String zzhry = null;
    public zzdsk zzhrz = null;
    public zzdsp[] zzhsa = zzdsp.zzbba();
    public String zzhsb = null;
    public zzdso zzhsc = null;
    private Boolean zzhsd = null;
    private String[] zzhse = zzdry.zzhog;
    private String zzhsf = null;
    private Boolean zzhsg = null;
    private Boolean zzhsh = null;
    private byte[] zzhsi = null;
    public zzdsq zzhsj = null;
    public String[] zzhsk = zzdry.zzhog;
    public String[] zzhsl = zzdry.zzhog;

    public zzdsj() {
        this.zzhno = null;
        this.zzhnx = -1;
    }

    public final void zza(zzdrp zzdrp) throws IOException {
        if (this.url != null) {
            zzdrp.zzf(1, this.url);
        }
        if (this.zzhrx != null) {
            zzdrp.zzf(2, this.zzhrx);
        }
        if (this.zzhsa != null && this.zzhsa.length > 0) {
            for (zzdsp zzdsp : this.zzhsa) {
                if (zzdsp != null) {
                    zzdrp.zza(4, (zzdrw) zzdsp);
                }
            }
        }
        if (this.zzhse != null && this.zzhse.length > 0) {
            for (String str : this.zzhse) {
                if (str != null) {
                    zzdrp.zzf(6, str);
                }
            }
        }
        if (this.zzhrv != null) {
            zzdrp.zzx(10, this.zzhrv.intValue());
        }
        if (this.zzhrz != null) {
            zzdrp.zza(12, (zzdrw) this.zzhrz);
        }
        if (this.zzhsb != null) {
            zzdrp.zzf(13, this.zzhsb);
        }
        if (this.zzhsc != null) {
            zzdrp.zza(14, (zzdrw) this.zzhsc);
        }
        if (this.zzhsj != null) {
            zzdrp.zza(17, (zzdrw) this.zzhsj);
        }
        if (this.zzhsk != null && this.zzhsk.length > 0) {
            for (String str2 : this.zzhsk) {
                if (str2 != null) {
                    zzdrp.zzf(20, str2);
                }
            }
        }
        if (this.zzhsl != null && this.zzhsl.length > 0) {
            for (String str3 : this.zzhsl) {
                if (str3 != null) {
                    zzdrp.zzf(21, str3);
                }
            }
        }
        super.zza(zzdrp);
    }

    /* access modifiers changed from: protected */
    public final int zzor() {
        int zzor = super.zzor();
        if (this.url != null) {
            zzor += zzdrp.zzg(1, this.url);
        }
        if (this.zzhrx != null) {
            zzor += zzdrp.zzg(2, this.zzhrx);
        }
        if (this.zzhsa != null && this.zzhsa.length > 0) {
            int i = zzor;
            for (zzdsp zzdsp : this.zzhsa) {
                if (zzdsp != null) {
                    i += zzdrp.zzb(4, (zzdrw) zzdsp);
                }
            }
            zzor = i;
        }
        if (this.zzhse != null && this.zzhse.length > 0) {
            int i2 = 0;
            int i3 = 0;
            for (String str : this.zzhse) {
                if (str != null) {
                    i3++;
                    i2 += zzdrp.zzgx(str);
                }
            }
            zzor = zzor + i2 + (i3 * 1);
        }
        if (this.zzhrv != null) {
            zzor += zzdrp.zzab(10, this.zzhrv.intValue());
        }
        if (this.zzhrz != null) {
            zzor += zzdrp.zzb(12, (zzdrw) this.zzhrz);
        }
        if (this.zzhsb != null) {
            zzor += zzdrp.zzg(13, this.zzhsb);
        }
        if (this.zzhsc != null) {
            zzor += zzdrp.zzb(14, (zzdrw) this.zzhsc);
        }
        if (this.zzhsj != null) {
            zzor += zzdrp.zzb(17, (zzdrw) this.zzhsj);
        }
        if (this.zzhsk != null && this.zzhsk.length > 0) {
            int i4 = 0;
            int i5 = 0;
            for (String str2 : this.zzhsk) {
                if (str2 != null) {
                    i5++;
                    i4 += zzdrp.zzgx(str2);
                }
            }
            zzor = zzor + i4 + (i5 * 2);
        }
        if (this.zzhsl == null || this.zzhsl.length <= 0) {
            return zzor;
        }
        int i6 = 0;
        int i7 = 0;
        for (String str3 : this.zzhsl) {
            if (str3 != null) {
                i7++;
                i6 += zzdrp.zzgx(str3);
            }
        }
        return zzor + i6 + (i7 * 2);
    }
}
