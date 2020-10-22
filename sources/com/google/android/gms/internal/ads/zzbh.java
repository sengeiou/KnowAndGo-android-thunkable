package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzbh extends zzdsr {
    private ByteBuffer zzde;

    public zzbh(String str) {
        super(str);
    }

    public final void zzg(ByteBuffer byteBuffer) {
        this.zzde = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }
}
