package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class zzmq implements zzlx {
    private int zzafu = -1;
    private ByteBuffer zzaws = zzavh;
    private int zzaxh = -1;
    private int[] zzaxi;
    private boolean zzaxj;
    private int[] zzaxk;
    private ByteBuffer zzaxl = zzavh;
    private boolean zzaxm;

    public final int zzhk() {
        return 2;
    }

    public final void zzb(int[] iArr) {
        this.zzaxi = iArr;
    }

    public final boolean zzb(int i, int i2, int i3) throws zzly {
        boolean z = !Arrays.equals(this.zzaxi, this.zzaxk);
        this.zzaxk = this.zzaxi;
        if (this.zzaxk == null) {
            this.zzaxj = false;
            return z;
        } else if (i3 != 2) {
            throw new zzly(i, i2, i3);
        } else if (!z && this.zzaxh == i && this.zzafu == i2) {
            return false;
        } else {
            this.zzaxh = i;
            this.zzafu = i2;
            this.zzaxj = i2 != this.zzaxk.length;
            int i4 = 0;
            while (i4 < this.zzaxk.length) {
                int i5 = this.zzaxk[i4];
                if (i5 < i2) {
                    this.zzaxj = (i5 != i4) | this.zzaxj;
                    i4++;
                } else {
                    throw new zzly(i, i2, i3);
                }
            }
            return true;
        }
    }

    public final boolean isActive() {
        return this.zzaxj;
    }

    public final int zzhj() {
        return this.zzaxk == null ? this.zzafu : this.zzaxk.length;
    }

    public final void zzi(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.zzafu * 2)) * this.zzaxk.length) << 1;
        if (this.zzaxl.capacity() < length) {
            this.zzaxl = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.zzaxl.clear();
        }
        while (position < limit) {
            for (int i : this.zzaxk) {
                this.zzaxl.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.zzafu << 1;
        }
        byteBuffer.position(limit);
        this.zzaxl.flip();
        this.zzaws = this.zzaxl;
    }

    public final void zzhl() {
        this.zzaxm = true;
    }

    public final ByteBuffer zzhm() {
        ByteBuffer byteBuffer = this.zzaws;
        this.zzaws = zzavh;
        return byteBuffer;
    }

    public final boolean zzdx() {
        return this.zzaxm && this.zzaws == zzavh;
    }

    public final void flush() {
        this.zzaws = zzavh;
        this.zzaxm = false;
    }

    public final void reset() {
        flush();
        this.zzaxl = zzavh;
        this.zzafu = -1;
        this.zzaxh = -1;
        this.zzaxk = null;
        this.zzaxj = false;
    }
}
