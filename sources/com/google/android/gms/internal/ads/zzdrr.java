package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrr;
import java.io.IOException;

public class zzdrr<M extends zzdrr<M>> extends zzdrw {
    protected zzdrt zzhno;

    /* access modifiers changed from: protected */
    public int zzor() {
        if (this.zzhno != null) {
            for (int i = 0; i < this.zzhno.size(); i++) {
                this.zzhno.zzhf(i).zzor();
            }
        }
        return 0;
    }

    public void zza(zzdrp zzdrp) throws IOException {
        if (this.zzhno != null) {
            for (int i = 0; i < this.zzhno.size(); i++) {
                this.zzhno.zzhf(i).zza(zzdrp);
            }
        }
    }

    public final /* synthetic */ zzdrw zzbal() throws CloneNotSupportedException {
        return (zzdrr) clone();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzdrr zzdrr = (zzdrr) super.clone();
        zzdrv.zza(this, zzdrr);
        return zzdrr;
    }
}
