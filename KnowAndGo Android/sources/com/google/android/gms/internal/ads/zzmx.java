package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class zzmx implements zzlx {
    private int zzafu = -1;
    private float zzauh = 1.0f;
    private float zzaui = 1.0f;
    private ByteBuffer zzaws = zzavh;
    private int zzaxh = -1;
    private ByteBuffer zzaxl = zzavh;
    private boolean zzaxm;
    private zzmw zzays;
    private ShortBuffer zzayt = this.zzaxl.asShortBuffer();
    private long zzayu;
    private long zzayv;

    public final int zzhk() {
        return 2;
    }

    public final float zzb(float f) {
        this.zzauh = zzsy.zza(f, 0.1f, 8.0f);
        return this.zzauh;
    }

    public final float zzc(float f) {
        this.zzaui = zzsy.zza(f, 0.1f, 8.0f);
        return f;
    }

    public final long zzhz() {
        return this.zzayu;
    }

    public final long zzia() {
        return this.zzayv;
    }

    public final boolean zzb(int i, int i2, int i3) throws zzly {
        if (i3 != 2) {
            throw new zzly(i, i2, i3);
        } else if (this.zzaxh == i && this.zzafu == i2) {
            return false;
        } else {
            this.zzaxh = i;
            this.zzafu = i2;
            return true;
        }
    }

    public final boolean isActive() {
        return Math.abs(this.zzauh - 1.0f) >= 0.01f || Math.abs(this.zzaui - 1.0f) >= 0.01f;
    }

    public final int zzhj() {
        return this.zzafu;
    }

    public final void zzi(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzayu += (long) remaining;
            this.zzays.zza(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int zzhx = (this.zzays.zzhx() * this.zzafu) << 1;
        if (zzhx > 0) {
            if (this.zzaxl.capacity() < zzhx) {
                this.zzaxl = ByteBuffer.allocateDirect(zzhx).order(ByteOrder.nativeOrder());
                this.zzayt = this.zzaxl.asShortBuffer();
            } else {
                this.zzaxl.clear();
                this.zzayt.clear();
            }
            this.zzays.zzb(this.zzayt);
            this.zzayv += (long) zzhx;
            this.zzaxl.limit(zzhx);
            this.zzaws = this.zzaxl;
        }
    }

    public final void zzhl() {
        this.zzays.zzhl();
        this.zzaxm = true;
    }

    public final ByteBuffer zzhm() {
        ByteBuffer byteBuffer = this.zzaws;
        this.zzaws = zzavh;
        return byteBuffer;
    }

    public final boolean zzdx() {
        if (this.zzaxm) {
            return this.zzays == null || this.zzays.zzhx() == 0;
        }
        return false;
    }

    public final void flush() {
        this.zzays = new zzmw(this.zzaxh, this.zzafu);
        this.zzays.setSpeed(this.zzauh);
        this.zzays.zza(this.zzaui);
        this.zzaws = zzavh;
        this.zzayu = 0;
        this.zzayv = 0;
        this.zzaxm = false;
    }

    public final void reset() {
        this.zzays = null;
        this.zzaxl = zzavh;
        this.zzayt = this.zzaxl.asShortBuffer();
        this.zzaws = zzavh;
        this.zzafu = -1;
        this.zzaxh = -1;
        this.zzayu = 0;
        this.zzayv = 0;
        this.zzaxm = false;
    }
}
