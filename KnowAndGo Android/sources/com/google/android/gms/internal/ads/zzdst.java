package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public abstract class zzdst extends zzdsr implements zzbd {
    private int flags;
    private int version;

    protected zzdst(String str) {
        super(str);
    }

    public final int getVersion() {
        if (!this.zzhti) {
            zzbbc();
        }
        return this.version;
    }

    /* access modifiers changed from: protected */
    public final long zzo(ByteBuffer byteBuffer) {
        this.version = zzbc.zza(byteBuffer.get());
        this.flags = (zzbc.zzb(byteBuffer) << 8) + 0 + zzbc.zza(byteBuffer.get());
        return 4;
    }
}
