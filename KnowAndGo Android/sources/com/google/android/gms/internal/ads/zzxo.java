package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzxo extends zzdrr<zzxo> {
    public Integer zzcfo = null;
    public Integer zzcfp = null;
    public Integer zzcfq = null;

    public zzxo() {
        this.zzhno = null;
        this.zzhnx = -1;
    }

    public final void zza(zzdrp zzdrp) throws IOException {
        if (this.zzcfo != null) {
            zzdrp.zzx(1, this.zzcfo.intValue());
        }
        if (this.zzcfp != null) {
            zzdrp.zzx(2, this.zzcfp.intValue());
        }
        if (this.zzcfq != null) {
            zzdrp.zzx(3, this.zzcfq.intValue());
        }
        super.zza(zzdrp);
    }

    /* access modifiers changed from: protected */
    public final int zzor() {
        int zzor = super.zzor();
        if (this.zzcfo != null) {
            zzor += zzdrp.zzab(1, this.zzcfo.intValue());
        }
        if (this.zzcfp != null) {
            zzor += zzdrp.zzab(2, this.zzcfp.intValue());
        }
        return this.zzcfq != null ? zzor + zzdrp.zzab(3, this.zzcfq.intValue()) : zzor;
    }
}
