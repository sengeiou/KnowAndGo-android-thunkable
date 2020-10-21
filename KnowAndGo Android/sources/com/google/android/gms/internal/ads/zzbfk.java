package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

@zzard
final class zzbfk implements zzdsw {
    private final ByteBuffer zzaxl;

    zzbfk(ByteBuffer byteBuffer) {
        this.zzaxl = byteBuffer.duplicate();
    }

    public final void close() throws IOException {
    }

    public final int read(ByteBuffer byteBuffer) throws IOException {
        if (this.zzaxl.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.zzaxl.remaining());
        byte[] bArr = new byte[min];
        this.zzaxl.get(bArr);
        byteBuffer.put(bArr);
        return min;
    }

    public final long size() throws IOException {
        return (long) this.zzaxl.limit();
    }

    public final long position() throws IOException {
        return (long) this.zzaxl.position();
    }

    public final void zzff(long j) throws IOException {
        this.zzaxl.position((int) j);
    }

    public final ByteBuffer zzi(long j, long j2) throws IOException {
        int position = this.zzaxl.position();
        this.zzaxl.position((int) j);
        ByteBuffer slice = this.zzaxl.slice();
        slice.limit((int) j2);
        this.zzaxl.position(position);
        return slice;
    }
}
