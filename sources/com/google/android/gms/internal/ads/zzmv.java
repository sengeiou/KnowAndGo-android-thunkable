package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

final class zzmv implements zzlx {
    private int zzafu = -1;
    private int zzagi = 0;
    private ByteBuffer zzaws = zzavh;
    private int zzaxh = -1;
    private ByteBuffer zzaxl = zzavh;
    private boolean zzaxm;

    public final int zzhk() {
        return 2;
    }

    public final boolean zzb(int i, int i2, int i3) throws zzly {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new zzly(i, i2, i3);
        } else if (this.zzaxh == i && this.zzafu == i2 && this.zzagi == i3) {
            return false;
        } else {
            this.zzaxh = i;
            this.zzafu = i2;
            this.zzagi = i3;
            if (i3 != 2) {
                return true;
            }
            this.zzaxl = zzavh;
            return true;
        }
    }

    public final boolean isActive() {
        return (this.zzagi == 0 || this.zzagi == 2) ? false : true;
    }

    public final int zzhj() {
        return this.zzafu;
    }

    public final void zzi(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        int i3 = this.zzagi;
        if (i3 == Integer.MIN_VALUE) {
            i = (i2 / 3) << 1;
        } else if (i3 == 3) {
            i = i2 << 1;
        } else if (i3 == 1073741824) {
            i = i2 / 2;
        } else {
            throw new IllegalStateException();
        }
        if (this.zzaxl.capacity() < i) {
            this.zzaxl = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.zzaxl.clear();
        }
        int i4 = this.zzagi;
        if (i4 == Integer.MIN_VALUE) {
            while (position < limit) {
                this.zzaxl.put(byteBuffer.get(position + 1));
                this.zzaxl.put(byteBuffer.get(position + 2));
                position += 3;
            }
        } else if (i4 == 3) {
            while (position < limit) {
                this.zzaxl.put((byte) 0);
                this.zzaxl.put((byte) ((byteBuffer.get(position) & UByte.MAX_VALUE) + ByteCompanionObject.MIN_VALUE));
                position++;
            }
        } else if (i4 == 1073741824) {
            while (position < limit) {
                this.zzaxl.put(byteBuffer.get(position + 2));
                this.zzaxl.put(byteBuffer.get(position + 3));
                position += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
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
        this.zzaxh = -1;
        this.zzafu = -1;
        this.zzagi = 0;
    }
}
