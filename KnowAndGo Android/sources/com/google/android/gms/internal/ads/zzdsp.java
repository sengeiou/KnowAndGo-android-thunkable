package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzdsp extends zzdrr<zzdsp> {
    private static volatile zzdsp[] zzhsv;
    public String url = null;
    public Integer zzhsw = null;
    public zzdsm zzhsx = null;
    private zzdsn zzhsy = null;
    private Integer zzhsz = null;
    private int[] zzhta = zzdry.zzhjo;
    private String zzhtb = null;
    public Integer zzhtc = null;
    public String[] zzhtd = zzdry.zzhog;

    public static zzdsp[] zzbba() {
        if (zzhsv == null) {
            synchronized (zzdrv.zzhnw) {
                if (zzhsv == null) {
                    zzhsv = new zzdsp[0];
                }
            }
        }
        return zzhsv;
    }

    public zzdsp() {
        this.zzhno = null;
        this.zzhnx = -1;
    }

    public final void zza(zzdrp zzdrp) throws IOException {
        zzdrp.zzx(1, this.zzhsw.intValue());
        if (this.url != null) {
            zzdrp.zzf(2, this.url);
        }
        if (this.zzhsx != null) {
            zzdrp.zza(3, (zzdrw) this.zzhsx);
        }
        if (this.zzhta != null && this.zzhta.length > 0) {
            for (int zzx : this.zzhta) {
                zzdrp.zzx(6, zzx);
            }
        }
        if (this.zzhtc != null) {
            zzdrp.zzx(8, this.zzhtc.intValue());
        }
        if (this.zzhtd != null && this.zzhtd.length > 0) {
            for (String str : this.zzhtd) {
                if (str != null) {
                    zzdrp.zzf(9, str);
                }
            }
        }
        super.zza(zzdrp);
    }

    /* access modifiers changed from: protected */
    public final int zzor() {
        int zzor = super.zzor() + zzdrp.zzab(1, this.zzhsw.intValue());
        if (this.url != null) {
            zzor += zzdrp.zzg(2, this.url);
        }
        if (this.zzhsx != null) {
            zzor += zzdrp.zzb(3, (zzdrw) this.zzhsx);
        }
        if (this.zzhta != null && this.zzhta.length > 0) {
            int i = 0;
            for (int zzge : this.zzhta) {
                i += zzdrp.zzge(zzge);
            }
            zzor = zzor + i + (this.zzhta.length * 1);
        }
        if (this.zzhtc != null) {
            zzor += zzdrp.zzab(8, this.zzhtc.intValue());
        }
        if (this.zzhtd == null || this.zzhtd.length <= 0) {
            return zzor;
        }
        int i2 = 0;
        int i3 = 0;
        for (String str : this.zzhtd) {
            if (str != null) {
                i3++;
                i2 += zzdrp.zzgx(str);
            }
        }
        return zzor + i2 + (i3 * 1);
    }
}
