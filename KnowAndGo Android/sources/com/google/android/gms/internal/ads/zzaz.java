package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

final class zzaz extends ThreadLocal<ByteBuffer> {
    zzaz(zzay zzay) {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        return ByteBuffer.allocate(32);
    }
}
